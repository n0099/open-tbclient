package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class e implements c {
    private static final Class<?> lQq = e.class;
    private final String lQC;
    private final j<File> lQD;
    private final CacheErrorLogger lQv;
    volatile a lRd = new a(null, null);
    private final int mVersion;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c lRe;
        @Nullable
        public final File lRf;

        a(@Nullable File file, @Nullable c cVar) {
            this.lRe = cVar;
            this.lRf = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.lQv = cacheErrorLogger;
        this.lQD = jVar;
        this.lQC = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return dmJ().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a A(String str, Object obj) throws IOException {
        return dmJ().A(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean B(String str, Object obj) throws IOException {
        return dmJ().B(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dmn() {
        try {
            dmJ().dmn();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lQq, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b z(String str, Object obj) throws IOException {
        return dmJ().z(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dmo() throws IOException {
        return dmJ().dmo();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dmJ().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long NV(String str) throws IOException {
        return dmJ().NV(str);
    }

    synchronized c dmJ() throws IOException {
        if (dmK()) {
            dmL();
            dmM();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lRd.lRe);
    }

    private boolean dmK() {
        a aVar = this.lRd;
        return aVar.lRe == null || aVar.lRf == null || !aVar.lRf.exists();
    }

    void dmL() {
        if (this.lRd.lRe != null && this.lRd.lRf != null) {
            com.facebook.common.file.a.af(this.lRd.lRf);
        }
    }

    private void dmM() throws IOException {
        File file = new File(this.lQD.get(), this.lQC);
        ae(file);
        this.lRd = new a(file, new DefaultDiskStorage(file, this.mVersion, this.lQv));
    }

    void ae(File file) throws IOException {
        try {
            FileUtils.ag(file);
            com.facebook.common.c.a.b(lQq, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.lQv.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, lQq, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
