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
    public final Recorder npC;
    public final KeyGenerator npD;
    public final ProxyConfiguration npE;
    public final int npF;
    public final int npG;
    public UrlConverter npH;
    public Dns npI;
    public Zone npJ;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.npF = builder.npF;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.npC = builder.npC;
        this.npD = a(builder.npD);
        this.npG = builder.npG;
        this.npE = builder.npE;
        this.npH = builder.npH;
        this.npJ = builder.npJ == null ? AutoZone.noH : builder.npJ;
        this.npI = builder.npI;
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
        private Zone npJ = null;
        private Recorder npC = null;
        private KeyGenerator npD = null;
        private ProxyConfiguration npE = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int npF = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int npG = 3;
        private UrlConverter npH = null;
        private Dns npI = null;

        public Configuration dGA() {
            return new Configuration(this);
        }
    }
}
