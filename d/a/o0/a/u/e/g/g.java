package d.a.o0.a.u.e.g;

import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.v2.q0;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class g extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48106e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f48107f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f48108g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ g f48109h;

        public a(g gVar, String str, boolean z, boolean z2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gVar, str, Boolean.valueOf(z), Boolean.valueOf(z2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48109h = gVar;
            this.f48106e = str;
            this.f48107f = z;
            this.f48108g = z2;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean j;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                d.a.o0.a.o2.b.a t = g.t();
                if (t == null) {
                    d.a.o0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                    this.f48109h.d(this.f48106e, new d.a.o0.a.u.h.b(1001));
                    return;
                }
                if (this.f48107f) {
                    j = t.r(this.f48108g);
                } else {
                    j = t.j(this.f48108g);
                }
                if (!j) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(this.f48107f ? "open" : IntentConfig.CLOSE);
                    sb.append("bottom bar fail");
                    d.a.o0.a.e0.d.b("Api-TabBar", sb.toString());
                    this.f48109h.d(this.f48106e, new d.a.o0.a.u.h.b(1001));
                }
                this.f48109h.d(this.f48106e, new d.a.o0.a.u.h.b(0));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(@NonNull d.a.o0.a.u.c.b bVar) {
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
                super((d.a.o0.a.u.c.b) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    public static d.a.o0.a.o2.b.a t() {
        InterceptResult invokeV;
        d.a.o0.a.h0.g.f l;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            d.a.o0.a.h0.g.g W = d.a.o0.a.g1.f.V().W();
            if (W == null || (l = W.l()) == null) {
                return null;
            }
            return l.i3();
        }
        return (d.a.o0.a.o2.b.a) invokeV.objValue;
    }

    public static boolean v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            d.a.o0.a.h0.g.g W = d.a.o0.a.g1.f.V().W();
            return W == null || W.o() == null || !W.o().Z1();
        }
        return invokeV.booleanValue;
    }

    public d.a.o0.a.u.h.b r(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-TabBar", "start close tab bar");
            }
            return u(str, false);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public d.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-TabBar", "handle: " + str);
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-TabBar", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    d.a.o0.a.e0.d.b("Api-TabBar", "parse fail");
                }
                return bVar;
            }
            int optInt = ((JSONObject) b2.second).optInt("index");
            if (v()) {
                d.a.o0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
                return new d.a.o0.a.u.h.b(1001, "fail not TabBar page");
            }
            d.a.o0.a.o2.b.a t = t();
            if (t == null) {
                d.a.o0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                return new d.a.o0.a.u.h.b(1001, "tabBarViewController is null");
            } else if (!t.k(optInt)) {
                d.a.o0.a.e0.d.b("Api-TabBar", "close red dot fail");
                return new d.a.o0.a.u.h.b(1001, "close red dot fail");
            } else {
                return new d.a.o0.a.u.h.b(0);
            }
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public final d.a.o0.a.u.h.b u(String str, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(Constants.METHOD_SEND_USER_MSG, this, str, z)) == null) {
            if (v()) {
                d.a.o0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
                return new d.a.o0.a.u.h.b(1001, "fail not TabBar page");
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-TabBar", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    d.a.o0.a.e0.d.b("Api-TabBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            String optString = jSONObject.optString("cb");
            if (TextUtils.isEmpty(optString)) {
                d.a.o0.a.e0.d.b("Api-TabBar", "callback is null");
                return new d.a.o0.a.u.h.b(1001, "callback is null");
            }
            q0.b0(new a(this, optString, z, jSONObject.optBoolean("animation")));
            return new d.a.o0.a.u.h.b(0);
        }
        return (d.a.o0.a.u.h.b) invokeLZ.objValue;
    }

    public d.a.o0.a.u.h.b w(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-TabBar", "start open tab bar");
            }
            return u(str, true);
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }

    public d.a.o0.a.u.h.b x(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-TabBar", "handle: " + str);
            }
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-TabBar", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    d.a.o0.a.e0.d.b("Api-TabBar", "parse fail");
                }
                return bVar;
            }
            JSONObject jSONObject = (JSONObject) b2.second;
            if (v()) {
                d.a.o0.a.e0.d.b("Api-TabBar", "fail not TabBar page");
                return new d.a.o0.a.u.h.b(1001, "fail not TabBar page");
            }
            d.a.o0.a.o2.b.a t = t();
            if (t == null) {
                d.a.o0.a.e0.d.b("Api-TabBar", "tabBarViewController is null");
                return new d.a.o0.a.u.h.b(1001, "tabBarViewController is null");
            } else if (!t.x(jSONObject.optInt("index"), jSONObject.optString("text"), jSONObject.optString("iconPath"), jSONObject.optString("selectedIconPath"))) {
                d.a.o0.a.e0.d.b("Api-TabBar", "set tab bar item fail");
                return new d.a.o0.a.u.h.b(1001, "set tab bar item fail");
            } else {
                return new d.a.o0.a.u.h.b(0);
            }
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
