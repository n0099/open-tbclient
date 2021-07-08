package d.f.b.a.f0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.d0.t;
import d.f.b.a.i0.v;
/* loaded from: classes8.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f70356a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean[] f70357b;

    /* renamed from: c  reason: collision with root package name */
    public final g f70358c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f70359d;

    /* renamed from: e  reason: collision with root package name */
    public final d.f.b.a.t[] f70360e;

    public i(t tVar, boolean[] zArr, g gVar, Object obj, d.f.b.a.t[] tVarArr) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tVar, zArr, gVar, obj, tVarArr};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f70356a = tVar;
        this.f70357b = zArr;
        this.f70358c = gVar;
        this.f70359d = obj;
        this.f70360e = tVarArr;
    }

    public boolean a(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iVar)) == null) {
            if (iVar == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f70358c.f70353a; i2++) {
                if (!b(iVar, i2)) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }

    public boolean b(i iVar, int i2) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, i2)) == null) ? iVar != null && this.f70357b[i2] == iVar.f70357b[i2] && v.a(this.f70358c.a(i2), iVar.f70358c.a(i2)) && v.a(this.f70360e[i2], iVar.f70360e[i2]) : invokeLI.booleanValue;
    }
}
