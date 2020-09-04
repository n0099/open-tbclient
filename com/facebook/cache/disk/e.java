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
    private static final Class<?> njM = e.class;
    private final int mVersion;
    private final CacheErrorLogger njR;
    private final String njY;
    private final j<File> njZ;
    volatile a nkz = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes8.dex */
    public static class a {
        @Nullable
        public final c nkA;
        @Nullable
        public final File nkB;

        a(@Nullable File file, @Nullable c cVar) {
            this.nkA = cVar;
            this.nkB = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.njR = cacheErrorLogger;
        this.njZ = jVar;
        this.njY = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dOt().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a C(String str, Object obj) throws IOException {
        return dOt().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean D(String str, Object obj) throws IOException {
        return dOt().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dNX() {
        try {
            dOt().dNX();
        } catch (IOException e) {
            com.facebook.common.c.a.b(njM, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b B(String str, Object obj) throws IOException {
        return dOt().B(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dNY() throws IOException {
        return dOt().dNY();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dOt().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Um(String str) throws IOException {
        return dOt().Um(str);
    }

    synchronized c dOt() throws IOException {
        if (dOu()) {
            dOv();
            dOw();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.nkz.nkA);
    }

    private boolean dOu() {
        a aVar = this.nkz;
        return aVar.nkA == null || aVar.nkB == null || !aVar.nkB.exists();
    }

    void dOv() {
        if (this.nkz.nkA != null && this.nkz.nkB != null) {
            com.facebook.common.file.a.ao(this.nkz.nkB);
        }
    }

    private void dOw() throws IOException {
        File file = new File(this.njZ.get(), this.njY);
        an(file);
        this.nkz = new a(file, new DefaultDiskStorage(file, this.mVersion, this.njR));
    }

    void an(File file) throws IOException {
        try {
            FileUtils.ap(file);
            com.facebook.common.c.a.b(njM, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.njR.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, njM, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
