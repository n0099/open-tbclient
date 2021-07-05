package d.a.q0.a.u.e.p;

import android.app.Activity;
import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.e2.c.i;
import d.a.q0.a.e2.c.j.b;
import d.a.q0.a.f1.e.b;
import d.a.q0.a.f2.a;
import d.a.q0.a.k;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;

    /* renamed from: d  reason: collision with root package name */
    public static final boolean f51122d;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements d.a.q0.a.v2.e1.b<i<b.e>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f51123e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.a2.e f51124f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ b f51125g;

        public a(b bVar, String str, d.a.q0.a.a2.e eVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bVar, str, eVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51125g = bVar;
            this.f51123e = str;
            this.f51124f = eVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.q0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(i<b.e> iVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, iVar) == null) {
                if (d.a.q0.a.e2.c.d.h(iVar)) {
                    if (b.f51122d) {
                        Log.d("Api-AddToDesktop", "start add to desktop");
                    }
                    this.f51125g.u(this.f51124f.x(), this.f51124f);
                    this.f51125g.d(this.f51123e, new d.a.q0.a.u.h.b(0));
                    return;
                }
                int b2 = iVar.b();
                this.f51125g.d(this.f51123e, new d.a.q0.a.u.h.b(b2, d.a.q0.a.e2.c.d.f(b2)));
            }
        }
    }

    /* renamed from: d.a.q0.a.u.e.p.b$b  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class C0987b implements a.f {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public C0987b(b bVar) {
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
                }
            }
        }

        @Override // d.a.q0.a.f2.a.f
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                b.w(i2);
            }
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2111529771, "Ld/a/q0/a/u/e/p/b;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-2111529771, "Ld/a/q0/a/u/e/p/b;");
                return;
            }
        }
        f51122d = k.f49133a;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(@NonNull d.a.q0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
    }

    public static void w(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(AdIconUtil.AD_TEXT_ID, null, i2) == null) {
            d.a.q0.a.j2.p.f fVar = new d.a.q0.a.j2.p.f();
            d.a.q0.a.a2.d g2 = d.a.q0.a.a2.d.g();
            String appId = g2.getAppId();
            String m = d.a.q0.a.j2.k.m(g2.l());
            fVar.f49124f = appId;
            fVar.f49120b = RetrieveTaskManager.KEY;
            fVar.f49119a = m;
            fVar.f49123e = "addshortcut";
            b.a L = g2.r().L();
            if (L != null) {
                fVar.f49121c = L.T();
            }
            fVar.a("appid", appId);
            fVar.a("resultstate", Integer.valueOf(i2));
            d.a.q0.a.j2.d.b(fVar);
        }
    }

    public final void u(@NonNull Context context, @NonNull d.a.q0.a.a2.e eVar) {
        b.a N;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048576, this, context, eVar) == null) || (N = eVar.N()) == null) {
            return;
        }
        d.a.q0.a.f2.a.k(context, N, new C0987b(this));
    }

    public d.a.q0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (f51122d) {
                Log.d("Api-AddToDesktop", "start addToDesktop action, params = " + str);
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-AddToDesktop", str);
            if (!((d.a.q0.a.u.h.b) b2.first).isSuccess()) {
                d.a.q0.a.e0.d.b("Api-AddToDesktop", "parse failed, params = " + str);
                return (d.a.q0.a.u.h.b) b2.first;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (f51122d) {
                Log.d("Api-AddToDesktop", "cb: " + optString);
            }
            if (TextUtils.isEmpty(optString)) {
                return new d.a.q0.a.u.h.b(202, "cb is required");
            }
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            Context i2 = i();
            if (!(i2 instanceof Activity) && (i2 = Q.x()) == null) {
                return new d.a.q0.a.u.h.b(1001, "the context is not an activity");
            }
            Q.T().g(i2, "scope_add_to_desktop", new a(this, optString, Q));
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }
}
