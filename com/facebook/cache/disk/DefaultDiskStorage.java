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
    private static final Class<?> mHr = DefaultDiskStorage.class;
    static final long mHs = TimeUnit.MINUTES.toMillis(30);
    private final File mHt;
    private final boolean mHu;
    private final File mHv;
    private final CacheErrorLogger mHw;
    private final com.facebook.common.time.a mHx;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.mHt = file;
        this.mHu = a(file, cacheErrorLogger);
        this.mHv = new File(this.mHt, HT(i));
        this.mHw = cacheErrorLogger;
        dyA();
        this.mHx = com.facebook.common.time.c.dzG();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, mHr, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, mHr, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String HT(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.mHu;
    }

    private void dyA() {
        boolean z = true;
        if (this.mHt.exists()) {
            if (this.mHv.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ak(this.mHt);
            }
        }
        if (z) {
            try {
                FileUtils.al(this.mHv);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.mHw.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mHr, "version directory could not be created: " + this.mHv, null);
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

    File Qu(String str) {
        return new File(getFilename(str));
    }

    private String Qv(String str) {
        return this.mHv + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Qw(String str) {
        return new File(Qv(str));
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
        private boolean mHB;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ac(File file) {
            if (!this.mHB && file.equals(DefaultDiskStorage.this.mHv)) {
                this.mHB = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            if (!this.mHB || !ah(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            if (!DefaultDiskStorage.this.mHt.equals(file) && !this.mHB) {
                file.delete();
            }
            if (this.mHB && file.equals(DefaultDiskStorage.this.mHv)) {
                this.mHB = false;
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
            return file.lastModified() > DefaultDiskStorage.this.mHx.now() - DefaultDiskStorage.mHs;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void dyB() {
        com.facebook.common.file.a.a(this.mHt, new e());
    }

    private void h(File file, String str) throws IOException {
        try {
            FileUtils.al(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.mHw.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mHr, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Qw = Qw(cVar.resourceId);
        if (!Qw.exists()) {
            h(Qw, "insert");
        }
        try {
            return new d(str, cVar.af(Qw));
        } catch (IOException e2) {
            this.mHw.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, mHr, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) {
        File Qu = Qu(str);
        if (Qu.exists()) {
            Qu.setLastModified(this.mHx.now());
            return com.facebook.a.b.Z(Qu);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.QA(Qv(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) {
        return aY(str, false);
    }

    private boolean aY(String str, boolean z) {
        File Qu = Qu(str);
        boolean exists = Qu.exists();
        if (z && exists) {
            Qu.setLastModified(this.mHx.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return aa(((b) aVar).dyE().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Qx(String str) {
        return aa(Qu(str));
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
    public List<c.a> dyC() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.mHv, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes13.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b mHz;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.mHz = com.facebook.a.b.Z(file);
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
                this.timestamp = this.mHz.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dyE() {
            return this.mHz;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.mHz.size();
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
        if (!Qw(ag.resourceId).equals(file.getParentFile())) {
            ag = null;
        }
        return ag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Qy(String str) {
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

        public String QA(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File af(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ag(File file) {
            String Qy;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Qy = DefaultDiskStorage.Qy(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Qy.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Qy, substring);
            }
            return null;
        }
    }

    /* loaded from: classes13.dex */
    class d implements c.b {
        private final String kVw;
        final File mHA;

        public d(String str, File file) {
            this.kVw = str;
            this.mHA = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mHA);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.mHA.length() != count) {
                        throw new IncompleteFileException(count, this.mHA.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.mHw.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.mHr, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aM(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Qu = DefaultDiskStorage.this.Qu(this.kVw);
            try {
                FileUtils.rename(this.mHA, Qu);
                if (Qu.exists()) {
                    Qu.setLastModified(DefaultDiskStorage.this.mHx.now());
                }
                return com.facebook.a.b.Z(Qu);
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
                DefaultDiskStorage.this.mHw.a(cacheErrorCategory, DefaultDiskStorage.mHr, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dyF() {
            return !this.mHA.exists() || this.mHA.delete();
        }
    }
}
