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
    private final CacheErrorLogger mPE;
    private final String mPL;
    private final j<File> mPM;
    private final long mPN;
    private final long mPO;
    private final long mPP;
    private final g mPQ;
    private final CacheEventListener mPR;
    private final com.facebook.common.a.b mPS;
    private final boolean mPT;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.mPL = (String) com.facebook.common.internal.g.checkNotNull(aVar.mPL);
        this.mPM = (j) com.facebook.common.internal.g.checkNotNull(aVar.mPM);
        this.mPN = aVar.mPU;
        this.mPO = aVar.mPV;
        this.mPP = aVar.mPW;
        this.mPQ = (g) com.facebook.common.internal.g.checkNotNull(aVar.mPQ);
        if (aVar.mPE == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dBL();
        } else {
            cacheErrorLogger = aVar.mPE;
        }
        this.mPE = cacheErrorLogger;
        if (aVar.mPR == null) {
            cacheEventListener = com.facebook.cache.common.f.dBM();
        } else {
            cacheEventListener = aVar.mPR;
        }
        this.mPR = cacheEventListener;
        if (aVar.mPS == null) {
            bVar = com.facebook.common.a.c.dCp();
        } else {
            bVar = aVar.mPS;
        }
        this.mPS = bVar;
        this.mContext = aVar.mContext;
        this.mPT = aVar.mPT;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dBU() {
        return this.mPL;
    }

    public j<File> dBV() {
        return this.mPM;
    }

    public long dBW() {
        return this.mPN;
    }

    public long dBX() {
        return this.mPO;
    }

    public long dBY() {
        return this.mPP;
    }

    public g dBZ() {
        return this.mPQ;
    }

    public CacheErrorLogger dCa() {
        return this.mPE;
    }

    public CacheEventListener dCb() {
        return this.mPR;
    }

    public com.facebook.common.a.b dCc() {
        return this.mPS;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dCd() {
        return this.mPT;
    }

    public static a fW(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes3.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private CacheErrorLogger mPE;
        private String mPL;
        private j<File> mPM;
        private g mPQ;
        private CacheEventListener mPR;
        private com.facebook.common.a.b mPS;
        private boolean mPT;
        private long mPU;
        private long mPV;
        private long mPW;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.mPL = "image_cache";
            this.mPU = 41943040L;
            this.mPV = 10485760L;
            this.mPW = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.mPQ = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dCe() {
            com.facebook.common.internal.g.d((this.mPM == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.mPM == null && this.mContext != null) {
                this.mPM = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dCf */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
