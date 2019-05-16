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
    private static final Class<?> jQR = DefaultDiskStorage.class;
    static final long jQS = TimeUnit.MINUTES.toMillis(30);
    private final File jQT;
    private final boolean jQU;
    private final File jQV;
    private final CacheErrorLogger jQW;
    private final com.facebook.common.time.a jQX;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jQT = file;
        this.jQU = a(file, cacheErrorLogger);
        this.jQV = new File(this.jQT, CN(i));
        this.jQW = cacheErrorLogger;
        cAT();
        this.jQX = com.facebook.common.time.b.cCa();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jQR, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jQR, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String CN(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jQU;
    }

    private void cAT() {
        boolean z = true;
        if (this.jQT.exists()) {
            if (this.jQV.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.af(this.jQT);
            }
        }
        if (z) {
            try {
                FileUtils.ag(this.jQV);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jQW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jQR, "version directory could not be created: " + this.jQV, null);
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
        return this.jQV + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
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
            if (W != null && W.jRa == FileType.CONTENT) {
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
        private boolean jRd;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
            if (!this.jRd && file.equals(DefaultDiskStorage.this.jQV)) {
                this.jRd = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void Y(File file) {
            if (!this.jRd || !ac(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
            if (!DefaultDiskStorage.this.jQT.equals(file) && !this.jRd) {
                file.delete();
            }
            if (this.jRd && file.equals(DefaultDiskStorage.this.jQV)) {
                this.jRd = false;
            }
        }

        private boolean ac(File file) {
            c W = DefaultDiskStorage.this.W(file);
            if (W == null) {
                return false;
            }
            if (W.jRa == FileType.TEMP) {
                return ad(file);
            }
            com.facebook.common.internal.g.checkState(W.jRa == FileType.CONTENT);
            return true;
        }

        private boolean ad(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jQX.now() - DefaultDiskStorage.jQS;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void cAU() {
        com.facebook.common.file.a.a(this.jQT, new e());
    }

    private void h(File file, String str) throws IOException {
        try {
            FileUtils.ag(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jQW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jQR, str, e2);
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
            this.jQW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jQR, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) {
        File GD = GD(str);
        if (GD.exists()) {
            GD.setLastModified(this.jQX.now());
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
            GD.setLastModified(this.jQX.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return V(((b) aVar).cAX().getFile());
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
    public List<c.a> cAV() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.jQV, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jQZ;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jQZ = com.facebook.a.b.U(file);
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
                this.timestamp = this.jQZ.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cAX() {
            return this.jQZ;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jQZ.size();
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
        public final FileType jRa;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jRa = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jRa + "(" + this.resourceId + ")";
        }

        public String GH(String str) {
            return str + File.separator + this.resourceId + this.jRa.extension;
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
        private final String jRb;
        final File jRc;

        public d(String str, File file) {
            this.jRb = str;
            this.jRc = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jRc);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jRc.length() != count) {
                        throw new IncompleteFileException(count, this.jRc.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jQW.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jQR, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aA(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File GD = DefaultDiskStorage.this.GD(this.jRb);
            try {
                FileUtils.rename(this.jRc, GD);
                if (GD.exists()) {
                    GD.setLastModified(DefaultDiskStorage.this.jQX.now());
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
                DefaultDiskStorage.this.jQW.a(cacheErrorCategory, DefaultDiskStorage.jQR, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean cAY() {
            return !this.jRc.exists() || this.jRc.delete();
        }
    }
}
