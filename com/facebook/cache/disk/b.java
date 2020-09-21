package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes12.dex */
public class b {
    private final Context mContext;
    private final int mVersion;
    private final CacheErrorLogger ntQ;
    private final String ntX;
    private final j<File> ntY;
    private final long ntZ;
    private final long nua;
    private final long nub;
    private final g nuc;
    private final CacheEventListener nud;
    private final com.facebook.common.a.b nue;
    private final boolean nuf;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.ntX = (String) com.facebook.common.internal.g.checkNotNull(aVar.ntX);
        this.ntY = (j) com.facebook.common.internal.g.checkNotNull(aVar.ntY);
        this.ntZ = aVar.nug;
        this.nua = aVar.nuh;
        this.nub = aVar.nui;
        this.nuc = (g) com.facebook.common.internal.g.checkNotNull(aVar.nuc);
        if (aVar.ntQ == null) {
            cacheErrorLogger = com.facebook.cache.common.e.dRS();
        } else {
            cacheErrorLogger = aVar.ntQ;
        }
        this.ntQ = cacheErrorLogger;
        if (aVar.nud == null) {
            cacheEventListener = com.facebook.cache.common.f.dRT();
        } else {
            cacheEventListener = aVar.nud;
        }
        this.nud = cacheEventListener;
        if (aVar.nue == null) {
            bVar = com.facebook.common.a.c.dSw();
        } else {
            bVar = aVar.nue;
        }
        this.nue = bVar;
        this.mContext = aVar.mContext;
        this.nuf = aVar.nuf;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String dSb() {
        return this.ntX;
    }

    public j<File> dSc() {
        return this.ntY;
    }

    public long dSd() {
        return this.ntZ;
    }

    public long dSe() {
        return this.nua;
    }

    public long dSf() {
        return this.nub;
    }

    public g dSg() {
        return this.nuc;
    }

    public CacheErrorLogger dSh() {
        return this.ntQ;
    }

    public CacheEventListener dSi() {
        return this.nud;
    }

    public com.facebook.common.a.b dSj() {
        return this.nue;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean dSk() {
        return this.nuf;
    }

    public static a gv(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger ntQ;
        private String ntX;
        private j<File> ntY;
        private g nuc;
        private CacheEventListener nud;
        private com.facebook.common.a.b nue;
        private boolean nuf;
        private long nug;
        private long nuh;
        private long nui;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.ntX = "image_cache";
            this.nug = 41943040L;
            this.nuh = 10485760L;
            this.nui = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.nuc = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b dSl() {
            com.facebook.common.internal.g.d((this.ntY == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.ntY == null && this.mContext != null) {
                this.ntY = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: dSm */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
