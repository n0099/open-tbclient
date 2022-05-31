package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.z94;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class t94 extends l84<z94> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public t94(a74 a74Var, la4 la4Var) {
        super(a74Var, la4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a74Var, la4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a74) objArr2[0], (la4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.l84
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84
    /* renamed from: v */
    public boolean f(z94 z94Var) {
        InterceptResult invokeL;
        List<z94.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, z94Var)) == null) {
            if (z94Var == null || (list = z94Var.a) == null || list.isEmpty()) {
                return false;
            }
            for (z94.a aVar : z94Var.a) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return false;
                }
                if (aVar.a == 0) {
                    if (aVar.d == null && aVar.g == null && aVar.e == null) {
                        return false;
                    }
                    e84 e84Var = aVar.d;
                    if (e84Var != null && !e84Var.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = aVar.g;
                    if (pMSAppInfo != null && !pMSAppInfo.checkValid()) {
                        return false;
                    }
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84
    /* renamed from: w */
    public z74 t(z94 z94Var) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, z94Var)) == null) {
            this.a.F();
            nc4 nc4Var = new nc4();
            Map<String, PMSAppInfo> v = c74.i().v();
            ArrayList arrayList = new ArrayList();
            List<g84> list = null;
            for (z94.a aVar : z94Var.a) {
                if (aVar != null) {
                    int i = aVar.a;
                    if (i != 0) {
                        this.a.w().o(aVar, v.get(aVar.b), new z74(i, aVar.b + "，Server返回错误"));
                    } else {
                        List<f84> list2 = aVar.e;
                        if (list2 != null) {
                            for (f84 f84Var : list2) {
                                if (f84Var != null) {
                                    f84Var.o = aVar.b;
                                }
                            }
                            p(aVar.e, nc4Var);
                            arrayList.addAll(aVar.e);
                        }
                        list = g(aVar.f);
                        if (list != null) {
                            n(list, nc4Var);
                        }
                        if (aVar.d != null && (pMSAppInfo2 = aVar.g) != null) {
                            pMSAppInfo2.appId = aVar.b;
                            this.a.w().l(aVar.g);
                            o(aVar.d, nc4Var);
                        } else {
                            PMSAppInfo pMSAppInfo3 = v.get(aVar.b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.b;
                                    List<f84> list3 = aVar.e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.g.copySubPkgInfo(aVar.e.get(0));
                                    }
                                    this.a.w().p(aVar.g, null);
                                } else {
                                    this.a.w().o(aVar, null, new z74(aVar.a, aVar.b + "，本地记录不存在"));
                                }
                            } else if (aVar.d == null && (pMSAppInfo = aVar.g) != null) {
                                pMSAppInfo.appId = aVar.b;
                                this.a.w().p(aVar.g, pMSAppInfo3);
                            } else {
                                e84 e84Var = aVar.d;
                                if (e84Var != null && aVar.g == null) {
                                    aVar.h = true;
                                    aVar.g = pMSAppInfo3;
                                    o(e84Var, nc4Var);
                                }
                            }
                        }
                    }
                }
            }
            if (nc4Var.n() == 0) {
                this.a.G();
            } else {
                this.a.H(nc4Var);
                q84.a(z94Var, arrayList, list, this.a);
            }
            return null;
        }
        return (z74) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l84
    /* renamed from: x */
    public z94 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? mc4.f(jSONObject) : (z94) invokeL.objValue;
    }
}
