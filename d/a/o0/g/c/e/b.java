package d.a.o0.g.c.e;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.alipay.sdk.util.l;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation;
import com.baidu.swan.gamecenter.appmanager.install.InstallPluginDelegateActivity;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.k;
import d.a.o0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f50158d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50159a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f50160b;

    /* renamed from: c  reason: collision with root package name */
    public d f50161c;

    /* loaded from: classes7.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.o0.g.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class RunnableC1076b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f50162e;

        /* renamed from: f  reason: collision with root package name */
        public String f50163f;

        public /* synthetic */ RunnableC1076b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.g.c.a.n().t(this.f50163f);
                d.a.o0.g.c.a.n().l(this.f50162e);
                d.a.o0.g.c.a.n().k();
            }
        }

        public RunnableC1076b(String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50162e = str;
            this.f50163f = str2;
        }
    }

    /* loaded from: classes7.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f50164e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f50165f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.o0.g.c.f.a f50166g;

        /* renamed from: h  reason: collision with root package name */
        public Activity f50167h;

        public /* synthetic */ c(JSONObject jSONObject, JSONObject jSONObject2, d.a.o0.g.c.f.a aVar, Activity activity, a aVar2) {
            this(jSONObject, jSONObject2, aVar, activity);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.g.c.a.n().G(this.f50165f);
                d.a.o0.g.c.i.c.a(this.f50164e.optString("packageName"), "installApp", null, null, new d.a.o0.g.c.i.a(this.f50165f));
                b.d(this.f50167h, this.f50164e, this.f50166g);
            }
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.a.o0.g.c.f.a aVar, Activity activity) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {jSONObject, jSONObject2, aVar, activity};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50164e = jSONObject;
            this.f50165f = jSONObject2;
            this.f50166g = aVar;
            this.f50167h = activity;
        }
    }

    /* loaded from: classes7.dex */
    public class d implements d.a.o0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f50168a;

        /* renamed from: b  reason: collision with root package name */
        public String f50169b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f50170c;

        public d(b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50170c = bVar;
        }

        @Override // d.a.o0.g.c.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f50169b = str;
            }
        }

        @Override // d.a.o0.g.c.f.b
        public void b(d.a.o0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (b.f50158d) {
                    Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f50168a);
                }
                this.f50170c.f(bVar);
                d.a.o0.g.c.c.b.f50118d.execute(new RunnableC1076b(this.f50169b, this.f50168a, null));
            }
        }

        @Override // d.a.o0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f50168a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(353368736, "Ld/a/o0/g/c/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(353368736, "Ld/a/o0/g/c/e/b;");
                return;
            }
        }
        f50158d = k.f46335a;
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
        this.f50161c = new d(this);
    }

    public static void d(Activity activity, @NonNull JSONObject jSONObject, @NonNull d.a.o0.g.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, activity, jSONObject, aVar) == null) {
            String optString = jSONObject.optString("url");
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString2 = jSONObject.optString("packageName");
            if (d.a.o0.g.c.a.n().y(optString) == null && optBoolean) {
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return;
                }
                d.a.o0.h.t.a.c().d(optString, optString2);
                return;
            }
            d.a.o0.g.c.a.n().r(activity, optString, optString2, aVar);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f50161c != null) {
                d.a.o0.g.c.a.n().B(this.f50159a, this.f50161c);
                this.f50161c = null;
            }
            this.f50161c = null;
        }
    }

    public final void f(d.a.o0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            if (bVar != null) {
                this.mResult.putString("functionType", bVar.a());
                this.mResult.putString("resultData", bVar.b());
                this.mResult.putInt(l.f2024a, bVar.c());
                if (!bVar.d()) {
                    d.a.o0.g.c.i.c.a(this.f50159a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new d.a.o0.g.c.i.a(this.f50160b));
                }
            }
            e();
            finish();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onAgentDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            if (f50158d) {
                Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f50159a);
            }
            e();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f50158d) {
                Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
            }
            this.f50160b = w.d(this.mParams.getString("ubc_params", ""));
            JSONObject d2 = w.d(this.mParams.getString("data", ""));
            String optString = d2.optString("packageName");
            this.f50159a = optString;
            this.mResult.putString("packageName", optString);
            d.a.o0.g.c.c.b.f50118d.execute(new c(d2, this.f50160b, this.f50161c, getAgent(), null));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f50158d) {
                Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f50159a);
            }
            d.a.o0.g.c.i.c.a(this.f50159a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(getAgent() instanceof InstallPluginDelegateActivity ? ((InstallPluginDelegateActivity) getAgent()).getErrorCode() : 31003), new d.a.o0.g.c.i.a(this.f50160b));
            e();
        }
    }
}
