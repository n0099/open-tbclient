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
    public final Recorder mMo;
    public final KeyGenerator mMp;
    public final ProxyConfiguration mMq;
    public final int mMr;
    public final int mMs;
    public UrlConverter mMt;
    public Dns mMu;
    public Zone mMv;
    public final int responseTimeout;
    public boolean useHttps;

    private Configuration(Builder builder) {
        this.useHttps = builder.useHttps;
        this.chunkSize = builder.chunkSize;
        this.mMr = builder.mMr;
        this.connectTimeout = builder.connectTimeout;
        this.responseTimeout = builder.responseTimeout;
        this.mMo = builder.mMo;
        this.mMp = a(builder.mMp);
        this.mMs = builder.mMs;
        this.mMq = builder.mMq;
        this.mMt = builder.mMt;
        this.mMv = builder.mMv == null ? AutoZone.mLt : builder.mMv;
        this.mMu = builder.mMu;
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
        private Zone mMv = null;
        private Recorder mMo = null;
        private KeyGenerator mMp = null;
        private ProxyConfiguration mMq = null;
        private boolean useHttps = false;
        private int chunkSize = 2097152;
        private int mMr = 4194304;
        private int connectTimeout = 10;
        private int responseTimeout = 60;
        private int mMs = 3;
        private UrlConverter mMt = null;
        private Dns mMu = null;

        public Configuration dAy() {
            return new Configuration(this);
        }
    }
}
