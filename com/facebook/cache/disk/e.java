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
    private static final Class<?> mHo = e.class;
    private final String mHA;
    private final j<File> mHB;
    private final CacheErrorLogger mHt;
    volatile a mIb = new a(null, null);
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c mIc;
        @Nullable
        public final File mIe;

        a(@Nullable File file, @Nullable c cVar) {
            this.mIc = cVar;
            this.mIe = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mHt = cacheErrorLogger;
        this.mHB = jVar;
        this.mHA = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dyT().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return dyT().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return dyT().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dyx() {
        try {
            dyT().dyx();
        } catch (IOException e) {
            com.facebook.common.c.a.b(mHo, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return dyT().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dyy() throws IOException {
        return dyT().dyy();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dyT().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Qw(String str) throws IOException {
        return dyT().Qw(str);
    }

    synchronized c dyT() throws IOException {
        if (dyU()) {
            dyV();
            dyW();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.mIb.mIc);
    }

    private boolean dyU() {
        a aVar = this.mIb;
        return aVar.mIc == null || aVar.mIe == null || !aVar.mIe.exists();
    }

    void dyV() {
        if (this.mIb.mIc != null && this.mIb.mIe != null) {
            com.facebook.common.file.a.ak(this.mIb.mIe);
        }
    }

    private void dyW() throws IOException {
        File file = new File(this.mHB.get(), this.mHA);
        aj(file);
        this.mIb = new a(file, new DefaultDiskStorage(file, this.mVersion, this.mHt));
    }

    void aj(File file) throws IOException {
        try {
            FileUtils.al(file);
            com.facebook.common.c.a.b(mHo, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.mHt.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mHo, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
