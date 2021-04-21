package com.qq.e.ads.nativ.express2;
/* loaded from: classes6.dex */
public class VideoOption2 {

    /* renamed from: a  reason: collision with root package name */
    public AutoPlayPolicy f38566a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f38567b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f38568c;

    /* renamed from: d  reason: collision with root package name */
    public int f38569d;

    /* renamed from: e  reason: collision with root package name */
    public int f38570e;

    /* loaded from: classes6.dex */
    public enum AutoPlayPolicy {
        WIFI(0),
        ALWAYS(1),
        NEVER(2);
        

        /* renamed from: a  reason: collision with root package name */
        public int f38572a;

        AutoPlayPolicy(int i) {
            this.f38572a = i;
        }

        public final int getPolicy() {
            return this.f38572a;
        }
    }

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public AutoPlayPolicy f38573a = AutoPlayPolicy.WIFI;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38574b = true;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38575c = false;

        /* renamed from: d  reason: collision with root package name */
        public int f38576d;

        /* renamed from: e  reason: collision with root package name */
        public int f38577e;

        public VideoOption2 build() {
            return new VideoOption2(this, (byte) 0);
        }

        public Builder setAutoPlayMuted(boolean z) {
            this.f38574b = z;
            return this;
        }

        public Builder setAutoPlayPolicy(AutoPlayPolicy autoPlayPolicy) {
            if (autoPlayPolicy != null) {
                this.f38573a = autoPlayPolicy;
            }
            return this;
        }

        public Builder setDetailPageMuted(boolean z) {
            this.f38575c = z;
            return this;
        }

        public Builder setMaxVideoDuration(int i) {
            this.f38576d = i;
            return this;
        }

        public Builder setMinVideoDuration(int i) {
            this.f38577e = i;
            return this;
        }
    }

    public VideoOption2(Builder builder) {
        this.f38566a = builder.f38573a;
        this.f38567b = builder.f38574b;
        this.f38568c = builder.f38575c;
        this.f38569d = builder.f38576d;
        this.f38570e = builder.f38577e;
    }

    public /* synthetic */ VideoOption2(Builder builder, byte b2) {
        this(builder);
    }

    public AutoPlayPolicy getAutoPlayPolicy() {
        return this.f38566a;
    }

    public int getMaxVideoDuration() {
        return this.f38569d;
    }

    public int getMinVideoDuration() {
        return this.f38570e;
    }

    public boolean isAutoPlayMuted() {
        return this.f38567b;
    }

    public boolean isDetailPageMuted() {
        return this.f38568c;
    }
}
