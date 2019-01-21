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
    private static final Class<?> iiR = e.class;
    private final CacheErrorLogger iiW;
    volatile a ijI = new a(null, null);
    private final String ijg;
    private final com.facebook.common.internal.i<File> ijh;
    private final int vz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c ijJ;
        @Nullable
        public final File ijK;

        a(@Nullable File file, @Nullable c cVar) {
            this.ijJ = cVar;
            this.ijK = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vz = i;
        this.iiW = cacheErrorLogger;
        this.ijh = iVar;
        this.ijg = str;
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
            com.facebook.common.c.a.b(iiR, "purgeUnexpectedResources", (Throwable) e);
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
        return (c) com.facebook.common.internal.g.checkNotNull(this.ijI.ijJ);
    }

    private boolean bUq() {
        a aVar = this.ijI;
        return aVar.ijJ == null || aVar.ijK == null || !aVar.ijK.exists();
    }

    void bUr() {
        if (this.ijI.ijJ != null && this.ijI.ijK != null) {
            com.facebook.common.file.a.ad(this.ijI.ijK);
        }
    }

    private void bUs() throws IOException {
        File file = new File(this.ijh.get(), this.ijg);
        ac(file);
        this.ijI = new a(file, new DefaultDiskStorage(file, this.vz, this.iiW));
    }

    void ac(File file) throws IOException {
        try {
            FileUtils.ae(file);
            com.facebook.common.c.a.b(iiR, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.iiW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, iiR, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
