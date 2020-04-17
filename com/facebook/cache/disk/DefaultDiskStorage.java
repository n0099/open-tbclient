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
/* loaded from: classes13.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> lQm = DefaultDiskStorage.class;
    static final long lQn = TimeUnit.MINUTES.toMillis(30);
    private final File lQo;
    private final boolean lQp;
    private final File lQq;
    private final CacheErrorLogger lQr;
    private final com.facebook.common.time.a lQs;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.lQo = file;
        this.lQp = a(file, cacheErrorLogger);
        this.lQq = new File(this.lQo, FY(i));
        this.lQr = cacheErrorLogger;
        dmo();
        this.lQs = com.facebook.common.time.c.dnv();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, lQm, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, lQm, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String FY(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.lQp;
    }

    private void dmo() {
        boolean z = true;
        if (this.lQo.exists()) {
            if (this.lQq.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.af(this.lQo);
            }
        }
        if (z) {
            try {
                FileUtils.ag(this.lQq);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.lQr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lQm, "version directory could not be created: " + this.lQq, null);
            }
        }
    }

    /* loaded from: classes13.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File NP(String str) {
        return new File(getFilename(str));
    }

    private String NQ(String str) {
        return this.lQq + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File NR(String str) {
        return new File(NQ(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
        }

        @Override // com.facebook.common.file.b
        public void Y(File file) {
            c W = DefaultDiskStorage.this.W(file);
            if (W != null && W.type == ".cnt") {
                this.result.add(new b(W.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes13.dex */
    private class e implements com.facebook.common.file.b {
        private boolean lQw;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
            if (!this.lQw && file.equals(DefaultDiskStorage.this.lQq)) {
                this.lQw = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void Y(File file) {
            if (!this.lQw || !ac(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
            if (!DefaultDiskStorage.this.lQo.equals(file) && !this.lQw) {
                file.delete();
            }
            if (this.lQw && file.equals(DefaultDiskStorage.this.lQq)) {
                this.lQw = false;
            }
        }

        private boolean ac(File file) {
            c W = DefaultDiskStorage.this.W(file);
            if (W == null) {
                return false;
            }
            if (W.type == ".tmp") {
                return ad(file);
            }
            com.facebook.common.internal.g.checkState(W.type == ".cnt");
            return true;
        }

        private boolean ad(File file) {
            return file.lastModified() > DefaultDiskStorage.this.lQs.now() - DefaultDiskStorage.lQn;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void dmp() {
        com.facebook.common.file.a.a(this.lQo, new e());
    }

    private void h(File file, String str) throws IOException {
        try {
            FileUtils.ag(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.lQr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lQm, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b z(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File NR = NR(cVar.resourceId);
        if (!NR.exists()) {
            h(NR, "insert");
        }
        try {
            return new d(str, cVar.aa(NR));
        } catch (IOException e2) {
            this.lQr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, lQm, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a A(String str, Object obj) {
        File NP = NP(str);
        if (NP.exists()) {
            NP.setLastModified(this.lQs.now());
            return com.facebook.a.b.U(NP);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.NV(NQ(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean B(String str, Object obj) {
        return aJ(str, false);
    }

    private boolean aJ(String str, boolean z) {
        File NP = NP(str);
        boolean exists = NP.exists();
        if (z && exists) {
            NP.setLastModified(this.lQs.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return V(((b) aVar).dms().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long NS(String str) {
        return V(NP(str));
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
    public List<c.a> dmq() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.lQq, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes13.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b lQu;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.lQu = com.facebook.a.b.U(file);
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
                this.timestamp = this.lQu.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dms() {
            return this.lQu;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.lQu.size();
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
        if (!NR(ab.resourceId).equals(file.getParentFile())) {
            ab = null;
        }
        return ab;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String NT(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
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

        public String NV(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File aa(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ab(File file) {
            String NT;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (NT = DefaultDiskStorage.NT(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (NT.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(NT, substring);
            }
            return null;
        }
    }

    /* loaded from: classes13.dex */
    class d implements c.b {
        private final String kiv;
        final File lQv;

        public d(String str, File file) {
            this.kiv = str;
            this.lQv = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.lQv);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.lQv.length() != count) {
                        throw new IncompleteFileException(count, this.lQv.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.lQr.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.lQm, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aG(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File NP = DefaultDiskStorage.this.NP(this.kiv);
            try {
                FileUtils.rename(this.lQv, NP);
                if (NP.exists()) {
                    NP.setLastModified(DefaultDiskStorage.this.lQs.now());
                }
                return com.facebook.a.b.U(NP);
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
                DefaultDiskStorage.this.lQr.a(cacheErrorCategory, DefaultDiskStorage.lQm, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dmt() {
            return !this.lQv.exists() || this.lQv.delete();
        }
    }
}
