package d.a.o0.n.i.k;

import androidx.annotation.Nullable;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.n.f.g;
import d.a.o0.n.j.f;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class e extends d.a.o0.n.i.d<d.a.o0.n.i.l.e> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable

    /* renamed from: h  reason: collision with root package name */
    public g f51206h;
    @Nullable

    /* renamed from: i  reason: collision with root package name */
    public g f51207i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(g gVar, d.a.o0.n.i.m.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {gVar, gVar2, gVar3, gVar4};
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
        this.f51206h = gVar3;
        this.f51207i = gVar4;
    }

    @Override // d.a.o0.n.i.d
    public String f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "updatecore" : (String) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.i.d
    /* renamed from: o */
    public boolean e(d.a.o0.n.i.l.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, eVar)) == null) ? eVar != null : invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.i.d
    /* renamed from: p */
    public d.a.o0.n.h.a m(d.a.o0.n.i.l.e eVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, eVar)) == null) {
            this.f51156e.D();
            d.a.o0.n.n.a.e(this.f51157f.a(), eVar.f51223a);
            g gVar = this.f51156e;
            if (gVar == this.f51206h || gVar == this.f51207i) {
                gVar = null;
            }
            f.c(eVar.f51224b, gVar, this.f51206h, this.f51207i);
            return null;
        }
        return (d.a.o0.n.h.a) invokeL.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // d.a.o0.n.i.d
    /* renamed from: q */
    public d.a.o0.n.i.l.e n(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, jSONObject)) == null) ? d.a.o0.n.o.e.n(jSONObject) : (d.a.o0.n.i.l.e) invokeL.objValue;
    }
}
