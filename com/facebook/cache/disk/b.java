package com.facebook.cache.disk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jyf;
    private final String jyo;
    private final com.facebook.common.internal.i<File> jyp;
    private final long jyq;
    private final long jyr;
    private final long jys;
    private final g jyt;
    private final CacheEventListener jyu;
    private final com.facebook.common.a.b jyv;
    private final boolean jyw;
    private final Context mContext;
    private final int vv;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vv = aVar.vv;
        this.jyo = (String) com.facebook.common.internal.g.checkNotNull(aVar.jyo);
        this.jyp = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jyp);
        this.jyq = aVar.jyx;
        this.jyr = aVar.jyy;
        this.jys = aVar.jyz;
        this.jyt = (g) com.facebook.common.internal.g.checkNotNull(aVar.jyt);
        if (aVar.jyf == null) {
            cacheErrorLogger = com.facebook.cache.common.e.csU();
        } else {
            cacheErrorLogger = aVar.jyf;
        }
        this.jyf = cacheErrorLogger;
        if (aVar.jyu == null) {
            cacheEventListener = com.facebook.cache.common.f.csV();
        } else {
            cacheEventListener = aVar.jyu;
        }
        this.jyu = cacheEventListener;
        if (aVar.jyv == null) {
            bVar = com.facebook.common.a.c.cty();
        } else {
            bVar = aVar.jyv;
        }
        this.jyv = bVar;
        this.mContext = aVar.mContext;
        this.jyw = aVar.jyw;
    }

    public int getVersion() {
        return this.vv;
    }

    public String ctd() {
        return this.jyo;
    }

    public com.facebook.common.internal.i<File> cte() {
        return this.jyp;
    }

    public long ctf() {
        return this.jyq;
    }

    public long ctg() {
        return this.jyr;
    }

    public long cth() {
        return this.jys;
    }

    public g cti() {
        return this.jyt;
    }

    public CacheErrorLogger ctj() {
        return this.jyf;
    }

    public CacheEventListener ctk() {
        return this.jyu;
    }

    public com.facebook.common.a.b ctl() {
        return this.jyv;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean ctm() {
        return this.jyw;
    }

    public static a eI(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jyf;
        private String jyo;
        private com.facebook.common.internal.i<File> jyp;
        private g jyt;
        private CacheEventListener jyu;
        private com.facebook.common.a.b jyv;
        private boolean jyw;
        private long jyx;
        private long jyy;
        private long jyz;
        @Nullable
        private final Context mContext;
        private int vv;

        private a(@Nullable Context context) {
            this.vv = 1;
            this.jyo = "image_cache";
            this.jyx = 41943040L;
            this.jyy = Config.FULL_TRACE_LOG_LIMIT;
            this.jyz = 2097152L;
            this.jyt = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b ctn() {
            com.facebook.common.internal.g.c((this.jyp == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jyp == null && this.mContext != null) {
                this.jyp = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
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
