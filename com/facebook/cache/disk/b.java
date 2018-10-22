package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger hVH;
    private final String hVR;
    private final com.facebook.common.internal.i<File> hVS;
    private final long hVT;
    private final long hVU;
    private final long hVV;
    private final g hVW;
    private final CacheEventListener hVX;
    private final com.facebook.common.a.b hVY;
    private final boolean hVZ;
    private final Context mContext;
    private final int vx;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vx = aVar.vx;
        this.hVR = (String) com.facebook.common.internal.g.checkNotNull(aVar.hVR);
        this.hVS = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.hVS);
        this.hVT = aVar.hWa;
        this.hVU = aVar.hWb;
        this.hVV = aVar.hWc;
        this.hVW = (g) com.facebook.common.internal.g.checkNotNull(aVar.hVW);
        if (aVar.hVH == null) {
            cacheErrorLogger = com.facebook.cache.common.e.bQR();
        } else {
            cacheErrorLogger = aVar.hVH;
        }
        this.hVH = cacheErrorLogger;
        if (aVar.hVX == null) {
            cacheEventListener = com.facebook.cache.common.f.bQS();
        } else {
            cacheEventListener = aVar.hVX;
        }
        this.hVX = cacheEventListener;
        if (aVar.hVY == null) {
            bVar = com.facebook.common.a.c.bRv();
        } else {
            bVar = aVar.hVY;
        }
        this.hVY = bVar;
        this.mContext = aVar.mContext;
        this.hVZ = aVar.hVZ;
    }

    public int getVersion() {
        return this.vx;
    }

    public String bRa() {
        return this.hVR;
    }

    public com.facebook.common.internal.i<File> bRb() {
        return this.hVS;
    }

    public long bRc() {
        return this.hVT;
    }

    public long bRd() {
        return this.hVU;
    }

    public long bRe() {
        return this.hVV;
    }

    public g bRf() {
        return this.hVW;
    }

    public CacheErrorLogger bRg() {
        return this.hVH;
    }

    public CacheEventListener bRh() {
        return this.hVX;
    }

    public com.facebook.common.a.b bRi() {
        return this.hVY;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean bRj() {
        return this.hVZ;
    }

    public static a dq(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger hVH;
        private String hVR;
        private com.facebook.common.internal.i<File> hVS;
        private g hVW;
        private CacheEventListener hVX;
        private com.facebook.common.a.b hVY;
        private boolean hVZ;
        private long hWa;
        private long hWb;
        private long hWc;
        @Nullable
        private final Context mContext;
        private int vx;

        private a(@Nullable Context context) {
            this.vx = 1;
            this.hVR = "image_cache";
            this.hWa = 41943040L;
            this.hWb = 10485760L;
            this.hWc = 2097152L;
            this.hVW = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b bRk() {
            com.facebook.common.internal.g.c((this.hVS == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.hVS == null && this.mContext != null) {
                this.hVS = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
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
