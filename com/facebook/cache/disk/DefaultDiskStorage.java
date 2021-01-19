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
/* loaded from: classes5.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> pnn = DefaultDiskStorage.class;
    static final long pno = TimeUnit.MINUTES.toMillis(30);
    private final File pnp;
    private final boolean pnq;
    private final File pnr;
    private final CacheErrorLogger pns;
    private final com.facebook.common.time.a pnt;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.pnp = file;
        this.pnq = a(file, cacheErrorLogger);
        this.pnr = new File(this.pnp, Ox(i));
        this.pns = cacheErrorLogger;
        epw();
        this.pnt = com.facebook.common.time.c.eqB();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pnn, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pnn, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String Ox(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.pnq;
    }

    private void epw() {
        boolean z = true;
        if (this.pnp.exists()) {
            if (this.pnr.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ay(this.pnp);
            }
        }
        if (z) {
            try {
                FileUtils.az(this.pnr);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.pns.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pnn, "version directory could not be created: " + this.pnr, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File XZ(String str) {
        return new File(getFilename(str));
    }

    private String Ya(String str) {
        return this.pnr + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Yb(String str) {
        return new File(Ya(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void aq(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ar(File file) {
            c ap = DefaultDiskStorage.this.ap(file);
            if (ap != null && ap.type == ".cnt") {
                this.result.add(new b(ap.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void as(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes5.dex */
    private class e implements com.facebook.common.file.b {
        private boolean pnx;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void aq(File file) {
            if (!this.pnx && file.equals(DefaultDiskStorage.this.pnr)) {
                this.pnx = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ar(File file) {
            if (!this.pnx || !av(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void as(File file) {
            if (!DefaultDiskStorage.this.pnp.equals(file) && !this.pnx) {
                file.delete();
            }
            if (this.pnx && file.equals(DefaultDiskStorage.this.pnr)) {
                this.pnx = false;
            }
        }

        private boolean av(File file) {
            c ap = DefaultDiskStorage.this.ap(file);
            if (ap == null) {
                return false;
            }
            if (ap.type == ".tmp") {
                return aw(file);
            }
            com.facebook.common.internal.g.checkState(ap.type == ".cnt");
            return true;
        }

        private boolean aw(File file) {
            return file.lastModified() > DefaultDiskStorage.this.pnt.now() - DefaultDiskStorage.pno;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void epx() {
        com.facebook.common.file.a.a(this.pnp, new e());
    }

    private void m(File file, String str) throws IOException {
        try {
            FileUtils.az(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.pns.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pnn, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b F(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Yb = Yb(cVar.resourceId);
        if (!Yb.exists()) {
            m(Yb, "insert");
        }
        try {
            return new d(str, cVar.at(Yb));
        } catch (IOException e2) {
            this.pns.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, pnn, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a G(String str, Object obj) {
        File XZ = XZ(str);
        if (XZ.exists()) {
            XZ.setLastModified(this.pnt.now());
            return com.facebook.a.b.an(XZ);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Yf(Ya(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean H(String str, Object obj) {
        return bn(str, false);
    }

    private boolean bn(String str, boolean z) {
        File XZ = XZ(str);
        boolean exists = XZ.exists();
        if (z && exists) {
            XZ.setLastModified(this.pnt.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ao(((b) aVar).epA().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Yc(String str) {
        return ao(XZ(str));
    }

    private long ao(File file) {
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
    public List<c.a> epy() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.pnr, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes5.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b pnv;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.pnv = com.facebook.a.b.an(file);
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
                this.timestamp = this.pnv.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b epA() {
            return this.pnv;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.pnv.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ap(File file) {
        c au = c.au(file);
        if (au == null) {
            return null;
        }
        if (!Yb(au.resourceId).equals(file.getParentFile())) {
            au = null;
        }
        return au;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Yd(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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

        public String Yf(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File at(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c au(File file) {
            String Yd;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Yd = DefaultDiskStorage.Yd(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Yd.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Yd, substring);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    class d implements c.b {
        private final String mzf;
        final File pnw;

        public d(String str, File file) {
            this.mzf = str;
            this.pnw = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.pnw);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.pnw.length() != count) {
                        throw new IncompleteFileException(count, this.pnw.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.pns.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.pnn, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aZ(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File XZ = DefaultDiskStorage.this.XZ(this.mzf);
            try {
                FileUtils.rename(this.pnw, XZ);
                if (XZ.exists()) {
                    XZ.setLastModified(DefaultDiskStorage.this.pnt.now());
                }
                return com.facebook.a.b.an(XZ);
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
                DefaultDiskStorage.this.pns.a(cacheErrorCategory, DefaultDiskStorage.pnn, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean epB() {
            return !this.pnw.exists() || this.pnw.delete();
        }
    }
}
