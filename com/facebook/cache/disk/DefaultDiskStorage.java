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
/* loaded from: classes6.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> prQ = DefaultDiskStorage.class;
    static final long prR = TimeUnit.MINUTES.toMillis(30);
    private final File prS;
    private final boolean prT;
    private final File prU;
    private final CacheErrorLogger prV;
    private final com.facebook.common.time.a prW;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.prS = file;
        this.prT = a(file, cacheErrorLogger);
        this.prU = new File(this.prS, PZ(i));
        this.prV = cacheErrorLogger;
        etm();
        this.prW = com.facebook.common.time.c.euo();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, prQ, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, prQ, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String PZ(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.prT;
    }

    private void etm() {
        boolean z = true;
        if (this.prS.exists()) {
            if (this.prU.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.az(this.prS);
            }
        }
        if (z) {
            try {
                FileUtils.aA(this.prU);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.prV.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, prQ, "version directory could not be created: " + this.prU, null);
            }
        }
    }

    /* loaded from: classes6.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File Zh(String str) {
        return new File(getFilename(str));
    }

    private String Zi(String str) {
        return this.prU + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Zj(String str) {
        return new File(Zi(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    private class e implements com.facebook.common.file.b {
        private boolean psa;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ar(File file) {
            if (!this.psa && file.equals(DefaultDiskStorage.this.prU)) {
                this.psa = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void as(File file) {
            if (!this.psa || !aw(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void at(File file) {
            if (!DefaultDiskStorage.this.prS.equals(file) && !this.psa) {
                file.delete();
            }
            if (this.psa && file.equals(DefaultDiskStorage.this.prU)) {
                this.psa = false;
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
            return file.lastModified() > DefaultDiskStorage.this.prW.now() - DefaultDiskStorage.prR;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void etn() {
        com.facebook.common.file.a.a(this.prS, new e());
    }

    private void m(File file, String str) throws IOException {
        try {
            FileUtils.aA(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.prV.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, prQ, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b F(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Zj = Zj(cVar.resourceId);
        if (!Zj.exists()) {
            m(Zj, "insert");
        }
        try {
            return new d(str, cVar.au(Zj));
        } catch (IOException e2) {
            this.prV.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, prQ, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a G(String str, Object obj) {
        File Zh = Zh(str);
        if (Zh.exists()) {
            Zh.setLastModified(this.prW.now());
            return com.facebook.a.b.ao(Zh);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Zn(Zi(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean H(String str, Object obj) {
        return bn(str, false);
    }

    private boolean bn(String str, boolean z) {
        File Zh = Zh(str);
        boolean exists = Zh.exists();
        if (z && exists) {
            Zh.setLastModified(this.prW.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ap(((b) aVar).etq().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Zk(String str) {
        return ap(Zh(str));
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
    public List<c.a> eto() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.prU, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes6.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b prY;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.prY = com.facebook.a.b.ao(file);
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
                this.timestamp = this.prY.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b etq() {
            return this.prY;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.prY.size();
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
        if (!Zj(av.resourceId).equals(file.getParentFile())) {
            av = null;
        }
        return av;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Zl(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
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

        public String Zn(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File au(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c av(File file) {
            String Zl;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Zl = DefaultDiskStorage.Zl(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Zl.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Zl, substring);
            }
            return null;
        }
    }

    /* loaded from: classes6.dex */
    class d implements c.b {
        private final String mDP;
        final File prZ;

        public d(String str, File file) {
            this.mDP = str;
            this.prZ = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.prZ);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.prZ.length() != count) {
                        throw new IncompleteFileException(count, this.prZ.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.prV.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.prQ, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aZ(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Zh = DefaultDiskStorage.this.Zh(this.mDP);
            try {
                FileUtils.rename(this.prZ, Zh);
                if (Zh.exists()) {
                    Zh.setLastModified(DefaultDiskStorage.this.prW.now());
                }
                return com.facebook.a.b.ao(Zh);
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
                DefaultDiskStorage.this.prV.a(cacheErrorCategory, DefaultDiskStorage.prQ, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean etr() {
            return !this.prZ.exists() || this.prZ.delete();
        }
    }
}
