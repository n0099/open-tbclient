package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b {
    private final Context mContext;
    private final String mHD;
    private final j<File> mHE;
    private final long mHF;
    private final long mHG;
    private final long mHH;
    private final g mHI;
    private final CacheEventListener mHJ;
    private final com.facebook.common.a.b mHK;
    private final boolean mHL;
    private final CacheErrorLogger mHw;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.mHD = (String) com.facebook.common.internal.g.checkNotNull(aVar.mHD);
        this.mHE = (j) com.facebook.common.internal.g.checkNotNull(aVar.mHE);
        this.mHF = aVar.mHM;
        this.mHG = aVar.mHN;
        this.mHH = aVar.mHO;
        this.mHI = (g) com.facebook.common.internal.g.checkNotNull(aVar.mHI);
        if (aVar.mHw == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dyy();
        } else {
            cacheErrorLogger = aVar.mHw;
        }
        this.mHw = cacheErrorLogger;
        if (aVar.mHJ == null) {
            cacheEventListener = com.facebook.cache.common.f.dyz();
        } else {
            cacheEventListener = aVar.mHJ;
        }
        this.mHJ = cacheEventListener;
        if (aVar.mHK == null) {
            bVar = com.facebook.common.a.c.dzc();
        } else {
            bVar = aVar.mHK;
        }
        this.mHK = bVar;
        this.mContext = aVar.mContext;
        this.mHL = aVar.mHL;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dyH() {
        return this.mHD;
    }

    public j<File> dyI() {
        return this.mHE;
    }

    public long dyJ() {
        return this.mHF;
    }

    public long dyK() {
        return this.mHG;
    }

    public long dyL() {
        return this.mHH;
    }

    public g dyM() {
        return this.mHI;
    }

    public CacheErrorLogger dyN() {
        return this.mHw;
    }

    public CacheEventListener dyO() {
        return this.mHJ;
    }

    public com.facebook.common.a.b dyP() {
        return this.mHK;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dyQ() {
        return this.mHL;
    }

    public static a fT(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private String mHD;
        private j<File> mHE;
        private g mHI;
        private CacheEventListener mHJ;
        private com.facebook.common.a.b mHK;
        private boolean mHL;
        private long mHM;
        private long mHN;
        private long mHO;
        private CacheErrorLogger mHw;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.mHD = "image_cache";
            this.mHM = 41943040L;
            this.mHN = 10485760L;
            this.mHO = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.mHI = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dyR() {
            com.facebook.common.internal.g.d((this.mHE == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.mHE == null && this.mContext != null) {
                this.mHE = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dyS */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
