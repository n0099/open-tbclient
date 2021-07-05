package d.f.e.a.a;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes10.dex */
public class c implements e {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: g  reason: collision with root package name */
    public static final String f73894g = "c";
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f73895a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f73896b;

    /* renamed from: c  reason: collision with root package name */
    public Looper f73897c;

    /* renamed from: d  reason: collision with root package name */
    public SensorEventListener f73898d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<SensorEventListener> f73899e;

    /* renamed from: f  reason: collision with root package name */
    public int f73900f;

    /* loaded from: classes10.dex */
    public class a implements SensorEventListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f73901e;

        public a(c cVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73901e = cVar;
        }

        @Override // android.hardware.SensorEventListener
        public void onAccuracyChanged(Sensor sensor, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, sensor, i2) == null) {
                synchronized (this.f73901e.f73899e) {
                    Iterator it = this.f73901e.f73899e.iterator();
                    while (it.hasNext()) {
                        ((SensorEventListener) it.next()).onAccuracyChanged(sensor, i2);
                    }
                }
            }
        }

        @Override // android.hardware.SensorEventListener
        public void onSensorChanged(SensorEvent sensorEvent) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEvent) == null) {
                synchronized (this.f73901e.f73899e) {
                    Iterator it = this.f73901e.f73899e.iterator();
                    while (it.hasNext()) {
                        ((SensorEventListener) it.next()).onSensorChanged(sensorEvent);
                    }
                }
            }
        }
    }

    /* loaded from: classes10.dex */
    public class b extends HandlerThread {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ c f73902e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(c cVar, String str) {
            super(str);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((String) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f73902e = cVar;
        }

        @Override // android.os.HandlerThread
        public void onLooperPrepared() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                Handler handler = new Handler(Looper.myLooper());
                this.f73902e.f73896b.registerListener(this.f73902e.f73898d, this.f73902e.f73896b.getDefaultSensor(1), this.f73902e.f73900f, handler);
                Sensor h2 = this.f73902e.h();
                if (h2 == null) {
                    Log.i(c.f73894g, "Uncalibrated gyroscope unavailable, default to regular gyroscope.");
                    h2 = this.f73902e.f73896b.getDefaultSensor(4);
                }
                this.f73902e.f73896b.registerListener(this.f73902e.f73898d, h2, this.f73902e.f73900f, handler);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(243243742, "Ld/f/e/a/a/c;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(243243742, "Ld/f/e/a/a/c;");
        }
    }

    public c(SensorManager sensorManager, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {sensorManager, Integer.valueOf(i2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f73899e = new ArrayList<>();
        this.f73896b = sensorManager;
        this.f73900f = i2;
    }

    @Override // d.f.e.a.a.e
    public void a() {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.f73895a) {
            return;
        }
        this.f73898d = new a(this);
        b bVar = new b(this, "sensor");
        bVar.start();
        this.f73897c = bVar.getLooper();
        this.f73895a = true;
    }

    @Override // d.f.e.a.a.e
    public void a(SensorEventListener sensorEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, sensorEventListener) == null) {
            synchronized (this.f73899e) {
                this.f73899e.remove(sensorEventListener);
            }
        }
    }

    @Override // d.f.e.a.a.e
    public void b() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) && this.f73895a) {
            this.f73896b.unregisterListener(this.f73898d);
            this.f73898d = null;
            this.f73897c.quit();
            this.f73897c = null;
            this.f73895a = false;
        }
    }

    @Override // d.f.e.a.a.e
    public void b(SensorEventListener sensorEventListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, sensorEventListener) == null) {
            synchronized (this.f73899e) {
                this.f73899e.add(sensorEventListener);
            }
        }
    }

    public final Sensor h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            if (Build.MANUFACTURER.equals("HTC")) {
                return null;
            }
            return this.f73896b.getDefaultSensor(16);
        }
        return (Sensor) invokeV.objValue;
    }
}
