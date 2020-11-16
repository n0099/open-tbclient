package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes17.dex */
public class b {
    private final Context mContext;
    private final int mVersion;
    private final CacheErrorLogger oLA;
    private final String oLH;
    private final j<File> oLI;
    private final long oLJ;
    private final long oLK;
    private final long oLL;
    private final g oLM;
    private final CacheEventListener oLN;
    private final com.facebook.common.a.b oLO;
    private final boolean oLP;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.oLH = (String) com.facebook.common.internal.g.checkNotNull(aVar.oLH);
        this.oLI = (j) com.facebook.common.internal.g.checkNotNull(aVar.oLI);
        this.oLJ = aVar.oLQ;
        this.oLK = aVar.oLR;
        this.oLL = aVar.oLS;
        this.oLM = (g) com.facebook.common.internal.g.checkNotNull(aVar.oLM);
        if (aVar.oLA == null) {
            cacheErrorLogger = com.facebook.cache.common.e.ejo();
        } else {
            cacheErrorLogger = aVar.oLA;
        }
        this.oLA = cacheErrorLogger;
        if (aVar.oLN == null) {
            cacheEventListener = com.facebook.cache.common.f.ejp();
        } else {
            cacheEventListener = aVar.oLN;
        }
        this.oLN = cacheEventListener;
        if (aVar.oLO == null) {
            bVar = com.facebook.common.a.c.ejS();
        } else {
            bVar = aVar.oLO;
        }
        this.oLO = bVar;
        this.mContext = aVar.mContext;
        this.oLP = aVar.oLP;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String ejx() {
        return this.oLH;
    }

    public j<File> ejy() {
        return this.oLI;
    }

    public long ejz() {
        return this.oLJ;
    }

    public long ejA() {
        return this.oLK;
    }

    public long ejB() {
        return this.oLL;
    }

    public g ejC() {
        return this.oLM;
    }

    public CacheErrorLogger ejD() {
        return this.oLA;
    }

    public CacheEventListener ejE() {
        return this.oLN;
    }

    public com.facebook.common.a.b ejF() {
        return this.oLO;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean ejG() {
        return this.oLP;
    }

    public static a gV(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes17.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger oLA;
        private String oLH;
        private j<File> oLI;
        private g oLM;
        private CacheEventListener oLN;
        private com.facebook.common.a.b oLO;
        private boolean oLP;
        private long oLQ;
        private long oLR;
        private long oLS;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.oLH = "image_cache";
            this.oLQ = 41943040L;
            this.oLR = 10485760L;
            this.oLS = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.oLM = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b ejH() {
            com.facebook.common.internal.g.d((this.oLI == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.oLI == null && this.mContext != null) {
                this.oLI = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: ejI */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
