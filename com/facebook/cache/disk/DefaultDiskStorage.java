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
    private static final Class<?> pAh = DefaultDiskStorage.class;
    static final long pAi = TimeUnit.MINUTES.toMillis(30);
    private final File pAj;
    private final boolean pAk;
    private final File pAl;
    private final CacheErrorLogger pAm;
    private final com.facebook.common.time.a pAn;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.pAj = file;
        this.pAk = a(file, cacheErrorLogger);
        this.pAl = new File(this.pAj, OX(i));
        this.pAm = cacheErrorLogger;
        esg();
        this.pAn = com.facebook.common.time.c.etl();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pAh, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pAh, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String OX(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.pAk;
    }

    private void esg() {
        boolean z = true;
        if (this.pAj.exists()) {
            if (this.pAl.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.aw(this.pAj);
            }
        }
        if (z) {
            try {
                FileUtils.ax(this.pAl);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.pAm.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pAh, "version directory could not be created: " + this.pAl, null);
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

    File Zs(String str) {
        return new File(getFilename(str));
    }

    private String Zt(String str) {
        return this.pAl + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Zu(String str) {
        return new File(Zt(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ao(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ap(File file) {
            c an = DefaultDiskStorage.this.an(file);
            if (an != null && an.type == ".cnt") {
                this.result.add(new b(an.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void aq(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes5.dex */
    private class e implements com.facebook.common.file.b {
        private boolean pAr;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ao(File file) {
            if (!this.pAr && file.equals(DefaultDiskStorage.this.pAl)) {
                this.pAr = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ap(File file) {
            if (!this.pAr || !at(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void aq(File file) {
            if (!DefaultDiskStorage.this.pAj.equals(file) && !this.pAr) {
                file.delete();
            }
            if (this.pAr && file.equals(DefaultDiskStorage.this.pAl)) {
                this.pAr = false;
            }
        }

        private boolean at(File file) {
            c an = DefaultDiskStorage.this.an(file);
            if (an == null) {
                return false;
            }
            if (an.type == ".tmp") {
                return au(file);
            }
            com.facebook.common.internal.g.checkState(an.type == ".cnt");
            return true;
        }

        private boolean au(File file) {
            return file.lastModified() > DefaultDiskStorage.this.pAn.now() - DefaultDiskStorage.pAi;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void esh() {
        com.facebook.common.file.a.a(this.pAj, new e());
    }

    private void l(File file, String str) throws IOException {
        try {
            FileUtils.ax(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.pAm.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pAh, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b D(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Zu = Zu(cVar.resourceId);
        if (!Zu.exists()) {
            l(Zu, "insert");
        }
        try {
            return new d(str, cVar.ar(Zu));
        } catch (IOException e2) {
            this.pAm.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, pAh, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a E(String str, Object obj) {
        File Zs = Zs(str);
        if (Zs.exists()) {
            Zs.setLastModified(this.pAn.now());
            return com.facebook.a.b.al(Zs);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Zy(Zt(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean F(String str, Object obj) {
        return bn(str, false);
    }

    private boolean bn(String str, boolean z) {
        File Zs = Zs(str);
        boolean exists = Zs.exists();
        if (z && exists) {
            Zs.setLastModified(this.pAn.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return am(((b) aVar).esk().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Zv(String str) {
        return am(Zs(str));
    }

    private long am(File file) {
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
    public List<c.a> esi() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.pAl, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes5.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b pAp;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.pAp = com.facebook.a.b.al(file);
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
                this.timestamp = this.pAp.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b esk() {
            return this.pAp;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.pAp.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c an(File file) {
        c as = c.as(file);
        if (as == null) {
            return null;
        }
        if (!Zu(as.resourceId).equals(file.getParentFile())) {
            as = null;
        }
        return as;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Zw(String str) {
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

        public String Zy(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File ar(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c as(File file) {
            String Zw;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Zw = DefaultDiskStorage.Zw(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Zw.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Zw, substring);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    class d implements c.b {
        private final String mKH;
        final File pAq;

        public d(String str, File file) {
            this.mKH = str;
            this.pAq = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.pAq);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.pAq.length() != count) {
                        throw new IncompleteFileException(count, this.pAq.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.pAm.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.pAh, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a bb(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Zs = DefaultDiskStorage.this.Zs(this.mKH);
            try {
                FileUtils.rename(this.pAq, Zs);
                if (Zs.exists()) {
                    Zs.setLastModified(DefaultDiskStorage.this.pAn.now());
                }
                return com.facebook.a.b.al(Zs);
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
                DefaultDiskStorage.this.pAm.a(cacheErrorCategory, DefaultDiskStorage.pAh, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean esl() {
            return !this.pAq.exists() || this.pAq.delete();
        }
    }
}
