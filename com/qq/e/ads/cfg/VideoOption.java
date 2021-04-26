package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f36009a;

    /* renamed from: b  reason: collision with root package name */
    public final int f36010b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f36011c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f36012d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f36013e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f36014f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f36015g;

    /* loaded from: classes6.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f36016a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f36017b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f36018c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f36019d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f36020e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f36021f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f36022g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f36016a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i2 = 1;
            }
            this.f36017b = i2;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f36022g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f36020e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f36021f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f36019d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f36018c = z;
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
        this.f36009a = builder.f36016a;
        this.f36010b = builder.f36017b;
        this.f36011c = builder.f36018c;
        this.f36012d = builder.f36019d;
        this.f36013e = builder.f36020e;
        this.f36014f = builder.f36021f;
        this.f36015g = builder.f36022g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f36009a;
    }

    public int getAutoPlayPolicy() {
        return this.f36010b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f36009a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f36010b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f36015g));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f36015g;
    }

    public boolean isEnableDetailPage() {
        return this.f36013e;
    }

    public boolean isEnableUserControl() {
        return this.f36014f;
    }

    public boolean isNeedCoverImage() {
        return this.f36012d;
    }

    public boolean isNeedProgressBar() {
        return this.f36011c;
    }
}
