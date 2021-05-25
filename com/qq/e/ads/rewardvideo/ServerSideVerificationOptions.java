package com.qq.e.ads.rewardvideo;
/* loaded from: classes7.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    public String f35349a;

    /* renamed from: b  reason: collision with root package name */
    public String f35350b;

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f35351a;

        /* renamed from: b  reason: collision with root package name */
        public String f35352b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.f35351a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f35352b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f35349a = builder.f35351a;
        this.f35350b = builder.f35352b;
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.f35349a;
    }

    public String getUserId() {
        return this.f35350b;
    }
}
