package com.repackage;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.za4;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class ta4 extends l94<za4> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ta4(a84 a84Var, lb4 lb4Var) {
        super(a84Var, lb4Var);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {a84Var, lb4Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((a84) objArr2[0], (lb4) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // com.repackage.l94
    public String h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: v */
    public boolean f(za4 za4Var) {
        InterceptResult invokeL;
        List<za4.a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, za4Var)) == null) {
            if (za4Var == null || (list = za4Var.a) == null || list.isEmpty()) {
                return false;
            }
            for (za4.a aVar : za4Var.a) {
                if (TextUtils.isEmpty(aVar.b)) {
                    return false;
                }
                if (aVar.a == 0) {
                    if (aVar.d == null && aVar.g == null && aVar.e == null) {
                        return false;
                    }
                    e94 e94Var = aVar.d;
                    if (e94Var != null && !e94Var.a()) {
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
    @Override // com.repackage.l94
    /* renamed from: w */
    public z84 t(za4 za4Var) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, za4Var)) == null) {
            this.a.E();
            nd4 nd4Var = new nd4();
            Map<String, PMSAppInfo> v = c84.i().v();
            ArrayList arrayList = new ArrayList();
            List<g94> list = null;
            for (za4.a aVar : za4Var.a) {
                if (aVar != null) {
                    int i = aVar.a;
                    if (i != 0) {
                        this.a.v().o(aVar, v.get(aVar.b), new z84(i, aVar.b + "，Server返回错误"));
                    } else {
                        List<f94> list2 = aVar.e;
                        if (list2 != null) {
                            for (f94 f94Var : list2) {
                                if (f94Var != null) {
                                    f94Var.o = aVar.b;
                                }
                            }
                            p(aVar.e, nd4Var);
                            arrayList.addAll(aVar.e);
                        }
                        list = g(aVar.f);
                        if (list != null) {
                            n(list, nd4Var);
                        }
                        if (aVar.d != null && (pMSAppInfo2 = aVar.g) != null) {
                            pMSAppInfo2.appId = aVar.b;
                            this.a.v().l(aVar.g);
                            o(aVar.d, nd4Var);
                        } else {
                            PMSAppInfo pMSAppInfo3 = v.get(aVar.b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = aVar.g;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = aVar.b;
                                    List<f94> list3 = aVar.e;
                                    if (list3 != null && !list3.isEmpty()) {
                                        aVar.g.copySubPkgInfo(aVar.e.get(0));
                                    }
                                    this.a.v().p(aVar.g, null);
                                } else {
                                    this.a.v().o(aVar, null, new z84(aVar.a, aVar.b + "，本地记录不存在"));
                                }
                            } else if (aVar.d == null && (pMSAppInfo = aVar.g) != null) {
                                pMSAppInfo.appId = aVar.b;
                                this.a.v().p(aVar.g, pMSAppInfo3);
                            } else {
                                e94 e94Var = aVar.d;
                                if (e94Var != null && aVar.g == null) {
                                    aVar.h = true;
                                    aVar.g = pMSAppInfo3;
                                    o(e94Var, nd4Var);
                                }
                            }
                        }
                    }
                }
            }
            if (nd4Var.n() == 0) {
                this.a.F();
            } else {
                this.a.G(nd4Var);
                q94.a(za4Var, arrayList, list, this.a);
            }
            return null;
        }
        return (z84) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.repackage.l94
    /* renamed from: x */
    public za4 u(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? md4.f(jSONObject) : (za4) invokeL.objValue;
    }
}
