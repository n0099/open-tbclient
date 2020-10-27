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
    private static final Class<?> oAy = e.class;
    private final int mVersion;
    private final CacheErrorLogger oAD;
    private final String oAK;
    private final j<File> oAL;
    volatile a oBl = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        public final c oBm;
        @Nullable
        public final File oBn;

        a(@Nullable File file, @Nullable c cVar) {
            this.oBm = cVar;
            this.oBn = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.oAD = cacheErrorLogger;
        this.oAL = jVar;
        this.oAK = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return ega().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return ega().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return ega().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void efE() {
        try {
            ega().efE();
        } catch (IOException e) {
            com.facebook.common.c.a.b(oAy, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return ega().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> efF() throws IOException {
        return ega().efF();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return ega().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Xp(String str) throws IOException {
        return ega().Xp(str);
    }

    synchronized c ega() throws IOException {
        if (egb()) {
            egc();
            egd();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.oBl.oBm);
    }

    private boolean egb() {
        a aVar = this.oBl;
        return aVar.oBm == null || aVar.oBn == null || !aVar.oBn.exists();
    }

    void egc() {
        if (this.oBl.oBm != null && this.oBl.oBn != null) {
            com.facebook.common.file.a.as(this.oBl.oBn);
        }
    }

    private void egd() throws IOException {
        File file = new File(this.oAL.get(), this.oAK);
        ar(file);
        this.oBl = new a(file, new DefaultDiskStorage(file, this.mVersion, this.oAD));
    }

    void ar(File file) throws IOException {
        try {
            FileUtils.at(file);
            com.facebook.common.c.a.b(oAy, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.oAD.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, oAy, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
