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
/* loaded from: classes5.dex */
public class DefaultDiskStorage implements com.facebook.cache.disk.c {
    private static final Class<?> pyc = DefaultDiskStorage.class;
    static final long pyd = TimeUnit.MINUTES.toMillis(30);
    private final File pye;
    private final boolean pyf;
    private final File pyg;
    private final CacheErrorLogger pyh;
    private final com.facebook.common.time.a pyi;

    public DefaultDiskStorage(File file, int i, CacheErrorLogger cacheErrorLogger) {
        com.facebook.common.internal.g.checkNotNull(file);
        this.pye = file;
        this.pyf = a(file, cacheErrorLogger);
        this.pyg = new File(this.pye, OT(i));
        this.pyh = cacheErrorLogger;
        erX();
        this.pyi = com.facebook.common.time.c.etc();
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
                cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pyc, "failed to read folder to check if external: " + str, e2);
                return false;
            }
        } catch (Exception e3) {
            cacheErrorLogger.a(CacheErrorLogger.CacheErrorCategory.OTHER, pyc, "failed to get the external storage directory!", e3);
            return false;
        }
    }

    static String OT(int i) {
        return String.format(null, "%s.ols%d.%d", "v2", 100, Integer.valueOf(i));
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        return this.pyf;
    }

    private void erX() {
        boolean z = true;
        if (this.pye.exists()) {
            if (this.pyg.exists()) {
                z = false;
            } else {
                com.facebook.common.file.a.aw(this.pye);
            }
        }
        if (z) {
            try {
                FileUtils.ax(this.pyg);
            } catch (FileUtils.CreateDirectoryException e2) {
                this.pyh.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pyc, "version directory could not be created: " + this.pyg, null);
            }
        }
    }

    /* loaded from: classes5.dex */
    private static class IncompleteFileException extends IOException {
        public final long actual;
        public final long expected;

        public IncompleteFileException(long j, long j2) {
            super("File was not written completely. Expected: " + j + ", found: " + j2);
            this.expected = j;
            this.actual = j2;
        }
    }

    File Zm(String str) {
        return new File(getFilename(str));
    }

    private String Zn(String str) {
        return this.pyg + File.separator + String.valueOf(Math.abs(str.hashCode() % 100));
    }

    private File Zo(String str) {
        return new File(Zn(str));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
    public class a implements com.facebook.common.file.b {
        private final List<c.a> result;

        private a() {
            this.result = new ArrayList();
        }

        @Override // com.facebook.common.file.b
        public void ao(File file) {
        }

        @Override // com.facebook.common.file.b
        public void ap(File file) {
            c an = DefaultDiskStorage.this.an(file);
            if (an != null && an.type == ".cnt") {
                this.result.add(new b(an.resourceId, file));
            }
        }

        @Override // com.facebook.common.file.b
        public void aq(File file) {
        }

        public List<c.a> getEntries() {
            return Collections.unmodifiableList(this.result);
        }
    }

    /* loaded from: classes5.dex */
    private class e implements com.facebook.common.file.b {
        private boolean pym;

        private e() {
        }

        @Override // com.facebook.common.file.b
        public void ao(File file) {
            if (!this.pym && file.equals(DefaultDiskStorage.this.pyg)) {
                this.pym = true;
            }
        }

        @Override // com.facebook.common.file.b
        public void ap(File file) {
            if (!this.pym || !at(file)) {
                file.delete();
            }
        }

        @Override // com.facebook.common.file.b
        public void aq(File file) {
            if (!DefaultDiskStorage.this.pye.equals(file) && !this.pym) {
                file.delete();
            }
            if (this.pym && file.equals(DefaultDiskStorage.this.pyg)) {
                this.pym = false;
            }
        }

        private boolean at(File file) {
            c an = DefaultDiskStorage.this.an(file);
            if (an == null) {
                return false;
            }
            if (an.type == ".tmp") {
                return au(file);
            }
            com.facebook.common.internal.g.checkState(an.type == ".cnt");
            return true;
        }

        private boolean au(File file) {
            return file.lastModified() > DefaultDiskStorage.this.pyi.now() - DefaultDiskStorage.pyd;
        }
    }

    @Override // com.facebook.cache.disk.c
    public void erY() {
        com.facebook.common.file.a.a(this.pye, new e());
    }

    private void l(File file, String str) throws IOException {
        try {
            FileUtils.ax(file);
        } catch (FileUtils.CreateDirectoryException e2) {
            this.pyh.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pyc, str, e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b E(String str, Object obj) throws IOException {
        c cVar = new c(".tmp", str);
        File Zo = Zo(cVar.resourceId);
        if (!Zo.exists()) {
            l(Zo, "insert");
        }
        try {
            return new d(str, cVar.ar(Zo));
        } catch (IOException e2) {
            this.pyh.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_TEMPFILE, pyc, "insert", e2);
            throw e2;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a F(String str, Object obj) {
        File Zm = Zm(str);
        if (Zm.exists()) {
            Zm.setLastModified(this.pyi.now());
            return com.facebook.a.b.al(Zm);
        }
        return null;
    }

    private String getFilename(String str) {
        c cVar = new c(".cnt", str);
        return cVar.Zs(Zn(cVar.resourceId));
    }

    @Override // com.facebook.cache.disk.c
    public boolean G(String str, Object obj) {
        return bn(str, false);
    }

    private boolean bn(String str, boolean z) {
        File Zm = Zm(str);
        boolean exists = Zm.exists();
        if (z && exists) {
            Zm.setLastModified(this.pyi.now());
        }
        return exists;
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) {
        return am(((b) aVar).esb().getFile());
    }

    @Override // com.facebook.cache.disk.c
    public long Zp(String str) {
        return am(Zm(str));
    }

    private long am(File file) {
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
    public List<c.a> erZ() throws IOException {
        a aVar = new a();
        com.facebook.common.file.a.a(this.pyg, aVar);
        return aVar.getEntries();
    }

    /* loaded from: classes5.dex */
    static class b implements c.a {
        private final String id;
        private final com.facebook.a.b pyk;
        private long size;
        private long timestamp;

        private b(String str, File file) {
            com.facebook.common.internal.g.checkNotNull(file);
            this.id = (String) com.facebook.common.internal.g.checkNotNull(str);
            this.pyk = com.facebook.a.b.al(file);
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
                this.timestamp = this.pyk.getFile().lastModified();
            }
            return this.timestamp;
        }

        public com.facebook.a.b esb() {
            return this.pyk;
        }

        @Override // com.facebook.cache.disk.c.a
        public long getSize() {
            if (this.size < 0) {
                this.size = this.pyk.size();
            }
            return this.size;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public c an(File file) {
        c as = c.as(file);
        if (as == null) {
            return null;
        }
        if (!Zo(as.resourceId).equals(file.getParentFile())) {
            as = null;
        }
        return as;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Nullable
    public static String Zq(String str) {
        if (".cnt".equals(str)) {
            return ".cnt";
        }
        if (".tmp".equals(str)) {
            return ".tmp";
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes5.dex */
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

        public String Zs(String str) {
            return str + File.separator + this.resourceId + this.type;
        }

        public File ar(File file) throws IOException {
            return File.createTempFile(this.resourceId + ".", ".tmp", file);
        }

        @Nullable
        public static c as(File file) {
            String Zq;
            String name = file.getName();
            int lastIndexOf = name.lastIndexOf(46);
            if (lastIndexOf > 0 && (Zq = DefaultDiskStorage.Zq(name.substring(lastIndexOf))) != null) {
                String substring = name.substring(0, lastIndexOf);
                if (Zq.equals(".tmp")) {
                    int lastIndexOf2 = substring.lastIndexOf(46);
                    if (lastIndexOf2 <= 0) {
                        return null;
                    }
                    substring = substring.substring(0, lastIndexOf2);
                }
                return new c(Zq, substring);
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    class d implements c.b {
        private final String mIE;
        final File pyl;

        public d(String str, File file) {
            this.mIE = str;
            this.pyl = file;
        }

        @Override // com.facebook.cache.disk.c.b
        public void a(com.facebook.cache.common.h hVar, Object obj) throws IOException {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(this.pyl);
                try {
                    com.facebook.common.internal.c cVar = new com.facebook.common.internal.c(fileOutputStream);
                    hVar.write(cVar);
                    cVar.flush();
                    long count = cVar.getCount();
                    fileOutputStream.close();
                    if (this.pyl.length() != count) {
                        throw new IncompleteFileException(count, this.pyl.length());
                    }
                } catch (Throwable th) {
                    fileOutputStream.close();
                    throw th;
                }
            } catch (FileNotFoundException e) {
                DefaultDiskStorage.this.pyh.a(CacheErrorLogger.CacheErrorCategory.WRITE_UPDATE_FILE_NOT_FOUND, DefaultDiskStorage.pyc, "updateResource", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public com.facebook.a.a aZ(Object obj) throws IOException {
            CacheErrorLogger.CacheErrorCategory cacheErrorCategory;
            File Zm = DefaultDiskStorage.this.Zm(this.mIE);
            try {
                FileUtils.rename(this.pyl, Zm);
                if (Zm.exists()) {
                    Zm.setLastModified(DefaultDiskStorage.this.pyi.now());
                }
                return com.facebook.a.b.al(Zm);
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
                DefaultDiskStorage.this.pyh.a(cacheErrorCategory, DefaultDiskStorage.pyc, "commit", e);
                throw e;
            }
        }

        @Override // com.facebook.cache.disk.c.b
        public boolean esc() {
            return !this.pyl.exists() || this.pyl.delete();
        }
    }
}
