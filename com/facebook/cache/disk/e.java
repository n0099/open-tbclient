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
    private static final Class<?> pAh = e.class;
    private final int mVersion;
    volatile a pAU = new a(null, null);
    private final CacheErrorLogger pAm;
    private final String pAt;
    private final j<File> pAu;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        public final c pAV;
        @Nullable
        public final File pAW;

        a(@Nullable File file, @Nullable c cVar) {
            this.pAV = cVar;
            this.pAW = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.pAm = cacheErrorLogger;
        this.pAu = jVar;
        this.pAt = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return esC().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a E(String str, Object obj) throws IOException {
        return esC().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean F(String str, Object obj) throws IOException {
        return esC().F(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void esh() {
        try {
            esC().esh();
        } catch (IOException e) {
            com.facebook.common.c.a.b(pAh, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b D(String str, Object obj) throws IOException {
        return esC().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> esi() throws IOException {
        return esC().esi();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return esC().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Zv(String str) throws IOException {
        return esC().Zv(str);
    }

    synchronized c esC() throws IOException {
        if (esD()) {
            esE();
            esF();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.pAU.pAV);
    }

    private boolean esD() {
        a aVar = this.pAU;
        return aVar.pAV == null || aVar.pAW == null || !aVar.pAW.exists();
    }

    void esE() {
        if (this.pAU.pAV != null && this.pAU.pAW != null) {
            com.facebook.common.file.a.aw(this.pAU.pAW);
        }
    }

    private void esF() throws IOException {
        File file = new File(this.pAu.get(), this.pAt);
        av(file);
        this.pAU = new a(file, new DefaultDiskStorage(file, this.mVersion, this.pAm));
    }

    void av(File file) throws IOException {
        try {
            FileUtils.ax(file);
            com.facebook.common.c.a.b(pAh, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.pAm.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pAh, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
