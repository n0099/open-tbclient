package d.b.a;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.embedapplog.AppLog;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class i1 extends h1 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i1(j1 j1Var) {
        super(j1Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {j1Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((j1) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.b.a.h1
    public boolean a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // d.b.a.h1
    public long b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f71678a.i().I() + 21600000 : invokeV.longValue;
    }

    @Override // d.b.a.h1
    public long[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? n1.f71711e : (long[]) invokeV.objValue;
    }

    @Override // d.b.a.h1
    public boolean d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            JSONObject c2 = this.f71678a.j().c();
            if (this.f71678a.j().D() == 0 || c2 == null || this.f71678a.i().I() + 21600000 > System.currentTimeMillis()) {
                return false;
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("magic_tag", "ss_app_log");
            jSONObject.put("header", c2);
            jSONObject.put("_gen_time", System.currentTimeMillis());
            JSONObject h2 = n.h(n.d(o.a(this.f71678a.f(), this.f71678a.j().c(), this.f71678a.n().getSettingUri(), true, AppLog.getIAppParam()), n.f71707e), jSONObject);
            AppLog.getDataObserver().onRemoteConfigGet(!i0.g(h2, this.f71678a.i().H()), h2);
            if (h2 != null) {
                this.f71678a.i().v(h2);
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // d.b.a.h1
    public String e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? "c" : (String) invokeV.objValue;
    }
}
