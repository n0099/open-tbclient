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
    public final Recorder oFr;
    public final KeyGenerator oFs;
    public final ProxyConfiguration oFt;
    public final int oFu;
    public final int oFv;
    public UrlConverter oFw;
    public Dns oFx;
    public Zone oFy;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.oFu = builder.oFu;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.oFr = builder.oFr;
        this.oFs = a(builder.oFs);
        this.oFv = builder.oFv;
        this.oFt = builder.oFt;
        this.oFw = builder.oFw;
        this.oFy = builder.oFy == null ? AutoZone.oEw : builder.oFy;
        this.oFx = builder.oFx;
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
        private Zone oFy = null;
        private Recorder oFr = null;
        private KeyGenerator oFs = null;
        private ProxyConfiguration oFt = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int oFu = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int oFv = 3;
        private UrlConverter oFw = null;
        private Dns oFx = null;

        public Configuration ekg() {
            return new Configuration(this);
        }
    }
}
