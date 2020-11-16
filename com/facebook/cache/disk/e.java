package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public class e implements c {
    private static final Class<?> oLv = e.class;
    private final int mVersion;
    private final CacheErrorLogger oLA;
    private final String oLH;
    private final j<File> oLI;
    volatile a oMi = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes17.dex */
    public static class a {
        @Nullable
        public final c oMj;
        @Nullable
        public final File oMk;

        a(@Nullable File file, @Nullable c cVar) {
            this.oMj = cVar;
            this.oMk = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.oLA = cacheErrorLogger;
        this.oLI = jVar;
        this.oLH = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return ejN().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return ejN().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return ejN().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void ejr() {
        try {
            ejN().ejr();
        } catch (IOException e) {
            com.facebook.common.c.a.b(oLv, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return ejN().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> ejs() throws IOException {
        return ejN().ejs();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return ejN().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long XE(String str) throws IOException {
        return ejN().XE(str);
    }

    synchronized c ejN() throws IOException {
        if (ejO()) {
            ejP();
            ejQ();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.oMi.oMj);
    }

    private boolean ejO() {
        a aVar = this.oMi;
        return aVar.oMj == null || aVar.oMk == null || !aVar.oMk.exists();
    }

    void ejP() {
        if (this.oMi.oMj != null && this.oMi.oMk != null) {
            com.facebook.common.file.a.as(this.oMi.oMk);
        }
    }

    private void ejQ() throws IOException {
        File file = new File(this.oLI.get(), this.oLH);
        ar(file);
        this.oMi = new a(file, new DefaultDiskStorage(file, this.mVersion, this.oLA));
    }

    void ar(File file) throws IOException {
        try {
            FileUtils.at(file);
            com.facebook.common.c.a.b(oLv, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.oLA.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, oLv, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
