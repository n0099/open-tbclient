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
    private static final Class<?> jyG = e.class;
    private final CacheErrorLogger jyL;
    private final String jyU;
    private final com.facebook.common.internal.i<File> jyV;
    volatile a jzv = new a(null, null);
    private final int vv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jzw;
        @Nullable
        public final File jzx;

        a(@Nullable File file, @Nullable c cVar) {
            this.jzw = cVar;
            this.jzx = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vv = i;
        this.jyL = cacheErrorLogger;
        this.jyV = iVar;
        this.jyU = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return ctA().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) throws IOException {
        return ctA().o(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) throws IOException {
        return ctA().p(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void cte() {
        try {
            ctA().cte();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jyG, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        return ctA().n(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> ctf() throws IOException {
        return ctA().ctf();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return ctA().a(aVar);
    }

    synchronized c ctA() throws IOException {
        if (ctB()) {
            ctC();
            ctD();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jzv.jzw);
    }

    private boolean ctB() {
        a aVar = this.jzv;
        return aVar.jzw == null || aVar.jzx == null || !aVar.jzx.exists();
    }

    void ctC() {
        if (this.jzv.jzw != null && this.jzv.jzx != null) {
            com.facebook.common.file.a.al(this.jzv.jzx);
        }
    }

    private void ctD() throws IOException {
        File file = new File(this.jyV.get(), this.jyU);
        ak(file);
        this.jzv = new a(file, new DefaultDiskStorage(file, this.vv, this.jyL));
    }

    void ak(File file) throws IOException {
        try {
            FileUtils.am(file);
            com.facebook.common.c.a.b(jyG, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jyL.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyG, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
