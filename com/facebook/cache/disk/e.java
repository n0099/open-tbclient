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
    private static final Class<?> jyb = e.class;
    volatile a jyQ = new a(null, null);
    private final CacheErrorLogger jyg;
    private final String jyp;
    private final com.facebook.common.internal.i<File> jyq;
    private final int vv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jyR;
        @Nullable
        public final File jyS;

        a(@Nullable File file, @Nullable c cVar) {
            this.jyR = cVar;
            this.jyS = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vv = i;
        this.jyg = cacheErrorLogger;
        this.jyq = iVar;
        this.jyp = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return ctt().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) throws IOException {
        return ctt().o(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) throws IOException {
        return ctt().p(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void csX() {
        try {
            ctt().csX();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jyb, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        return ctt().n(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> csY() throws IOException {
        return ctt().csY();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return ctt().a(aVar);
    }

    synchronized c ctt() throws IOException {
        if (ctu()) {
            ctv();
            ctw();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jyQ.jyR);
    }

    private boolean ctu() {
        a aVar = this.jyQ;
        return aVar.jyR == null || aVar.jyS == null || !aVar.jyS.exists();
    }

    void ctv() {
        if (this.jyQ.jyR != null && this.jyQ.jyS != null) {
            com.facebook.common.file.a.al(this.jyQ.jyS);
        }
    }

    private void ctw() throws IOException {
        File file = new File(this.jyq.get(), this.jyp);
        ak(file);
        this.jyQ = new a(file, new DefaultDiskStorage(file, this.vv, this.jyg));
    }

    void ak(File file) throws IOException {
        try {
            FileUtils.am(file);
            com.facebook.common.c.a.b(jyb, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jyg.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jyb, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
