package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jyT;
    private final String jzc;
    private final com.facebook.common.internal.i<File> jzd;
    private final long jze;
    private final long jzf;
    private final long jzg;
    private final g jzh;
    private final CacheEventListener jzi;
    private final com.facebook.common.a.b jzj;
    private final boolean jzk;
    private final Context mContext;
    private final int vv;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vv = aVar.vv;
        this.jzc = (String) com.facebook.common.internal.g.checkNotNull(aVar.jzc);
        this.jzd = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.jzd);
        this.jze = aVar.jzl;
        this.jzf = aVar.jzm;
        this.jzg = aVar.jzn;
        this.jzh = (g) com.facebook.common.internal.g.checkNotNull(aVar.jzh);
        if (aVar.jyT == null) {
            cacheErrorLogger = com.facebook.cache.common.e.csY();
        } else {
            cacheErrorLogger = aVar.jyT;
        }
        this.jyT = cacheErrorLogger;
        if (aVar.jzi == null) {
            cacheEventListener = com.facebook.cache.common.f.csZ();
        } else {
            cacheEventListener = aVar.jzi;
        }
        this.jzi = cacheEventListener;
        if (aVar.jzj == null) {
            bVar = com.facebook.common.a.c.ctC();
        } else {
            bVar = aVar.jzj;
        }
        this.jzj = bVar;
        this.mContext = aVar.mContext;
        this.jzk = aVar.jzk;
    }

    public int getVersion() {
        return this.vv;
    }

    public String cth() {
        return this.jzc;
    }

    public com.facebook.common.internal.i<File> cti() {
        return this.jzd;
    }

    public long ctj() {
        return this.jze;
    }

    public long ctk() {
        return this.jzf;
    }

    public long ctl() {
        return this.jzg;
    }

    public g ctm() {
        return this.jzh;
    }

    public CacheErrorLogger ctn() {
        return this.jyT;
    }

    public CacheEventListener cto() {
        return this.jzi;
    }

    public com.facebook.common.a.b ctp() {
        return this.jzj;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean ctq() {
        return this.jzk;
    }

    public static a eK(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jyT;
        private String jzc;
        private com.facebook.common.internal.i<File> jzd;
        private g jzh;
        private CacheEventListener jzi;
        private com.facebook.common.a.b jzj;
        private boolean jzk;
        private long jzl;
        private long jzm;
        private long jzn;
        @Nullable
        private final Context mContext;
        private int vv;

        private a(@Nullable Context context) {
            this.vv = 1;
            this.jzc = "image_cache";
            this.jzl = 41943040L;
            this.jzm = 10485760L;
            this.jzn = 2097152L;
            this.jzh = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b ctr() {
            com.facebook.common.internal.g.c((this.jzd == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.jzd == null && this.mContext != null) {
                this.jzd = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cts */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
