package com.qiniu.android.storage;

import com.qiniu.android.common.AutoZone;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.Dns;
import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.UrlConverter;
import java.io.File;
/* loaded from: classes5.dex */
public final class Configuration {
    public final int chunkSize;
    public final int connectTimeout;
    public final Recorder nDs;
    public final KeyGenerator nDt;
    public final ProxyConfiguration nDu;
    public final int nDv;
    public final int nDw;
    public UrlConverter nDx;
    public Dns nDy;
    public Zone nDz;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nDv = builder.nDv;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nDs = builder.nDs;
        this.nDt = a(builder.nDt);
        this.nDw = builder.nDw;
        this.nDu = builder.nDu;
        this.nDx = builder.nDx;
        this.nDz = builder.nDz == null ? AutoZone.nCx : builder.nDz;
        this.nDy = builder.nDy;
    }

    private KeyGenerator a(KeyGenerator keyGenerator) {
        if (keyGenerator == null) {
            return new KeyGenerator() { // from class: com.qiniu.android.storage.Configuration.1
                @Override // com.qiniu.android.storage.KeyGenerator
                public String p(String str, File file) {
                    return str + "_._" + ((Object) new StringBuffer(file.getAbsolutePath()).reverse());
                }
            };
        }
        return keyGenerator;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private Zone nDz = null;
        private Recorder nDs = null;
        private KeyGenerator nDt = null;
        private ProxyConfiguration nDu = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nDv = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nDw = 3;
        private UrlConverter nDx = null;
        private Dns nDy = null;

        public Configuration dMM() {
            return new Configuration(this);
        }
    }
}
