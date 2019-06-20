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
    private static final Class<?> jQV = e.class;
    volatile a jRK = new a(null, null);
    private final CacheErrorLogger jRa;
    private final String jRj;
    private final com.facebook.common.internal.i<File> jRk;
    private final int sX;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c jRL;
        @Nullable
        public final File jRM;

        a(@Nullable File file, @Nullable c cVar) {
            this.jRL = cVar;
            this.jRM = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.sX = i;
        this.jRa = cacheErrorLogger;
        this.jRk = iVar;
        this.jRj = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return cBr().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) throws IOException {
        return cBr().r(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean s(String str, Object obj) throws IOException {
        return cBr().s(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void cAV() {
        try {
            cBr().cAV();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jQV, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b q(String str, Object obj) throws IOException {
        return cBr().q(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> cAW() throws IOException {
        return cBr().cAW();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return cBr().a(aVar);
    }

    synchronized c cBr() throws IOException {
        if (cBs()) {
            cBt();
            cBu();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.jRK.jRL);
    }

    private boolean cBs() {
        a aVar = this.jRK;
        return aVar.jRL == null || aVar.jRM == null || !aVar.jRM.exists();
    }

    void cBt() {
        if (this.jRK.jRL != null && this.jRK.jRM != null) {
            com.facebook.common.file.a.af(this.jRK.jRM);
        }
    }

    private void cBu() throws IOException {
        File file = new File(this.jRk.get(), this.jRj);
        ae(file);
        this.jRK = new a(file, new DefaultDiskStorage(file, this.sX, this.jRa));
    }

    void ae(File file) throws IOException {
        try {
            FileUtils.ag(file);
            com.facebook.common.c.a.b(jQV, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jRa.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jQV, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
