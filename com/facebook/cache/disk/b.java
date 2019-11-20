package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jZb;
    private final String jZj;
    private final com.facebook.common.internal.i<File> jZk;
    private final long jZl;
    private final long jZm;
    private final long jZn;
    private final g jZo;
    private final CacheEventListener jZp;
    private final com.facebook.common.a.b jZq;
    private final boolean jZr;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.jZj = (String) com.facebook.common.internal.g.checkNotNull(aVar.jZj);
        this.jZk = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jZk);
        this.jZl = aVar.jZs;
        this.jZm = aVar.jZt;
        this.jZn = aVar.jZu;
        this.jZo = (g) com.facebook.common.internal.g.checkNotNull(aVar.jZo);
        if (aVar.jZb == null) {
            cacheErrorLogger = com.facebook.cache.common.e.cBY();
        } else {
            cacheErrorLogger = aVar.jZb;
        }
        this.jZb = cacheErrorLogger;
        if (aVar.jZp == null) {
            cacheEventListener = com.facebook.cache.common.f.cBZ();
        } else {
            cacheEventListener = aVar.jZp;
        }
        this.jZp = cacheEventListener;
        if (aVar.jZq == null) {
            bVar = com.facebook.common.a.c.cCC();
        } else {
            bVar = aVar.jZq;
        }
        this.jZq = bVar;
        this.mContext = aVar.mContext;
        this.jZr = aVar.jZr;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String cCh() {
        return this.jZj;
    }

    public com.facebook.common.internal.i<File> cCi() {
        return this.jZk;
    }

    public long cCj() {
        return this.jZl;
    }

    public long cCk() {
        return this.jZm;
    }

    public long cCl() {
        return this.jZn;
    }

    public g cCm() {
        return this.jZo;
    }

    public CacheErrorLogger cCn() {
        return this.jZb;
    }

    public CacheEventListener cCo() {
        return this.jZp;
    }

    public com.facebook.common.a.b cCp() {
        return this.jZq;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean cCq() {
        return this.jZr;
    }

    public static a eq(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jZb;
        private String jZj;
        private com.facebook.common.internal.i<File> jZk;
        private g jZo;
        private CacheEventListener jZp;
        private com.facebook.common.a.b jZq;
        private boolean jZr;
        private long jZs;
        private long jZt;
        private long jZu;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.jZj = "image_cache";
            this.jZs = 41943040L;
            this.jZt = 10485760L;
            this.jZu = 2097152L;
            this.jZo = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b cCr() {
            com.facebook.common.internal.g.d((this.jZk == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jZk == null && this.mContext != null) {
                this.jZk = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cCs */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
