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
/* loaded from: classes17.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> oLv = DefaultDiskStorage.class;
    static final long oLw = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger oLA;
    private final com.facebook.common.time.a oLB;
    private final File oLx;
    private final boolean oLy;
    private final File oLz;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.oLx = file;
        this.oLy = a(file, cacheErrorLogger);
        this.oLz = new File(this.oLx, OS(i));
        this.oLA = cacheErrorLogger;
        ejq();
        this.oLB = com.facebook.common.time.c.ekw();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, oLv, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, oLv, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String OS(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.oLy;
    }

    private void ejq() {
        boolean z = true;
        if (this.oLx.exists()) {
            if (this.oLz.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.as(this.oLx);
            }
        }
        if (z) {
            try {
                FileUtils.at(this.oLz);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.oLA.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, oLv, "version directory could not be created: " + this.oLz, null);
            }
        }
    }

    /* loaded from: classes17.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File XB(String str) {
        return new File(getFilename(str));
    }

    private String XC(String str) {
        return this.oLz + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File XD(String str) {
        return new File(XC(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
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

    /* loaded from: classes17.dex */
    private class e implements com.facebook.common.file.b {
        private boolean oLF;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ak(File file) {
            if (!this.oLF && file.equals(DefaultDiskStorage.this.oLz)) {
                this.oLF = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void al(File file) {
            if (!this.oLF || !ap(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void am(File file) {
            if (!DefaultDiskStorage.this.oLx.equals(file) && !this.oLF) {
                file.delete();
            }
            if (this.oLF && file.equals(DefaultDiskStorage.this.oLz)) {
                this.oLF = false;
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
            return file.lastModified() > DefaultDiskStorage.this.oLB.now() - DefaultDiskStorage.oLw;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void ejr() {
        com.facebook.common.file.a.a(this.oLx, new e());
    }

    private void j(File file, String str) throws IOException {
        try {
            FileUtils.at(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.oLA.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, oLv, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File XD = XD(cVar.resourceId);
        if (!XD.exists()) {
            j(XD, "insert");
        }
        try {
            return new d(str, cVar.an(XD));
        } catch (IOException e2) {
            this.oLA.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, oLv, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) {
        File XB = XB(str);
        if (XB.exists()) {
            XB.setLastModified(this.oLB.now());
            return com.facebook.a.b.ah(XB);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.XH(XC(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) {
        return bm(str, false);
    }

    private boolean bm(String str, boolean z) {
        File XB = XB(str);
        boolean exists = XB.exists();
        if (z && exists) {
            XB.setLastModified(this.oLB.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ai(((b) aVar).eju().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long XE(String str) {
        return ai(XB(str));
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
    public List<c.a> ejs() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.oLz, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes17.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b oLD;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.oLD = com.facebook.a.b.ah(file);
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
                this.timestamp = this.oLD.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b eju() {
            return this.oLD;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.oLD.size();
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
        if (!XD(ao.resourceId).equals(file.getParentFile())) {
            ao = null;
        }
        return ao;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String XF(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes17.dex */
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

        public String XH(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File an(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ao(File file) {
            String XF;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (XF = DefaultDiskStorage.XF(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (XF.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(XF, substring);
            }
            return null;
        }
    }

    /* loaded from: classes17.dex */
    class d implements c.b {
        private final String mks;
        final File oLE;

        public d(String str, File file) {
            this.mks = str;
            this.oLE = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.oLE);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.oLE.length() != count) {
                        throw new IncompleteFileException(count, this.oLE.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.oLA.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.oLv, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aY(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File XB = DefaultDiskStorage.this.XB(this.mks);
            try {
                FileUtils.rename(this.oLE, XB);
                if (XB.exists()) {
                    XB.setLastModified(DefaultDiskStorage.this.oLB.now());
                }
                return com.facebook.a.b.ah(XB);
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
                DefaultDiskStorage.this.oLA.a(cacheErrorCategory, DefaultDiskStorage.oLv, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean ejv() {
            return !this.oLE.exists() || this.oLE.delete();
        }
    }
}
