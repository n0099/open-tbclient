package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f38346a;

    /* renamed from: b  reason: collision with root package name */
    public final int f38347b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f38348c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f38349d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f38350e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f38351f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f38352g;

    /* loaded from: classes6.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes6.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public boolean f38353a = true;

        /* renamed from: b  reason: collision with root package name */
        public int f38354b = 1;

        /* renamed from: c  reason: collision with root package name */
        public boolean f38355c = true;

        /* renamed from: d  reason: collision with root package name */
        public boolean f38356d = true;

        /* renamed from: e  reason: collision with root package name */
        public boolean f38357e = true;

        /* renamed from: f  reason: collision with root package name */
        public boolean f38358f = false;

        /* renamed from: g  reason: collision with root package name */
        public boolean f38359g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f38353a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i = 1;
            }
            this.f38354b = i;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.f38359g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.f38357e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f38358f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.f38356d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.f38355c = z;
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
        this.f38346a = builder.f38353a;
        this.f38347b = builder.f38354b;
        this.f38348c = builder.f38355c;
        this.f38349d = builder.f38356d;
        this.f38350e = builder.f38357e;
        this.f38351f = builder.f38358f;
        this.f38352g = builder.f38359g;
    }

    public /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f38346a;
    }

    public int getAutoPlayPolicy() {
        return this.f38347b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f38346a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f38347b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.f38352g));
        } catch (Exception e2) {
            GDTLogger.e("Get video options error: " + e2.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.f38352g;
    }

    public boolean isEnableDetailPage() {
        return this.f38350e;
    }

    public boolean isEnableUserControl() {
        return this.f38351f;
    }

    public boolean isNeedCoverImage() {
        return this.f38349d;
    }

    public boolean isNeedProgressBar() {
        return this.f38348c;
    }
}
