package d.a.o0.h.b0;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.unitedscheme.SchemeRouter;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.internal.Sets;
import d.a.o0.a.k;
import d.a.o0.a.n0.d;
import d.a.o0.a.n0.f;
import d.a.o0.a.v1.c.f.e;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class b extends d.a.o0.a.v1.a.a.a implements d.a.o0.a.v1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f50297g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f50298h;

    /* renamed from: i  reason: collision with root package name */
    public static long f50299i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f50300f;

    /* loaded from: classes7.dex */
    public class a implements h.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f50301e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f50302f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f50303g;

        public a(b bVar, boolean z, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, Boolean.valueOf(z), bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50303g = bVar;
            this.f50301e = z;
            this.f50302f = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f50301e) {
                    if (b.f50297g) {
                        Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + b.f50299i);
                    }
                    e.k().c(this.f50303g, b.f50299i);
                }
                d d2 = f.c().d();
                if (d2 != null) {
                    List<String> singletonList = Collections.singletonList(this.f50302f.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                    d.a.o0.a.n0.l.c l = d.a.o0.a.n0.l.c.l();
                    l.i(6);
                    d2.h(singletonList, true, l.k());
                }
                if (b.f50297g) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + d2);
                }
                if (this.f50301e) {
                    return;
                }
                this.f50303g.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1872988054, "Ld/a/o0/h/b0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1872988054, "Ld/a/o0/h/b0/b;");
                return;
            }
        }
        f50297g = k.f46335a;
        f50298h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");
        f50299i = TimeUnit.SECONDS.toMillis(10L);
    }

    public b() {
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
        this.f50300f = SwanAppProcessInfo.UNKNOWN.index;
    }

    @Override // d.a.o0.a.v1.c.f.a
    public void a(String str, d.a.o0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar.f48461f.index == this.f50300f && f50298h.contains(str)) {
            e.k().h(this);
            if (f50297g) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            h();
        }
    }

    @Override // d.a.o0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
            this.f50300f = i2;
            boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
            if (f50297g) {
                Log.i("SwanGameReloadDelegate", "execCall: target = " + this.f50300f);
                Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
            }
            h.d.i("").o(Schedulers.io()).B(new a(this, checkProcessId, bundle));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String string = this.f48399a.getString("scheme");
            if (f50297g) {
                Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }

    @Override // d.a.o0.a.v1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f50297g) {
                Log.i("SwanGameReloadDelegate", "timeout");
            }
            h();
        }
    }
}
