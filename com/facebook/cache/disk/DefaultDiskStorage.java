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
    private static final Class<?> kbD = DefaultDiskStorage.class;
    static final long kbE = TimeUnit.MINUTES.toMillis(30);
    private final File kbF;
    private final boolean kbG;
    private final File kbH;
    private final CacheErrorLogger kbI;
    private final com.facebook.common.time.a kbJ;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.kbF = file;
        this.kbG = a(file, cacheErrorLogger);
        this.kbH = new File(this.kbF, DA(i));
        this.kbI = cacheErrorLogger;
        cFe();
        this.kbJ = com.facebook.common.time.b.cGl();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, kbD, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, kbD, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String DA(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.kbG;
    }

    private void cFe() {
        boolean z = true;
        if (this.kbF.exists()) {
            if (this.kbH.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.af(this.kbF);
            }
        }
        if (z) {
            try {
                FileUtils.ag(this.kbH);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.kbI.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, kbD, "version directory could not be created: " + this.kbH, null);
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

    File Ia(String str) {
        return new File(Id(str));
    }

    private String Ib(String str) {
        return this.kbH + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Ic(String str) {
        return new File(Ib(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> bhe;

        private a() {
            this.bhe = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
        }

        @Override // com.facebook.common.file.b
        public void Y(File file) {
            c W = DefaultDiskStorage.this.W(file);
            if (W != null && W.kbM == FileType.CONTENT) {
                this.bhe.add(new b(W.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.bhe);
        }
    }

    /* loaded from: classes2.dex */
    private class e implements com.facebook.common.file.b {
        private boolean kbO;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void X(File file) {
            if (!this.kbO && file.equals(DefaultDiskStorage.this.kbH)) {
                this.kbO = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void Y(File file) {
            if (!this.kbO || !ac(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void Z(File file) {
            if (!DefaultDiskStorage.this.kbF.equals(file) && !this.kbO) {
                file.delete();
            }
            if (this.kbO && file.equals(DefaultDiskStorage.this.kbH)) {
                this.kbO = false;
            }
        }

        private boolean ac(File file) {
            c W = DefaultDiskStorage.this.W(file);
            if (W == null) {
                return false;
            }
            if (W.kbM == FileType.TEMP) {
                return ad(file);
            }
            com.facebook.common.internal.g.checkState(W.kbM == FileType.CONTENT);
            return true;
        }

        private boolean ad(File file) {
            return file.lastModified() > DefaultDiskStorage.this.kbJ.now() - DefaultDiskStorage.kbE;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void cFf() {
        com.facebook.common.file.a.a(this.kbF, new e());
    }

    private void h(File file, String str) throws IOException {
        try {
            FileUtils.ag(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.kbI.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, kbD, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b q(String str, Object obj) throws IOException {
        c cVar = new c(FileType.TEMP, str);
        File Ic = Ic(cVar.resourceId);
        if (!Ic.exists()) {
            h(Ic, "insert");
        }
        try {
            return new d(str, cVar.aa(Ic));
        } catch (IOException e2) {
            this.kbI.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, kbD, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) {
        File Ia = Ia(str);
        if (Ia.exists()) {
            Ia.setLastModified(this.kbJ.now());
            return com.facebook.a.b.U(Ia);
        }
        return null;
    }

    private String Id(String str) {
        c cVar = new c(FileType.CONTENT, str);
        return cVar.Ie(Ib(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean s(String str, Object obj) {
        return aD(str, false);
    }

    private boolean aD(String str, boolean z) {
        File Ia = Ia(str);
        boolean exists = Ia.exists();
        if (z && exists) {
            Ia.setLastModified(this.kbJ.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return V(((b) aVar).cFi().getFile());
    }

    private long V(File file) {
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
    public List<c.a> cFg() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.kbH, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes2.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b kbL;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.kbL = com.facebook.a.b.U(file);
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
                this.timestamp = this.kbL.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b cFi() {
            return this.kbL;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.kbL.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c W(File file) {
        c ab = c.ab(file);
        if (ab == null) {
            return null;
        }
        if (!Ic(ab.resourceId).equals(file.getParentFile())) {
            ab = null;
        }
        return ab;
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
        public final FileType kbM;
        public final String resourceId;

        private c(FileType fileType, String str) {
            this.kbM = fileType;
            this.resourceId = str;
        }

        public String toString() {
            return this.kbM + "(" + this.resourceId + ")";
        }

        public String Ie(String str) {
            return str + File.separator + this.resourceId + this.kbM.extension;
        }

        public File aa(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c ab(File file) {
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
        private final String iAK;
        final File kbN;

        public d(String str, File file) {
            this.iAK = str;
            this.kbN = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.kbN);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.kbN.length() != count) {
                        throw new IncompleteFileException(count, this.kbN.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.kbI.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.kbD, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aA(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Ia = DefaultDiskStorage.this.Ia(this.iAK);
            try {
                FileUtils.rename(this.kbN, Ia);
                if (Ia.exists()) {
                    Ia.setLastModified(DefaultDiskStorage.this.kbJ.now());
                }
                return com.facebook.a.b.U(Ia);
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
                DefaultDiskStorage.this.kbI.a(cacheErrorCategory, DefaultDiskStorage.kbD, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean cFj() {
            return !this.kbN.exists() || this.kbN.delete();
        }
    }
}
