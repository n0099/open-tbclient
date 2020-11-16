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
    public final Recorder pHK;
    public final KeyGenerator pHL;
    public final ProxyConfiguration pHM;
    public final int pHN;
    public final int pHO;
    public UrlConverter pHP;
    public Dns pHQ;
    public Zone pHR;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.pHN = builder.pHN;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.pHK = builder.pHK;
        this.pHL = a(builder.pHL);
        this.pHO = builder.pHO;
        this.pHM = builder.pHM;
        this.pHP = builder.pHP;
        this.pHR = builder.pHR == null ? AutoZone.pGP : builder.pHR;
        this.pHQ = builder.pHQ;
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
        private Zone pHR = null;
        private Recorder pHK = null;
        private KeyGenerator pHL = null;
        private ProxyConfiguration pHM = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int pHN = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int pHO = 3;
        private UrlConverter pHP = null;
        private Dns pHQ = null;

        public Configuration exW() {
            return new Configuration(this);
        }
    }
}
