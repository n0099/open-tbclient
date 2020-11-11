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
    private final CacheErrorLogger oJW;
    private final String oKd;
    private final j<File> oKe;
    private final long oKf;
    private final long oKg;
    private final long oKh;
    private final g oKi;
    private final CacheEventListener oKj;
    private final com.facebook.common.a.b oKk;
    private final boolean oKl;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.oKd = (String) com.facebook.common.internal.g.checkNotNull(aVar.oKd);
        this.oKe = (j) com.facebook.common.internal.g.checkNotNull(aVar.oKe);
        this.oKf = aVar.oKm;
        this.oKg = aVar.oKn;
        this.oKh = aVar.oKo;
        this.oKi = (g) com.facebook.common.internal.g.checkNotNull(aVar.oKi);
        if (aVar.oJW == null) {
            cacheErrorLogger = com.facebook.cache.common.e.ejq();
        } else {
            cacheErrorLogger = aVar.oJW;
        }
        this.oJW = cacheErrorLogger;
        if (aVar.oKj == null) {
            cacheEventListener = com.facebook.cache.common.f.ejr();
        } else {
            cacheEventListener = aVar.oKj;
        }
        this.oKj = cacheEventListener;
        if (aVar.oKk == null) {
            bVar = com.facebook.common.a.c.ejU();
        } else {
            bVar = aVar.oKk;
        }
        this.oKk = bVar;
        this.mContext = aVar.mContext;
        this.oKl = aVar.oKl;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String ejz() {
        return this.oKd;
    }

    public j<File> ejA() {
        return this.oKe;
    }

    public long ejB() {
        return this.oKf;
    }

    public long ejC() {
        return this.oKg;
    }

    public long ejD() {
        return this.oKh;
    }

    public g ejE() {
        return this.oKi;
    }

    public CacheErrorLogger ejF() {
        return this.oJW;
    }

    public CacheEventListener ejG() {
        return this.oKj;
    }

    public com.facebook.common.a.b ejH() {
        return this.oKk;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean ejI() {
        return this.oKl;
    }

    public static a gX(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes12.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger oJW;
        private String oKd;
        private j<File> oKe;
        private g oKi;
        private CacheEventListener oKj;
        private com.facebook.common.a.b oKk;
        private boolean oKl;
        private long oKm;
        private long oKn;
        private long oKo;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.oKd = "image_cache";
            this.oKm = 41943040L;
            this.oKn = 10485760L;
            this.oKo = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.oKi = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b ejJ() {
            com.facebook.common.internal.g.d((this.oKe == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.oKe == null && this.mContext != null) {
                this.oKe = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.j
                    /* renamed from: ejK */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
