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
import com.baidu.android.common.others.lang.StringUtil;
import com.kwad.sdk.utils.ai;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    public static Context f31968a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, com.kwad.sdk.collector.c> f31969b = new HashMap();

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.collector.c<com.kwad.sdk.core.g.a.c> {
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
        @Override // com.kwad.sdk.collector.c
        @SuppressLint({"MissingPermission"})
        /* renamed from: c */
        public com.kwad.sdk.core.g.a.c b(Context context) {
            int i2;
            int i3;
            CellInfo cellInfo = null;
            if (context == null) {
                return null;
            }
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            CellLocation cellLocation = telephonyManager.getCellLocation();
            int i4 = -1;
            if (cellLocation instanceof CdmaCellLocation) {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) telephonyManager.getCellLocation();
                i3 = cdmaCellLocation.getBaseStationId();
                i2 = cdmaCellLocation.getNetworkId();
            } else if (cellLocation instanceof GsmCellLocation) {
                GsmCellLocation gsmCellLocation = (GsmCellLocation) telephonyManager.getCellLocation();
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
            return new com.kwad.sdk.core.g.a.c(i3, i2, i4);
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends com.kwad.sdk.collector.c<List<com.kwad.sdk.collector.a.e>> {
        public b(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.collector.c
        @WorkerThread
        /* renamed from: c */
        public List<com.kwad.sdk.collector.a.e> b(Context context) {
            if (context == null) {
                return null;
            }
            final ArrayList arrayList = new ArrayList();
            final SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            final CountDownLatch countDownLatch = new CountDownLatch(3);
            Sensor defaultSensor = sensorManager.getDefaultSensor(1);
            if (defaultSensor != null) {
                sensorManager.registerListener(new SensorEventListener() { // from class: com.kwad.sdk.collector.h.b.1
                    @Override // android.hardware.SensorEventListener
                    public void onAccuracyChanged(Sensor sensor, int i2) {
                    }

                    @Override // android.hardware.SensorEventListener
                    public void onSensorChanged(SensorEvent sensorEvent) {
                        com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged TYPE_ACCELEROMETER");
                        arrayList.add(com.kwad.sdk.collector.a.e.a(sensorEvent));
                        countDownLatch.countDown();
                        sensorManager.unregisterListener(this);
                    }
                }, defaultSensor, 1);
            }
            Sensor defaultSensor2 = sensorManager.getDefaultSensor(4);
            if (defaultSensor2 != null) {
                sensorManager.registerListener(new SensorEventListener() { // from class: com.kwad.sdk.collector.h.b.2
                    @Override // android.hardware.SensorEventListener
                    public void onAccuracyChanged(Sensor sensor, int i2) {
                    }

                    @Override // android.hardware.SensorEventListener
                    public void onSensorChanged(SensorEvent sensorEvent) {
                        com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged TYPE_GYROSCOPE");
                        arrayList.add(com.kwad.sdk.collector.a.e.a(sensorEvent));
                        countDownLatch.countDown();
                        sensorManager.unregisterListener(this);
                    }
                }, defaultSensor2, 1);
            }
            Sensor defaultSensor3 = sensorManager.getDefaultSensor(9);
            if (defaultSensor3 != null) {
                sensorManager.registerListener(new SensorEventListener() { // from class: com.kwad.sdk.collector.h.b.3
                    @Override // android.hardware.SensorEventListener
                    public void onAccuracyChanged(Sensor sensor, int i2) {
                    }

                    @Override // android.hardware.SensorEventListener
                    public void onSensorChanged(SensorEvent sensorEvent) {
                        com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged TYPE_GRAVITY");
                        arrayList.add(com.kwad.sdk.collector.a.e.a(sensorEvent));
                        countDownLatch.countDown();
                        sensorManager.unregisterListener(this);
                    }
                }, defaultSensor3, 1);
            }
            try {
                countDownLatch.await(10L, TimeUnit.SECONDS);
            } catch (InterruptedException unused) {
            }
            return arrayList;
        }
    }

    /* loaded from: classes6.dex */
    public static class c extends com.kwad.sdk.collector.c<com.kwad.sdk.collector.a.f> {
        public c(boolean z) {
            super(z);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.collector.c
        @SuppressLint({"MissingPermission"})
        /* renamed from: c */
        public com.kwad.sdk.collector.a.f b(Context context) {
            if (ai.a(context, "android.permission.READ_PHONE_STATE") != 0) {
                return null;
            }
            com.kwad.sdk.collector.a.f fVar = new com.kwad.sdk.collector.a.f();
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (Build.VERSION.SDK_INT >= 22) {
                fVar.f31949b = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
            }
            if (Build.VERSION.SDK_INT >= 23) {
                fVar.f31948a = telephonyManager.getPhoneCount();
            }
            return fVar;
        }
    }

    @Nullable
    public static com.kwad.sdk.core.g.a.c a() {
        if (d()) {
            return (com.kwad.sdk.core.g.a.c) a("baseStationEnable");
        }
        return null;
    }

    public static <T> T a(String str) {
        com.kwad.sdk.collector.c cVar = f31969b.get(str);
        if (cVar != null) {
            return (T) cVar.a(f31968a);
        }
        return null;
    }

    public static void a(Context context) {
        if (context == null || d()) {
            return;
        }
        f31968a = context.getApplicationContext();
        f31969b.put("baseStationEnable", new a(com.kwad.sdk.core.config.c.O()));
        f31969b.put("sensorEventEnable", new b(com.kwad.sdk.core.config.c.H()));
        f31969b.put("simCardInfoEnable", new c(com.kwad.sdk.core.config.c.G()));
        for (com.kwad.sdk.collector.c cVar : f31969b.values()) {
            com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "collector: " + cVar.f31954a + StringUtil.ARRAY_ELEMENT_SEPARATOR + cVar.getClass().getSimpleName());
        }
        com.kwad.sdk.collector.a.c.a(context);
    }

    @Nullable
    @WorkerThread
    public static List<com.kwad.sdk.collector.a.e> b() {
        if (d()) {
            return (List) a("sensorEventEnable");
        }
        return null;
    }

    @Nullable
    public static com.kwad.sdk.collector.a.f c() {
        if (d()) {
            return (com.kwad.sdk.collector.a.f) a("simCardInfoEnable");
        }
        return null;
    }

    public static boolean d() {
        return f31968a != null;
    }
}
