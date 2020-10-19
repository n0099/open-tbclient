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
/* loaded from: classes12.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> nJf = DefaultDiskStorage.class;
    static final long nJg = TimeUnit.MINUTES.toMillis(30);
    private final File nJh;
    private final boolean nJi;
    private final File nJj;
    private final CacheErrorLogger nJk;
    private final com.facebook.common.time.a nJl;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.nJh = file;
        this.nJi = a(file, cacheErrorLogger);
        this.nJj = new File(this.nJh, Md(i));
        this.nJk = cacheErrorLogger;
        dVF();
        this.nJl = com.facebook.common.time.c.dWL();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, nJf, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, nJf, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String Md(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.nJi;
    }

    private void dVF() {
        boolean z = true;
        if (this.nJh.exists()) {
            if (this.nJj.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ar(this.nJh);
            }
        }
        if (z) {
            try {
                FileUtils.as(this.nJj);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.nJk.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, nJf, "version directory could not be created: " + this.nJj, null);
            }
        }
    }

    /* loaded from: classes12.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File Vz(String str) {
        return new File(getFilename(str));
    }

    private String VA(String str) {
        return this.nJj + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File VB(String str) {
        return new File(VA(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void aj(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ak(File file) {
            c ai = DefaultDiskStorage.this.ai(file);
            if (ai != null && ai.type == ".cnt") {
                this.result.add(new b(ai.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void al(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes12.dex */
    private class e implements com.facebook.common.file.b {
        private boolean nJp;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void aj(File file) {
            if (!this.nJp && file.equals(DefaultDiskStorage.this.nJj)) {
                this.nJp = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ak(File file) {
            if (!this.nJp || !ao(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void al(File file) {
            if (!DefaultDiskStorage.this.nJh.equals(file) && !this.nJp) {
                file.delete();
            }
            if (this.nJp && file.equals(DefaultDiskStorage.this.nJj)) {
                this.nJp = false;
            }
        }

        private boolean ao(File file) {
            c ai = DefaultDiskStorage.this.ai(file);
            if (ai == null) {
                return false;
            }
            if (ai.type == ".tmp") {
                return ap(file);
            }
            com.facebook.common.internal.g.checkState(ai.type == ".cnt");
            return true;
        }

        private boolean ap(File file) {
            return file.lastModified() > DefaultDiskStorage.this.nJl.now() - DefaultDiskStorage.nJg;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void dVG() {
        com.facebook.common.file.a.a(this.nJh, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.as(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.nJk.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, nJf, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File VB = VB(cVar.resourceId);
        if (!VB.exists()) {
            i(VB, "insert");
        }
        try {
            return new d(str, cVar.am(VB));
        } catch (IOException e2) {
            this.nJk.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, nJf, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) {
        File Vz = Vz(str);
        if (Vz.exists()) {
            Vz.setLastModified(this.nJl.now());
            return com.facebook.a.b.ag(Vz);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.VF(VA(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) {
        return be(str, false);
    }

    private boolean be(String str, boolean z) {
        File Vz = Vz(str);
        boolean exists = Vz.exists();
        if (z && exists) {
            Vz.setLastModified(this.nJl.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ah(((b) aVar).dVJ().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long VC(String str) {
        return ah(Vz(str));
    }

    private long ah(File file) {
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
    public List<c.a> dVH() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.nJj, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes12.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b nJn;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.nJn = com.facebook.a.b.ag(file);
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
                this.timestamp = this.nJn.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dVJ() {
            return this.nJn;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.nJn.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ai(File file) {
        c an = c.an(file);
        if (an == null) {
            return null;
        }
        if (!VB(an.resourceId).equals(file.getParentFile())) {
            an = null;
        }
        return an;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String VD(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
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

        public String VF(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File am(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c an(File file) {
            String VD;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (VD = DefaultDiskStorage.VD(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (VD.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(VD, substring);
            }
            return null;
        }
    }

    /* loaded from: classes12.dex */
    class d implements c.b {
        private final String lRC;
        final File nJo;

        public d(String str, File file) {
            this.lRC = str;
            this.nJo = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.nJo);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.nJo.length() != count) {
                        throw new IncompleteFileException(count, this.nJo.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.nJk.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.nJf, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aT(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Vz = DefaultDiskStorage.this.Vz(this.lRC);
            try {
                FileUtils.rename(this.nJo, Vz);
                if (Vz.exists()) {
                    Vz.setLastModified(DefaultDiskStorage.this.nJl.now());
                }
                return com.facebook.a.b.ag(Vz);
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
                DefaultDiskStorage.this.nJk.a(cacheErrorCategory, DefaultDiskStorage.nJf, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dVK() {
            return !this.nJo.exists() || this.nJo.delete();
        }
    }
}
