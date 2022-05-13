package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.mb4;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class gb4 extends y94<mb4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gb4(n84 n84Var, yb4 yb4Var) {
        super(n84Var, yb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {n84Var, yb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((n84) objArr2[0], (yb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.y94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: v */
    public boolean f(mb4 mb4Var) {
        InterceptResult invokeL;
        List<mb4.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, mb4Var)) == null) {
            if (mb4Var == null || (list = mb4Var.a) == null || list.isEmpty()) {
                return false;
            }
            for (mb4.a aVar : mb4Var.a) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return false;
                }
                if (aVar.a == 0) {
                    if (aVar.d == null && aVar.g == null && aVar.e == null) {
                        return false;
                    }
                    r94 r94Var = aVar.d;
                    if (r94Var != null && !r94Var.a()) {
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
    @Override // com.repackage.y94
    /* renamed from: w */
    public m94 t(mb4 mb4Var) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, mb4Var)) == null) {
            this.a.F();
            ae4 ae4Var = new ae4();
            Map<String, PMSAppInfo> v = p84.i().v();
            ArrayList arrayList = new ArrayList();
            List<t94> list = null;
            for (mb4.a aVar : mb4Var.a) {
                if (aVar != null) {
                    int i = aVar.a;
                    if (i != 0) {
                        this.a.w().o(aVar, v.get(aVar.b), new m94(i, aVar.b + "，Server返回错误"));
                    } else {
                        List<s94> list2 = aVar.e;
                        if (list2 != null) {
                            for (s94 s94Var : list2) {
                                if (s94Var != null) {
                                    s94Var.o = aVar.b;
                                }
                            }
                            p(aVar.e, ae4Var);
                            arrayList.addAll(aVar.e);
                        }
                        list = g(aVar.f);
                        if (list != null) {
                            n(list, ae4Var);
                        }
                        if (aVar.d != null && (pMSAppInfo2 = aVar.g) != null) {
                            pMSAppInfo2.appId = aVar.b;
                            this.a.w().l(aVar.g);
                            o(aVar.d, ae4Var);
                        } else {
                            PMSAppInfo pMSAppInfo3 = v.get(aVar.b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.b;
                                    List<s94> list3 = aVar.e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.g.copySubPkgInfo(aVar.e.get(0));
                                    }
                                    this.a.w().p(aVar.g, null);
                                } else {
                                    this.a.w().o(aVar, null, new m94(aVar.a, aVar.b + "，本地记录不存在"));
                                }
                            } else if (aVar.d == null && (pMSAppInfo = aVar.g) != null) {
                                pMSAppInfo.appId = aVar.b;
                                this.a.w().p(aVar.g, pMSAppInfo3);
                            } else {
                                r94 r94Var = aVar.d;
                                if (r94Var != null && aVar.g == null) {
                                    aVar.h = true;
                                    aVar.g = pMSAppInfo3;
                                    o(r94Var, ae4Var);
                                }
                            }
                        }
                    }
                }
            }
            if (ae4Var.n() == 0) {
                this.a.G();
            } else {
                this.a.H(ae4Var);
                da4.a(mb4Var, arrayList, list, this.a);
            }
            return null;
        }
        return (m94) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.y94
    /* renamed from: x */
    public mb4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? zd4.f(jSONObject) : (mb4) invokeL.objValue;
    }
}
