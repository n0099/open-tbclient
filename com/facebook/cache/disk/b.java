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
    private final CacheErrorLogger paI;
    private final String paP;
    private final j<File> paQ;
    private final long paR;
    private final long paS;
    private final long paT;
    private final g paU;
    private final CacheEventListener paV;
    private final com.facebook.common.a.b paW;
    private final boolean paX;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.paP = (String) com.facebook.common.internal.g.checkNotNull(aVar.paP);
        this.paQ = (j) com.facebook.common.internal.g.checkNotNull(aVar.paQ);
        this.paR = aVar.paY;
        this.paS = aVar.paZ;
        this.paT = aVar.pba;
        this.paU = (g) com.facebook.common.internal.g.checkNotNull(aVar.paU);
        if (aVar.paI == null) {
            cacheErrorLogger = com.facebook.cache.common.e.epe();
        } else {
            cacheErrorLogger = aVar.paI;
        }
        this.paI = cacheErrorLogger;
        if (aVar.paV == null) {
            cacheEventListener = com.facebook.cache.common.f.epf();
        } else {
            cacheEventListener = aVar.paV;
        }
        this.paV = cacheEventListener;
        if (aVar.paW == null) {
            bVar = com.facebook.common.a.c.epH();
        } else {
            bVar = aVar.paW;
        }
        this.paW = bVar;
        this.mContext = aVar.mContext;
        this.paX = aVar.paX;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String epn() {
        return this.paP;
    }

    public j<File> epo() {
        return this.paQ;
    }

    public long epp() {
        return this.paR;
    }

    public long epq() {
        return this.paS;
    }

    public long epr() {
        return this.paT;
    }

    public g eps() {
        return this.paU;
    }

    public CacheErrorLogger ept() {
        return this.paI;
    }

    public CacheEventListener epu() {
        return this.paV;
    }

    public com.facebook.common.a.b epv() {
        return this.paW;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean epw() {
        return this.paX;
    }

    public static a hE(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes7.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger paI;
        private String paP;
        private j<File> paQ;
        private g paU;
        private CacheEventListener paV;
        private com.facebook.common.a.b paW;
        private boolean paX;
        private long paY;
        private long paZ;
        private long pba;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.paP = "image_cache";
            this.paY = 41943040L;
            this.paZ = 10485760L;
            this.pba = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.paU = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b epx() {
            com.facebook.common.internal.g.d((this.paQ == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.paQ == null && this.mContext != null) {
                this.paQ = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
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
