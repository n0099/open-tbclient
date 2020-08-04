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
    public final Recorder nMf;
    public final KeyGenerator nMg;
    public final ProxyConfiguration nMh;
    public final int nMi;
    public final int nMj;
    public UrlConverter nMk;
    public Dns nMl;
    public Zone nMm;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nMi = builder.nMi;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nMf = builder.nMf;
        this.nMg = a(builder.nMg);
        this.nMj = builder.nMj;
        this.nMh = builder.nMh;
        this.nMk = builder.nMk;
        this.nMm = builder.nMm == null ? AutoZone.nLk : builder.nMm;
        this.nMl = builder.nMl;
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
        private Zone nMm = null;
        private Recorder nMf = null;
        private KeyGenerator nMg = null;
        private ProxyConfiguration nMh = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nMi = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nMj = 3;
        private UrlConverter nMk = null;
        private Dns nMl = null;

        public Configuration dQn() {
            return new Configuration(this);
        }
    }
}
