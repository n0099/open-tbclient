package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f38862a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38863b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f38864c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f38865d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f38866e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f38867f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f38868g;

    /* loaded from: classes7.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f38869a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f38870b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38871c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f38872d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38873e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38874f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38875g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f38869a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i2 = 1;
            }
            this.f38870b = i2;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f38875g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f38873e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f38874f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f38872d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f38871c = z;
            return this;
        }
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public static final class VideoADContainerRender {
        public static final int DEV = 2;
        public static final int SDK = 1;
        public static final int UNKNOWN = 0;
    }

    @Deprecated
    /* loaded from: classes7.dex */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    public VideoOption(Builder builder) {
        this.f38862a = builder.f38869a;
        this.f38863b = builder.f38870b;
        this.f38864c = builder.f38871c;
        this.f38865d = builder.f38872d;
        this.f38866e = builder.f38873e;
        this.f38867f = builder.f38874f;
        this.f38868g = builder.f38875g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f38862a;
    }

    public int getAutoPlayPolicy() {
        return this.f38863b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f38862a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f38863b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f38868g));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f38868g;
    }

    public boolean isEnableDetailPage() {
        return this.f38866e;
    }

    public boolean isEnableUserControl() {
        return this.f38867f;
    }

    public boolean isNeedCoverImage() {
        return this.f38865d;
    }

    public boolean isNeedProgressBar() {
        return this.f38864c;
    }
}
