package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import com.facebook.common.internal.k;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes11.dex */
public class b {
    private final CacheErrorLogger lCT;
    private final String lDa;
    private final j<File> lDb;
    private final long lDc;
    private final long lDd;
    private final long lDe;
    private final g lDf;
    private final CacheEventListener lDg;
    private final com.facebook.common.a.b lDh;
    private final boolean lDi;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.lDa = (String) com.facebook.common.internal.g.checkNotNull(aVar.lDa);
        this.lDb = (j) com.facebook.common.internal.g.checkNotNull(aVar.lDb);
        this.lDc = aVar.lDj;
        this.lDd = aVar.lDk;
        this.lDe = aVar.lDl;
        this.lDf = (g) com.facebook.common.internal.g.checkNotNull(aVar.lDf);
        if (aVar.lCT == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dhD();
        } else {
            cacheErrorLogger = aVar.lCT;
        }
        this.lCT = cacheErrorLogger;
        if (aVar.lDg == null) {
            cacheEventListener = com.facebook.cache.common.f.dhE();
        } else {
            cacheEventListener = aVar.lDg;
        }
        this.lDg = cacheEventListener;
        if (aVar.lDh == null) {
            bVar = com.facebook.common.a.c.dih();
        } else {
            bVar = aVar.lDh;
        }
        this.lDh = bVar;
        this.mContext = aVar.mContext;
        this.lDi = aVar.lDi;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dhM() {
        return this.lDa;
    }

    public j<File> dhN() {
        return this.lDb;
    }

    public long dhO() {
        return this.lDc;
    }

    public long dhP() {
        return this.lDd;
    }

    public long dhQ() {
        return this.lDe;
    }

    public g dhR() {
        return this.lDf;
    }

    public CacheErrorLogger dhS() {
        return this.lCT;
    }

    public CacheEventListener dhT() {
        return this.lDg;
    }

    public com.facebook.common.a.b dhU() {
        return this.lDh;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dhV() {
        return this.lDi;
    }

    public static a gj(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes11.dex */
    public static class a {
        private CacheErrorLogger lCT;
        private String lDa;
        private j<File> lDb;
        private g lDf;
        private CacheEventListener lDg;
        private com.facebook.common.a.b lDh;
        private boolean lDi;
        private long lDj;
        private long lDk;
        private long lDl;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.lDa = "image_cache";
            this.lDj = 41943040L;
            this.lDk = 10485760L;
            this.lDl = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.lDf = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public a ag(File file) {
            this.lDb = k.aS(file);
            return this;
        }

        public b dhW() {
            com.facebook.common.internal.g.d((this.lDb == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.lDb == null && this.mContext != null) {
                this.lDb = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dhX */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
