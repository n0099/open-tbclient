package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b {
    private final Context mContext;
    private final int mVersion;
    private final CacheErrorLogger oAD;
    private final String oAK;
    private final j<File> oAL;
    private final long oAM;
    private final long oAN;
    private final long oAO;
    private final g oAP;
    private final CacheEventListener oAQ;
    private final com.facebook.common.a.b oAR;
    private final boolean oAS;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.oAK = (String) com.facebook.common.internal.g.checkNotNull(aVar.oAK);
        this.oAL = (j) com.facebook.common.internal.g.checkNotNull(aVar.oAL);
        this.oAM = aVar.oAT;
        this.oAN = aVar.oAU;
        this.oAO = aVar.oAV;
        this.oAP = (g) com.facebook.common.internal.g.checkNotNull(aVar.oAP);
        if (aVar.oAD == null) {
            cacheErrorLogger = com.facebook.cache.common.e.efB();
        } else {
            cacheErrorLogger = aVar.oAD;
        }
        this.oAD = cacheErrorLogger;
        if (aVar.oAQ == null) {
            cacheEventListener = com.facebook.cache.common.f.efC();
        } else {
            cacheEventListener = aVar.oAQ;
        }
        this.oAQ = cacheEventListener;
        if (aVar.oAR == null) {
            bVar = com.facebook.common.a.c.egf();
        } else {
            bVar = aVar.oAR;
        }
        this.oAR = bVar;
        this.mContext = aVar.mContext;
        this.oAS = aVar.oAS;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String efK() {
        return this.oAK;
    }

    public j<File> efL() {
        return this.oAL;
    }

    public long efM() {
        return this.oAM;
    }

    public long efN() {
        return this.oAN;
    }

    public long efO() {
        return this.oAO;
    }

    public g efP() {
        return this.oAP;
    }

    public CacheErrorLogger efQ() {
        return this.oAD;
    }

    public CacheEventListener efR() {
        return this.oAQ;
    }

    public com.facebook.common.a.b efS() {
        return this.oAR;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean efT() {
        return this.oAS;
    }

    public static a gX(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger oAD;
        private String oAK;
        private j<File> oAL;
        private g oAP;
        private CacheEventListener oAQ;
        private com.facebook.common.a.b oAR;
        private boolean oAS;
        private long oAT;
        private long oAU;
        private long oAV;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.oAK = "image_cache";
            this.oAT = 41943040L;
            this.oAU = 10485760L;
            this.oAV = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.oAP = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b efU() {
            com.facebook.common.internal.g.d((this.oAL == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.oAL == null && this.mContext != null) {
                this.oAL = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: efV */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
