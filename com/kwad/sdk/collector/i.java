package com.kwad.sdk.collector;

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
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.WorkerThread;
import androidx.core.content.ContextCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.kuaishou.weapon.un.s;
import com.kwad.sdk.utils.ao;
import com.kwad.sdk.utils.av;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes7.dex */
public class i {
    public static Context a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, com.kwad.sdk.collector.e> f54057b = new HashMap();

    /* loaded from: classes7.dex */
    public static class a extends com.kwad.sdk.collector.e<com.kwad.sdk.core.request.model.c> {

        /* renamed from: c  reason: collision with root package name */
        public static com.kwad.sdk.core.request.model.c f54058c;

        public a(boolean z) {
            super(z);
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        private int a(CellInfo cellInfo) {
            if (cellInfo == null) {
                return -1;
            }
            try {
                Method declaredMethod = cellInfo.getClass().getDeclaredMethod("getCellSignalStrength", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((CellSignalStrength) declaredMethod.invoke(cellInfo, new Object[0])).getLevel();
            } catch (Throwable unused) {
                return -1;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.collector.e
        /* renamed from: c */
        public com.kwad.sdk.core.request.model.c b(Context context) {
            int i2;
            int i3;
            if (ao.a() || com.kwad.sdk.core.config.b.a(64L)) {
                return f54058c;
            }
            com.kwad.sdk.core.request.model.c cVar = f54058c;
            if (cVar != null) {
                return cVar;
            }
            CellInfo cellInfo = null;
            if (context == null || ao.a()) {
                return null;
            }
            int i4 = -1;
            if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, s.f53808g) != -1) {
                if (av.a(context, s.f53808g) == 0) {
                    TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                    CellLocation cellLocation = telephonyManager.getCellLocation();
                    if (cellLocation instanceof CdmaCellLocation) {
                        CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                        i3 = cdmaCellLocation.getBaseStationId();
                        i2 = cdmaCellLocation.getNetworkId();
                    } else if (cellLocation instanceof GsmCellLocation) {
                        GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
                        i3 = gsmCellLocation.getCid();
                        i2 = gsmCellLocation.getLac();
                    } else {
                        i2 = -1;
                        i3 = -1;
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
                            i4 = a(cellInfo);
                        }
                    }
                    f54058c = new com.kwad.sdk.core.request.model.c(i3, i2, i4);
                }
                return f54058c;
            }
            return null;
        }
    }

    /* loaded from: classes7.dex */
    public static class b extends com.kwad.sdk.collector.e<List<com.kwad.sdk.collector.kwai.e>> implements SensorEventListener {

        /* renamed from: c  reason: collision with root package name */
        public d f54059c;

        /* renamed from: d  reason: collision with root package name */
        public d f54060d;

        /* renamed from: e  reason: collision with root package name */
        public d f54061e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f54062f;

        public b(Context context, boolean z) {
            super(z);
            this.f54062f = false;
            if (z && 0 == 0) {
                d(context);
            }
        }

        private List<com.kwad.sdk.collector.kwai.e> a() {
            ArrayList arrayList = new ArrayList();
            d dVar = this.f54059c;
            if (dVar != null) {
                arrayList.add(com.kwad.sdk.collector.kwai.e.a(dVar.a(), this.f54059c.b()));
            }
            d dVar2 = this.f54060d;
            if (dVar2 != null) {
                arrayList.add(com.kwad.sdk.collector.kwai.e.a(dVar2.a(), this.f54060d.b()));
            }
            d dVar3 = this.f54061e;
            if (dVar3 != null) {
                arrayList.add(com.kwad.sdk.collector.kwai.e.a(dVar3.a(), this.f54061e.b()));
            }
            return arrayList;
        }

        private boolean a(SensorManager sensorManager, int i2, SensorEventListener sensorEventListener) {
            Sensor defaultSensor = sensorManager.getDefaultSensor(i2);
            if (defaultSensor == null) {
                return false;
            }
            return sensorManager.registerListener(sensorEventListener, defaultSensor, 3);
        }

