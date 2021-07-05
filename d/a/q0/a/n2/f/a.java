package d.a.q0.a.n2.f;

import android.annotation.SuppressLint;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobstat.Config;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e0.d;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    @SuppressLint({"StaticFieldLeak"})
    public static volatile a m;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f49726a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f49727b;

    /* renamed from: c  reason: collision with root package name */
    public SensorEventListener f49728c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f49729d;

    /* renamed from: e  reason: collision with root package name */
    public Sensor f49730e;

    /* renamed from: f  reason: collision with root package name */
    public Sensor f49731f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f49732g;

    /* renamed from: h  reason: collision with root package name */
    public float[] f49733h;

    /* renamed from: i  reason: collision with root package name */
    public int f49734i;
    public c j;
    public boolean k;
    public long l;

    /* renamed from: d.a.q0.a.n2.f.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0891a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49735e;

        public C0891a(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49735e = aVar;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 1) {
                    this.f49735e.f49732g = sensorEvent.values;
                    this.f49735e.f49734i = sensorEvent.accuracy;
                    d.a("SwanAppCompassManager", "accelerometer changed accuracy: " + this.f49735e.f49734i);
                    this.f49735e.k();
                    return;
                }
                d.l("compass", "illegal accelerometer event");
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49736e;

        public b(a aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49736e = aVar;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Sensor sensor;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent != null && (sensor = sensorEvent.sensor) != null && sensor.getType() == 2) {
                    this.f49736e.f49733h = sensorEvent.values;
                    this.f49736e.f49734i = sensorEvent.accuracy;
                    d.a("SwanAppCompassManager", "magneticFiled changed accuracy: " + this.f49736e.f49734i);
                    this.f49736e.k();
                    return;
                }
                d.l("compass", "illegal magnetic filed event");
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface c {
        void a(float f2, int i2);
    }

    public a() {
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
        this.f49732g = new float[3];
        this.f49733h = new float[3];
        this.f49734i = -100;
        this.k = false;
        this.l = 0L;
    }

    public static String h(int i2) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(AdIconUtil.BAIDU_LOGO_ID, null, i2)) == null) ? i2 != -1 ? i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "unknow" : "high" : "medium" : Config.EXCEPTION_MEMORY_LOW : "unreliable" : "no-contact" : (String) invokeI.objValue;
    }

    public static a i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (m == null) {
                synchronized (a.class) {
                    if (m == null) {
                        m = new a();
                    }
                }
            }
            return m;
        }
        return (a) invokeV.objValue;
    }

    public static void n() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || m == null) {
            return;
        }
        m.m();
    }

    public final float f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[3];
            float[] fArr2 = new float[9];
            SensorManager.getRotationMatrix(fArr2, null, this.f49732g, this.f49733h);
            SensorManager.getOrientation(fArr2, fArr);
            return (((float) Math.toDegrees(fArr[0])) + 360.0f) % 360.0f;
        }
        return invokeV.floatValue;
    }

    public final SensorEventListener g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d.g("compass", "get Accelerometer listener");
            SensorEventListener sensorEventListener = this.f49728c;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0891a c0891a = new C0891a(this);
            this.f49728c = c0891a;
            return c0891a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final SensorEventListener j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            d.g("compass", "get MagneticFiled listener");
            SensorEventListener sensorEventListener = this.f49729d;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            b bVar = new b(this);
            this.f49729d = bVar;
            return bVar;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || this.j == null || System.currentTimeMillis() - this.l <= 200) {
            return;
        }
        float f2 = f();
        d.a("SwanAppCompassManager", "orientation changed, orientation : " + f2);
        this.j.a(f2, this.f49734i);
        this.l = System.currentTimeMillis();
    }

    public void l(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, context) == null) {
            this.f49726a = context;
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            d.g("compass", "release");
            if (this.k) {
                q();
            }
            this.f49727b = null;
            this.f49731f = null;
            this.f49730e = null;
            this.f49728c = null;
            this.f49729d = null;
            this.j = null;
            this.f49726a = null;
            m = null;
        }
    }

    public void o(c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, cVar) == null) {
            this.j = cVar;
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            Context context = this.f49726a;
            if (context == null) {
                d.b("compass", "start error, none context");
            } else if (this.k) {
                d.l("compass", "has already start");
            } else {
                SensorManager sensorManager = (SensorManager) context.getSystemService("sensor");
                this.f49727b = sensorManager;
                if (sensorManager != null) {
                    this.f49730e = sensorManager.getDefaultSensor(1);
                    this.f49731f = this.f49727b.getDefaultSensor(2);
                    this.f49727b.registerListener(g(), this.f49730e, 1);
                    this.f49727b.registerListener(j(), this.f49731f, 1);
                    this.k = true;
                    d.g("compass", "start listen");
                    return;
                }
                d.b("compass", "none sensorManager");
            }
        }
    }

    public void q() {
        SensorManager sensorManager;
        SensorManager sensorManager2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (!this.k) {
                d.l("compass", "has already stop");
                return;
            }
            d.g("compass", "stop listen");
            SensorEventListener sensorEventListener = this.f49728c;
            if (sensorEventListener != null && (sensorManager2 = this.f49727b) != null) {
                sensorManager2.unregisterListener(sensorEventListener);
                this.f49728c = null;
            }
            SensorEventListener sensorEventListener2 = this.f49729d;
            if (sensorEventListener2 != null && (sensorManager = this.f49727b) != null) {
                sensorManager.unregisterListener(sensorEventListener2);
                this.f49729d = null;
            }
            this.f49727b = null;
            this.f49731f = null;
            this.f49730e = null;
            this.k = false;
        }
    }
}
