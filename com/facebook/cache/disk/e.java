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
    private static final Class<?> mls = e.class;
    private final int mVersion;
    private final String mlE;
    private final j<File> mlF;
    private final CacheErrorLogger mlx;
    volatile a mmf = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c mmg;
        @Nullable
        public final File mmh;

        a(@Nullable File file, @Nullable c cVar) {
            this.mmg = cVar;
            this.mmh = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mlx = cacheErrorLogger;
        this.mlF = jVar;
        this.mlE = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return duq().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return duq().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return duq().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dtU() {
        try {
            duq().dtU();
        } catch (IOException e) {
            com.facebook.common.c.a.b(mls, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return duq().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dtV() throws IOException {
        return duq().dtV();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return duq().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long PK(String str) throws IOException {
        return duq().PK(str);
    }

    synchronized c duq() throws IOException {
        if (dur()) {
            dus();
            dut();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.mmf.mmg);
    }

    private boolean dur() {
        a aVar = this.mmf;
        return aVar.mmg == null || aVar.mmh == null || !aVar.mmh.exists();
    }

    void dus() {
        if (this.mmf.mmg != null && this.mmf.mmh != null) {
            com.facebook.common.file.a.aj(this.mmf.mmh);
        }
    }

    private void dut() throws IOException {
        File file = new File(this.mlF.get(), this.mlE);
        ai(file);
        this.mmf = new a(file, new DefaultDiskStorage(file, this.mVersion, this.mlx));
    }

    void ai(File file) throws IOException {
        try {
            FileUtils.ak(file);
            com.facebook.common.c.a.b(mls, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.mlx.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mls, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
