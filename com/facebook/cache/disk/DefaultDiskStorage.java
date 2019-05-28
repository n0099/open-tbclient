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
    private static final Class<?> jQS = DefaultDiskStorage.class;
    static final long jQT = TimeUnit.MINUTES.toMillis(30);
    private final File jQU;
    private final boolean jQV;
    private final File jQW;
    private final CacheErrorLogger jQX;
    private final com.facebook.common.time.a jQY;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jQU = file;
        this.jQV = a(file, cacheErrorLogger);
        this.jQW = new File(this.jQU, CN(i));
        this.jQX = cacheErrorLogger;
        cAV();
        this.jQY = com.facebook.common.time.b.cCc();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jQS, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jQS, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String CN(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jQV;
    }

    private void cAV() {
        boolean z = true;
        if (this.jQU.exists()) {
            if (this.jQW.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.af(this.jQU);
            }
        }
        if (z) {
            try {
                FileUtils.ag(this.jQW);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jQX.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jQS, "version directory could not be created: " + this.jQW, null);
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

    File GD(String str) {
        return new File(GG(str));
    }

    private String GE(String str) {
        return this.jQW + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File GF(String str) {
        return new File(GE(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> bfT;

        private a() {
            this.bfT = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
        }

        @Override // com.facebook.common.file.b
        public void Y(File file) {
            c W = DefaultDiskStorage.this.W(file);
            if (W != null && W.jRb == FileType.CONTENT) {
                this.bfT.add(new b(W.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.bfT);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean jRe;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
            if (!this.jRe && file.equals(DefaultDiskStorage.this.jQW)) {
                this.jRe = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void Y(File file) {
            if (!this.jRe || !ac(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
            if (!DefaultDiskStorage.this.jQU.equals(file) && !this.jRe) {
                file.delete();
            }
            if (this.jRe && file.equals(DefaultDiskStorage.this.jQW)) {
                this.jRe = false;
            }
        }

        private boolean ac(File file) {
            c W = DefaultDiskStorage.this.W(file);
            if (W == null) {
                return false;
            }
            if (W.jRb == FileType.TEMP) {
                return ad(file);
            }
            com.facebook.common.internal.g.checkState(W.jRb == FileType.CONTENT);
            return true;
        }

        private boolean ad(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jQY.now() - DefaultDiskStorage.jQT;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void cAW() {
        com.facebook.common.file.a.a(this.jQU, new e());
    }

    private void h(File file, String str) throws IOException {
        try {
            FileUtils.ag(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jQX.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jQS, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b q(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File GF = GF(cVar.resourceId);
        if (!GF.exists()) {
            h(GF, "insert");
        }
        try {
            return new d(str, cVar.aa(GF));
        } catch (IOException e2) {
            this.jQX.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jQS, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) {
        File GD = GD(str);
        if (GD.exists()) {
            GD.setLastModified(this.jQY.now());
            return com.facebook.a.b.U(GD);
        }
        return null;
    }

    private String GG(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.GH(GE(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean s(String str, Object obj) {
        return az(str, false);
    }

    private boolean az(String str, boolean z) {
        File GD = GD(str);
        boolean exists = GD.exists();
        if (z && exists) {
            GD.setLastModified(this.jQY.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return V(((b) aVar).cAZ().getFile());
    }

    private long V(File file) {
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
    public List<c.a> cAX() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.jQW, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jRa;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jRa = com.facebook.a.b.U(file);
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
                this.timestamp = this.jRa.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cAZ() {
            return this.jRa;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jRa.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c W(File file) {
        c ab = c.ab(file);
        if (ab == null) {
            return null;
        }
        if (!GF(ab.resourceId).equals(file.getParentFile())) {
            ab = null;
        }
        return ab;
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
        public final FileType jRb;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jRb = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jRb + "(" + this.resourceId + ")";
        }

        public String GH(String str) {
            return str + File.separator + this.resourceId + this.jRb.extension;
        }

        public File aa(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ab(File file) {
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
        private final String jRc;
        final File jRd;

        public d(String str, File file) {
            this.jRc = str;
            this.jRd = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jRd);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jRd.length() != count) {
                        throw new IncompleteFileException(count, this.jRd.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jQX.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jQS, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aA(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File GD = DefaultDiskStorage.this.GD(this.jRc);
            try {
                FileUtils.rename(this.jRd, GD);
                if (GD.exists()) {
                    GD.setLastModified(DefaultDiskStorage.this.jQY.now());
                }
                return com.facebook.a.b.U(GD);
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
                DefaultDiskStorage.this.jQX.a(cacheErrorCategory, DefaultDiskStorage.jQS, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean cBa() {
            return !this.jRd.exists() || this.jRd.delete();
        }
    }
}
