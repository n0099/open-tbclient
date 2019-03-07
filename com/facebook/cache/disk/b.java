package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jyA;
    private final String jyJ;
    private final com.facebook.common.internal.i<File> jyK;
    private final long jyL;
    private final long jyM;
    private final long jyN;
    private final g jyO;
    private final CacheEventListener jyP;
    private final com.facebook.common.a.b jyQ;
    private final boolean jyR;
    private final Context mContext;
    private final int vv;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vv = aVar.vv;
        this.jyJ = (String) com.facebook.common.internal.g.checkNotNull(aVar.jyJ);
        this.jyK = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jyK);
        this.jyL = aVar.jyS;
        this.jyM = aVar.jyT;
        this.jyN = aVar.jyU;
        this.jyO = (g) com.facebook.common.internal.g.checkNotNull(aVar.jyO);
        if (aVar.jyA == null) {
            cacheErrorLogger = com.facebook.cache.common.e.csO();
        } else {
            cacheErrorLogger = aVar.jyA;
        }
        this.jyA = cacheErrorLogger;
        if (aVar.jyP == null) {
            cacheEventListener = com.facebook.cache.common.f.csP();
        } else {
            cacheEventListener = aVar.jyP;
        }
        this.jyP = cacheEventListener;
        if (aVar.jyQ == null) {
            bVar = com.facebook.common.a.c.cts();
        } else {
            bVar = aVar.jyQ;
        }
        this.jyQ = bVar;
        this.mContext = aVar.mContext;
        this.jyR = aVar.jyR;
    }

    public int getVersion() {
        return this.vv;
    }

    public String csX() {
        return this.jyJ;
    }

    public com.facebook.common.internal.i<File> csY() {
        return this.jyK;
    }

    public long csZ() {
        return this.jyL;
    }

    public long cta() {
        return this.jyM;
    }

    public long ctb() {
        return this.jyN;
    }

    public g ctc() {
        return this.jyO;
    }

    public CacheErrorLogger ctd() {
        return this.jyA;
    }

    public CacheEventListener cte() {
        return this.jyP;
    }

    public com.facebook.common.a.b ctf() {
        return this.jyQ;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean ctg() {
        return this.jyR;
    }

    public static a eK(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jyA;
        private String jyJ;
        private com.facebook.common.internal.i<File> jyK;
        private g jyO;
        private CacheEventListener jyP;
        private com.facebook.common.a.b jyQ;
        private boolean jyR;
        private long jyS;
        private long jyT;
        private long jyU;
        @Nullable
        private final Context mContext;
        private int vv;

        private a(@Nullable Context context) {
            this.vv = 1;
            this.jyJ = "image_cache";
            this.jyS = 41943040L;
            this.jyT = 10485760L;
            this.jyU = 2097152L;
            this.jyO = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b cth() {
            com.facebook.common.internal.g.c((this.jyK == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jyK == null && this.mContext != null) {
                this.jyK = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cti */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
