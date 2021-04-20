package com.qq.e.ads.rewardvideo;
/* loaded from: classes6.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    public String f38508a;

    /* renamed from: b  reason: collision with root package name */
    public String f38509b;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f38510a;

        /* renamed from: b  reason: collision with root package name */
        public String f38511b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.f38510a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f38511b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f38508a = builder.f38510a;
        this.f38509b = builder.f38511b;
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.f38508a;
    }

    public String getUserId() {
        return this.f38509b;
    }
}
