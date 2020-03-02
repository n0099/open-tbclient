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
    private static final Class<?> lHa = e.class;
    volatile a lHN = new a(null, null);
    private final CacheErrorLogger lHf;
    private final String lHm;
    private final j<File> lHn;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c lHO;
        @Nullable
        public final File lHP;

        a(@Nullable File file, @Nullable c cVar) {
            this.lHO = cVar;
            this.lHP = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.lHf = cacheErrorLogger;
        this.lHn = jVar;
        this.lHm = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dku().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) throws IOException {
        return dku().v(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) throws IOException {
        return dku().w(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void djY() {
        try {
            dku().djY();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lHa, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        return dku().u(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> djZ() throws IOException {
        return dku().djZ();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dku().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long OK(String str) throws IOException {
        return dku().OK(str);
    }

    synchronized c dku() throws IOException {
        if (dkv()) {
            dkw();
            dkx();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lHN.lHO);
    }

    private boolean dkv() {
        a aVar = this.lHN;
        return aVar.lHO == null || aVar.lHP == null || !aVar.lHP.exists();
    }

    void dkw() {
        if (this.lHN.lHO != null && this.lHN.lHP != null) {
            com.facebook.common.file.a.ak(this.lHN.lHP);
        }
    }

    private void dkx() throws IOException {
        File file = new File(this.lHn.get(), this.lHm);
        aj(file);
        this.lHN = new a(file, new DefaultDiskStorage(file, this.mVersion, this.lHf));
    }

    void aj(File file) throws IOException {
        try {
            FileUtils.al(file);
            com.facebook.common.c.a.b(lHa, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.lHf.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lHa, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
