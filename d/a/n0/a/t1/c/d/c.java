package d.a.n0.a.t1.c.d;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class c extends d.a.n0.a.t1.c.d.a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public class a implements d.a.n0.a.n.a.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.t1.c.c.a f47407a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.a.h0.j.b f47408b;

        public a(c cVar, d.a.n0.a.t1.c.c.a aVar, d.a.n0.a.h0.j.b bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cVar, aVar, bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f47407a = aVar;
            this.f47408b = bVar;
        }

        @Override // d.a.n0.a.n.a.b
        public void a(int i2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
                d.a.n0.a.t1.d.a.a("obtain address failure, errCode = " + i2);
                this.f47408b.a(this.f47407a);
            }
        }

        @Override // d.a.n0.a.n.a.b
        public void b(JSONObject jSONObject) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, jSONObject) == null) {
                d.a.n0.a.t1.d.a.a("obtain address success");
                d.a.n0.a.t1.c.c.a aVar = this.f47407a;
                aVar.f47390d = true;
                if (jSONObject != null) {
                    aVar.f47391e = jSONObject.toString();
                }
                this.f47408b.a(this.f47407a);
            }
        }
    }

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // d.a.n0.a.t1.c.d.b
    public d.a.n0.a.u.h.b b(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, jSONObject)) == null) {
            return null;
        }
        return (d.a.n0.a.u.h.b) invokeL.objValue;
    }

    @Override // d.a.n0.a.t1.c.d.b
    public String g() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "mapp_choose_address" : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.t1.c.d.b
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "SwanPluginAddressFunPage" : (String) invokeV.objValue;
    }

    @Override // d.a.n0.a.t1.c.d.a
    public void p(SwanAppActivity swanAppActivity, String str, d.a.n0.a.t1.c.b.b bVar, d.a.n0.a.e2.d.a aVar, d.a.n0.a.h0.j.b<d.a.n0.a.t1.c.c.a> bVar2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLLL(1048579, this, swanAppActivity, str, bVar, aVar, bVar2) == null) {
            d.a.n0.a.t1.c.c.a aVar2 = new d.a.n0.a.t1.c.c.a(bVar.f47383f);
            aVar2.f47387a = bVar.f47382e;
            if (aVar != null && aVar.j.a() != LightappBusinessClient.SVC_ID_H5_TRANSERECORD) {
                d.a.n0.a.t1.d.a.a("obtain address detail");
                d.a.n0.a.c1.a.c0().a(swanAppActivity, str, str, new a(this, aVar2, bVar2));
                return;
            }
            d.a.n0.a.t1.d.a.a("user denied");
            bVar2.a(aVar2);
        }
    }
}
