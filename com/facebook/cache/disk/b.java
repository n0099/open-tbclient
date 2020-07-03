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
    private final String mHA;
    private final j<File> mHB;
    private final long mHC;
    private final long mHD;
    private final long mHE;
    private final g mHF;
    private final CacheEventListener mHG;
    private final com.facebook.common.a.b mHH;
    private final boolean mHI;
    private final CacheErrorLogger mHt;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.mHA = (String) com.facebook.common.internal.g.checkNotNull(aVar.mHA);
        this.mHB = (j) com.facebook.common.internal.g.checkNotNull(aVar.mHB);
        this.mHC = aVar.mHJ;
        this.mHD = aVar.mHK;
        this.mHE = aVar.mHL;
        this.mHF = (g) com.facebook.common.internal.g.checkNotNull(aVar.mHF);
        if (aVar.mHt == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dyu();
        } else {
            cacheErrorLogger = aVar.mHt;
        }
        this.mHt = cacheErrorLogger;
        if (aVar.mHG == null) {
            cacheEventListener = com.facebook.cache.common.f.dyv();
        } else {
            cacheEventListener = aVar.mHG;
        }
        this.mHG = cacheEventListener;
        if (aVar.mHH == null) {
            bVar = com.facebook.common.a.c.dyY();
        } else {
            bVar = aVar.mHH;
        }
        this.mHH = bVar;
        this.mContext = aVar.mContext;
        this.mHI = aVar.mHI;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dyD() {
        return this.mHA;
    }

    public j<File> dyE() {
        return this.mHB;
    }

    public long dyF() {
        return this.mHC;
    }

    public long dyG() {
        return this.mHD;
    }

    public long dyH() {
        return this.mHE;
    }

    public g dyI() {
        return this.mHF;
    }

    public CacheErrorLogger dyJ() {
        return this.mHt;
    }

    public CacheEventListener dyK() {
        return this.mHG;
    }

    public com.facebook.common.a.b dyL() {
        return this.mHH;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dyM() {
        return this.mHI;
    }

    public static a fT(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private String mHA;
        private j<File> mHB;
        private g mHF;
        private CacheEventListener mHG;
        private com.facebook.common.a.b mHH;
        private boolean mHI;
        private long mHJ;
        private long mHK;
        private long mHL;
        private CacheErrorLogger mHt;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.mHA = "image_cache";
            this.mHJ = 41943040L;
            this.mHK = 10485760L;
            this.mHL = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.mHF = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dyN() {
            com.facebook.common.internal.g.d((this.mHB == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.mHB == null && this.mContext != null) {
                this.mHB = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dyO */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
