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
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.kwad.sdk.utils.ap;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f64170a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, com.kwad.sdk.collector.e> f64171b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes2.dex */
    public static class a extends com.kwad.sdk.collector.e<com.kwad.sdk.core.g.a.c> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static com.kwad.sdk.core.g.a.c f64172c;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(boolean z) {
            super(z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        @RequiresApi(api = 17)
        @SuppressLint({"BlockedPrivateApi"})
        private int a(CellInfo cellInfo) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, this, cellInfo)) == null) {
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
            return invokeL.intValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.collector.e
        /* renamed from: c */
        public com.kwad.sdk.core.g.a.c b(Context context) {
            InterceptResult invokeL;
            int i2;
            int i3;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                com.kwad.sdk.core.g.a.c cVar = f64172c;
                if (cVar != null) {
                    return cVar;
                }
                CellInfo cellInfo = null;
                if (context == null) {
                    return null;
                }
                int i4 = -1;
                if (Build.VERSION.SDK_INT < 23 || ContextCompat.checkSelfPermission(context, "android.permission.ACCESS_FINE_LOCATION") != -1) {
                    if (ap.a(context, "android.permission.ACCESS_FINE_LOCATION") == 0) {
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
                        f64172c = new com.kwad.sdk.core.g.a.c(i3, i2, i4);
                    }
                    return f64172c;
                }
                return null;
            }
            return (com.kwad.sdk.core.g.a.c) invokeL.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class b extends com.kwad.sdk.collector.e<List<com.kwad.sdk.collector.a.e>> implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public d f64173c;

        /* renamed from: d  reason: collision with root package name */
        public d f64174d;

        /* renamed from: e  reason: collision with root package name */
        public d f64175e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f64176f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context, boolean z) {
            super(z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {context, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64176f = false;
            if (z && 0 == 0) {
                d(context);
            }
        }

        private List<com.kwad.sdk.collector.a.e> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                ArrayList arrayList = new ArrayList();
                d dVar = this.f64173c;
                if (dVar != null) {
                    arrayList.add(com.kwad.sdk.collector.a.e.a(dVar.a(), this.f64173c.b()));
                }
                d dVar2 = this.f64174d;
                if (dVar2 != null) {
                    arrayList.add(com.kwad.sdk.collector.a.e.a(dVar2.a(), this.f64174d.b()));
                }
                d dVar3 = this.f64175e;
                if (dVar3 != null) {
                    arrayList.add(com.kwad.sdk.collector.a.e.a(dVar3.a(), this.f64175e.b()));
                }
                return arrayList;
            }
            return (List) invokeV.objValue;
        }

        private boolean a(SensorManager sensorManager, int i2, SensorEventListener sensorEventListener) {
            InterceptResult invokeLIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65538, this, sensorManager, i2, sensorEventListener)) == null) {
                Sensor defaultSensor = sensorManager.getDefaultSensor(i2);
                if (defaultSensor == null) {
                    return false;
                }
                return sensorManager.registerListener(sensorEventListener, defaultSensor, 3);
            }
            return invokeLIL.booleanValue;
        }

        private void d(Context context) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(65539, this, context) == null) {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                boolean a2 = a(sensorManager, 1, this);
                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "accelerometerSensorAvailable: " + a2);
                boolean a3 = a(sensorManager, 4, this);
                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "gyroscopeSensorAvailable : " + a3);
                boolean a4 = a(sensorManager, 9, this);
                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "gravitySensorAvailable : " + a4);
            }
        }

        @WorkerThread
        private synchronized List<com.kwad.sdk.collector.a.e> e(Context context) {
            InterceptResult invokeL;
            ArrayList arrayList;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, this, context)) == null) {
                synchronized (this) {
                    arrayList = new ArrayList();
                    SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                    CountDownLatch countDownLatch = new CountDownLatch(3);
                    if (!a(sensorManager, 1, new c(this, arrayList, countDownLatch, sensorManager) { // from class: com.kwad.sdk.collector.i.b.1
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f64177a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ CountDownLatch f64178b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ SensorManager f64179c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ b f64180d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList, countDownLatch, sensorManager};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64180d = this;
                            this.f64177a = arrayList;
                            this.f64178b = countDownLatch;
                            this.f64179c = sensorManager;
                        }

                        @Override // android.hardware.SensorEventListener
                        public void onSensorChanged(SensorEvent sensorEvent) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, sensorEvent) == null) {
                                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                                this.f64177a.add(com.kwad.sdk.collector.a.e.a(sensorEvent, System.currentTimeMillis()));
                                this.f64178b.countDown();
                                this.f64179c.unregisterListener(this);
                            }
                        }
                    })) {
                        countDownLatch.countDown();
                    }
                    if (!a(sensorManager, 4, new c(this, arrayList, countDownLatch, sensorManager) { // from class: com.kwad.sdk.collector.i.b.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f64181a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ CountDownLatch f64182b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ SensorManager f64183c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ b f64184d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList, countDownLatch, sensorManager};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64184d = this;
                            this.f64181a = arrayList;
                            this.f64182b = countDownLatch;
                            this.f64183c = sensorManager;
                        }

                        @Override // android.hardware.SensorEventListener
                        public void onSensorChanged(SensorEvent sensorEvent) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, sensorEvent) == null) {
                                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                                this.f64181a.add(com.kwad.sdk.collector.a.e.a(sensorEvent, System.currentTimeMillis()));
                                this.f64182b.countDown();
                                this.f64183c.unregisterListener(this);
                            }
                        }
                    })) {
                        countDownLatch.countDown();
                    }
                    if (!a(sensorManager, 9, new c(this, arrayList, countDownLatch, sensorManager) { // from class: com.kwad.sdk.collector.i.b.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f64185a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ CountDownLatch f64186b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ SensorManager f64187c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ b f64188d;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, arrayList, countDownLatch, sensorManager};
                                interceptable2.invokeUnInit(65536, newInitContext);
                                int i2 = newInitContext.flag;
                                if ((i2 & 1) != 0) {
                                    int i3 = i2 & 2;
                                    newInitContext.thisArg = this;
                                    interceptable2.invokeInitBody(65536, newInitContext);
                                    return;
                                }
                            }
                            this.f64188d = this;
                            this.f64185a = arrayList;
                            this.f64186b = countDownLatch;
                            this.f64187c = sensorManager;
                        }

                        @Override // android.hardware.SensorEventListener
                        public void onSensorChanged(SensorEvent sensorEvent) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, sensorEvent) == null) {
                                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                                this.f64185a.add(com.kwad.sdk.collector.a.e.a(sensorEvent, System.currentTimeMillis()));
                                this.f64186b.countDown();
                                this.f64187c.unregisterListener(this);
                            }
                        }
                    })) {
                        countDownLatch.countDown();
                    }
                    try {
                        countDownLatch.await(2L, TimeUnit.SECONDS);
                    } catch (InterruptedException unused) {
                    }
                }
                return arrayList;
            }
            return (List) invokeL.objValue;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.collector.e
        @Nullable
        @WorkerThread
        /* renamed from: c */
        public List<com.kwad.sdk.collector.a.e> b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                if (context == null) {
                    return null;
                }
                long currentTimeMillis = System.currentTimeMillis();
                if (this.f64176f) {
                    return e(context);
                }
                List<com.kwad.sdk.collector.a.e> a2 = a();
                long currentTimeMillis2 = System.currentTimeMillis() - currentTimeMillis;
                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "getSensorInfoOnceAynsc time: " + currentTimeMillis2);
                return a2;
            }
            return (List) invokeL.objValue;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, sensor, i2) == null) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048579, this, sensorEvent) == null) || sensorEvent == null) {
                return;
            }
            int type = sensorEvent.sensor.getType();
            if (type == 1) {
                this.f64173c = new d(sensorEvent);
            } else if (type == 4) {
                this.f64174d = new d(sensorEvent);
            } else if (type != 9) {
            } else {
                this.f64175e = new d(sensorEvent);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static abstract class c implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SensorEvent f64189a;

        /* renamed from: b  reason: collision with root package name */
        public long f64190b;

        public d(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {sensorEvent};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64189a = sensorEvent;
            this.f64190b = System.currentTimeMillis();
        }

        public SensorEvent a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f64189a : (SensorEvent) invokeV.objValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f64190b : invokeV.longValue;
        }
    }

    /* loaded from: classes2.dex */
    public static class e extends com.kwad.sdk.collector.e<com.kwad.sdk.collector.a.f> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public e(boolean z) {
            super(z);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Boolean) newInitContext.callArgs[0]).booleanValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.kwad.sdk.collector.e
        @Nullable
        @SuppressLint({"MissingPermission"})
        /* renamed from: c */
        public com.kwad.sdk.collector.a.f b(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context)) == null) {
                if (ap.a(context, "android.permission.READ_PHONE_STATE") != 0) {
                    return null;
                }
                com.kwad.sdk.collector.a.f fVar = new com.kwad.sdk.collector.a.f();
                if (Build.VERSION.SDK_INT >= 22) {
                    fVar.f64145b = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
                }
                fVar.f64144a = ap.a(context, (TelephonyManager) null);
                return fVar;
            }
            return (com.kwad.sdk.collector.a.f) invokeL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1320780785, "Lcom/kwad/sdk/collector/i;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1320780785, "Lcom/kwad/sdk/collector/i;");
                return;
            }
        }
        f64171b = new HashMap();
    }

    @Nullable
    public static com.kwad.sdk.core.g.a.c a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (d()) {
                return (com.kwad.sdk.core.g.a.c) a("baseStationEnable");
            }
            return null;
        }
        return (com.kwad.sdk.core.g.a.c) invokeV.objValue;
    }

    @Nullable
    public static <T> T a(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            com.kwad.sdk.collector.e eVar = f64171b.get(str);
            if (eVar != null) {
                return (T) eVar.a(f64170a);
            }
            return null;
        }
        return (T) invokeL.objValue;
    }

    public static void a(Context context) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(65539, null, context) == null) || context == null) {
            return;
        }
        boolean N = com.kwad.sdk.core.config.c.N();
        com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "sensorEnable2: " + N);
        if (d()) {
            if (f64171b.containsKey("baseStationEnable")) {
                boolean U = com.kwad.sdk.core.config.c.U();
                com.kwad.sdk.collector.e eVar = f64171b.get("baseStationEnable");
                if (eVar != null) {
                    eVar.a(U);
                }
            }
            if (f64171b.containsKey("sensorEventEnable")) {
                boolean N2 = com.kwad.sdk.core.config.c.N();
                com.kwad.sdk.collector.e eVar2 = f64171b.get("sensorEventEnable");
                if (eVar2 != null) {
                    eVar2.a(N2);
                }
            }
            if (f64171b.containsKey("simCardInfoEnable")) {
                boolean M = com.kwad.sdk.core.config.c.M();
                com.kwad.sdk.collector.e eVar3 = f64171b.get("simCardInfoEnable");
                if (eVar3 != null) {
                    eVar3.a(M);
                }
            }
        } else {
            f64170a = context.getApplicationContext();
            f64171b.put("baseStationEnable", new a(com.kwad.sdk.core.config.c.U()));
            f64171b.put("sensorEventEnable", new b(f64170a, com.kwad.sdk.core.config.c.N()));
            f64171b.put("simCardInfoEnable", new e(com.kwad.sdk.core.config.c.M()));
            com.kwad.sdk.collector.a.c.a(context);
        }
        for (com.kwad.sdk.collector.e eVar4 : f64171b.values()) {
            com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "collector: " + eVar4.f64163a + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar4.getClass().getSimpleName());
        }
    }

    @Nullable
    @WorkerThread
    public static List<com.kwad.sdk.collector.a.e> b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            if (d()) {
                return (List) a("sensorEventEnable");
            }
            return null;
        }
        return (List) invokeV.objValue;
    }

    @Nullable
    public static com.kwad.sdk.collector.a.f c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, null)) == null) {
            if (d()) {
                return (com.kwad.sdk.collector.a.f) a("simCardInfoEnable");
            }
            return null;
        }
        return (com.kwad.sdk.collector.a.f) invokeV.objValue;
    }

    public static boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f64170a != null : invokeV.booleanValue;
    }
}
