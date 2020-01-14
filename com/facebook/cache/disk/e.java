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
    private static final Class<?> lGr = e.class;
    private final String lGD;
    private final j<File> lGE;
    private final CacheErrorLogger lGw;
    volatile a lHe = new a(null, null);
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        public final c lHf;
        @Nullable
        public final File lHg;

        a(@Nullable File file, @Nullable c cVar) {
            this.lHf = cVar;
            this.lHg = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.lGw = cacheErrorLogger;
        this.lGE = jVar;
        this.lGD = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return djf().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a v(String str, Object obj) throws IOException {
        return djf().v(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean w(String str, Object obj) throws IOException {
        return djf().w(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void diJ() {
        try {
            djf().diJ();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lGr, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b u(String str, Object obj) throws IOException {
        return djf().u(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> diK() throws IOException {
        return djf().diK();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return djf().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Oy(String str) throws IOException {
        return djf().Oy(str);
    }

    synchronized c djf() throws IOException {
        if (djg()) {
            djh();
            dji();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lHe.lHf);
    }

    private boolean djg() {
        a aVar = this.lHe;
        return aVar.lHf == null || aVar.lHg == null || !aVar.lHg.exists();
    }

    void djh() {
        if (this.lHe.lHf != null && this.lHe.lHg != null) {
            com.facebook.common.file.a.ai(this.lHe.lHg);
        }
    }

    private void dji() throws IOException {
        File file = new File(this.lGE.get(), this.lGD);
        ah(file);
        this.lHe = new a(file, new DefaultDiskStorage(file, this.mVersion, this.lGw));
    }

    void ah(File file) throws IOException {
        try {
            FileUtils.aj(file);
            com.facebook.common.c.a.b(lGr, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.lGw.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lGr, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
