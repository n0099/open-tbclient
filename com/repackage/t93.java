package com.repackage;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class t93 implements SensorEventListener {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile t93 i;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public SensorManager b;
    public Sensor c;
    public a d;
    public double[] e;
    public boolean f;
    public long g;
    public int h;

    /* loaded from: classes7.dex */
    public interface a {
        void a(double[] dArr);
    }

    public t93() {
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
        this.e = new double[3];
        this.f = false;
        this.g = 0L;
    }

    public static t93 a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            if (i == null) {
                synchronized (t93.class) {
                    if (i == null) {
                        i = new t93();
                    }
                }
            }
            return i;
        }
        return (t93) invokeV.objValue;
    }

    public static synchronized void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(65538, null) == null) {
            synchronized (t93.class) {
                if (i == null) {
                    return;
                }
                i.c();
            }
        }
    }

    public synchronized void b(Context context, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048576, this, context, i2) == null) {
            synchronized (this) {
                this.a = context;
                this.h = i2;
            }
        }
    }

    public final synchronized void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            synchronized (this) {
                hx1.i("accelerometer", "release");
                if (this.f) {
                    g();
                }
                this.a = null;
                i = null;
            }
        }
    }

    public synchronized void e(a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            synchronized (this) {
                this.d = aVar;
            }
        }
    }

    public synchronized void f() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            synchronized (this) {
                if (this.a == null) {
                    hx1.c("accelerometer", "start error, none context");
                } else if (this.f) {
                    hx1.o("accelerometer", "has already start");
                } else {
                    SensorManager sensorManager = (SensorManager) this.a.getSystemService("sensor");
                    this.b = sensorManager;
                    if (sensorManager != null) {
                        Sensor defaultSensor = sensorManager.getDefaultSensor(1);
                        this.c = defaultSensor;
                        this.b.registerListener(this, defaultSensor, 1);
                        this.f = true;
                        hx1.i("accelerometer", "start listen");
                    } else {
                        hx1.c("accelerometer", "none sensorManager");
                    }
                }
            }
        }
    }

    public synchronized void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            synchronized (this) {
                if (!this.f) {
                    hx1.o("accelerometer", "has already stop");
                    return;
                }
                if (this.b != null) {
                    this.b.unregisterListener(this);
                }
                this.b = null;
                this.c = null;
                this.f = false;
            }
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onAccuracyChanged(Sensor sensor, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048581, this, sensor, i2) == null) {
        }
    }

    @Override // android.hardware.SensorEventListener
    public void onSensorChanged(SensorEvent sensorEvent) {
        Sensor sensor;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, sensorEvent) == null) || sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 1) {
            return;
        }
        float[] fArr = sensorEvent.values;
        if (fArr != null && fArr.length == 3) {
            synchronized (this) {
                if (this.f && this.d != null && System.currentTimeMillis() - this.g > this.h) {
                    this.e[0] = (-sensorEvent.values[0]) / 9.8d;
                    this.e[1] = (-sensorEvent.values[1]) / 9.8d;
                    this.e[2] = (-sensorEvent.values[2]) / 9.8d;
                    this.d.a(this.e);
                    this.g = System.currentTimeMillis();
                }
                if (h03.v) {
                    Log.d("AccelerometerManager", "current Time : " + this.g + "current Acc x : " + this.e[0] + "current Acc y : " + this.e[1] + "current Acc z : " + this.e[2]);
                }
            }
            return;
        }
        hx1.o("accelerometer", "illegal accelerometer event");
    }
}
