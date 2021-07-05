package d.a.s0.n2;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.provider.Settings;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.n2.k;
import java.lang.ref.WeakReference;
/* loaded from: classes9.dex */
public class j {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<Activity> f64016a;

    /* renamed from: b  reason: collision with root package name */
    public SensorManager f64017b;

    /* renamed from: c  reason: collision with root package name */
    public g f64018c;

    /* renamed from: d  reason: collision with root package name */
    public Sensor f64019d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f64020e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f64021f;

    /* renamed from: g  reason: collision with root package name */
    public k f64022g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f64023h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f64024i;
    public Handler j;
    public k.a k;

    /* loaded from: classes9.dex */
    public class a extends Handler {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f64025a;

        public a(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64025a = jVar;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Activity activity;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, message) == null) || message == null || this.f64025a.f64016a == null || (activity = (Activity) this.f64025a.f64016a.get()) == null || !this.f64025a.f64024i || message.what != 1) {
                return;
            }
            int requestedOrientation = activity.getRequestedOrientation();
            int i2 = message.arg1;
            if (!this.f64025a.f64023h) {
                if (i2 > 225 && i2 < 315) {
                    if (requestedOrientation == 8) {
                        activity.setRequestedOrientation(0);
                    }
                } else if (i2 <= 45 || i2 >= 135 || requestedOrientation != 0) {
                } else {
                    activity.setRequestedOrientation(8);
                }
            } else if ((i2 > 235 && i2 < 305) || (i2 > 55 && i2 < 125)) {
                if (!this.f64025a.f64021f) {
                    if (i2 <= 55 || i2 >= 125) {
                        if (requestedOrientation != 0) {
                            activity.setRequestedOrientation(0);
                        }
                    } else if (requestedOrientation != 8) {
                        activity.setRequestedOrientation(8);
                    }
                }
                this.f64025a.f64020e = false;
            } else if ((i2 <= 325 || i2 >= 360) && (i2 < 0 || i2 >= 35)) {
            } else {
                if (!this.f64025a.f64020e && requestedOrientation != 1) {
                    activity.setRequestedOrientation(1);
                }
                this.f64025a.f64021f = false;
            }
        }
    }

    /* loaded from: classes9.dex */
    public class b implements k.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ j f64026a;

        public b(j jVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f64026a = jVar;
        }

        @Override // d.a.s0.n2.k.a
        public void a(boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
                this.f64026a.f64023h = z;
            }
        }
    }

    public j(Activity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64020e = false;
        this.f64021f = false;
        this.f64023h = false;
        this.f64024i = false;
        this.j = new a(this);
        this.k = new b(this);
        if (activity == null) {
            return;
        }
        this.f64016a = new WeakReference<>(activity);
        SensorManager sensorManager = (SensorManager) activity.getApplicationContext().getSystemService("sensor");
        this.f64017b = sensorManager;
        this.f64019d = sensorManager.getDefaultSensor(1);
        this.f64018c = new g(this.j);
        if (activity.getClass().getName().contains(SwanAppActivity.TAG)) {
            activity.setRequestedOrientation(1);
        }
    }

    public void i(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.f64024i = z;
        }
    }

    public void j() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            SensorManager sensorManager = this.f64017b;
            if (sensorManager != null) {
                sensorManager.registerListener(this.f64018c, this.f64019d, 2);
            }
            WeakReference<Activity> weakReference = this.f64016a;
            if (weakReference == null || (activity = weakReference.get()) == null) {
                return;
            }
            k kVar = new k(activity.getApplicationContext(), new Handler(Looper.getMainLooper()));
            this.f64022g = kVar;
            kVar.b(this.k);
            activity.getContentResolver().registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), true, this.f64022g);
        }
    }

    public void k() {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            SensorManager sensorManager = this.f64017b;
            if (sensorManager != null) {
                sensorManager.unregisterListener(this.f64018c);
            }
            this.j.removeCallbacksAndMessages(null);
            WeakReference<Activity> weakReference = this.f64016a;
            if (weakReference == null || this.f64022g == null || (activity = weakReference.get()) == null) {
                return;
            }
            activity.getContentResolver().unregisterContentObserver(this.f64022g);
        }
    }

    public void l() {
        WeakReference<Activity> weakReference;
        Activity activity;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (weakReference = this.f64016a) == null || (activity = weakReference.get()) == null) {
            return;
        }
        if (activity.getRequestedOrientation() == 1) {
            activity.setRequestedOrientation(0);
            this.f64020e = true;
            return;
        }
        activity.setRequestedOrientation(1);
        this.f64021f = true;
    }
}
