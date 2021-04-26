package com.qq.e.ads.rewardvideo;
/* loaded from: classes6.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    public String f36175a;

    /* renamed from: b  reason: collision with root package name */
    public String f36176b;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f36177a;

        /* renamed from: b  reason: collision with root package name */
        public String f36178b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.f36177a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f36178b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f36175a = builder.f36177a;
        this.f36176b = builder.f36178b;
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.f36175a;
    }

    public String getUserId() {
        return this.f36176b;
    }
}
