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
    private static final Class<?> iiQ = e.class;
    private final CacheErrorLogger iiV;
    volatile a ijH = new a(null, null);
    private final String ijf;
    private final com.facebook.common.internal.i<File> ijg;
    private final int vz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c ijI;
        @Nullable
        public final File ijJ;

        a(@Nullable File file, @Nullable c cVar) {
            this.ijI = cVar;
            this.ijJ = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vz = i;
        this.iiV = cacheErrorLogger;
        this.ijg = iVar;
        this.ijf = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return bUp().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) throws IOException {
        return bUp().l(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) throws IOException {
        return bUp().m(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void bTT() {
        try {
            bUp().bTT();
        } catch (IOException e) {
            com.facebook.common.c.a.b(iiQ, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        return bUp().k(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> bTU() throws IOException {
        return bUp().bTU();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return bUp().a(aVar);
    }

    synchronized c bUp() throws IOException {
        if (bUq()) {
            bUr();
            bUs();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.ijH.ijI);
    }

    private boolean bUq() {
        a aVar = this.ijH;
        return aVar.ijI == null || aVar.ijJ == null || !aVar.ijJ.exists();
    }

    void bUr() {
        if (this.ijH.ijI != null && this.ijH.ijJ != null) {
            com.facebook.common.file.a.ad(this.ijH.ijJ);
        }
    }

    private void bUs() throws IOException {
        File file = new File(this.ijg.get(), this.ijf);
        ac(file);
        this.ijH = new a(file, new DefaultDiskStorage(file, this.vz, this.iiV));
    }

    void ac(File file) throws IOException {
        try {
            FileUtils.ae(file);
            com.facebook.common.c.a.b(iiQ, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.iiV.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, iiQ, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
