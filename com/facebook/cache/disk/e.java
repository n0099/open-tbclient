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
    private static final Class<?> hVB = e.class;
    private final CacheErrorLogger hVG;
    private final String hVQ;
    private final com.facebook.common.internal.i<File> hVR;
    volatile a hWs = new a(null, null);
    private final int vx;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c hWt;
        @Nullable
        public final File hWu;

        a(@Nullable File file, @Nullable c cVar) {
            this.hWt = cVar;
            this.hWu = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vx = i;
        this.hVG = cacheErrorLogger;
        this.hVR = iVar;
        this.hVQ = str;
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
            com.facebook.common.c.a.b(hVB, "purgeUnexpectedResources", (Throwable) e);
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
        return (c) com.facebook.common.internal.g.checkNotNull(this.hWs.hWt);
    }

    private boolean bRr() {
        a aVar = this.hWs;
        return aVar.hWt == null || aVar.hWu == null || !aVar.hWu.exists();
    }

    void bRs() {
        if (this.hWs.hWt != null && this.hWs.hWu != null) {
            com.facebook.common.file.a.ab(this.hWs.hWu);
        }
    }

    private void bRt() throws IOException {
        File file = new File(this.hVR.get(), this.hVQ);
        aa(file);
        this.hWs = new a(file, new DefaultDiskStorage(file, this.vx, this.hVG));
    }

    void aa(File file) throws IOException {
        try {
            FileUtils.ac(file);
            com.facebook.common.c.a.b(hVB, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.hVG.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, hVB, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
