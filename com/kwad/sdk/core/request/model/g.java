package com.kwad.sdk.core.request.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.kuaishou.weapon.adsdk.DeviceInfo;
import com.kwad.sdk.KsAdSDKImpl;
import com.kwad.sdk.crash.utils.SystemUtil;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bg;
import com.kwad.sdk.utils.t;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class g implements com.kwad.sdk.core.b {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f54726b;

    /* renamed from: c  reason: collision with root package name */
    public int f54727c;

    /* renamed from: d  reason: collision with root package name */
    public Long f54728d;

    /* renamed from: e  reason: collision with root package name */
    public Long f54729e;

    /* renamed from: f  reason: collision with root package name */
    public Long f54730f;

    /* renamed from: g  reason: collision with root package name */
    public Long f54731g;

    /* renamed from: h  reason: collision with root package name */
    public String f54732h;

    /* renamed from: i  reason: collision with root package name */
    public String f54733i;
    public long k;
    public String l;
    public String m;
    public long n;
    public String p;
    public String q;
    public boolean s;
    public List<a> u;
    public com.kwad.sdk.collector.kwai.f v;
    public com.kwad.sdk.collector.kwai.d w;
    public c x;
    public List<com.kwad.sdk.collector.kwai.e> y;

    /* renamed from: j  reason: collision with root package name */
    public List<com.kwad.sdk.core.request.model.a> f54734j = new ArrayList();
    public int o = -1;
    public float r = -1.0f;
    public int t = -1;

    /* loaded from: classes8.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f54735b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f54736c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f54737d = -1;

        public a(int i2) {
            this.a = -1;
            this.a = i2;
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
            if (com.kwad.sdk.core.config.b.a(256L)) {
                return arrayList;
            }
            for (int i2 = 0; i2 <= 5; i2++) {
                a aVar = new a(i2);
                if (com.kwad.sdk.b.a.booleanValue()) {
                    aVar.b(context);
                } else {
                    aVar.c(context);
                }
                arrayList.add(aVar);
            }
            return arrayList;
        }

        public a b(Context context) {
            if (context == null) {
                return null;
            }
            int[] audioVolumes = DeviceInfo.getAudioVolumes(context, a(this.a));
            if (audioVolumes != null && audioVolumes.length == 3) {
                this.f54737d = audioVolumes[0];
                this.f54735b = audioVolumes[1];
                if (Build.VERSION.SDK_INT >= 28) {
                    this.f54736c = audioVolumes[2];
                }
            }
            return this;
        }

        public a c(Context context) {
            if (context == null) {
                return null;
            }
            int a = a(this.a);
            AudioManager audioManager = (AudioManager) context.getSystemService("audio");
            this.f54737d = audioManager.getStreamVolume(a);
            this.f54735b = audioManager.getStreamMaxVolume(a);
            if (Build.VERSION.SDK_INT >= 28) {
                this.f54736c = audioManager.getStreamMinVolume(a);
            }
            return this;
        }
    }

    @WorkerThread
    public static g a() {
        g gVar = new g();
        gVar.a = av.c();
        gVar.f54726b = AbiUtil.a();
        gVar.f54727c = av.a(KsAdSDKImpl.get().getContext());
        gVar.f54728d = Long.valueOf(av.b(KsAdSDKImpl.get().getContext()));
        gVar.f54729e = Long.valueOf(av.c(KsAdSDKImpl.get().getContext()));
        gVar.f54730f = Long.valueOf(av.a());
        gVar.f54731g = Long.valueOf(av.b());
        gVar.f54732h = av.h(KsAdSDKImpl.get().getContext());
        gVar.f54733i = av.j(KsAdSDKImpl.get().getContext());
        gVar.f54734j = bg.a(KsAdSDKImpl.get().getContext(), 15);
        gVar.k = av.h();
        gVar.n = av.i();
        gVar.q = av.j();
        gVar.p = av.k();
        gVar.l = av.l();
        gVar.m = av.m();
        Context context = KsAdSDKImpl.get().getContext();
        if (context != null) {
            gVar.o = av.m(context);
            gVar.u = a.a(context);
            gVar.r = SystemUtil.d(context);
            gVar.a(context);
        }
        gVar.w = com.kwad.sdk.collector.kwai.c.a();
        gVar.x = av.l(context);
        gVar.y = com.kwad.sdk.collector.i.b();
        gVar.v = av.k(context);
        return gVar;
    }

    private void a(@NonNull Context context) {
        int i2;
        if (com.kwad.sdk.core.config.b.a(512L)) {
            return;
        }
        if (com.kwad.sdk.b.a.booleanValue()) {
            this.s = DeviceInfo.isCharging(context);
            i2 = DeviceInfo.getChargeType(context);
        } else {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
            Intent registerReceiver = context.registerReceiver(null, intentFilter);
            if (registerReceiver == null) {
                return;
            }
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.s = intExtra == 2 || intExtra == 5;
            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra2 == 2) {
                this.t = 1;
                return;
            } else if (intExtra2 == 1) {
                this.t = 2;
                return;
            } else if (intExtra2 != 4) {
                if (intExtra2 == 0) {
                    this.t = 0;
                    return;
                }
                return;
            } else {
                i2 = 3;
            }
        }
        this.t = i2;
    }

    @Override // com.kwad.sdk.core.b
    public void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.a(jSONObject, "cpuCount", this.a);
        t.a(jSONObject, "cpuAbi", this.f54726b);
        t.a(jSONObject, "batteryPercent", this.f54727c);
        t.a(jSONObject, "totalMemorySize", this.f54728d.longValue());
        t.a(jSONObject, "availableMemorySize", this.f54729e.longValue());
        t.a(jSONObject, "totalDiskSize", this.f54730f.longValue());
        t.a(jSONObject, "availableDiskSize", this.f54731g.longValue());
        t.a(jSONObject, BaseStatisContent.IMSI, this.f54732h);
        t.a(jSONObject, "iccid", this.f54733i);
        t.a(jSONObject, "wifiList", this.f54734j);
        t.a(jSONObject, "bootTime", this.k);
        t.a(jSONObject, "romName", this.l);
        t.a(jSONObject, "romVersion", this.m);
        t.a(jSONObject, "romBuildTimestamp", this.n);
        t.a(jSONObject, "ringerMode", this.o);
        t.a(jSONObject, "audioStreamInfo", this.u);
        t.a(jSONObject, "baseBandVersion", this.p);
        t.a(jSONObject, "fingerPrint", this.q);
        t.a(jSONObject, "screenBrightness", this.r);
        t.a(jSONObject, "isCharging", this.s);
        t.a(jSONObject, "chargeType", this.t);
        com.kwad.sdk.collector.kwai.f fVar = this.v;
        if (fVar != null) {
            t.a(jSONObject, "simCardInfo", fVar);
        }
        com.kwad.sdk.collector.kwai.d dVar = this.w;
        if (dVar != null) {
            t.a(jSONObject, "environmentInfo", dVar);
        }
        c cVar = this.x;
        if (cVar != null) {
            t.a(jSONObject, "baseStationInfo", cVar);
        }
        List<com.kwad.sdk.collector.kwai.e> list = this.y;
        if (list != null) {
            t.a(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
