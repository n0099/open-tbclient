package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b {
    private final Context mContext;
    private final int mVersion;
    private final CacheErrorLogger nJk;
    private final String nJr;
    private final j<File> nJs;
    private final long nJt;
    private final long nJu;
    private final long nJv;
    private final g nJw;
    private final CacheEventListener nJx;
    private final com.facebook.common.a.b nJy;
    private final boolean nJz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.nJr = (String) com.facebook.common.internal.g.checkNotNull(aVar.nJr);
        this.nJs = (j) com.facebook.common.internal.g.checkNotNull(aVar.nJs);
        this.nJt = aVar.nJA;
        this.nJu = aVar.nJB;
        this.nJv = aVar.nJC;
        this.nJw = (g) com.facebook.common.internal.g.checkNotNull(aVar.nJw);
        if (aVar.nJk == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dVD();
        } else {
            cacheErrorLogger = aVar.nJk;
        }
        this.nJk = cacheErrorLogger;
        if (aVar.nJx == null) {
            cacheEventListener = com.facebook.cache.common.f.dVE();
        } else {
            cacheEventListener = aVar.nJx;
        }
        this.nJx = cacheEventListener;
        if (aVar.nJy == null) {
            bVar = com.facebook.common.a.c.dWh();
        } else {
            bVar = aVar.nJy;
        }
        this.nJy = bVar;
        this.mContext = aVar.mContext;
        this.nJz = aVar.nJz;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dVM() {
        return this.nJr;
    }

    public j<File> dVN() {
        return this.nJs;
    }

    public long dVO() {
        return this.nJt;
    }

    public long dVP() {
        return this.nJu;
    }

    public long dVQ() {
        return this.nJv;
    }

    public g dVR() {
        return this.nJw;
    }

    public CacheErrorLogger dVS() {
        return this.nJk;
    }

    public CacheEventListener dVT() {
        return this.nJx;
    }

    public com.facebook.common.a.b dVU() {
        return this.nJy;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dVV() {
        return this.nJz;
    }

    public static a gD(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private long nJA;
        private long nJB;
        private long nJC;
        private CacheErrorLogger nJk;
        private String nJr;
        private j<File> nJs;
        private g nJw;
        private CacheEventListener nJx;
        private com.facebook.common.a.b nJy;
        private boolean nJz;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.nJr = "image_cache";
            this.nJA = 41943040L;
            this.nJB = 10485760L;
            this.nJC = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.nJw = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dVW() {
            com.facebook.common.internal.g.d((this.nJs == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.nJs == null && this.mContext != null) {
                this.nJs = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dVX */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
