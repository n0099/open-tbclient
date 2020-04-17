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
    public final Recorder mMl;
    public final KeyGenerator mMm;
    public final ProxyConfiguration mMn;
    public final int mMo;
    public final int mMp;
    public UrlConverter mMq;
    public Dns mMr;
    public Zone mMs;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.mMo = builder.mMo;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.mMl = builder.mMl;
        this.mMm = a(builder.mMm);
        this.mMp = builder.mMp;
        this.mMn = builder.mMn;
        this.mMq = builder.mMq;
        this.mMs = builder.mMs == null ? AutoZone.mLq : builder.mMs;
        this.mMr = builder.mMr;
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
        private Zone mMs = null;
        private Recorder mMl = null;
        private KeyGenerator mMm = null;
        private ProxyConfiguration mMn = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int mMo = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int mMp = 3;
        private UrlConverter mMq = null;
        private Dns mMr = null;

        public Configuration dAC() {
            return new Configuration(this);
        }
    }
}
