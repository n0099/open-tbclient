package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger ieE;
    private final String ieO;
    private final com.facebook.common.internal.i<File> ieP;
    private final long ieQ;
    private final long ieR;
    private final long ieS;
    private final g ieT;
    private final CacheEventListener ieU;
    private final com.facebook.common.a.b ieV;
    private final boolean ieW;
    private final Context mContext;
    private final int vz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vz = aVar.vz;
        this.ieO = (String) com.facebook.common.internal.g.checkNotNull(aVar.ieO);
        this.ieP = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.ieP);
        this.ieQ = aVar.ieX;
        this.ieR = aVar.ieY;
        this.ieS = aVar.ieZ;
        this.ieT = (g) com.facebook.common.internal.g.checkNotNull(aVar.ieT);
        if (aVar.ieE == null) {
            cacheErrorLogger = com.facebook.cache.common.e.bSs();
        } else {
            cacheErrorLogger = aVar.ieE;
        }
        this.ieE = cacheErrorLogger;
        if (aVar.ieU == null) {
            cacheEventListener = com.facebook.cache.common.f.bSt();
        } else {
            cacheEventListener = aVar.ieU;
        }
        this.ieU = cacheEventListener;
        if (aVar.ieV == null) {
            bVar = com.facebook.common.a.c.bSW();
        } else {
            bVar = aVar.ieV;
        }
        this.ieV = bVar;
        this.mContext = aVar.mContext;
        this.ieW = aVar.ieW;
    }

    public int getVersion() {
        return this.vz;
    }

    public String bSB() {
        return this.ieO;
    }

    public com.facebook.common.internal.i<File> bSC() {
        return this.ieP;
    }

    public long bSD() {
        return this.ieQ;
    }

    public long bSE() {
        return this.ieR;
    }

    public long bSF() {
        return this.ieS;
    }

    public g bSG() {
        return this.ieT;
    }

    public CacheErrorLogger bSH() {
        return this.ieE;
    }

    public CacheEventListener bSI() {
        return this.ieU;
    }

    public com.facebook.common.a.b bSJ() {
        return this.ieV;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean bSK() {
        return this.ieW;
    }

    public static a dp(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger ieE;
        private String ieO;
        private com.facebook.common.internal.i<File> ieP;
        private g ieT;
        private CacheEventListener ieU;
        private com.facebook.common.a.b ieV;
        private boolean ieW;
        private long ieX;
        private long ieY;
        private long ieZ;
        @Nullable
        private final Context mContext;
        private int vz;

        private a(@Nullable Context context) {
            this.vz = 1;
            this.ieO = "image_cache";
            this.ieX = 41943040L;
            this.ieY = 10485760L;
            this.ieZ = 2097152L;
            this.ieT = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b bSL() {
            com.facebook.common.internal.g.c((this.ieP == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.ieP == null && this.mContext != null) {
                this.ieP = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: bSM */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
