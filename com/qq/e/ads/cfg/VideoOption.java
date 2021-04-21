package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f38441a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38442b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f38443c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f38444d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f38445e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f38446f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f38447g;

    /* loaded from: classes6.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f38448a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f38449b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38450c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f38451d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38452e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38453f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38454g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f38448a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i = 1;
            }
            this.f38449b = i;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f38454g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f38452e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f38453f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f38451d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f38450c = z;
            return this;
        }
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public static final class VideoADContainerRender {
        public static final int DEV = 2;
        public static final int SDK = 1;
        public static final int UNKNOWN = 0;
    }

    @Deprecated
    /* loaded from: classes6.dex */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    public VideoOption(Builder builder) {
        this.f38441a = builder.f38448a;
        this.f38442b = builder.f38449b;
        this.f38443c = builder.f38450c;
        this.f38444d = builder.f38451d;
        this.f38445e = builder.f38452e;
        this.f38446f = builder.f38453f;
        this.f38447g = builder.f38454g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f38441a;
    }

    public int getAutoPlayPolicy() {
        return this.f38442b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f38441a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f38442b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f38447g));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f38447g;
    }

    public boolean isEnableDetailPage() {
        return this.f38445e;
    }

    public boolean isEnableUserControl() {
        return this.f38446f;
    }

    public boolean isNeedCoverImage() {
        return this.f38444d;
    }

    public boolean isNeedProgressBar() {
        return this.f38443c;
    }
}
