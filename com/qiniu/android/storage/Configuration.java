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
    public final Recorder pGh;
    public final KeyGenerator pGi;
    public final ProxyConfiguration pGj;
    public final int pGk;
    public final int pGl;
    public UrlConverter pGm;
    public Dns pGn;
    public Zone pGo;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.pGk = builder.pGk;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.pGh = builder.pGh;
        this.pGi = a(builder.pGi);
        this.pGl = builder.pGl;
        this.pGj = builder.pGj;
        this.pGm = builder.pGm;
        this.pGo = builder.pGo == null ? AutoZone.pFm : builder.pGo;
        this.pGn = builder.pGn;
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
        private Zone pGo = null;
        private Recorder pGh = null;
        private KeyGenerator pGi = null;
        private ProxyConfiguration pGj = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int pGk = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int pGl = 3;
        private UrlConverter pGm = null;
        private Dns pGn = null;

        public Configuration exV() {
            return new Configuration(this);
        }
    }
}
