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
    public final Recorder nnA;
    public final KeyGenerator nnB;
    public final ProxyConfiguration nnC;
    public final int nnD;
    public final int nnE;
    public UrlConverter nnF;
    public Dns nnG;
    public Zone nnH;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nnD = builder.nnD;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nnA = builder.nnA;
        this.nnB = a(builder.nnB);
        this.nnE = builder.nnE;
        this.nnC = builder.nnC;
        this.nnF = builder.nnF;
        this.nnH = builder.nnH == null ? AutoZone.nmF : builder.nnH;
        this.nnG = builder.nnG;
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

    /* loaded from: classes5.dex */
    public static class Builder {
        private Zone nnH = null;
        private Recorder nnA = null;
        private KeyGenerator nnB = null;
        private ProxyConfiguration nnC = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nnD = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nnE = 3;
        private UrlConverter nnF = null;
        private Dns nnG = null;

        public Configuration dFX() {
            return new Configuration(this);
        }
    }
}
