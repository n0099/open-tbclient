package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class e implements c {
    private static final Class<?> lQm = e.class;
    volatile a lQZ = new a(null, null);
    private final CacheErrorLogger lQr;
    private final String lQy;
    private final j<File> lQz;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c lRa;
        @Nullable
        public final File lRb;

        a(@Nullable File file, @Nullable c cVar) {
            this.lRa = cVar;
            this.lRb = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.lQr = cacheErrorLogger;
        this.lQz = jVar;
        this.lQy = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dmL().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a A(String str, Object obj) throws IOException {
        return dmL().A(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean B(String str, Object obj) throws IOException {
        return dmL().B(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dmp() {
        try {
            dmL().dmp();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lQm, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b z(String str, Object obj) throws IOException {
        return dmL().z(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dmq() throws IOException {
        return dmL().dmq();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dmL().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long NS(String str) throws IOException {
        return dmL().NS(str);
    }

    synchronized c dmL() throws IOException {
        if (dmM()) {
            dmN();
            dmO();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lQZ.lRa);
    }

    private boolean dmM() {
        a aVar = this.lQZ;
        return aVar.lRa == null || aVar.lRb == null || !aVar.lRb.exists();
    }

    void dmN() {
        if (this.lQZ.lRa != null && this.lQZ.lRb != null) {
            com.facebook.common.file.a.af(this.lQZ.lRb);
        }
    }

    private void dmO() throws IOException {
        File file = new File(this.lQz.get(), this.lQy);
        ae(file);
        this.lQZ = new a(file, new DefaultDiskStorage(file, this.mVersion, this.lQr));
    }

    void ae(File file) throws IOException {
        try {
            FileUtils.ag(file);
            com.facebook.common.c.a.b(lQm, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.lQr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lQm, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
