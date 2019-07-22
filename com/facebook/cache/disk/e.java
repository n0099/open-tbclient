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
    private static final Class<?> jYa = e.class;
    volatile a jYO = new a(null, null);
    private final CacheErrorLogger jYf;
    private final String jYn;
    private final com.facebook.common.internal.i<File> jYo;
    private final int tb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jYP;
        @Nullable
        public final File jYQ;

        a(@Nullable File file, @Nullable c cVar) {
            this.jYP = cVar;
            this.jYQ = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.tb = i;
        this.jYf = cacheErrorLogger;
        this.jYo = iVar;
        this.jYn = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return cEs().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) throws IOException {
        return cEs().r(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean s(String str, Object obj) throws IOException {
        return cEs().s(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void cDW() {
        try {
            cEs().cDW();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jYa, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b q(String str, Object obj) throws IOException {
        return cEs().q(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> cDX() throws IOException {
        return cEs().cDX();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return cEs().a(aVar);
    }

    synchronized c cEs() throws IOException {
        if (cEt()) {
            cEu();
            cEv();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jYO.jYP);
    }

    private boolean cEt() {
        a aVar = this.jYO;
        return aVar.jYP == null || aVar.jYQ == null || !aVar.jYQ.exists();
    }

    void cEu() {
        if (this.jYO.jYP != null && this.jYO.jYQ != null) {
            com.facebook.common.file.a.af(this.jYO.jYQ);
        }
    }

    private void cEv() throws IOException {
        File file = new File(this.jYo.get(), this.jYn);
        ae(file);
        this.jYO = new a(file, new DefaultDiskStorage(file, this.tb, this.jYf));
    }

    void ae(File file) throws IOException {
        try {
            FileUtils.ag(file);
            com.facebook.common.c.a.b(jYa, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jYf.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jYa, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
