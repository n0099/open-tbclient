package com.qq.e.ads.nativ.express2;
/* loaded from: classes7.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f39088a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f39089b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39090c;

    /* renamed from: d  reason: collision with root package name */
    public int f39091d;

    /* renamed from: e  reason: collision with root package name */
    public int f39092e;

    /* loaded from: classes7.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f39094a;

        AutoPlayPolicy(int i2) {
            this.f39094a = i2;
        }

        public final int getPolicy() {
            return this.f39094a;
        }
    }

    /* loaded from: classes7.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f39095a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        public boolean f39096b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f39097c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f39098d;

        /* renamed from: e  reason: collision with root package name */
        public int f39099e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f39096b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f39095a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f39097c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i2) {
            this.f39098d = i2;
            return this;
        }

        public Builder setMinVideoDuration(int i2) {
            this.f39099e = i2;
            return this;
        }
    }

    public VideoOption2(Builder builder) {
        this.f39088a = builder.f39095a;
        this.f39089b = builder.f39096b;
        this.f39090c = builder.f39097c;
        this.f39091d = builder.f39098d;
        this.f39092e = builder.f39099e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f39088a;
    }

    public int getMaxVideoDuration() {
        return this.f39091d;
    }

    public int getMinVideoDuration() {
        return this.f39092e;
    }

    public boolean isAutoPlayMuted() {
        return this.f39089b;
    }

    public boolean isDetailPageMuted() {
        return this.f39090c;
    }
}
