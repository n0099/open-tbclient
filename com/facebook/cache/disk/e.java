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
    private static final Class<?> nJf = e.class;
    private final int mVersion;
    volatile a nJS = new a(null, null);
    private final CacheErrorLogger nJk;
    private final String nJr;
    private final j<File> nJs;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        public final c nJT;
        @Nullable
        public final File nJU;

        a(@Nullable File file, @Nullable c cVar) {
            this.nJT = cVar;
            this.nJU = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.nJk = cacheErrorLogger;
        this.nJs = jVar;
        this.nJr = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dWc().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return dWc().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return dWc().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dVG() {
        try {
            dWc().dVG();
        } catch (IOException e) {
            com.facebook.common.c.a.b(nJf, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return dWc().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dVH() throws IOException {
        return dWc().dVH();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dWc().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long VC(String str) throws IOException {
        return dWc().VC(str);
    }

    synchronized c dWc() throws IOException {
        if (dWd()) {
            dWe();
            dWf();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.nJS.nJT);
    }

    private boolean dWd() {
        a aVar = this.nJS;
        return aVar.nJT == null || aVar.nJU == null || !aVar.nJU.exists();
    }

    void dWe() {
        if (this.nJS.nJT != null && this.nJS.nJU != null) {
            com.facebook.common.file.a.ar(this.nJS.nJU);
        }
    }

    private void dWf() throws IOException {
        File file = new File(this.nJs.get(), this.nJr);
        aq(file);
        this.nJS = new a(file, new DefaultDiskStorage(file, this.mVersion, this.nJk));
    }

    void aq(File file) throws IOException {
        try {
            FileUtils.as(file);
            com.facebook.common.c.a.b(nJf, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.nJk.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, nJf, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
