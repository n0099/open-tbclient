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
    public final Recorder oqa;
    public final KeyGenerator oqb;
    public final ProxyConfiguration oqc;
    public final int oqd;
    public final int oqe;
    public UrlConverter oqf;
    public Dns oqg;
    public Zone oqh;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.oqd = builder.oqd;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.oqa = builder.oqa;
        this.oqb = a(builder.oqb);
        this.oqe = builder.oqe;
        this.oqc = builder.oqc;
        this.oqf = builder.oqf;
        this.oqh = builder.oqh == null ? AutoZone.ope : builder.oqh;
        this.oqg = builder.oqg;
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
        private Zone oqh = null;
        private Recorder oqa = null;
        private KeyGenerator oqb = null;
        private ProxyConfiguration oqc = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int oqd = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int oqe = 3;
        private UrlConverter oqf = null;
        private Dns oqg = null;

        public Configuration egv() {
            return new Configuration(this);
        }
    }
}
