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
    private static final Class<?> lHl = e.class;
    volatile a lHY = new a(null, null);
    private final CacheErrorLogger lHq;
    private final String lHx;
    private final j<File> lHy;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c lHZ;
        @Nullable
        public final File lIa;

        a(@Nullable File file, @Nullable c cVar) {
            this.lHZ = cVar;
            this.lIa = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.lHq = cacheErrorLogger;
        this.lHy = jVar;
        this.lHx = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dkv().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) throws IOException {
        return dkv().v(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) throws IOException {
        return dkv().w(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void djZ() {
        try {
            dkv().djZ();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lHl, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        return dkv().u(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dka() throws IOException {
        return dkv().dka();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dkv().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long OL(String str) throws IOException {
        return dkv().OL(str);
    }

    synchronized c dkv() throws IOException {
        if (dkw()) {
            dkx();
            dky();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lHY.lHZ);
    }

    private boolean dkw() {
        a aVar = this.lHY;
        return aVar.lHZ == null || aVar.lIa == null || !aVar.lIa.exists();
    }

    void dkx() {
        if (this.lHY.lHZ != null && this.lHY.lIa != null) {
            com.facebook.common.file.a.ak(this.lHY.lIa);
        }
    }

    private void dky() throws IOException {
        File file = new File(this.lHy.get(), this.lHx);
        aj(file);
        this.lHY = new a(file, new DefaultDiskStorage(file, this.mVersion, this.lHq));
    }

    void aj(File file) throws IOException {
        try {
            FileUtils.al(file);
            com.facebook.common.c.a.b(lHl, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.lHq.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lHl, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
