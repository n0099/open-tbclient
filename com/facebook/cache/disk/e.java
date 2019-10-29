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
    private static final Class<?> jZN = e.class;
    private final CacheErrorLogger jZS;
    volatile a kaA = new a(null, null);
    private final String kaa;
    private final com.facebook.common.internal.i<File> kab;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c kaB;
        @Nullable
        public final File kaC;

        a(@Nullable File file, @Nullable c cVar) {
            this.kaB = cVar;
            this.kaC = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.jZS = cacheErrorLogger;
        this.kab = iVar;
        this.kaa = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return cCz().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a o(String str, Object obj) throws IOException {
        return cCz().o(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean p(String str, Object obj) throws IOException {
        return cCz().p(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void cCd() {
        try {
            cCz().cCd();
        } catch (IOException e) {
            com.facebook.common.c.a.b(jZN, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b n(String str, Object obj) throws IOException {
        return cCz().n(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> cCe() throws IOException {
        return cCz().cCe();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return cCz().a(aVar);
    }

    synchronized c cCz() throws IOException {
        if (cCA()) {
            cCB();
            cCC();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.kaA.kaB);
    }

    private boolean cCA() {
        a aVar = this.kaA;
        return aVar.kaB == null || aVar.kaC == null || !aVar.kaC.exists();
    }

    void cCB() {
        if (this.kaA.kaB != null && this.kaA.kaC != null) {
            com.facebook.common.file.a.R(this.kaA.kaC);
        }
    }

    private void cCC() throws IOException {
        File file = new File(this.kab.get(), this.kaa);
        Q(file);
        this.kaA = new a(file, new DefaultDiskStorage(file, this.mVersion, this.jZS));
    }

    void Q(File file) throws IOException {
        try {
            FileUtils.S(file);
            com.facebook.common.c.a.b(jZN, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.jZS.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, jZN, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
