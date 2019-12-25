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
/* loaded from: classes11.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> lCO = DefaultDiskStorage.class;
    static final long lCP = TimeUnit.MINUTES.toMillis(30);
    private final File lCQ;
    private final boolean lCR;
    private final File lCS;
    private final CacheErrorLogger lCT;
    private final com.facebook.common.time.a lCU;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.lCQ = file;
        this.lCR = a(file, cacheErrorLogger);
        this.lCS = new File(this.lCQ, Hh(i));
        this.lCT = cacheErrorLogger;
        dhF();
        this.lCU = com.facebook.common.time.c.diL();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, lCO, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, lCO, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String Hh(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.lCR;
    }

    private void dhF() {
        boolean z = true;
        if (this.lCQ.exists()) {
            if (this.lCS.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ai(this.lCQ);
            }
        }
        if (z) {
            try {
                FileUtils.aj(this.lCS);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.lCT.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lCO, "version directory could not be created: " + this.lCS, null);
            }
        }
    }

    /* loaded from: classes11.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File Ol(String str) {
        return new File(getFilename(str));
    }

    private String Om(String str) {
        return this.lCS + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File On(String str) {
        return new File(Om(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
        }

        @Override // com.facebook.common.file.b
        public void aa(File file) {
            c Y = DefaultDiskStorage.this.Y(file);
            if (Y != null && Y.type == ".cnt") {
                this.result.add(new b(Y.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void ab(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes11.dex */
    private class e implements com.facebook.common.file.b {
        private boolean lCY;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
            if (!this.lCY && file.equals(DefaultDiskStorage.this.lCS)) {
                this.lCY = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void aa(File file) {
            if (!this.lCY || !ae(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ab(File file) {
            if (!DefaultDiskStorage.this.lCQ.equals(file) && !this.lCY) {
                file.delete();
            }
            if (this.lCY && file.equals(DefaultDiskStorage.this.lCS)) {
                this.lCY = false;
            }
        }

        private boolean ae(File file) {
            c Y = DefaultDiskStorage.this.Y(file);
            if (Y == null) {
                return false;
            }
            if (Y.type == ".tmp") {
                return af(file);
            }
            com.facebook.common.internal.g.checkState(Y.type == ".cnt");
            return true;
        }

        private boolean af(File file) {
            return file.lastModified() > DefaultDiskStorage.this.lCU.now() - DefaultDiskStorage.lCP;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void dhG() {
        com.facebook.common.file.a.a(this.lCQ, new e());
    }

    private void f(File file, String str) throws IOException {
        try {
            FileUtils.aj(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.lCT.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lCO, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File On = On(cVar.resourceId);
        if (!On.exists()) {
            f(On, "insert");
        }
        try {
            return new d(str, cVar.ac(On));
        } catch (IOException e2) {
            this.lCT.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, lCO, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) {
        File Ol = Ol(str);
        if (Ol.exists()) {
            Ol.setLastModified(this.lCU.now());
            return com.facebook.a.b.W(Ol);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Oq(Om(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) {
        return aJ(str, false);
    }

    private boolean aJ(String str, boolean z) {
        File Ol = Ol(str);
        boolean exists = Ol.exists();
        if (z && exists) {
            Ol.setLastModified(this.lCU.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return X(((b) aVar).dhJ().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Oo(String str) {
        return X(Ol(str));
    }

    private long X(File file) {
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
    public List<c.a> dhH() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.lCS, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes11.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b lCW;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.lCW = com.facebook.a.b.W(file);
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
                this.timestamp = this.lCW.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dhJ() {
            return this.lCW;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.lCW.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c Y(File file) {
        c ad = c.ad(file);
        if (ad == null) {
            return null;
        }
        if (!On(ad.resourceId).equals(file.getParentFile())) {
            ad = null;
        }
        return ad;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Op(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
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

        public String Oq(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File ac(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ad(File file) {
            String Op;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Op = DefaultDiskStorage.Op(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Op.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Op, substring);
            }
            return null;
        }
    }

    /* loaded from: classes11.dex */
    class d implements c.b {
        private final String jso;
        final File lCX;

        public d(String str, File file) {
            this.jso = str;
            this.lCX = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.lCX);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.lCX.length() != count) {
                        throw new IncompleteFileException(count, this.lCX.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.lCT.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.lCO, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aO(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Ol = DefaultDiskStorage.this.Ol(this.jso);
            try {
                FileUtils.rename(this.lCX, Ol);
                if (Ol.exists()) {
                    Ol.setLastModified(DefaultDiskStorage.this.lCU.now());
                }
                return com.facebook.a.b.W(Ol);
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
                DefaultDiskStorage.this.lCT.a(cacheErrorCategory, DefaultDiskStorage.lCO, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dhK() {
            return !this.lCX.exists() || this.lCX.delete();
        }
    }
}
