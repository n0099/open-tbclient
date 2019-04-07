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
    private static final Class<?> jya = e.class;
    volatile a jyP = new a(null, null);
    private final CacheErrorLogger jyf;
    private final String jyo;
    private final com.facebook.common.internal.i<File> jyp;
    private final int vv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jyQ;
        @Nullable
        public final File jyR;

        a(@Nullable File file, @Nullable c cVar) {
            this.jyQ = cVar;
            this.jyR = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vv = i;
        this.jyf = cacheErrorLogger;
        this.jyp = iVar;
        this.jyo = str;
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
            com.facebook.common.c.a.b(jya, "purgeUnexpectedResources", (Throwable) e);
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
        return (c) com.facebook.common.internal.g.checkNotNull(this.jyP.jyQ);
    }

    private boolean ctu() {
        a aVar = this.jyP;
        return aVar.jyQ == null || aVar.jyR == null || !aVar.jyR.exists();
    }

    void ctv() {
        if (this.jyP.jyQ != null && this.jyP.jyR != null) {
            com.facebook.common.file.a.al(this.jyP.jyR);
        }
    }

    private void ctw() throws IOException {
        File file = new File(this.jyp.get(), this.jyo);
        ak(file);
        this.jyP = new a(file, new DefaultDiskStorage(file, this.vv, this.jyf));
    }

    void ak(File file) throws IOException {
        try {
            FileUtils.am(file);
            com.facebook.common.c.a.b(jya, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jyf.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jya, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
