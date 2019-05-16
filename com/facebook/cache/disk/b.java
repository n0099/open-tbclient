package com.facebook.cache.disk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jQW;
    private final String jRf;
    private final com.facebook.common.internal.i<File> jRg;
    private final long jRh;
    private final long jRi;
    private final long jRj;
    private final g jRk;
    private final CacheEventListener jRl;
    private final com.facebook.common.a.b jRm;
    private final boolean jRn;
    private final Context mContext;
    private final int sY;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.sY = aVar.sY;
        this.jRf = (String) com.facebook.common.internal.g.checkNotNull(aVar.jRf);
        this.jRg = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jRg);
        this.jRh = aVar.jRo;
        this.jRi = aVar.jRp;
        this.jRj = aVar.jRq;
        this.jRk = (g) com.facebook.common.internal.g.checkNotNull(aVar.jRk);
        if (aVar.jQW == null) {
            cacheErrorLogger = com.facebook.cache.common.e.cAR();
        } else {
            cacheErrorLogger = aVar.jQW;
        }
        this.jQW = cacheErrorLogger;
        if (aVar.jRl == null) {
            cacheEventListener = com.facebook.cache.common.f.cAS();
        } else {
            cacheEventListener = aVar.jRl;
        }
        this.jRl = cacheEventListener;
        if (aVar.jRm == null) {
            bVar = com.facebook.common.a.c.cBv();
        } else {
            bVar = aVar.jRm;
        }
        this.jRm = bVar;
        this.mContext = aVar.mContext;
        this.jRn = aVar.jRn;
    }

    public int getVersion() {
        return this.sY;
    }

    public String cBa() {
        return this.jRf;
    }

    public com.facebook.common.internal.i<File> cBb() {
        return this.jRg;
    }

    public long cBc() {
        return this.jRh;
    }

    public long cBd() {
        return this.jRi;
    }

    public long cBe() {
        return this.jRj;
    }

    public g cBf() {
        return this.jRk;
    }

    public CacheErrorLogger cBg() {
        return this.jQW;
    }

    public CacheEventListener cBh() {
        return this.jRl;
    }

    public com.facebook.common.a.b cBi() {
        return this.jRm;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean cBj() {
        return this.jRn;
    }

    public static a ey(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jQW;
        private String jRf;
        private com.facebook.common.internal.i<File> jRg;
        private g jRk;
        private CacheEventListener jRl;
        private com.facebook.common.a.b jRm;
        private boolean jRn;
        private long jRo;
        private long jRp;
        private long jRq;
        @Nullable
        private final Context mContext;
        private int sY;

        private a(@Nullable Context context) {
            this.sY = 1;
            this.jRf = "image_cache";
            this.jRo = 41943040L;
            this.jRp = Config.FULL_TRACE_LOG_LIMIT;
            this.jRq = 2097152L;
            this.jRk = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b cBk() {
            com.facebook.common.internal.g.c((this.jRg == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jRg == null && this.mContext != null) {
                this.jRg = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cBl */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
