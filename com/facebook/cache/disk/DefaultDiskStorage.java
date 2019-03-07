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
    private static final Class<?> jyv = DefaultDiskStorage.class;
    static final long jyw = TimeUnit.MINUTES.toMillis(30);
    private final CacheErrorLogger jyA;
    private final com.facebook.common.time.a jyB;
    private final File jyx;
    private final boolean jyy;
    private final File jyz;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jyx = file;
        this.jyy = a(file, cacheErrorLogger);
        this.jyz = new File(this.jyx, BS(i));
        this.jyA = cacheErrorLogger;
        csQ();
        this.jyB = com.facebook.common.time.b.ctY();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jyv, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jyv, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String BS(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jyy;
    }

    private void csQ() {
        boolean z = true;
        if (this.jyx.exists()) {
            if (this.jyz.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.al(this.jyx);
            }
        }
        if (z) {
            try {
                FileUtils.am(this.jyz);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jyA.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyv, "version directory could not be created: " + this.jyz, null);
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

    File Fr(String str) {
        return new File(Fu(str));
    }

    private String Fs(String str) {
        return this.jyz + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Ft(String str) {
        return new File(Fs(str));
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
            if (ac != null && ac.jyE == FileType.CONTENT) {
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
        private boolean jyH;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            if (!this.jyH && file.equals(DefaultDiskStorage.this.jyz)) {
                this.jyH = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            if (!this.jyH || !ai(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
            if (!DefaultDiskStorage.this.jyx.equals(file) && !this.jyH) {
                file.delete();
            }
            if (this.jyH && file.equals(DefaultDiskStorage.this.jyz)) {
                this.jyH = false;
            }
        }

        private boolean ai(File file) {
            c ac = DefaultDiskStorage.this.ac(file);
            if (ac == null) {
                return false;
            }
            if (ac.jyE == FileType.TEMP) {
                return aj(file);
            }
            com.facebook.common.internal.g.checkState(ac.jyE == FileType.CONTENT);
            return true;
        }

        private boolean aj(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jyB.now() - DefaultDiskStorage.jyw;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void csR() {
        com.facebook.common.file.a.a(this.jyx, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.am(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jyA.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyv, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File Ft = Ft(cVar.resourceId);
        if (!Ft.exists()) {
            i(Ft, "insert");
        }
        try {
            return new d(str, cVar.ag(Ft));
        } catch (IOException e2) {
            this.jyA.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jyv, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) {
        File Fr = Fr(str);
        if (Fr.exists()) {
            Fr.setLastModified(this.jyB.now());
            return com.facebook.a.b.aa(Fr);
        }
        return null;
    }

    private String Fu(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.Fv(Fs(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) {
        return aw(str, false);
    }

    private boolean aw(String str, boolean z) {
        File Fr = Fr(str);
        boolean exists = Fr.exists();
        if (z && exists) {
            Fr.setLastModified(this.jyB.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ab(((b) aVar).csU().getFile());
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
    public List<c.a> csS() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.jyz, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jyD;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jyD = com.facebook.a.b.aa(file);
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
                this.timestamp = this.jyD.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b csU() {
            return this.jyD;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jyD.size();
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
        if (!Ft(ah.resourceId).equals(file.getParentFile())) {
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
        public final FileType jyE;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jyE = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jyE + "(" + this.resourceId + ")";
        }

        public String Fv(String str) {
            return str + File.separator + this.resourceId + this.jyE.extension;
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
        private final String jyF;
        final File jyG;

        public d(String str, File file) {
            this.jyF = str;
            this.jyG = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jyG);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jyG.length() != count) {
                        throw new IncompleteFileException(count, this.jyG.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jyA.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jyv, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aB(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Fr = DefaultDiskStorage.this.Fr(this.jyF);
            try {
                FileUtils.rename(this.jyG, Fr);
                if (Fr.exists()) {
                    Fr.setLastModified(DefaultDiskStorage.this.jyB.now());
                }
                return com.facebook.a.b.aa(Fr);
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
                DefaultDiskStorage.this.jyA.a(cacheErrorCategory, DefaultDiskStorage.jyv, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean csV() {
            return !this.jyG.exists() || this.jyG.delete();
        }
    }
}
