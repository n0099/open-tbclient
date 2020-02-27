package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import com.facebook.common.internal.k;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b {
    private final CacheErrorLogger lHd;
    private final String lHk;
    private final j<File> lHl;
    private final long lHm;
    private final long lHn;
    private final long lHo;
    private final g lHp;
    private final CacheEventListener lHq;
    private final com.facebook.common.a.b lHr;
    private final boolean lHs;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.lHk = (String) com.facebook.common.internal.g.checkNotNull(aVar.lHk);
        this.lHl = (j) com.facebook.common.internal.g.checkNotNull(aVar.lHl);
        this.lHm = aVar.lHt;
        this.lHn = aVar.lHu;
        this.lHo = aVar.lHv;
        this.lHp = (g) com.facebook.common.internal.g.checkNotNull(aVar.lHp);
        if (aVar.lHd == null) {
            cacheErrorLogger = com.facebook.cache.common.e.djT();
        } else {
            cacheErrorLogger = aVar.lHd;
        }
        this.lHd = cacheErrorLogger;
        if (aVar.lHq == null) {
            cacheEventListener = com.facebook.cache.common.f.djU();
        } else {
            cacheEventListener = aVar.lHq;
        }
        this.lHq = cacheEventListener;
        if (aVar.lHr == null) {
            bVar = com.facebook.common.a.c.dkx();
        } else {
            bVar = aVar.lHr;
        }
        this.lHr = bVar;
        this.mContext = aVar.mContext;
        this.lHs = aVar.lHs;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dkc() {
        return this.lHk;
    }

    public j<File> dkd() {
        return this.lHl;
    }

    public long dke() {
        return this.lHm;
    }

    public long dkf() {
        return this.lHn;
    }

    public long dkg() {
        return this.lHo;
    }

    public g dkh() {
        return this.lHp;
    }

    public CacheErrorLogger dki() {
        return this.lHd;
    }

    public CacheEventListener dkj() {
        return this.lHq;
    }

    public com.facebook.common.a.b dkk() {
        return this.lHr;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dkl() {
        return this.lHs;
    }

    public static a gj(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private CacheErrorLogger lHd;
        private String lHk;
        private j<File> lHl;
        private g lHp;
        private CacheEventListener lHq;
        private com.facebook.common.a.b lHr;
        private boolean lHs;
        private long lHt;
        private long lHu;
        private long lHv;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.lHk = "image_cache";
            this.lHt = 41943040L;
            this.lHu = 10485760L;
            this.lHv = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.lHp = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public a ai(File file) {
            this.lHl = k.aU(file);
            return this;
        }

        public b dkm() {
            com.facebook.common.internal.g.d((this.lHl == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.lHl == null && this.mContext != null) {
                this.lHl = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dkn */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
