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
    public UrlConverter nDA;
    public Dns nDB;
    public Zone nDC;
    public final Recorder nDv;
    public final KeyGenerator nDw;
    public final ProxyConfiguration nDx;
    public final int nDy;
    public final int nDz;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nDy = builder.nDy;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nDv = builder.nDv;
        this.nDw = a(builder.nDw);
        this.nDz = builder.nDz;
        this.nDx = builder.nDx;
        this.nDA = builder.nDA;
        this.nDC = builder.nDC == null ? AutoZone.nCA : builder.nDC;
        this.nDB = builder.nDB;
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
        private Zone nDC = null;
        private Recorder nDv = null;
        private KeyGenerator nDw = null;
        private ProxyConfiguration nDx = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nDy = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nDz = 3;
        private UrlConverter nDA = null;
        private Dns nDB = null;

        public Configuration dMQ() {
            return new Configuration(this);
        }
    }
}
