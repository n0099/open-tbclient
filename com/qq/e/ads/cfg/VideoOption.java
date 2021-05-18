package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f35254a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35255b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f35256c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f35257d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f35258e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f35259f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f35260g;

    /* loaded from: classes5.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes5.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f35261a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f35262b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35263c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f35264d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f35265e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f35266f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f35267g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f35261a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i2 = 1;
            }
            this.f35262b = i2;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f35267g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f35265e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f35266f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f35264d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f35263c = z;
            return this;
        }
    }

    @Deprecated
    /* loaded from: classes5.dex */
    public static final class VideoADContainerRender {
        public static final int DEV = 2;
        public static final int SDK = 1;
        public static final int UNKNOWN = 0;
    }

    @Deprecated
    /* loaded from: classes5.dex */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    public VideoOption(Builder builder) {
        this.f35254a = builder.f35261a;
        this.f35255b = builder.f35262b;
        this.f35256c = builder.f35263c;
        this.f35257d = builder.f35264d;
        this.f35258e = builder.f35265e;
        this.f35259f = builder.f35266f;
        this.f35260g = builder.f35267g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f35254a;
    }

    public int getAutoPlayPolicy() {
        return this.f35255b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f35254a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f35255b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f35260g));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f35260g;
    }

    public boolean isEnableDetailPage() {
        return this.f35258e;
    }

    public boolean isEnableUserControl() {
        return this.f35259f;
    }

    public boolean isNeedCoverImage() {
        return this.f35257d;
    }

    public boolean isNeedProgressBar() {
        return this.f35256c;
    }
}
