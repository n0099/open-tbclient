package com.facebook.cache.disk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final com.facebook.common.a.b jZA;
    private final boolean jZB;
    private final CacheErrorLogger jZl;
    private final String jZt;
    private final com.facebook.common.internal.i<File> jZu;
    private final long jZv;
    private final long jZw;
    private final long jZx;
    private final g jZy;
    private final CacheEventListener jZz;
    private final Context mContext;
    private final int tb;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.tb = aVar.tb;
        this.jZt = (String) com.facebook.common.internal.g.checkNotNull(aVar.jZt);
        this.jZu = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jZu);
        this.jZv = aVar.jZC;
        this.jZw = aVar.jZD;
        this.jZx = aVar.jZE;
        this.jZy = (g) com.facebook.common.internal.g.checkNotNull(aVar.jZy);
        if (aVar.jZl == null) {
            cacheErrorLogger = com.facebook.cache.common.e.cEo();
        } else {
            cacheErrorLogger = aVar.jZl;
        }
        this.jZl = cacheErrorLogger;
        if (aVar.jZz == null) {
            cacheEventListener = com.facebook.cache.common.f.cEp();
        } else {
            cacheEventListener = aVar.jZz;
        }
        this.jZz = cacheEventListener;
        if (aVar.jZA == null) {
            bVar = com.facebook.common.a.c.cES();
        } else {
            bVar = aVar.jZA;
        }
        this.jZA = bVar;
        this.mContext = aVar.mContext;
        this.jZB = aVar.jZB;
    }

    public int getVersion() {
        return this.tb;
    }

    public String cEx() {
        return this.jZt;
    }

    public com.facebook.common.internal.i<File> cEy() {
        return this.jZu;
    }

    public long cEz() {
        return this.jZv;
    }

    public long cEA() {
        return this.jZw;
    }

    public long cEB() {
        return this.jZx;
    }

    public g cEC() {
        return this.jZy;
    }

    public CacheErrorLogger cED() {
        return this.jZl;
    }

    public CacheEventListener cEE() {
        return this.jZz;
    }

    public com.facebook.common.a.b cEF() {
        return this.jZA;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean cEG() {
        return this.jZB;
    }

    public static a eA(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private com.facebook.common.a.b jZA;
        private boolean jZB;
        private long jZC;
        private long jZD;
        private long jZE;
        private CacheErrorLogger jZl;
        private String jZt;
        private com.facebook.common.internal.i<File> jZu;
        private g jZy;
        private CacheEventListener jZz;
        @Nullable
        private final Context mContext;
        private int tb;

        private a(@Nullable Context context) {
            this.tb = 1;
            this.jZt = "image_cache";
            this.jZC = 41943040L;
            this.jZD = Config.FULL_TRACE_LOG_LIMIT;
            this.jZE = 2097152L;
            this.jZy = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b cEH() {
            com.facebook.common.internal.g.c((this.jZu == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jZu == null && this.mContext != null) {
                this.jZu = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cEI */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
