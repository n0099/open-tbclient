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
    private final long lQA;
    private final long lQB;
    private final long lQC;
    private final g lQD;
    private final CacheEventListener lQE;
    private final com.facebook.common.a.b lQF;
    private final boolean lQG;
    private final CacheErrorLogger lQr;
    private final String lQy;
    private final j<File> lQz;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.lQy = (String) com.facebook.common.internal.g.checkNotNull(aVar.lQy);
        this.lQz = (j) com.facebook.common.internal.g.checkNotNull(aVar.lQz);
        this.lQA = aVar.lQH;
        this.lQB = aVar.lQI;
        this.lQC = aVar.lQJ;
        this.lQD = (g) com.facebook.common.internal.g.checkNotNull(aVar.lQD);
        if (aVar.lQr == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dmm();
        } else {
            cacheErrorLogger = aVar.lQr;
        }
        this.lQr = cacheErrorLogger;
        if (aVar.lQE == null) {
            cacheEventListener = com.facebook.cache.common.f.dmn();
        } else {
            cacheEventListener = aVar.lQE;
        }
        this.lQE = cacheEventListener;
        if (aVar.lQF == null) {
            bVar = com.facebook.common.a.c.dmQ();
        } else {
            bVar = aVar.lQF;
        }
        this.lQF = bVar;
        this.mContext = aVar.mContext;
        this.lQG = aVar.lQG;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dmv() {
        return this.lQy;
    }

    public j<File> dmw() {
        return this.lQz;
    }

    public long dmx() {
        return this.lQA;
    }

    public long dmy() {
        return this.lQB;
    }

    public long dmz() {
        return this.lQC;
    }

    public g dmA() {
        return this.lQD;
    }

    public CacheErrorLogger dmB() {
        return this.lQr;
    }

    public CacheEventListener dmC() {
        return this.lQE;
    }

    public com.facebook.common.a.b dmD() {
        return this.lQF;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dmE() {
        return this.lQG;
    }

    public static a fM(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private g lQD;
        private CacheEventListener lQE;
        private com.facebook.common.a.b lQF;
        private boolean lQG;
        private long lQH;
        private long lQI;
        private long lQJ;
        private CacheErrorLogger lQr;
        private String lQy;
        private j<File> lQz;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.lQy = "image_cache";
            this.lQH = 41943040L;
            this.lQI = 10485760L;
            this.lQJ = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.lQD = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dmF() {
            com.facebook.common.internal.g.d((this.lQz == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.lQz == null && this.mContext != null) {
                this.lQz = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dmG */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
