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
    private static final Class<?> jZg = e.class;
    volatile a jZU = new a(null, null);
    private final CacheErrorLogger jZl;
    private final String jZt;
    private final com.facebook.common.internal.i<File> jZu;
    private final int tb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jZV;
        @Nullable
        public final File jZW;

        a(@Nullable File file, @Nullable c cVar) {
            this.jZV = cVar;
            this.jZW = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.tb = i;
        this.jZl = cacheErrorLogger;
        this.jZu = iVar;
        this.jZt = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return cEN().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) throws IOException {
        return cEN().r(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean s(String str, Object obj) throws IOException {
        return cEN().s(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void cEr() {
        try {
            cEN().cEr();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jZg, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b q(String str, Object obj) throws IOException {
        return cEN().q(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> cEs() throws IOException {
        return cEN().cEs();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return cEN().a(aVar);
    }

    synchronized c cEN() throws IOException {
        if (cEO()) {
            cEP();
            cEQ();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jZU.jZV);
    }

    private boolean cEO() {
        a aVar = this.jZU;
        return aVar.jZV == null || aVar.jZW == null || !aVar.jZW.exists();
    }

    void cEP() {
        if (this.jZU.jZV != null && this.jZU.jZW != null) {
            com.facebook.common.file.a.af(this.jZU.jZW);
        }
    }

    private void cEQ() throws IOException {
        File file = new File(this.jZu.get(), this.jZt);
        ae(file);
        this.jZU = new a(file, new DefaultDiskStorage(file, this.tb, this.jZl));
    }

    void ae(File file) throws IOException {
        try {
            FileUtils.ag(file);
            com.facebook.common.c.a.b(jZg, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jZl.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jZg, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
