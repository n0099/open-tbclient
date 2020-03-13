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
    public final Recorder nnN;
    public final KeyGenerator nnO;
    public final ProxyConfiguration nnP;
    public final int nnQ;
    public final int nnR;
    public UrlConverter nnS;
    public Dns nnT;
    public Zone nnU;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nnQ = builder.nnQ;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nnN = builder.nnN;
        this.nnO = a(builder.nnO);
        this.nnR = builder.nnR;
        this.nnP = builder.nnP;
        this.nnS = builder.nnS;
        this.nnU = builder.nnU == null ? AutoZone.nmS : builder.nnU;
        this.nnT = builder.nnT;
    }

    private KeyGenerator a(KeyGenerator keyGenerator) {
        if (keyGenerator == null) {
            return new KeyGenerator() { // from class: com.qiniu.android.storage.Configuration.1
                @Override // com.qiniu.android.storage.KeyGenerator
                public String q(String str, File file) {
                    return str + "_._" + ((Object) new StringBuffer(file.getAbsolutePath()).reverse());
                }
            };
        }
        return keyGenerator;
    }

    /* loaded from: classes5.dex */
    public static class Builder {
        private Zone nnU = null;
        private Recorder nnN = null;
        private KeyGenerator nnO = null;
        private ProxyConfiguration nnP = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nnQ = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nnR = 3;
        private UrlConverter nnS = null;
        private Dns nnT = null;

        public Configuration dGa() {
            return new Configuration(this);
        }
    }
}
