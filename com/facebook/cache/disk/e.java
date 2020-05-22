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
    private static final Class<?> mki = e.class;
    private final int mVersion;
    volatile a mkV = new a(null, null);
    private final CacheErrorLogger mkn;
    private final String mku;
    private final j<File> mkv;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        public final c mkW;
        @Nullable
        public final File mkX;

        a(@Nullable File file, @Nullable c cVar) {
            this.mkW = cVar;
            this.mkX = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.mkn = cacheErrorLogger;
        this.mkv = jVar;
        this.mku = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return duc().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a D(String str, Object obj) throws IOException {
        return duc().D(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean E(String str, Object obj) throws IOException {
        return duc().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void dtG() {
        try {
            duc().dtG();
        } catch (IOException e) {
            com.facebook.common.c.a.b(mki, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b C(String str, Object obj) throws IOException {
        return duc().C(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> dtH() throws IOException {
        return duc().dtH();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return duc().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long PJ(String str) throws IOException {
        return duc().PJ(str);
    }

    synchronized c duc() throws IOException {
        if (dud()) {
            due();
            duf();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.mkV.mkW);
    }

    private boolean dud() {
        a aVar = this.mkV;
        return aVar.mkW == null || aVar.mkX == null || !aVar.mkX.exists();
    }

    void due() {
        if (this.mkV.mkW != null && this.mkV.mkX != null) {
            com.facebook.common.file.a.aj(this.mkV.mkX);
        }
    }

    private void duf() throws IOException {
        File file = new File(this.mkv.get(), this.mku);
        ai(file);
        this.mkV = new a(file, new DefaultDiskStorage(file, this.mVersion, this.mkn));
    }

    void ai(File file) throws IOException {
        try {
            FileUtils.ak(file);
            com.facebook.common.c.a.b(mki, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.mkn.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, mki, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
