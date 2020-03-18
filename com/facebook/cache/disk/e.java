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
    private static final Class<?> lIR = e.class;
    private final CacheErrorLogger lIW;
    volatile a lJE = new a(null, null);
    private final String lJd;
    private final j<File> lJe;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c lJF;
        @Nullable
        public final File lJG;

        a(@Nullable File file, @Nullable c cVar) {
            this.lJF = cVar;
            this.lJG = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.lIW = cacheErrorLogger;
        this.lJe = jVar;
        this.lJd = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dkS().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) throws IOException {
        return dkS().v(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) throws IOException {
        return dkS().w(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dkw() {
        try {
            dkS().dkw();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lIR, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        return dkS().u(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dkx() throws IOException {
        return dkS().dkx();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dkS().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long OK(String str) throws IOException {
        return dkS().OK(str);
    }

    synchronized c dkS() throws IOException {
        if (dkT()) {
            dkU();
            dkV();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lJE.lJF);
    }

    private boolean dkT() {
        a aVar = this.lJE;
        return aVar.lJF == null || aVar.lJG == null || !aVar.lJG.exists();
    }

    void dkU() {
        if (this.lJE.lJF != null && this.lJE.lJG != null) {
            com.facebook.common.file.a.ak(this.lJE.lJG);
        }
    }

    private void dkV() throws IOException {
        File file = new File(this.lJe.get(), this.lJd);
        aj(file);
        this.lJE = new a(file, new DefaultDiskStorage(file, this.mVersion, this.lIW));
    }

    void aj(File file) throws IOException {
        try {
            FileUtils.al(file);
            com.facebook.common.c.a.b(lIR, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.lIW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lIR, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
