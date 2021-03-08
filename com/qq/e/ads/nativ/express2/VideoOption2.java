package com.qq.e.ads.nativ.express2;
/* loaded from: classes4.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    private AutoPlayPolicy f7534a;
    private boolean b;
    private boolean c;
    private int d;
    private int e;

    /* loaded from: classes4.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        private int f7535a;

        AutoPlayPolicy(int i) {
            this.f7535a = i;
        }

        public final int getPolicy() {
            return this.f7535a;
        }
    }

    /* loaded from: classes4.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        AutoPlayPolicy f7536a = AutoPlayPolicy.WIFI;
        boolean b = true;
        boolean c = false;
        int d;
        int e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f7536a = autoPlayPolicy;
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
        this.f7534a = builder.f7536a;
        this.b = builder.b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
    }

    /* synthetic */ VideoOption2(Builder builder, byte b) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f7534a;
    }

    public int getMaxVideoDuration() {
        return this.d;
    }

    public int getMinVideoDuration() {
        return this.e;
    }

    public boolean isAutoPlayMuted() {
        return this.b;
    }

    public boolean isDetailPageMuted() {
        return this.c;
    }
}
