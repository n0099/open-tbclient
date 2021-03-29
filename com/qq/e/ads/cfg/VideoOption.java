package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f38057a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38058b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f38059c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f38060d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f38061e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f38062f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f38063g;

    /* loaded from: classes6.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f38064a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f38065b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38066c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f38067d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38068e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38069f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38070g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f38064a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i = 1;
            }
            this.f38065b = i;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f38070g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f38068e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f38069f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f38067d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f38066c = z;
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
        this.f38057a = builder.f38064a;
        this.f38058b = builder.f38065b;
        this.f38059c = builder.f38066c;
        this.f38060d = builder.f38067d;
        this.f38061e = builder.f38068e;
        this.f38062f = builder.f38069f;
        this.f38063g = builder.f38070g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f38057a;
    }

    public int getAutoPlayPolicy() {
        return this.f38058b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f38057a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f38058b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f38063g));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f38063g;
    }

    public boolean isEnableDetailPage() {
        return this.f38061e;
    }

    public boolean isEnableUserControl() {
        return this.f38062f;
    }

    public boolean isNeedCoverImage() {
        return this.f38060d;
    }

    public boolean isNeedProgressBar() {
        return this.f38059c;
    }
}
