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
    private static final Class<?> ihJ = e.class;
    private final CacheErrorLogger ihO;
    private final String ihY;
    private final com.facebook.common.internal.i<File> ihZ;
    volatile a iiA = new a(null, null);
    private final int vz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c iiB;
        @Nullable
        public final File iiC;

        a(@Nullable File file, @Nullable c cVar) {
            this.iiB = cVar;
            this.iiC = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vz = i;
        this.ihO = cacheErrorLogger;
        this.ihZ = iVar;
        this.ihY = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return bTH().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) throws IOException {
        return bTH().l(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) throws IOException {
        return bTH().m(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void bTl() {
        try {
            bTH().bTl();
        } catch (IOException e) {
            com.facebook.common.c.a.b(ihJ, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        return bTH().k(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> bTm() throws IOException {
        return bTH().bTm();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return bTH().a(aVar);
    }

    synchronized c bTH() throws IOException {
        if (bTI()) {
            bTJ();
            bTK();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.iiA.iiB);
    }

    private boolean bTI() {
        a aVar = this.iiA;
        return aVar.iiB == null || aVar.iiC == null || !aVar.iiC.exists();
    }

    void bTJ() {
        if (this.iiA.iiB != null && this.iiA.iiC != null) {
            com.facebook.common.file.a.ac(this.iiA.iiC);
        }
    }

    private void bTK() throws IOException {
        File file = new File(this.ihZ.get(), this.ihY);
        ab(file);
        this.iiA = new a(file, new DefaultDiskStorage(file, this.vz, this.ihO));
    }

    void ab(File file) throws IOException {
        try {
            FileUtils.ad(file);
            com.facebook.common.c.a.b(ihJ, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.ihO.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, ihJ, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
