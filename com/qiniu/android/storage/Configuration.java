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
    public final Recorder nhC;
    public final KeyGenerator nhD;
    public final ProxyConfiguration nhE;
    public final int nhF;
    public final int nhG;
    public UrlConverter nhH;
    public Dns nhI;
    public Zone nhJ;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nhF = builder.nhF;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nhC = builder.nhC;
        this.nhD = a(builder.nhD);
        this.nhG = builder.nhG;
        this.nhE = builder.nhE;
        this.nhH = builder.nhH;
        this.nhJ = builder.nhJ == null ? AutoZone.ngH : builder.nhJ;
        this.nhI = builder.nhI;
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
        private Zone nhJ = null;
        private Recorder nhC = null;
        private KeyGenerator nhD = null;
        private ProxyConfiguration nhE = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nhF = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nhG = 3;
        private UrlConverter nhH = null;
        private Dns nhI = null;

        public Configuration dIg() {
            return new Configuration(this);
        }
    }
}
