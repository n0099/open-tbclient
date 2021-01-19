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
    private static final Class<?> pnn = e.class;
    private final int mVersion;
    private final j<File> pnA;
    private final CacheErrorLogger pns;
    private final String pnz;
    volatile a poa = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        public final c pob;
        @Nullable
        public final File poc;

        a(@Nullable File file, @Nullable c cVar) {
            this.pob = cVar;
            this.poc = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.pns = cacheErrorLogger;
        this.pnA = jVar;
        this.pnz = str;
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
            com.facebook.common.c.a.b(pnn, "purgeUnexpectedResources", e);
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
    public long Yc(String str) throws IOException {
        return epS().Yc(str);
    }

    synchronized c epS() throws IOException {
        if (epT()) {
            epU();
            epV();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.poa.pob);
    }

    private boolean epT() {
        a aVar = this.poa;
        return aVar.pob == null || aVar.poc == null || !aVar.poc.exists();
    }

    void epU() {
        if (this.poa.pob != null && this.poa.poc != null) {
            com.facebook.common.file.a.ay(this.poa.poc);
        }
    }

    private void epV() throws IOException {
        File file = new File(this.pnA.get(), this.pnz);
        ax(file);
        this.poa = new a(file, new DefaultDiskStorage(file, this.mVersion, this.pns));
    }

    void ax(File file) throws IOException {
        try {
            FileUtils.az(file);
            com.facebook.common.c.a.d(pnn, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.pns.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pnn, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
