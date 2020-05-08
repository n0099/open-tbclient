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
    private final String lQC;
    private final j<File> lQD;
    private final long lQE;
    private final long lQF;
    private final long lQG;
    private final g lQH;
    private final CacheEventListener lQI;
    private final com.facebook.common.a.b lQJ;
    private final boolean lQK;
    private final CacheErrorLogger lQv;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.lQC = (String) com.facebook.common.internal.g.checkNotNull(aVar.lQC);
        this.lQD = (j) com.facebook.common.internal.g.checkNotNull(aVar.lQD);
        this.lQE = aVar.lQL;
        this.lQF = aVar.lQM;
        this.lQG = aVar.lQN;
        this.lQH = (g) com.facebook.common.internal.g.checkNotNull(aVar.lQH);
        if (aVar.lQv == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dmj();
        } else {
            cacheErrorLogger = aVar.lQv;
        }
        this.lQv = cacheErrorLogger;
        if (aVar.lQI == null) {
            cacheEventListener = com.facebook.cache.common.f.dmk();
        } else {
            cacheEventListener = aVar.lQI;
        }
        this.lQI = cacheEventListener;
        if (aVar.lQJ == null) {
            bVar = com.facebook.common.a.c.dmN();
        } else {
            bVar = aVar.lQJ;
        }
        this.lQJ = bVar;
        this.mContext = aVar.mContext;
        this.lQK = aVar.lQK;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dms() {
        return this.lQC;
    }

    public j<File> dmt() {
        return this.lQD;
    }

    public long dmu() {
        return this.lQE;
    }

    public long dmv() {
        return this.lQF;
    }

    public long dmw() {
        return this.lQG;
    }

    public g dmx() {
        return this.lQH;
    }

    public CacheErrorLogger dmy() {
        return this.lQv;
    }

    public CacheEventListener dmz() {
        return this.lQI;
    }

    public com.facebook.common.a.b dmA() {
        return this.lQJ;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dmB() {
        return this.lQK;
    }

    public static a fA(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private String lQC;
        private j<File> lQD;
        private g lQH;
        private CacheEventListener lQI;
        private com.facebook.common.a.b lQJ;
        private boolean lQK;
        private long lQL;
        private long lQM;
        private long lQN;
        private CacheErrorLogger lQv;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.lQC = "image_cache";
            this.lQL = 41943040L;
            this.lQM = 10485760L;
            this.lQN = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.lQH = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dmC() {
            com.facebook.common.internal.g.d((this.lQD == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.lQD == null && this.mContext != null) {
                this.lQD = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dmD */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
