package d.a.q0.n.i.k;

import android.text.TextUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n.f.g;
import d.a.q0.n.h.f;
import d.a.q0.n.i.l.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d.a.q0.n.i.d<d.a.q0.n.i.l.a> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(g gVar, d.a.q0.n.i.m.g gVar2) {
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
                super((g) objArr2[0], (d.a.q0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.a.q0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkglist" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.q0.n.i.l.a aVar) {
        InterceptResult invokeL;
        List<a.C1197a> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, aVar)) == null) {
            if (aVar == null || (list = aVar.f54006a) == null || list.isEmpty()) {
                return false;
            }
            for (a.C1197a c1197a : aVar.f54006a) {
                if (TextUtils.isEmpty(c1197a.f54008b)) {
                    return false;
                }
                if (c1197a.f54007a == 0) {
                    if (c1197a.f54010d == null && c1197a.f54012f == null && c1197a.f54011e == null) {
                        return false;
                    }
                    f fVar = c1197a.f54010d;
                    if (fVar != null && !fVar.a()) {
                        return false;
                    }
                    PMSAppInfo pMSAppInfo = c1197a.f54012f;
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
    @Override // d.a.q0.n.i.d
    /* renamed from: p */
    public d.a.q0.n.h.a m(d.a.q0.n.i.l.a aVar) {
        InterceptResult invokeL;
        PMSAppInfo pMSAppInfo;
        PMSAppInfo pMSAppInfo2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, aVar)) == null) {
            this.f53954e.D();
            d.a.q0.n.o.f fVar = new d.a.q0.n.o.f();
            Map<String, PMSAppInfo> t = d.a.q0.n.g.a.h().t();
            ArrayList arrayList = new ArrayList();
            for (a.C1197a c1197a : aVar.f54006a) {
                if (c1197a != null) {
                    int i2 = c1197a.f54007a;
                    if (i2 != 0) {
                        this.f53954e.u().o(c1197a, t.get(c1197a.f54008b), new d.a.q0.n.h.a(i2, c1197a.f54008b + "，Server返回错误"));
                    } else {
                        List<d.a.q0.n.h.g> list = c1197a.f54011e;
                        if (list != null) {
                            for (d.a.q0.n.h.g gVar : list) {
                                if (gVar != null) {
                                    gVar.o = c1197a.f54008b;
                                }
                            }
                            j(c1197a.f54011e, fVar);
                            arrayList.addAll(c1197a.f54011e);
                        }
                        if (c1197a.f54010d != null && (pMSAppInfo2 = c1197a.f54012f) != null) {
                            pMSAppInfo2.appId = c1197a.f54008b;
                            this.f53954e.u().l(c1197a.f54012f);
                            i(c1197a.f54010d, fVar);
                        } else {
                            PMSAppInfo pMSAppInfo3 = t.get(c1197a.f54008b);
                            if (pMSAppInfo3 == null) {
                                PMSAppInfo pMSAppInfo4 = c1197a.f54012f;
                                if (pMSAppInfo4 != null) {
                                    pMSAppInfo4.appId = c1197a.f54008b;
                                    List<d.a.q0.n.h.g> list2 = c1197a.f54011e;
                                    if (list2 != null && !list2.isEmpty()) {
                                        c1197a.f54012f.copySubPkgInfo(c1197a.f54011e.get(0));
                                    }
                                    this.f53954e.u().p(c1197a.f54012f, null);
                                } else {
                                    int i3 = c1197a.f54007a;
                                    this.f53954e.u().o(c1197a, null, new d.a.q0.n.h.a(i3, c1197a.f54008b + "，本地记录不存在"));
                                }
                            } else if (c1197a.f54010d == null && (pMSAppInfo = c1197a.f54012f) != null) {
                                pMSAppInfo.appId = c1197a.f54008b;
                                this.f53954e.u().p(c1197a.f54012f, pMSAppInfo3);
                            } else {
                                f fVar2 = c1197a.f54010d;
                                if (fVar2 != null && c1197a.f54012f == null) {
                                    c1197a.f54013g = true;
                                    c1197a.f54012f = pMSAppInfo3;
                                    i(fVar2, fVar);
                                }
                            }
                        }
                    }
                }
            }
            if (fVar.l() == 0) {
                this.f53954e.E();
            } else {
                this.f53954e.F(fVar);
                d.a.q0.n.i.i.a.a(aVar, arrayList, this.f53954e);
            }
            return null;
        }
        return (d.a.q0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.n.i.d
    /* renamed from: q */
    public d.a.q0.n.i.l.a n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? d.a.q0.n.o.e.e(jSONObject) : (d.a.q0.n.i.l.a) invokeL.objValue;
    }
}
