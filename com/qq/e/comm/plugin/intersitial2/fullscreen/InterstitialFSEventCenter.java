package com.qq.e.comm.plugin.intersitial2.fullscreen;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.qq.e.comm.util.GDTLogger;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class InterstitialFSEventCenter {

    /* renamed from: a  reason: collision with root package name */
    private static volatile InterstitialFSEventCenter f12417a;

    /* renamed from: b  reason: collision with root package name */
    private Map<String, a> f12418b = new HashMap();
    private Handler c = new Handler(Looper.getMainLooper());

    @Retention(RetentionPolicy.SOURCE)
    /* loaded from: classes4.dex */
    public @interface InterstitialFSEvent {
        public static final int ON_AD_CLICKED = 10003;
        public static final int ON_AD_CLOSED = 10004;
        public static final int ON_AD_EXPOSURE = 10002;
        public static final int ON_AD_OPEN = 10001;
        public static final int ON_VIDEO_CACHED = 10005;
        public static final int ON_VIDEO_COMPLETE = 10011;
        public static final int ON_VIDEO_ERROR = 10012;
        public static final int ON_VIDEO_INIT = 10006;
        public static final int ON_VIDEO_LOADING = 10007;
        public static final int ON_VIDEO_PAUSE = 10010;
        public static final int ON_VIDEO_READY = 10008;
        public static final int ON_VIDEO_START = 10009;
    }

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, int i, Object obj);
    }

    private InterstitialFSEventCenter() {
    }

    public static InterstitialFSEventCenter a() {
        if (f12417a == null) {
            synchronized (InterstitialFSEventCenter.class) {
                try {
                    if (f12417a == null) {
                        f12417a = new InterstitialFSEventCenter();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f12417a;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f12418b.remove(str);
    }

    public void a(final String str, final int i, final Object obj) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.c.post(new Runnable() { // from class: com.qq.e.comm.plugin.intersitial2.fullscreen.InterstitialFSEventCenter.1
            @Override // java.lang.Runnable
            public void run() {
                a aVar = (a) InterstitialFSEventCenter.this.f12418b.get(str);
                if (aVar != null) {
                    aVar.a(str, i, obj);
                }
            }
        });
    }

    public void a(String str, a aVar) {
        if (TextUtils.isEmpty(str) || aVar == null) {
            GDTLogger.d("registerListener id null or listener null");
        } else {
            this.f12418b.put(str, aVar);
        }
    }
}
