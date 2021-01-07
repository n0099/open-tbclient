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
    private static final Class<?> prR = DefaultDiskStorage.class;
    static final long prS = TimeUnit.MINUTES.toMillis(30);
    private final File prT;
    private final boolean prU;
    private final File prV;
    private final CacheErrorLogger prW;
    private final com.facebook.common.time.a prX;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.prT = file;
        this.prU = a(file, cacheErrorLogger);
        this.prV = new File(this.prT, Qe(i));
        this.prW = cacheErrorLogger;
        etq();
        this.prX = com.facebook.common.time.c.euv();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, prR, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, prR, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String Qe(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.prU;
    }

    private void etq() {
        boolean z = true;
        if (this.prT.exists()) {
            if (this.prV.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.az(this.prT);
            }
        }
        if (z) {
            try {
                FileUtils.aA(this.prV);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.prW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, prR, "version directory could not be created: " + this.prV, null);
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

    File Zg(String str) {
        return new File(getFilename(str));
    }

    private String Zh(String str) {
        return this.prV + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Zi(String str) {
        return new File(Zh(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ar(File file) {
        }

        @Override // com.facebook.common.file.b
        public void as(File file) {
            c aq = DefaultDiskStorage.this.aq(file);
            if (aq != null && aq.type == ".cnt") {
                this.result.add(new b(aq.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void at(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes5.dex */
    private class e implements com.facebook.common.file.b {
        private boolean psb;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ar(File file) {
            if (!this.psb && file.equals(DefaultDiskStorage.this.prV)) {
                this.psb = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void as(File file) {
            if (!this.psb || !aw(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void at(File file) {
            if (!DefaultDiskStorage.this.prT.equals(file) && !this.psb) {
                file.delete();
            }
            if (this.psb && file.equals(DefaultDiskStorage.this.prV)) {
                this.psb = false;
            }
        }

        private boolean aw(File file) {
            c aq = DefaultDiskStorage.this.aq(file);
            if (aq == null) {
                return false;
            }
            if (aq.type == ".tmp") {
                return ax(file);
            }
            com.facebook.common.internal.g.checkState(aq.type == ".cnt");
            return true;
        }

        private boolean ax(File file) {
            return file.lastModified() > DefaultDiskStorage.this.prX.now() - DefaultDiskStorage.prS;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void etr() {
        com.facebook.common.file.a.a(this.prT, new e());
    }

    private void m(File file, String str) throws IOException {
        try {
            FileUtils.aA(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.prW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, prR, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b F(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Zi = Zi(cVar.resourceId);
        if (!Zi.exists()) {
            m(Zi, "insert");
        }
        try {
            return new d(str, cVar.au(Zi));
        } catch (IOException e2) {
            this.prW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, prR, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a G(String str, Object obj) {
        File Zg = Zg(str);
        if (Zg.exists()) {
            Zg.setLastModified(this.prX.now());
            return com.facebook.a.b.ao(Zg);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Zm(Zh(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean H(String str, Object obj) {
        return bn(str, false);
    }

    private boolean bn(String str, boolean z) {
        File Zg = Zg(str);
        boolean exists = Zg.exists();
        if (z && exists) {
            Zg.setLastModified(this.prX.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ap(((b) aVar).etu().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Zj(String str) {
        return ap(Zg(str));
    }

    private long ap(File file) {
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
    public List<c.a> ets() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.prV, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes5.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b prZ;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.prZ = com.facebook.a.b.ao(file);
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
                this.timestamp = this.prZ.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b etu() {
            return this.prZ;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.prZ.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c aq(File file) {
        c av = c.av(file);
        if (av == null) {
            return null;
        }
        if (!Zi(av.resourceId).equals(file.getParentFile())) {
            av = null;
        }
        return av;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Zk(String str) {
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

        public String Zm(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File au(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c av(File file) {
            String Zk;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Zk = DefaultDiskStorage.Zk(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Zk.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Zk, substring);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    class d implements c.b {
        private final String mDO;
        final File psa;

        public d(String str, File file) {
            this.mDO = str;
            this.psa = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.psa);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.psa.length() != count) {
                        throw new IncompleteFileException(count, this.psa.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.prW.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.prR, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aZ(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Zg = DefaultDiskStorage.this.Zg(this.mDO);
            try {
                FileUtils.rename(this.psa, Zg);
                if (Zg.exists()) {
                    Zg.setLastModified(DefaultDiskStorage.this.prX.now());
                }
                return com.facebook.a.b.ao(Zg);
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
                DefaultDiskStorage.this.prW.a(cacheErrorCategory, DefaultDiskStorage.prR, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean etv() {
            return !this.psa.exists() || this.psa.delete();
        }
    }
}
