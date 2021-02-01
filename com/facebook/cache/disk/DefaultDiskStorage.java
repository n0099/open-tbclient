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
    private static final Class<?> pxC = DefaultDiskStorage.class;
    static final long pxD = TimeUnit.MINUTES.toMillis(30);
    private final File pxE;
    private final boolean pxF;
    private final File pxG;
    private final CacheErrorLogger pxH;
    private final com.facebook.common.time.a pxI;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.pxE = file;
        this.pxF = a(file, cacheErrorLogger);
        this.pxG = new File(this.pxE, OS(i));
        this.pxH = cacheErrorLogger;
        erP();
        this.pxI = com.facebook.common.time.c.esU();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pxC, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pxC, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String OS(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.pxF;
    }

    private void erP() {
        boolean z = true;
        if (this.pxE.exists()) {
            if (this.pxG.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.av(this.pxE);
            }
        }
        if (z) {
            try {
                FileUtils.aw(this.pxG);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.pxH.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pxC, "version directory could not be created: " + this.pxG, null);
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

    File Za(String str) {
        return new File(getFilename(str));
    }

    private String Zb(String str) {
        return this.pxG + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Zc(String str) {
        return new File(Zb(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void an(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ao(File file) {
            c am = DefaultDiskStorage.this.am(file);
            if (am != null && am.type == ".cnt") {
                this.result.add(new b(am.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void ap(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes5.dex */
    private class e implements com.facebook.common.file.b {
        private boolean pxM;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void an(File file) {
            if (!this.pxM && file.equals(DefaultDiskStorage.this.pxG)) {
                this.pxM = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ao(File file) {
            if (!this.pxM || !as(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ap(File file) {
            if (!DefaultDiskStorage.this.pxE.equals(file) && !this.pxM) {
                file.delete();
            }
            if (this.pxM && file.equals(DefaultDiskStorage.this.pxG)) {
                this.pxM = false;
            }
        }

        private boolean as(File file) {
            c am = DefaultDiskStorage.this.am(file);
            if (am == null) {
                return false;
            }
            if (am.type == ".tmp") {
                return at(file);
            }
            com.facebook.common.internal.g.checkState(am.type == ".cnt");
            return true;
        }

        private boolean at(File file) {
            return file.lastModified() > DefaultDiskStorage.this.pxI.now() - DefaultDiskStorage.pxD;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void erQ() {
        com.facebook.common.file.a.a(this.pxE, new e());
    }

    private void l(File file, String str) throws IOException {
        try {
            FileUtils.aw(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.pxH.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pxC, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b E(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Zc = Zc(cVar.resourceId);
        if (!Zc.exists()) {
            l(Zc, "insert");
        }
        try {
            return new d(str, cVar.aq(Zc));
        } catch (IOException e2) {
            this.pxH.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, pxC, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a F(String str, Object obj) {
        File Za = Za(str);
        if (Za.exists()) {
            Za.setLastModified(this.pxI.now());
            return com.facebook.a.b.ak(Za);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Zg(Zb(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean G(String str, Object obj) {
        return bn(str, false);
    }

    private boolean bn(String str, boolean z) {
        File Za = Za(str);
        boolean exists = Za.exists();
        if (z && exists) {
            Za.setLastModified(this.pxI.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return al(((b) aVar).erT().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Zd(String str) {
        return al(Za(str));
    }

    private long al(File file) {
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
    public List<c.a> erR() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.pxG, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes5.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b pxK;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.pxK = com.facebook.a.b.ak(file);
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
                this.timestamp = this.pxK.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b erT() {
            return this.pxK;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.pxK.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c am(File file) {
        c ar = c.ar(file);
        if (ar == null) {
            return null;
        }
        if (!Zc(ar.resourceId).equals(file.getParentFile())) {
            ar = null;
        }
        return ar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Ze(String str) {
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

        public String Zg(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File aq(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ar(File file) {
            String Ze;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Ze = DefaultDiskStorage.Ze(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Ze.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Ze, substring);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    class d implements c.b {
        private final String mIm;
        final File pxL;

        public d(String str, File file) {
            this.mIm = str;
            this.pxL = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.pxL);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.pxL.length() != count) {
                        throw new IncompleteFileException(count, this.pxL.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.pxH.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.pxC, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aZ(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Za = DefaultDiskStorage.this.Za(this.mIm);
            try {
                FileUtils.rename(this.pxL, Za);
                if (Za.exists()) {
                    Za.setLastModified(DefaultDiskStorage.this.pxI.now());
                }
                return com.facebook.a.b.ak(Za);
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
                DefaultDiskStorage.this.pxH.a(cacheErrorCategory, DefaultDiskStorage.pxC, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean erU() {
            return !this.pxL.exists() || this.pxL.delete();
        }
    }
}
