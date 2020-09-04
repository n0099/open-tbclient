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
    private final CacheErrorLogger njR;
    private final String njY;
    private final j<File> njZ;
    private final long nka;
    private final long nkb;
    private final long nkc;
    private final g nkd;
    private final CacheEventListener nke;
    private final com.facebook.common.a.b nkf;
    private final boolean nkg;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.njY = (String) com.facebook.common.internal.g.checkNotNull(aVar.njY);
        this.njZ = (j) com.facebook.common.internal.g.checkNotNull(aVar.njZ);
        this.nka = aVar.nkh;
        this.nkb = aVar.nki;
        this.nkc = aVar.nkj;
        this.nkd = (g) com.facebook.common.internal.g.checkNotNull(aVar.nkd);
        if (aVar.njR == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dNU();
        } else {
            cacheErrorLogger = aVar.njR;
        }
        this.njR = cacheErrorLogger;
        if (aVar.nke == null) {
            cacheEventListener = com.facebook.cache.common.f.dNV();
        } else {
            cacheEventListener = aVar.nke;
        }
        this.nke = cacheEventListener;
        if (aVar.nkf == null) {
            bVar = com.facebook.common.a.c.dOy();
        } else {
            bVar = aVar.nkf;
        }
        this.nkf = bVar;
        this.mContext = aVar.mContext;
        this.nkg = aVar.nkg;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dOd() {
        return this.njY;
    }

    public j<File> dOe() {
        return this.njZ;
    }

    public long dOf() {
        return this.nka;
    }

    public long dOg() {
        return this.nkb;
    }

    public long dOh() {
        return this.nkc;
    }

    public g dOi() {
        return this.nkd;
    }

    public CacheErrorLogger dOj() {
        return this.njR;
    }

    public CacheEventListener dOk() {
        return this.nke;
    }

    public com.facebook.common.a.b dOl() {
        return this.nkf;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dOm() {
        return this.nkg;
    }

    public static a gp(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes8.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger njR;
        private String njY;
        private j<File> njZ;
        private g nkd;
        private CacheEventListener nke;
        private com.facebook.common.a.b nkf;
        private boolean nkg;
        private long nkh;
        private long nki;
        private long nkj;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.njY = "image_cache";
            this.nkh = 41943040L;
            this.nki = 10485760L;
            this.nkj = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.nkd = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dOn() {
            com.facebook.common.internal.g.d((this.njZ == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.njZ == null && this.mContext != null) {
                this.njZ = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dOo */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
