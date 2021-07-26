package d.a.o0.a.n2.i;

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
import d.a.o0.a.e0.d;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: i  reason: collision with root package name */
    public static volatile a f46973i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public SensorManager f46974a;

    /* renamed from: b  reason: collision with root package name */
    public SensorEventListener f46975b;

    /* renamed from: c  reason: collision with root package name */
    public Sensor f46976c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f46977d;

    /* renamed from: e  reason: collision with root package name */
    public b f46978e;

    /* renamed from: f  reason: collision with root package name */
    public float[] f46979f;

    /* renamed from: g  reason: collision with root package name */
    public float[] f46980g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f46981h;

    /* renamed from: d.a.o0.a.n2.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class C0854a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ a f46982e;

        public C0854a(a aVar) {
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
            this.f46982e = aVar;
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
                    this.f46982e.f46979f = (float[]) fArr.clone();
                } else if (sensorEvent == null || (sensor = sensorEvent.sensor) == null || sensor.getType() != 2) {
                } else {
                    float[] fArr2 = sensorEvent.values;
                    if (fArr2 != null && fArr2.length == 3) {
                        this.f46982e.f46980g = (float[]) fArr2.clone();
                    }
                    if (this.f46982e.f46978e == null || this.f46982e.f46979f == null || this.f46982e.f46980g == null || (g2 = this.f46982e.g()) == null) {
                        return;
                    }
                    this.f46982e.f46978e.a(g2);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
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
        this.f46981h = false;
    }

    public static a h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, null)) == null) {
            if (f46973i == null) {
                synchronized (a.class) {
                    if (f46973i == null) {
                        f46973i = new a();
                    }
                }
            }
            return f46973i;
        }
        return (a) invokeV.objValue;
    }

    public static void k() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(65544, null) == null) || f46973i == null) {
            return;
        }
        f46973i.j();
    }

    @Nullable
    public final float[] g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            float[] fArr = new float[9];
            float[] fArr2 = new float[9];
            float[] fArr3 = new float[3];
            if (SensorManager.getRotationMatrix(fArr, null, this.f46979f, this.f46980g) && SensorManager.remapCoordinateSystem(fArr, 2, 129, fArr2)) {
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
            SensorEventListener sensorEventListener = this.f46975b;
            if (sensorEventListener != null) {
                return sensorEventListener;
            }
            C0854a c0854a = new C0854a(this);
            this.f46975b = c0854a;
            return c0854a;
        }
        return (SensorEventListener) invokeV.objValue;
    }

    public final void j() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            d.g("SwanAppOrientationManager", "release");
            if (this.f46981h) {
                m();
            }
            this.f46974a = null;
            this.f46976c = null;
            this.f46977d = null;
            this.f46975b = null;
            this.f46979f = null;
            this.f46980g = null;
            f46973i = null;
        }
    }

    public boolean l(int i2, @NonNull b bVar) {
        InterceptResult invokeIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIL = interceptable.invokeIL(1048579, this, i2, bVar)) == null) {
            if (this.f46981h) {
                d.l("SwanAppOrientationManager", "has already start, change new listener");
                this.f46978e = bVar;
                return true;
            }
            SensorManager sensorManager = (SensorManager) d.a.o0.a.c1.a.b().getSystemService("sensor");
            this.f46974a = sensorManager;
            if (sensorManager != null) {
                this.f46978e = bVar;
                this.f46976c = sensorManager.getDefaultSensor(1);
                Sensor defaultSensor = this.f46974a.getDefaultSensor(2);
                this.f46977d = defaultSensor;
                if (this.f46976c != null && defaultSensor != null) {
                    this.f46974a.registerListener(i(), this.f46976c, i2);
                    this.f46974a.registerListener(i(), this.f46977d, i2);
                    this.f46981h = true;
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
            if (!this.f46981h) {
                d.l("SwanAppOrientationManager", "has already stop");
                return;
            }
            this.f46981h = false;
            SensorEventListener sensorEventListener = this.f46975b;
            if (sensorEventListener != null && (sensorManager = this.f46974a) != null) {
                sensorManager.unregisterListener(sensorEventListener);
                this.f46975b = null;
            }
            this.f46978e = null;
            this.f46974a = null;
            this.f46976c = null;
            this.f46977d = null;
        }
    }
}
