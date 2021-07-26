package d.a;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.mobads.sdk.api.BDAdConfig;
import com.baidu.mobads.sdk.api.MobadsPermissionSettings;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.f0.b.f;
import d.a.f0.b.g.g;
import d.a.i0.a.g.d;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: f  reason: collision with root package name */
    public static final a f41047f;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public volatile boolean f41048a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.f0.b.a f41049b;

    /* renamed from: c  reason: collision with root package name */
    public long f41050c;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f41051d;

    /* renamed from: e  reason: collision with root package name */
    public final ArrayList<d> f41052e;

    /* renamed from: d.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes6.dex */
    public class RunnableC0541a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f41053e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ a f41054f;

        public RunnableC0541a(a aVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f41054f = aVar;
            this.f41053e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f41053e != 1 || ((float) (System.currentTimeMillis() - this.f41054f.f41050c)) >= g.d() * 60000.0f) {
                    if (this.f41054f.f41049b == null) {
                        this.f41054f.f41049b = new d.a.f0.b.a();
                    }
                    this.f41054f.f41049b.l(d.a.f0.a.b.a.f42713a.get());
                    this.f41054f.f41050c = System.currentTimeMillis();
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public interface b {
        void onFailed();

        void onSuccess();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1640061567, "Ld/a/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1640061567, "Ld/a/a;");
                return;
            }
        }
        f41047f = new a();
    }

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f41048a = false;
        this.f41051d = new Handler(Looper.myLooper());
        this.f41052e = new ArrayList<>();
    }

    public static a f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, null)) == null) ? f41047f : (a) invokeV.objValue;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f41052e.clear();
        }
    }

    public void g(d.a.f0.a.b.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, aVar) == null) {
            if (aVar == null) {
                Log.e("SplashAdFacade", "appContext is null ,init failed");
                return;
            }
            d.a.f0.a.b.a.f42713a.set(aVar);
            aVar.o().registerActivityLifecycleCallbacks(new f());
            new BDAdConfig.Builder().setAppName(aVar.u()).setAppsid(aVar.r()).build(aVar.o()).init();
            MobadsPermissionSettings.setPermissionReadDeviceID(true);
            MobadsPermissionSettings.setPermissionLocation(true);
            MobadsPermissionSettings.setPermissionStorage(true);
            MobadsPermissionSettings.setPermissionAppList(true);
        }
    }

    public boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.f41048a : invokeV.booleanValue;
    }

    public void i(int i2) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048579, this, i2) == null) || d.a.f0.a.b.a.f42713a.get() == null) {
            return;
        }
        this.f41051d.postDelayed(new RunnableC0541a(this, i2), 5000L);
    }
}
