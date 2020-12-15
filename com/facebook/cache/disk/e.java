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
    private static final Class<?> paF = e.class;
    private final int mVersion;
    private final CacheErrorLogger paK;
    private final String paR;
    private final j<File> paS;
    volatile a pbs = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {
        @Nullable
        public final c pbt;
        @Nullable
        public final File pbu;

        a(@Nullable File file, @Nullable c cVar) {
            this.pbt = cVar;
            this.pbu = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.paK = cacheErrorLogger;
        this.paS = jVar;
        this.paR = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return epD().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a C(String str, Object obj) throws IOException {
        return epD().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean D(String str, Object obj) throws IOException {
        return epD().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void epi() {
        try {
            epD().epi();
        } catch (IOException e) {
            com.facebook.common.c.a.b(paF, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b B(String str, Object obj) throws IOException {
        return epD().B(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> epj() throws IOException {
        return epD().epj();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return epD().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long YZ(String str) throws IOException {
        return epD().YZ(str);
    }

    synchronized c epD() throws IOException {
        if (epE()) {
            epF();
            epG();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.pbs.pbt);
    }

    private boolean epE() {
        a aVar = this.pbs;
        return aVar.pbt == null || aVar.pbu == null || !aVar.pbu.exists();
    }

    void epF() {
        if (this.pbs.pbt != null && this.pbs.pbu != null) {
            com.facebook.common.file.a.au(this.pbs.pbu);
        }
    }

    private void epG() throws IOException {
        File file = new File(this.paS.get(), this.paR);
        at(file);
        this.pbs = new a(file, new DefaultDiskStorage(file, this.mVersion, this.paK));
    }

    void at(File file) throws IOException {
        try {
            FileUtils.av(file);
            com.facebook.common.c.a.b(paF, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.paK.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, paF, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
