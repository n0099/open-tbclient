package d.a.q0.a.n2.i;

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
import d.a.q0.a.e0.d;
/* loaded from: classes8.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f49771i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f49772a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f49773b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f49774c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f49775d;

    /* renamed from: e  reason: collision with root package name */
    public b f49776e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f49777f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f49778g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f49779h;

    /* renamed from: d.a.q0.a.n2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0896a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f49780e;

        public C0896a(a aVar) {
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
            this.f49780e = aVar;
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
            float[] g2;
            Sensor sensor2;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                if (sensorEvent != null && (sensor2 = sensorEvent.sensor) != null && sensor2.getType() == 1) {
                    float[] fArr = sensorEvent.values;
                    if (fArr == null || fArr.length != 3) {
                        return;
                    }
                    this.f49780e.f49777f = (float[]) fArr.clone();
                } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
                } else {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2 != null && fArr2.length == 3) {
                        this.f49780e.f49778g = (float[]) fArr2.clone();
                    }
                    if (this.f49780e.f49776e == null || this.f49780e.f49777f == null || this.f49780e.f49778g == null || (g2 = this.f49780e.g()) == null) {
                        return;
                    }
                    this.f49780e.f49776e.a(g2);
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public interface b {
        void a(float[] fArr);
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
        this.f49779h = false;
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f49771i == null) {
                synchronized (a.class) {
                    if (f49771i == null) {
                        f49771i = new a();
                    }
                }
            }
            return f49771i;
        }
        return (a) invokeV.objValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f49771i == null) {
            return;
        }
        f49771i.j();
    }

    @Nullable
    public final float[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[9];
            float[] fArr2 = new float[9];
            float[] fArr3 = new float[3];
            if (SensorManager.getRotationMatrix(fArr, null, this.f49777f, this.f49778g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
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
            d.g("SwanAppOrientationManager", "get System Sensor listener");
            SensorEventListener sensorEventListener = this.f49773b;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0896a c0896a = new C0896a(this);
            this.f49773b = c0896a;
            return c0896a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.g("SwanAppOrientationManager", "release");
            if (this.f49779h) {
                m();
            }
            this.f49772a = null;
            this.f49774c = null;
            this.f49775d = null;
            this.f49773b = null;
            this.f49777f = null;
            this.f49778g = null;
            f49771i = null;
        }
    }

    public boolean l(int i2, @NonNull b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, bVar)) == null) {
            if (this.f49779h) {
                d.l("SwanAppOrientationManager", "has already start, change new listener");
                this.f49776e = bVar;
                return true;
            }
            SensorManager sensorManager = (SensorManager) d.a.q0.a.c1.a.b().getSystemService("sensor");
            this.f49772a = sensorManager;
            if (sensorManager != null) {
                this.f49776e = bVar;
                this.f49774c = sensorManager.getDefaultSensor(1);
                Sensor defaultSensor = this.f49772a.getDefaultSensor(2);
                this.f49775d = defaultSensor;
                if (this.f49774c != null && defaultSensor != null) {
                    this.f49772a.registerListener(i(), this.f49774c, i2);
                    this.f49772a.registerListener(i(), this.f49775d, i2);
                    this.f49779h = true;
                    d.g("SwanAppOrientationManager", "start listen");
                    return true;
                }
                d.b("SwanAppOrientationManager", "Accelerometer || Magnetic is null");
                return false;
            }
            d.b("SwanAppOrientationManager", "none sensorManager");
            return false;
        }
        return invokeIL.booleanValue;
    }

    public void m() {
        SensorManager sensorManager;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (!this.f49779h) {
                d.l("SwanAppOrientationManager", "has already stop");
                return;
            }
            this.f49779h = false;
            SensorEventListener sensorEventListener = this.f49773b;
            if (sensorEventListener != null && (sensorManager = this.f49772a) != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.f49773b = null;
            }
            this.f49776e = null;
            this.f49772a = null;
            this.f49774c = null;
            this.f49775d = null;
        }
    }
}
