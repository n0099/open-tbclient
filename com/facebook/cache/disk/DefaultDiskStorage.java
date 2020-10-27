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
    private static final Class<?> oAy = DefaultDiskStorage.class;
    static final long oAz = TimeUnit.MINUTES.toMillis(30);
    private final File oAA;
    private final boolean oAB;
    private final File oAC;
    private final CacheErrorLogger oAD;
    private final com.facebook.common.time.a oAE;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.oAA = file;
        this.oAB = a(file, cacheErrorLogger);
        this.oAC = new File(this.oAA, NU(i));
        this.oAD = cacheErrorLogger;
        efD();
        this.oAE = com.facebook.common.time.c.egJ();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, oAy, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, oAy, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String NU(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.oAB;
    }

    private void efD() {
        boolean z = true;
        if (this.oAA.exists()) {
            if (this.oAC.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.as(this.oAA);
            }
        }
        if (z) {
            try {
                FileUtils.at(this.oAC);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.oAD.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, oAy, "version directory could not be created: " + this.oAC, null);
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

    File Xm(String str) {
        return new File(getFilename(str));
    }

    private String Xn(String str) {
        return this.oAC + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Xo(String str) {
        return new File(Xn(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ak(File file) {
        }

        @Override // com.facebook.common.file.b
        public void al(File file) {
            c aj = DefaultDiskStorage.this.aj(file);
            if (aj != null && aj.type == ".cnt") {
                this.result.add(new b(aj.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void am(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes12.dex */
    private class e implements com.facebook.common.file.b {
        private boolean oAI;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ak(File file) {
            if (!this.oAI && file.equals(DefaultDiskStorage.this.oAC)) {
                this.oAI = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void al(File file) {
            if (!this.oAI || !ap(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void am(File file) {
            if (!DefaultDiskStorage.this.oAA.equals(file) && !this.oAI) {
                file.delete();
            }
            if (this.oAI && file.equals(DefaultDiskStorage.this.oAC)) {
                this.oAI = false;
            }
        }

        private boolean ap(File file) {
            c aj = DefaultDiskStorage.this.aj(file);
            if (aj == null) {
                return false;
            }
            if (aj.type == ".tmp") {
                return aq(file);
            }
            com.facebook.common.internal.g.checkState(aj.type == ".cnt");
            return true;
        }

        private boolean aq(File file) {
            return file.lastModified() > DefaultDiskStorage.this.oAE.now() - DefaultDiskStorage.oAz;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void efE() {
        com.facebook.common.file.a.a(this.oAA, new e());
    }

    private void j(File file, String str) throws IOException {
        try {
            FileUtils.at(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.oAD.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, oAy, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Xo = Xo(cVar.resourceId);
        if (!Xo.exists()) {
            j(Xo, "insert");
        }
        try {
            return new d(str, cVar.an(Xo));
        } catch (IOException e2) {
            this.oAD.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, oAy, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) {
        File Xm = Xm(str);
        if (Xm.exists()) {
            Xm.setLastModified(this.oAE.now());
            return com.facebook.a.b.ah(Xm);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Xs(Xn(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) {
        return bk(str, false);
    }

    private boolean bk(String str, boolean z) {
        File Xm = Xm(str);
        boolean exists = Xm.exists();
        if (z && exists) {
            Xm.setLastModified(this.oAE.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ai(((b) aVar).efH().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Xp(String str) {
        return ai(Xm(str));
    }

    private long ai(File file) {
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
    public List<c.a> efF() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.oAC, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes12.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b oAG;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.oAG = com.facebook.a.b.ah(file);
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
                this.timestamp = this.oAG.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b efH() {
            return this.oAG;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.oAG.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aj(File file) {
        c ao = c.ao(file);
        if (ao == null) {
            return null;
        }
        if (!Xo(ao.resourceId).equals(file.getParentFile())) {
            ao = null;
        }
        return ao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Xq(String str) {
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

        public String Xs(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File an(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ao(File file) {
            String Xq;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Xq = DefaultDiskStorage.Xq(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Xq.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Xq, substring);
            }
            return null;
        }
    }

    /* loaded from: classes12.dex */
    class d implements c.b {
        private final String mea;
        final File oAH;

        public d(String str, File file) {
            this.mea = str;
            this.oAH = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.oAH);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.oAH.length() != count) {
                        throw new IncompleteFileException(count, this.oAH.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.oAD.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.oAy, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aX(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Xm = DefaultDiskStorage.this.Xm(this.mea);
            try {
                FileUtils.rename(this.oAH, Xm);
                if (Xm.exists()) {
                    Xm.setLastModified(DefaultDiskStorage.this.oAE.now());
                }
                return com.facebook.a.b.ah(Xm);
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
                DefaultDiskStorage.this.oAD.a(cacheErrorCategory, DefaultDiskStorage.oAy, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean efI() {
            return !this.oAH.exists() || this.oAH.delete();
        }
    }
}
