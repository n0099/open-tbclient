package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f38960a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38961b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f38962c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f38963d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f38964e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f38965f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f38966g;

    /* loaded from: classes7.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes7.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f38967a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f38968b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38969c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f38970d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38971e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38972f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38973g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f38967a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i2) {
            if (i2 < 0 || i2 > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i2 = 1;
            }
            this.f38968b = i2;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f38973g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f38971e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f38972f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f38970d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f38969c = z;
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
        this.f38960a = builder.f38967a;
        this.f38961b = builder.f38968b;
        this.f38962c = builder.f38969c;
        this.f38963d = builder.f38970d;
        this.f38964e = builder.f38971e;
        this.f38965f = builder.f38972f;
        this.f38966g = builder.f38973g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f38960a;
    }

    public int getAutoPlayPolicy() {
        return this.f38961b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f38960a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f38961b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f38966g));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f38966g;
    }

    public boolean isEnableDetailPage() {
        return this.f38964e;
    }

    public boolean isEnableUserControl() {
        return this.f38965f;
    }

    public boolean isNeedCoverImage() {
        return this.f38963d;
    }

    public boolean isNeedProgressBar() {
        return this.f38962c;
    }
}
