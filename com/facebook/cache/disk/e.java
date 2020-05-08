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
            return dmI().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a A(String str, Object obj) throws IOException {
        return dmI().A(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean B(String str, Object obj) throws IOException {
        return dmI().B(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dmm() {
        try {
            dmI().dmm();
        } catch (IOException e) {
            com.facebook.common.c.a.b(lQq, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b z(String str, Object obj) throws IOException {
        return dmI().z(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dmn() throws IOException {
        return dmI().dmn();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return dmI().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long NV(String str) throws IOException {
        return dmI().NV(str);
    }

    synchronized c dmI() throws IOException {
        if (dmJ()) {
            dmK();
            dmL();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.lRd.lRe);
    }

    private boolean dmJ() {
        a aVar = this.lRd;
        return aVar.lRe == null || aVar.lRf == null || !aVar.lRf.exists();
    }

    void dmK() {
        if (this.lRd.lRe != null && this.lRd.lRf != null) {
            com.facebook.common.file.a.af(this.lRd.lRf);
        }
    }

    private void dmL() throws IOException {
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
