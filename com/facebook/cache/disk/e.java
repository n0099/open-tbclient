package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class e implements c {
    private static final Class<?> prQ = e.class;
    private final int mVersion;
    private final CacheErrorLogger prV;
    volatile a psD = new a(null, null);
    private final String psc;
    private final j<File> psd;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        @Nullable
        public final c psE;
        @Nullable
        public final File psF;

        a(@Nullable File file, @Nullable c cVar) {
            this.psE = cVar;
            this.psF = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.prV = cacheErrorLogger;
        this.psd = jVar;
        this.psc = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return etI().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a G(String str, Object obj) throws IOException {
        return etI().G(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean H(String str, Object obj) throws IOException {
        return etI().H(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void etn() {
        try {
            etI().etn();
        } catch (IOException e) {
            com.facebook.common.c.a.b(prQ, "purgeUnexpectedResources", e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b F(String str, Object obj) throws IOException {
        return etI().F(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> eto() throws IOException {
        return etI().eto();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return etI().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Zk(String str) throws IOException {
        return etI().Zk(str);
    }

    synchronized c etI() throws IOException {
        if (etJ()) {
            etK();
            etL();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.psD.psE);
    }

    private boolean etJ() {
        a aVar = this.psD;
        return aVar.psE == null || aVar.psF == null || !aVar.psF.exists();
    }

    void etK() {
        if (this.psD.psE != null && this.psD.psF != null) {
            com.facebook.common.file.a.az(this.psD.psF);
        }
    }

    private void etL() throws IOException {
        File file = new File(this.psd.get(), this.psc);
        ay(file);
        this.psD = new a(file, new DefaultDiskStorage(file, this.mVersion, this.prV));
    }

    void ay(File file) throws IOException {
        try {
            FileUtils.aA(file);
            com.facebook.common.c.a.d(prQ, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.prV.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, prQ, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