        private void d(Context context) {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            boolean a = a(sensorManager, 1, this);
            com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "accelerometerSensorAvailable: " + a);
            boolean a2 = a(sensorManager, 4, this);
            com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "gyroscopeSensorAvailable : " + a2);
            boolean a3 = a(sensorManager, 9, this);
            com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "gravitySensorAvailable : " + a3);
        }

        @WorkerThread
        private synchronized List<com.kwad.sdk.collector.kwai.e> e(Context context) {
            final ArrayList arrayList;
            arrayList = new ArrayList();
            final SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            final CountDownLatch countDownLatch = new CountDownLatch(3);
            if (!a(sensorManager, 1, new c() { // from class: com.kwad.sdk.collector.i.b.1
                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.collector.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            if (!a(sensorManager, 4, new c() { // from class: com.kwad.sdk.collector.i.b.2
                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.collector.kwai.e.a(sensorEvent, System.currentTimeMillis()));
                    countDownLatch.countDown();
                    sensorManager.unregisterListener(this);
                }
            })) {
                countDownLatch.countDown();
            }
            if (!a(sensorManager, 9, new c() { // from class: com.kwad.sdk.collector.i.b.3
                @Override // android.hardware.SensorEventListener
                public void onSensorChanged(SensorEvent sensorEvent) {
                    com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                    arrayList.add(com.kwad.sdk.collector.kwai.e.a(sensorEvent, System.currentTimeMillis()));
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
        @Override // com.kwad.sdk.collector.e
        @Nullable
        @WorkerThread
        /* renamed from: c */
        public List<com.kwad.sdk.collector.kwai.e> b(Context context) {
            if (context == null) {
                return null;
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (this.f54062f) {
                return e(context);
            }
            List<com.kwad.sdk.collector.kwai.e> a = a();
            long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
            com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "getSensorInfoOnceAynsc time: " + currentTimeMillis2);
            return a;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            if (sensorEvent == null) {
                return;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                this.f54059c = new d(sensorEvent);
            } else if (type == 4) {
                this.f54060d = new d(sensorEvent);
            } else if (type != 9) {
            } else {
                this.f54061e = new d(sensorEvent);
            }
        }
    }

    /* loaded from: classes7.dex */
    public static abstract class c implements SensorEventListener {
        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
        }
    }

    /* loaded from: classes7.dex */
    public static class d {
        public SensorEvent a;

        /* renamed from: b  reason: collision with root package name */
        public long f54072b = System.currentTimeMillis();

        public d(SensorEvent sensorEvent) {
            this.a = sensorEvent;
        }

        public SensorEvent a() {
            return this.a;
        }

        public long b() {
            return this.f54072b;
        }
    }

    /* loaded from: classes7.dex */
    public static class e extends com.kwad.sdk.collector.e<com.kwad.sdk.collector.kwai.f> {
        public e(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.collector.e
        @Nullable
        @SuppressLint({"MissingPermission"})
        /* renamed from: c */
        public com.kwad.sdk.collector.kwai.f b(Context context) {
            if (av.a(context, s.f53804c) != 0) {
                return null;
            }
            com.kwad.sdk.collector.kwai.f fVar = new com.kwad.sdk.collector.kwai.f();
            if (Build.VERSION.SDK_INT >= 22) {
                fVar.f54092b = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
            }
            fVar.a = av.a(context, (TelephonyManager) null);
            return fVar;
        }
    }

    @Nullable
    public static com.kwad.sdk.core.request.model.c a() {
        if (d()) {
            return (com.kwad.sdk.core.request.model.c) a("baseStationEnable");
        }
        return null;
    }

    @Nullable
    public static <T> T a(String str) {
        com.kwad.sdk.collector.e eVar = f54057b.get(str);
        if (eVar != null) {
            return (T) eVar.a(a);
        }
        return null;
    }

    public static void a(Context context) {
        if (context == null) {
            return;
        }
        boolean O = com.kwad.sdk.core.config.b.O();
        com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "sensorEnable2: " + O);
        if (d()) {
            if (f54057b.containsKey("baseStationEnable")) {
                boolean W = com.kwad.sdk.core.config.b.W();
                com.kwad.sdk.collector.e eVar = f54057b.get("baseStationEnable");
                if (eVar != null) {
                    eVar.a(W);
                }
            }
            if (f54057b.containsKey("sensorEventEnable")) {
                boolean O2 = com.kwad.sdk.core.config.b.O();
                com.kwad.sdk.collector.e eVar2 = f54057b.get("sensorEventEnable");
                if (eVar2 != null) {
                    eVar2.a(O2);
                }
            }
            if (f54057b.containsKey("simCardInfoEnable")) {
                boolean N = com.kwad.sdk.core.config.b.N();
                com.kwad.sdk.collector.e eVar3 = f54057b.get("simCardInfoEnable");
                if (eVar3 != null) {
                    eVar3.a(N);
                }
            }
        } else {
            a = context.getApplicationContext();
            f54057b.put("baseStationEnable", new a(com.kwad.sdk.core.config.b.W()));
            f54057b.put("sensorEventEnable", new b(a, com.kwad.sdk.core.config.b.O()));
            f54057b.put("simCardInfoEnable", new e(com.kwad.sdk.core.config.b.N()));
            com.kwad.sdk.collector.kwai.c.a(context);
        }
        for (com.kwad.sdk.collector.e eVar4 : f54057b.values()) {
            com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "collector: " + eVar4.a + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar4.getClass().getSimpleName());
        }
    }

    @Nullable
    @WorkerThread
    public static List<com.kwad.sdk.collector.kwai.e> b() {
        if (d()) {
            return (List) a("sensorEventEnable");
        }
        return null;
    }

    @Nullable
    public static com.kwad.sdk.collector.kwai.f c() {
        if (d()) {
            return (com.kwad.sdk.collector.kwai.f) a("simCardInfoEnable");
        }
        return null;
    }

    public static boolean d() {
        return a != null;
    }
}
