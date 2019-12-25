package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class e implements c {
    private static final Class<?> lCO = e.class;
    private final CacheErrorLogger lCT;
    volatile a lDB = new a(null, null);
    private final String lDa;
    private final j<File> lDb;
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a {
        @Nullable
        public final c lDC;
        @Nullable
        public final File lDD;

        a(@Nullable File file, @Nullable c cVar) {
            this.lDC = cVar;
            this.lDD = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.lCT = cacheErrorLogger;
        this.lDb = jVar;
        this.lDa = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dic().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) throws IOException {
        return dic().v(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) throws IOException {
        return dic().w(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dhG() {
        try {
            dic().dhG();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lCO, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        return dic().u(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dhH() throws IOException {
        return dic().dhH();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dic().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Oo(String str) throws IOException {
        return dic().Oo(str);
    }

    synchronized c dic() throws IOException {
        if (did()) {
            die();
            dif();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lDB.lDC);
    }

    private boolean did() {
        a aVar = this.lDB;
        return aVar.lDC == null || aVar.lDD == null || !aVar.lDD.exists();
    }

    void die() {
        if (this.lDB.lDC != null && this.lDB.lDD != null) {
            com.facebook.common.file.a.ai(this.lDB.lDD);
        }
    }

    private void dif() throws IOException {
        File file = new File(this.lDb.get(), this.lDa);
        ah(file);
        this.lDB = new a(file, new DefaultDiskStorage(file, this.mVersion, this.lCT));
    }

    void ah(File file) throws IOException {
        try {
            FileUtils.aj(file);
            com.facebook.common.c.a.b(lCO, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.lCT.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lCO, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
