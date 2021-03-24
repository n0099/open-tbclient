package com.qq.e.ads.nativ.express2;
/* loaded from: classes6.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f38181a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38182b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38183c;

    /* renamed from: d  reason: collision with root package name */
    public int f38184d;

    /* renamed from: e  reason: collision with root package name */
    public int f38185e;

    /* loaded from: classes6.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f38187a;

        AutoPlayPolicy(int i) {
            this.f38187a = i;
        }

        public final int getPolicy() {
            return this.f38187a;
        }
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f38188a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38189b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38190c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f38191d;

        /* renamed from: e  reason: collision with root package name */
        public int f38192e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f38189b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f38188a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f38190c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i) {
            this.f38191d = i;
            return this;
        }

        public Builder setMinVideoDuration(int i) {
            this.f38192e = i;
            return this;
        }
    }

    public VideoOption2(Builder builder) {
        this.f38181a = builder.f38188a;
        this.f38182b = builder.f38189b;
        this.f38183c = builder.f38190c;
        this.f38184d = builder.f38191d;
        this.f38185e = builder.f38192e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f38181a;
    }

    public int getMaxVideoDuration() {
        return this.f38184d;
    }

    public int getMinVideoDuration() {
        return this.f38185e;
    }

    public boolean isAutoPlayMuted() {
        return this.f38182b;
    }

    public boolean isDetailPageMuted() {
        return this.f38183c;
    }
}
