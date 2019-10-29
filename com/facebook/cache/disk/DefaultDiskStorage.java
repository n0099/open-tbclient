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
    private static final Class<?> jZN = DefaultDiskStorage.class;
    static final long jZO = TimeUnit.MINUTES.toMillis(30);
    private final File jZP;
    private final boolean jZQ;
    private final File jZR;
    private final CacheErrorLogger jZS;
    private final com.facebook.common.time.a jZT;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.jZP = file;
        this.jZQ = a(file, cacheErrorLogger);
        this.jZR = new File(this.jZP, BW(i));
        this.jZS = cacheErrorLogger;
        cCc();
        this.jZT = com.facebook.common.time.b.cDj();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jZN, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, jZN, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String BW(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.jZQ;
    }

    private void cCc() {
        boolean z = true;
        if (this.jZP.exists()) {
            if (this.jZR.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.R(this.jZP);
            }
        }
        if (z) {
            try {
                FileUtils.S(this.jZR);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.jZS.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jZN, "version directory could not be created: " + this.jZR, null);
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
        return this.jZR + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
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
            if (I != null && I.jZW == FileType.CONTENT) {
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
        private boolean jZY;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void J(File file) {
            if (!this.jZY && file.equals(DefaultDiskStorage.this.jZR)) {
                this.jZY = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void K(File file) {
            if (!this.jZY || !O(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void L(File file) {
            if (!DefaultDiskStorage.this.jZP.equals(file) && !this.jZY) {
                file.delete();
            }
            if (this.jZY && file.equals(DefaultDiskStorage.this.jZR)) {
                this.jZY = false;
            }
        }

        private boolean O(File file) {
            c I = DefaultDiskStorage.this.I(file);
            if (I == null) {
                return false;
            }
            if (I.jZW == FileType.TEMP) {
                return P(file);
            }
            com.facebook.common.internal.g.checkState(I.jZW == FileType.CONTENT);
            return true;
        }

        private boolean P(File file) {
            return file.lastModified() > DefaultDiskStorage.this.jZT.now() - DefaultDiskStorage.jZO;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void cCd() {
        com.facebook.common.file.a.a(this.jZP, new e());
    }

    private void e(File file, String str) throws IOException {
        try {
            FileUtils.S(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.jZS.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jZN, str, e2);
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
            this.jZS.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, jZN, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) {
        File Gr = Gr(str);
        if (Gr.exists()) {
            Gr.setLastModified(this.jZT.now());
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
            Gr.setLastModified(this.jZT.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return H(((b) aVar).cCg().getFile());
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
    public List<c.a> cCe() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.jZR, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b jZV;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.jZV = com.facebook.a.b.G(file);
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
                this.timestamp = this.jZV.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cCg() {
            return this.jZV;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.jZV.size();
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
        public final FileType jZW;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.jZW = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.jZW + "(" + this.resourceId + ")";
        }

        public String Gv(String str) {
            return str + File.separator + this.resourceId + this.jZW.extension;
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
        private final String izh;
        final File jZX;

        public d(String str, File file) {
            this.izh = str;
            this.jZX = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.jZX);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.jZX.length() != count) {
                        throw new IncompleteFileException(count, this.jZX.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.jZS.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.jZN, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a av(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Gr = DefaultDiskStorage.this.Gr(this.izh);
            try {
                FileUtils.rename(this.jZX, Gr);
                if (Gr.exists()) {
                    Gr.setLastModified(DefaultDiskStorage.this.jZT.now());
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
                DefaultDiskStorage.this.jZS.a(cacheErrorCategory, DefaultDiskStorage.jZN, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean cCh() {
            return !this.jZX.exists() || this.jZX.delete();
        }
    }
}
