package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f35183a;

    /* renamed from: b  reason: collision with root package name */
    public final int f35184b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f35185c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f35186d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f35187e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f35188f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f35189g;

    /* loaded from: classes7.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f35190a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f35191b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f35192c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f35193d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f35194e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f35195f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f35196g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f35190a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i2 = 1;
            }
            this.f35191b = i2;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f35196g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f35194e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f35195f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f35193d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f35192c = z;
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
        this.f35183a = builder.f35190a;
        this.f35184b = builder.f35191b;
        this.f35185c = builder.f35192c;
        this.f35186d = builder.f35193d;
        this.f35187e = builder.f35194e;
        this.f35188f = builder.f35195f;
        this.f35189g = builder.f35196g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f35183a;
    }

    public int getAutoPlayPolicy() {
        return this.f35184b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f35183a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f35184b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f35189g));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f35189g;
    }

    public boolean isEnableDetailPage() {
        return this.f35187e;
    }

    public boolean isEnableUserControl() {
        return this.f35188f;
    }

    public boolean isNeedCoverImage() {
        return this.f35186d;
    }

    public boolean isNeedProgressBar() {
        return this.f35185c;
    }
}
