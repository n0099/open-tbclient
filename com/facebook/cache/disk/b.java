package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger hVG;
    private final String hVQ;
    private final com.facebook.common.internal.i<File> hVR;
    private final long hVS;
    private final long hVT;
    private final long hVU;
    private final g hVV;
    private final CacheEventListener hVW;
    private final com.facebook.common.a.b hVX;
    private final boolean hVY;
    private final Context mContext;
    private final int vx;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vx = aVar.vx;
        this.hVQ = (String) com.facebook.common.internal.g.checkNotNull(aVar.hVQ);
        this.hVR = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.hVR);
        this.hVS = aVar.hVZ;
        this.hVT = aVar.hWa;
        this.hVU = aVar.hWb;
        this.hVV = (g) com.facebook.common.internal.g.checkNotNull(aVar.hVV);
        if (aVar.hVG == null) {
            cacheErrorLogger = com.facebook.cache.common.e.bQR();
        } else {
            cacheErrorLogger = aVar.hVG;
        }
        this.hVG = cacheErrorLogger;
        if (aVar.hVW == null) {
            cacheEventListener = com.facebook.cache.common.f.bQS();
        } else {
            cacheEventListener = aVar.hVW;
        }
        this.hVW = cacheEventListener;
        if (aVar.hVX == null) {
            bVar = com.facebook.common.a.c.bRv();
        } else {
            bVar = aVar.hVX;
        }
        this.hVX = bVar;
        this.mContext = aVar.mContext;
        this.hVY = aVar.hVY;
    }

    public int getVersion() {
        return this.vx;
    }

    public String bRa() {
        return this.hVQ;
    }

    public com.facebook.common.internal.i<File> bRb() {
        return this.hVR;
    }

    public long bRc() {
        return this.hVS;
    }

    public long bRd() {
        return this.hVT;
    }

    public long bRe() {
        return this.hVU;
    }

    public g bRf() {
        return this.hVV;
    }

    public CacheErrorLogger bRg() {
        return this.hVG;
    }

    public CacheEventListener bRh() {
        return this.hVW;
    }

    public com.facebook.common.a.b bRi() {
        return this.hVX;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean bRj() {
        return this.hVY;
    }

    public static a dq(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger hVG;
        private String hVQ;
        private com.facebook.common.internal.i<File> hVR;
        private g hVV;
        private CacheEventListener hVW;
        private com.facebook.common.a.b hVX;
        private boolean hVY;
        private long hVZ;
        private long hWa;
        private long hWb;
        @Nullable
        private final Context mContext;
        private int vx;

        private a(@Nullable Context context) {
            this.vx = 1;
            this.hVQ = "image_cache";
            this.hVZ = 41943040L;
            this.hWa = 10485760L;
            this.hWb = 2097152L;
            this.hVV = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b bRk() {
            com.facebook.common.internal.g.c((this.hVR == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.hVR == null && this.mContext != null) {
                this.hVR = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: bRl */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
