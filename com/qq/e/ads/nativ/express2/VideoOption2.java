package com.qq.e.ads.nativ.express2;
/* loaded from: classes7.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f35311a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35312b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35313c;

    /* renamed from: d  reason: collision with root package name */
    public int f35314d;

    /* renamed from: e  reason: collision with root package name */
    public int f35315e;

    /* loaded from: classes7.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f35317a;

        AutoPlayPolicy(int i2) {
            this.f35317a = i2;
        }

        public final int getPolicy() {
            return this.f35317a;
        }
    }

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f35318a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        public boolean f35319b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35320c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f35321d;

        /* renamed from: e  reason: collision with root package name */
        public int f35322e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f35319b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f35318a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f35320c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f35321d = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f35322e = i2;
            return this;
        }
    }

    public VideoOption2(Builder builder) {
        this.f35311a = builder.f35318a;
        this.f35312b = builder.f35319b;
        this.f35313c = builder.f35320c;
        this.f35314d = builder.f35321d;
        this.f35315e = builder.f35322e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f35311a;
    }

    public int getMaxVideoDuration() {
        return this.f35314d;
    }

    public int getMinVideoDuration() {
        return this.f35315e;
    }

    public boolean isAutoPlayMuted() {
        return this.f35312b;
    }

    public boolean isDetailPageMuted() {
        return this.f35313c;
    }
}
