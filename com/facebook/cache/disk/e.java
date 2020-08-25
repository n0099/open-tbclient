package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class e implements c {
    private static final Class<?> nju = e.class;
    private final int mVersion;
    private final String njG;
    private final j<File> njH;
    private final CacheErrorLogger njz;
    volatile a nkh = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        @Nullable
        public final c nki;
        @Nullable
        public final File nkj;

        a(@Nullable File file, @Nullable c cVar) {
            this.nki = cVar;
            this.nkj = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.njz = cacheErrorLogger;
        this.njH = jVar;
        this.njG = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dOk().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a C(String str, Object obj) throws IOException {
        return dOk().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean D(String str, Object obj) throws IOException {
        return dOk().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dNO() {
        try {
            dOk().dNO();
        } catch (IOException e) {
            com.facebook.common.c.a.b(nju, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b B(String str, Object obj) throws IOException {
        return dOk().B(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dNP() throws IOException {
        return dOk().dNP();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dOk().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Um(String str) throws IOException {
        return dOk().Um(str);
    }

    synchronized c dOk() throws IOException {
        if (dOl()) {
            dOm();
            dOn();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.nkh.nki);
    }

    private boolean dOl() {
        a aVar = this.nkh;
        return aVar.nki == null || aVar.nkj == null || !aVar.nkj.exists();
    }

    void dOm() {
        if (this.nkh.nki != null && this.nkh.nkj != null) {
            com.facebook.common.file.a.ao(this.nkh.nkj);
        }
    }

    private void dOn() throws IOException {
        File file = new File(this.njH.get(), this.njG);
        an(file);
        this.nkh = new a(file, new DefaultDiskStorage(file, this.mVersion, this.njz));
    }

    void an(File file) throws IOException {
        try {
            FileUtils.ap(file);
            com.facebook.common.c.a.b(nju, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.njz.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, nju, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
