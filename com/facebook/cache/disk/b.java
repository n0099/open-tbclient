package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes6.dex */
public class b {
    private final Context mContext;
    private final int mVersion;
    private final CacheErrorLogger prV;
    private final String psc;
    private final j<File> psd;
    private final long pse;
    private final long psf;
    private final long psg;
    private final g psh;
    private final CacheEventListener psi;
    private final com.facebook.common.a.b psj;
    private final boolean psk;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.psc = (String) com.facebook.common.internal.g.checkNotNull(aVar.psc);
        this.psd = (j) com.facebook.common.internal.g.checkNotNull(aVar.psd);
        this.pse = aVar.psl;
        this.psf = aVar.psm;
        this.psg = aVar.psn;
        this.psh = (g) com.facebook.common.internal.g.checkNotNull(aVar.psh);
        if (aVar.prV == null) {
            cacheErrorLogger = com.facebook.cache.common.e.etk();
        } else {
            cacheErrorLogger = aVar.prV;
        }
        this.prV = cacheErrorLogger;
        if (aVar.psi == null) {
            cacheEventListener = com.facebook.cache.common.f.etl();
        } else {
            cacheEventListener = aVar.psi;
        }
        this.psi = cacheEventListener;
        if (aVar.psj == null) {
            bVar = com.facebook.common.a.c.etN();
        } else {
            bVar = aVar.psj;
        }
        this.psj = bVar;
        this.mContext = aVar.mContext;
        this.psk = aVar.psk;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String ett() {
        return this.psc;
    }

    public j<File> etu() {
        return this.psd;
    }

    public long etv() {
        return this.pse;
    }

    public long etw() {
        return this.psf;
    }

    public long etx() {
        return this.psg;
    }

    public g ety() {
        return this.psh;
    }

    public CacheErrorLogger etz() {
        return this.prV;
    }

    public CacheEventListener etA() {
        return this.psi;
    }

    public com.facebook.common.a.b etB() {
        return this.psj;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean etC() {
        return this.psk;
    }

    public static a ig(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes6.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger prV;
        private String psc;
        private j<File> psd;
        private g psh;
        private CacheEventListener psi;
        private com.facebook.common.a.b psj;
        private boolean psk;
        private long psl;
        private long psm;
        private long psn;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.psc = "image_cache";
            this.psl = 41943040L;
            this.psm = 10485760L;
            this.psn = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.psh = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b etD() {
            com.facebook.common.internal.g.checkState((this.psd == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.psd == null && this.mContext != null) {
                this.psd = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX WARN: Can't rename method to resolve collision */
                    @Override // com.facebook.common.internal.j
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
