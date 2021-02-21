package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class e implements c {
    private static final Class<?> pyc = e.class;
    private final int mVersion;
    volatile a pyP = new a(null, null);
    private final CacheErrorLogger pyh;
    private final String pyo;
    private final j<File> pyp;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        public final c pyQ;
        @Nullable
        public final File pyR;

        a(@Nullable File file, @Nullable c cVar) {
            this.pyQ = cVar;
            this.pyR = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.pyh = cacheErrorLogger;
        this.pyp = jVar;
        this.pyo = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return est().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a F(String str, Object obj) throws IOException {
        return est().F(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean G(String str, Object obj) throws IOException {
        return est().G(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void erY() {
        try {
            est().erY();
        } catch (IOException e) {
            com.facebook.common.c.a.b(pyc, "purgeUnexpectedResources", e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b E(String str, Object obj) throws IOException {
        return est().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> erZ() throws IOException {
        return est().erZ();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return est().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Zp(String str) throws IOException {
        return est().Zp(str);
    }

    synchronized c est() throws IOException {
        if (esu()) {
            esv();
            esw();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.pyP.pyQ);
    }

    private boolean esu() {
        a aVar = this.pyP;
        return aVar.pyQ == null || aVar.pyR == null || !aVar.pyR.exists();
    }

    void esv() {
        if (this.pyP.pyQ != null && this.pyP.pyR != null) {
            com.facebook.common.file.a.aw(this.pyP.pyR);
        }
    }

    private void esw() throws IOException {
        File file = new File(this.pyp.get(), this.pyo);
        av(file);
        this.pyP = new a(file, new DefaultDiskStorage(file, this.mVersion, this.pyh));
    }

    void av(File file) throws IOException {
        try {
            FileUtils.ax(file);
            com.facebook.common.c.a.d(pyc, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.pyh.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pyc, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
