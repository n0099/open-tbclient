package com.qq.e.ads.nativ.express2;
/* loaded from: classes7.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f38990a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38991b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38992c;

    /* renamed from: d  reason: collision with root package name */
    public int f38993d;

    /* renamed from: e  reason: collision with root package name */
    public int f38994e;

    /* loaded from: classes7.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f38996a;

        AutoPlayPolicy(int i2) {
            this.f38996a = i2;
        }

        public final int getPolicy() {
            return this.f38996a;
        }
    }

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f38997a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38998b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38999c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f39000d;

        /* renamed from: e  reason: collision with root package name */
        public int f39001e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f38998b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f38997a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f38999c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f39000d = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f39001e = i2;
            return this;
        }
    }

    public VideoOption2(Builder builder) {
        this.f38990a = builder.f38997a;
        this.f38991b = builder.f38998b;
        this.f38992c = builder.f38999c;
        this.f38993d = builder.f39000d;
        this.f38994e = builder.f39001e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f38990a;
    }

    public int getMaxVideoDuration() {
        return this.f38993d;
    }

    public int getMinVideoDuration() {
        return this.f38994e;
    }

    public boolean isAutoPlayMuted() {
        return this.f38991b;
    }

    public boolean isDetailPageMuted() {
        return this.f38992c;
    }
}
