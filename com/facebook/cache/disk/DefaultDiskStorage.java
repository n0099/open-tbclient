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
    private static final Class<?> hXm = DefaultDiskStorage.class;
    static final long hXn = TimeUnit.MINUTES.toMillis(30);
    private final File hXo;
    private final boolean hXp;
    private final File hXq;
    private final CacheErrorLogger hXr;
    private final com.facebook.common.time.a hXs;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.hXo = file;
        this.hXp = a(file, cacheErrorLogger);
        this.hXq = new File(this.hXo, xu(i));
        this.hXr = cacheErrorLogger;
        bQo();
        this.hXs = com.facebook.common.time.b.bRw();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, hXm, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, hXm, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String xu(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.hXp;
    }

    private void bQo() {
        boolean z = true;
        if (this.hXo.exists()) {
            if (this.hXq.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ab(this.hXo);
            }
        }
        if (z) {
            try {
                FileUtils.ac(this.hXq);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.hXr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, hXm, "version directory could not be created: " + this.hXq, null);
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

    File yt(String str) {
        return new File(yw(str));
    }

    private String yu(String str) {
        return this.hXq + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File yv(String str) {
        return new File(yu(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> hXt;

        private a() {
            this.hXt = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void T(File file) {
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
            c S = DefaultDiskStorage.this.S(file);
            if (S != null && S.hXw == FileType.CONTENT) {
                this.hXt.add(new b(S.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.hXt);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean hXz;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void T(File file) {
            if (!this.hXz && file.equals(DefaultDiskStorage.this.hXq)) {
                this.hXz = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void U(File file) {
            if (!this.hXz || !Y(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void V(File file) {
            if (!DefaultDiskStorage.this.hXo.equals(file) && !this.hXz) {
                file.delete();
            }
            if (this.hXz && file.equals(DefaultDiskStorage.this.hXq)) {
                this.hXz = false;
            }
        }

        private boolean Y(File file) {
            c S = DefaultDiskStorage.this.S(file);
            if (S == null) {
                return false;
            }
            if (S.hXw == FileType.TEMP) {
                return Z(file);
            }
            com.facebook.common.internal.g.checkState(S.hXw == FileType.CONTENT);
            return true;
        }

        private boolean Z(File file) {
            return file.lastModified() > DefaultDiskStorage.this.hXs.now() - DefaultDiskStorage.hXn;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void bQp() {
        com.facebook.common.file.a.a(this.hXo, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.ac(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.hXr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, hXm, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File yv = yv(cVar.resourceId);
        if (!yv.exists()) {
            i(yv, "insert");
        }
        try {
            return new d(str, cVar.W(yv));
        } catch (IOException e2) {
            this.hXr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, hXm, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) {
        File yt = yt(str);
        if (yt.exists()) {
            yt.setLastModified(this.hXs.now());
            return com.facebook.a.b.Q(yt);
        }
        return null;
    }

    private String yw(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.yx(yu(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) {
        return af(str, false);
    }

    private boolean af(String str, boolean z) {
        File yt = yt(str);
        boolean exists = yt.exists();
        if (z && exists) {
            yt.setLastModified(this.hXs.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return R(((b) aVar).bQs().getFile());
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
    public List<c.a> bQq() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.hXq, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final com.facebook.a.b hXv;
        private final String id;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.hXv = com.facebook.a.b.Q(file);
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
                this.timestamp = this.hXv.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b bQs() {
            return this.hXv;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.hXv.size();
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
        if (!yv(X.resourceId).equals(file.getParentFile())) {
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
        public final FileType hXw;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.hXw = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.hXw + "(" + this.resourceId + ")";
        }

        public String yx(String str) {
            return str + File.separator + this.resourceId + this.hXw.extension;
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
        private final String hXx;
        final File hXy;

        public d(String str, File file) {
            this.hXx = str;
            this.hXy = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.hXy);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.hXy.length() != count) {
                        throw new IncompleteFileException(count, this.hXy.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.hXr.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.hXm, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a al(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File yt = DefaultDiskStorage.this.yt(this.hXx);
            try {
                FileUtils.rename(this.hXy, yt);
                if (yt.exists()) {
                    yt.setLastModified(DefaultDiskStorage.this.hXs.now());
                }
                return com.facebook.a.b.Q(yt);
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
                DefaultDiskStorage.this.hXr.a(cacheErrorCategory, DefaultDiskStorage.hXm, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean bQt() {
            return !this.hXy.exists() || this.hXy.delete();
        }
    }
}
