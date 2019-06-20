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
    private static final Class<?> jQV = DefaultDiskStorage.class;
    static final long jQW = TimeUnit.MINUTES.toMillis(30);
    private final File jQX;
    private final boolean jQY;
    private final File jQZ;
    private final CacheErrorLogger jRa;
    private final com.facebook.common.time.a jRb;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jQX = file;
        this.jQY = a(file, cacheErrorLogger);
        this.jQZ = new File(this.jQX, CN(i));
        this.jRa = cacheErrorLogger;
        cAU();
        this.jRb = com.facebook.common.time.b.cCb();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jQV, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jQV, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String CN(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jQY;
    }

    private void cAU() {
        boolean z = true;
        if (this.jQX.exists()) {
            if (this.jQZ.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.af(this.jQX);
            }
        }
        if (z) {
            try {
                FileUtils.ag(this.jQZ);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jRa.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jQV, "version directory could not be created: " + this.jQZ, null);
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

    File GF(String str) {
        return new File(GI(str));
    }

    private String GG(String str) {
        return this.jQZ + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File GH(String str) {
        return new File(GG(str));
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
            if (W != null && W.jRe == FileType.CONTENT) {
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
        private boolean jRh;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
            if (!this.jRh && file.equals(DefaultDiskStorage.this.jQZ)) {
                this.jRh = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void Y(File file) {
            if (!this.jRh || !ac(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
            if (!DefaultDiskStorage.this.jQX.equals(file) && !this.jRh) {
                file.delete();
            }
            if (this.jRh && file.equals(DefaultDiskStorage.this.jQZ)) {
                this.jRh = false;
            }
        }

        private boolean ac(File file) {
            c W = DefaultDiskStorage.this.W(file);
            if (W == null) {
                return false;
            }
            if (W.jRe == FileType.TEMP) {
                return ad(file);
            }
            com.facebook.common.internal.g.checkState(W.jRe == FileType.CONTENT);
            return true;
        }

        private boolean ad(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jRb.now() - DefaultDiskStorage.jQW;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void cAV() {
        com.facebook.common.file.a.a(this.jQX, new e());
    }

    private void h(File file, String str) throws IOException {
        try {
            FileUtils.ag(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jRa.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jQV, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b q(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File GH = GH(cVar.resourceId);
        if (!GH.exists()) {
            h(GH, "insert");
        }
        try {
            return new d(str, cVar.aa(GH));
        } catch (IOException e2) {
            this.jRa.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jQV, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) {
        File GF = GF(str);
        if (GF.exists()) {
            GF.setLastModified(this.jRb.now());
            return com.facebook.a.b.U(GF);
        }
        return null;
    }

    private String GI(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.GJ(GG(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean s(String str, Object obj) {
        return az(str, false);
    }

    private boolean az(String str, boolean z) {
        File GF = GF(str);
        boolean exists = GF.exists();
        if (z && exists) {
            GF.setLastModified(this.jRb.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return V(((b) aVar).cAY().getFile());
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
    public List<c.a> cAW() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.jQZ, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jRd;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jRd = com.facebook.a.b.U(file);
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
                this.timestamp = this.jRd.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cAY() {
            return this.jRd;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jRd.size();
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
        if (!GH(ab.resourceId).equals(file.getParentFile())) {
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
        public final FileType jRe;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jRe = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jRe + "(" + this.resourceId + ")";
        }

        public String GJ(String str) {
            return str + File.separator + this.resourceId + this.jRe.extension;
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
        private final String jRf;
        final File jRg;

        public d(String str, File file) {
            this.jRf = str;
            this.jRg = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jRg);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jRg.length() != count) {
                        throw new IncompleteFileException(count, this.jRg.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jRa.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jQV, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aA(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File GF = DefaultDiskStorage.this.GF(this.jRf);
            try {
                FileUtils.rename(this.jRg, GF);
                if (GF.exists()) {
                    GF.setLastModified(DefaultDiskStorage.this.jRb.now());
                }
                return com.facebook.a.b.U(GF);
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
                DefaultDiskStorage.this.jRa.a(cacheErrorCategory, DefaultDiskStorage.jQV, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean cAZ() {
            return !this.jRg.exists() || this.jRg.delete();
        }
    }
}
