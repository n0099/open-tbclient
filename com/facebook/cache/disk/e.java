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
    private static final Class<?> jyO = e.class;
    private final CacheErrorLogger jyT;
    volatile a jzD = new a(null, null);
    private final String jzc;
    private final com.facebook.common.internal.i<File> jzd;
    private final int vv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jzE;
        @Nullable
        public final File jzF;

        a(@Nullable File file, @Nullable c cVar) {
            this.jzE = cVar;
            this.jzF = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vv = i;
        this.jyT = cacheErrorLogger;
        this.jzd = iVar;
        this.jzc = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return ctx().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) throws IOException {
        return ctx().o(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) throws IOException {
        return ctx().p(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void ctb() {
        try {
            ctx().ctb();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jyO, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        return ctx().n(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> ctc() throws IOException {
        return ctx().ctc();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return ctx().a(aVar);
    }

    synchronized c ctx() throws IOException {
        if (cty()) {
            ctz();
            ctA();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jzD.jzE);
    }

    private boolean cty() {
        a aVar = this.jzD;
        return aVar.jzE == null || aVar.jzF == null || !aVar.jzF.exists();
    }

    void ctz() {
        if (this.jzD.jzE != null && this.jzD.jzF != null) {
            com.facebook.common.file.a.al(this.jzD.jzF);
        }
    }

    private void ctA() throws IOException {
        File file = new File(this.jzd.get(), this.jzc);
        ak(file);
        this.jzD = new a(file, new DefaultDiskStorage(file, this.vv, this.jyT));
    }

    void ak(File file) throws IOException {
        try {
            FileUtils.am(file);
            com.facebook.common.c.a.b(jyO, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jyT.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyO, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
