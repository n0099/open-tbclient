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
    private static final Class<?> jya = DefaultDiskStorage.class;
    static final long jyb = TimeUnit.MINUTES.toMillis(30);
    private final File jyc;
    private final boolean jyd;
    private final File jye;
    private final CacheErrorLogger jyf;
    private final com.facebook.common.time.a jyg;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jyc = file;
        this.jyd = a(file, cacheErrorLogger);
        this.jye = new File(this.jyc, BJ(i));
        this.jyf = cacheErrorLogger;
        csW();
        this.jyg = com.facebook.common.time.b.cue();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jya, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jya, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String BJ(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jyd;
    }

    private void csW() {
        boolean z = true;
        if (this.jyc.exists()) {
            if (this.jye.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.al(this.jyc);
            }
        }
        if (z) {
            try {
                FileUtils.am(this.jye);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jyf.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jya, "version directory could not be created: " + this.jye, null);
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
        return this.jye + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Fk(String str) {
        return new File(Fj(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> bbR;

        private a() {
            this.bbR = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            c ac = DefaultDiskStorage.this.ac(file);
            if (ac != null && ac.jyj == FileType.CONTENT) {
                this.bbR.add(new b(ac.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.bbR);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean jym;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ad(File file) {
            if (!this.jym && file.equals(DefaultDiskStorage.this.jye)) {
                this.jym = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ae(File file) {
            if (!this.jym || !ai(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void af(File file) {
            if (!DefaultDiskStorage.this.jyc.equals(file) && !this.jym) {
                file.delete();
            }
            if (this.jym && file.equals(DefaultDiskStorage.this.jye)) {
                this.jym = false;
            }
        }

        private boolean ai(File file) {
            c ac = DefaultDiskStorage.this.ac(file);
            if (ac == null) {
                return false;
            }
            if (ac.jyj == FileType.TEMP) {
                return aj(file);
            }
            com.facebook.common.internal.g.checkState(ac.jyj == FileType.CONTENT);
            return true;
        }

        private boolean aj(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jyg.now() - DefaultDiskStorage.jyb;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void csX() {
        com.facebook.common.file.a.a(this.jyc, new e());
    }

    private void i(File file, String str) throws IOException {
        try {
            FileUtils.am(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jyf.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jya, str, e2);
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
            this.jyf.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jya, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) {
        File Fi = Fi(str);
        if (Fi.exists()) {
            Fi.setLastModified(this.jyg.now());
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
            Fi.setLastModified(this.jyg.now());
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
        com.facebook.common.file.a.a(this.jye, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jyi;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jyi = com.facebook.a.b.aa(file);
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
                this.timestamp = this.jyi.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cta() {
            return this.jyi;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jyi.size();
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
        public final FileType jyj;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jyj = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jyj + "(" + this.resourceId + ")";
        }

        public String Fm(String str) {
            return str + File.separator + this.resourceId + this.jyj.extension;
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
        private final String jyk;
        final File jyl;

        public d(String str, File file) {
            this.jyk = str;
            this.jyl = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jyl);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jyl.length() != count) {
                        throw new IncompleteFileException(count, this.jyl.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jyf.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jya, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a ay(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Fi = DefaultDiskStorage.this.Fi(this.jyk);
            try {
                FileUtils.rename(this.jyl, Fi);
                if (Fi.exists()) {
                    Fi.setLastModified(DefaultDiskStorage.this.jyg.now());
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
                DefaultDiskStorage.this.jyf.a(cacheErrorCategory, DefaultDiskStorage.jya, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean ctb() {
            return !this.jyl.exists() || this.jyl.delete();
        }
    }
}
