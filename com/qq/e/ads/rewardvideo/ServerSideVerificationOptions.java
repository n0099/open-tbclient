package com.qq.e.ads.rewardvideo;
/* loaded from: classes6.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    public String f38603a;

    /* renamed from: b  reason: collision with root package name */
    public String f38604b;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f38605a;

        /* renamed from: b  reason: collision with root package name */
        public String f38606b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.f38605a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f38606b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f38603a = builder.f38605a;
        this.f38604b = builder.f38606b;
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.f38603a;
    }

    public String getUserId() {
        return this.f38604b;
    }
}
