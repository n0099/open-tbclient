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
import org.webrtc.MediaStreamTrack;
/* loaded from: classes3.dex */
public class g implements com.kwad.sdk.core.b {
    public int a;

    /* renamed from: b  reason: collision with root package name */
    public String f56164b;

    /* renamed from: c  reason: collision with root package name */
    public int f56165c;

    /* renamed from: d  reason: collision with root package name */
    public Long f56166d;

    /* renamed from: e  reason: collision with root package name */
    public Long f56167e;

    /* renamed from: f  reason: collision with root package name */
    public Long f56168f;

    /* renamed from: g  reason: collision with root package name */
    public Long f56169g;

    /* renamed from: h  reason: collision with root package name */
    public String f56170h;

    /* renamed from: i  reason: collision with root package name */
    public String f56171i;
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
    public List<com.kwad.sdk.core.request.model.a> f56172j = new ArrayList();
    public int o = -1;
    public float r = -1.0f;
    public int t = -1;

    /* loaded from: classes3.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int a;

        /* renamed from: b  reason: collision with root package name */
        public int f56173b = -1;

        /* renamed from: c  reason: collision with root package name */
        public int f56174c = -1;

        /* renamed from: d  reason: collision with root package name */
        public int f56175d = -1;

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
                this.f56175d = audioVolumes[0];
                this.f56173b = audioVolumes[1];
                if (Build.VERSION.SDK_INT >= 28) {
                    this.f56174c = audioVolumes[2];
                }
            }
            return this;
        }

        public a c(Context context) {
            if (context == null) {
                return null;
            }
            int a = a(this.a);
            AudioManager audioManager = (AudioManager) context.getSystemService(MediaStreamTrack.AUDIO_TRACK_KIND);
            this.f56175d = audioManager.getStreamVolume(a);
            this.f56173b = audioManager.getStreamMaxVolume(a);
            if (Build.VERSION.SDK_INT >= 28) {
                this.f56174c = audioManager.getStreamMinVolume(a);
            }
            return this;
        }
    }

    @WorkerThread
    public static g a() {
        g gVar = new g();
        gVar.a = av.c();
        gVar.f56164b = AbiUtil.a();
        gVar.f56165c = av.a(KsAdSDKImpl.get().getContext());
        gVar.f56166d = Long.valueOf(av.b(KsAdSDKImpl.get().getContext()));
        gVar.f56167e = Long.valueOf(av.c(KsAdSDKImpl.get().getContext()));
        gVar.f56168f = Long.valueOf(av.a());
        gVar.f56169g = Long.valueOf(av.b());
        gVar.f56170h = av.h(KsAdSDKImpl.get().getContext());
        gVar.f56171i = av.j(KsAdSDKImpl.get().getContext());
        gVar.f56172j = bg.a(KsAdSDKImpl.get().getContext(), 15);
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
        t.a(jSONObject, "cpuAbi", this.f56164b);
        t.a(jSONObject, "batteryPercent", this.f56165c);
        t.a(jSONObject, "totalMemorySize", this.f56166d.longValue());
        t.a(jSONObject, "availableMemorySize", this.f56167e.longValue());
        t.a(jSONObject, "totalDiskSize", this.f56168f.longValue());
        t.a(jSONObject, "availableDiskSize", this.f56169g.longValue());
        t.a(jSONObject, BaseStatisContent.IMSI, this.f56170h);
        t.a(jSONObject, "iccid", this.f56171i);
        t.a(jSONObject, "wifiList", this.f56172j);
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
