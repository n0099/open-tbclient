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
    private static final Class<?> prR = e.class;
    private final int mVersion;
    private final CacheErrorLogger prW;
    volatile a psE = new a(null, null);
    private final String psd;
    private final j<File> pse;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        public final c psF;
        @Nullable
        public final File psG;

        a(@Nullable File file, @Nullable c cVar) {
            this.psF = cVar;
            this.psG = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.prW = cacheErrorLogger;
        this.pse = jVar;
        this.psd = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return etM().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a G(String str, Object obj) throws IOException {
        return etM().G(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean H(String str, Object obj) throws IOException {
        return etM().H(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void etr() {
        try {
            etM().etr();
        } catch (IOException e) {
            com.facebook.common.c.a.b(prR, "purgeUnexpectedResources", e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b F(String str, Object obj) throws IOException {
        return etM().F(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> ets() throws IOException {
        return etM().ets();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return etM().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Zj(String str) throws IOException {
        return etM().Zj(str);
    }

    synchronized c etM() throws IOException {
        if (etN()) {
            etO();
            etP();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.psE.psF);
    }

    private boolean etN() {
        a aVar = this.psE;
        return aVar.psF == null || aVar.psG == null || !aVar.psG.exists();
    }

    void etO() {
        if (this.psE.psF != null && this.psE.psG != null) {
            com.facebook.common.file.a.az(this.psE.psG);
        }
    }

    private void etP() throws IOException {
        File file = new File(this.pse.get(), this.psd);
        ay(file);
        this.psE = new a(file, new DefaultDiskStorage(file, this.mVersion, this.prW));
    }

    void ay(File file) throws IOException {
        try {
            FileUtils.aA(file);
            com.facebook.common.c.a.d(prR, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.prW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, prR, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
