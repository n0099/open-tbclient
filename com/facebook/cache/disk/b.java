package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes8.dex */
public class b {
    private final Context mContext;
    private final int mVersion;
    private final String njG;
    private final j<File> njH;
    private final long njI;
    private final long njJ;
    private final long njK;
    private final g njL;
    private final CacheEventListener njM;
    private final com.facebook.common.a.b njN;
    private final boolean njO;
    private final CacheErrorLogger njz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.njG = (String) com.facebook.common.internal.g.checkNotNull(aVar.njG);
        this.njH = (j) com.facebook.common.internal.g.checkNotNull(aVar.njH);
        this.njI = aVar.njP;
        this.njJ = aVar.njQ;
        this.njK = aVar.njR;
        this.njL = (g) com.facebook.common.internal.g.checkNotNull(aVar.njL);
        if (aVar.njz == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dNL();
        } else {
            cacheErrorLogger = aVar.njz;
        }
        this.njz = cacheErrorLogger;
        if (aVar.njM == null) {
            cacheEventListener = com.facebook.cache.common.f.dNM();
        } else {
            cacheEventListener = aVar.njM;
        }
        this.njM = cacheEventListener;
        if (aVar.njN == null) {
            bVar = com.facebook.common.a.c.dOp();
        } else {
            bVar = aVar.njN;
        }
        this.njN = bVar;
        this.mContext = aVar.mContext;
        this.njO = aVar.njO;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dNU() {
        return this.njG;
    }

    public j<File> dNV() {
        return this.njH;
    }

    public long dNW() {
        return this.njI;
    }

    public long dNX() {
        return this.njJ;
    }

    public long dNY() {
        return this.njK;
    }

    public g dNZ() {
        return this.njL;
    }

    public CacheErrorLogger dOa() {
        return this.njz;
    }

    public CacheEventListener dOb() {
        return this.njM;
    }

    public com.facebook.common.a.b dOc() {
        return this.njN;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dOd() {
        return this.njO;
    }

    public static a gp(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes8.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private String njG;
        private j<File> njH;
        private g njL;
        private CacheEventListener njM;
        private com.facebook.common.a.b njN;
        private boolean njO;
        private long njP;
        private long njQ;
        private long njR;
        private CacheErrorLogger njz;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.njG = "image_cache";
            this.njP = 41943040L;
            this.njQ = 10485760L;
            this.njR = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.njL = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dOe() {
            com.facebook.common.internal.g.d((this.njH == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.njH == null && this.mContext != null) {
                this.njH = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dOf */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
