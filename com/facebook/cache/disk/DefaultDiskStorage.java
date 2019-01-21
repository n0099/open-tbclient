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
    private static final Class<?> iiR = DefaultDiskStorage.class;
    static final long iiS = TimeUnit.MINUTES.toMillis(30);
    private final File iiT;
    private final boolean iiU;
    private final File iiV;
    private final CacheErrorLogger iiW;
    private final com.facebook.common.time.a iiX;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.iiT = file;
        this.iiU = a(file, cacheErrorLogger);
        this.iiV = new File(this.iiT, yg(i));
        this.iiW = cacheErrorLogger;
        bTS();
        this.iiX = com.facebook.common.time.b.bVa();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, iiR, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, iiR, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String yg(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.iiU;
    }

    private void bTS() {
        boolean z = true;
        if (this.iiT.exists()) {
            if (this.iiV.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ad(this.iiT);
            }
        }
        if (z) {
            try {
                FileUtils.ae(this.iiV);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.iiW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, iiR, "version directory could not be created: " + this.iiV, null);
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

    File zp(String str) {
        return new File(zs(str));
    }

    private String zq(String str) {
        return this.iiV + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File zr(String str) {
        return new File(zq(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> iiY;

        private a() {
            this.iiY = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
        }

        @Override // com.facebook.common.file.b
        public void W(File file) {
            c U = DefaultDiskStorage.this.U(file);
            if (U != null && U.ijb == FileType.CONTENT) {
                this.iiY.add(new b(U.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.iiY);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean ije;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
            if (!this.ije && file.equals(DefaultDiskStorage.this.iiV)) {
                this.ije = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void W(File file) {
            if (!this.ije || !aa(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
            if (!DefaultDiskStorage.this.iiT.equals(file) && !this.ije) {
                file.delete();
            }
            if (this.ije && file.equals(DefaultDiskStorage.this.iiV)) {
                this.ije = false;
            }
        }

        private boolean aa(File file) {
            c U = DefaultDiskStorage.this.U(file);
            if (U == null) {
                return false;
            }
            if (U.ijb == FileType.TEMP) {
                return ab(file);
            }
            com.facebook.common.internal.g.checkState(U.ijb == FileType.CONTENT);
            return true;
        }

        private boolean ab(File file) {
            return file.lastModified() > DefaultDiskStorage.this.iiX.now() - DefaultDiskStorage.iiS;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void bTT() {
        com.facebook.common.file.a.a(this.iiT, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.ae(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.iiW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, iiR, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File zr = zr(cVar.resourceId);
        if (!zr.exists()) {
            i(zr, "insert");
        }
        try {
            return new d(str, cVar.Y(zr));
        } catch (IOException e2) {
            this.iiW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, iiR, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) {
        File zp = zp(str);
        if (zp.exists()) {
            zp.setLastModified(this.iiX.now());
            return com.facebook.a.b.S(zp);
        }
        return null;
    }

    private String zs(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.zt(zq(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) {
        return ag(str, false);
    }

    private boolean ag(String str, boolean z) {
        File zp = zp(str);
        boolean exists = zp.exists();
        if (z && exists) {
            zp.setLastModified(this.iiX.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return T(((b) aVar).bTW().getFile());
    }

    private long T(File file) {
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
    public List<c.a> bTU() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.iiV, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b ija;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.ija = com.facebook.a.b.S(file);
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
                this.timestamp = this.ija.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b bTW() {
            return this.ija;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.ija.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c U(File file) {
        c Z = c.Z(file);
        if (Z == null) {
            return null;
        }
        if (!zr(Z.resourceId).equals(file.getParentFile())) {
            Z = null;
        }
        return Z;
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
        public final FileType ijb;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.ijb = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.ijb + "(" + this.resourceId + ")";
        }

        public String zt(String str) {
            return str + File.separator + this.resourceId + this.ijb.extension;
        }

        public File Y(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c Z(File file) {
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
        private final String ijc;
        final File ijd;

        public d(String str, File file) {
            this.ijc = str;
            this.ijd = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.ijd);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.ijd.length() != count) {
                        throw new IncompleteFileException(count, this.ijd.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.iiW.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.iiR, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a am(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File zp = DefaultDiskStorage.this.zp(this.ijc);
            try {
                FileUtils.rename(this.ijd, zp);
                if (zp.exists()) {
                    zp.setLastModified(DefaultDiskStorage.this.iiX.now());
                }
                return com.facebook.a.b.S(zp);
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
                DefaultDiskStorage.this.iiW.a(cacheErrorCategory, DefaultDiskStorage.iiR, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean bTX() {
            return !this.ijd.exists() || this.ijd.delete();
        }
    }
}
