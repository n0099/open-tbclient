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
    public final Recorder nMd;
    public final KeyGenerator nMe;
    public final ProxyConfiguration nMf;
    public final int nMg;
    public final int nMh;
    public UrlConverter nMi;
    public Dns nMj;
    public Zone nMk;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nMg = builder.nMg;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nMd = builder.nMd;
        this.nMe = a(builder.nMe);
        this.nMh = builder.nMh;
        this.nMf = builder.nMf;
        this.nMi = builder.nMi;
        this.nMk = builder.nMk == null ? AutoZone.nLi : builder.nMk;
        this.nMj = builder.nMj;
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
        private Zone nMk = null;
        private Recorder nMd = null;
        private KeyGenerator nMe = null;
        private ProxyConfiguration nMf = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nMg = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nMh = 3;
        private UrlConverter nMi = null;
        private Dns nMj = null;

        public Configuration dQm() {
            return new Configuration(this);
        }
    }
}
