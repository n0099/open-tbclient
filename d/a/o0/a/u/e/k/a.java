package d.a.o0.a.u.e.k;

import android.util.Log;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.a.a2.e;
import d.a.o0.a.g1.f;
import d.a.o0.a.h0.g.g;
import d.a.o0.a.j2.h;
import d.a.o0.a.r1.i;
import d.a.o0.a.v2.q0;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
import java.util.UUID;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.o0.a.u.c.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: d.a.o0.a.u.e.k.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public class RunnableC0932a implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ int f48205e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ g f48206f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ g.b f48207g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ a f48208h;

        public RunnableC0932a(a aVar, int i2, g gVar, g.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aVar, Integer.valueOf(i2), gVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f48208h = aVar;
            this.f48205e = i2;
            this.f48206f = gVar;
            this.f48207g = bVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if (this.f48205e > 1) {
                    d.a.o0.a.v2.g.b(this.f48206f, this.f48208h.i(), 1);
                }
                this.f48207g.a();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(@NonNull d.a.o0.a.u.c.b bVar) {
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

    public d.a.o0.a.u.h.b s(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-NavigateBack", "handle: " + str);
            }
            e Q = e.Q();
            if (Q != null) {
                Q.B().e(Q.getAppId());
            }
            String uuid = UUID.randomUUID().toString();
            i.b(uuid);
            Pair<d.a.o0.a.u.h.b, JSONObject> b2 = d.a.o0.a.u.i.b.b("Api-NavigateBack", str);
            d.a.o0.a.u.h.b bVar = (d.a.o0.a.u.h.b) b2.first;
            if (!bVar.isSuccess()) {
                if (d.a.o0.a.u.c.d.f47942c) {
                    d.a.o0.a.e0.d.b("Api-NavigateBack", "parse fail");
                }
                return bVar;
            }
            int optInt = ((JSONObject) b2.second).optInt("delta", 1);
            g W = f.V().W();
            if (W == null) {
                d.a.o0.a.e0.d.b("Api-NavigateBack", "manager is null");
                return new d.a.o0.a.u.h.b(1001, "manager is null");
            }
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-NavigateBack", "back delta: " + optInt);
            }
            int k = W.k();
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-NavigateBack", "fragment count " + k);
            }
            if (k == 1) {
                d.a.o0.a.e0.d.b("Api-NavigateBack", "navigateBack api can only work when slave's count greater than 1");
                return new d.a.o0.a.u.h.b(1001, "navigateBack api can only work when slave's count greater than 1");
            }
            if (optInt >= k) {
                optInt = k - 1;
            }
            if (d.a.o0.a.u.c.d.f47942c) {
                Log.d("Api-NavigateBack", "real back delta: " + optInt);
            }
            d.a.o0.a.h0.g.d j = W.j((k - optInt) - 1);
            h.f((j == null || j.K1() == null) ? "" : j.K1().g(), "1");
            i.c(1, uuid);
            g.b i2 = W.i("navigateBack");
            i2.n(g.f45214i, g.f45213h);
            i2.h(optInt);
            q0.X(new RunnableC0932a(this, k, W, i2));
            d.a.o0.a.h0.g.f o = W.o();
            d.a.o0.a.l1.b Z2 = o == null ? null : o.Z2();
            d.a.o0.a.r1.h.q(FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE, uuid).C(new UbcFlowEvent("na_push_page_end"));
            i.a(uuid, Z2);
            if (!(W.m() instanceof d.a.o0.a.h0.g.f)) {
                d.a.o0.a.e0.d.b("Api-NavigateBack", "top fragment error");
                return new d.a.o0.a.u.h.b(1001, "top fragment error");
            }
            d.a.o0.a.h0.g.f fVar = (d.a.o0.a.h0.g.f) W.m();
            return new d.a.o0.a.u.h.b(0, d.a.o0.a.c2.f.p0.a.c(fVar != null ? fVar.g3() : ""));
        }
        return (d.a.o0.a.u.h.b) invokeL.objValue;
    }
}
