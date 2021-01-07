package com.tencent.map.geoloclite.tsa;

import android.content.Context;
import android.os.Looper;
import b.a.a.a.a.p;
import b.a.a.a.a.w;
import b.a.a.a.a.x;
/* loaded from: classes4.dex */
public final class TencentLiteLocationManager {
    public static final int COORDINATE_TYPE_WGS84 = 0;
    public static final int ERROR_BAD_JSON = 2;
    public static final int ERROR_NETWORK = 1;
    public static final int ERROR_OK = 0;
    public static final int ERROR_UNKNOWN = 404;
    private static TencentLiteLocationManager d;

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f13650a = new byte[0];

    /* renamed from: b  reason: collision with root package name */
    private final w f13651b;
    private final p c;

    private TencentLiteLocationManager(Context context) {
        this.f13651b = w.G(context);
        this.c = new p(this.f13651b);
    }

    public static TencentLiteLocationManager getInstance(Context context) throws NullPointerException, IllegalArgumentException {
        TencentLiteLocationManager tencentLiteLocationManager;
        synchronized (TencentLiteLocationManager.class) {
            try {
                if (d == null) {
                    if (context == null || context.getApplicationContext() == null) {
                        throw new NullPointerException("context is null");
                    }
                    d = new TencentLiteLocationManager(context.getApplicationContext());
                }
                tencentLiteLocationManager = d;
            } finally {
            }
        }
        return tencentLiteLocationManager;
    }

    public final String getVersion() {
        return x.b() + "." + x.c();
    }

    public final void removeUpdates(TencentLiteLocationListener tencentLiteLocationListener) {
        synchronized (this.f13650a) {
            p pVar = this.c;
            pVar.a();
            synchronized (pVar.f1071b) {
                pVar.Aw = null;
            }
            pVar.b();
        }
    }

    public final int requestLocationUpdates(long j, TencentLiteLocationListener tencentLiteLocationListener) {
        return requestLocationUpdates(j, tencentLiteLocationListener, Looper.myLooper());
    }

    public final int requestLocationUpdates(long j, TencentLiteLocationListener tencentLiteLocationListener, Looper looper) {
        int a2;
        if (tencentLiteLocationListener == null || looper == null) {
            throw new NullPointerException("listener or looper is null");
        }
        if (j < 0) {
            j = 0;
        }
        synchronized (this.f13650a) {
            a2 = this.c.a(j, tencentLiteLocationListener, looper);
        }
        return a2;
    }
}
