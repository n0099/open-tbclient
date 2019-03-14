package com.facebook.cache.disk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jyL;
    private final String jyU;
    private final com.facebook.common.internal.i<File> jyV;
    private final long jyW;
    private final long jyX;
    private final long jyY;
    private final g jyZ;
    private final CacheEventListener jza;
    private final com.facebook.common.a.b jzb;
    private final boolean jzc;
    private final Context mContext;
    private final int vv;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vv = aVar.vv;
        this.jyU = (String) com.facebook.common.internal.g.checkNotNull(aVar.jyU);
        this.jyV = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jyV);
        this.jyW = aVar.jzd;
        this.jyX = aVar.jze;
        this.jyY = aVar.jzf;
        this.jyZ = (g) com.facebook.common.internal.g.checkNotNull(aVar.jyZ);
        if (aVar.jyL == null) {
            cacheErrorLogger = com.facebook.cache.common.e.ctb();
        } else {
            cacheErrorLogger = aVar.jyL;
        }
        this.jyL = cacheErrorLogger;
        if (aVar.jza == null) {
            cacheEventListener = com.facebook.cache.common.f.ctc();
        } else {
            cacheEventListener = aVar.jza;
        }
        this.jza = cacheEventListener;
        if (aVar.jzb == null) {
            bVar = com.facebook.common.a.c.ctF();
        } else {
            bVar = aVar.jzb;
        }
        this.jzb = bVar;
        this.mContext = aVar.mContext;
        this.jzc = aVar.jzc;
    }

    public int getVersion() {
        return this.vv;
    }

    public String ctk() {
        return this.jyU;
    }

    public com.facebook.common.internal.i<File> ctl() {
        return this.jyV;
    }

    public long ctm() {
        return this.jyW;
    }

    public long ctn() {
        return this.jyX;
    }

    public long cto() {
        return this.jyY;
    }

    public g ctp() {
        return this.jyZ;
    }

    public CacheErrorLogger ctq() {
        return this.jyL;
    }

    public CacheEventListener ctr() {
        return this.jza;
    }

    public com.facebook.common.a.b cts() {
        return this.jzb;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean ctt() {
        return this.jzc;
    }

    public static a eJ(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jyL;
        private String jyU;
        private com.facebook.common.internal.i<File> jyV;
        private g jyZ;
        private CacheEventListener jza;
        private com.facebook.common.a.b jzb;
        private boolean jzc;
        private long jzd;
        private long jze;
        private long jzf;
        @Nullable
        private final Context mContext;
        private int vv;

        private a(@Nullable Context context) {
            this.vv = 1;
            this.jyU = "image_cache";
            this.jzd = 41943040L;
            this.jze = Config.FULL_TRACE_LOG_LIMIT;
            this.jzf = 2097152L;
            this.jyZ = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b ctu() {
            com.facebook.common.internal.g.c((this.jyV == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jyV == null && this.mContext != null) {
                this.jyV = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: ctv */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
