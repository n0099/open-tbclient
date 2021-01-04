package com.qq.e.ads.nativ.express2;
/* loaded from: classes3.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    private AutoPlayPolicy f11796a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f11797b;
    private boolean c;
    private int d;
    private int e;

    /* loaded from: classes3.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        private int f11799a;

        AutoPlayPolicy(int i) {
            this.f11799a = i;
        }

        public final int getPolicy() {
            return this.f11799a;
        }
    }

    /* loaded from: classes3.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        AutoPlayPolicy f11800a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        boolean f11801b = true;
        boolean c = false;
        int d;
        int e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f11801b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f11800a = autoPlayPolicy;
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
        this.f11796a = builder.f11800a;
        this.f11797b = builder.f11801b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f11796a;
    }

    public int getMaxVideoDuration() {
        return this.d;
    }

    public int getMinVideoDuration() {
        return this.e;
    }

    public boolean isAutoPlayMuted() {
        return this.f11797b;
    }

    public boolean isDetailPageMuted() {
        return this.c;
    }
}
