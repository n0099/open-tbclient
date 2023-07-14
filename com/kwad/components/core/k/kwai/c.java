package com.kwad.components.core.k.kwai;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.f.kwai.e;
import com.kwad.sdk.f.kwai.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.ar;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.m;
import com.kwad.sdk.utils.r;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class c implements com.kwad.sdk.core.b {
    public int HV;
    public String HW;
    public int HX;
    public Long HY;
    public Long HZ;
    public Long Ia;
    public Long Ib;
    public String Ic;
    public String Id;
    public long If;
    public String Ig;
    public String Ih;
    public long Ii;
    public String Ik;
    public String Il;
    public boolean Im;
    public List<a> Io;
    public f Ip;
    public com.kwad.sdk.f.kwai.d Iq;
    public com.kwad.sdk.f.kwai.b Ir;
    public List<e> Is;
    public List<bi.a> Ie = new ArrayList();
    public int Ij = -1;
    public float screenBrightness = -1.0f;
    public int In = -1;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.kwai.a implements com.kwad.sdk.core.b {
        public int It = -1;
        public int Iu = -1;
        public int Iv = -1;
        public int streamType;

        public a(int i) {
            this.streamType = i;
        }

        public static int ap(int i) {
            if (i != 0) {
                if (i == 1) {
                    return 1;
                }
                if (i == 2) {
                    return 2;
                }
                if (i == 3) {
                    return 3;
                }
                if (i == 4) {
                    return 4;
                }
                if (i == 5) {
                    return 5;
                }
            }
            return 0;
        }

        public static List<a> as(Context context) {
            AudioManager audioManager;
            ArrayList arrayList = new ArrayList();
            if (context == null || com.kwad.sdk.core.config.d.i(256L)) {
                return arrayList;
            }
            try {
                audioManager = (AudioManager) context.getSystemService("audio");
            } catch (Exception unused) {
            }
            if (audioManager == null) {
                return arrayList;
            }
            for (int i = 0; i <= 5; i++) {
                a aVar = new a(i);
                int ap = ap(i);
                aVar.Iv = audioManager.getStreamVolume(ap);
                aVar.It = audioManager.getStreamMaxVolume(ap);
                if (Build.VERSION.SDK_INT >= 28) {
                    aVar.Iu = audioManager.getStreamMinVolume(ap);
                }
                arrayList.add(aVar);
            }
            return arrayList;
        }
    }

    private void ar(@NonNull Context context) {
        if (com.kwad.sdk.core.config.d.i(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        Intent registerReceiver = context.registerReceiver(null, intentFilter);
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.Im = intExtra == 2 || intExtra == 5;
            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra2 == 2) {
                this.In = 1;
            } else if (intExtra2 == 1) {
                this.In = 2;
            } else if (intExtra2 == 4) {
                this.In = 3;
            } else if (intExtra2 == 0) {
                this.In = 0;
            }
        }
    }

    public static Context getContext() {
        return ((com.kwad.sdk.service.kwai.d) ServiceProvider.get(com.kwad.sdk.service.kwai.d.class)).getContext();
    }

    @WorkerThread
    public static c oq() {
        c cVar = new c();
        cVar.HV = az.AD();
        cVar.HW = AbiUtil.bO(getContext());
        cVar.HX = az.dm(getContext());
        cVar.HY = Long.valueOf(az.dn(getContext()));
        cVar.HZ = Long.valueOf(az.dl(getContext()));
        cVar.Ia = Long.valueOf(az.AB());
        cVar.Ib = Long.valueOf(az.AC());
        cVar.Ic = ar.cN(getContext());
        cVar.Id = ar.cO(getContext());
        cVar.Ie = ar.h(getContext(), 15);
        cVar.If = az.AH();
        cVar.Ii = az.AI();
        cVar.Il = az.AJ();
        cVar.Ik = az.AK();
        cVar.Ig = az.AL();
        cVar.Ih = az.AM();
        Context context = getContext();
        if (context != null) {
            cVar.Ij = az.du(context);
            cVar.Io = a.as(context);
            cVar.ar(context);
        }
        cVar.Iq = m.zk();
        cVar.Ir = ar.yS();
        cVar.Is = ar.Aj();
        cVar.Ip = ar.yT();
        return cVar;
    }

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        r.putValue(jSONObject, "cpuCount", this.HV);
        r.putValue(jSONObject, "cpuAbi", this.HW);
        r.putValue(jSONObject, "batteryPercent", this.HX);
        r.putValue(jSONObject, "totalMemorySize", this.HY.longValue());
        r.putValue(jSONObject, "availableMemorySize", this.HZ.longValue());
        r.putValue(jSONObject, "totalDiskSize", this.Ia.longValue());
        r.putValue(jSONObject, "availableDiskSize", this.Ib.longValue());
        r.putValue(jSONObject, BaseStatisContent.IMSI, this.Ic);
        r.putValue(jSONObject, "iccid", this.Id);
        r.putValue(jSONObject, "wifiList", this.Ie);
        r.putValue(jSONObject, "bootTime", this.If);
        r.putValue(jSONObject, "romName", this.Ig);
        r.putValue(jSONObject, "romVersion", this.Ih);
        r.putValue(jSONObject, "romBuildTimestamp", this.Ii);
        r.putValue(jSONObject, "ringerMode", this.Ij);
        r.putValue(jSONObject, "audioStreamInfo", this.Io);
        r.putValue(jSONObject, "baseBandVersion", this.Ik);
        r.putValue(jSONObject, "fingerPrint", this.Il);
        r.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        r.putValue(jSONObject, "isCharging", this.Im);
        r.putValue(jSONObject, "chargeType", this.In);
        f fVar = this.Ip;
        if (fVar != null) {
            r.a(jSONObject, "simCardInfo", fVar);
        }
        com.kwad.sdk.f.kwai.d dVar = this.Iq;
        if (dVar != null) {
            r.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.f.kwai.b bVar = this.Ir;
        if (bVar != null) {
            r.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.Is;
        if (list != null) {
            r.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
