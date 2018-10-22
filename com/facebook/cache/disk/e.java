package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e implements c {
    private static final Class<?> hVC = e.class;
    private final CacheErrorLogger hVH;
    private final String hVR;
    private final com.facebook.common.internal.i<File> hVS;
    volatile a hWt = new a(null, null);
    private final int vx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c hWu;
        @Nullable
        public final File hWv;

        a(@Nullable File file, @Nullable c cVar) {
            this.hWu = cVar;
            this.hWv = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vx = i;
        this.hVH = cacheErrorLogger;
        this.hVS = iVar;
        this.hVR = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return bRq().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) throws IOException {
        return bRq().l(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) throws IOException {
        return bRq().m(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void bQU() {
        try {
            bRq().bQU();
        } catch (IOException e) {
            com.facebook.common.c.a.b(hVC, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        return bRq().k(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> bQV() throws IOException {
        return bRq().bQV();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return bRq().a(aVar);
    }

    synchronized c bRq() throws IOException {
        if (bRr()) {
            bRs();
            bRt();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.hWt.hWu);
    }

    private boolean bRr() {
        a aVar = this.hWt;
        return aVar.hWu == null || aVar.hWv == null || !aVar.hWv.exists();
    }

    void bRs() {
        if (this.hWt.hWu != null && this.hWt.hWv != null) {
            com.facebook.common.file.a.ab(this.hWt.hWv);
        }
    }

    private void bRt() throws IOException {
        File file = new File(this.hVS.get(), this.hVR);
        aa(file);
        this.hWt = new a(file, new DefaultDiskStorage(file, this.vx, this.hVH));
    }

    void aa(File file) throws IOException {
        try {
            FileUtils.ac(file);
            com.facebook.common.c.a.b(hVC, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.hVH.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, hVC, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
