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
    private static final Class<?> hVC = DefaultDiskStorage.class;
    static final long hVD = TimeUnit.MINUTES.toMillis(30);
    private final File hVE;
    private final boolean hVF;
    private final File hVG;
    private final CacheErrorLogger hVH;
    private final com.facebook.common.time.a hVI;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.hVE = file;
        this.hVF = a(file, cacheErrorLogger);
        this.hVG = new File(this.hVE, xb(i));
        this.hVH = cacheErrorLogger;
        bQT();
        this.hVI = com.facebook.common.time.b.bSb();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, hVC, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, hVC, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String xb(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.hVF;
    }

    private void bQT() {
        boolean z = true;
        if (this.hVE.exists()) {
            if (this.hVG.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ab(this.hVE);
            }
        }
        if (z) {
            try {
                FileUtils.ac(this.hVG);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.hVH.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, hVC, "version directory could not be created: " + this.hVG, null);
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

    File yo(String str) {
        return new File(yr(str));
    }

    private String yp(String str) {
        return this.hVG + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File yq(String str) {
        return new File(yp(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> hVJ;

        private a() {
            this.hVJ = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void T(File file) {
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
            c S = DefaultDiskStorage.this.S(file);
            if (S != null && S.hVM == FileType.CONTENT) {
                this.hVJ.add(new b(S.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.hVJ);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean hVP;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void T(File file) {
            if (!this.hVP && file.equals(DefaultDiskStorage.this.hVG)) {
                this.hVP = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
            if (!this.hVP || !Y(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
            if (!DefaultDiskStorage.this.hVE.equals(file) && !this.hVP) {
                file.delete();
            }
            if (this.hVP && file.equals(DefaultDiskStorage.this.hVG)) {
                this.hVP = false;
            }
        }

        private boolean Y(File file) {
            c S = DefaultDiskStorage.this.S(file);
            if (S == null) {
                return false;
            }
            if (S.hVM == FileType.TEMP) {
                return Z(file);
            }
            com.facebook.common.internal.g.checkState(S.hVM == FileType.CONTENT);
            return true;
        }

        private boolean Z(File file) {
            return file.lastModified() > DefaultDiskStorage.this.hVI.now() - DefaultDiskStorage.hVD;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void bQU() {
        com.facebook.common.file.a.a(this.hVE, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.ac(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.hVH.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, hVC, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File yq = yq(cVar.resourceId);
        if (!yq.exists()) {
            i(yq, "insert");
        }
        try {
            return new d(str, cVar.W(yq));
        } catch (IOException e2) {
            this.hVH.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, hVC, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) {
        File yo = yo(str);
        if (yo.exists()) {
            yo.setLastModified(this.hVI.now());
            return com.facebook.a.b.Q(yo);
        }
        return null;
    }

    private String yr(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.ys(yp(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) {
        return af(str, false);
    }

    private boolean af(String str, boolean z) {
        File yo = yo(str);
        boolean exists = yo.exists();
        if (z && exists) {
            yo.setLastModified(this.hVI.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return R(((b) aVar).bQX().getFile());
    }

    private long R(File file) {
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
    public List<c.a> bQV() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.hVG, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final com.facebook.a.b hVL;
        private final String id;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.hVL = com.facebook.a.b.Q(file);
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
                this.timestamp = this.hVL.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b bQX() {
            return this.hVL;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.hVL.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c S(File file) {
        c X = c.X(file);
        if (X == null) {
            return null;
        }
        if (!yq(X.resourceId).equals(file.getParentFile())) {
            X = null;
        }
        return X;
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
        public final FileType hVM;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.hVM = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.hVM + "(" + this.resourceId + ")";
        }

        public String ys(String str) {
            return str + File.separator + this.resourceId + this.hVM.extension;
        }

        public File W(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c X(File file) {
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
        private final String hVN;
        final File hVO;

        public d(String str, File file) {
            this.hVN = str;
            this.hVO = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.hVO);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.hVO.length() != count) {
                        throw new IncompleteFileException(count, this.hVO.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.hVH.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.hVC, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a am(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File yo = DefaultDiskStorage.this.yo(this.hVN);
            try {
                FileUtils.rename(this.hVO, yo);
                if (yo.exists()) {
                    yo.setLastModified(DefaultDiskStorage.this.hVI.now());
                }
                return com.facebook.a.b.Q(yo);
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
                DefaultDiskStorage.this.hVH.a(cacheErrorCategory, DefaultDiskStorage.hVC, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean bQY() {
            return !this.hVO.exists() || this.hVO.delete();
        }
    }
}
