package d.a.o0.n.i.k;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.n.f.g;
import d.a.o0.n.o.f;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class d extends d.a.o0.n.i.d<d.a.o0.n.i.l.d> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: h  reason: collision with root package name */
    public final String f51205h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d(String str, g gVar, d.a.o0.n.i.m.g gVar2) {
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
                super((g) objArr2[0], (d.a.o0.n.i.m.g) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51205h = str;
    }

    @Override // d.a.o0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "getpkg" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.o0.n.i.l.d dVar) {
        InterceptResult invokeL;
        List<d.a.o0.n.h.g> list;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, dVar)) == null) {
            if (dVar == null || (list = dVar.f51222a) == null) {
                return false;
            }
            for (d.a.o0.n.h.g gVar : list) {
                if (!gVar.a()) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.i.d
    /* renamed from: p */
    public d.a.o0.n.h.a m(d.a.o0.n.i.l.d dVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, dVar)) == null) {
            this.f51156e.D();
            f fVar = new f();
            j(dVar.f51222a, fVar);
            if (fVar.l() == 0) {
                this.f51156e.E();
                return null;
            }
            this.f51156e.F(fVar);
            d.a.o0.n.i.i.a.d(dVar, this.f51156e);
            return null;
        }
        return (d.a.o0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.i.d
    /* renamed from: q */
    public d.a.o0.n.i.l.d n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? d.a.o0.n.o.e.h(this.f51205h, jSONObject) : (d.a.o0.n.i.l.d) invokeL.objValue;
    }
}
