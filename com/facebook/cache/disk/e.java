package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e implements c {
    private static final Class<?> hXm = e.class;
    private final String hXB;
    private final com.facebook.common.internal.i<File> hXC;
    private final CacheErrorLogger hXr;
    volatile a hYd = new a(null, null);
    private final int vz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c hYe;
        @Nullable
        public final File hYf;

        a(@Nullable File file, @Nullable c cVar) {
            this.hYe = cVar;
            this.hYf = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vz = i;
        this.hXr = cacheErrorLogger;
        this.hXC = iVar;
        this.hXB = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return bQL().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) throws IOException {
        return bQL().l(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) throws IOException {
        return bQL().m(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void bQp() {
        try {
            bQL().bQp();
        } catch (IOException e) {
            com.facebook.common.c.a.b(hXm, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        return bQL().k(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> bQq() throws IOException {
        return bQL().bQq();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return bQL().a(aVar);
    }

    synchronized c bQL() throws IOException {
        if (bQM()) {
            bQN();
            bQO();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.hYd.hYe);
    }

    private boolean bQM() {
        a aVar = this.hYd;
        return aVar.hYe == null || aVar.hYf == null || !aVar.hYf.exists();
    }

    void bQN() {
        if (this.hYd.hYe != null && this.hYd.hYf != null) {
            com.facebook.common.file.a.ab(this.hYd.hYf);
        }
    }

    private void bQO() throws IOException {
        File file = new File(this.hXC.get(), this.hXB);
        aa(file);
        this.hYd = new a(file, new DefaultDiskStorage(file, this.vz, this.hXr));
    }

    void aa(File file) throws IOException {
        try {
            FileUtils.ac(file);
            com.facebook.common.c.a.b(hXm, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.hXr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, hXm, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
