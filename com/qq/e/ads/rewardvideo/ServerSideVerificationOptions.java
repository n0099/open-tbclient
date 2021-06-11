package com.qq.e.ads.rewardvideo;
/* loaded from: classes7.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    public String f39028a;

    /* renamed from: b  reason: collision with root package name */
    public String f39029b;

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f39030a;

        /* renamed from: b  reason: collision with root package name */
        public String f39031b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.f39030a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f39031b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f39028a = builder.f39030a;
        this.f39029b = builder.f39031b;
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.f39028a;
    }

    public String getUserId() {
        return this.f39029b;
    }
}
