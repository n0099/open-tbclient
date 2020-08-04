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
/* loaded from: classes3.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private final File mPB;
    private final boolean mPC;
    private final File mPD;
    private final CacheErrorLogger mPE;
    private final com.facebook.common.time.a mPF;
    private static final Class<?> mPz = DefaultDiskStorage.class;
    static final long mPA = TimeUnit.MINUTES.toMillis(30);

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.mPB = file;
        this.mPC = a(file, cacheErrorLogger);
        this.mPD = new File(this.mPB, Io(i));
        this.mPE = cacheErrorLogger;
        dBN();
        this.mPF = com.facebook.common.time.c.dCT();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, mPz, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, mPz, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String Io(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.mPC;
    }

    private void dBN() {
        boolean z = true;
        if (this.mPB.exists()) {
            if (this.mPD.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.an(this.mPB);
            }
        }
        if (z) {
            try {
                FileUtils.ao(this.mPD);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.mPE.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mPz, "version directory could not be created: " + this.mPD, null);
            }
        }
    }

    /* loaded from: classes3.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File Rf(String str) {
        return new File(getFilename(str));
    }

    private String Rg(String str) {
        return this.mPD + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Rh(String str) {
        return new File(Rg(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ag(File file) {
            c ae = DefaultDiskStorage.this.ae(file);
            if (ae != null && ae.type == ".cnt") {
                this.result.add(new b(ae.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void ah(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes3.dex */
    private class e implements com.facebook.common.file.b {
        private boolean mPJ;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
            if (!this.mPJ && file.equals(DefaultDiskStorage.this.mPD)) {
                this.mPJ = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ag(File file) {
            if (!this.mPJ || !ak(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ah(File file) {
            if (!DefaultDiskStorage.this.mPB.equals(file) && !this.mPJ) {
                file.delete();
            }
            if (this.mPJ && file.equals(DefaultDiskStorage.this.mPD)) {
                this.mPJ = false;
            }
        }

        private boolean ak(File file) {
            c ae = DefaultDiskStorage.this.ae(file);
            if (ae == null) {
                return false;
            }
            if (ae.type == ".tmp") {
                return al(file);
            }
            com.facebook.common.internal.g.checkState(ae.type == ".cnt");
            return true;
        }

        private boolean al(File file) {
            return file.lastModified() > DefaultDiskStorage.this.mPF.now() - DefaultDiskStorage.mPA;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void dBO() {
        com.facebook.common.file.a.a(this.mPB, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.ao(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.mPE.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mPz, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Rh = Rh(cVar.resourceId);
        if (!Rh.exists()) {
            i(Rh, "insert");
        }
        try {
            return new d(str, cVar.ai(Rh));
        } catch (IOException e2) {
            this.mPE.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, mPz, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) {
        File Rf = Rf(str);
        if (Rf.exists()) {
            Rf.setLastModified(this.mPF.now());
            return com.facebook.a.b.ac(Rf);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Rl(Rg(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) {
        return aV(str, false);
    }

    private boolean aV(String str, boolean z) {
        File Rf = Rf(str);
        boolean exists = Rf.exists();
        if (z && exists) {
            Rf.setLastModified(this.mPF.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ad(((b) aVar).dBR().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Ri(String str) {
        return ad(Rf(str));
    }

    private long ad(File file) {
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
    public List<c.a> dBP() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.mPD, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes3.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b mPH;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.mPH = com.facebook.a.b.ac(file);
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
                this.timestamp = this.mPH.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dBR() {
            return this.mPH;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.mPH.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ae(File file) {
        c aj = c.aj(file);
        if (aj == null) {
            return null;
        }
        if (!Rh(aj.resourceId).equals(file.getParentFile())) {
            aj = null;
        }
        return aj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Rj(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
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

        public String Rl(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File ai(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c aj(File file) {
            String Rj;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Rj = DefaultDiskStorage.Rj(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Rj.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Rj, substring);
            }
            return null;
        }
    }

    /* loaded from: classes3.dex */
    class d implements c.b {
        private final String lcR;
        final File mPI;

        public d(String str, File file) {
            this.lcR = str;
            this.mPI = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.mPI);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.mPI.length() != count) {
                        throw new IncompleteFileException(count, this.mPI.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.mPE.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.mPz, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aM(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Rf = DefaultDiskStorage.this.Rf(this.lcR);
            try {
                FileUtils.rename(this.mPI, Rf);
                if (Rf.exists()) {
                    Rf.setLastModified(DefaultDiskStorage.this.mPF.now());
                }
                return com.facebook.a.b.ac(Rf);
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
                DefaultDiskStorage.this.mPE.a(cacheErrorCategory, DefaultDiskStorage.mPz, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dBS() {
            return !this.mPI.exists() || this.mPI.delete();
        }
    }
}
