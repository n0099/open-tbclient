package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import com.facebook.common.internal.k;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes13.dex */
public class b {
    private final CacheErrorLogger lIW;
    private final String lJd;
    private final j<File> lJe;
    private final long lJf;
    private final long lJg;
    private final long lJh;
    private final g lJi;
    private final CacheEventListener lJj;
    private final com.facebook.common.a.b lJk;
    private final boolean lJl;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.lJd = (String) com.facebook.common.internal.g.checkNotNull(aVar.lJd);
        this.lJe = (j) com.facebook.common.internal.g.checkNotNull(aVar.lJe);
        this.lJf = aVar.lJm;
        this.lJg = aVar.lJn;
        this.lJh = aVar.lJo;
        this.lJi = (g) com.facebook.common.internal.g.checkNotNull(aVar.lJi);
        if (aVar.lIW == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dkt();
        } else {
            cacheErrorLogger = aVar.lIW;
        }
        this.lIW = cacheErrorLogger;
        if (aVar.lJj == null) {
            cacheEventListener = com.facebook.cache.common.f.dku();
        } else {
            cacheEventListener = aVar.lJj;
        }
        this.lJj = cacheEventListener;
        if (aVar.lJk == null) {
            bVar = com.facebook.common.a.c.dkX();
        } else {
            bVar = aVar.lJk;
        }
        this.lJk = bVar;
        this.mContext = aVar.mContext;
        this.lJl = aVar.lJl;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dkC() {
        return this.lJd;
    }

    public j<File> dkD() {
        return this.lJe;
    }

    public long dkE() {
        return this.lJf;
    }

    public long dkF() {
        return this.lJg;
    }

    public long dkG() {
        return this.lJh;
    }

    public g dkH() {
        return this.lJi;
    }

    public CacheErrorLogger dkI() {
        return this.lIW;
    }

    public CacheEventListener dkJ() {
        return this.lJj;
    }

    public com.facebook.common.a.b dkK() {
        return this.lJk;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dkL() {
        return this.lJl;
    }

    public static a gi(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private CacheErrorLogger lIW;
        private String lJd;
        private j<File> lJe;
        private g lJi;
        private CacheEventListener lJj;
        private com.facebook.common.a.b lJk;
        private boolean lJl;
        private long lJm;
        private long lJn;
        private long lJo;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.lJd = "image_cache";
            this.lJm = 41943040L;
            this.lJn = 10485760L;
            this.lJo = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.lJi = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public a ai(File file) {
            this.lJe = k.aU(file);
            return this;
        }

        public b dkM() {
            com.facebook.common.internal.g.d((this.lJe == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.lJe == null && this.mContext != null) {
                this.lJe = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dkN */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
