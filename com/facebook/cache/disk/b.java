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
    private final CacheErrorLogger pyh;
    private final String pyo;
    private final j<File> pyp;
    private final long pyq;
    private final long pyr;
    private final long pys;
    private final g pyt;
    private final CacheEventListener pyu;
    private final com.facebook.common.a.b pyv;
    private final boolean pyw;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.mVersion = aVar.mVersion;
        this.pyo = (String) com.facebook.common.internal.g.checkNotNull(aVar.pyo);
        this.pyp = (j) com.facebook.common.internal.g.checkNotNull(aVar.pyp);
        this.pyq = aVar.pyx;
        this.pyr = aVar.pyy;
        this.pys = aVar.pyz;
        this.pyt = (g) com.facebook.common.internal.g.checkNotNull(aVar.pyt);
        if (aVar.pyh == null) {
            cacheErrorLogger = com.facebook.cache.common.e.erV();
        } else {
            cacheErrorLogger = aVar.pyh;
        }
        this.pyh = cacheErrorLogger;
        if (aVar.pyu == null) {
            cacheEventListener = com.facebook.cache.common.f.erW();
        } else {
            cacheEventListener = aVar.pyu;
        }
        this.pyu = cacheEventListener;
        if (aVar.pyv == null) {
            bVar = com.facebook.common.a.c.esy();
        } else {
            bVar = aVar.pyv;
        }
        this.pyv = bVar;
        this.mContext = aVar.mContext;
        this.pyw = aVar.pyw;
    }

    public int getVersion() {
        return this.mVersion;
    }

    public String ese() {
        return this.pyo;
    }

    public j<File> esf() {
        return this.pyp;
    }

    public long esg() {
        return this.pyq;
    }

    public long esh() {
        return this.pyr;
    }

    public long esi() {
        return this.pys;
    }

    public g esj() {
        return this.pyt;
    }

    public CacheErrorLogger esk() {
        return this.pyh;
    }

    public CacheEventListener esl() {
        return this.pyu;
    }

    public com.facebook.common.a.b esm() {
        return this.pyv;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean esn() {
        return this.pyw;
    }

    public static a ih(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes5.dex */
    public static class a {
        @Nullable
        private final Context mContext;
        private int mVersion;
        private CacheErrorLogger pyh;
        private String pyo;
        private j<File> pyp;
        private g pyt;
        private CacheEventListener pyu;
        private com.facebook.common.a.b pyv;
        private boolean pyw;
        private long pyx;
        private long pyy;
        private long pyz;

        private a(@Nullable Context context) {
            this.mVersion = 1;
            this.pyo = "image_cache";
            this.pyx = 41943040L;
            this.pyy = 10485760L;
            this.pyz = PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
            this.pyt = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b eso() {
            com.facebook.common.internal.g.checkState((this.pyp == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.pyp == null && this.mContext != null) {
                this.pyp = new j<File>() { // from class: com.facebook.cache.disk.b.a.1
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
