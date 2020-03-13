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
    private static final Class<?> lHl = DefaultDiskStorage.class;
    static final long lHm = TimeUnit.MINUTES.toMillis(30);
    private final File lHn;
    private final boolean lHo;
    private final File lHp;
    private final CacheErrorLogger lHq;
    private final com.facebook.common.time.a lHr;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.lHn = file;
        this.lHo = a(file, cacheErrorLogger);
        this.lHp = new File(this.lHn, Hr(i));
        this.lHq = cacheErrorLogger;
        djY();
        this.lHr = com.facebook.common.time.c.dle();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, lHl, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, lHl, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String Hr(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.lHo;
    }

    private void djY() {
        boolean z = true;
        if (this.lHn.exists()) {
            if (this.lHp.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ak(this.lHn);
            }
        }
        if (z) {
            try {
                FileUtils.al(this.lHp);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.lHq.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lHl, "version directory could not be created: " + this.lHp, null);
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

    File OI(String str) {
        return new File(getFilename(str));
    }

    private String OJ(String str) {
        return this.lHp + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File OK(String str) {
        return new File(OJ(str));
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
        private boolean lHv;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ab(File file) {
            if (!this.lHv && file.equals(DefaultDiskStorage.this.lHp)) {
                this.lHv = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ac(File file) {
            if (!this.lHv || !ag(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            if (!DefaultDiskStorage.this.lHn.equals(file) && !this.lHv) {
                file.delete();
            }
            if (this.lHv && file.equals(DefaultDiskStorage.this.lHp)) {
                this.lHv = false;
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
            return file.lastModified() > DefaultDiskStorage.this.lHr.now() - DefaultDiskStorage.lHm;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void djZ() {
        com.facebook.common.file.a.a(this.lHn, new e());
    }

    private void f(File file, String str) throws IOException {
        try {
            FileUtils.al(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.lHq.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lHl, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File OK = OK(cVar.resourceId);
        if (!OK.exists()) {
            f(OK, "insert");
        }
        try {
            return new d(str, cVar.ae(OK));
        } catch (IOException e2) {
            this.lHq.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, lHl, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) {
        File OI = OI(str);
        if (OI.exists()) {
            OI.setLastModified(this.lHr.now());
            return com.facebook.a.b.Y(OI);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.OO(OJ(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) {
        return aJ(str, false);
    }

    private boolean aJ(String str, boolean z) {
        File OI = OI(str);
        boolean exists = OI.exists();
        if (z && exists) {
            OI.setLastModified(this.lHr.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return Z(((b) aVar).dkc().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long OL(String str) {
        return Z(OI(str));
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
    public List<c.a> dka() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.lHp, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes13.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b lHt;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.lHt = com.facebook.a.b.Y(file);
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
                this.timestamp = this.lHt.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dkc() {
            return this.lHt;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.lHt.size();
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
        if (!OK(af.resourceId).equals(file.getParentFile())) {
            af = null;
        }
        return af;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String OM(String str) {
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

        public String OO(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File ae(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c af(File file) {
            String OM;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (OM = DefaultDiskStorage.OM(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (OM.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(OM, substring);
            }
            return null;
        }
    }

    /* loaded from: classes13.dex */
    class d implements c.b {
        private final String jwZ;
        final File lHu;

        public d(String str, File file) {
            this.jwZ = str;
            this.lHu = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.lHu);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.lHu.length() != count) {
                        throw new IncompleteFileException(count, this.lHu.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.lHq.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.lHl, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aQ(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File OI = DefaultDiskStorage.this.OI(this.jwZ);
            try {
                FileUtils.rename(this.lHu, OI);
                if (OI.exists()) {
                    OI.setLastModified(DefaultDiskStorage.this.lHr.now());
                }
                return com.facebook.a.b.Y(OI);
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
                DefaultDiskStorage.this.lHq.a(cacheErrorCategory, DefaultDiskStorage.lHl, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dkd() {
            return !this.lHu.exists() || this.lHu.delete();
        }
    }
}
