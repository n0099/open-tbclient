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
    private final long lHA;
    private final long lHB;
    private final g lHC;
    private final CacheEventListener lHD;
    private final com.facebook.common.a.b lHE;
    private final boolean lHF;
    private final CacheErrorLogger lHq;
    private final String lHx;
    private final j<File> lHy;
    private final long lHz;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.lHx = (String) com.facebook.common.internal.g.checkNotNull(aVar.lHx);
        this.lHy = (j) com.facebook.common.internal.g.checkNotNull(aVar.lHy);
        this.lHz = aVar.lHG;
        this.lHA = aVar.lHH;
        this.lHB = aVar.lHI;
        this.lHC = (g) com.facebook.common.internal.g.checkNotNull(aVar.lHC);
        if (aVar.lHq == null) {
            cacheErrorLogger = com.facebook.cache.common.e.djW();
        } else {
            cacheErrorLogger = aVar.lHq;
        }
        this.lHq = cacheErrorLogger;
        if (aVar.lHD == null) {
            cacheEventListener = com.facebook.cache.common.f.djX();
        } else {
            cacheEventListener = aVar.lHD;
        }
        this.lHD = cacheEventListener;
        if (aVar.lHE == null) {
            bVar = com.facebook.common.a.c.dkA();
        } else {
            bVar = aVar.lHE;
        }
        this.lHE = bVar;
        this.mContext = aVar.mContext;
        this.lHF = aVar.lHF;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dkf() {
        return this.lHx;
    }

    public j<File> dkg() {
        return this.lHy;
    }

    public long dkh() {
        return this.lHz;
    }

    public long dki() {
        return this.lHA;
    }

    public long dkj() {
        return this.lHB;
    }

    public g dkk() {
        return this.lHC;
    }

    public CacheErrorLogger dkl() {
        return this.lHq;
    }

    public CacheEventListener dkm() {
        return this.lHD;
    }

    public com.facebook.common.a.b dkn() {
        return this.lHE;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dko() {
        return this.lHF;
    }

    public static a gj(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private g lHC;
        private CacheEventListener lHD;
        private com.facebook.common.a.b lHE;
        private boolean lHF;
        private long lHG;
        private long lHH;
        private long lHI;
        private CacheErrorLogger lHq;
        private String lHx;
        private j<File> lHy;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.lHx = "image_cache";
            this.lHG = 41943040L;
            this.lHH = 10485760L;
            this.lHI = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.lHC = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public a ai(File file) {
            this.lHy = k.aU(file);
            return this;
        }

        public b dkp() {
            com.facebook.common.internal.g.d((this.lHy == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.lHy == null && this.mContext != null) {
                this.lHy = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dkq */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
