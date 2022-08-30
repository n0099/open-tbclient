package com.kwad.sdk.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellLocation;
import android.telephony.CellSignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public final class at {
    public static Context WF;
    public static Map<String, i> aoc = new HashMap();

    /* loaded from: classes7.dex */
    public static class a extends i<com.kwad.sdk.f.kwai.b> {
        public static com.kwad.sdk.f.kwai.b aod;

        public a(boolean z) {
            super(z);
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        public static int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                return ((CellSignalStrength) q.a((Object) cellInfo, "getCellSignalStrength", new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.i
        /* renamed from: dd */
        public com.kwad.sdk.f.kwai.b ca(Context context) {
            int i;
            int i2;
            if (aq.zT() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class)).i(64L)) {
                return aod;
            }
            com.kwad.sdk.f.kwai.b bVar = aod;
            if (bVar != null) {
                return bVar;
            }
            CellInfo cellInfo = null;
            if (context == null || aq.zT()) {
                return null;
            }
            int i3 = -1;
            if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, com.kuaishou.weapon.p0.h.g) != -1) {
                if (az.checkSelfPermission(context, com.kuaishou.weapon.p0.h.g) == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i2 = cdmaCellLocation.getBaseStationId();
                        i = cdmaCellLocation.getNetworkId();
                    } else if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        i2 = gsmCellLocation.getCid();
                        i = gsmCellLocation.getLac();
                    } else {
                        i = -1;
                        i2 = -1;
                    }
                    if (Build.VERSION.SDK_INT >= 17) {
                        Iterator<CellInfo> it = telephonyManager.getAllCellInfo().iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            CellInfo next = it.next();
                            if (next != null && next.isRegistered()) {
                                cellInfo = next;
                                break;
                            }
                        }
                        if (cellInfo != null) {
                            i3 = a(cellInfo);
                        }
                    }
                    aod = new com.kwad.sdk.f.kwai.b(i2, i, i3);
                }
                return aod;
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends i<List<com.kwad.sdk.f.kwai.e>> implements SensorEventListener {
        public d aoe;
        public d aof;
        public d aog;
        public boolean aoh;

        public b(Context context, boolean z) {
            super(z);
            this.aoh = false;
            if (z && 0 == 0) {
                de(context);
            }
        }

        private List<com.kwad.sdk.f.kwai.e> Ap() {
            ArrayList arrayList = new ArrayList();
            d dVar = this.aoe;
            if (dVar != null) {
                arrayList.add(com.kwad.sdk.f.kwai.e.a(dVar.Aq(), this.aoe.getTimestamp()));
            }
            d dVar2 = this.aof;
            if (dVar2 != null) {
                arrayList.add(com.kwad.sdk.f.kwai.e.a(dVar2.Aq(), this.aof.getTimestamp()));
            }
            d dVar3 = this.aog;
            if (dVar3 != null) {
                arrayList.add(com.kwad.sdk.f.kwai.e.a(dVar3.Aq(), this.aog.getTimestamp()));
            }
            return arrayList;
        }

        public static boolean a(SensorManager sensorManager, int i, SensorEventListener sensorEventListener) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(i);
            if (defaultSensor == null) {
                return false;
            }
            return sensorManager.registerListener(sensorEventListener, defaultSensor, 3);
        }

        private void de(Context context) {
            SensorManager sensorManager;
            try {
                sensorManager = (SensorManager) context.getSystemService("sensor");
            } catch (Exception unused) {
                sensorManager = null;
            }
            if (sensorManager == null) {
                return;
            }
            boolean a = a(sensorManager, 1, this);
            com.kwad.sdk.core.e.b.d("SensitiveInfoCollectors", "accelerometerSensorAvailable: " + a);
            boolean a2 = a(sensorManager, 4, this);
            com.kwad.sdk.core.e.b.d("SensitiveInfoCollectors", "gyroscopeSensorAvailable : " + a2);
            boolean a3 = a(sensorManager, 9, this);
            com.kwad.sdk.core.e.b.d("SensitiveInfoCollectors", "gravitySensorAvailable : " + a3);
        }

        @WorkerThread
        private synchronized List<com.kwad.sdk.f.kwai.e> df(Context context) {
            final ArrayList arrayList;
            arrayList = new ArrayList();
            final SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            final CountDownLatch countDownLatch = new CountDownLatch(3);
            if (!a(sensorManager, 1, new c() { // from class: com.kwad.sdk.utils.at.b.1
                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.e.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.f.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            if (!a(sensorManager, 4, new c() { // from class: com.kwad.sdk.utils.at.b.2
                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.e.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.f.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            if (!a(sensorManager, 9, new c() { // from class: com.kwad.sdk.utils.at.b.3
                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.e.b.d("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.f.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            try {
                countDownLatch.await(2L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
            }
            return arrayList;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX INFO: Access modifiers changed from: private */
        @Override // com.kwad.sdk.utils.i
        @Nullable
        @WorkerThread
        /* renamed from: dg */
        public List<com.kwad.sdk.f.kwai.e> ca(Context context) {
            if (context == null) {
                return null;
            }
            System.currentTimeMillis();
            return this.aoh ? df(context) : Ap();
        }

        @Override // android.hardware.SensorEventListener
        public final void onAccuracyChanged(Sensor sensor, int i) {
        }

        @Override // android.hardware.SensorEventListener
        public final void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null) {
                return;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                this.aoe = new d(sensorEvent);
            } else if (type == 4) {
                this.aof = new d(sensorEvent);
            } else if (type != 9) {
            } else {
                this.aog = new d(sensorEvent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class c implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public SensorEvent aol;
        public long timestamp = System.currentTimeMillis();

        public d(SensorEvent sensorEvent) {
            this.aol = sensorEvent;
        }

        public final SensorEvent Aq() {
            return this.aol;
        }

        public final long getTimestamp() {
            return this.timestamp;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends i<com.kwad.sdk.f.kwai.f> {
        public e(boolean z) {
            super(z);
        }

        @Nullable
        public static com.kwad.sdk.f.kwai.f dh(Context context) {
            com.kwad.sdk.f.kwai.f fVar = new com.kwad.sdk.f.kwai.f();
            fVar.amF = ar.cR(context);
            fVar.amE = ar.cP(context);
            return fVar;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.kwad.sdk.utils.i
        @Nullable
        public final /* synthetic */ com.kwad.sdk.f.kwai.f ca(Context context) {
            return dh(context);
        }
    }

    @Nullable
    @WorkerThread
    public static List<com.kwad.sdk.f.kwai.e> Aj() {
        if (Ao()) {
            return (List) dR("sensorEventEnable");
        }
        return null;
    }

    public static boolean Ao() {
        return WF != null;
    }

    @Nullable
    public static <T> T dR(String str) {
        i iVar = aoc.get(str);
        if (iVar != null) {
            return (T) iVar.bZ(WF);
        }
        return null;
    }

    public static void init(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.get(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            com.kwad.sdk.core.e.b.d("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        boolean ly = fVar.ly();
        com.kwad.sdk.core.e.b.d("SensitiveInfoCollectors", "sensorEnable2: " + ly);
        if (Ao()) {
            if (aoc.containsKey("baseStationEnable")) {
                boolean lz = fVar.lz();
                i iVar = aoc.get("baseStationEnable");
                if (iVar != null) {
                    iVar.aD(lz);
                }
            }
            if (aoc.containsKey("sensorEventEnable")) {
                boolean ly2 = fVar.ly();
                i iVar2 = aoc.get("sensorEventEnable");
                if (iVar2 != null) {
                    iVar2.aD(ly2);
                }
            }
            if (aoc.containsKey("simCardInfoEnable")) {
                boolean lx = fVar.lx();
                i iVar3 = aoc.get("simCardInfoEnable");
                if (iVar3 != null) {
                    iVar3.aD(lx);
                }
            }
        } else {
            WF = context.getApplicationContext();
            aoc.put("baseStationEnable", new a(fVar.lz()));
            aoc.put("sensorEventEnable", new b(WF, fVar.ly()));
            aoc.put("simCardInfoEnable", new e(fVar.lx()));
            m.cf(context);
        }
        for (i iVar4 : aoc.values()) {
            com.kwad.sdk.core.e.b.d("SensitiveInfoCollectors", "collector: " + iVar4.Dv + StringUtil.ARRAY_ELEMENT_SEPARATOR + iVar4.getClass().getSimpleName());
        }
    }

    @Nullable
    public static com.kwad.sdk.f.kwai.b yS() {
        if (Ao()) {
            return (com.kwad.sdk.f.kwai.b) dR("baseStationEnable");
        }
        return null;
    }

    @Nullable
    public static com.kwad.sdk.f.kwai.f yT() {
        if (Ao()) {
            return (com.kwad.sdk.f.kwai.f) dR("simCardInfoEnable");
        }
        return null;
    }
}
