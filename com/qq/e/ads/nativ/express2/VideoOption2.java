package com.qq.e.ads.nativ.express2;
/* loaded from: classes6.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f38182a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38183b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38184c;

    /* renamed from: d  reason: collision with root package name */
    public int f38185d;

    /* renamed from: e  reason: collision with root package name */
    public int f38186e;

    /* loaded from: classes6.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f38188a;

        AutoPlayPolicy(int i) {
            this.f38188a = i;
        }

        public final int getPolicy() {
            return this.f38188a;
        }
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f38189a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38190b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38191c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f38192d;

        /* renamed from: e  reason: collision with root package name */
        public int f38193e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f38190b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f38189a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f38191c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i) {
            this.f38192d = i;
            return this;
        }

        public Builder setMinVideoDuration(int i) {
            this.f38193e = i;
            return this;
        }
    }

    public VideoOption2(Builder builder) {
        this.f38182a = builder.f38189a;
        this.f38183b = builder.f38190b;
        this.f38184c = builder.f38191c;
        this.f38185d = builder.f38192d;
        this.f38186e = builder.f38193e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f38182a;
    }

    public int getMaxVideoDuration() {
        return this.f38185d;
    }

    public int getMinVideoDuration() {
        return this.f38186e;
    }

    public boolean isAutoPlayMuted() {
        return this.f38183b;
    }

    public boolean isDetailPageMuted() {
        return this.f38184c;
    }
}
