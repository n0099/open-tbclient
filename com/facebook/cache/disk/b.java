package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import com.facebook.common.internal.k;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b {
    private final String lGD;
    private final j<File> lGE;
    private final long lGF;
    private final long lGG;
    private final long lGH;
    private final g lGI;
    private final CacheEventListener lGJ;
    private final com.facebook.common.a.b lGK;
    private final boolean lGL;
    private final CacheErrorLogger lGw;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.lGD = (String) com.facebook.common.internal.g.checkNotNull(aVar.lGD);
        this.lGE = (j) com.facebook.common.internal.g.checkNotNull(aVar.lGE);
        this.lGF = aVar.lGM;
        this.lGG = aVar.lGN;
        this.lGH = aVar.lGO;
        this.lGI = (g) com.facebook.common.internal.g.checkNotNull(aVar.lGI);
        if (aVar.lGw == null) {
            cacheErrorLogger = com.facebook.cache.common.e.diG();
        } else {
            cacheErrorLogger = aVar.lGw;
        }
        this.lGw = cacheErrorLogger;
        if (aVar.lGJ == null) {
            cacheEventListener = com.facebook.cache.common.f.diH();
        } else {
            cacheEventListener = aVar.lGJ;
        }
        this.lGJ = cacheEventListener;
        if (aVar.lGK == null) {
            bVar = com.facebook.common.a.c.djk();
        } else {
            bVar = aVar.lGK;
        }
        this.lGK = bVar;
        this.mContext = aVar.mContext;
        this.lGL = aVar.lGL;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String diP() {
        return this.lGD;
    }

    public j<File> diQ() {
        return this.lGE;
    }

    public long diR() {
        return this.lGF;
    }

    public long diS() {
        return this.lGG;
    }

    public long diT() {
        return this.lGH;
    }

    public g diU() {
        return this.lGI;
    }

    public CacheErrorLogger diV() {
        return this.lGw;
    }

    public CacheEventListener diW() {
        return this.lGJ;
    }

    public com.facebook.common.a.b diX() {
        return this.lGK;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean diY() {
        return this.lGL;
    }

    public static a gk(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class a {
        private String lGD;
        private j<File> lGE;
        private g lGI;
        private CacheEventListener lGJ;
        private com.facebook.common.a.b lGK;
        private boolean lGL;
        private long lGM;
        private long lGN;
        private long lGO;
        private CacheErrorLogger lGw;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.lGD = "image_cache";
            this.lGM = 41943040L;
            this.lGN = 10485760L;
            this.lGO = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.lGI = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public a ag(File file) {
            this.lGE = k.aS(file);
            return this;
        }

        public b diZ() {
            com.facebook.common.internal.g.d((this.lGE == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.lGE == null && this.mContext != null) {
                this.lGE = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dja */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
