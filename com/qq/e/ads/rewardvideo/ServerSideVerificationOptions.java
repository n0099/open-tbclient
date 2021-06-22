package com.qq.e.ads.rewardvideo;
/* loaded from: classes7.dex */
public class ServerSideVerificationOptions {
    public static final String TRANS_ID = "transId";

    /* renamed from: a  reason: collision with root package name */
    public String f39126a;

    /* renamed from: b  reason: collision with root package name */
    public String f39127b;

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public String f39128a;

        /* renamed from: b  reason: collision with root package name */
        public String f39129b;

        public ServerSideVerificationOptions build() {
            return new ServerSideVerificationOptions(this, (byte) 0);
        }

        public Builder setCustomData(String str) {
            this.f39128a = str;
            return this;
        }

        public Builder setUserId(String str) {
            this.f39129b = str;
            return this;
        }
    }

    public ServerSideVerificationOptions(Builder builder) {
        this.f39126a = builder.f39128a;
        this.f39127b = builder.f39129b;
    }

    public /* synthetic */ ServerSideVerificationOptions(Builder builder, byte b2) {
        this(builder);
    }

    public String getCustomData() {
        return this.f39126a;
    }

    public String getUserId() {
        return this.f39127b;
    }
}
