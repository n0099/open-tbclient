package d.a.q0.n.i.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n.f.g;
import d.a.q0.n.h.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class b extends d.a.q0.n.i.d<d.a.q0.n.i.l.b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f54002h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String str, g gVar, d.a.q0.n.i.m.g gVar2) {
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
                super((g) objArr2[0], (d.a.q0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f54002h = str;
    }

    @Override // d.a.q0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.q0.n.i.l.b bVar) {
        InterceptResult invokeL;
        List<d.a.q0.n.h.g> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, bVar)) == null) {
            if (bVar == null) {
                return false;
            }
            if (bVar.f54014a == null && (((list = bVar.f54015b) == null || list.isEmpty()) && bVar.f54016c == null && bVar.f54018e == null && bVar.f54017d == null)) {
                return false;
            }
            f fVar = bVar.f54014a;
            if (fVar == null || fVar.a()) {
                List<d.a.q0.n.h.g> list2 = bVar.f54015b;
                if (list2 != null) {
                    for (d.a.q0.n.h.g gVar : list2) {
                        if (!gVar.a()) {
                            return false;
                        }
                    }
                }
                d.a.q0.n.h.d dVar = bVar.f54016c;
                if (dVar == null || dVar.a()) {
                    d.a.q0.n.h.b bVar2 = bVar.f54018e;
                    if (bVar2 == null || bVar2.a()) {
                        PMSAppInfo pMSAppInfo = bVar.f54017d;
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
    @Override // d.a.q0.n.i.d
    /* renamed from: p */
    public d.a.q0.n.h.a m(d.a.q0.n.i.l.b bVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, bVar)) == null) {
            this.f53954e.D();
            d.a.q0.n.o.f fVar = new d.a.q0.n.o.f();
            i(bVar.f54014a, fVar);
            j(bVar.f54015b, fVar);
            h(bVar.f54016c, fVar);
            g(bVar.f54018e, fVar);
            l(bVar.f54017d);
            if (fVar.l() == 0) {
                this.f53954e.E();
                return null;
            }
            this.f53954e.F(fVar);
            d.a.q0.n.i.i.a.b(bVar, this.f53954e);
            return null;
        }
        return (d.a.q0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.q0.n.i.d
    /* renamed from: q */
    public d.a.q0.n.i.l.b n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? d.a.q0.n.o.e.f(this.f54002h, jSONObject) : (d.a.q0.n.i.l.b) invokeL.objValue;
    }
}
