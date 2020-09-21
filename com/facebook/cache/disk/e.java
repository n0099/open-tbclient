package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class e implements c {
    private static final Class<?> ntL = e.class;
    private final int mVersion;
    private final CacheErrorLogger ntQ;
    private final String ntX;
    private final j<File> ntY;
    volatile a nuz = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        public final c nuA;
        @Nullable
        public final File nuB;

        a(@Nullable File file, @Nullable c cVar) {
            this.nuA = cVar;
            this.nuB = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.ntQ = cacheErrorLogger;
        this.ntY = jVar;
        this.ntX = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dSr().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a C(String str, Object obj) throws IOException {
        return dSr().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean D(String str, Object obj) throws IOException {
        return dSr().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dRV() {
        try {
            dSr().dRV();
        } catch (IOException e) {
            com.facebook.common.c.a.b(ntL, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b B(String str, Object obj) throws IOException {
        return dSr().B(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dRW() throws IOException {
        return dSr().dRW();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dSr().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long UO(String str) throws IOException {
        return dSr().UO(str);
    }

    synchronized c dSr() throws IOException {
        if (dSs()) {
            dSt();
            dSu();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.nuz.nuA);
    }

    private boolean dSs() {
        a aVar = this.nuz;
        return aVar.nuA == null || aVar.nuB == null || !aVar.nuB.exists();
    }

    void dSt() {
        if (this.nuz.nuA != null && this.nuz.nuB != null) {
            com.facebook.common.file.a.ao(this.nuz.nuB);
        }
    }

    private void dSu() throws IOException {
        File file = new File(this.ntY.get(), this.ntX);
        an(file);
        this.nuz = new a(file, new DefaultDiskStorage(file, this.mVersion, this.ntQ));
    }

    void an(File file) throws IOException {
        try {
            FileUtils.ap(file);
            com.facebook.common.c.a.b(ntL, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.ntQ.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, ntL, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
