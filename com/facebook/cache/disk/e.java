package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class e implements c {
    private static final Class<?> mPx = e.class;
    private final CacheErrorLogger mPC;
    private final String mPJ;
    private final j<File> mPK;
    volatile a mQk = new a(null, null);
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        @Nullable
        public final c mQl;
        @Nullable
        public final File mQm;

        a(@Nullable File file, @Nullable c cVar) {
            this.mQl = cVar;
            this.mQm = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mPC = cacheErrorLogger;
        this.mPK = jVar;
        this.mPJ = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dCj().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return dCj().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return dCj().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dBN() {
        try {
            dCj().dBN();
        } catch (IOException e) {
            com.facebook.common.c.a.b(mPx, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return dCj().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dBO() throws IOException {
        return dCj().dBO();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dCj().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Ri(String str) throws IOException {
        return dCj().Ri(str);
    }

    synchronized c dCj() throws IOException {
        if (dCk()) {
            dCl();
            dCm();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.mQk.mQl);
    }

    private boolean dCk() {
        a aVar = this.mQk;
        return aVar.mQl == null || aVar.mQm == null || !aVar.mQm.exists();
    }

    void dCl() {
        if (this.mQk.mQl != null && this.mQk.mQm != null) {
            com.facebook.common.file.a.an(this.mQk.mQm);
        }
    }

    private void dCm() throws IOException {
        File file = new File(this.mPK.get(), this.mPJ);
        am(file);
        this.mQk = new a(file, new DefaultDiskStorage(file, this.mVersion, this.mPC));
    }

    void am(File file) throws IOException {
        try {
            FileUtils.ao(file);
            com.facebook.common.c.a.b(mPx, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.mPC.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mPx, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
