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
/* loaded from: classes6.dex */
public class i {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: a  reason: collision with root package name */
    public static Context f34041a;

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, com.kwad.sdk.collector.e> f34042b;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes6.dex */
    public static class a extends com.kwad.sdk.collector.e<com.kwad.sdk.core.g.a.c> {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: c  reason: collision with root package name */
        public static com.kwad.sdk.core.g.a.c f34043c;
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
                com.kwad.sdk.core.g.a.c cVar = f34043c;
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
                        f34043c = new com.kwad.sdk.core.g.a.c(i3, i2, i4);
                    }
                    return f34043c;
                }
                return null;
            }
            return (com.kwad.sdk.core.g.a.c) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static class b extends com.kwad.sdk.collector.e<List<com.kwad.sdk.collector.a.e>> implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public d f34044c;

        /* renamed from: d  reason: collision with root package name */
        public d f34045d;

        /* renamed from: e  reason: collision with root package name */
        public d f34046e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f34047f;

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
            this.f34047f = false;
            if (z && 0 == 0) {
                d(context);
            }
        }

        private List<com.kwad.sdk.collector.a.e> a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(65537, this)) == null) {
                ArrayList arrayList = new ArrayList();
                d dVar = this.f34044c;
                if (dVar != null) {
                    arrayList.add(com.kwad.sdk.collector.a.e.a(dVar.a(), this.f34044c.b()));
                }
                d dVar2 = this.f34045d;
                if (dVar2 != null) {
                    arrayList.add(com.kwad.sdk.collector.a.e.a(dVar2.a(), this.f34045d.b()));
                }
                d dVar3 = this.f34046e;
                if (dVar3 != null) {
                    arrayList.add(com.kwad.sdk.collector.a.e.a(dVar3.a(), this.f34046e.b()));
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
                        public final /* synthetic */ List f34048a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ CountDownLatch f34049b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ SensorManager f34050c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ b f34051d;

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
                            this.f34051d = this;
                            this.f34048a = arrayList;
                            this.f34049b = countDownLatch;
                            this.f34050c = sensorManager;
                        }

                        @Override // android.hardware.SensorEventListener
                        public void onSensorChanged(SensorEvent sensorEvent) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, sensorEvent) == null) {
                                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                                this.f34048a.add(com.kwad.sdk.collector.a.e.a(sensorEvent, System.currentTimeMillis()));
                                this.f34049b.countDown();
                                this.f34050c.unregisterListener(this);
                            }
                        }
                    })) {
                        countDownLatch.countDown();
                    }
                    if (!a(sensorManager, 4, new c(this, arrayList, countDownLatch, sensorManager) { // from class: com.kwad.sdk.collector.i.b.2
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f34052a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ CountDownLatch f34053b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ SensorManager f34054c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ b f34055d;

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
                            this.f34055d = this;
                            this.f34052a = arrayList;
                            this.f34053b = countDownLatch;
                            this.f34054c = sensorManager;
                        }

                        @Override // android.hardware.SensorEventListener
                        public void onSensorChanged(SensorEvent sensorEvent) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, sensorEvent) == null) {
                                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                                this.f34052a.add(com.kwad.sdk.collector.a.e.a(sensorEvent, System.currentTimeMillis()));
                                this.f34053b.countDown();
                                this.f34054c.unregisterListener(this);
                            }
                        }
                    })) {
                        countDownLatch.countDown();
                    }
                    if (!a(sensorManager, 9, new c(this, arrayList, countDownLatch, sensorManager) { // from class: com.kwad.sdk.collector.i.b.3
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;

                        /* renamed from: a  reason: collision with root package name */
                        public final /* synthetic */ List f34056a;

                        /* renamed from: b  reason: collision with root package name */
                        public final /* synthetic */ CountDownLatch f34057b;

                        /* renamed from: c  reason: collision with root package name */
                        public final /* synthetic */ SensorManager f34058c;

                        /* renamed from: d  reason: collision with root package name */
                        public final /* synthetic */ b f34059d;

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
                            this.f34059d = this;
                            this.f34056a = arrayList;
                            this.f34057b = countDownLatch;
                            this.f34058c = sensorManager;
                        }

                        @Override // android.hardware.SensorEventListener
                        public void onSensorChanged(SensorEvent sensorEvent) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeL(1048576, this, sensorEvent) == null) {
                                com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "onSensorChanged, type: " + sensorEvent.sensor.getType());
                                this.f34056a.add(com.kwad.sdk.collector.a.e.a(sensorEvent, System.currentTimeMillis()));
                                this.f34057b.countDown();
                                this.f34058c.unregisterListener(this);
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
                if (this.f34047f) {
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
                this.f34044c = new d(sensorEvent);
            } else if (type == 4) {
                this.f34045d = new d(sensorEvent);
            } else if (type != 9) {
            } else {
                this.f34046e = new d(sensorEvent);
            }
        }
    }

    /* loaded from: classes6.dex */
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

    /* loaded from: classes6.dex */
    public static class d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public SensorEvent f34060a;

        /* renamed from: b  reason: collision with root package name */
        public long f34061b;

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
            this.f34060a = sensorEvent;
            this.f34061b = System.currentTimeMillis();
        }

        public SensorEvent a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.f34060a : (SensorEvent) invokeV.objValue;
        }

        public long b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f34061b : invokeV.longValue;
        }
    }

    /* loaded from: classes6.dex */
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
                TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
                if (Build.VERSION.SDK_INT >= 22) {
                    fVar.f34016b = ((SubscriptionManager) context.getSystemService("telephony_subscription_service")).getActiveSubscriptionInfoCount();
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    fVar.f34015a = telephonyManager.getPhoneCount();
                }
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
        f34042b = new HashMap();
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
            com.kwad.sdk.collector.e eVar = f34042b.get(str);
            if (eVar != null) {
                return (T) eVar.a(f34041a);
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
            if (f34042b.containsKey("baseStationEnable")) {
                boolean U = com.kwad.sdk.core.config.c.U();
                com.kwad.sdk.collector.e eVar = f34042b.get("baseStationEnable");
                if (eVar != null) {
                    eVar.a(U);
                }
            }
            if (f34042b.containsKey("sensorEventEnable")) {
                boolean N2 = com.kwad.sdk.core.config.c.N();
                com.kwad.sdk.collector.e eVar2 = f34042b.get("sensorEventEnable");
                if (eVar2 != null) {
                    eVar2.a(N2);
                }
            }
            if (f34042b.containsKey("simCardInfoEnable")) {
                boolean M = com.kwad.sdk.core.config.c.M();
                com.kwad.sdk.collector.e eVar3 = f34042b.get("simCardInfoEnable");
                if (eVar3 != null) {
                    eVar3.a(M);
                }
            }
        } else {
            f34041a = context.getApplicationContext();
            f34042b.put("baseStationEnable", new a(com.kwad.sdk.core.config.c.U()));
            f34042b.put("sensorEventEnable", new b(f34041a, com.kwad.sdk.core.config.c.N()));
            f34042b.put("simCardInfoEnable", new e(com.kwad.sdk.core.config.c.M()));
            com.kwad.sdk.collector.a.c.a(context);
        }
        for (com.kwad.sdk.collector.e eVar4 : f34042b.values()) {
            com.kwad.sdk.core.d.a.a("SensitiveInfoCollectors", "collector: " + eVar4.f34034a + StringUtil.ARRAY_ELEMENT_SEPARATOR + eVar4.getClass().getSimpleName());
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
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f34041a != null : invokeV.booleanValue;
    }
}
