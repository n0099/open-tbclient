package com.facebook.cache.disk;

import android.os.Environment;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> ihJ = DefaultDiskStorage.class;
    static final long ihK = TimeUnit.MINUTES.toMillis(30);
    private final File ihL;
    private final boolean ihM;
    private final File ihN;
    private final CacheErrorLogger ihO;
    private final com.facebook.common.time.a ihP;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.ihL = file;
        this.ihM = a(file, cacheErrorLogger);
        this.ihN = new File(this.ihL, ye(i));
        this.ihO = cacheErrorLogger;
        bTk();
        this.ihP = com.facebook.common.time.b.bUs();
    }

    private static boolean a(File file, CacheErrorLogger cacheErrorLogger) {
        String str = null;
        try {
            File externalStorageDirectory = Environment.getExternalStorageDirectory();
            if (externalStorageDirectory == null) {
                return false;
            }
            String file2 = externalStorageDirectory.toString();
            try {
                str = file.getCanonicalPath();
                if (!str.contains(file2)) {
                    return false;
                }
                return true;
            } catch (IOException e2) {
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, ihJ, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, ihJ, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String ye(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.ihM;
    }

    private void bTk() {
        boolean z = true;
        if (this.ihL.exists()) {
            if (this.ihN.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ac(this.ihL);
            }
        }
        if (z) {
            try {
                FileUtils.ad(this.ihN);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.ihO.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, ihJ, "version directory could not be created: " + this.ihN, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File yZ(String str) {
        return new File(zc(str));
    }

    private String za(String str) {
        return this.ihN + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File zb(String str) {
        return new File(za(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> ihQ;

        private a() {
            this.ihQ = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
            c T = DefaultDiskStorage.this.T(file);
            if (T != null && T.ihT == FileType.CONTENT) {
                this.ihQ.add(new b(T.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void W(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.ihQ);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean ihW;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
            if (!this.ihW && file.equals(DefaultDiskStorage.this.ihN)) {
                this.ihW = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
            if (!this.ihW || !Z(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void W(File file) {
            if (!DefaultDiskStorage.this.ihL.equals(file) && !this.ihW) {
                file.delete();
            }
            if (this.ihW && file.equals(DefaultDiskStorage.this.ihN)) {
                this.ihW = false;
            }
        }

        private boolean Z(File file) {
            c T = DefaultDiskStorage.this.T(file);
            if (T == null) {
                return false;
            }
            if (T.ihT == FileType.TEMP) {
                return aa(file);
            }
            com.facebook.common.internal.g.checkState(T.ihT == FileType.CONTENT);
            return true;
        }

        private boolean aa(File file) {
            return file.lastModified() > DefaultDiskStorage.this.ihP.now() - DefaultDiskStorage.ihK;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void bTl() {
        com.facebook.common.file.a.a(this.ihL, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.ad(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.ihO.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, ihJ, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File zb = zb(cVar.resourceId);
        if (!zb.exists()) {
            i(zb, "insert");
        }
        try {
            return new d(str, cVar.X(zb));
        } catch (IOException e2) {
            this.ihO.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, ihJ, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) {
        File yZ = yZ(str);
        if (yZ.exists()) {
            yZ.setLastModified(this.ihP.now());
            return com.facebook.a.b.R(yZ);
        }
        return null;
    }

    private String zc(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.zd(za(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) {
        return ah(str, false);
    }

    private boolean ah(String str, boolean z) {
        File yZ = yZ(str);
        boolean exists = yZ.exists();
        if (z && exists) {
            yZ.setLastModified(this.ihP.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return S(((b) aVar).bTo().getFile());
    }

    private long S(File file) {
        if (!file.exists()) {
            return 0L;
        }
        long length = file.length();
        if (!file.delete()) {
            return -1L;
        }
        return length;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.facebook.cache.disk.c
    /* renamed from: getEntries */
    public List<c.a> bTm() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.ihN, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b ihS;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.ihS = com.facebook.a.b.R(file);
            this.size = -1L;
            this.timestamp = -1L;
        }

        @Override // com.facebook.cache.disk.c.a
        public String getId() {
            return this.id;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getTimestamp() {
            if (this.timestamp < 0) {
                this.timestamp = this.ihS.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b bTo() {
            return this.ihS;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.ihS.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c T(File file) {
        c Y = c.Y(file);
        if (Y == null) {
            return null;
        }
        if (!zb(Y.resourceId).equals(file.getParentFile())) {
            Y = null;
        }
        return Y;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum FileType {
        CONTENT(".cnt"),
        TEMP(".tmp");
        
        public final String extension;

        FileType(String str) {
            this.extension = str;
        }

        public static FileType fromExtension(String str) {
            if (".cnt".equals(str)) {
                return CONTENT;
            }
            if (".tmp".equals(str)) {
                return TEMP;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        public final FileType ihT;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.ihT = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.ihT + "(" + this.resourceId + ")";
        }

        public String zd(String str) {
            return str + File.separator + this.resourceId + this.ihT.extension;
        }

        public File X(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c Y(File file) {
            FileType fromExtension;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (fromExtension = FileType.fromExtension(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (fromExtension.equals(FileType.TEMP)) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(fromExtension, substring);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class d implements c.b {
        private final String ihU;
        final File ihV;

        public d(String str, File file) {
            this.ihU = str;
            this.ihV = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.ihV);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.ihV.length() != count) {
                        throw new IncompleteFileException(count, this.ihV.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.ihO.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.ihJ, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a am(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File yZ = DefaultDiskStorage.this.yZ(this.ihU);
            try {
                FileUtils.rename(this.ihV, yZ);
                if (yZ.exists()) {
                    yZ.setLastModified(DefaultDiskStorage.this.ihP.now());
                }
                return com.facebook.a.b.R(yZ);
            } catch (FileUtils.RenameException e) {
                Throwable cause = e.getCause();
                if (cause == null) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                } else if (cause instanceof FileUtils.ParentDirNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_PARENT_NOT_FOUND;
                } else if (cause instanceof FileNotFoundException) {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_TEMPFILE_NOT_FOUND;
                } else {
                    cacheErrorCategory = CacheErrorLogger.CacheErrorCategory.WRITE_RENAME_FILE_OTHER;
                }
                DefaultDiskStorage.this.ihO.a(cacheErrorCategory, DefaultDiskStorage.ihJ, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean bTp() {
            return !this.ihV.exists() || this.ihV.delete();
        }
    }
}
