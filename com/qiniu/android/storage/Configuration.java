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
    public final Recorder pwO;
    public final KeyGenerator pwP;
    public final ProxyConfiguration pwQ;
    public final int pwR;
    public final int pwS;
    public UrlConverter pwT;
    public Dns pwU;
    public Zone pwV;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.pwR = builder.pwR;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.pwO = builder.pwO;
        this.pwP = a(builder.pwP);
        this.pwS = builder.pwS;
        this.pwQ = builder.pwQ;
        this.pwT = builder.pwT;
        this.pwV = builder.pwV == null ? AutoZone.pvS : builder.pwV;
        this.pwU = builder.pwU;
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

    /* loaded from: classes6.dex */
    public static class Builder {
        private Zone pwV = null;
        private Recorder pwO = null;
        private KeyGenerator pwP = null;
        private ProxyConfiguration pwQ = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int pwR = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int pwS = 3;
        private UrlConverter pwT = null;
        private Dns pwU = null;

        public Configuration eug() {
            return new Configuration(this);
        }
    }
}
