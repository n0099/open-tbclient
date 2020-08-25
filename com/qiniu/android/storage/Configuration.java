package com.qiniu.android.storage;

import com.qiniu.android.common.AutoZone;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.Dns;
import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.UrlConverter;
import java.io.File;
/* loaded from: classes6.dex */
public final class Configuration {
    public final int chunkSize;
    public final int connectTimeout;
    public final Recorder ofZ;
    public final KeyGenerator oga;
    public final ProxyConfiguration ogb;
    public final int ogc;
    public final int ogd;
    public UrlConverter oge;
    public Dns ogf;
    public Zone ogg;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.ogc = builder.ogc;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.ofZ = builder.ofZ;
        this.oga = a(builder.oga);
        this.ogd = builder.ogd;
        this.ogb = builder.ogb;
        this.oge = builder.oge;
        this.ogg = builder.ogg == null ? AutoZone.ofd : builder.ogg;
        this.ogf = builder.ogf;
    }

    private KeyGenerator a(KeyGenerator keyGenerator) {
        if (keyGenerator == null) {
            return new KeyGenerator() { // from class: com.qiniu.android.storage.Configuration.1
                @Override // com.qiniu.android.storage.KeyGenerator
                public String r(String str, File file) {
                    return str + "_._" + ((Object) new StringBuffer(file.getAbsolutePath()).reverse());
                }
            };
        }
        return keyGenerator;
    }

    /* loaded from: classes6.dex */
    public static class Builder {
        private Zone ogg = null;
        private Recorder ofZ = null;
        private KeyGenerator oga = null;
        private ProxyConfiguration ogb = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int ogc = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int ogd = 3;
        private UrlConverter oge = null;
        private Dns ogf = null;

        public Configuration ecp() {
            return new Configuration(this);
        }
    }
}
