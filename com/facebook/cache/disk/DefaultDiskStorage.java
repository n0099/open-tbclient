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
    private static final Class<?> jyb = DefaultDiskStorage.class;
    static final long jyc = TimeUnit.MINUTES.toMillis(30);
    private final File jyd;
    private final boolean jye;
    private final File jyf;
    private final CacheErrorLogger jyg;
    private final com.facebook.common.time.a jyh;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jyd = file;
        this.jye = a(file, cacheErrorLogger);
        this.jyf = new File(this.jyd, BJ(i));
        this.jyg = cacheErrorLogger;
        csW();
        this.jyh = com.facebook.common.time.b.cue();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jyb, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jyb, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String BJ(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jye;
    }

    private void csW() {
        boolean z = true;
        if (this.jyd.exists()) {
            if (this.jyf.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.al(this.jyd);
            }
        }
        if (z) {
            try {
                FileUtils.am(this.jyf);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jyg.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyb, "version directory could not be created: " + this.jyf, null);
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

    File Fi(String str) {
        return new File(Fl(str));
    }

    private String Fj(String str) {
        return this.jyf + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Fk(String str) {
        return new File(Fj(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> bbS;

        private a() {
            this.bbS = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            c ac = DefaultDiskStorage.this.ac(file);
            if (ac != null && ac.jyk == FileType.CONTENT) {
                this.bbS.add(new b(ac.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.bbS);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean jyn;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            if (!this.jyn && file.equals(DefaultDiskStorage.this.jyf)) {
                this.jyn = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            if (!this.jyn || !ai(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
            if (!DefaultDiskStorage.this.jyd.equals(file) && !this.jyn) {
                file.delete();
            }
            if (this.jyn && file.equals(DefaultDiskStorage.this.jyf)) {
                this.jyn = false;
            }
        }

        private boolean ai(File file) {
            c ac = DefaultDiskStorage.this.ac(file);
            if (ac == null) {
                return false;
            }
            if (ac.jyk == FileType.TEMP) {
                return aj(file);
            }
            com.facebook.common.internal.g.checkState(ac.jyk == FileType.CONTENT);
            return true;
        }

        private boolean aj(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jyh.now() - DefaultDiskStorage.jyc;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void csX() {
        com.facebook.common.file.a.a(this.jyd, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.am(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jyg.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyb, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File Fk = Fk(cVar.resourceId);
        if (!Fk.exists()) {
            i(Fk, "insert");
        }
        try {
            return new d(str, cVar.ag(Fk));
        } catch (IOException e2) {
            this.jyg.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jyb, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) {
        File Fi = Fi(str);
        if (Fi.exists()) {
            Fi.setLastModified(this.jyh.now());
            return com.facebook.a.b.aa(Fi);
        }
        return null;
    }

    private String Fl(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.Fm(Fj(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) {
        return ax(str, false);
    }

    private boolean ax(String str, boolean z) {
        File Fi = Fi(str);
        boolean exists = Fi.exists();
        if (z && exists) {
            Fi.setLastModified(this.jyh.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return ab(((b) aVar).cta().getFile());
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
    public List<c.a> csY() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.jyf, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jyj;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jyj = com.facebook.a.b.aa(file);
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
                this.timestamp = this.jyj.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cta() {
            return this.jyj;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jyj.size();
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
        if (!Fk(ah.resourceId).equals(file.getParentFile())) {
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
        public final FileType jyk;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jyk = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jyk + "(" + this.resourceId + ")";
        }

        public String Fm(String str) {
            return str + File.separator + this.resourceId + this.jyk.extension;
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
        private final String jyl;
        final File jym;

        public d(String str, File file) {
            this.jyl = str;
            this.jym = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jym);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jym.length() != count) {
                        throw new IncompleteFileException(count, this.jym.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jyg.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jyb, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a ay(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Fi = DefaultDiskStorage.this.Fi(this.jyl);
            try {
                FileUtils.rename(this.jym, Fi);
                if (Fi.exists()) {
                    Fi.setLastModified(DefaultDiskStorage.this.jyh.now());
                }
                return com.facebook.a.b.aa(Fi);
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
                DefaultDiskStorage.this.jyg.a(cacheErrorCategory, DefaultDiskStorage.jyb, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean ctb() {
            return !this.jym.exists() || this.jym.delete();
        }
    }
}
