package com.yy.hiidostatis.defs.controller;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorListener;
import android.hardware.SensorManager;
import android.os.Build;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.hiidostatis.api.StatisContent;
import com.yy.hiidostatis.inner.util.DefaultPreference;
import com.yy.hiidostatis.inner.util.ThreadPool;
import com.yy.hiidostatis.inner.util.log.L;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes8.dex */
public class SensorController implements SensorEventListener, SensorListener {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CACHE_HEAD_LENGTH = 5;
    public static final int CACHE_LENGTH = 10;
    public static final String KEY_ACCEL = "accel";
    public static final String KEY_BATLV = "batlv";
    public static final String KEY_GYRO = "gyro";
    public static final String KEY_LIGHT = "light";
    public static final int MAX_SAVE_INTEVAL_SECOND = 300;
    public static final int MAX_SAVE_THRESHOLD = 10;
    public static volatile StatisContent record;
    public transient /* synthetic */ FieldHolder $fh;
    public Sensor accelerometer;
    public LinkedList<SensorRecord> accelerometerCache;
    public float accelerometerThreshold;
    public Context context;
    public int countAccelerometer;
    public int countGvroscope;
    public int countLight;
    public final boolean enable;
    public Sensor gyroscope;
    public LinkedList<SensorRecord> gyroscopeCache;
    public float gyroscopeThreshold;
    public BatteryInfo initiateBattery;
    public Sensor light;
    public LinkedList<SensorRecord> lightCache;
    public float lightThreshold;
    public int preSaveCountAcce;
    public int preSaveCountGyro;
    public int preSaveCountLight;
    public boolean register;
    public int saveCount;
    public int saveTime;
    public SensorManager sensorManager;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(-1043676736, "Lcom/yy/hiidostatis/defs/controller/SensorController;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(-1043676736, "Lcom/yy/hiidostatis/defs/controller/SensorController;");
        }
    }

    @Override // android.hardware.SensorListener
    public void onAccuracyChanged(int i, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeII(1048576, this, i, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensor, i) == null) {
        }
    }

    /* loaded from: classes8.dex */
    public static class BatteryInfo {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public int chargePlugged;
        public int level;
        public float pecent;
        public int status;

        public BatteryInfo() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public static BatteryInfo getCurrentBatttery(Context context) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
                try {
                    Intent registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
                    int intExtra = registerReceiver.getIntExtra("status", -1);
                    int intExtra2 = registerReceiver.getIntExtra("level", -1);
                    int intExtra3 = registerReceiver.getIntExtra("plugged", -1);
                    BatteryInfo batteryInfo = new BatteryInfo();
                    batteryInfo.level = intExtra2;
                    batteryInfo.status = intExtra;
                    batteryInfo.pecent = (intExtra2 * 100) / registerReceiver.getIntExtra("scale", -1);
                    batteryInfo.chargePlugged = intExtra3;
                    return batteryInfo;
                } catch (Throwable th) {
                    L.debug("SensorController", th.getMessage(), new Object[0]);
                    return null;
                }
            }
            return (BatteryInfo) invokeL.objValue;
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return String.format("%d,%d,%f,%d", Integer.valueOf(this.status), Integer.valueOf(this.level), Float.valueOf(this.pecent), Integer.valueOf(this.chargePlugged));
            }
            return (String) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static class SensorRecord {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public long time;
        public float[] value;

        public SensorRecord(float[] fArr, long j) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {fArr, Long.valueOf(j)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.value = fArr;
            this.time = j;
        }
    }

    public SensorController(Context context, float f, float f2, float f3, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.gyroscopeCache = new LinkedList<>();
        this.accelerometerCache = new LinkedList<>();
        this.lightCache = new LinkedList<>();
        this.gyroscopeThreshold = f;
        this.accelerometerThreshold = f2;
        this.lightThreshold = f3;
        this.enable = z;
        this.context = context;
        if (!z) {
            return;
        }
        try {
            SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
            this.sensorManager = sensorManager;
            this.gyroscope = sensorManager.getDefaultSensor(4);
            this.accelerometer = this.sensorManager.getDefaultSensor(1);
            this.light = this.sensorManager.getDefaultSensor(5);
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
        }
    }

    private void addCache(float[] fArr, LinkedList<SensorRecord> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, fArr, linkedList) == null) {
            if (linkedList.size() < 10) {
                linkedList.add(new SensorRecord(copyFloatArray(fArr), System.currentTimeMillis()));
                return;
            }
            SensorRecord remove = linkedList.remove(5);
            remove.value = copyFloatArray(fArr);
            remove.time = System.currentTimeMillis();
            linkedList.add(remove);
            while (linkedList.size() > 10) {
                linkedList.remove(5);
            }
        }
    }

    private boolean compareFloats(float[] fArr, float[] fArr2, float f) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TRACKBALL, this, new Object[]{fArr, fArr2, Float.valueOf(f)})) == null) {
            if (fArr.length != fArr2.length) {
                return true;
            }
            for (int i = 0; i < fArr.length; i++) {
                if (f > 0.0f) {
                    if (Math.abs(fArr[i] - fArr2[i]) > f) {
                        return true;
                    }
                } else if (fArr[i] != 0.0f) {
                    if ((Math.abs(fArr2[i] - fArr[i]) * 100.0f) / Math.abs(fArr[i]) > (-f)) {
                        return true;
                    }
                } else if (fArr2[i] != 0.0f) {
                    return true;
                }
            }
            return false;
        }
        return invokeCommon.booleanValue;
    }

    public static float[] copyFloatArray(float[] fArr) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65541, null, fArr)) == null) {
            float[] fArr2 = new float[fArr.length];
            System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
            return fArr2;
        }
        return (float[]) invokeL.objValue;
    }

    public static synchronized void initRecord(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65542, null, context) == null) {
            synchronized (SensorController.class) {
                StatisContent loadFileAndClear = loadFileAndClear(context);
                if (loadFileAndClear != null && !loadFileAndClear.isEmpty()) {
                    record = loadFileAndClear;
                }
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, sensorEvent) != null) || !this.enable) {
            return;
        }
        try {
            valueChanged(sensorEvent.sensor.getType(), sensorEvent.values);
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
        }
    }

    public void onStart(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, context) != null) || !this.enable) {
            return;
        }
        if (this.initiateBattery == null) {
            this.initiateBattery = BatteryInfo.getCurrentBatttery(context);
        }
        register(context);
    }

    public void onStop(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048581, this, context) != null) || !this.enable) {
            return;
        }
        unregister(context);
        save(context, true);
    }

    public void reset(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048582, this, context) != null) || !this.enable) {
            return;
        }
        this.countLight = 0;
        this.countAccelerometer = 0;
        this.countGvroscope = 0;
        this.gyroscopeCache.clear();
        this.accelerometerCache.clear();
        this.lightCache.clear();
        this.initiateBattery = BatteryInfo.getCurrentBatttery(context);
    }

    public static synchronized StatisContent loadFileAndClear(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65543, null, context)) == null) {
            synchronized (SensorController.class) {
                if (record != null) {
                    StatisContent statisContent = record;
                    record = null;
                    return statisContent;
                }
                StatisContent statisContent2 = new StatisContent();
                String prefString = DefaultPreference.getPreference().getPrefString(context, "SENSOR_gyro", null);
                String prefString2 = DefaultPreference.getPreference().getPrefString(context, "SENSOR_accel", null);
                String prefString3 = DefaultPreference.getPreference().getPrefString(context, "SENSOR_light", null);
                String prefString4 = DefaultPreference.getPreference().getPrefString(context, "SENSOR_batlv", null);
                if (prefString != null && !prefString.isEmpty()) {
                    statisContent2.put(KEY_GYRO, prefString);
                }
                if (prefString2 != null && !prefString2.isEmpty()) {
                    statisContent2.put(KEY_ACCEL, prefString2);
                }
                if (prefString3 != null && !prefString3.isEmpty()) {
                    statisContent2.put(KEY_LIGHT, prefString3);
                }
                if (prefString4 != null && !prefString4.isEmpty()) {
                    statisContent2.put(KEY_BATLV, prefString4);
                }
                DefaultPreference.getPreference().clearKey(context, "SENSOR_gyro");
                DefaultPreference.getPreference().clearKey(context, "SENSOR_accel");
                DefaultPreference.getPreference().clearKey(context, "SENSOR_light");
                DefaultPreference.getPreference().clearKey(context, "SENSOR_batlv");
                return statisContent2;
            }
        }
        return (StatisContent) invokeL.objValue;
    }

    private void recordToString(int i, List<SensorRecord> list, StringBuilder sb) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeILL(65544, this, i, list, sb) == null) {
            sb.append(i);
            if (i > 0) {
                sb.append("|");
                for (SensorRecord sensorRecord : list) {
                    for (float f : sensorRecord.value) {
                        sb.append(f);
                        sb.append(',');
                    }
                    sb.append(sensorRecord.time);
                    sb.append(':');
                }
                sb.setLength(sb.length() - 1);
            }
        }
    }

    private void register(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(65545, this, context) != null) || this.register) {
            return;
        }
        Sensor sensor = this.gyroscope;
        if (sensor != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.sensorManager.registerListener(this, sensor, 3);
            } else {
                this.sensorManager.registerListener(this, 4, 3);
            }
            this.register = true;
        }
        Sensor sensor2 = this.accelerometer;
        if (sensor2 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.sensorManager.registerListener(this, sensor2, 3);
            } else {
                this.sensorManager.registerListener(this, 1, 3);
            }
            this.register = true;
        }
        Sensor sensor3 = this.light;
        if (sensor3 != null) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.sensorManager.registerListener(this, sensor3, 3);
            } else {
                this.sensorManager.registerListener(this, 5);
            }
            this.register = true;
        }
    }

    private void unregister(Context context) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(65549, this, context) == null) && this.register) {
            if (Build.VERSION.SDK_INT >= 24) {
                this.sensorManager.unregisterListener(this, this.gyroscope);
                this.sensorManager.unregisterListener(this, this.accelerometer);
                this.sensorManager.unregisterListener(this, this.light);
            } else {
                this.sensorManager.unregisterListener(this, 2);
                this.sensorManager.unregisterListener(this, 16);
                this.sensorManager.unregisterListener(this, 127);
            }
            this.register = false;
        }
    }

    /* JADX DEBUG: Another duplicated slice has different insns count: {[]}, finally: {[MOVE_EXCEPTION, INVOKE, CONST, NEW_ARRAY, INVOKE, MOVE_EXCEPTION] complete} */
    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void save(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65546, this, context, z) == null) {
            synchronized (this) {
                try {
                    int i = this.saveCount * 5;
                    if (i > 300) {
                        i = 300;
                    }
                    if (!z) {
                        if ((System.currentTimeMillis() / 1000) - this.saveTime < i) {
                            return;
                        }
                    }
                } finally {
                }
                if (!z && this.countGvroscope == 0 && this.countAccelerometer == 0 && this.countLight == 0) {
                    return;
                }
                this.saveTime = (int) (System.currentTimeMillis() / 1000);
                if (!z) {
                    this.saveCount++;
                }
                this.preSaveCountGyro = this.countGvroscope;
                this.preSaveCountAcce = this.countAccelerometer;
                this.preSaveCountLight = this.countLight;
                StatisContent params = toParams();
                String str = params.get(KEY_GYRO);
                String str2 = params.get(KEY_ACCEL);
                String str3 = params.get(KEY_LIGHT);
                String str4 = params.get(KEY_BATLV);
                if (str != null && !str.isEmpty()) {
                    DefaultPreference.getPreference().setPrefString(context, "SENSOR_gyro", str);
                }
                if (str2 != null && !str2.isEmpty()) {
                    DefaultPreference.getPreference().setPrefString(context, "SENSOR_accel", str2);
                }
                if (str3 != null && !str3.isEmpty()) {
                    DefaultPreference.getPreference().setPrefString(context, "SENSOR_light", str3);
                }
                if (str4 != null && !str4.isEmpty()) {
                    DefaultPreference.getPreference().setPrefString(context, "SENSOR_batlv", str4);
                }
            }
        }
    }

    private void valueChanged(int i, float[] fArr) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(65550, this, i, fArr) == null) {
            if (i != 1) {
                if (i != 4) {
                    if (i == 5) {
                        if (this.lightCache.isEmpty()) {
                            this.lightCache.add(new SensorRecord(copyFloatArray(fArr), System.currentTimeMillis()));
                            this.countLight++;
                            saveAsyn(this.context, true);
                        } else if (compareFloats(this.lightCache.getLast().value, fArr, this.lightThreshold)) {
                            addCache(fArr, this.lightCache);
                            int i2 = this.countLight + 1;
                            this.countLight = i2;
                            if (i2 - this.preSaveCountLight > 10) {
                                saveAsyn(this.context, false);
                            }
                        }
                    }
                } else if (this.gyroscopeCache.isEmpty()) {
                    this.gyroscopeCache.add(new SensorRecord(copyFloatArray(fArr), System.currentTimeMillis()));
                    this.countGvroscope++;
                    saveAsyn(this.context, true);
                } else if (compareFloats(this.gyroscopeCache.getLast().value, fArr, this.gyroscopeThreshold)) {
                    addCache(fArr, this.gyroscopeCache);
                    int i3 = this.countGvroscope + 1;
                    this.countGvroscope = i3;
                    if (i3 - this.preSaveCountGyro > 10) {
                        saveAsyn(this.context, false);
                    }
                }
            } else if (this.accelerometerCache.isEmpty()) {
                this.accelerometerCache.add(new SensorRecord(copyFloatArray(fArr), System.currentTimeMillis()));
                this.countAccelerometer++;
                saveAsyn(this.context, true);
            } else if (compareFloats(this.accelerometerCache.getLast().value, fArr, this.accelerometerThreshold)) {
                addCache(fArr, this.accelerometerCache);
                int i4 = this.countAccelerometer + 1;
                this.countAccelerometer = i4;
                if (i4 - this.preSaveCountAcce > 10) {
                    saveAsyn(this.context, false);
                }
            }
        }
    }

    private void saveAsyn(Context context, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(65547, this, context, z) == null) {
            ThreadPool.getPool().execute(new Runnable(this, context, z) { // from class: com.yy.hiidostatis.defs.controller.SensorController.1
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SensorController this$0;
                public final /* synthetic */ Context val$context;
                public final /* synthetic */ boolean val$force;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, context, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$context = context;
                    this.val$force = z;
                }

                @Override // java.lang.Runnable
                public void run() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        this.this$0.save(this.val$context, this.val$force);
                    }
                }
            });
        }
    }

    @Override // android.hardware.SensorListener
    public void onSensorChanged(int i, float[] fArr) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i, fArr) != null) || !this.enable) {
            return;
        }
        try {
            valueChanged(i, fArr);
        } catch (Throwable th) {
            L.debug(this, th.getMessage(), new Object[0]);
        }
    }

    private StatisContent toParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65548, this)) == null) {
            StatisContent statisContent = new StatisContent();
            StringBuilder sb = new StringBuilder();
            recordToString(this.countGvroscope, this.gyroscopeCache, sb);
            statisContent.put(KEY_GYRO, sb.toString());
            sb.setLength(0);
            recordToString(this.countAccelerometer, this.accelerometerCache, sb);
            statisContent.put(KEY_ACCEL, sb.toString());
            sb.setLength(0);
            recordToString(this.countLight, this.lightCache, sb);
            statisContent.put(KEY_LIGHT, sb.toString());
            if (this.initiateBattery != null) {
                BatteryInfo currentBatttery = BatteryInfo.getCurrentBatttery(this.context);
                statisContent.put(KEY_BATLV, this.initiateBattery.toString() + "|" + currentBatttery.toString());
            }
            return statisContent;
        }
        return (StatisContent) invokeV.objValue;
    }
}
