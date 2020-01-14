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
    public final Recorder nmZ;
    public final KeyGenerator nna;
    public final ProxyConfiguration nnb;
    public final int nnc;
    public final int nnd;
    public UrlConverter nne;
    public Dns nnf;
    public Zone nng;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.nnc = builder.nnc;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.nmZ = builder.nmZ;
        this.nna = a(builder.nna);
        this.nnd = builder.nnd;
        this.nnb = builder.nnb;
        this.nne = builder.nne;
        this.nng = builder.nng == null ? AutoZone.nme : builder.nng;
        this.nnf = builder.nnf;
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
        private Zone nng = null;
        private Recorder nmZ = null;
        private KeyGenerator nna = null;
        private ProxyConfiguration nnb = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int nnc = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int nnd = 3;
        private UrlConverter nne = null;
        private Dns nnf = null;

        public Configuration dEQ() {
            return new Configuration(this);
        }
    }
}
