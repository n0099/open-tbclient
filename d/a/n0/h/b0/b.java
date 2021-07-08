package d.a.n0.h.b0;

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
import d.a.n0.a.k;
import d.a.n0.a.n0.d;
import d.a.n0.a.n0.f;
import d.a.n0.a.v1.c.f.e;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes7.dex */
public class b extends d.a.n0.a.v1.a.a.a implements d.a.n0.a.v1.c.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: g  reason: collision with root package name */
    public static final boolean f49793g;

    /* renamed from: h  reason: collision with root package name */
    public static final Set<String> f49794h;

    /* renamed from: i  reason: collision with root package name */
    public static long f49795i;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: f  reason: collision with root package name */
    public int f49796f;

    /* loaded from: classes7.dex */
    public class a implements h.n.b<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f49797e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ Bundle f49798f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f49799g;

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
            this.f49799g = bVar;
            this.f49797e = z;
            this.f49798f = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // h.n.b
        /* renamed from: a */
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                if (this.f49797e) {
                    if (b.f49793g) {
                        Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + b.f49795i);
                    }
                    e.k().c(this.f49799g, b.f49795i);
                }
                d d2 = f.c().d();
                if (d2 != null) {
                    List<String> singletonList = Collections.singletonList(this.f49798f.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                    d.a.n0.a.n0.l.c l = d.a.n0.a.n0.l.c.l();
                    l.i(6);
                    d2.h(singletonList, true, l.k());
                }
                if (b.f49793g) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + d2);
                }
                if (this.f49797e) {
                    return;
                }
                this.f49799g.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1676474549, "Ld/a/n0/h/b0/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1676474549, "Ld/a/n0/h/b0/b;");
                return;
            }
        }
        f49793g = k.f45831a;
        f49794h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");
        f49795i = TimeUnit.SECONDS.toMillis(10L);
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
        this.f49796f = SwanAppProcessInfo.UNKNOWN.index;
    }

    @Override // d.a.n0.a.v1.c.f.a
    public void a(String str, d.a.n0.a.v1.c.f.c cVar) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, cVar) == null) && cVar.f47957f.index == this.f49796f && f49794h.contains(str)) {
            e.k().h(this);
            if (f49793g) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            h();
        }
    }

    @Override // d.a.n0.a.v1.a.a.a
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
            this.f49796f = i2;
            boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
            if (f49793g) {
                Log.i("SwanGameReloadDelegate", "execCall: target = " + this.f49796f);
                Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
            }
            h.d.i("").o(Schedulers.io()).B(new a(this, checkProcessId, bundle));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String string = this.f47895a.getString("scheme");
            if (f49793g) {
                Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }

    @Override // d.a.n0.a.v1.c.f.a
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (f49793g) {
                Log.i("SwanGameReloadDelegate", "timeout");
            }
            h();
        }
    }
}
