package com.facebook.cache.disk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jQX;
    private final String jRg;
    private final com.facebook.common.internal.i<File> jRh;
    private final long jRi;
    private final long jRj;
    private final long jRk;
    private final g jRl;
    private final CacheEventListener jRm;
    private final com.facebook.common.a.b jRn;
    private final boolean jRo;
    private final Context mContext;
    private final int sY;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.sY = aVar.sY;
        this.jRg = (String) com.facebook.common.internal.g.checkNotNull(aVar.jRg);
        this.jRh = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jRh);
        this.jRi = aVar.jRp;
        this.jRj = aVar.jRq;
        this.jRk = aVar.jRr;
        this.jRl = (g) com.facebook.common.internal.g.checkNotNull(aVar.jRl);
        if (aVar.jQX == null) {
            cacheErrorLogger = com.facebook.cache.common.e.cAT();
        } else {
            cacheErrorLogger = aVar.jQX;
        }
        this.jQX = cacheErrorLogger;
        if (aVar.jRm == null) {
            cacheEventListener = com.facebook.cache.common.f.cAU();
        } else {
            cacheEventListener = aVar.jRm;
        }
        this.jRm = cacheEventListener;
        if (aVar.jRn == null) {
            bVar = com.facebook.common.a.c.cBx();
        } else {
            bVar = aVar.jRn;
        }
        this.jRn = bVar;
        this.mContext = aVar.mContext;
        this.jRo = aVar.jRo;
    }

    public int getVersion() {
        return this.sY;
    }

    public String cBc() {
        return this.jRg;
    }

    public com.facebook.common.internal.i<File> cBd() {
        return this.jRh;
    }

    public long cBe() {
        return this.jRi;
    }

    public long cBf() {
        return this.jRj;
    }

    public long cBg() {
        return this.jRk;
    }

    public g cBh() {
        return this.jRl;
    }

    public CacheErrorLogger cBi() {
        return this.jQX;
    }

    public CacheEventListener cBj() {
        return this.jRm;
    }

    public com.facebook.common.a.b cBk() {
        return this.jRn;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean cBl() {
        return this.jRo;
    }

    public static a ey(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jQX;
        private String jRg;
        private com.facebook.common.internal.i<File> jRh;
        private g jRl;
        private CacheEventListener jRm;
        private com.facebook.common.a.b jRn;
        private boolean jRo;
        private long jRp;
        private long jRq;
        private long jRr;
        @Nullable
        private final Context mContext;
        private int sY;

        private a(@Nullable Context context) {
            this.sY = 1;
            this.jRg = "image_cache";
            this.jRp = 41943040L;
            this.jRq = Config.FULL_TRACE_LOG_LIMIT;
            this.jRr = 2097152L;
            this.jRl = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b cBm() {
            com.facebook.common.internal.g.c((this.jRh == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jRh == null && this.mContext != null) {
                this.jRh = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cBn */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
