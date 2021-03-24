package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f38056a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38057b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f38058c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f38059d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f38060e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f38061f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f38062g;

    /* loaded from: classes6.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f38063a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f38064b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38065c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f38066d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38067e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38068f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38069g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f38063a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i = 1;
            }
            this.f38064b = i;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f38069g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f38067e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f38068f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f38066d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f38065c = z;
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
        this.f38056a = builder.f38063a;
        this.f38057b = builder.f38064b;
        this.f38058c = builder.f38065c;
        this.f38059d = builder.f38066d;
        this.f38060e = builder.f38067e;
        this.f38061f = builder.f38068f;
        this.f38062g = builder.f38069g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f38056a;
    }

    public int getAutoPlayPolicy() {
        return this.f38057b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f38056a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f38057b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f38062g));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f38062g;
    }

    public boolean isEnableDetailPage() {
        return this.f38060e;
    }

    public boolean isEnableUserControl() {
        return this.f38061f;
    }

    public boolean isNeedCoverImage() {
        return this.f38059d;
    }

    public boolean isNeedProgressBar() {
        return this.f38058c;
    }
}
