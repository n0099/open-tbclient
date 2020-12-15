package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes7.dex */
public class b {
    private final Context mContext;
    private final int mVersion;
    private final CacheErrorLogger paK;
    private final String paR;
    private final j<File> paS;
    private final long paT;
    private final long paU;
    private final long paV;
    private final g paW;
    private final CacheEventListener paX;
    private final com.facebook.common.a.b paY;
    private final boolean paZ;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.paR = (String) com.facebook.common.internal.g.checkNotNull(aVar.paR);
        this.paS = (j) com.facebook.common.internal.g.checkNotNull(aVar.paS);
        this.paT = aVar.pba;
        this.paU = aVar.pbb;
        this.paV = aVar.pbc;
        this.paW = (g) com.facebook.common.internal.g.checkNotNull(aVar.paW);
        if (aVar.paK == null) {
            cacheErrorLogger = com.facebook.cache.common.e.epf();
        } else {
            cacheErrorLogger = aVar.paK;
        }
        this.paK = cacheErrorLogger;
        if (aVar.paX == null) {
            cacheEventListener = com.facebook.cache.common.f.epg();
        } else {
            cacheEventListener = aVar.paX;
        }
        this.paX = cacheEventListener;
        if (aVar.paY == null) {
            bVar = com.facebook.common.a.c.epI();
        } else {
            bVar = aVar.paY;
        }
        this.paY = bVar;
        this.mContext = aVar.mContext;
        this.paZ = aVar.paZ;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String epo() {
        return this.paR;
    }

    public j<File> epp() {
        return this.paS;
    }

    public long epq() {
        return this.paT;
    }

    public long epr() {
        return this.paU;
    }

    public long eps() {
        return this.paV;
    }

    public g ept() {
        return this.paW;
    }

    public CacheErrorLogger epu() {
        return this.paK;
    }

    public CacheEventListener epv() {
        return this.paX;
    }

    public com.facebook.common.a.b epw() {
        return this.paY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean epx() {
        return this.paZ;
    }

    public static a hE(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes7.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger paK;
        private String paR;
        private j<File> paS;
        private g paW;
        private CacheEventListener paX;
        private com.facebook.common.a.b paY;
        private boolean paZ;
        private long pba;
        private long pbb;
        private long pbc;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.paR = "image_cache";
            this.pba = 41943040L;
            this.pbb = 10485760L;
            this.pbc = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.paW = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b epy() {
            com.facebook.common.internal.g.d((this.paS == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.paS == null && this.mContext != null) {
                this.paS = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.facebook.common.internal.j
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
