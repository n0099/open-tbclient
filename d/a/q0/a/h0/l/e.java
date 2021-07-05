package d.a.q0.a.h0.l;

import android.app.Activity;
import android.content.Context;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.h0.u.g;
import d.a.q0.a.k;
import d.a.q0.a.l0.j;
import java.io.File;
import java.io.IOException;
/* loaded from: classes8.dex */
public class e implements d.a.q0.a.h0.l.a {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean j;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public d f48157e;

    /* renamed from: f  reason: collision with root package name */
    public String f48158f;

    /* renamed from: g  reason: collision with root package name */
    public String f48159g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f48160h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f48161i;

    /* loaded from: classes8.dex */
    public class a implements V8EngineConfiguration.JSCacheCallback {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48162a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f48163b;

        public a(e eVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48163b = eVar;
            this.f48162a = str;
        }

        @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
        public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, cacheInfo) == null) {
                if (e.j) {
                    Log.d("V8MasterAdapter", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                }
                if (!cacheInfo.cached || TextUtils.isEmpty(cacheInfo.jsPath)) {
                    return;
                }
                File file = new File(cacheInfo.jsPath);
                try {
                    if (file.getPath().startsWith(new File(this.f48162a).getCanonicalPath())) {
                        this.f48163b.f48160h = true;
                    } else if (!TextUtils.isEmpty(this.f48163b.f48159g) && file.getCanonicalPath().startsWith(new File(this.f48163b.f48159g).getCanonicalPath())) {
                        this.f48163b.f48161i = true;
                    }
                } catch (IOException e2) {
                    if (e.j) {
                        e2.printStackTrace();
                    }
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements j {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.b f48164a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f48165b;

        public b(e eVar, d.a.q0.a.h0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48165b = eVar;
            this.f48164a = bVar;
        }

        @Override // d.a.q0.a.l0.j
        public void a(d.a.q0.a.l0.a aVar) {
            d.a.q0.a.h0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || (bVar = this.f48164a) == null) {
                return;
            }
            bVar.a(this.f48165b.f48158f);
        }
    }

    /* loaded from: classes8.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48166e;

        public c(e eVar, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eVar, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48166e = i2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                try {
                    Process.setThreadPriority(this.f48166e);
                } catch (Throwable th) {
                    d.a.q0.a.e0.d.b("V8MasterAdapter", th.getMessage());
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(705566279, "Ld/a/q0/a/h0/l/e;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(705566279, "Ld/a/q0/a/h0/l/e;");
                return;
            }
        }
        j = k.f49133a;
    }

    public e(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // d.a.q0.a.h0.l.a
    public void D(d.a.q0.a.h0.u.a aVar) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, aVar) == null) || aVar == null) {
            return;
        }
        if (j) {
            Log.d("V8MasterAdapter", "pathList item: " + aVar.f48536b);
        }
        String str = aVar.f48536b;
        this.f48159g = str;
        this.f48157e.j(d.a.q0.a.h0.d.a.a("appjs", str));
    }

    @Override // d.a.q0.a.h0.l.a
    public String b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            d dVar = this.f48157e;
            if (dVar != null) {
                return dVar.g();
            }
            if (j) {
                Log.d("V8MasterAdapter", Log.getStackTraceString(new Exception("illegal state")));
                return "";
            }
            return "";
        }
        return (String) invokeV.objValue;
    }

    @Override // d.a.q0.a.h0.l.a
    public void c(d.a.q0.a.h0.b bVar) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) || (dVar = this.f48157e) == null) {
            return;
        }
        dVar.k(new b(this, bVar));
    }

    @Override // d.a.q0.a.h0.l.a
    public void destroy() {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048579, this) == null) || (dVar = this.f48157e) == null) {
            return;
        }
        dVar.f();
    }

    @Override // d.a.q0.a.h0.l.a
    public void e(Activity activity) {
        d dVar;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, activity) == null) || (dVar = this.f48157e) == null) {
            return;
        }
        dVar.d(activity);
    }

    @Override // d.a.q0.a.h0.l.a
    public d.a.q0.a.h0.f.a g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.f48157e.h() : (d.a.q0.a.h0.f.a) invokeV.objValue;
    }

    public d j(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, str)) == null) ? new d(str, "runtime/index.js") : (d) invokeL.objValue;
    }

    public int k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) ? d.a.q0.a.h0.d.a.b(this.f48160h, this.f48161i) : invokeV.intValue;
    }

    @Override // d.a.q0.a.h0.l.a
    public void loadUrl(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            if (this.f48157e == null) {
                String U = g.N().U();
                d j2 = j(U);
                this.f48157e = j2;
                this.f48158f = str;
                j2.i(new a(this, U));
            } else if (j) {
                Log.e("V8MasterAdapter", Log.getStackTraceString(new Exception("same instance loadUrl should not be call twice.")));
            }
        }
    }

    @Override // d.a.q0.a.h0.l.a
    @AnyThread
    public void r(int i2) {
        d dVar;
        d.a.q0.a.l0.a h2;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048585, this, i2) == null) || (dVar = this.f48157e) == null || (h2 = dVar.h()) == null) {
            return;
        }
        h2.runOnJSThread(new c(this, i2));
    }
}
