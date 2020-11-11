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
    private static final Class<?> oJR = e.class;
    private final int mVersion;
    private final CacheErrorLogger oJW;
    volatile a oKE = new a(null, null);
    private final String oKd;
    private final j<File> oKe;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        public final c oKF;
        @Nullable
        public final File oKG;

        a(@Nullable File file, @Nullable c cVar) {
            this.oKF = cVar;
            this.oKG = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.oJW = cacheErrorLogger;
        this.oKe = jVar;
        this.oKd = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return ejP().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return ejP().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return ejP().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void ejt() {
        try {
            ejP().ejt();
        } catch (IOException e) {
            com.facebook.common.c.a.b(oJR, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return ejP().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> eju() throws IOException {
        return ejP().eju();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return ejP().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long XT(String str) throws IOException {
        return ejP().XT(str);
    }

    synchronized c ejP() throws IOException {
        if (ejQ()) {
            ejR();
            ejS();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.oKE.oKF);
    }

    private boolean ejQ() {
        a aVar = this.oKE;
        return aVar.oKF == null || aVar.oKG == null || !aVar.oKG.exists();
    }

    void ejR() {
        if (this.oKE.oKF != null && this.oKE.oKG != null) {
            com.facebook.common.file.a.as(this.oKE.oKG);
        }
    }

    private void ejS() throws IOException {
        File file = new File(this.oKe.get(), this.oKd);
        ar(file);
        this.oKE = new a(file, new DefaultDiskStorage(file, this.mVersion, this.oJW));
    }

    void ar(File file) throws IOException {
        try {
            FileUtils.at(file);
            com.facebook.common.c.a.b(oJR, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.oJW.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, oJR, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
