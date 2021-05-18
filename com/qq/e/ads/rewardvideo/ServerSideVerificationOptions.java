package com.qq.e.ads.rewardvideo;
/* loaded from: classes6.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    public String f35420a;

    /* renamed from: b  reason: collision with root package name */
    public String f35421b;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f35422a;

        /* renamed from: b  reason: collision with root package name */
        public String f35423b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.f35422a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f35423b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f35420a = builder.f35422a;
        this.f35421b = builder.f35423b;
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.f35420a;
    }

    public String getUserId() {
        return this.f35421b;
    }
}
