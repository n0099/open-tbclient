package d.a.n0.n.i.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.n.f.g;
import d.a.n0.n.h.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class b extends d.a.n0.n.i.d<d.a.n0.n.i.l.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f50700h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, g gVar, d.a.n0.n.i.m.g gVar2) {
        super(gVar, gVar2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, gVar, gVar2};
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
        this.f50700h = str;
    }

    @Override // d.a.n0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.n0.n.i.l.b bVar) {
        InterceptResult invokeL;
        List<d.a.n0.n.h.g> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (bVar.f50712a == null && (((list = bVar.f50713b) == null || list.isEmpty()) && bVar.f50714c == null && bVar.f50716e == null && bVar.f50715d == null)) {
                return false;
            }
            f fVar = bVar.f50712a;
            if (fVar == null || fVar.a()) {
                List<d.a.n0.n.h.g> list2 = bVar.f50713b;
                if (list2 != null) {
                    for (d.a.n0.n.h.g gVar : list2) {
                        if (!gVar.a()) {
                            return false;
                        }
                    }
                }
                d.a.n0.n.h.d dVar = bVar.f50714c;
                if (dVar == null || dVar.a()) {
                    d.a.n0.n.h.b bVar2 = bVar.f50716e;
                    if (bVar2 == null || bVar2.a()) {
                        PMSAppInfo pMSAppInfo = bVar.f50715d;
                        return pMSAppInfo == null || pMSAppInfo.checkValid();
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.n.i.d
    /* renamed from: p */
    public d.a.n0.n.h.a m(d.a.n0.n.i.l.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f50652e.D();
            d.a.n0.n.o.f fVar = new d.a.n0.n.o.f();
            i(bVar.f50712a, fVar);
            j(bVar.f50713b, fVar);
            h(bVar.f50714c, fVar);
            g(bVar.f50716e, fVar);
            l(bVar.f50715d);
            if (fVar.l() == 0) {
                this.f50652e.E();
                return null;
            }
            this.f50652e.F(fVar);
            d.a.n0.n.i.i.a.b(bVar, this.f50652e);
            return null;
        }
        return (d.a.n0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.n0.n.i.d
    /* renamed from: q */
    public d.a.n0.n.i.l.b n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? d.a.n0.n.o.e.f(this.f50700h, jSONObject) : (d.a.n0.n.i.l.b) invokeL.objValue;
    }
}
