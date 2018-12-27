package com.facebook.cache.disk;

import android.content.Context;
import com.facebook.cache.common.CacheErrorLogger;
import com.facebook.cache.common.CacheEventListener;
import java.io.File;
import javax.annotation.Nullable;
/* loaded from: classes2.dex */
public class b {
    private final CacheErrorLogger ihO;
    private final String ihY;
    private final com.facebook.common.internal.i<File> ihZ;
    private final long iia;
    private final long iib;
    private final long iic;
    private final g iid;
    private final CacheEventListener iie;
    private final com.facebook.common.a.b iif;
    private final boolean iig;
    private final Context mContext;
    private final int vz;

    private b(a aVar) {
        CacheErrorLogger cacheErrorLogger;
        CacheEventListener cacheEventListener;
        com.facebook.common.a.b bVar;
        this.vz = aVar.vz;
        this.ihY = (String) com.facebook.common.internal.g.checkNotNull(aVar.ihY);
        this.ihZ = (com.facebook.common.internal.i) com.facebook.common.internal.g.checkNotNull(aVar.ihZ);
        this.iia = aVar.iih;
        this.iib = aVar.iii;
        this.iic = aVar.iij;
        this.iid = (g) com.facebook.common.internal.g.checkNotNull(aVar.iid);
        if (aVar.ihO == null) {
            cacheErrorLogger = com.facebook.cache.common.e.bTi();
        } else {
            cacheErrorLogger = aVar.ihO;
        }
        this.ihO = cacheErrorLogger;
        if (aVar.iie == null) {
            cacheEventListener = com.facebook.cache.common.f.bTj();
        } else {
            cacheEventListener = aVar.iie;
        }
        this.iie = cacheEventListener;
        if (aVar.iif == null) {
            bVar = com.facebook.common.a.c.bTM();
        } else {
            bVar = aVar.iif;
        }
        this.iif = bVar;
        this.mContext = aVar.mContext;
        this.iig = aVar.iig;
    }

    public int getVersion() {
        return this.vz;
    }

    public String bTr() {
        return this.ihY;
    }

    public com.facebook.common.internal.i<File> bTs() {
        return this.ihZ;
    }

    public long bTt() {
        return this.iia;
    }

    public long bTu() {
        return this.iib;
    }

    public long bTv() {
        return this.iic;
    }

    public g bTw() {
        return this.iid;
    }

    public CacheErrorLogger bTx() {
        return this.ihO;
    }

    public CacheEventListener bTy() {
        return this.iie;
    }

    public com.facebook.common.a.b bTz() {
        return this.iif;
    }

    public Context getContext() {
        return this.mContext;
    }

    public boolean bTA() {
        return this.iig;
    }

    public static a dp(@Nullable Context context) {
        return new a(context);
    }

    /* loaded from: classes2.dex */
    public static class a {
        private CacheErrorLogger ihO;
        private String ihY;
        private com.facebook.common.internal.i<File> ihZ;
        private g iid;
        private CacheEventListener iie;
        private com.facebook.common.a.b iif;
        private boolean iig;
        private long iih;
        private long iii;
        private long iij;
        @Nullable
        private final Context mContext;
        private int vz;

        private a(@Nullable Context context) {
            this.vz = 1;
            this.ihY = "image_cache";
            this.iih = 41943040L;
            this.iii = 10485760L;
            this.iij = 2097152L;
            this.iid = new com.facebook.cache.disk.a();
            this.mContext = context;
        }

        public b bTB() {
            com.facebook.common.internal.g.c((this.ihZ == null && this.mContext == null) ? false : true, "Either a non-null context or a base directory path or supplier must be provided.");
            if (this.ihZ == null && this.mContext != null) {
                this.ihZ = new com.facebook.common.internal.i<File>() { // from class: com.facebook.cache.disk.b.a.1
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.facebook.common.internal.i
                    /* renamed from: bTC */
                    public File get() {
                        return a.this.mContext.getApplicationContext().getCacheDir();
                    }
                };
            }
            return new b(this);
        }
    }
}
