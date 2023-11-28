package com.kwad.components.core.request.model;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.k.a.d;
import com.kwad.sdk.k.a.e;
import com.kwad.sdk.k.a.f;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.AbiUtil;
import com.kwad.sdk.utils.av;
import com.kwad.sdk.utils.bb;
import com.kwad.sdk.utils.bi;
import com.kwad.sdk.utils.bu;
import com.kwad.sdk.utils.n;
import com.kwad.sdk.utils.t;
import com.yy.hiidostatis.inner.BaseStatisContent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b implements com.kwad.sdk.core.b {
    public String RA;
    public long RC;
    public String RD;
    public String RE;
    public long RF;
    public String RH;
    public String RI;
    public boolean RJ;
    public List<a> RL;
    public f RM;
    public d RN;
    public com.kwad.sdk.k.a.b RO;
    public List<e> RP;
    public int Rs;
    public String Rt;
    public int Ru;
    public Long Rv;
    public Long Rw;
    public Long Rx;
    public Long Ry;
    public String Rz;
    public List<bu.a> RB = new CopyOnWriteArrayList();
    public int RG = -1;
    public float screenBrightness = -1.0f;
    public int RK = -1;

    @Override // com.kwad.sdk.core.b
    public final void parseJson(@Nullable JSONObject jSONObject) {
    }

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a implements com.kwad.sdk.core.b {
        public int RQ = -1;
        public int RR = -1;
        public int RS = -1;
        public int streamType;

        public static int aC(int i) {
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

        public a(int i) {
            this.streamType = i;
        }

        public static List<a> ag(Context context) {
            AudioManager audioManager;
            ArrayList arrayList = new ArrayList();
            if (context == null) {
                return arrayList;
            }
            if (com.kwad.sdk.core.config.d.T(256L)) {
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
                int aC = aC(i);
                aVar.RS = audioManager.getStreamVolume(aC);
                aVar.RQ = audioManager.getStreamMaxVolume(aC);
                if (Build.VERSION.SDK_INT >= 28) {
                    aVar.RR = audioManager.getStreamMinVolume(aC);
                }
                arrayList.add(aVar);
            }
            return arrayList;
        }
    }

    public static Context getContext() {
        return ServiceProvider.Jn();
    }

    private void af(@NonNull Context context) {
        boolean z;
        if (com.kwad.sdk.core.config.d.T(512L)) {
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        intentFilter.addAction("android.intent.action.BATTERY_CHANGED");
        Intent registerReceiver = context.registerReceiver(null, intentFilter);
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            if (intExtra != 2 && intExtra != 5) {
                z = false;
            } else {
                z = true;
            }
            this.RJ = z;
            int intExtra2 = registerReceiver.getIntExtra("plugged", -1);
            if (intExtra2 == 2) {
                this.RK = 1;
            } else if (intExtra2 == 1) {
                this.RK = 2;
            } else if (intExtra2 == 4) {
                this.RK = 3;
            } else if (intExtra2 == 0) {
                this.RK = 0;
            }
        }
    }

    @WorkerThread
    public static b qm() {
        b bVar = new b();
        bVar.Rs = bi.Lt();
        bVar.Rt = AbiUtil.bD(getContext());
        bVar.Ru = bi.cW(getContext());
        bVar.Rv = Long.valueOf(bi.cX(getContext()));
        bVar.Rw = Long.valueOf(bi.cV(getContext()));
        bVar.Rx = Long.valueOf(bi.Lq());
        bVar.Ry = Long.valueOf(bi.Lr());
        bVar.Rz = av.cA(getContext());
        bVar.RA = av.cB(getContext());
        bVar.RB.addAll(av.n(getContext(), 15));
        bVar.RC = bi.Lx();
        bVar.RF = bi.Ly();
        bVar.RI = bi.Lz();
        bVar.RH = bi.LA();
        bVar.RD = bi.LB();
        bVar.RE = bi.LC();
        Context context = getContext();
        if (context != null) {
            bVar.RG = bi.de(context);
            bVar.RL = new CopyOnWriteArrayList(a.ag(context));
            bVar.af(context);
        }
        bVar.RN = n.JF();
        bVar.RO = av.IV();
        bVar.RP = bb.La().Lb();
        bVar.RM = av.IW();
        return bVar;
    }

    @Override // com.kwad.sdk.core.b
    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        t.putValue(jSONObject, "cpuCount", this.Rs);
        t.putValue(jSONObject, "cpuAbi", this.Rt);
        t.putValue(jSONObject, "batteryPercent", this.Ru);
        t.putValue(jSONObject, "totalMemorySize", this.Rv.longValue());
        t.putValue(jSONObject, "availableMemorySize", this.Rw.longValue());
        t.putValue(jSONObject, "totalDiskSize", this.Rx.longValue());
        t.putValue(jSONObject, "availableDiskSize", this.Ry.longValue());
        t.putValue(jSONObject, BaseStatisContent.IMSI, this.Rz);
        t.putValue(jSONObject, "iccid", this.RA);
        t.putValue(jSONObject, "wifiList", this.RB);
        t.putValue(jSONObject, "bootTime", this.RC);
        t.putValue(jSONObject, "romName", this.RD);
        t.putValue(jSONObject, "romVersion", this.RE);
        t.putValue(jSONObject, "romBuildTimestamp", this.RF);
        t.putValue(jSONObject, "ringerMode", this.RG);
        t.putValue(jSONObject, "audioStreamInfo", this.RL);
        t.putValue(jSONObject, "baseBandVersion", this.RH);
        t.putValue(jSONObject, "fingerPrint", this.RI);
        t.putValue(jSONObject, "screenBrightness", this.screenBrightness);
        t.putValue(jSONObject, "isCharging", this.RJ);
        t.putValue(jSONObject, "chargeType", this.RK);
        f fVar = this.RM;
        if (fVar != null) {
            t.a(jSONObject, "simCardInfo", fVar);
        }
        d dVar = this.RN;
        if (dVar != null) {
            t.a(jSONObject, "environmentInfo", dVar);
        }
        com.kwad.sdk.k.a.b bVar = this.RO;
        if (bVar != null) {
            t.a(jSONObject, "baseStationInfo", bVar);
        }
        List<e> list = this.RP;
        if (list != null) {
            t.putValue(jSONObject, "sensorEventInfoList", list);
        }
        return jSONObject;
    }
}
