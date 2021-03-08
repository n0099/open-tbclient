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
    private final com.facebook.common.a.b pAA;
    private final boolean pAB;
    private final CacheErrorLogger pAm;
    private final String pAt;
    private final j<File> pAu;
    private final long pAv;
    private final long pAw;
    private final long pAx;
    private final g pAy;
    private final CacheEventListener pAz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.pAt = (String) com.facebook.common.internal.g.checkNotNull(aVar.pAt);
        this.pAu = (j) com.facebook.common.internal.g.checkNotNull(aVar.pAu);
        this.pAv = aVar.pAC;
        this.pAw = aVar.pAD;
        this.pAx = aVar.pAE;
        this.pAy = (g) com.facebook.common.internal.g.checkNotNull(aVar.pAy);
        if (aVar.pAm == null) {
            cacheErrorLogger = com.facebook.cache.common.e.ese();
        } else {
            cacheErrorLogger = aVar.pAm;
        }
        this.pAm = cacheErrorLogger;
        if (aVar.pAz == null) {
            cacheEventListener = com.facebook.cache.common.f.esf();
        } else {
            cacheEventListener = aVar.pAz;
        }
        this.pAz = cacheEventListener;
        if (aVar.pAA == null) {
            bVar = com.facebook.common.a.c.esH();
        } else {
            bVar = aVar.pAA;
        }
        this.pAA = bVar;
        this.mContext = aVar.mContext;
        this.pAB = aVar.pAB;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String esn() {
        return this.pAt;
    }

    public j<File> eso() {
        return this.pAu;
    }

    public long esp() {
        return this.pAv;
    }

    public long esq() {
        return this.pAw;
    }

    public long esr() {
        return this.pAx;
    }

    public g ess() {
        return this.pAy;
    }

    public CacheErrorLogger est() {
        return this.pAm;
    }

    public CacheEventListener esu() {
        return this.pAz;
    }

    public com.facebook.common.a.b esv() {
        return this.pAA;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean esw() {
        return this.pAB;
    }

    public static a ig(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private com.facebook.common.a.b pAA;
        private boolean pAB;
        private long pAC;
        private long pAD;
        private long pAE;
        private CacheErrorLogger pAm;
        private String pAt;
        private j<File> pAu;
        private g pAy;
        private CacheEventListener pAz;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.pAt = "image_cache";
            this.pAC = 41943040L;
            this.pAD = 10485760L;
            this.pAE = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.pAy = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b esx() {
            com.facebook.common.internal.g.checkState((this.pAu == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.pAu == null && this.mContext != null) {
                this.pAu = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
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
