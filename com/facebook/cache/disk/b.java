package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger iiW;
    private final String ijg;
    private final com.facebook.common.internal.i<File> ijh;
    private final long iji;
    private final long ijj;
    private final long ijk;
    private final g ijl;
    private final CacheEventListener ijm;
    private final com.facebook.common.a.b ijn;
    private final boolean ijo;
    private final Context mContext;
    private final int vz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vz = aVar.vz;
        this.ijg = (String) com.facebook.common.internal.g.checkNotNull(aVar.ijg);
        this.ijh = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.ijh);
        this.iji = aVar.ijp;
        this.ijj = aVar.ijq;
        this.ijk = aVar.ijr;
        this.ijl = (g) com.facebook.common.internal.g.checkNotNull(aVar.ijl);
        if (aVar.iiW == null) {
            cacheErrorLogger = com.facebook.cache.common.e.bTQ();
        } else {
            cacheErrorLogger = aVar.iiW;
        }
        this.iiW = cacheErrorLogger;
        if (aVar.ijm == null) {
            cacheEventListener = com.facebook.cache.common.f.bTR();
        } else {
            cacheEventListener = aVar.ijm;
        }
        this.ijm = cacheEventListener;
        if (aVar.ijn == null) {
            bVar = com.facebook.common.a.c.bUu();
        } else {
            bVar = aVar.ijn;
        }
        this.ijn = bVar;
        this.mContext = aVar.mContext;
        this.ijo = aVar.ijo;
    }

    public int getVersion() {
        return this.vz;
    }

    public String bTZ() {
        return this.ijg;
    }

    public com.facebook.common.internal.i<File> bUa() {
        return this.ijh;
    }

    public long bUb() {
        return this.iji;
    }

    public long bUc() {
        return this.ijj;
    }

    public long bUd() {
        return this.ijk;
    }

    public g bUe() {
        return this.ijl;
    }

    public CacheErrorLogger bUf() {
        return this.iiW;
    }

    public CacheEventListener bUg() {
        return this.ijm;
    }

    public com.facebook.common.a.b bUh() {
        return this.ijn;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean bUi() {
        return this.ijo;
    }

    public static a dp(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger iiW;
        private String ijg;
        private com.facebook.common.internal.i<File> ijh;
        private g ijl;
        private CacheEventListener ijm;
        private com.facebook.common.a.b ijn;
        private boolean ijo;
        private long ijp;
        private long ijq;
        private long ijr;
        @Nullable
        private final Context mContext;
        private int vz;

        private a(@Nullable Context context) {
            this.vz = 1;
            this.ijg = "image_cache";
            this.ijp = 41943040L;
            this.ijq = 10485760L;
            this.ijr = 2097152L;
            this.ijl = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b bUj() {
            com.facebook.common.internal.g.c((this.ijh == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.ijh == null && this.mContext != null) {
                this.ijh = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
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
