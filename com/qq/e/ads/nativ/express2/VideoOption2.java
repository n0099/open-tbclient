package com.qq.e.ads.nativ.express2;
/* loaded from: classes3.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    private AutoPlayPolicy f11497a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11498b;
    private boolean c;
    private int d;
    private int e;

    /* loaded from: classes3.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        private int f11500a;

        AutoPlayPolicy(int i) {
            this.f11500a = i;
        }

        public final int getPolicy() {
            return this.f11500a;
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        AutoPlayPolicy f11501a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        boolean f11502b = true;
        boolean c = false;
        int d;
        int e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f11502b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f11501a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i) {
            this.d = i;
            return this;
        }

        public Builder setMinVideoDuration(int i) {
            this.e = i;
            return this;
        }
    }

    private VideoOption2(Builder builder) {
        this.f11497a = builder.f11501a;
        this.f11498b = builder.f11502b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f11497a;
    }

    public int getMaxVideoDuration() {
        return this.d;
    }

    public int getMinVideoDuration() {
        return this.e;
    }

    public boolean isAutoPlayMuted() {
        return this.f11498b;
    }

    public boolean isDetailPageMuted() {
        return this.c;
    }
}
