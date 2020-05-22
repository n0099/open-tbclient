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
    private static final Class<?> mki = DefaultDiskStorage.class;
    static final long mkj = TimeUnit.MINUTES.toMillis(30);
    private final File mkk;
    private final boolean mkl;
    private final File mkm;
    private final CacheErrorLogger mkn;
    private final com.facebook.common.time.a mko;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.mkk = file;
        this.mkl = a(file, cacheErrorLogger);
        this.mkm = new File(this.mkk, GK(i));
        this.mkn = cacheErrorLogger;
        dtF();
        this.mko = com.facebook.common.time.c.duL();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, mki, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, mki, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String GK(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.mkl;
    }

    private void dtF() {
        boolean z = true;
        if (this.mkk.exists()) {
            if (this.mkm.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.aj(this.mkk);
            }
        }
        if (z) {
            try {
                FileUtils.ak(this.mkm);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.mkn.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mki, "version directory could not be created: " + this.mkm, null);
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

    File PG(String str) {
        return new File(getFilename(str));
    }

    private String PH(String str) {
        return this.mkm + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File PI(String str) {
        return new File(PH(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ab(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ac(File file) {
            c aa = DefaultDiskStorage.this.aa(file);
            if (aa != null && aa.type == ".cnt") {
                this.result.add(new b(aa.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes13.dex */
    private class e implements com.facebook.common.file.b {
        private boolean mks;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ab(File file) {
            if (!this.mks && file.equals(DefaultDiskStorage.this.mkm)) {
                this.mks = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ac(File file) {
            if (!this.mks || !ag(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            if (!DefaultDiskStorage.this.mkk.equals(file) && !this.mks) {
                file.delete();
            }
            if (this.mks && file.equals(DefaultDiskStorage.this.mkm)) {
                this.mks = false;
            }
        }

        private boolean ag(File file) {
            c aa = DefaultDiskStorage.this.aa(file);
            if (aa == null) {
                return false;
            }
            if (aa.type == ".tmp") {
                return ah(file);
            }
            com.facebook.common.internal.g.checkState(aa.type == ".cnt");
            return true;
        }

        private boolean ah(File file) {
            return file.lastModified() > DefaultDiskStorage.this.mko.now() - DefaultDiskStorage.mkj;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void dtG() {
        com.facebook.common.file.a.a(this.mkk, new e());
    }

    private void h(File file, String str) throws IOException {
        try {
            FileUtils.ak(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.mkn.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mki, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File PI = PI(cVar.resourceId);
        if (!PI.exists()) {
            h(PI, "insert");
        }
        try {
            return new d(str, cVar.ae(PI));
        } catch (IOException e2) {
            this.mkn.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, mki, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) {
        File PG = PG(str);
        if (PG.exists()) {
            PG.setLastModified(this.mko.now());
            return com.facebook.a.b.Y(PG);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.PM(PH(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) {
        return aW(str, false);
    }

    private boolean aW(String str, boolean z) {
        File PG = PG(str);
        boolean exists = PG.exists();
        if (z && exists) {
            PG.setLastModified(this.mko.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return Z(((b) aVar).dtJ().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long PJ(String str) {
        return Z(PG(str));
    }

    private long Z(File file) {
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
    public List<c.a> dtH() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.mkm, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes13.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b mkq;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.mkq = com.facebook.a.b.Y(file);
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
                this.timestamp = this.mkq.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dtJ() {
            return this.mkq;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.mkq.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aa(File file) {
        c af = c.af(file);
        if (af == null) {
            return null;
        }
        if (!PI(af.resourceId).equals(file.getParentFile())) {
            af = null;
        }
        return af;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String PK(String str) {
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

        public String PM(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File ae(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c af(File file) {
            String PK;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (PK = DefaultDiskStorage.PK(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (PK.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(PK, substring);
            }
            return null;
        }
    }

    /* loaded from: classes13.dex */
    class d implements c.b {
        private final String kAt;
        final File mkr;

        public d(String str, File file) {
            this.kAt = str;
            this.mkr = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mkr);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.mkr.length() != count) {
                        throw new IncompleteFileException(count, this.mkr.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.mkn.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.mki, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aL(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File PG = DefaultDiskStorage.this.PG(this.kAt);
            try {
                FileUtils.rename(this.mkr, PG);
                if (PG.exists()) {
                    PG.setLastModified(DefaultDiskStorage.this.mko.now());
                }
                return com.facebook.a.b.Y(PG);
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
                DefaultDiskStorage.this.mkn.a(cacheErrorCategory, DefaultDiskStorage.mki, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dtK() {
            return !this.mkr.exists() || this.mkr.delete();
        }
    }
}
