package d.a.q0.g.c.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.delegate.DelegateListener;
import com.baidu.searchbox.process.ipc.delegate.DelegateResult;
import com.baidu.searchbox.process.ipc.delegate.DelegateUtils;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.gamecenter.appmanager.download.AppDownloadNetworkStateReceiver;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.k;
import d.a.q0.a.v2.w;
import java.lang.ref.WeakReference;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d.a.q0.g.f.a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f52915c;

    /* renamed from: d  reason: collision with root package name */
    public static ExecutorService f52916d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements DelegateListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f52917a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f52918b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.u0.b f52919c;

        public a(b bVar, String str, String str2, d.a.q0.a.u0.b bVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, str2, bVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52917a = str;
            this.f52918b = str2;
            this.f52919c = bVar2;
        }

        @Override // com.baidu.searchbox.process.ipc.delegate.DelegateListener
        public void onDelegateCallBack(@NonNull DelegateResult delegateResult) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, delegateResult) == null) {
                if (b.f52915c) {
                    Log.d("appManagerAction", "InstallAppDelegation onDelegateCallBack isOk:" + delegateResult.isOk() + ",packageName：" + this.f52917a + ",result:" + delegateResult.mResult);
                }
                String string = delegateResult.mResult.getString("packageName");
                if (!TextUtils.isEmpty(this.f52917a) && !TextUtils.equals(this.f52917a, string)) {
                    if (d.a.q0.g.c.e.a.h(AppRuntime.getAppContext(), this.f52917a)) {
                        if (!TextUtils.isEmpty(this.f52918b)) {
                            d.a.q0.g.c.i.c.a(this.f52917a, this.f52918b, "success", "", null);
                        }
                        this.f52919c.a(new JSONObject());
                        return;
                    }
                    if (!TextUtils.isEmpty(this.f52918b)) {
                        d.a.q0.g.c.i.c.a(this.f52917a, this.f52918b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                    }
                    this.f52919c.onFail(31003, "apk install cancel");
                } else if (!delegateResult.isOk()) {
                    if (!TextUtils.isEmpty(this.f52918b)) {
                        d.a.q0.g.c.i.c.a(this.f52917a, this.f52918b, com.baidu.pass.biometrics.face.liveness.b.a.g0, "", null);
                    }
                    this.f52919c.onFail(31003, "apk install cancel");
                } else {
                    d.a.q0.g.c.a.n().t(this.f52917a);
                    b.g(delegateResult.mResult, this.f52919c);
                }
            }
        }
    }

    /* renamed from: d.a.q0.g.c.c.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C1116b extends d.a.q0.a.v1.a.b.c.c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: c  reason: collision with root package name */
        public String f52920c;

        /* renamed from: d  reason: collision with root package name */
        public String f52921d;

        /* renamed from: e  reason: collision with root package name */
        public d.a.q0.a.u0.b f52922e;

        public C1116b(String str, String str2, d.a.q0.a.u0.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52921d = str;
            this.f52920c = str2;
            this.f52922e = bVar;
        }

        @Override // d.a.q0.a.v1.a.b.c.a
        public long a() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return 0L;
            }
            return invokeV.longValue;
        }

        @Override // d.a.q0.a.v1.a.b.c.a
        public boolean c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                return true;
            }
            return invokeV.booleanValue;
        }

        public final void e() {
            d.a.q0.a.u0.b bVar;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) || (bVar = this.f52922e) == null) {
                return;
            }
            bVar.onFail(31018, "download process is killed");
            b.e(this.f52921d, this.f52920c, 31018);
            this.f52922e = null;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v1.a.b.c.c, d.a.q0.a.v1.a.b.c.a
        public void onEvent(@NonNull d.a.q0.a.v1.a.b.a.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048579, this, bVar) == null) {
                Bundle a2 = bVar.a();
                d.a.q0.a.u0.b bVar2 = this.f52922e;
                if (bVar2 == null) {
                    return;
                }
                if (a2 != null) {
                    b.g(a2, bVar2);
                } else {
                    bVar2.onFail(1001, "");
                }
            }
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public WeakReference<C1116b> f52923e;

        public c(C1116b c1116b) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c1116b};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52923e = new WeakReference<>(c1116b);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (b.f52915c) {
                    Log.d("appManagerAction", "onConnectionDown");
                }
                if (this.f52923e.get() != null) {
                    this.f52923e.get().e();
                }
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1054373732, "Ld/a/q0/g/c/c/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1054373732, "Ld/a/q0/g/c/c/b;");
                return;
            }
        }
        f52915c = k.f49133a;
        f52916d = Executors.newSingleThreadExecutor();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b() {
        super("appDownloadManager");
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((String) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void e(String str, String str2, int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(AdIconUtil.AD_TEXT_ID, null, str, str2, i2) == null) {
            d.a.q0.g.c.i.c.a(str, str2, com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(i2), null);
        }
    }

    public static void g(@NonNull Bundle bundle, @NonNull d.a.q0.a.u0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(AdIconUtil.BAIDU_LOGO_ID, null, bundle, bVar) == null) {
            String string = bundle.getString("functionType");
            if (string == null) {
                bVar.onFail(1001, "");
                return;
            }
            String string2 = bundle.getString("resultData", "");
            int i2 = bundle.getInt(l.f1990a, 1001);
            if (f52915c) {
                Log.d("appManagerAction", "handleResult:function = " + string + ",result = " + string2);
            }
            char c2 = 65535;
            int hashCode = string.hashCode();
            if (hashCode != -1013362275) {
                if (hashCode == -530890460 && string.equals("onSuccess")) {
                    c2 = 0;
                }
            } else if (string.equals("onFail")) {
                c2 = 1;
            }
            if (c2 == 0) {
                bVar.a(w.d(string2));
            } else if (c2 != 1) {
            } else {
                bVar.onFail(i2, string2);
            }
        }
    }

    @Override // d.a.q0.g.f.a
    public d.a.q0.a.u.h.b a(@NonNull JSONObject jSONObject, @NonNull d.a.q0.a.u0.b bVar) {
        InterceptResult invokeLL;
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, jSONObject, bVar)) == null) {
            if (f52915c) {
                Log.d("appManagerAction", "handle: " + jSONObject);
            }
            String optString = jSONObject.optString(AppDownloadNetworkStateReceiver.KEY_OPERATION);
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            if (optJSONObject != null) {
                str = optJSONObject.optString("packageName");
                str2 = optJSONObject.optString("installSource");
            } else {
                str = null;
                str2 = null;
            }
            Bundle bundle = new Bundle();
            bundle.putString(AppDownloadNetworkStateReceiver.KEY_OPERATION, optString);
            bundle.putString("data", optJSONObject == null ? "" : optJSONObject.toString());
            bundle.putString("ubc_params", new d.a.q0.g.c.i.a().a());
            if (TextUtils.equals(optString, "installApp")) {
                if (!TextUtils.isEmpty(str2)) {
                    d.a.q0.g.c.i.c.a(str, str2, "start", "", null);
                }
                f(bundle, str, str2, bVar);
                return null;
            }
            d.a.q0.a.v1.c.e.a z = d.a.q0.a.a2.d.g().z();
            if (z != null) {
                C1116b c1116b = new C1116b(str, optString, bVar);
                z.L(bundle, d.a.q0.g.c.d.e.class, c1116b);
                z.J(new c(c1116b));
            }
            return null;
        }
        return (d.a.q0.a.u.h.b) invokeLL.objValue;
    }

    public final void f(@NonNull Bundle bundle, @Nullable String str, String str2, @NonNull d.a.q0.a.u0.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bundle, str, str2, bVar) == null) {
            SwanAppActivity x = d.a.q0.a.a2.d.g().x();
            if (x == null) {
                bVar.onFail(1001, "");
            } else if (d.a.q0.g.c.e.a.h(AppRuntime.getAppContext(), str)) {
                bVar.a(new JSONObject());
            } else {
                if (f52915c) {
                    Log.d("appManagerAction", "InstallAppDelegation handleInstall");
                }
                DelegateUtils.callOnMainWithActivity(x, InstallPluginDelegateActivity.class, d.a.q0.g.c.e.b.class, bundle, new a(this, str, str2, bVar));
            }
        }
    }
}
