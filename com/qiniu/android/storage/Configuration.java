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
    public final Recorder ngs;
    public final KeyGenerator ngt;
    public final ProxyConfiguration ngu;
    public final int ngv;
    public final int ngw;
    public UrlConverter ngx;
    public Dns ngy;
    public Zone ngz;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.ngv = builder.ngv;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.ngs = builder.ngs;
        this.ngt = a(builder.ngt);
        this.ngw = builder.ngw;
        this.ngu = builder.ngu;
        this.ngx = builder.ngx;
        this.ngz = builder.ngz == null ? AutoZone.nfx : builder.ngz;
        this.ngy = builder.ngy;
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
        private Zone ngz = null;
        private Recorder ngs = null;
        private KeyGenerator ngt = null;
        private ProxyConfiguration ngu = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int ngv = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int ngw = 3;
        private UrlConverter ngx = null;
        private Dns ngy = null;

        public Configuration dHS() {
            return new Configuration(this);
        }
    }
}
