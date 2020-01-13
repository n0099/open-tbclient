package com.qiniu.android.storage;

import com.qiniu.android.common.AutoZone;
import com.qiniu.android.common.Zone;
import com.qiniu.android.http.Dns;
import com.qiniu.android.http.ProxyConfiguration;
import com.qiniu.android.http.UrlConverter;
import java.io.File;
/* loaded from: classes4.dex */
public final class Configuration {
    public final int chunkSize;
    public final int connectTimeout;
    public final Recorder nmU;
    public final KeyGenerator nmV;
    public final ProxyConfiguration nmW;
    public final int nmX;
    public final int nmY;
    public UrlConverter nmZ;
    public Dns nna;
    public Zone nnb;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nmX = builder.nmX;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nmU = builder.nmU;
        this.nmV = a(builder.nmV);
        this.nmY = builder.nmY;
        this.nmW = builder.nmW;
        this.nmZ = builder.nmZ;
        this.nnb = builder.nnb == null ? AutoZone.nlZ : builder.nnb;
        this.nna = builder.nna;
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

    /* loaded from: classes4.dex */
    public static class Builder {
        private Zone nnb = null;
        private Recorder nmU = null;
        private KeyGenerator nmV = null;
        private ProxyConfiguration nmW = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nmX = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nmY = 3;
        private UrlConverter nmZ = null;
        private Dns nna = null;

        public Configuration dEO() {
            return new Configuration(this);
        }
    }
}
