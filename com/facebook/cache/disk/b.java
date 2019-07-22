package com.facebook.cache.disk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jYf;
    private final String jYn;
    private final com.facebook.common.internal.i<File> jYo;
    private final long jYp;
    private final long jYq;
    private final long jYr;
    private final g jYs;
    private final CacheEventListener jYt;
    private final com.facebook.common.a.b jYu;
    private final boolean jYv;
    private final Context mContext;
    private final int tb;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.tb = aVar.tb;
        this.jYn = (String) com.facebook.common.internal.g.checkNotNull(aVar.jYn);
        this.jYo = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jYo);
        this.jYp = aVar.jYw;
        this.jYq = aVar.jYx;
        this.jYr = aVar.jYy;
        this.jYs = (g) com.facebook.common.internal.g.checkNotNull(aVar.jYs);
        if (aVar.jYf == null) {
            cacheErrorLogger = com.facebook.cache.common.e.cDT();
        } else {
            cacheErrorLogger = aVar.jYf;
        }
        this.jYf = cacheErrorLogger;
        if (aVar.jYt == null) {
            cacheEventListener = com.facebook.cache.common.f.cDU();
        } else {
            cacheEventListener = aVar.jYt;
        }
        this.jYt = cacheEventListener;
        if (aVar.jYu == null) {
            bVar = com.facebook.common.a.c.cEx();
        } else {
            bVar = aVar.jYu;
        }
        this.jYu = bVar;
        this.mContext = aVar.mContext;
        this.jYv = aVar.jYv;
    }

    public int getVersion() {
        return this.tb;
    }

    public String cEc() {
        return this.jYn;
    }

    public com.facebook.common.internal.i<File> cEd() {
        return this.jYo;
    }

    public long cEe() {
        return this.jYp;
    }

    public long cEf() {
        return this.jYq;
    }

    public long cEg() {
        return this.jYr;
    }

    public g cEh() {
        return this.jYs;
    }

    public CacheErrorLogger cEi() {
        return this.jYf;
    }

    public CacheEventListener cEj() {
        return this.jYt;
    }

    public com.facebook.common.a.b cEk() {
        return this.jYu;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean cEl() {
        return this.jYv;
    }

    public static a ez(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jYf;
        private String jYn;
        private com.facebook.common.internal.i<File> jYo;
        private g jYs;
        private CacheEventListener jYt;
        private com.facebook.common.a.b jYu;
        private boolean jYv;
        private long jYw;
        private long jYx;
        private long jYy;
        @Nullable
        private final Context mContext;
        private int tb;

        private a(@Nullable Context context) {
            this.tb = 1;
            this.jYn = "image_cache";
            this.jYw = 41943040L;
            this.jYx = Config.FULL_TRACE_LOG_LIMIT;
            this.jYy = 2097152L;
            this.jYs = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b cEm() {
            com.facebook.common.internal.g.c((this.jYo == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jYo == null && this.mContext != null) {
                this.jYo = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cEn */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
