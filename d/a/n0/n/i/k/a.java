package d.a.n0.n.i.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.n.f.g;
import d.a.n0.n.h.f;
import d.a.n0.n.i.l.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d.a.n0.n.i.d<d.a.n0.n.i.l.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g gVar, d.a.n0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, gVar2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((g) objArr2[0], (d.a.n0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.n0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.n0.n.i.l.a aVar) {
        InterceptResult invokeL;
        List<a.C1146a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar == null || (list = aVar.f50704a) == null || list.isEmpty()) {
                return false;
            }
            for (a.C1146a c1146a : aVar.f50704a) {
                if (TextUtils.isEmpty(c1146a.f50706b)) {
                    return false;
                }
                if (c1146a.f50705a == 0) {
                    if (c1146a.f50708d == null && c1146a.f50710f == null && c1146a.f50709e == null) {
                        return false;
                    }
                    f fVar = c1146a.f50708d;
                    if (fVar != null && !fVar.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = c1146a.f50710f;
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
    @Override // d.a.n0.n.i.d
    /* renamed from: p */
    public d.a.n0.n.h.a m(d.a.n0.n.i.l.a aVar) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            this.f50652e.D();
            d.a.n0.n.o.f fVar = new d.a.n0.n.o.f();
            Map<String, PMSAppInfo> t = d.a.n0.n.g.a.h().t();
            ArrayList arrayList = new ArrayList();
            for (a.C1146a c1146a : aVar.f50704a) {
                if (c1146a != null) {
                    int i2 = c1146a.f50705a;
                    if (i2 != 0) {
                        this.f50652e.u().o(c1146a, t.get(c1146a.f50706b), new d.a.n0.n.h.a(i2, c1146a.f50706b + "，Server返回错误"));
                    } else {
                        List<d.a.n0.n.h.g> list = c1146a.f50709e;
                        if (list != null) {
                            for (d.a.n0.n.h.g gVar : list) {
                                if (gVar != null) {
                                    gVar.o = c1146a.f50706b;
                                }
                            }
                            j(c1146a.f50709e, fVar);
                            arrayList.addAll(c1146a.f50709e);
                        }
                        if (c1146a.f50708d != null && (pMSAppInfo2 = c1146a.f50710f) != null) {
                            pMSAppInfo2.appId = c1146a.f50706b;
                            this.f50652e.u().l(c1146a.f50710f);
                            i(c1146a.f50708d, fVar);
                        } else {
                            PMSAppInfo pMSAppInfo3 = t.get(c1146a.f50706b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = c1146a.f50710f;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = c1146a.f50706b;
                                    List<d.a.n0.n.h.g> list2 = c1146a.f50709e;
                                    if (list2 != null && !list2.isEmpty()) {
                                        c1146a.f50710f.copySubPkgInfo(c1146a.f50709e.get(0));
                                    }
                                    this.f50652e.u().p(c1146a.f50710f, null);
                                } else {
                                    int i3 = c1146a.f50705a;
                                    this.f50652e.u().o(c1146a, null, new d.a.n0.n.h.a(i3, c1146a.f50706b + "，本地记录不存在"));
                                }
                            } else if (c1146a.f50708d == null && (pMSAppInfo = c1146a.f50710f) != null) {
                                pMSAppInfo.appId = c1146a.f50706b;
                                this.f50652e.u().p(c1146a.f50710f, pMSAppInfo3);
                            } else {
                                f fVar2 = c1146a.f50708d;
                                if (fVar2 != null && c1146a.f50710f == null) {
                                    c1146a.f50711g = true;
                                    c1146a.f50710f = pMSAppInfo3;
                                    i(fVar2, fVar);
                                }
                            }
                        }
                    }
                }
            }
            if (fVar.l() == 0) {
                this.f50652e.E();
            } else {
                this.f50652e.F(fVar);
                d.a.n0.n.i.i.a.a(aVar, arrayList, this.f50652e);
            }
            return null;
        }
        return (d.a.n0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.n.i.d
    /* renamed from: q */
    public d.a.n0.n.i.l.a n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? d.a.n0.n.o.e.e(jSONObject) : (d.a.n0.n.i.l.a) invokeL.objValue;
    }
}
