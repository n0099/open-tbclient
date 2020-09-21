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
    private static final Class<?> ntL = DefaultDiskStorage.class;
    static final long ntM = TimeUnit.MINUTES.toMillis(30);
    private final File ntN;
    private final boolean ntO;
    private final File ntP;
    private final CacheErrorLogger ntQ;
    private final com.facebook.common.time.a ntR;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.ntN = file;
        this.ntO = a(file, cacheErrorLogger);
        this.ntP = new File(this.ntN, Lx(i));
        this.ntQ = cacheErrorLogger;
        dRU();
        this.ntR = com.facebook.common.time.c.dTa();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, ntL, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, ntL, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String Lx(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.ntO;
    }

    private void dRU() {
        boolean z = true;
        if (this.ntN.exists()) {
            if (this.ntP.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ao(this.ntN);
            }
        }
        if (z) {
            try {
                FileUtils.ap(this.ntP);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.ntQ.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, ntL, "version directory could not be created: " + this.ntP, null);
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

    File UL(String str) {
        return new File(getFilename(str));
    }

    private String UM(String str) {
        return this.ntP + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File UN(String str) {
        return new File(UM(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes12.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ag(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ah(File file) {
            c af = DefaultDiskStorage.this.af(file);
            if (af != null && af.type == ".cnt") {
                this.result.add(new b(af.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void ai(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes12.dex */
    private class e implements com.facebook.common.file.b {
        private boolean ntV;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ag(File file) {
            if (!this.ntV && file.equals(DefaultDiskStorage.this.ntP)) {
                this.ntV = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ah(File file) {
            if (!this.ntV || !al(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ai(File file) {
            if (!DefaultDiskStorage.this.ntN.equals(file) && !this.ntV) {
                file.delete();
            }
            if (this.ntV && file.equals(DefaultDiskStorage.this.ntP)) {
                this.ntV = false;
            }
        }

        private boolean al(File file) {
            c af = DefaultDiskStorage.this.af(file);
            if (af == null) {
                return false;
            }
            if (af.type == ".tmp") {
                return am(file);
            }
            com.facebook.common.internal.g.checkState(af.type == ".cnt");
            return true;
        }

        private boolean am(File file) {
            return file.lastModified() > DefaultDiskStorage.this.ntR.now() - DefaultDiskStorage.ntM;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void dRV() {
        com.facebook.common.file.a.a(this.ntN, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.ap(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.ntQ.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, ntL, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b B(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File UN = UN(cVar.resourceId);
        if (!UN.exists()) {
            i(UN, "insert");
        }
        try {
            return new d(str, cVar.aj(UN));
        } catch (IOException e2) {
            this.ntQ.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, ntL, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a C(String str, Object obj) {
        File UL = UL(str);
        if (UL.exists()) {
            UL.setLastModified(this.ntR.now());
            return com.facebook.a.b.ad(UL);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.UR(UM(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean D(String str, Object obj) {
        return ba(str, false);
    }

    private boolean ba(String str, boolean z) {
        File UL = UL(str);
        boolean exists = UL.exists();
        if (z && exists) {
            UL.setLastModified(this.ntR.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ae(((b) aVar).dRY().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long UO(String str) {
        return ae(UL(str));
    }

    private long ae(File file) {
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
    public List<c.a> dRW() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.ntP, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes12.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b ntT;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.ntT = com.facebook.a.b.ad(file);
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
                this.timestamp = this.ntT.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dRY() {
            return this.ntT;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.ntT.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c af(File file) {
        c ak = c.ak(file);
        if (ak == null) {
            return null;
        }
        if (!UN(ak.resourceId).equals(file.getParentFile())) {
            ak = null;
        }
        return ak;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String UP(String str) {
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

        public String UR(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File aj(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ak(File file) {
            String UP;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (UP = DefaultDiskStorage.UP(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (UP.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(UP, substring);
            }
            return null;
        }
    }

    /* loaded from: classes12.dex */
    class d implements c.b {
        private final String lCn;
        final File ntU;

        public d(String str, File file) {
            this.lCn = str;
            this.ntU = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.ntU);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.ntU.length() != count) {
                        throw new IncompleteFileException(count, this.ntU.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.ntQ.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.ntL, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aQ(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File UL = DefaultDiskStorage.this.UL(this.lCn);
            try {
                FileUtils.rename(this.ntU, UL);
                if (UL.exists()) {
                    UL.setLastModified(DefaultDiskStorage.this.ntR.now());
                }
                return com.facebook.a.b.ad(UL);
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
                DefaultDiskStorage.this.ntQ.a(cacheErrorCategory, DefaultDiskStorage.ntL, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dRZ() {
            return !this.ntU.exists() || this.ntU.delete();
        }
    }
}
