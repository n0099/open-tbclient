package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class e implements c {
    private static final Class<?> paD = e.class;
    private final int mVersion;
    private final CacheErrorLogger paI;
    private final String paP;
    private final j<File> paQ;
    volatile a pbq = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {
        @Nullable
        public final c pbr;
        @Nullable
        public final File pbs;

        a(@Nullable File file, @Nullable c cVar) {
            this.pbr = cVar;
            this.pbs = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.paI = cacheErrorLogger;
        this.paQ = jVar;
        this.paP = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return epC().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a C(String str, Object obj) throws IOException {
        return epC().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean D(String str, Object obj) throws IOException {
        return epC().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void eph() {
        try {
            epC().eph();
        } catch (IOException e) {
            com.facebook.common.c.a.b(paD, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b B(String str, Object obj) throws IOException {
        return epC().B(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> epi() throws IOException {
        return epC().epi();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return epC().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long YZ(String str) throws IOException {
        return epC().YZ(str);
    }

    synchronized c epC() throws IOException {
        if (epD()) {
            epE();
            epF();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.pbq.pbr);
    }

    private boolean epD() {
        a aVar = this.pbq;
        return aVar.pbr == null || aVar.pbs == null || !aVar.pbs.exists();
    }

    void epE() {
        if (this.pbq.pbr != null && this.pbq.pbs != null) {
            com.facebook.common.file.a.au(this.pbq.pbs);
        }
    }

    private void epF() throws IOException {
        File file = new File(this.paQ.get(), this.paP);
        at(file);
        this.pbq = new a(file, new DefaultDiskStorage(file, this.mVersion, this.paI));
    }

    void at(File file) throws IOException {
        try {
            FileUtils.av(file);
            com.facebook.common.c.a.b(paD, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.paI.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, paD, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
