package com.qq.e.ads.nativ.express2;
/* loaded from: classes6.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f35382a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f35383b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f35384c;

    /* renamed from: d  reason: collision with root package name */
    public int f35385d;

    /* renamed from: e  reason: collision with root package name */
    public int f35386e;

    /* loaded from: classes6.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f35388a;

        AutoPlayPolicy(int i2) {
            this.f35388a = i2;
        }

        public final int getPolicy() {
            return this.f35388a;
        }
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f35389a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        public boolean f35390b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35391c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f35392d;

        /* renamed from: e  reason: collision with root package name */
        public int f35393e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f35390b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f35389a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f35391c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f35392d = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f35393e = i2;
            return this;
        }
    }

    public VideoOption2(Builder builder) {
        this.f35382a = builder.f35389a;
        this.f35383b = builder.f35390b;
        this.f35384c = builder.f35391c;
        this.f35385d = builder.f35392d;
        this.f35386e = builder.f35393e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f35382a;
    }

    public int getMaxVideoDuration() {
        return this.f35385d;
    }

    public int getMinVideoDuration() {
        return this.f35386e;
    }

    public boolean isAutoPlayMuted() {
        return this.f35383b;
    }

    public boolean isDetailPageMuted() {
        return this.f35384c;
    }
}
