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
import com.baidu.sofire.utility.PermissionChecker;
import com.kwad.sdk.service.ServiceProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes5.dex */
public final class aq {
    public static Context a;
    public static Map<String, i> b = new HashMap();

    /* loaded from: classes5.dex */
    public static class a extends i<com.kwad.sdk.g.kwai.b> {
        public static com.kwad.sdk.g.kwai.b c;

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
        /* renamed from: c */
        public com.kwad.sdk.g.kwai.b b(Context context) {
            int i;
            int i2;
            if (an.a() || ((com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class)).a(64L)) {
                return c;
            }
            com.kwad.sdk.g.kwai.b bVar = c;
            if (bVar != null) {
                return bVar;
            }
            CellInfo cellInfo = null;
            if (context == null || an.a()) {
                return null;
            }
            int i3 = -1;
            if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, PermissionChecker.ACCESS_FINE_LOCATION) != -1) {
                if (av.a(context, PermissionChecker.ACCESS_FINE_LOCATION) == 0) {
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
                    c = new com.kwad.sdk.g.kwai.b(i2, i, i3);
                }
                return c;
            }
            return null;
        }
    }

    /* loaded from: classes5.dex */
    public static class b extends i<List<com.kwad.sdk.g.kwai.e>> implements SensorEventListener {
        public d c;
        public d d;
        public d e;
        public boolean f;

        public b(Context context, boolean z) {
            super(z);
            this.f = false;
            if (z && 0 == 0) {
                c(context);
            }
        }

        private List<com.kwad.sdk.g.kwai.e> a() {
            ArrayList arrayList = new ArrayList();
            d dVar = this.c;
            if (dVar != null) {
                arrayList.add(com.kwad.sdk.g.kwai.e.a(dVar.a(), this.c.b()));
            }
            d dVar2 = this.d;
            if (dVar2 != null) {
                arrayList.add(com.kwad.sdk.g.kwai.e.a(dVar2.a(), this.d.b()));
            }
            d dVar3 = this.e;
            if (dVar3 != null) {
                arrayList.add(com.kwad.sdk.g.kwai.e.a(dVar3.a(), this.e.b()));
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

        private void c(Context context) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            boolean a = a(sensorManager, 1, this);
            com.kwad.sdk.core.d.b.a("SensitiveInfoCollectors", "accelerometerSensorAvailable: " + a);
            boolean a2 = a(sensorManager, 4, this);
            com.kwad.sdk.core.d.b.a("SensitiveInfoCollectors", "gyroscopeSensorAvailable : " + a2);
            boolean a3 = a(sensorManager, 9, this);
            com.kwad.sdk.core.d.b.a("SensitiveInfoCollectors", "gravitySensorAvailable : " + a3);
        }

        @WorkerThread
        private synchronized List<com.kwad.sdk.g.kwai.e> d(Context context) {
            final ArrayList arrayList;
            arrayList = new ArrayList();
            final SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            final CountDownLatch countDownLatch = new CountDownLatch(3);
            if (!a(sensorManager, 1, new c() { // from class: com.kwad.sdk.utils.aq.b.1
                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.b.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.g.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            if (!a(sensorManager, 4, new c() { // from class: com.kwad.sdk.utils.aq.b.2
                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.b.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.g.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            if (!a(sensorManager, 9, new c() { // from class: com.kwad.sdk.utils.aq.b.3
                @Override // android.hardware.SensorEventListener
                public final void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.b.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.g.kwai.e.a(sensorEvent, System.currentTimeMillis()));
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
        /* renamed from: e */
        public List<com.kwad.sdk.g.kwai.e> b(Context context) {
            if (context == null) {
                return null;
            }
            System.currentTimeMillis();
            return this.f ? d(context) : a();
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
                this.c = new d(sensorEvent);
            } else if (type == 4) {
                this.d = new d(sensorEvent);
            } else if (type != 9) {
            } else {
                this.e = new d(sensorEvent);
            }
        }
    }

    /* loaded from: classes5.dex */
    public static abstract class c implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    }

    /* loaded from: classes5.dex */
    public static class d {
        public SensorEvent a;
        public long b = System.currentTimeMillis();

        public d(SensorEvent sensorEvent) {
            this.a = sensorEvent;
        }

        public final SensorEvent a() {
            return this.a;
        }

        public final long b() {
            return this.b;
        }
    }

    /* loaded from: classes5.dex */
    public static class e extends i<com.kwad.sdk.g.kwai.f> {
        public e(boolean z) {
            super(z);
        }

        @Nullable
        public static com.kwad.sdk.g.kwai.f c(Context context) {
            com.kwad.sdk.g.kwai.f fVar = new com.kwad.sdk.g.kwai.f();
            fVar.b = ao.j(context);
            fVar.a = ao.i(context);
            return fVar;
        }

        /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
        @Override // com.kwad.sdk.utils.i
        @Nullable
        public final /* synthetic */ com.kwad.sdk.g.kwai.f b(Context context) {
            return c(context);
        }
    }

    @Nullable
    public static com.kwad.sdk.g.kwai.b a() {
        if (d()) {
            return (com.kwad.sdk.g.kwai.b) a("baseStationEnable");
        }
        return null;
    }

    @Nullable
    public static <T> T a(String str) {
        i iVar = b.get(str);
        if (iVar != null) {
            return (T) iVar.a(a);
        }
        return null;
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        com.kwad.sdk.service.kwai.f fVar = (com.kwad.sdk.service.kwai.f) ServiceProvider.a(com.kwad.sdk.service.kwai.f.class);
        if (fVar == null) {
            com.kwad.sdk.core.d.b.a("SensitiveInfoCollectors", "init sdkConfigProvider is null");
            return;
        }
        boolean b2 = fVar.b();
        com.kwad.sdk.core.d.b.a("SensitiveInfoCollectors", "sensorEnable2: " + b2);
        if (d()) {
            if (b.containsKey("baseStationEnable")) {
                boolean c2 = fVar.c();
                i iVar = b.get("baseStationEnable");
                if (iVar != null) {
                    iVar.a(c2);
                }
            }
            if (b.containsKey("sensorEventEnable")) {
                boolean b3 = fVar.b();
                i iVar2 = b.get("sensorEventEnable");
                if (iVar2 != null) {
                    iVar2.a(b3);
                }
            }
            if (b.containsKey("simCardInfoEnable")) {
                boolean a2 = fVar.a();
                i iVar3 = b.get("simCardInfoEnable");
                if (iVar3 != null) {
                    iVar3.a(a2);
                }
            }
        } else {
            a = context.getApplicationContext();
            b.put("baseStationEnable", new a(fVar.c()));
            b.put("sensorEventEnable", new b(a, fVar.b()));
            b.put("simCardInfoEnable", new e(fVar.a()));
            m.a(context);
        }
        for (i iVar4 : b.values()) {
            com.kwad.sdk.core.d.b.a("SensitiveInfoCollectors", "collector: " + iVar4.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + iVar4.getClass().getSimpleName());
        }
    }

    @Nullable
    @WorkerThread
    public static List<com.kwad.sdk.g.kwai.e> b() {
        if (d()) {
            return (List) a("sensorEventEnable");
        }
        return null;
    }

    @Nullable
    public static com.kwad.sdk.g.kwai.f c() {
        if (d()) {
            return (com.kwad.sdk.g.kwai.f) a("simCardInfoEnable");
        }
        return null;
    }

    public static boolean d() {
        return a != null;
    }
}
