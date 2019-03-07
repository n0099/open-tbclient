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
    private static final Class<?> jyv = e.class;
    private final CacheErrorLogger jyA;
    private final String jyJ;
    private final com.facebook.common.internal.i<File> jyK;
    volatile a jzk = new a(null, null);
    private final int vv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jzl;
        @Nullable
        public final File jzm;

        a(@Nullable File file, @Nullable c cVar) {
            this.jzl = cVar;
            this.jzm = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vv = i;
        this.jyA = cacheErrorLogger;
        this.jyK = iVar;
        this.jyJ = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return ctn().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) throws IOException {
        return ctn().o(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) throws IOException {
        return ctn().p(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void csR() {
        try {
            ctn().csR();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jyv, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        return ctn().n(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> csS() throws IOException {
        return ctn().csS();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return ctn().a(aVar);
    }

    synchronized c ctn() throws IOException {
        if (cto()) {
            ctp();
            ctq();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jzk.jzl);
    }

    private boolean cto() {
        a aVar = this.jzk;
        return aVar.jzl == null || aVar.jzm == null || !aVar.jzm.exists();
    }

    void ctp() {
        if (this.jzk.jzl != null && this.jzk.jzm != null) {
            com.facebook.common.file.a.al(this.jzk.jzm);
        }
    }

    private void ctq() throws IOException {
        File file = new File(this.jyK.get(), this.jyJ);
        ak(file);
        this.jzk = new a(file, new DefaultDiskStorage(file, this.vv, this.jyA));
    }

    void ak(File file) throws IOException {
        try {
            FileUtils.am(file);
            com.facebook.common.c.a.b(jyv, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jyA.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyv, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
