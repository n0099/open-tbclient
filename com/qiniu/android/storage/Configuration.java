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
    public final Recorder nnC;
    public final KeyGenerator nnD;
    public final ProxyConfiguration nnE;
    public final int nnF;
    public final int nnG;
    public UrlConverter nnH;
    public Dns nnI;
    public Zone nnJ;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nnF = builder.nnF;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nnC = builder.nnC;
        this.nnD = a(builder.nnD);
        this.nnG = builder.nnG;
        this.nnE = builder.nnE;
        this.nnH = builder.nnH;
        this.nnJ = builder.nnJ == null ? AutoZone.nmH : builder.nnJ;
        this.nnI = builder.nnI;
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
        private Zone nnJ = null;
        private Recorder nnC = null;
        private KeyGenerator nnD = null;
        private ProxyConfiguration nnE = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nnF = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nnG = 3;
        private UrlConverter nnH = null;
        private Dns nnI = null;

        public Configuration dFZ() {
            return new Configuration(this);
        }
    }
}
