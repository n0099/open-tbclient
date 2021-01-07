package com.facebook.cache.disk;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import com.facebook.common.internal.j;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes5.dex */
public class b {
    private final Context mContext;
    private final int mVersion;
    private final CacheErrorLogger prW;
    private final String psd;
    private final j<File> pse;
    private final long psf;
    private final long psg;
    private final long psh;
    private final g psi;
    private final CacheEventListener psj;
    private final com.facebook.common.a.b psk;
    private final boolean psl;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.psd = (String) com.facebook.common.internal.g.checkNotNull(aVar.psd);
        this.pse = (j) com.facebook.common.internal.g.checkNotNull(aVar.pse);
        this.psf = aVar.psm;
        this.psg = aVar.psn;
        this.psh = aVar.pso;
        this.psi = (g) com.facebook.common.internal.g.checkNotNull(aVar.psi);
        if (aVar.prW == null) {
            cacheErrorLogger = com.facebook.cache.common.e.eto();
        } else {
            cacheErrorLogger = aVar.prW;
        }
        this.prW = cacheErrorLogger;
        if (aVar.psj == null) {
            cacheEventListener = com.facebook.cache.common.f.etp();
        } else {
            cacheEventListener = aVar.psj;
        }
        this.psj = cacheEventListener;
        if (aVar.psk == null) {
            bVar = com.facebook.common.a.c.etR();
        } else {
            bVar = aVar.psk;
        }
        this.psk = bVar;
        this.mContext = aVar.mContext;
        this.psl = aVar.psl;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String etx() {
        return this.psd;
    }

    public j<File> ety() {
        return this.pse;
    }

    public long etz() {
        return this.psf;
    }

    public long etA() {
        return this.psg;
    }

    public long etB() {
        return this.psh;
    }

    public g etC() {
        return this.psi;
    }

    public CacheErrorLogger etD() {
        return this.prW;
    }

    public CacheEventListener etE() {
        return this.psj;
    }

    public com.facebook.common.a.b etF() {
        return this.psk;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean etG() {
        return this.psl;
    }

    public static a ig(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger prW;
        private String psd;
        private j<File> pse;
        private g psi;
        private CacheEventListener psj;
        private com.facebook.common.a.b psk;
        private boolean psl;
        private long psm;
        private long psn;
        private long pso;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.psd = "image_cache";
            this.psm = 41943040L;
            this.psn = 10485760L;
            this.pso = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.psi = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b etH() {
            com.facebook.common.internal.g.checkState((this.pse == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.pse == null && this.mContext != null) {
                this.pse = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
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
