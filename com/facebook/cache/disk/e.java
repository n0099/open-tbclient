package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class e implements c {
    private static final Class<?> mHr = e.class;
    private final String mHD;
    private final j<File> mHE;
    private final CacheErrorLogger mHw;
    volatile a mIf = new a(null, null);
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c mIg;
        @Nullable
        public final File mIh;

        a(@Nullable File file, @Nullable c cVar) {
            this.mIg = cVar;
            this.mIh = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mHw = cacheErrorLogger;
        this.mHE = jVar;
        this.mHD = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dyX().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return dyX().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return dyX().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dyB() {
        try {
            dyX().dyB();
        } catch (IOException e) {
            com.facebook.common.c.a.b(mHr, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return dyX().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dyC() throws IOException {
        return dyX().dyC();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dyX().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Qx(String str) throws IOException {
        return dyX().Qx(str);
    }

    synchronized c dyX() throws IOException {
        if (dyY()) {
            dyZ();
            dza();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.mIf.mIg);
    }

    private boolean dyY() {
        a aVar = this.mIf;
        return aVar.mIg == null || aVar.mIh == null || !aVar.mIh.exists();
    }

    void dyZ() {
        if (this.mIf.mIg != null && this.mIf.mIh != null) {
            com.facebook.common.file.a.ak(this.mIf.mIh);
        }
    }

    private void dza() throws IOException {
        File file = new File(this.mHE.get(), this.mHD);
        aj(file);
        this.mIf = new a(file, new DefaultDiskStorage(file, this.mVersion, this.mHw));
    }

    void aj(File file) throws IOException {
        try {
            FileUtils.al(file);
            com.facebook.common.c.a.b(mHr, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.mHw.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mHr, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
