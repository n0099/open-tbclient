package com.facebook.cache.disk;

import android.os.Environment;
import com.baidu.android.imsdk.internal.DefaultConfig;
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
    private static final Class<?> jYW = DefaultDiskStorage.class;
    static final long jYX = TimeUnit.MINUTES.toMillis(30);
    private final File jYY;
    private final boolean jYZ;
    private final File jZa;
    private final CacheErrorLogger jZb;
    private final com.facebook.common.time.a jZc;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jYY = file;
        this.jYZ = a(file, cacheErrorLogger);
        this.jZa = new File(this.jYY, BV(i));
        this.jZb = cacheErrorLogger;
        cCa();
        this.jZc = com.facebook.common.time.b.cDh();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jYW, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jYW, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String BV(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jYZ;
    }

    private void cCa() {
        boolean z = true;
        if (this.jYY.exists()) {
            if (this.jZa.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.R(this.jYY);
            }
        }
        if (z) {
            try {
                FileUtils.S(this.jZa);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jZb.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jYW, "version directory could not be created: " + this.jZa, null);
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

    File Gr(String str) {
        return new File(Gu(str));
    }

    private String Gs(String str) {
        return this.jZa + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Gt(String str) {
        return new File(Gs(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void J(File file) {
        }

        @Override // com.facebook.common.file.b
        public void K(File file) {
            c I = DefaultDiskStorage.this.I(file);
            if (I != null && I.jZf == FileType.CONTENT) {
                this.result.add(new b(I.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void L(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean jZh;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void J(File file) {
            if (!this.jZh && file.equals(DefaultDiskStorage.this.jZa)) {
                this.jZh = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void K(File file) {
            if (!this.jZh || !O(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void L(File file) {
            if (!DefaultDiskStorage.this.jYY.equals(file) && !this.jZh) {
                file.delete();
            }
            if (this.jZh && file.equals(DefaultDiskStorage.this.jZa)) {
                this.jZh = false;
            }
        }

        private boolean O(File file) {
            c I = DefaultDiskStorage.this.I(file);
            if (I == null) {
                return false;
            }
            if (I.jZf == FileType.TEMP) {
                return P(file);
            }
            com.facebook.common.internal.g.checkState(I.jZf == FileType.CONTENT);
            return true;
        }

        private boolean P(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jZc.now() - DefaultDiskStorage.jYX;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void cCb() {
        com.facebook.common.file.a.a(this.jYY, new e());
    }

    private void e(File file, String str) throws IOException {
        try {
            FileUtils.S(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jZb.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jYW, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File Gt = Gt(cVar.resourceId);
        if (!Gt.exists()) {
            e(Gt, "insert");
        }
        try {
            return new d(str, cVar.M(Gt));
        } catch (IOException e2) {
            this.jZb.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jYW, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) {
        File Gr = Gr(str);
        if (Gr.exists()) {
            Gr.setLastModified(this.jZc.now());
            return com.facebook.a.b.G(Gr);
        }
        return null;
    }

    private String Gu(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.Gv(Gs(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) {
        return ay(str, false);
    }

    private boolean ay(String str, boolean z) {
        File Gr = Gr(str);
        boolean exists = Gr.exists();
        if (z && exists) {
            Gr.setLastModified(this.jZc.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return H(((b) aVar).cCe().getFile());
    }

    private long H(File file) {
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
    public List<c.a> cCc() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.jZa, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jZe;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jZe = com.facebook.a.b.G(file);
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
                this.timestamp = this.jZe.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cCe() {
            return this.jZe;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jZe.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c I(File file) {
        c N = c.N(file);
        if (N == null) {
            return null;
        }
        if (!Gt(N.resourceId).equals(file.getParentFile())) {
            N = null;
        }
        return N;
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
        public final FileType jZf;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jZf = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jZf + "(" + this.resourceId + ")";
        }

        public String Gv(String str) {
            return str + File.separator + this.resourceId + this.jZf.extension;
        }

        public File M(File file) throws IOException {
            return File.createTempFile(this.resourceId + DefaultConfig.TOKEN_SEPARATOR, ".tmp", file);
        }

        @Nullable
        public static c N(File file) {
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
        private final String iyq;
        final File jZg;

        public d(String str, File file) {
            this.iyq = str;
            this.jZg = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jZg);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jZg.length() != count) {
                        throw new IncompleteFileException(count, this.jZg.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jZb.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jYW, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a av(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Gr = DefaultDiskStorage.this.Gr(this.iyq);
            try {
                FileUtils.rename(this.jZg, Gr);
                if (Gr.exists()) {
                    Gr.setLastModified(DefaultDiskStorage.this.jZc.now());
                }
                return com.facebook.a.b.G(Gr);
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
                DefaultDiskStorage.this.jZb.a(cacheErrorCategory, DefaultDiskStorage.jYW, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean cCf() {
            return !this.jZg.exists() || this.jZg.delete();
        }
    }
}
