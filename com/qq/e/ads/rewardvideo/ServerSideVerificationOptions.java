package com.qq.e.ads.rewardvideo;
/* loaded from: classes6.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    public String f38219a;

    /* renamed from: b  reason: collision with root package name */
    public String f38220b;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f38221a;

        /* renamed from: b  reason: collision with root package name */
        public String f38222b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.f38221a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f38222b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f38219a = builder.f38221a;
        this.f38220b = builder.f38222b;
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.f38219a;
    }

    public String getUserId() {
        return this.f38220b;
    }
}
