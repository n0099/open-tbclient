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
    private final File ieB;
    private final boolean ieC;
    private final File ieD;
    private final CacheErrorLogger ieE;
    private final com.facebook.common.time.a ieF;
    private static final Class<?> iez = DefaultDiskStorage.class;
    static final long ieA = TimeUnit.MINUTES.toMillis(30);

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.ieB = file;
        this.ieC = a(file, cacheErrorLogger);
        this.ieD = new File(this.ieB, xR(i));
        this.ieE = cacheErrorLogger;
        bSt();
        this.ieF = com.facebook.common.time.b.bTB();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, iez, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, iez, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String xR(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.ieC;
    }

    private void bSt() {
        boolean z = true;
        if (this.ieB.exists()) {
            if (this.ieD.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ac(this.ieB);
            }
        }
        if (z) {
            try {
                FileUtils.ad(this.ieD);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.ieE.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, iez, "version directory could not be created: " + this.ieD, null);
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

    File yW(String str) {
        return new File(yZ(str));
    }

    private String yX(String str) {
        return this.ieD + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File yY(String str) {
        return new File(yX(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> ieG;

        private a() {
            this.ieG = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
            c T = DefaultDiskStorage.this.T(file);
            if (T != null && T.ieJ == FileType.CONTENT) {
                this.ieG.add(new b(T.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void W(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.ieG);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean ieM;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
            if (!this.ieM && file.equals(DefaultDiskStorage.this.ieD)) {
                this.ieM = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
            if (!this.ieM || !Z(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void W(File file) {
            if (!DefaultDiskStorage.this.ieB.equals(file) && !this.ieM) {
                file.delete();
            }
            if (this.ieM && file.equals(DefaultDiskStorage.this.ieD)) {
                this.ieM = false;
            }
        }

        private boolean Z(File file) {
            c T = DefaultDiskStorage.this.T(file);
            if (T == null) {
                return false;
            }
            if (T.ieJ == FileType.TEMP) {
                return aa(file);
            }
            com.facebook.common.internal.g.checkState(T.ieJ == FileType.CONTENT);
            return true;
        }

        private boolean aa(File file) {
            return file.lastModified() > DefaultDiskStorage.this.ieF.now() - DefaultDiskStorage.ieA;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void bSu() {
        com.facebook.common.file.a.a(this.ieB, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.ad(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.ieE.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, iez, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File yY = yY(cVar.resourceId);
        if (!yY.exists()) {
            i(yY, "insert");
        }
        try {
            return new d(str, cVar.X(yY));
        } catch (IOException e2) {
            this.ieE.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, iez, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) {
        File yW = yW(str);
        if (yW.exists()) {
            yW.setLastModified(this.ieF.now());
            return com.facebook.a.b.R(yW);
        }
        return null;
    }

    private String yZ(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.za(yX(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) {
        return ah(str, false);
    }

    private boolean ah(String str, boolean z) {
        File yW = yW(str);
        boolean exists = yW.exists();
        if (z && exists) {
            yW.setLastModified(this.ieF.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return S(((b) aVar).bSx().getFile());
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
    public List<c.a> bSv() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.ieD, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b ieI;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.ieI = com.facebook.a.b.R(file);
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
                this.timestamp = this.ieI.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b bSx() {
            return this.ieI;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.ieI.size();
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
        if (!yY(Y.resourceId).equals(file.getParentFile())) {
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
        public final FileType ieJ;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.ieJ = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.ieJ + "(" + this.resourceId + ")";
        }

        public String za(String str) {
            return str + File.separator + this.resourceId + this.ieJ.extension;
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
        private final String ieK;
        final File ieL;

        public d(String str, File file) {
            this.ieK = str;
            this.ieL = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.ieL);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.ieL.length() != count) {
                        throw new IncompleteFileException(count, this.ieL.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.ieE.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.iez, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a am(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File yW = DefaultDiskStorage.this.yW(this.ieK);
            try {
                FileUtils.rename(this.ieL, yW);
                if (yW.exists()) {
                    yW.setLastModified(DefaultDiskStorage.this.ieF.now());
                }
                return com.facebook.a.b.R(yW);
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
                DefaultDiskStorage.this.ieE.a(cacheErrorCategory, DefaultDiskStorage.iez, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean bSy() {
            return !this.ieL.exists() || this.ieL.delete();
        }
    }
}
