package com.qq.e.ads.nativ.express2;
/* loaded from: classes6.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f38471a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38472b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38473c;

    /* renamed from: d  reason: collision with root package name */
    public int f38474d;

    /* renamed from: e  reason: collision with root package name */
    public int f38475e;

    /* loaded from: classes6.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f38477a;

        AutoPlayPolicy(int i) {
            this.f38477a = i;
        }

        public final int getPolicy() {
            return this.f38477a;
        }
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f38478a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38479b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38480c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f38481d;

        /* renamed from: e  reason: collision with root package name */
        public int f38482e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f38479b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f38478a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f38480c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i) {
            this.f38481d = i;
            return this;
        }

        public Builder setMinVideoDuration(int i) {
            this.f38482e = i;
            return this;
        }
    }

    public VideoOption2(Builder builder) {
        this.f38471a = builder.f38478a;
        this.f38472b = builder.f38479b;
        this.f38473c = builder.f38480c;
        this.f38474d = builder.f38481d;
        this.f38475e = builder.f38482e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f38471a;
    }

    public int getMaxVideoDuration() {
        return this.f38474d;
    }

    public int getMinVideoDuration() {
        return this.f38475e;
    }

    public boolean isAutoPlayMuted() {
        return this.f38472b;
    }

    public boolean isDetailPageMuted() {
        return this.f38473c;
    }
}
