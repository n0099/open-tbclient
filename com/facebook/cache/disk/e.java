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
    private static final Class<?> iez = e.class;
    private final CacheErrorLogger ieE;
    private final String ieO;
    private final com.facebook.common.internal.i<File> ieP;
    volatile a ifq = new a(null, null);
    private final int vz;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c ifr;
        @Nullable
        public final File ifs;

        a(@Nullable File file, @Nullable c cVar) {
            this.ifr = cVar;
            this.ifs = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.vz = i;
        this.ieE = cacheErrorLogger;
        this.ieP = iVar;
        this.ieO = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return bSQ().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a l(String str, Object obj) throws IOException {
        return bSQ().l(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean m(String str, Object obj) throws IOException {
        return bSQ().m(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void bSu() {
        try {
            bSQ().bSu();
        } catch (IOException e) {
            com.facebook.common.c.a.b(iez, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b k(String str, Object obj) throws IOException {
        return bSQ().k(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> bSv() throws IOException {
        return bSQ().bSv();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return bSQ().a(aVar);
    }

    synchronized c bSQ() throws IOException {
        if (bSR()) {
            bSS();
            bST();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.ifq.ifr);
    }

    private boolean bSR() {
        a aVar = this.ifq;
        return aVar.ifr == null || aVar.ifs == null || !aVar.ifs.exists();
    }

    void bSS() {
        if (this.ifq.ifr != null && this.ifq.ifs != null) {
            com.facebook.common.file.a.ac(this.ifq.ifs);
        }
    }

    private void bST() throws IOException {
        File file = new File(this.ieP.get(), this.ieO);
        ab(file);
        this.ifq = new a(file, new DefaultDiskStorage(file, this.vz, this.ieE));
    }

    void ab(File file) throws IOException {
        try {
            FileUtils.ad(file);
            com.facebook.common.c.a.b(iez, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.ieE.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, iez, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
