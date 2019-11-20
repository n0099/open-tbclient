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
    private static final Class<?> jYW = e.class;
    volatile a jZJ = new a(null, null);
    private final CacheErrorLogger jZb;
    private final String jZj;
    private final com.facebook.common.internal.i<File> jZk;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jZK;
        @Nullable
        public final File jZL;

        a(@Nullable File file, @Nullable c cVar) {
            this.jZK = cVar;
            this.jZL = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.jZb = cacheErrorLogger;
        this.jZk = iVar;
        this.jZj = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return cCx().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) throws IOException {
        return cCx().o(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) throws IOException {
        return cCx().p(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void cCb() {
        try {
            cCx().cCb();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jYW, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        return cCx().n(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> cCc() throws IOException {
        return cCx().cCc();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return cCx().a(aVar);
    }

    synchronized c cCx() throws IOException {
        if (cCy()) {
            cCz();
            cCA();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jZJ.jZK);
    }

    private boolean cCy() {
        a aVar = this.jZJ;
        return aVar.jZK == null || aVar.jZL == null || !aVar.jZL.exists();
    }

    void cCz() {
        if (this.jZJ.jZK != null && this.jZJ.jZL != null) {
            com.facebook.common.file.a.R(this.jZJ.jZL);
        }
    }

    private void cCA() throws IOException {
        File file = new File(this.jZk.get(), this.jZj);
        Q(file);
        this.jZJ = new a(file, new DefaultDiskStorage(file, this.mVersion, this.jZb));
    }

    void Q(File file) throws IOException {
        try {
            FileUtils.S(file);
            com.facebook.common.c.a.b(jYW, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jZb.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jYW, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
