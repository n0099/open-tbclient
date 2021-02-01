package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import com.facebook.common.internal.j;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class e implements c {
    private static final Class<?> pxC = e.class;
    private final int mVersion;
    private final CacheErrorLogger pxH;
    private final String pxO;
    private final j<File> pxP;
    volatile a pyp = new a(null, null);

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        public final c pyq;
        @Nullable
        public final File pyr;

        a(@Nullable File file, @Nullable c cVar) {
            this.pyq = cVar;
            this.pyr = file;
        }
    }

    public e(int i, j<File> jVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.mVersion = i;
        this.pxH = cacheErrorLogger;
        this.pxP = jVar;
        this.pxO = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return esl().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a F(String str, Object obj) throws IOException {
        return esl().F(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean G(String str, Object obj) throws IOException {
        return esl().G(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void erQ() {
        try {
            esl().erQ();
        } catch (IOException e) {
            com.facebook.common.c.a.b(pxC, "purgeUnexpectedResources", e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b E(String str, Object obj) throws IOException {
        return esl().E(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> erR() throws IOException {
        return esl().erR();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return esl().a(aVar);
    }

    @Override // com.facebook.cache.disk.c
    public long Zd(String str) throws IOException {
        return esl().Zd(str);
    }

    synchronized c esl() throws IOException {
        if (esm()) {
            esn();
            eso();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.pyp.pyq);
    }

    private boolean esm() {
        a aVar = this.pyp;
        return aVar.pyq == null || aVar.pyr == null || !aVar.pyr.exists();
    }

    void esn() {
        if (this.pyp.pyq != null && this.pyp.pyr != null) {
            com.facebook.common.file.a.av(this.pyp.pyr);
        }
    }

    private void eso() throws IOException {
        File file = new File(this.pxP.get(), this.pxO);
        au(file);
        this.pyp = new a(file, new DefaultDiskStorage(file, this.mVersion, this.pxH));
    }

    void au(File file) throws IOException {
        try {
            FileUtils.aw(file);
            com.facebook.common.c.a.d(pxC, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.pxH.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, pxC, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
