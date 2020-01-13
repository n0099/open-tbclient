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
    private final long lGA;
    private final long lGB;
    private final long lGC;
    private final g lGD;
    private final CacheEventListener lGE;
    private final com.facebook.common.a.b lGF;
    private final boolean lGG;
    private final CacheErrorLogger lGr;
    private final String lGy;
    private final j<File> lGz;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.lGy = (String) com.facebook.common.internal.g.checkNotNull(aVar.lGy);
        this.lGz = (j) com.facebook.common.internal.g.checkNotNull(aVar.lGz);
        this.lGA = aVar.lGH;
        this.lGB = aVar.lGI;
        this.lGC = aVar.lGJ;
        this.lGD = (g) com.facebook.common.internal.g.checkNotNull(aVar.lGD);
        if (aVar.lGr == null) {
            cacheErrorLogger = com.facebook.cache.common.e.diE();
        } else {
            cacheErrorLogger = aVar.lGr;
        }
        this.lGr = cacheErrorLogger;
        if (aVar.lGE == null) {
            cacheEventListener = com.facebook.cache.common.f.diF();
        } else {
            cacheEventListener = aVar.lGE;
        }
        this.lGE = cacheEventListener;
        if (aVar.lGF == null) {
            bVar = com.facebook.common.a.c.dji();
        } else {
            bVar = aVar.lGF;
        }
        this.lGF = bVar;
        this.mContext = aVar.mContext;
        this.lGG = aVar.lGG;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String diN() {
        return this.lGy;
    }

    public j<File> diO() {
        return this.lGz;
    }

    public long diP() {
        return this.lGA;
    }

    public long diQ() {
        return this.lGB;
    }

    public long diR() {
        return this.lGC;
    }

    public g diS() {
        return this.lGD;
    }

    public CacheErrorLogger diT() {
        return this.lGr;
    }

    public CacheEventListener diU() {
        return this.lGE;
    }

    public com.facebook.common.a.b diV() {
        return this.lGF;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean diW() {
        return this.lGG;
    }

    public static a gk(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class a {
        private g lGD;
        private CacheEventListener lGE;
        private com.facebook.common.a.b lGF;
        private boolean lGG;
        private long lGH;
        private long lGI;
        private long lGJ;
        private CacheErrorLogger lGr;
        private String lGy;
        private j<File> lGz;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.lGy = "image_cache";
            this.lGH = 41943040L;
            this.lGI = 10485760L;
            this.lGJ = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.lGD = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public a ag(File file) {
            this.lGz = k.aS(file);
            return this;
        }

        public b diX() {
            com.facebook.common.internal.g.d((this.lGz == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.lGz == null && this.mContext != null) {
                this.lGz = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: diY */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
