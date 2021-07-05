package d.a.q0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class c extends d.a.q0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes8.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.g.d f50854e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50855f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50856g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f50857h;

        public a(c cVar, d.a.q0.a.h0.g.d dVar, String str, String str2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, str2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50857h = cVar;
            this.f50854e = dVar;
            this.f50855f = str;
            this.f50856g = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.h0.g.d dVar = this.f50854e;
                boolean z = true;
                if (!((dVar == null || !dVar.o2(this.f50855f, true)) ? false : false)) {
                    d.a.q0.a.e0.d.b("Api-NavigationBar", "set title fail");
                    this.f50857h.d(this.f50856g, new d.a.q0.a.u.h.b(1001));
                }
                this.f50857h.d(this.f50856g, new d.a.q0.a.u.h.b(0));
            }
        }
    }

    /* loaded from: classes8.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.g.d f50858e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50859f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f50860g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f50861h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ JSONObject f50862i;
        public final /* synthetic */ c j;

        public b(c cVar, d.a.q0.a.h0.g.d dVar, String str, String str2, String str3, JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, str2, str3, jSONObject};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.j = cVar;
            this.f50858e = dVar;
            this.f50859f = str;
            this.f50860g = str2;
            this.f50861h = str3;
            this.f50862i = jSONObject;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.h0.g.d dVar = this.f50858e;
                if (dVar != null && dVar.v2(this.f50859f, true)) {
                    if (!this.f50858e.m2(SwanAppConfigData.s(this.f50861h), true)) {
                        d.a.q0.a.e0.d.b("Api-NavigationBar", "set title background fail");
                        this.j.d(this.f50860g, new d.a.q0.a.u.h.b(1001));
                        return;
                    }
                    JSONObject jSONObject = this.f50862i;
                    if (jSONObject != null) {
                        this.f50858e.k2(jSONObject.optInt("duration"), this.f50862i.optString("timingFunc"));
                        d.a.q0.a.e0.d.g("Api-NavigationBar", "set action bar animator");
                    }
                    this.j.d(this.f50860g, new d.a.q0.a.u.h.b(0));
                    return;
                }
                d.a.q0.a.e0.d.b("Api-NavigationBar", "set title color fail");
                this.j.d(this.f50860g, new d.a.q0.a.u.h.b(1001));
            }
        }
    }

    /* renamed from: d.a.q0.a.u.e.g.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public class RunnableC0963c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.q0.a.h0.g.d f50863e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f50864f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f50865g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ c f50866h;

        public RunnableC0963c(c cVar, d.a.q0.a.h0.g.d dVar, String str, boolean z) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, dVar, str, Boolean.valueOf(z)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f50866h = cVar;
            this.f50863e = dVar;
            this.f50864f = str;
            this.f50865g = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean O1;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.q0.a.h0.g.d dVar = this.f50863e;
                if (dVar == null) {
                    d.a.q0.a.e0.d.b("Api-NavigationBar", "swanAppFragment is null");
                    this.f50866h.d(this.f50864f, new d.a.q0.a.u.h.b(1001));
                    return;
                }
                if (this.f50865g) {
                    O1 = dVar.D2();
                } else {
                    O1 = dVar.O1();
                }
                if (!O1) {
                    String str = this.f50865g ? "show" : "hide";
                    d.a.q0.a.e0.d.b("Api-NavigationBar", str + " navigation loading progressbar fail");
                    this.f50866h.d(this.f50864f, new d.a.q0.a.u.h.b(1001));
                    return;
                }
                this.f50866h.d(this.f50864f, new d.a.q0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NonNull d.a.q0.a.u.c.b bVar) {
        super(bVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((d.a.q0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public final d.a.q0.a.u.h.b r(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(1048576, this, str, z)) == null) {
            d.a.q0.a.h0.g.g W = d.a.q0.a.g1.f.V().W();
            if (W == null) {
                d.a.q0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new d.a.q0.a.u.h.b(1001);
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-NavigationBar", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    d.a.q0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            String optString = ((JSONObject) b2.second).optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.q0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new d.a.q0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new RunnableC0963c(this, W.m(), optString, z));
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeLZ.objValue;
    }

    public d.a.q0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-NavigationBar", "start hide navigation bar loading");
            }
            return r(str, false);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b t(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-NavigationBar", "set navigation bar color");
            }
            d.a.q0.a.h0.g.g W = d.a.q0.a.g1.f.V().W();
            if (W == null) {
                d.a.q0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new d.a.q0.a.u.h.b(1001);
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-NavigationBar", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    d.a.q0.a.e0.d.b("Api-NavigationBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.q0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new d.a.q0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new b(this, W.m(), jSONObject.optString("frontColor"), optString, jSONObject.optString("backgroundColor"), jSONObject.optJSONObject("animation")));
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b u(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-NavigationBar", "set navigation bar title");
            }
            Pair<d.a.q0.a.u.h.b, JSONObject> b2 = d.a.q0.a.u.i.b.b("Api-NavigationBar", str);
            d.a.q0.a.u.h.b bVar = (d.a.q0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                d.a.q0.a.e0.d.b("Api-NavigationBar", "parse fail");
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (jSONObject == null) {
                d.a.q0.a.e0.d.b("Api-NavigationBar", "paramsJson is null");
                return new d.a.q0.a.u.h.b(1001);
            }
            String optString = jSONObject.optString("title");
            d.a.q0.a.h0.g.g W = d.a.q0.a.g1.f.V().W();
            if (W == null) {
                d.a.q0.a.e0.d.b("Api-NavigationBar", "manager is null");
                return new d.a.q0.a.u.h.b(1001);
            }
            String optString2 = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString2)) {
                d.a.q0.a.e0.d.b("Api-NavigationBar", "callback is null");
                return new d.a.q0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, W.m(), optString, optString2));
            return new d.a.q0.a.u.h.b(0);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }

    public d.a.q0.a.u.h.b v(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (d.a.q0.a.u.c.d.f50740c) {
                Log.d("Api-NavigationBar", "start show navigation bar loading");
            }
            d.a.q0.a.a2.e Q = d.a.q0.a.a2.e.Q();
            if (Q != null && Q.d0()) {
                if (d.a.q0.a.u.c.d.f50740c) {
                    Log.d("Api-NavigationBar", "Api-NavigationBar does not supported when app is invisible.");
                }
                return new d.a.q0.a.u.h.b(1001, "ui operation does not supported when app is invisible.");
            }
            return r(str, true);
        }
        return (d.a.q0.a.u.h.b) invokeL.objValue;
    }
}
