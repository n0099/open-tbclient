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
/* loaded from: classes12.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> lGm = DefaultDiskStorage.class;
    static final long lGn = TimeUnit.MINUTES.toMillis(30);
    private final File lGo;
    private final boolean lGp;
    private final File lGq;
    private final CacheErrorLogger lGr;
    private final com.facebook.common.time.a lGs;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.lGo = file;
        this.lGp = a(file, cacheErrorLogger);
        this.lGq = new File(this.lGo, Hm(i));
        this.lGr = cacheErrorLogger;
        diG();
        this.lGs = com.facebook.common.time.c.djM();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, lGm, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, lGm, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String Hm(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.lGp;
    }

    private void diG() {
        boolean z = true;
        if (this.lGo.exists()) {
            if (this.lGq.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ai(this.lGo);
            }
        }
        if (z) {
            try {
                FileUtils.aj(this.lGq);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.lGr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lGm, "version directory could not be created: " + this.lGq, null);
            }
        }
    }

    /* loaded from: classes12.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File Ov(String str) {
        return new File(getFilename(str));
    }

    private String Ow(String str) {
        return this.lGq + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Ox(String str) {
        return new File(Ow(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
        }

        @Override // com.facebook.common.file.b
        public void aa(File file) {
            c Y = DefaultDiskStorage.this.Y(file);
            if (Y != null && Y.type == ".cnt") {
                this.result.add(new b(Y.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void ab(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes12.dex */
    private class e implements com.facebook.common.file.b {
        private boolean lGw;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
            if (!this.lGw && file.equals(DefaultDiskStorage.this.lGq)) {
                this.lGw = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void aa(File file) {
            if (!this.lGw || !ae(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ab(File file) {
            if (!DefaultDiskStorage.this.lGo.equals(file) && !this.lGw) {
                file.delete();
            }
            if (this.lGw && file.equals(DefaultDiskStorage.this.lGq)) {
                this.lGw = false;
            }
        }

        private boolean ae(File file) {
            c Y = DefaultDiskStorage.this.Y(file);
            if (Y == null) {
                return false;
            }
            if (Y.type == ".tmp") {
                return af(file);
            }
            com.facebook.common.internal.g.checkState(Y.type == ".cnt");
            return true;
        }

        private boolean af(File file) {
            return file.lastModified() > DefaultDiskStorage.this.lGs.now() - DefaultDiskStorage.lGn;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void diH() {
        com.facebook.common.file.a.a(this.lGo, new e());
    }

    private void f(File file, String str) throws IOException {
        try {
            FileUtils.aj(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.lGr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lGm, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Ox = Ox(cVar.resourceId);
        if (!Ox.exists()) {
            f(Ox, "insert");
        }
        try {
            return new d(str, cVar.ac(Ox));
        } catch (IOException e2) {
            this.lGr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, lGm, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) {
        File Ov = Ov(str);
        if (Ov.exists()) {
            Ov.setLastModified(this.lGs.now());
            return com.facebook.a.b.W(Ov);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.OA(Ow(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) {
        return aJ(str, false);
    }

    private boolean aJ(String str, boolean z) {
        File Ov = Ov(str);
        boolean exists = Ov.exists();
        if (z && exists) {
            Ov.setLastModified(this.lGs.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return X(((b) aVar).diK().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Oy(String str) {
        return X(Ov(str));
    }

    private long X(File file) {
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
    public List<c.a> diI() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.lGq, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes12.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b lGu;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.lGu = com.facebook.a.b.W(file);
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
                this.timestamp = this.lGu.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b diK() {
            return this.lGu;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.lGu.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Y(File file) {
        c ad = c.ad(file);
        if (ad == null) {
            return null;
        }
        if (!Ox(ad.resourceId).equals(file.getParentFile())) {
            ad = null;
        }
        return ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Oz(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public static class c {
        public final String resourceId;
        public final String type;

        private c(String str, String str2) {
            this.type = str;
            this.resourceId = str2;
        }

        public String toString() {
            return this.type + "(" + this.resourceId + ")";
        }

        public String OA(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File ac(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ad(File file) {
            String Oz;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Oz = DefaultDiskStorage.Oz(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Oz.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Oz, substring);
            }
            return null;
        }
    }

    /* loaded from: classes12.dex */
    class d implements c.b {
        private final String jvQ;
        final File lGv;

        public d(String str, File file) {
            this.jvQ = str;
            this.lGv = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.lGv);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.lGv.length() != count) {
                        throw new IncompleteFileException(count, this.lGv.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.lGr.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.lGm, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aO(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Ov = DefaultDiskStorage.this.Ov(this.jvQ);
            try {
                FileUtils.rename(this.lGv, Ov);
                if (Ov.exists()) {
                    Ov.setLastModified(DefaultDiskStorage.this.lGs.now());
                }
                return com.facebook.a.b.W(Ov);
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
                DefaultDiskStorage.this.lGr.a(cacheErrorCategory, DefaultDiskStorage.lGm, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean diL() {
            return !this.lGv.exists() || this.lGv.delete();
        }
    }
}
