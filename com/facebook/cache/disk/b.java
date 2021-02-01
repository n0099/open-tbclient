package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class b {
    private final Context mContext;
    private final int mVersion;
    private final CacheErrorLogger pxH;
    private final String pxO;
    private final j<File> pxP;
    private final long pxQ;
    private final long pxR;
    private final long pxS;
    private final g pxT;
    private final CacheEventListener pxU;
    private final com.facebook.common.a.b pxV;
    private final boolean pxW;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.pxO = (String) com.facebook.common.internal.g.checkNotNull(aVar.pxO);
        this.pxP = (j) com.facebook.common.internal.g.checkNotNull(aVar.pxP);
        this.pxQ = aVar.pxX;
        this.pxR = aVar.pxY;
        this.pxS = aVar.pxZ;
        this.pxT = (g) com.facebook.common.internal.g.checkNotNull(aVar.pxT);
        if (aVar.pxH == null) {
            cacheErrorLogger = com.facebook.cache.common.e.erN();
        } else {
            cacheErrorLogger = aVar.pxH;
        }
        this.pxH = cacheErrorLogger;
        if (aVar.pxU == null) {
            cacheEventListener = com.facebook.cache.common.f.erO();
        } else {
            cacheEventListener = aVar.pxU;
        }
        this.pxU = cacheEventListener;
        if (aVar.pxV == null) {
            bVar = com.facebook.common.a.c.esq();
        } else {
            bVar = aVar.pxV;
        }
        this.pxV = bVar;
        this.mContext = aVar.mContext;
        this.pxW = aVar.pxW;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String erW() {
        return this.pxO;
    }

    public j<File> erX() {
        return this.pxP;
    }

    public long erY() {
        return this.pxQ;
    }

    public long erZ() {
        return this.pxR;
    }

    public long esa() {
        return this.pxS;
    }

    public g esb() {
        return this.pxT;
    }

    public CacheErrorLogger esc() {
        return this.pxH;
    }

    public CacheEventListener esd() {
        return this.pxU;
    }

    public com.facebook.common.a.b ese() {
        return this.pxV;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean esf() {
        return this.pxW;
    }

    public static a ih(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger pxH;
        private String pxO;
        private j<File> pxP;
        private g pxT;
        private CacheEventListener pxU;
        private com.facebook.common.a.b pxV;
        private boolean pxW;
        private long pxX;
        private long pxY;
        private long pxZ;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.pxO = "image_cache";
            this.pxX = 41943040L;
            this.pxY = 10485760L;
            this.pxZ = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.pxT = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b esg() {
            com.facebook.common.internal.g.checkState((this.pxP == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.pxP == null && this.mContext != null) {
                this.pxP = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
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
