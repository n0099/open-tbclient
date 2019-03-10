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
    private static final Class<?> jyO = DefaultDiskStorage.class;
    static final long jyP = TimeUnit.MINUTES.toMillis(30);
    private final File jyQ;
    private final boolean jyR;
    private final File jyS;
    private final CacheErrorLogger jyT;
    private final com.facebook.common.time.a jyU;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jyQ = file;
        this.jyR = a(file, cacheErrorLogger);
        this.jyS = new File(this.jyQ, BT(i));
        this.jyT = cacheErrorLogger;
        cta();
        this.jyU = com.facebook.common.time.b.cui();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jyO, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jyO, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String BT(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jyR;
    }

    private void cta() {
        boolean z = true;
        if (this.jyQ.exists()) {
            if (this.jyS.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.al(this.jyQ);
            }
        }
        if (z) {
            try {
                FileUtils.am(this.jyS);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jyT.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyO, "version directory could not be created: " + this.jyS, null);
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

    File Fu(String str) {
        return new File(Fx(str));
    }

    private String Fv(String str) {
        return this.jyS + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Fw(String str) {
        return new File(Fv(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> bbN;

        private a() {
            this.bbN = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            c ac = DefaultDiskStorage.this.ac(file);
            if (ac != null && ac.jyX == FileType.CONTENT) {
                this.bbN.add(new b(ac.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.bbN);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean jza;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            if (!this.jza && file.equals(DefaultDiskStorage.this.jyS)) {
                this.jza = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            if (!this.jza || !ai(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
            if (!DefaultDiskStorage.this.jyQ.equals(file) && !this.jza) {
                file.delete();
            }
            if (this.jza && file.equals(DefaultDiskStorage.this.jyS)) {
                this.jza = false;
            }
        }

        private boolean ai(File file) {
            c ac = DefaultDiskStorage.this.ac(file);
            if (ac == null) {
                return false;
            }
            if (ac.jyX == FileType.TEMP) {
                return aj(file);
            }
            com.facebook.common.internal.g.checkState(ac.jyX == FileType.CONTENT);
            return true;
        }

        private boolean aj(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jyU.now() - DefaultDiskStorage.jyP;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void ctb() {
        com.facebook.common.file.a.a(this.jyQ, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.am(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jyT.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyO, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File Fw = Fw(cVar.resourceId);
        if (!Fw.exists()) {
            i(Fw, "insert");
        }
        try {
            return new d(str, cVar.ag(Fw));
        } catch (IOException e2) {
            this.jyT.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jyO, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) {
        File Fu = Fu(str);
        if (Fu.exists()) {
            Fu.setLastModified(this.jyU.now());
            return com.facebook.a.b.aa(Fu);
        }
        return null;
    }

    private String Fx(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.Fy(Fv(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) {
        return ax(str, false);
    }

    private boolean ax(String str, boolean z) {
        File Fu = Fu(str);
        boolean exists = Fu.exists();
        if (z && exists) {
            Fu.setLastModified(this.jyU.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ab(((b) aVar).cte().getFile());
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
    public List<c.a> ctc() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.jyS, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jyW;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jyW = com.facebook.a.b.aa(file);
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
                this.timestamp = this.jyW.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cte() {
            return this.jyW;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jyW.size();
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
        if (!Fw(ah.resourceId).equals(file.getParentFile())) {
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
        public final FileType jyX;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jyX = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jyX + "(" + this.resourceId + ")";
        }

        public String Fy(String str) {
            return str + File.separator + this.resourceId + this.jyX.extension;
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
        private final String jyY;
        final File jyZ;

        public d(String str, File file) {
            this.jyY = str;
            this.jyZ = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jyZ);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jyZ.length() != count) {
                        throw new IncompleteFileException(count, this.jyZ.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jyT.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jyO, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aC(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Fu = DefaultDiskStorage.this.Fu(this.jyY);
            try {
                FileUtils.rename(this.jyZ, Fu);
                if (Fu.exists()) {
                    Fu.setLastModified(DefaultDiskStorage.this.jyU.now());
                }
                return com.facebook.a.b.aa(Fu);
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
                DefaultDiskStorage.this.jyT.a(cacheErrorCategory, DefaultDiskStorage.jyO, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean ctf() {
            return !this.jyZ.exists() || this.jyZ.delete();
        }
    }
}
