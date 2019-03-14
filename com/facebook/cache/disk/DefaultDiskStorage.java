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
/* loaded from: classes2.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> jyG = DefaultDiskStorage.class;
    static final long jyH = TimeUnit.MINUTES.toMillis(30);
    private final File jyI;
    private final boolean jyJ;
    private final File jyK;
    private final CacheErrorLogger jyL;
    private final com.facebook.common.time.a jyM;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jyI = file;
        this.jyJ = a(file, cacheErrorLogger);
        this.jyK = new File(this.jyI, BT(i));
        this.jyL = cacheErrorLogger;
        ctd();
        this.jyM = com.facebook.common.time.b.cul();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jyG, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jyG, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String BT(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jyJ;
    }

    private void ctd() {
        boolean z = true;
        if (this.jyI.exists()) {
            if (this.jyK.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.al(this.jyI);
            }
        }
        if (z) {
            try {
                FileUtils.am(this.jyK);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jyL.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyG, "version directory could not be created: " + this.jyK, null);
            }
        }
    }

    /* loaded from: classes2.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File Fs(String str) {
        return new File(Fv(str));
    }

    private String Ft(String str) {
        return this.jyK + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Fu(String str) {
        return new File(Ft(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> bbO;

        private a() {
            this.bbO = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            c ac = DefaultDiskStorage.this.ac(file);
            if (ac != null && ac.jyP == FileType.CONTENT) {
                this.bbO.add(new b(ac.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.bbO);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean jyS;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            if (!this.jyS && file.equals(DefaultDiskStorage.this.jyK)) {
                this.jyS = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            if (!this.jyS || !ai(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
            if (!DefaultDiskStorage.this.jyI.equals(file) && !this.jyS) {
                file.delete();
            }
            if (this.jyS && file.equals(DefaultDiskStorage.this.jyK)) {
                this.jyS = false;
            }
        }

        private boolean ai(File file) {
            c ac = DefaultDiskStorage.this.ac(file);
            if (ac == null) {
                return false;
            }
            if (ac.jyP == FileType.TEMP) {
                return aj(file);
            }
            com.facebook.common.internal.g.checkState(ac.jyP == FileType.CONTENT);
            return true;
        }

        private boolean aj(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jyM.now() - DefaultDiskStorage.jyH;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void cte() {
        com.facebook.common.file.a.a(this.jyI, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.am(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jyL.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyG, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File Fu = Fu(cVar.resourceId);
        if (!Fu.exists()) {
            i(Fu, "insert");
        }
        try {
            return new d(str, cVar.ag(Fu));
        } catch (IOException e2) {
            this.jyL.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jyG, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) {
        File Fs = Fs(str);
        if (Fs.exists()) {
            Fs.setLastModified(this.jyM.now());
            return com.facebook.a.b.aa(Fs);
        }
        return null;
    }

    private String Fv(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.Fw(Ft(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) {
        return ax(str, false);
    }

    private boolean ax(String str, boolean z) {
        File Fs = Fs(str);
        boolean exists = Fs.exists();
        if (z && exists) {
            Fs.setLastModified(this.jyM.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ab(((b) aVar).cth().getFile());
    }

    private long ab(File file) {
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
    public List<c.a> ctf() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.jyK, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jyO;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jyO = com.facebook.a.b.aa(file);
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
                this.timestamp = this.jyO.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cth() {
            return this.jyO;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jyO.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c ac(File file) {
        c ah = c.ah(file);
        if (ah == null) {
            return null;
        }
        if (!Fu(ah.resourceId).equals(file.getParentFile())) {
            ah = null;
        }
        return ah;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public enum FileType {
        CONTENT(".cnt"),
        TEMP(".tmp");
        
        public final String extension;

        FileType(String str) {
            this.extension = str;
        }

        public static FileType fromExtension(String str) {
            if (".cnt".equals(str)) {
                return CONTENT;
            }
            if (".tmp".equals(str)) {
                return TEMP;
            }
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class c {
        public final FileType jyP;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jyP = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jyP + "(" + this.resourceId + ")";
        }

        public String Fw(String str) {
            return str + File.separator + this.resourceId + this.jyP.extension;
        }

        public File ag(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ah(File file) {
            FileType fromExtension;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (fromExtension = FileType.fromExtension(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (fromExtension.equals(FileType.TEMP)) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(fromExtension, substring);
            }
            return null;
        }
    }

    /* loaded from: classes2.dex */
    class d implements c.b {
        private final String jyQ;
        final File jyR;

        public d(String str, File file) {
            this.jyQ = str;
            this.jyR = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jyR);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jyR.length() != count) {
                        throw new IncompleteFileException(count, this.jyR.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jyL.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jyG, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aC(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Fs = DefaultDiskStorage.this.Fs(this.jyQ);
            try {
                FileUtils.rename(this.jyR, Fs);
                if (Fs.exists()) {
                    Fs.setLastModified(DefaultDiskStorage.this.jyM.now());
                }
                return com.facebook.a.b.aa(Fs);
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
                DefaultDiskStorage.this.jyL.a(cacheErrorCategory, DefaultDiskStorage.jyG, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean cti() {
            return !this.jyR.exists() || this.jyR.delete();
        }
    }
}
