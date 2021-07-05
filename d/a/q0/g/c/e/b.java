package d.a.q0.g.c.e;

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
import d.a.q0.a.k;
import d.a.q0.a.v2.w;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends ActivityDelegation {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f52956d;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f52957a;

    /* renamed from: b  reason: collision with root package name */
    public JSONObject f52958b;

    /* renamed from: c  reason: collision with root package name */
    public d f52959c;

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* renamed from: d.a.q0.g.c.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class RunnableC1118b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public String f52960e;

        /* renamed from: f  reason: collision with root package name */
        public String f52961f;

        public /* synthetic */ RunnableC1118b(String str, String str2, a aVar) {
            this(str, str2);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.g.c.a.n().t(this.f52961f);
                d.a.q0.g.c.a.n().l(this.f52960e);
                d.a.q0.g.c.a.n().k();
            }
        }

        public RunnableC1118b(String str, String str2) {
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
            this.f52960e = str;
            this.f52961f = str2;
        }
    }

    /* loaded from: classes8.dex */
    public static class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public JSONObject f52962e;

        /* renamed from: f  reason: collision with root package name */
        public JSONObject f52963f;

        /* renamed from: g  reason: collision with root package name */
        public d.a.q0.g.c.f.a f52964g;

        /* renamed from: h  reason: collision with root package name */
        public Activity f52965h;

        public /* synthetic */ c(JSONObject jSONObject, JSONObject jSONObject2, d.a.q0.g.c.f.a aVar, Activity activity, a aVar2) {
            this(jSONObject, jSONObject2, aVar, activity);
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.g.c.a.n().G(this.f52963f);
                d.a.q0.g.c.i.c.a(this.f52962e.optString("packageName"), "installApp", null, null, new d.a.q0.g.c.i.a(this.f52963f));
                b.d(this.f52965h, this.f52962e, this.f52964g);
            }
        }

        public c(@NonNull JSONObject jSONObject, JSONObject jSONObject2, @NonNull d.a.q0.g.c.f.a aVar, Activity activity) {
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
            this.f52962e = jSONObject;
            this.f52963f = jSONObject2;
            this.f52964g = aVar;
            this.f52965h = activity;
        }
    }

    /* loaded from: classes8.dex */
    public class d implements d.a.q0.g.c.f.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public String f52966a;

        /* renamed from: b  reason: collision with root package name */
        public String f52967b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b f52968c;

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
            this.f52968c = bVar;
        }

        @Override // d.a.q0.g.c.f.a
        public void a(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
                this.f52967b = str;
            }
        }

        @Override // d.a.q0.g.c.f.b
        public void b(d.a.q0.g.c.g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
                if (b.f52956d) {
                    Log.d("InstallAppDelegation", "onResult mPackageName:" + this.f52966a);
                }
                this.f52968c.f(bVar);
                d.a.q0.g.c.c.b.f52916d.execute(new RunnableC1118b(this.f52967b, this.f52966a, null));
            }
        }

        @Override // d.a.q0.g.c.f.a
        public void setPackageName(String str) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
                this.f52966a = str;
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1054433314, "Ld/a/q0/g/c/e/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1054433314, "Ld/a/q0/g/c/e/b;");
                return;
            }
        }
        f52956d = k.f49133a;
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
        this.f52959c = new d(this);
    }

    public static void d(Activity activity, @NonNull JSONObject jSONObject, @NonNull d.a.q0.g.c.f.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(AdIconUtil.AD_TEXT_ID, null, activity, jSONObject, aVar) == null) {
            String optString = jSONObject.optString("url");
            boolean optBoolean = jSONObject.optBoolean("baiduAppDownload");
            String optString2 = jSONObject.optString("packageName");
            if (d.a.q0.g.c.a.n().y(optString) == null && optBoolean) {
                if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
                    return;
                }
                d.a.q0.h.t.a.c().d(optString, optString2);
                return;
            }
            d.a.q0.g.c.a.n().r(activity, optString, optString2, aVar);
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (this.f52959c != null) {
                d.a.q0.g.c.a.n().B(this.f52957a, this.f52959c);
                this.f52959c = null;
            }
            this.f52959c = null;
        }
    }

    public final void f(d.a.q0.g.c.g.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            if (bVar != null) {
                this.mResult.putString("functionType", bVar.a());
                this.mResult.putString("resultData", bVar.b());
                this.mResult.putInt(l.f1990a, bVar.c());
                if (!bVar.d()) {
                    d.a.q0.g.c.i.c.a(this.f52957a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(bVar.c()), new d.a.q0.g.c.i.a(this.f52958b));
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
            if (f52956d) {
                Log.d("InstallAppDelegation", "onAgentDestroy mPackageName:" + this.f52957a);
            }
            e();
        }
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public boolean onExec() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            if (f52956d) {
                Log.d("InstallAppDelegation", "onExec mParams" + this.mParams);
            }
            this.f52958b = w.d(this.mParams.getString("ubc_params", ""));
            JSONObject d2 = w.d(this.mParams.getString("data", ""));
            String optString = d2.optString("packageName");
            this.f52957a = optString;
            this.mResult.putString("packageName", optString);
            d.a.q0.g.c.c.b.f52916d.execute(new c(d2, this.f52958b, this.f52959c, getAgent(), null));
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.searchbox.process.ipc.delegate.activity.ActivityDelegation
    public void onSelfFinish() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            if (f52956d) {
                Log.d("InstallAppDelegation", "onSelfFinish mPackageName:" + this.f52957a);
            }
            d.a.q0.g.c.i.c.a(this.f52957a, "installApp", com.baidu.pass.biometrics.face.liveness.b.a.g0, String.valueOf(getAgent() instanceof InstallPluginDelegateActivity ? ((InstallPluginDelegateActivity) getAgent()).getErrorCode() : 31003), new d.a.q0.g.c.i.a(this.f52958b));
            e();
        }
    }
}
