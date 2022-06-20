package com.repackage;

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
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public class jz3 extends sv2 implements pw2 {
    public static /* synthetic */ Interceptable $ic;
    public static final boolean g;
    public static final Set<String> h;
    public static long i;
    public transient /* synthetic */ FieldHolder $fh;
    public int f;

    /* loaded from: classes6.dex */
    public class a implements lv9<String> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ boolean a;
        public final /* synthetic */ Bundle b;
        public final /* synthetic */ jz3 c;

        public a(jz3 jz3Var, boolean z, Bundle bundle) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jz3Var, Boolean.valueOf(z), bundle};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = jz3Var;
            this.a = z;
            this.b = bundle;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.repackage.lv9
        public void call(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.a) {
                    if (jz3.g) {
                        Log.i("SwanGameReloadDelegate", "execCall: addCallback CALLBACK_TERM = " + jz3.i);
                    }
                    tw2.k().c(this.c, jz3.i);
                }
                c82 d = e82.c().d();
                if (d != null) {
                    List<String> singletonList = Collections.singletonList(this.b.getString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID));
                    n92 l = n92.l();
                    l.i(6);
                    d.h(singletonList, true, l.k());
                }
                if (jz3.g) {
                    Log.i("SwanGameReloadDelegate", "execCall: addCallback purge finish = " + d);
                }
                if (this.a) {
                    return;
                }
                this.c.h();
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-755571410, "Lcom/repackage/jz3;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-755571410, "Lcom/repackage/jz3;");
                return;
            }
        }
        g = cg1.a;
        h = Sets.newHashSet("event_puppet_unload_app", "event_puppet_offline");
        i = TimeUnit.SECONDS.toMillis(10L);
    }

    public jz3() {
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
        this.f = SwanAppProcessInfo.UNKNOWN.index;
    }

    @Override // com.repackage.pw2
    public void a(String str, rw2 rw2Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLL(1048576, this, str, rw2Var) == null) && rw2Var.b.index == this.f && h.contains(str)) {
            tw2.k().h(this);
            if (g) {
                Log.i("SwanGameReloadDelegate", "onEvent: event = " + str);
            }
            h();
        }
    }

    @Override // com.repackage.sv2
    public void b(@NonNull Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle) == null) {
            int i2 = bundle.getInt("target", SwanAppProcessInfo.UNKNOWN.index);
            this.f = i2;
            boolean checkProcessId = SwanAppProcessInfo.checkProcessId(i2);
            if (g) {
                Log.i("SwanGameReloadDelegate", "execCall: target = " + this.f);
                Log.i("SwanGameReloadDelegate", "execCall: waitCallback = " + checkProcessId);
            }
            xu9.f("").k(Schedulers.io()).w(new a(this, checkProcessId, bundle));
        }
    }

    public final void h() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            String string = this.a.getString("scheme");
            if (g) {
                Log.i("SwanGameReloadDelegate", "invoke: scheme = " + string);
            }
            if (TextUtils.isEmpty(string)) {
                return;
            }
            SchemeRouter.invoke(AppRuntime.getAppContext(), string);
        }
    }

    @Override // com.repackage.pw2
    public void timeout() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (g) {
                Log.i("SwanGameReloadDelegate", "timeout");
            }
            h();
        }
    }
}
