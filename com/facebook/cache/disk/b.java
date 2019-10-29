package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger jZS;
    private final String kaa;
    private final com.facebook.common.internal.i<File> kab;
    private final long kac;
    private final long kad;
    private final long kae;
    private final g kaf;
    private final CacheEventListener kag;
    private final com.facebook.common.a.b kah;
    private final boolean kai;
    private final Context mContext;
    private final int mVersion;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.kaa = (String) com.facebook.common.internal.g.checkNotNull(aVar.kaa);
        this.kab = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.kab);
        this.kac = aVar.kaj;
        this.kad = aVar.kak;
        this.kae = aVar.kal;
        this.kaf = (g) com.facebook.common.internal.g.checkNotNull(aVar.kaf);
        if (aVar.jZS == null) {
            cacheErrorLogger = com.facebook.cache.common.e.cCa();
        } else {
            cacheErrorLogger = aVar.jZS;
        }
        this.jZS = cacheErrorLogger;
        if (aVar.kag == null) {
            cacheEventListener = com.facebook.cache.common.f.cCb();
        } else {
            cacheEventListener = aVar.kag;
        }
        this.kag = cacheEventListener;
        if (aVar.kah == null) {
            bVar = com.facebook.common.a.c.cCE();
        } else {
            bVar = aVar.kah;
        }
        this.kah = bVar;
        this.mContext = aVar.mContext;
        this.kai = aVar.kai;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String cCj() {
        return this.kaa;
    }

    public com.facebook.common.internal.i<File> cCk() {
        return this.kab;
    }

    public long cCl() {
        return this.kac;
    }

    public long cCm() {
        return this.kad;
    }

    public long cCn() {
        return this.kae;
    }

    public g cCo() {
        return this.kaf;
    }

    public CacheErrorLogger cCp() {
        return this.jZS;
    }

    public CacheEventListener cCq() {
        return this.kag;
    }

    public com.facebook.common.a.b cCr() {
        return this.kah;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean cCs() {
        return this.kai;
    }

    public static a eq(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger jZS;
        private String kaa;
        private com.facebook.common.internal.i<File> kab;
        private g kaf;
        private CacheEventListener kag;
        private com.facebook.common.a.b kah;
        private boolean kai;
        private long kaj;
        private long kak;
        private long kal;
        @Nullable
        private final Context mContext;
        private int mVersion;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.kaa = "image_cache";
            this.kaj = 41943040L;
            this.kak = 10485760L;
            this.kal = 2097152L;
            this.kaf = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b cCt() {
            com.facebook.common.internal.g.d((this.kab == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.kab == null && this.mContext != null) {
                this.kab = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: cCu */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
