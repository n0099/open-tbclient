package com.facebook.cache.disk;

import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.disk.c;
import com.facebook.common.file.FileUtils;
import java.io.File;
import java.io.IOException;
import java.util.Collection;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class e implements c {
    private static final Class<?> kbD = e.class;
    private final CacheErrorLogger kbI;
    private final String kbQ;
    private final com.facebook.common.internal.i<File> kbR;
    volatile a kcr = new a(null, null);
    private final int tb;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes2.dex */
    public static class a {
        @Nullable
        public final c kcs;
        @Nullable
        public final File kct;

        a(@Nullable File file, @Nullable c cVar) {
            this.kcs = cVar;
            this.kct = file;
        }
    }

    public e(int i, com.facebook.common.internal.i<File> iVar, String str, CacheErrorLogger cacheErrorLogger) {
        this.tb = i;
        this.kbI = cacheErrorLogger;
        this.kbR = iVar;
        this.kbQ = str;
    }

    @Override // com.facebook.cache.disk.c
    public boolean isExternal() {
        try {
            return cFB().isExternal();
        } catch (IOException e) {
            return false;
        }
    }

    @Override // com.facebook.cache.disk.c
    public com.facebook.a.a r(String str, Object obj) throws IOException {
        return cFB().r(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public boolean s(String str, Object obj) throws IOException {
        return cFB().s(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public void cFf() {
        try {
            cFB().cFf();
        } catch (IOException e) {
            com.facebook.common.c.a.b(kbD, "purgeUnexpectedResources", (Throwable) e);
        }
    }

    @Override // com.facebook.cache.disk.c
    public c.b q(String str, Object obj) throws IOException {
        return cFB().q(str, obj);
    }

    @Override // com.facebook.cache.disk.c
    public Collection<c.a> cFg() throws IOException {
        return cFB().cFg();
    }

    @Override // com.facebook.cache.disk.c
    public long a(c.a aVar) throws IOException {
        return cFB().a(aVar);
    }

    synchronized c cFB() throws IOException {
        if (cFC()) {
            cFD();
            cFE();
        }
        return (c) com.facebook.common.internal.g.checkNotNull(this.kcr.kcs);
    }

    private boolean cFC() {
        a aVar = this.kcr;
        return aVar.kcs == null || aVar.kct == null || !aVar.kct.exists();
    }

    void cFD() {
        if (this.kcr.kcs != null && this.kcr.kct != null) {
            com.facebook.common.file.a.af(this.kcr.kct);
        }
    }

    private void cFE() throws IOException {
        File file = new File(this.kbR.get(), this.kbQ);
        ae(file);
        this.kcr = new a(file, new DefaultDiskStorage(file, this.tb, this.kbI));
    }

    void ae(File file) throws IOException {
        try {
            FileUtils.ag(file);
            com.facebook.common.c.a.b(kbD, "Created cache directory %s", file.getAbsolutePath());
        } catch (FileUtils.CreateDirectoryException e) {
            this.kbI.a(CacheErrorLogger.CacheErrorCategory.WRITE_CREATE_DIR, kbD, "createRootDirectoryIfNecessary", e);
            throw e;
        }
    }
}
