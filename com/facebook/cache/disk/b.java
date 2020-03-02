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
    private final CacheErrorLogger lHf;
    private final String lHm;
    private final j<File> lHn;
    private final long lHo;
    private final long lHp;
    private final long lHq;
    private final g lHr;
    private final CacheEventListener lHs;
    private final com.facebook.common.a.b lHt;
    private final boolean lHu;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.lHm = (String) com.facebook.common.internal.g.checkNotNull(aVar.lHm);
        this.lHn = (j) com.facebook.common.internal.g.checkNotNull(aVar.lHn);
        this.lHo = aVar.lHv;
        this.lHp = aVar.lHw;
        this.lHq = aVar.lHx;
        this.lHr = (g) com.facebook.common.internal.g.checkNotNull(aVar.lHr);
        if (aVar.lHf == null) {
            cacheErrorLogger = com.facebook.cache.common.e.djV();
        } else {
            cacheErrorLogger = aVar.lHf;
        }
        this.lHf = cacheErrorLogger;
        if (aVar.lHs == null) {
            cacheEventListener = com.facebook.cache.common.f.djW();
        } else {
            cacheEventListener = aVar.lHs;
        }
        this.lHs = cacheEventListener;
        if (aVar.lHt == null) {
            bVar = com.facebook.common.a.c.dkz();
        } else {
            bVar = aVar.lHt;
        }
        this.lHt = bVar;
        this.mContext = aVar.mContext;
        this.lHu = aVar.lHu;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dke() {
        return this.lHm;
    }

    public j<File> dkf() {
        return this.lHn;
    }

    public long dkg() {
        return this.lHo;
    }

    public long dkh() {
        return this.lHp;
    }

    public long dki() {
        return this.lHq;
    }

    public g dkj() {
        return this.lHr;
    }

    public CacheErrorLogger dkk() {
        return this.lHf;
    }

    public CacheEventListener dkl() {
        return this.lHs;
    }

    public com.facebook.common.a.b dkm() {
        return this.lHt;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dkn() {
        return this.lHu;
    }

    public static a gj(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes13.dex */
    public static class a {
        private CacheErrorLogger lHf;
        private String lHm;
        private j<File> lHn;
        private g lHr;
        private CacheEventListener lHs;
        private com.facebook.common.a.b lHt;
        private boolean lHu;
        private long lHv;
        private long lHw;
        private long lHx;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.lHm = "image_cache";
            this.lHv = 41943040L;
            this.lHw = 10485760L;
            this.lHx = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.lHr = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public a ai(File file) {
            this.lHn = k.aU(file);
            return this;
        }

        public b dko() {
            com.facebook.common.internal.g.d((this.lHn == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.lHn == null && this.mContext != null) {
                this.lHn = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dkp */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
