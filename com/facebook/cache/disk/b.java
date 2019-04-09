package com.facebook.cache.disk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jyg;
    private final String jyp;
    private final com.facebook.common.internal.i<File> jyq;
    private final long jyr;
    private final long jys;
    private final long jyt;
    private final g jyu;
    private final CacheEventListener jyv;
    private final com.facebook.common.a.b jyw;
    private final boolean jyx;
    private final Context mContext;
    private final int vv;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vv = aVar.vv;
        this.jyp = (String) com.facebook.common.internal.g.checkNotNull(aVar.jyp);
        this.jyq = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jyq);
        this.jyr = aVar.jyy;
        this.jys = aVar.jyz;
        this.jyt = aVar.jyA;
        this.jyu = (g) com.facebook.common.internal.g.checkNotNull(aVar.jyu);
        if (aVar.jyg == null) {
            cacheErrorLogger = com.facebook.cache.common.e.csU();
        } else {
            cacheErrorLogger = aVar.jyg;
        }
        this.jyg = cacheErrorLogger;
        if (aVar.jyv == null) {
            cacheEventListener = com.facebook.cache.common.f.csV();
        } else {
            cacheEventListener = aVar.jyv;
        }
        this.jyv = cacheEventListener;
        if (aVar.jyw == null) {
            bVar = com.facebook.common.a.c.cty();
        } else {
            bVar = aVar.jyw;
        }
        this.jyw = bVar;
        this.mContext = aVar.mContext;
        this.jyx = aVar.jyx;
    }

    public int getVersion() {
        return this.vv;
    }

    public String ctd() {
        return this.jyp;
    }

    public com.facebook.common.internal.i<File> cte() {
        return this.jyq;
    }

    public long ctf() {
        return this.jyr;
    }

    public long ctg() {
        return this.jys;
    }

    public long cth() {
        return this.jyt;
    }

    public g cti() {
        return this.jyu;
    }

    public CacheErrorLogger ctj() {
        return this.jyg;
    }

    public CacheEventListener ctk() {
        return this.jyv;
    }

    public com.facebook.common.a.b ctl() {
        return this.jyw;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean ctm() {
        return this.jyx;
    }

    public static a eI(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private long jyA;
        private CacheErrorLogger jyg;
        private String jyp;
        private com.facebook.common.internal.i<File> jyq;
        private g jyu;
        private CacheEventListener jyv;
        private com.facebook.common.a.b jyw;
        private boolean jyx;
        private long jyy;
        private long jyz;
        @Nullable
        private final Context mContext;
        private int vv;

        private a(@Nullable Context context) {
            this.vv = 1;
            this.jyp = "image_cache";
            this.jyy = 41943040L;
            this.jyz = Config.FULL_TRACE_LOG_LIMIT;
            this.jyA = 2097152L;
            this.jyu = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b ctn() {
            com.facebook.common.internal.g.c((this.jyq == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jyq == null && this.mContext != null) {
                this.jyq = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cto */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
