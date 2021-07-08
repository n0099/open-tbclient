package d.a.n0.h.b0;

import android.app.Activity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.activity.BaseActivity;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.process.SwanAppProcessInfo;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.a.a2.d;
import d.a.n0.a.a2.e;
import d.a.n0.a.f1.e.b;
import d.a.n0.a.k;
import d.a.n0.a.v2.q0;
import d.a.n0.a.z1.b.b.h;
import d.a.n0.f.g;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f49782b;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public h f49783a;

    /* renamed from: d.a.n0.h.b0.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC1079a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ SwanAppActivity f49784e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f49785f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.y.b.a f49786g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f49787h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ a f49788i;

        public RunnableC1079a(a aVar, SwanAppActivity swanAppActivity, String str, d.a.n0.a.y.b.a aVar2, d.a.n0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, swanAppActivity, str, aVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49788i = aVar;
            this.f49784e = swanAppActivity;
            this.f49785f = str;
            this.f49786g = aVar2;
            this.f49787h = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                this.f49788i.f(this.f49784e, this.f49785f, this.f49786g, this.f49787h);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class b implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.y.b.a f49789e;

        public b(a aVar, d.a.n0.a.y.b.a aVar2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49789e = aVar2;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                d.a.n0.h.m0.c.a(this.f49789e, true, new d.a.n0.h.b0.c(false));
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements DialogInterface.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.y.b.a f49790e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.f1.e.b f49791f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ a f49792g;

        public c(a aVar, d.a.n0.a.y.b.a aVar2, d.a.n0.a.f1.e.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, aVar2, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f49792g = aVar;
            this.f49790e = aVar2;
            this.f49791f = bVar;
        }

        @Override // android.content.DialogInterface.OnClickListener
        public void onClick(DialogInterface dialogInterface, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLI(1048576, this, dialogInterface, i2) == null) {
                d.a.n0.h.m0.c.a(this.f49790e, true, new d.a.n0.h.b0.c(true));
                this.f49792g.e(this.f49791f);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1676474580, "Ld/a/n0/h/b0/a;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1676474580, "Ld/a/n0/h/b0/a;");
                return;
            }
        }
        f49782b = k.f45831a;
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
            }
        }
    }

    public final void c(d.a.n0.a.y.b.a aVar, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, aVar, str) == null) {
            d.a.n0.h.d.c.b bVar = new d.a.n0.h.d.c.b();
            bVar.errMsg = str;
            d.a.n0.h.m0.c.a(aVar, false, bVar);
        }
    }

    public void d(JsObject jsObject) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jsObject) == null) {
            d.a.n0.a.y.b.a G = d.a.n0.a.y.b.a.G(jsObject);
            if (G == null) {
                G = new d.a.n0.a.y.b.a();
            }
            d.a.n0.a.y.b.a aVar = G;
            e r = d.g().r();
            if (!r.e()) {
                c(aVar, "reload failed, api internal error.");
                return;
            }
            SwanAppActivity x = r.x();
            b.a L = r.L();
            if (x == null) {
                c(aVar, "reload failed, api internal error.");
                return;
            }
            String C = aVar.C("content");
            if (TextUtils.isEmpty(C)) {
                C = x.getString(g.aiapps_game_reload_dialog_content);
            }
            q0.b0(new RunnableC1079a(this, x, C, aVar, L));
        }
    }

    public final void e(@NonNull d.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, bVar) == null) {
            String H = bVar.H();
            String e1 = d.a.n0.a.f1.e.c.e1(bVar.H(), bVar.T(), bVar.G());
            Bundle bundle = new Bundle();
            bundle.putString(BaseActivity.EXTRA_PARAM_THIRD_VERIFY_APP_ID, H);
            bundle.putString("scheme", e1);
            bundle.putInt("target", SwanAppProcessInfo.current().index);
            if (f49782b) {
                Log.d("SwanGameReloadApi", "reload-appid:" + bVar.H());
            }
            d.a.n0.a.v1.c.e.a.E().K(bundle, d.a.n0.h.b0.b.class);
        }
    }

    public final void f(@NonNull Activity activity, @NonNull String str, @NonNull d.a.n0.a.y.b.a aVar, @NonNull d.a.n0.a.f1.e.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048579, this, activity, str, aVar, bVar) == null) {
            h hVar = this.f49783a;
            if (hVar != null && hVar.isShowing()) {
                c(aVar, "reload failed, the reload dialog has been displayed.");
                return;
            }
            h.a aVar2 = new h.a(activity);
            aVar2.U(g.aiapps_game_reload_dialog_title);
            aVar2.x(str);
            aVar2.a();
            aVar2.n(new d.a.n0.a.w2.h.a());
            aVar2.m(false);
            aVar2.B(g.aiapps_cancel, new b(this, aVar));
            aVar2.O(g.aiapps_ok, new c(this, aVar, bVar));
            this.f49783a = aVar2.X();
        }
    }
}
