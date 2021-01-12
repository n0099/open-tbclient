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
    private static final Class<?> pnm = DefaultDiskStorage.class;
    static final long pnn = TimeUnit.MINUTES.toMillis(30);
    private final File pno;
    private final boolean pnp;
    private final File pnq;
    private final CacheErrorLogger pnr;
    private final com.facebook.common.time.a pns;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.pno = file;
        this.pnp = a(file, cacheErrorLogger);
        this.pnq = new File(this.pno, Ox(i));
        this.pnr = cacheErrorLogger;
        epw();
        this.pns = com.facebook.common.time.c.eqB();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pnm, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pnm, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String Ox(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.pnp;
    }

    private void epw() {
        boolean z = true;
        if (this.pno.exists()) {
            if (this.pnq.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ay(this.pno);
            }
        }
        if (z) {
            try {
                FileUtils.az(this.pnq);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.pnr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pnm, "version directory could not be created: " + this.pnq, null);
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

    File XY(String str) {
        return new File(getFilename(str));
    }

    private String XZ(String str) {
        return this.pnq + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Ya(String str) {
        return new File(XZ(str));
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
        private boolean pnw;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void aq(File file) {
            if (!this.pnw && file.equals(DefaultDiskStorage.this.pnq)) {
                this.pnw = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ar(File file) {
            if (!this.pnw || !av(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void as(File file) {
            if (!DefaultDiskStorage.this.pno.equals(file) && !this.pnw) {
                file.delete();
            }
            if (this.pnw && file.equals(DefaultDiskStorage.this.pnq)) {
                this.pnw = false;
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
            return file.lastModified() > DefaultDiskStorage.this.pns.now() - DefaultDiskStorage.pnn;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void epx() {
        com.facebook.common.file.a.a(this.pno, new e());
    }

    private void m(File file, String str) throws IOException {
        try {
            FileUtils.az(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.pnr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pnm, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b F(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Ya = Ya(cVar.resourceId);
        if (!Ya.exists()) {
            m(Ya, "insert");
        }
        try {
            return new d(str, cVar.at(Ya));
        } catch (IOException e2) {
            this.pnr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, pnm, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a G(String str, Object obj) {
        File XY = XY(str);
        if (XY.exists()) {
            XY.setLastModified(this.pns.now());
            return com.facebook.a.b.an(XY);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Ye(XZ(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean H(String str, Object obj) {
        return bn(str, false);
    }

    private boolean bn(String str, boolean z) {
        File XY = XY(str);
        boolean exists = XY.exists();
        if (z && exists) {
            XY.setLastModified(this.pns.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ao(((b) aVar).epA().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Yb(String str) {
        return ao(XY(str));
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
        com.facebook.common.file.a.a(this.pnq, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes5.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b pnu;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.pnu = com.facebook.a.b.an(file);
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
                this.timestamp = this.pnu.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b epA() {
            return this.pnu;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.pnu.size();
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
        if (!Ya(au.resourceId).equals(file.getParentFile())) {
            au = null;
        }
        return au;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Yc(String str) {
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

        public String Ye(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File at(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c au(File file) {
            String Yc;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Yc = DefaultDiskStorage.Yc(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Yc.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Yc, substring);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    class d implements c.b {
        private final String mzf;
        final File pnv;

        public d(String str, File file) {
            this.mzf = str;
            this.pnv = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.pnv);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.pnv.length() != count) {
                        throw new IncompleteFileException(count, this.pnv.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.pnr.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.pnm, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aZ(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File XY = DefaultDiskStorage.this.XY(this.mzf);
            try {
                FileUtils.rename(this.pnv, XY);
                if (XY.exists()) {
                    XY.setLastModified(DefaultDiskStorage.this.pns.now());
                }
                return com.facebook.a.b.an(XY);
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
                DefaultDiskStorage.this.pnr.a(cacheErrorCategory, DefaultDiskStorage.pnm, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean epB() {
            return !this.pnv.exists() || this.pnv.delete();
        }
    }
}
