package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes3.dex */
public class b {
    private final Context mContext;
    private final CacheErrorLogger mPC;
    private final String mPJ;
    private final j<File> mPK;
    private final long mPL;
    private final long mPM;
    private final long mPN;
    private final g mPO;
    private final CacheEventListener mPP;
    private final com.facebook.common.a.b mPQ;
    private final boolean mPR;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.mPJ = (String) com.facebook.common.internal.g.checkNotNull(aVar.mPJ);
        this.mPK = (j) com.facebook.common.internal.g.checkNotNull(aVar.mPK);
        this.mPL = aVar.mPS;
        this.mPM = aVar.mPT;
        this.mPN = aVar.mPU;
        this.mPO = (g) com.facebook.common.internal.g.checkNotNull(aVar.mPO);
        if (aVar.mPC == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dBK();
        } else {
            cacheErrorLogger = aVar.mPC;
        }
        this.mPC = cacheErrorLogger;
        if (aVar.mPP == null) {
            cacheEventListener = com.facebook.cache.common.f.dBL();
        } else {
            cacheEventListener = aVar.mPP;
        }
        this.mPP = cacheEventListener;
        if (aVar.mPQ == null) {
            bVar = com.facebook.common.a.c.dCo();
        } else {
            bVar = aVar.mPQ;
        }
        this.mPQ = bVar;
        this.mContext = aVar.mContext;
        this.mPR = aVar.mPR;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dBT() {
        return this.mPJ;
    }

    public j<File> dBU() {
        return this.mPK;
    }

    public long dBV() {
        return this.mPL;
    }

    public long dBW() {
        return this.mPM;
    }

    public long dBX() {
        return this.mPN;
    }

    public g dBY() {
        return this.mPO;
    }

    public CacheErrorLogger dBZ() {
        return this.mPC;
    }

    public CacheEventListener dCa() {
        return this.mPP;
    }

    public com.facebook.common.a.b dCb() {
        return this.mPQ;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dCc() {
        return this.mPR;
    }

    public static a fW(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes3.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private CacheErrorLogger mPC;
        private String mPJ;
        private j<File> mPK;
        private g mPO;
        private CacheEventListener mPP;
        private com.facebook.common.a.b mPQ;
        private boolean mPR;
        private long mPS;
        private long mPT;
        private long mPU;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.mPJ = "image_cache";
            this.mPS = 41943040L;
            this.mPT = 10485760L;
            this.mPU = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.mPO = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dCd() {
            com.facebook.common.internal.g.d((this.mPK == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.mPK == null && this.mContext != null) {
                this.mPK = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dCe */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
