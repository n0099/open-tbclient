package com.qq.e.ads.nativ.express2;
/* loaded from: classes6.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f36137a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f36138b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f36139c;

    /* renamed from: d  reason: collision with root package name */
    public int f36140d;

    /* renamed from: e  reason: collision with root package name */
    public int f36141e;

    /* loaded from: classes6.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f36143a;

        AutoPlayPolicy(int i2) {
            this.f36143a = i2;
        }

        public final int getPolicy() {
            return this.f36143a;
        }
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f36144a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        public boolean f36145b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36146c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f36147d;

        /* renamed from: e  reason: collision with root package name */
        public int f36148e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f36145b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f36144a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f36146c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f36147d = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f36148e = i2;
            return this;
        }
    }

    public VideoOption2(Builder builder) {
        this.f36137a = builder.f36144a;
        this.f36138b = builder.f36145b;
        this.f36139c = builder.f36146c;
        this.f36140d = builder.f36147d;
        this.f36141e = builder.f36148e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f36137a;
    }

    public int getMaxVideoDuration() {
        return this.f36140d;
    }

    public int getMinVideoDuration() {
        return this.f36141e;
    }

    public boolean isAutoPlayMuted() {
        return this.f36138b;
    }

    public boolean isDetailPageMuted() {
        return this.f36139c;
    }
}
