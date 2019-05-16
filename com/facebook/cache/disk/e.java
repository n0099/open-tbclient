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
    private static final Class<?> jQR = e.class;
    private final CacheErrorLogger jQW;
    volatile a jRG = new a(null, null);
    private final String jRf;
    private final com.facebook.common.internal.i<File> jRg;
    private final int sY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jRH;
        @Nullable
        public final File jRI;

        a(@Nullable File file, @Nullable c cVar) {
            this.jRH = cVar;
            this.jRI = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.sY = i;
        this.jQW = cacheErrorLogger;
        this.jRg = iVar;
        this.jRf = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return cBq().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) throws IOException {
        return cBq().r(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean s(String str, Object obj) throws IOException {
        return cBq().s(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void cAU() {
        try {
            cBq().cAU();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jQR, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b q(String str, Object obj) throws IOException {
        return cBq().q(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> cAV() throws IOException {
        return cBq().cAV();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return cBq().a(aVar);
    }

    synchronized c cBq() throws IOException {
        if (cBr()) {
            cBs();
            cBt();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jRG.jRH);
    }

    private boolean cBr() {
        a aVar = this.jRG;
        return aVar.jRH == null || aVar.jRI == null || !aVar.jRI.exists();
    }

    void cBs() {
        if (this.jRG.jRH != null && this.jRG.jRI != null) {
            com.facebook.common.file.a.af(this.jRG.jRI);
        }
    }

    private void cBt() throws IOException {
        File file = new File(this.jRg.get(), this.jRf);
        ae(file);
        this.jRG = new a(file, new DefaultDiskStorage(file, this.sY, this.jQW));
    }

    void ae(File file) throws IOException {
        try {
            FileUtils.ag(file);
            com.facebook.common.c.a.b(jQR, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jQW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jQR, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
