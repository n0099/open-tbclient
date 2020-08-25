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
/* loaded from: classes8.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> nju = DefaultDiskStorage.class;
    static final long njv = TimeUnit.MINUTES.toMillis(30);
    private final com.facebook.common.time.a njA;
    private final File njw;
    private final boolean njx;
    private final File njy;
    private final CacheErrorLogger njz;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.njw = file;
        this.njx = a(file, cacheErrorLogger);
        this.njy = new File(this.njw, KS(i));
        this.njz = cacheErrorLogger;
        dNN();
        this.njA = com.facebook.common.time.c.dOT();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, nju, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, nju, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String KS(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.njx;
    }

    private void dNN() {
        boolean z = true;
        if (this.njw.exists()) {
            if (this.njy.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.ao(this.njw);
            }
        }
        if (z) {
            try {
                FileUtils.ap(this.njy);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.njz.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, nju, "version directory could not be created: " + this.njy, null);
            }
        }
    }

    /* loaded from: classes8.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File Uj(String str) {
        return new File(getFilename(str));
    }

    private String Uk(String str) {
        return this.njy + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Ul(String str) {
        return new File(Uk(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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

    /* loaded from: classes8.dex */
    private class e implements com.facebook.common.file.b {
        private boolean njE;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ag(File file) {
            if (!this.njE && file.equals(DefaultDiskStorage.this.njy)) {
                this.njE = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ah(File file) {
            if (!this.njE || !al(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void ai(File file) {
            if (!DefaultDiskStorage.this.njw.equals(file) && !this.njE) {
                file.delete();
            }
            if (this.njE && file.equals(DefaultDiskStorage.this.njy)) {
                this.njE = false;
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
            return file.lastModified() > DefaultDiskStorage.this.njA.now() - DefaultDiskStorage.njv;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void dNO() {
        com.facebook.common.file.a.a(this.njw, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.ap(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.njz.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, nju, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b B(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Ul = Ul(cVar.resourceId);
        if (!Ul.exists()) {
            i(Ul, "insert");
        }
        try {
            return new d(str, cVar.aj(Ul));
        } catch (IOException e2) {
            this.njz.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, nju, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a C(String str, Object obj) {
        File Uj = Uj(str);
        if (Uj.exists()) {
            Uj.setLastModified(this.njA.now());
            return com.facebook.a.b.ad(Uj);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Up(Uk(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean D(String str, Object obj) {
        return aZ(str, false);
    }

    private boolean aZ(String str, boolean z) {
        File Uj = Uj(str);
        boolean exists = Uj.exists();
        if (z && exists) {
            Uj.setLastModified(this.njA.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ae(((b) aVar).dNR().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Um(String str) {
        return ae(Uj(str));
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
    public List<c.a> dNP() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.njy, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes8.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b njC;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.njC = com.facebook.a.b.ad(file);
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
                this.timestamp = this.njC.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b dNR() {
            return this.njC;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.njC.size();
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
        if (!Ul(ak.resourceId).equals(file.getParentFile())) {
            ak = null;
        }
        return ak;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Un(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
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

        public String Up(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File aj(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ak(File file) {
            String Un;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Un = DefaultDiskStorage.Un(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Un.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Un, substring);
            }
            return null;
        }
    }

    /* loaded from: classes8.dex */
    class d implements c.b {
        private final String ltk;
        final File njD;

        public d(String str, File file) {
            this.ltk = str;
            this.njD = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.njD);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.njD.length() != count) {
                        throw new IncompleteFileException(count, this.njD.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.njz.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.nju, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aO(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Uj = DefaultDiskStorage.this.Uj(this.ltk);
            try {
                FileUtils.rename(this.njD, Uj);
                if (Uj.exists()) {
                    Uj.setLastModified(DefaultDiskStorage.this.njA.now());
                }
                return com.facebook.a.b.ad(Uj);
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
                DefaultDiskStorage.this.njz.a(cacheErrorCategory, DefaultDiskStorage.nju, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean dNS() {
            return !this.njD.exists() || this.njD.delete();
        }
    }
}
