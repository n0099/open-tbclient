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
    private final String mlE;
    private final j<File> mlF;
    private final long mlG;
    private final long mlH;
    private final long mlI;
    private final g mlJ;
    private final CacheEventListener mlK;
    private final com.facebook.common.a.b mlL;
    private final boolean mlM;
    private final CacheErrorLogger mlx;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.mlE = (String) com.facebook.common.internal.g.checkNotNull(aVar.mlE);
        this.mlF = (j) com.facebook.common.internal.g.checkNotNull(aVar.mlF);
        this.mlG = aVar.mlN;
        this.mlH = aVar.mlO;
        this.mlI = aVar.mlP;
        this.mlJ = (g) com.facebook.common.internal.g.checkNotNull(aVar.mlJ);
        if (aVar.mlx == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dtR();
        } else {
            cacheErrorLogger = aVar.mlx;
        }
        this.mlx = cacheErrorLogger;
        if (aVar.mlK == null) {
            cacheEventListener = com.facebook.cache.common.f.dtS();
        } else {
            cacheEventListener = aVar.mlK;
        }
        this.mlK = cacheEventListener;
        if (aVar.mlL == null) {
            bVar = com.facebook.common.a.c.duv();
        } else {
            bVar = aVar.mlL;
        }
        this.mlL = bVar;
        this.mContext = aVar.mContext;
        this.mlM = aVar.mlM;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dua() {
        return this.mlE;
    }

    public j<File> dub() {
        return this.mlF;
    }

    public long duc() {
        return this.mlG;
    }

    public long dud() {
        return this.mlH;
    }

    public long due() {
        return this.mlI;
    }

    public g duf() {
        return this.mlJ;
    }

    public CacheErrorLogger dug() {
        return this.mlx;
    }

    public CacheEventListener duh() {
        return this.mlK;
    }

    public com.facebook.common.a.b dui() {
        return this.mlL;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean duj() {
        return this.mlM;
    }

    public static a fS(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private String mlE;
        private j<File> mlF;
        private g mlJ;
        private CacheEventListener mlK;
        private com.facebook.common.a.b mlL;
        private boolean mlM;
        private long mlN;
        private long mlO;
        private long mlP;
        private CacheErrorLogger mlx;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.mlE = "image_cache";
            this.mlN = 41943040L;
            this.mlO = 10485760L;
            this.mlP = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.mlJ = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b duk() {
            com.facebook.common.internal.g.d((this.mlF == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.mlF == null && this.mContext != null) {
                this.mlF = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dul */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
