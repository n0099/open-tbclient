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
    private static final Class<?> mPz = e.class;
    private final CacheErrorLogger mPE;
    private final String mPL;
    private final j<File> mPM;
    volatile a mQm = new a(null, null);
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        @Nullable
        public final c mQn;
        @Nullable
        public final File mQo;

        a(@Nullable File file, @Nullable c cVar) {
            this.mQn = cVar;
            this.mQo = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mPE = cacheErrorLogger;
        this.mPM = jVar;
        this.mPL = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dCk().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return dCk().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return dCk().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dBO() {
        try {
            dCk().dBO();
        } catch (IOException e) {
            com.facebook.common.c.a.b(mPz, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return dCk().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dBP() throws IOException {
        return dCk().dBP();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dCk().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Ri(String str) throws IOException {
        return dCk().Ri(str);
    }

    synchronized c dCk() throws IOException {
        if (dCl()) {
            dCm();
            dCn();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.mQm.mQn);
    }

    private boolean dCl() {
        a aVar = this.mQm;
        return aVar.mQn == null || aVar.mQo == null || !aVar.mQo.exists();
    }

    void dCm() {
        if (this.mQm.mQn != null && this.mQm.mQo != null) {
            com.facebook.common.file.a.an(this.mQm.mQo);
        }
    }

    private void dCn() throws IOException {
        File file = new File(this.mPM.get(), this.mPL);
        am(file);
        this.mQm = new a(file, new DefaultDiskStorage(file, this.mVersion, this.mPE));
    }

    void am(File file) throws IOException {
        try {
            FileUtils.ao(file);
            com.facebook.common.c.a.b(mPz, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.mPE.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mPz, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
