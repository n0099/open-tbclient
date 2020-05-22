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
    private final Context mContext;
    private final int mVersion;
    private final CacheEventListener mkA;
    private final com.facebook.common.a.b mkB;
    private final boolean mkC;
    private final CacheErrorLogger mkn;
    private final String mku;
    private final j<File> mkv;
    private final long mkw;
    private final long mkx;
    private final long mky;
    private final g mkz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.mku = (String) com.facebook.common.internal.g.checkNotNull(aVar.mku);
        this.mkv = (j) com.facebook.common.internal.g.checkNotNull(aVar.mkv);
        this.mkw = aVar.mkD;
        this.mkx = aVar.mkE;
        this.mky = aVar.mkF;
        this.mkz = (g) com.facebook.common.internal.g.checkNotNull(aVar.mkz);
        if (aVar.mkn == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dtD();
        } else {
            cacheErrorLogger = aVar.mkn;
        }
        this.mkn = cacheErrorLogger;
        if (aVar.mkA == null) {
            cacheEventListener = com.facebook.cache.common.f.dtE();
        } else {
            cacheEventListener = aVar.mkA;
        }
        this.mkA = cacheEventListener;
        if (aVar.mkB == null) {
            bVar = com.facebook.common.a.c.duh();
        } else {
            bVar = aVar.mkB;
        }
        this.mkB = bVar;
        this.mContext = aVar.mContext;
        this.mkC = aVar.mkC;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dtM() {
        return this.mku;
    }

    public j<File> dtN() {
        return this.mkv;
    }

    public long dtO() {
        return this.mkw;
    }

    public long dtP() {
        return this.mkx;
    }

    public long dtQ() {
        return this.mky;
    }

    public g dtR() {
        return this.mkz;
    }

    public CacheErrorLogger dtS() {
        return this.mkn;
    }

    public CacheEventListener dtT() {
        return this.mkA;
    }

    public com.facebook.common.a.b dtU() {
        return this.mkB;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dtV() {
        return this.mkC;
    }

    public static a fS(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheEventListener mkA;
        private com.facebook.common.a.b mkB;
        private boolean mkC;
        private long mkD;
        private long mkE;
        private long mkF;
        private CacheErrorLogger mkn;
        private String mku;
        private j<File> mkv;
        private g mkz;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.mku = "image_cache";
            this.mkD = 41943040L;
            this.mkE = 10485760L;
            this.mkF = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.mkz = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dtW() {
            com.facebook.common.internal.g.d((this.mkv == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.mkv == null && this.mContext != null) {
                this.mkv = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dtX */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
