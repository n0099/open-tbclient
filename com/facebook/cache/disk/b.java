package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final String hXB;
    private final com.facebook.common.internal.i<File> hXC;
    private final long hXD;
    private final long hXE;
    private final long hXF;
    private final g hXG;
    private final CacheEventListener hXH;
    private final com.facebook.common.a.b hXI;
    private final boolean hXJ;
    private final CacheErrorLogger hXr;
    private final Context mContext;
    private final int vz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vz = aVar.vz;
        this.hXB = (String) com.facebook.common.internal.g.checkNotNull(aVar.hXB);
        this.hXC = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.hXC);
        this.hXD = aVar.hXK;
        this.hXE = aVar.hXL;
        this.hXF = aVar.hXM;
        this.hXG = (g) com.facebook.common.internal.g.checkNotNull(aVar.hXG);
        if (aVar.hXr == null) {
            cacheErrorLogger = com.facebook.cache.common.e.bQm();
        } else {
            cacheErrorLogger = aVar.hXr;
        }
        this.hXr = cacheErrorLogger;
        if (aVar.hXH == null) {
            cacheEventListener = com.facebook.cache.common.f.bQn();
        } else {
            cacheEventListener = aVar.hXH;
        }
        this.hXH = cacheEventListener;
        if (aVar.hXI == null) {
            bVar = com.facebook.common.a.c.bQQ();
        } else {
            bVar = aVar.hXI;
        }
        this.hXI = bVar;
        this.mContext = aVar.mContext;
        this.hXJ = aVar.hXJ;
    }

    public int getVersion() {
        return this.vz;
    }

    public String bQv() {
        return this.hXB;
    }

    public com.facebook.common.internal.i<File> bQw() {
        return this.hXC;
    }

    public long bQx() {
        return this.hXD;
    }

    public long bQy() {
        return this.hXE;
    }

    public long bQz() {
        return this.hXF;
    }

    public g bQA() {
        return this.hXG;
    }

    public CacheErrorLogger bQB() {
        return this.hXr;
    }

    public CacheEventListener bQC() {
        return this.hXH;
    }

    public com.facebook.common.a.b bQD() {
        return this.hXI;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean bQE() {
        return this.hXJ;
    }

    public static a dl(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private String hXB;
        private com.facebook.common.internal.i<File> hXC;
        private g hXG;
        private CacheEventListener hXH;
        private com.facebook.common.a.b hXI;
        private boolean hXJ;
        private long hXK;
        private long hXL;
        private long hXM;
        private CacheErrorLogger hXr;
        @Nullable
        private final Context mContext;
        private int vz;

        private a(@Nullable Context context) {
            this.vz = 1;
            this.hXB = "image_cache";
            this.hXK = 41943040L;
            this.hXL = 10485760L;
            this.hXM = 2097152L;
            this.hXG = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b bQF() {
            com.facebook.common.internal.g.c((this.hXC == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.hXC == null && this.mContext != null) {
                this.hXC = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: bQG */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
