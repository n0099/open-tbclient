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
    private static final Class<?> hVB = DefaultDiskStorage.class;
    static final long hVC = TimeUnit.MINUTES.toMillis(30);
    private final File hVD;
    private final boolean hVE;
    private final File hVF;
    private final CacheErrorLogger hVG;
    private final com.facebook.common.time.a hVH;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.hVD = file;
        this.hVE = a(file, cacheErrorLogger);
        this.hVF = new File(this.hVD, xb(i));
        this.hVG = cacheErrorLogger;
        bQT();
        this.hVH = com.facebook.common.time.b.bSb();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, hVB, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, hVB, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String xb(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.hVE;
    }

    private void bQT() {
        boolean z = true;
        if (this.hVD.exists()) {
            if (this.hVF.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ab(this.hVD);
            }
        }
        if (z) {
            try {
                FileUtils.ac(this.hVF);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.hVG.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, hVB, "version directory could not be created: " + this.hVF, null);
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
        return this.hVF + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File yq(String str) {
        return new File(yp(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> hVI;

        private a() {
            this.hVI = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void T(File file) {
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
            c S = DefaultDiskStorage.this.S(file);
            if (S != null && S.hVL == FileType.CONTENT) {
                this.hVI.add(new b(S.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.hVI);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean hVO;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void T(File file) {
            if (!this.hVO && file.equals(DefaultDiskStorage.this.hVF)) {
                this.hVO = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
            if (!this.hVO || !Y(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
            if (!DefaultDiskStorage.this.hVD.equals(file) && !this.hVO) {
                file.delete();
            }
            if (this.hVO && file.equals(DefaultDiskStorage.this.hVF)) {
                this.hVO = false;
            }
        }

        private boolean Y(File file) {
            c S = DefaultDiskStorage.this.S(file);
            if (S == null) {
                return false;
            }
            if (S.hVL == FileType.TEMP) {
                return Z(file);
            }
            com.facebook.common.internal.g.checkState(S.hVL == FileType.CONTENT);
            return true;
        }

        private boolean Z(File file) {
            return file.lastModified() > DefaultDiskStorage.this.hVH.now() - DefaultDiskStorage.hVC;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void bQU() {
        com.facebook.common.file.a.a(this.hVD, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.ac(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.hVG.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, hVB, str, e2);
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
            this.hVG.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, hVB, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) {
        File yo = yo(str);
        if (yo.exists()) {
            yo.setLastModified(this.hVH.now());
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
            yo.setLastModified(this.hVH.now());
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
        com.facebook.common.file.a.a(this.hVF, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final com.facebook.a.b hVK;
        private final String id;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.hVK = com.facebook.a.b.Q(file);
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
                this.timestamp = this.hVK.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b bQX() {
            return this.hVK;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.hVK.size();
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
        public final FileType hVL;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.hVL = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.hVL + "(" + this.resourceId + ")";
        }

        public String ys(String str) {
            return str + File.separator + this.resourceId + this.hVL.extension;
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
        private final String hVM;
        final File hVN;

        public d(String str, File file) {
            this.hVM = str;
            this.hVN = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.hVN);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.hVN.length() != count) {
                        throw new IncompleteFileException(count, this.hVN.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.hVG.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.hVB, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a am(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File yo = DefaultDiskStorage.this.yo(this.hVM);
            try {
                FileUtils.rename(this.hVN, yo);
                if (yo.exists()) {
                    yo.setLastModified(DefaultDiskStorage.this.hVH.now());
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
                DefaultDiskStorage.this.hVG.a(cacheErrorCategory, DefaultDiskStorage.hVB, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean bQY() {
            return !this.hVN.exists() || this.hVN.delete();
        }
    }
}
