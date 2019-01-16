package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger iiV;
    private final String ijf;
    private final com.facebook.common.internal.i<File> ijg;
    private final long ijh;
    private final long iji;
    private final long ijj;
    private final g ijk;
    private final CacheEventListener ijl;
    private final com.facebook.common.a.b ijm;
    private final boolean ijn;
    private final Context mContext;
    private final int vz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vz = aVar.vz;
        this.ijf = (String) com.facebook.common.internal.g.checkNotNull(aVar.ijf);
        this.ijg = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.ijg);
        this.ijh = aVar.ijo;
        this.iji = aVar.ijp;
        this.ijj = aVar.ijq;
        this.ijk = (g) com.facebook.common.internal.g.checkNotNull(aVar.ijk);
        if (aVar.iiV == null) {
            cacheErrorLogger = com.facebook.cache.common.e.bTQ();
        } else {
            cacheErrorLogger = aVar.iiV;
        }
        this.iiV = cacheErrorLogger;
        if (aVar.ijl == null) {
            cacheEventListener = com.facebook.cache.common.f.bTR();
        } else {
            cacheEventListener = aVar.ijl;
        }
        this.ijl = cacheEventListener;
        if (aVar.ijm == null) {
            bVar = com.facebook.common.a.c.bUu();
        } else {
            bVar = aVar.ijm;
        }
        this.ijm = bVar;
        this.mContext = aVar.mContext;
        this.ijn = aVar.ijn;
    }

    public int getVersion() {
        return this.vz;
    }

    public String bTZ() {
        return this.ijf;
    }

    public com.facebook.common.internal.i<File> bUa() {
        return this.ijg;
    }

    public long bUb() {
        return this.ijh;
    }

    public long bUc() {
        return this.iji;
    }

    public long bUd() {
        return this.ijj;
    }

    public g bUe() {
        return this.ijk;
    }

    public CacheErrorLogger bUf() {
        return this.iiV;
    }

    public CacheEventListener bUg() {
        return this.ijl;
    }

    public com.facebook.common.a.b bUh() {
        return this.ijm;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean bUi() {
        return this.ijn;
    }

    public static a dp(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger iiV;
        private String ijf;
        private com.facebook.common.internal.i<File> ijg;
        private g ijk;
        private CacheEventListener ijl;
        private com.facebook.common.a.b ijm;
        private boolean ijn;
        private long ijo;
        private long ijp;
        private long ijq;
        @Nullable
        private final Context mContext;
        private int vz;

        private a(@Nullable Context context) {
            this.vz = 1;
            this.ijf = "image_cache";
            this.ijo = 41943040L;
            this.ijp = 10485760L;
            this.ijq = 2097152L;
            this.ijk = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b bUj() {
            com.facebook.common.internal.g.c((this.ijg == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.ijg == null && this.mContext != null) {
                this.ijg = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: bUk */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
