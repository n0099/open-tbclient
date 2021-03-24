package com.qq.e.ads.rewardvideo;
/* loaded from: classes6.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    public String f38218a;

    /* renamed from: b  reason: collision with root package name */
    public String f38219b;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f38220a;

        /* renamed from: b  reason: collision with root package name */
        public String f38221b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.f38220a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f38221b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f38218a = builder.f38220a;
        this.f38219b = builder.f38221b;
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.f38218a;
    }

    public String getUserId() {
        return this.f38219b;
    }
}
