package com.facebook.cache.disk;

import android.content.Context;
import com.baidu.mobstat.Config;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger kbI;
    private final String kbQ;
    private final com.facebook.common.internal.i<File> kbR;
    private final long kbS;
    private final long kbT;
    private final long kbU;
    private final g kbV;
    private final CacheEventListener kbW;
    private final com.facebook.common.a.b kbX;
    private final boolean kbY;
    private final Context mContext;
    private final int tb;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.tb = aVar.tb;
        this.kbQ = (String) com.facebook.common.internal.g.checkNotNull(aVar.kbQ);
        this.kbR = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.kbR);
        this.kbS = aVar.kbZ;
        this.kbT = aVar.kca;
        this.kbU = aVar.kcb;
        this.kbV = (g) com.facebook.common.internal.g.checkNotNull(aVar.kbV);
        if (aVar.kbI == null) {
            cacheErrorLogger = com.facebook.cache.common.e.cFc();
        } else {
            cacheErrorLogger = aVar.kbI;
        }
        this.kbI = cacheErrorLogger;
        if (aVar.kbW == null) {
            cacheEventListener = com.facebook.cache.common.f.cFd();
        } else {
            cacheEventListener = aVar.kbW;
        }
        this.kbW = cacheEventListener;
        if (aVar.kbX == null) {
            bVar = com.facebook.common.a.c.cFG();
        } else {
            bVar = aVar.kbX;
        }
        this.kbX = bVar;
        this.mContext = aVar.mContext;
        this.kbY = aVar.kbY;
    }

    public int getVersion() {
        return this.tb;
    }

    public String cFl() {
        return this.kbQ;
    }

    public com.facebook.common.internal.i<File> cFm() {
        return this.kbR;
    }

    public long cFn() {
        return this.kbS;
    }

    public long cFo() {
        return this.kbT;
    }

    public long cFp() {
        return this.kbU;
    }

    public g cFq() {
        return this.kbV;
    }

    public CacheErrorLogger cFr() {
        return this.kbI;
    }

    public CacheEventListener cFs() {
        return this.kbW;
    }

    public com.facebook.common.a.b cFt() {
        return this.kbX;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean cFu() {
        return this.kbY;
    }

    public static a eB(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger kbI;
        private String kbQ;
        private com.facebook.common.internal.i<File> kbR;
        private g kbV;
        private CacheEventListener kbW;
        private com.facebook.common.a.b kbX;
        private boolean kbY;
        private long kbZ;
        private long kca;
        private long kcb;
        @Nullable
        private final Context mContext;
        private int tb;

        private a(@Nullable Context context) {
            this.tb = 1;
            this.kbQ = "image_cache";
            this.kbZ = 41943040L;
            this.kca = Config.FULL_TRACE_LOG_LIMIT;
            this.kcb = 2097152L;
            this.kbV = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b cFv() {
            com.facebook.common.internal.g.c((this.kbR == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.kbR == null && this.mContext != null) {
                this.kbR = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cFw */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
