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
    private final j<File> pnA;
    private final long pnB;
    private final long pnC;
    private final long pnD;
    private final g pnE;
    private final CacheEventListener pnF;
    private final com.facebook.common.a.b pnG;
    private final boolean pnH;
    private final CacheErrorLogger pns;
    private final String pnz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.pnz = (String) com.facebook.common.internal.g.checkNotNull(aVar.pnz);
        this.pnA = (j) com.facebook.common.internal.g.checkNotNull(aVar.pnA);
        this.pnB = aVar.pnI;
        this.pnC = aVar.pnJ;
        this.pnD = aVar.pnK;
        this.pnE = (g) com.facebook.common.internal.g.checkNotNull(aVar.pnE);
        if (aVar.pns == null) {
            cacheErrorLogger = com.facebook.cache.common.e.epu();
        } else {
            cacheErrorLogger = aVar.pns;
        }
        this.pns = cacheErrorLogger;
        if (aVar.pnF == null) {
            cacheEventListener = com.facebook.cache.common.f.epv();
        } else {
            cacheEventListener = aVar.pnF;
        }
        this.pnF = cacheEventListener;
        if (aVar.pnG == null) {
            bVar = com.facebook.common.a.c.epX();
        } else {
            bVar = aVar.pnG;
        }
        this.pnG = bVar;
        this.mContext = aVar.mContext;
        this.pnH = aVar.pnH;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String epD() {
        return this.pnz;
    }

    public j<File> epE() {
        return this.pnA;
    }

    public long epF() {
        return this.pnB;
    }

    public long epG() {
        return this.pnC;
    }

    public long epH() {
        return this.pnD;
    }

    public g epI() {
        return this.pnE;
    }

    public CacheErrorLogger epJ() {
        return this.pns;
    }

    public CacheEventListener epK() {
        return this.pnF;
    }

    public com.facebook.common.a.b epL() {
        return this.pnG;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean epM() {
        return this.pnH;
    }

    public static a ie(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private j<File> pnA;
        private g pnE;
        private CacheEventListener pnF;
        private com.facebook.common.a.b pnG;
        private boolean pnH;
        private long pnI;
        private long pnJ;
        private long pnK;
        private CacheErrorLogger pns;
        private String pnz;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.pnz = "image_cache";
            this.pnI = 41943040L;
            this.pnJ = 10485760L;
            this.pnK = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.pnE = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b epN() {
            com.facebook.common.internal.g.checkState((this.pnA == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.pnA == null && this.mContext != null) {
                this.pnA = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
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
