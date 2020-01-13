package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class e implements c {
    private static final Class<?> lGm = e.class;
    volatile a lGZ = new a(null, null);
    private final CacheErrorLogger lGr;
    private final String lGy;
    private final j<File> lGz;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        public final c lHa;
        @Nullable
        public final File lHb;

        a(@Nullable File file, @Nullable c cVar) {
            this.lHa = cVar;
            this.lHb = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.lGr = cacheErrorLogger;
        this.lGz = jVar;
        this.lGy = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return djd().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) throws IOException {
        return djd().v(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) throws IOException {
        return djd().w(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void diH() {
        try {
            djd().diH();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lGm, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        return djd().u(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> diI() throws IOException {
        return djd().diI();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return djd().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Oy(String str) throws IOException {
        return djd().Oy(str);
    }

    synchronized c djd() throws IOException {
        if (dje()) {
            djf();
            djg();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lGZ.lHa);
    }

    private boolean dje() {
        a aVar = this.lGZ;
        return aVar.lHa == null || aVar.lHb == null || !aVar.lHb.exists();
    }

    void djf() {
        if (this.lGZ.lHa != null && this.lGZ.lHb != null) {
            com.facebook.common.file.a.ai(this.lGZ.lHb);
        }
    }

    private void djg() throws IOException {
        File file = new File(this.lGz.get(), this.lGy);
        ah(file);
        this.lGZ = new a(file, new DefaultDiskStorage(file, this.mVersion, this.lGr));
    }

    void ah(File file) throws IOException {
        try {
            FileUtils.aj(file);
            com.facebook.common.c.a.b(lGm, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.lGr.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lGm, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
