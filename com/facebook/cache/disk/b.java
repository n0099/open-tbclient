package com.facebook.cache.disk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jRa;
    private final String jRj;
    private final com.facebook.common.internal.i<File> jRk;
    private final long jRl;
    private final long jRm;
    private final long jRn;
    private final g jRo;
    private final CacheEventListener jRp;
    private final com.facebook.common.a.b jRq;
    private final boolean jRr;
    private final Context mContext;
    private final int sX;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.sX = aVar.sX;
        this.jRj = (String) com.facebook.common.internal.g.checkNotNull(aVar.jRj);
        this.jRk = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jRk);
        this.jRl = aVar.jRs;
        this.jRm = aVar.jRt;
        this.jRn = aVar.jRu;
        this.jRo = (g) com.facebook.common.internal.g.checkNotNull(aVar.jRo);
        if (aVar.jRa == null) {
            cacheErrorLogger = com.facebook.cache.common.e.cAS();
        } else {
            cacheErrorLogger = aVar.jRa;
        }
        this.jRa = cacheErrorLogger;
        if (aVar.jRp == null) {
            cacheEventListener = com.facebook.cache.common.f.cAT();
        } else {
            cacheEventListener = aVar.jRp;
        }
        this.jRp = cacheEventListener;
        if (aVar.jRq == null) {
            bVar = com.facebook.common.a.c.cBw();
        } else {
            bVar = aVar.jRq;
        }
        this.jRq = bVar;
        this.mContext = aVar.mContext;
        this.jRr = aVar.jRr;
    }

    public int getVersion() {
        return this.sX;
    }

    public String cBb() {
        return this.jRj;
    }

    public com.facebook.common.internal.i<File> cBc() {
        return this.jRk;
    }

    public long cBd() {
        return this.jRl;
    }

    public long cBe() {
        return this.jRm;
    }

    public long cBf() {
        return this.jRn;
    }

    public g cBg() {
        return this.jRo;
    }

    public CacheErrorLogger cBh() {
        return this.jRa;
    }

    public CacheEventListener cBi() {
        return this.jRp;
    }

    public com.facebook.common.a.b cBj() {
        return this.jRq;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean cBk() {
        return this.jRr;
    }

    public static a ey(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jRa;
        private String jRj;
        private com.facebook.common.internal.i<File> jRk;
        private g jRo;
        private CacheEventListener jRp;
        private com.facebook.common.a.b jRq;
        private boolean jRr;
        private long jRs;
        private long jRt;
        private long jRu;
        @Nullable
        private final Context mContext;
        private int sX;

        private a(@Nullable Context context) {
            this.sX = 1;
            this.jRj = "image_cache";
            this.jRs = 41943040L;
            this.jRt = Config.FULL_TRACE_LOG_LIMIT;
            this.jRu = 2097152L;
            this.jRo = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b cBl() {
            com.facebook.common.internal.g.c((this.jRk == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jRk == null && this.mContext != null) {
                this.jRk = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cBm */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
