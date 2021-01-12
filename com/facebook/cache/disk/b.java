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
    private final long pnA;
    private final long pnB;
    private final long pnC;
    private final g pnD;
    private final CacheEventListener pnE;
    private final com.facebook.common.a.b pnF;
    private final boolean pnG;
    private final CacheErrorLogger pnr;
    private final String pny;
    private final j<File> pnz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.pny = (String) com.facebook.common.internal.g.checkNotNull(aVar.pny);
        this.pnz = (j) com.facebook.common.internal.g.checkNotNull(aVar.pnz);
        this.pnA = aVar.pnH;
        this.pnB = aVar.pnI;
        this.pnC = aVar.pnJ;
        this.pnD = (g) com.facebook.common.internal.g.checkNotNull(aVar.pnD);
        if (aVar.pnr == null) {
            cacheErrorLogger = com.facebook.cache.common.e.epu();
        } else {
            cacheErrorLogger = aVar.pnr;
        }
        this.pnr = cacheErrorLogger;
        if (aVar.pnE == null) {
            cacheEventListener = com.facebook.cache.common.f.epv();
        } else {
            cacheEventListener = aVar.pnE;
        }
        this.pnE = cacheEventListener;
        if (aVar.pnF == null) {
            bVar = com.facebook.common.a.c.epX();
        } else {
            bVar = aVar.pnF;
        }
        this.pnF = bVar;
        this.mContext = aVar.mContext;
        this.pnG = aVar.pnG;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String epD() {
        return this.pny;
    }

    public j<File> epE() {
        return this.pnz;
    }

    public long epF() {
        return this.pnA;
    }

    public long epG() {
        return this.pnB;
    }

    public long epH() {
        return this.pnC;
    }

    public g epI() {
        return this.pnD;
    }

    public CacheErrorLogger epJ() {
        return this.pnr;
    }

    public CacheEventListener epK() {
        return this.pnE;
    }

    public com.facebook.common.a.b epL() {
        return this.pnF;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean epM() {
        return this.pnG;
    }

    public static a ie(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private g pnD;
        private CacheEventListener pnE;
        private com.facebook.common.a.b pnF;
        private boolean pnG;
        private long pnH;
        private long pnI;
        private long pnJ;
        private CacheErrorLogger pnr;
        private String pny;
        private j<File> pnz;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.pny = "image_cache";
            this.pnH = 41943040L;
            this.pnI = 10485760L;
            this.pnJ = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.pnD = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b epN() {
            com.facebook.common.internal.g.checkState((this.pnz == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.pnz == null && this.mContext != null) {
                this.pnz = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
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
