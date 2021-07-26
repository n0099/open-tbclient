package d.a.o0.a.m1.h;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f46624e;

    /* renamed from: f  reason: collision with root package name */
    public final d.a.o0.a.p.e.e f46625f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(d.a.o0.a.p.e.e eVar, boolean z) {
        super(6);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {eVar, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super(((Integer) newInitContext.callArgs[0]).intValue());
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46624e = z;
        this.f46625f = eVar;
    }

    @Override // d.a.o0.a.m1.h.c
    public String d() {
        InterceptResult invokeV;
        d.a.o0.a.c2.f.r0.d params;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            d.a.o0.a.p.e.e eVar = this.f46625f;
            if (eVar == null || (params = eVar.getParams()) == null) {
                return null;
            }
            return params.f43982g;
        }
        return (String) invokeV.objValue;
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f46624e : invokeV.booleanValue;
    }
}
