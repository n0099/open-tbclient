package com.repackage;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class qa3 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile qa3 i;
    public transient /* synthetic */ FieldHolder $fh;
    public SensorManager a;
    public SensorEventListener b;
    public Sensor c;
    public Sensor d;
    public b e;
    public float[] f;
    public float[] g;
    public boolean h;

    /* loaded from: classes7.dex */
    public class a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ qa3 a;

        public a(qa3 qa3Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {qa3Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = qa3Var;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i) == null) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            float[] g;
            Sensor sensor2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent != null && (sensor2 = sensorEvent.sensor) != null && sensor2.getType() == 1) {
                    float[] fArr = sensorEvent.values;
                    if (fArr == null || fArr.length != 3) {
                        return;
                    }
                    this.a.f = (float[]) fArr.clone();
                } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
                } else {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2 != null && fArr2.length == 3) {
                        this.a.g = (float[]) fArr2.clone();
                    }
                    if (this.a.e == null || this.a.f == null || this.a.g == null || (g = this.a.g()) == null) {
                        return;
                    }
                    this.a.e.a(g);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(float[] fArr);
    }

    public qa3() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.h = false;
    }

    public static qa3 h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (i == null) {
                synchronized (qa3.class) {
                    if (i == null) {
                        i = new qa3();
                    }
                }
            }
            return i;
        }
        return (qa3) invokeV.objValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || i == null) {
            return;
        }
        i.j();
    }

    @Nullable
    public final float[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[9];
            float[] fArr2 = new float[9];
            float[] fArr3 = new float[3];
            if (SensorManager.getRotationMatrix(fArr, null, this.f, this.g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
                SensorManager.getOrientation(fArr2, fArr3);
                return fArr3;
            }
            return null;
        }
        return (float[]) invokeV.objValue;
    }

    public final SensorEventListener i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            ix1.i("SwanAppOrientationManager", "get System Sensor listener");
            SensorEventListener sensorEventListener = this.b;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            a aVar = new a(this);
            this.b = aVar;
            return aVar;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            ix1.i("SwanAppOrientationManager", "release");
            if (this.h) {
                m();
            }
            this.a = null;
            this.c = null;
            this.d = null;
            this.b = null;
            this.f = null;
            this.g = null;
            i = null;
        }
    }

    public boolean l(int i2, @NonNull b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, bVar)) == null) {
            if (this.h) {
                ix1.o("SwanAppOrientationManager", "has already start, change new listener");
                this.e = bVar;
                return true;
            }
            SensorManager sensorManager = (SensorManager) pj2.c().getSystemService("sensor");
            this.a = sensorManager;
            if (sensorManager != null) {
                this.e = bVar;
                this.c = sensorManager.getDefaultSensor(1);
                Sensor defaultSensor = this.a.getDefaultSensor(2);
                this.d = defaultSensor;
                if (this.c != null && defaultSensor != null) {
                    this.a.registerListener(i(), this.c, i2);
                    this.a.registerListener(i(), this.d, i2);
                    this.h = true;
                    ix1.i("SwanAppOrientationManager", "start listen");
                    return true;
                }
                ix1.c("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            ix1.c("SwanAppOrientationManager", "none sensorManager");
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void m() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.h) {
                ix1.o("SwanAppOrientationManager", "has already stop");
                return;
            }
            this.h = false;
            SensorEventListener sensorEventListener = this.b;
            if (sensorEventListener != null && (sensorManager = this.a) != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.b = null;
            }
            this.e = null;
            this.a = null;
            this.c = null;
            this.d = null;
        }
    }
}
