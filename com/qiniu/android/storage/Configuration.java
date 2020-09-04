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
    public final Recorder ogr;
    public final KeyGenerator ogs;
    public final ProxyConfiguration ogt;
    public final int ogu;
    public final int ogv;
    public UrlConverter ogw;
    public Dns ogx;
    public Zone ogy;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.ogu = builder.ogu;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.ogr = builder.ogr;
        this.ogs = a(builder.ogs);
        this.ogv = builder.ogv;
        this.ogt = builder.ogt;
        this.ogw = builder.ogw;
        this.ogy = builder.ogy == null ? AutoZone.ofw : builder.ogy;
        this.ogx = builder.ogx;
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
        private Zone ogy = null;
        private Recorder ogr = null;
        private KeyGenerator ogs = null;
        private ProxyConfiguration ogt = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int ogu = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int ogv = 3;
        private UrlConverter ogw = null;
        private Dns ogx = null;

        public Configuration ecy() {
            return new Configuration(this);
        }
    }
}
