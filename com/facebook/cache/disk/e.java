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
    private static final Class<?> jQS = e.class;
    private final CacheErrorLogger jQX;
    volatile a jRH = new a(null, null);
    private final String jRg;
    private final com.facebook.common.internal.i<File> jRh;
    private final int sY;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jRI;
        @Nullable
        public final File jRJ;

        a(@Nullable File file, @Nullable c cVar) {
            this.jRI = cVar;
            this.jRJ = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.sY = i;
        this.jQX = cacheErrorLogger;
        this.jRh = iVar;
        this.jRg = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return cBs().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) throws IOException {
        return cBs().r(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean s(String str, Object obj) throws IOException {
        return cBs().s(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void cAW() {
        try {
            cBs().cAW();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jQS, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b q(String str, Object obj) throws IOException {
        return cBs().q(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> cAX() throws IOException {
        return cBs().cAX();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return cBs().a(aVar);
    }

    synchronized c cBs() throws IOException {
        if (cBt()) {
            cBu();
            cBv();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jRH.jRI);
    }

    private boolean cBt() {
        a aVar = this.jRH;
        return aVar.jRI == null || aVar.jRJ == null || !aVar.jRJ.exists();
    }

    void cBu() {
        if (this.jRH.jRI != null && this.jRH.jRJ != null) {
            com.facebook.common.file.a.af(this.jRH.jRJ);
        }
    }

    private void cBv() throws IOException {
        File file = new File(this.jRh.get(), this.jRg);
        ae(file);
        this.jRH = new a(file, new DefaultDiskStorage(file, this.sY, this.jQX));
    }

    void ae(File file) throws IOException {
        try {
            FileUtils.ag(file);
            com.facebook.common.c.a.b(jQS, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jQX.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jQS, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
