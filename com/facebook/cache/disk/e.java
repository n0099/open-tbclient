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
    private static final Class<?> lGY = e.class;
    volatile a lHL = new a(null, null);
    private final CacheErrorLogger lHd;
    private final String lHk;
    private final j<File> lHl;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c lHM;
        @Nullable
        public final File lHN;

        a(@Nullable File file, @Nullable c cVar) {
            this.lHM = cVar;
            this.lHN = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.lHd = cacheErrorLogger;
        this.lHl = jVar;
        this.lHk = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dks().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) throws IOException {
        return dks().v(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) throws IOException {
        return dks().w(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void djW() {
        try {
            dks().djW();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lGY, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        return dks().u(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> djX() throws IOException {
        return dks().djX();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dks().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long OK(String str) throws IOException {
        return dks().OK(str);
    }

    synchronized c dks() throws IOException {
        if (dkt()) {
            dku();
            dkv();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lHL.lHM);
    }

    private boolean dkt() {
        a aVar = this.lHL;
        return aVar.lHM == null || aVar.lHN == null || !aVar.lHN.exists();
    }

    void dku() {
        if (this.lHL.lHM != null && this.lHL.lHN != null) {
            com.facebook.common.file.a.ak(this.lHL.lHN);
        }
    }

    private void dkv() throws IOException {
        File file = new File(this.lHl.get(), this.lHk);
        aj(file);
        this.lHL = new a(file, new DefaultDiskStorage(file, this.mVersion, this.lHd));
    }

    void aj(File file) throws IOException {
        try {
            FileUtils.al(file);
            com.facebook.common.c.a.b(lGY, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.lHd.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lGY, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
