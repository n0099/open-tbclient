package com.kwad.sdk.core.g.a;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import android.os.SystemClock;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.AbiUtil;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ai;
import com.kwad.sdk.utils.as;
import com.kwad.sdk.utils.o;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
import org.webrtc.MediaStreamTrack;
/* loaded from: classes6.dex */
public class h implements com.kwad.sdk.core.b {

    /* renamed from: a  reason: collision with root package name */
    public int f32318a;

    /* renamed from: b  reason: collision with root package name */
    public String f32319b;

    /* renamed from: c  reason: collision with root package name */
    public int f32320c;

    /* renamed from: d  reason: collision with root package name */
    public Long f32321d;

    /* renamed from: e  reason: collision with root package name */
    public Long f32322e;

    /* renamed from: f  reason: collision with root package name */
    public Long f32323f;

    /* renamed from: g  reason: collision with root package name */
    public Long f32324g;

    /* renamed from: h  reason: collision with root package name */
    public String f32325h;

    /* renamed from: i  reason: collision with root package name */
    public String f32326i;
    public List<com.kwad.sdk.core.g.a.a> j = new ArrayList();
    public long k;
    public String l;
    public String m;
    public long n;
    public int o;
    public String p;
    public String q;
    public float r;
    public boolean s;
    public int t;
    public List<a> u;
    public com.kwad.sdk.collector.a.f v;
    public com.kwad.sdk.collector.a.d w;
    public c x;
    public List<com.kwad.sdk.collector.a.e> y;

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {

        /* renamed from: a  reason: collision with root package name */
        public int f32327a;

        /* renamed from: b  reason: collision with root package name */
        public int f32328b;

        /* renamed from: c  reason: collision with root package name */
        public int f32329c;

        /* renamed from: d  reason: collision with root package name */
        public int f32330d;

        public a(int i2) {
            this.f32327a = -1;
            this.f32327a = i2;
        }

        private int a(int i2) {
            if (i2 != 0) {
                if (i2 == 1) {
                    return 1;
                }
                if (i2 == 2) {
                    return 2;
                }
                if (i2 == 3) {
                    return 3;
                }
                if (i2 == 4) {
                    return 4;
                }
                if (i2 == 5) {
                    return 5;
                }
            }
            return 0;
        }

        public static List<a> a(Context context) {
            ArrayList arrayList = new ArrayList();
            if (com.kwad.sdk.core.config.c.a(256L)) {
                return arrayList;
            }
            for (int i2 = 0; i2 <= 5; i2++) {
                a aVar = new a(i2);
                aVar.b(context);
                arrayList.add(aVar);
            }
            return arrayList;
        }

        public a b(Context context) {
            if (context == null) {
                return null;
            }
            int a2 = a(this.f32327a);
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f32330d = audioManager.getStreamVolume(a2);
            this.f32328b = audioManager.getStreamMaxVolume(a2);
            if (Build.VERSION.SDK_INT >= 28) {
                this.f32329c = audioManager.getStreamMinVolume(a2);
            }
            return this;
        }
    }

    @WorkerThread
    public static h a() {
        h hVar = new h();
        hVar.f32318a = ai.c();
        hVar.f32319b = AbiUtil.a();
        hVar.f32320c = ai.a(KsAdSDKImpl.get().getContext());
        hVar.f32321d = Long.valueOf(ai.b(KsAdSDKImpl.get().getContext()));
        hVar.f32322e = Long.valueOf(ai.c(KsAdSDKImpl.get().getContext()));
        hVar.f32323f = Long.valueOf(ai.a());
        hVar.f32324g = Long.valueOf(ai.b());
        hVar.f32325h = ai.g(KsAdSDKImpl.get().getContext());
        hVar.f32326i = ai.h(KsAdSDKImpl.get().getContext());
        hVar.j = as.a(KsAdSDKImpl.get().getContext(), 15);
        hVar.k = SystemClock.elapsedRealtime() / 1000;
        hVar.n = Build.TIME;
        hVar.q = Build.FINGERPRINT;
        hVar.p = Build.getRadioVersion();
        hVar.l = ac.c();
        hVar.m = ac.d();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            hVar.o = ((AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND)).getRingerMode();
            hVar.u = a.a(context);
            hVar.r = SystemUtil.c(context);
            hVar.a(context);
        }
        hVar.w = com.kwad.sdk.collector.a.c.a();
        hVar.x = com.kwad.sdk.collector.h.a();
        hVar.y = com.kwad.sdk.collector.h.b();
        hVar.v = com.kwad.sdk.collector.h.c();
        return hVar;
    }

    private void a(@NonNull Context context) {
        if (com.kwad.sdk.core.config.c.a(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        Intent registerReceiver = context.registerReceiver(null, intentFilter);
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.s = intExtra == 2 || intExtra == 5;
            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra2 == 2) {
                this.t = 1;
            } else if (intExtra2 == 1) {
                this.t = 2;
            } else if (intExtra2 == 4) {
                this.t = 3;
            }
        }
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        o.a(jSONObject, "cpuCount", this.f32318a);
        o.a(jSONObject, "cpuAbi", this.f32319b);
        o.a(jSONObject, "batteryPercent", this.f32320c);
        o.a(jSONObject, "totalMemorySize", this.f32321d.longValue());
        o.a(jSONObject, "availableMemorySize", this.f32322e.longValue());
        o.a(jSONObject, "totalDiskSize", this.f32323f.longValue());
        o.a(jSONObject, "availableDiskSize", this.f32324g.longValue());
        o.a(jSONObject, "imsi", this.f32325h);
        o.a(jSONObject, "iccid", this.f32326i);
        o.a(jSONObject, "wifiList", this.j);
        o.a(jSONObject, "bootTime", this.k);
        o.a(jSONObject, "romName", this.l);
        o.a(jSONObject, "romVersion", this.m);
        o.a(jSONObject, "romBuildTimestamp", this.n);
        o.a(jSONObject, "ringerMode", this.o);
        o.a(jSONObject, "audioStreamInfo", this.u);
        o.a(jSONObject, "baseBandVersion", this.p);
        o.a(jSONObject, "fingerPrint", this.q);
        o.a(jSONObject, "screenBrightness", this.r);
        o.a(jSONObject, "isCharging", this.s);
        o.a(jSONObject, "chargeType", this.t);
        com.kwad.sdk.collector.a.f fVar = this.v;
        if (fVar != null) {
            o.a(jSONObject, "simCardInfo", fVar);
        }
        com.kwad.sdk.collector.a.d dVar = this.w;
        if (dVar != null) {
            o.a(jSONObject, "environmentInfo", dVar);
        }
        c cVar = this.x;
        if (cVar != null) {
            o.a(jSONObject, "baseStationInfo", cVar);
        }
        List<com.kwad.sdk.collector.a.e> list = this.y;
        if (list != null) {
            o.a(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
