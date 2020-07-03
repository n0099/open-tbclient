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
    private static final Class<?> mHo = DefaultDiskStorage.class;
    static final long mHp = TimeUnit.MINUTES.toMillis(30);
    private final File mHq;
    private final boolean mHr;
    private final File mHs;
    private final CacheErrorLogger mHt;
    private final com.facebook.common.time.a mHu;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.mHq = file;
        this.mHr = a(file, cacheErrorLogger);
        this.mHs = new File(this.mHq, HT(i));
        this.mHt = cacheErrorLogger;
        dyw();
        this.mHu = com.facebook.common.time.c.dzC();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, mHo, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, mHo, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String HT(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.mHr;
    }

    private void dyw() {
        boolean z = true;
        if (this.mHq.exists()) {
            if (this.mHs.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ak(this.mHq);
            }
        }
        if (z) {
            try {
                FileUtils.al(this.mHs);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.mHt.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mHo, "version directory could not be created: " + this.mHs, null);
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

    File Qt(String str) {
        return new File(getFilename(str));
    }

    private String Qu(String str) {
        return this.mHs + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Qv(String str) {
        return new File(Qu(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes13.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ac(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            c ab = DefaultDiskStorage.this.ab(file);
            if (ab != null && ab.type == ".cnt") {
                this.result.add(new b(ab.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes13.dex */
    private class e implements com.facebook.common.file.b {
        private boolean mHy;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ac(File file) {
            if (!this.mHy && file.equals(DefaultDiskStorage.this.mHs)) {
                this.mHy = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            if (!this.mHy || !ah(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            if (!DefaultDiskStorage.this.mHq.equals(file) && !this.mHy) {
                file.delete();
            }
            if (this.mHy && file.equals(DefaultDiskStorage.this.mHs)) {
                this.mHy = false;
            }
        }

        private boolean ah(File file) {
            c ab = DefaultDiskStorage.this.ab(file);
            if (ab == null) {
                return false;
            }
            if (ab.type == ".tmp") {
                return ai(file);
            }
            com.facebook.common.internal.g.checkState(ab.type == ".cnt");
            return true;
        }

        private boolean ai(File file) {
            return file.lastModified() > DefaultDiskStorage.this.mHu.now() - DefaultDiskStorage.mHp;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void dyx() {
        com.facebook.common.file.a.a(this.mHq, new e());
    }

    private void h(File file, String str) throws IOException {
        try {
            FileUtils.al(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.mHt.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mHo, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Qv = Qv(cVar.resourceId);
        if (!Qv.exists()) {
            h(Qv, "insert");
        }
        try {
            return new d(str, cVar.af(Qv));
        } catch (IOException e2) {
            this.mHt.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, mHo, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) {
        File Qt = Qt(str);
        if (Qt.exists()) {
            Qt.setLastModified(this.mHu.now());
            return com.facebook.a.b.Z(Qt);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Qz(Qu(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) {
        return aY(str, false);
    }

    private boolean aY(String str, boolean z) {
        File Qt = Qt(str);
        boolean exists = Qt.exists();
        if (z && exists) {
            Qt.setLastModified(this.mHu.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return aa(((b) aVar).dyA().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Qw(String str) {
        return aa(Qt(str));
    }

    private long aa(File file) {
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
    public List<c.a> dyy() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.mHs, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes13.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b mHw;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.mHw = com.facebook.a.b.Z(file);
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
                this.timestamp = this.mHw.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dyA() {
            return this.mHw;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.mHw.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ab(File file) {
        c ag = c.ag(file);
        if (ag == null) {
            return null;
        }
        if (!Qv(ag.resourceId).equals(file.getParentFile())) {
            ag = null;
        }
        return ag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Qx(String str) {
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

        public String Qz(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File af(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ag(File file) {
            String Qx;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Qx = DefaultDiskStorage.Qx(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Qx.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Qx, substring);
            }
            return null;
        }
    }

    /* loaded from: classes13.dex */
    class d implements c.b {
        private final String kVw;
        final File mHx;

        public d(String str, File file) {
            this.kVw = str;
            this.mHx = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mHx);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.mHx.length() != count) {
                        throw new IncompleteFileException(count, this.mHx.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.mHt.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.mHo, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aM(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Qt = DefaultDiskStorage.this.Qt(this.kVw);
            try {
                FileUtils.rename(this.mHx, Qt);
                if (Qt.exists()) {
                    Qt.setLastModified(DefaultDiskStorage.this.mHu.now());
                }
                return com.facebook.a.b.Z(Qt);
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
                DefaultDiskStorage.this.mHt.a(cacheErrorCategory, DefaultDiskStorage.mHo, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dyB() {
            return !this.mHx.exists() || this.mHx.delete();
        }
    }
}
