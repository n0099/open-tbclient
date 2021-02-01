package com.qq.e.ads.cfg;

import com.qq.e.comm.util.GDTLogger;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class VideoOption {

    /* renamed from: a  reason: collision with root package name */
    private final boolean f11443a;

    /* renamed from: b  reason: collision with root package name */
    private final int f11444b;
    private final boolean c;
    private final boolean d;
    private final boolean e;
    private final boolean f;
    private final boolean g;

    /* loaded from: classes15.dex */
    public static final class AutoPlayPolicy {
        public static final int ALWAYS = 1;
        public static final int NEVER = 2;
        public static final int WIFI = 0;
    }

    /* loaded from: classes15.dex */
    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        private boolean f11445a = true;

        /* renamed from: b  reason: collision with root package name */
        private int f11446b = 1;
        private boolean c = true;
        private boolean d = true;
        private boolean e = true;
        private boolean f = false;
        private boolean g = false;

        public final VideoOption build() {
            return new VideoOption(this, (byte) 0);
        }

        public final Builder setAutoPlayMuted(boolean z) {
            this.f11445a = z;
            return this;
        }

        public final Builder setAutoPlayPolicy(int i) {
            if (i < 0 || i > 2) {
                GDTLogger.e("invalid value of autoPlayPolicy, can only be [0, 2], reset to : 1");
                i = 1;
            }
            this.f11446b = i;
            return this;
        }

        public final Builder setDetailPageMuted(boolean z) {
            this.g = z;
            return this;
        }

        public final Builder setEnableDetailPage(boolean z) {
            this.e = z;
            return this;
        }

        public final Builder setEnableUserControl(boolean z) {
            this.f = z;
            return this;
        }

        public final Builder setNeedCoverImage(boolean z) {
            this.d = z;
            return this;
        }

        public final Builder setNeedProgressBar(boolean z) {
            this.c = z;
            return this;
        }
    }

    /* loaded from: classes15.dex */
    public static final class VideoADContainerRender {
        public static final int DEV = 2;
        public static final int SDK = 1;
        public static final int UNKNOWN = 0;
    }

    /* loaded from: classes15.dex */
    public static final class VideoPlayPolicy {
        public static final int AUTO = 1;
        public static final int MANUAL = 2;
        public static final int UNKNOWN = 0;
    }

    private VideoOption(Builder builder) {
        this.f11443a = builder.f11445a;
        this.f11444b = builder.f11446b;
        this.c = builder.c;
        this.d = builder.d;
        this.e = builder.e;
        this.f = builder.f;
        this.g = builder.g;
    }

    /* synthetic */ VideoOption(Builder builder, byte b2) {
        this(builder);
    }

    public boolean getAutoPlayMuted() {
        return this.f11443a;
    }

    public int getAutoPlayPolicy() {
        return this.f11444b;
    }

    public JSONObject getOptions() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("autoPlayMuted", Boolean.valueOf(this.f11443a));
            jSONObject.putOpt("autoPlayPolicy", Integer.valueOf(this.f11444b));
            jSONObject.putOpt("detailPageMuted", Boolean.valueOf(this.g));
        } catch (Exception e) {
            GDTLogger.e("Get video options error: " + e.getMessage());
        }
        return jSONObject;
    }

    public boolean isDetailPageMuted() {
        return this.g;
    }

    public boolean isEnableDetailPage() {
        return this.e;
    }

    public boolean isEnableUserControl() {
        return this.f;
    }

    public boolean isNeedCoverImage() {
        return this.d;
    }

    public boolean isNeedProgressBar() {
        return this.c;
    }
}
