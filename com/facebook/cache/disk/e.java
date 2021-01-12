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
    private static final Class<?> pnm = e.class;
    private final int mVersion;
    volatile a pnZ = new a(null, null);
    private final CacheErrorLogger pnr;
    private final String pny;
    private final j<File> pnz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        public final c poa;
        @Nullable
        public final File pob;

        a(@Nullable File file, @Nullable c cVar) {
            this.poa = cVar;
            this.pob = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.pnr = cacheErrorLogger;
        this.pnz = jVar;
        this.pny = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return epS().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a G(String str, Object obj) throws IOException {
        return epS().G(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean H(String str, Object obj) throws IOException {
        return epS().H(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void epx() {
        try {
            epS().epx();
        } catch (IOException e) {
            com.facebook.common.c.a.b(pnm, "purgeUnexpectedResources", e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b F(String str, Object obj) throws IOException {
        return epS().F(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> epy() throws IOException {
        return epS().epy();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return epS().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Yb(String str) throws IOException {
        return epS().Yb(str);
    }

    synchronized c epS() throws IOException {
        if (epT()) {
            epU();
            epV();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.pnZ.poa);
    }

    private boolean epT() {
        a aVar = this.pnZ;
        return aVar.poa == null || aVar.pob == null || !aVar.pob.exists();
    }

    void epU() {
        if (this.pnZ.poa != null && this.pnZ.pob != null) {
            com.facebook.common.file.a.ay(this.pnZ.pob);
        }
    }

    private void epV() throws IOException {
        File file = new File(this.pnz.get(), this.pny);
        ax(file);
        this.pnZ = new a(file, new DefaultDiskStorage(file, this.mVersion, this.pnr));
    }

    void ax(File file) throws IOException {
        try {
            FileUtils.az(file);
            com.facebook.common.c.a.d(pnm, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.pnr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pnm, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
