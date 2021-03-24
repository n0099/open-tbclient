package com.bytedance.sdk.openadsdk.j;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import com.baidu.searchbox.live.interfaces.DI;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class c {

    /* renamed from: a  reason: collision with root package name */
    public Context f29520a;

    /* renamed from: b  reason: collision with root package name */
    public WeakReference<e> f29521b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, a> f29522c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f29523d = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.j.c.1
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            e d2;
            if (sensorEvent.sensor.getType() != 1 || (d2 = c.this.d()) == null) {
                return;
            }
            float[] fArr = sensorEvent.values;
            float f2 = fArr[0];
            float f3 = fArr[1];
            float f4 = fArr[2];
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", Math.round(f2));
                jSONObject.put("y", Math.round(f3));
                jSONObject.put("z", Math.round(f4));
                d2.a("accelerometer_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    public SensorEventListener f29524e = new SensorEventListener() { // from class: com.bytedance.sdk.openadsdk.j.c.10
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            e d2;
            if (sensorEvent.sensor.getType() != 4 || (d2 = c.this.d()) == null) {
                return;
            }
            float degrees = (float) Math.toDegrees(sensorEvent.values[0]);
            float degrees2 = (float) Math.toDegrees(sensorEvent.values[1]);
            float degrees3 = (float) Math.toDegrees(sensorEvent.values[2]);
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("x", Math.round(degrees));
                jSONObject.put("y", Math.round(degrees2));
                jSONObject.put("z", Math.round(degrees3));
                d2.a("gyro_callback", jSONObject);
            } catch (Throwable unused) {
            }
        }
    };

    /* loaded from: classes6.dex */
    public interface a {
        JSONObject a(JSONObject jSONObject) throws Throwable;
    }

    public c(e eVar) {
        this.f29520a = eVar.a();
        this.f29521b = new WeakReference<>(eVar);
        c();
    }

    private void c() {
        this.f29522c.put("adInfo", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.11
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) {
                e d2 = c.this.d();
                if (d2 != null) {
                    return d2.n();
                }
                return null;
            }
        });
        this.f29522c.put(DI.APP_INFO_NAME, new a() { // from class: com.bytedance.sdk.openadsdk.j.c.12
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("appName", "playable_sdk");
                jSONObject2.put("playableSdkEdition", "1.0.0.0");
                JSONArray jSONArray = new JSONArray();
                for (String str : c.this.a()) {
                    jSONArray.put(str);
                }
                jSONObject2.put("supportList", jSONArray);
                e d2 = c.this.d();
                if (d2 != null) {
                    jSONObject2.put("deviceId", d2.g());
                    jSONObject2.put("netType", d2.k());
                    jSONObject2.put("innerAppName", d2.d());
                    jSONObject2.put("appName", d2.e());
                    jSONObject2.put("appVersion", d2.f());
                    Map<String, String> b2 = d2.b();
                    for (String str2 : b2.keySet()) {
                        jSONObject2.put(str2, b2.get(str2));
                    }
                }
                return jSONObject2;
            }
        });
        this.f29522c.put("subscribe_app_ad", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.13
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.j.a e2 = c.this.e();
                if (e2 == null) {
                    return null;
                }
                e2.a(jSONObject);
                return null;
            }
        });
        this.f29522c.put("download_app_ad", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.14
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) {
                com.bytedance.sdk.openadsdk.j.a e2 = c.this.e();
                if (e2 == null) {
                    return null;
                }
                e2.b(jSONObject);
                return null;
            }
        });
        this.f29522c.put("isViewable", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.15
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d2 = c.this.d();
                if (d2 == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("viewStatus", d2.i());
                return jSONObject2;
            }
        });
        this.f29522c.put("getVolume", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.16
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d2 = c.this.d();
                if (d2 == null) {
                    return new JSONObject();
                }
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("endcard_mute", d2.h());
                return jSONObject2;
            }
        });
        this.f29522c.put("getScreenSize", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.17
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d2 = c.this.d();
                if (d2 == null) {
                    return new JSONObject();
                }
                return d2.m();
            }
        });
        this.f29522c.put("start_accelerometer_observer", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.2
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        d.a("PlayableJsBridge", "invoke start_accelerometer_observer error", th);
                        jSONObject2.put("code", -2);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                g.a(c.this.f29520a, c.this.f29523d, i);
                jSONObject2.put("code", 0);
                return jSONObject2;
            }
        });
        this.f29522c.put("close_accelerometer_observer", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.3
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    g.a(c.this.f29520a, c.this.f29523d);
                    jSONObject2.put("code", 0);
                    return jSONObject2;
                } catch (Throwable th) {
                    d.a("PlayableJsBridge", "invoke close_accelerometer_observer error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.f29522c.put("start_gyro_observer", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.4
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                int i = 2;
                if (jSONObject != null) {
                    try {
                        i = jSONObject.optInt("interval_android", 2);
                    } catch (Throwable th) {
                        d.a("PlayableJsBridge", "invoke start_gyro_observer error", th);
                        jSONObject2.put("code", -2);
                        jSONObject2.put("codeMsg", th.toString());
                        return jSONObject2;
                    }
                }
                g.b(c.this.f29520a, c.this.f29524e, i);
                jSONObject2.put("code", 0);
                return jSONObject2;
            }
        });
        this.f29522c.put("close_gyro_observer", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.5
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    g.a(c.this.f29520a, c.this.f29524e);
                    jSONObject2.put("code", 0);
                    return jSONObject2;
                } catch (Throwable th) {
                    d.a("PlayableJsBridge", "invoke close_gyro_observer error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.f29522c.put("device_shake", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.6
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                JSONObject jSONObject2 = new JSONObject();
                try {
                    g.a(c.this.f29520a);
                    jSONObject2.put("code", 0);
                    return jSONObject2;
                } catch (Throwable th) {
                    d.a("PlayableJsBridge", "invoke device_shake error", th);
                    jSONObject2.put("code", -2);
                    jSONObject2.put("codeMsg", th.toString());
                    return jSONObject2;
                }
            }
        });
        this.f29522c.put("playable_style", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.7
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d2 = c.this.d();
                if (d2 != null) {
                    return d2.c();
                }
                return null;
            }
        });
        this.f29522c.put("sendReward", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.8
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                e d2 = c.this.d();
                if (d2 != null) {
                    d2.o();
                    return null;
                }
                return null;
            }
        });
        this.f29522c.put("webview_time_track", new a() { // from class: com.bytedance.sdk.openadsdk.j.c.9
            @Override // com.bytedance.sdk.openadsdk.j.c.a
            public JSONObject a(JSONObject jSONObject) throws Throwable {
                com.bytedance.sdk.openadsdk.j.a e2 = c.this.e();
                if (e2 != null) {
                    e2.c(jSONObject);
                    return null;
                }
                return null;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public e d() {
        WeakReference<e> weakReference = this.f29521b;
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public com.bytedance.sdk.openadsdk.j.a e() {
        e d2 = d();
        if (d2 == null) {
            return null;
        }
        return d2.l();
    }

    public Set<String> a() {
        return this.f29522c.keySet();
    }

    public void b() {
        g.a(this.f29520a, this.f29523d);
        g.a(this.f29520a, this.f29524e);
    }

    public JSONObject a(String str, JSONObject jSONObject) {
        try {
            a aVar = this.f29522c.get(str);
            if (aVar == null) {
                return null;
            }
            return aVar.a(jSONObject);
        } catch (Throwable th) {
            d.a("PlayableJsBridge", "invoke error", th);
            return null;
        }
    }
}
