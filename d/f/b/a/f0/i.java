package d.f.b.a.f0;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.f.b.a.d0.t;
import d.f.b.a.i0.v;
/* loaded from: classes10.dex */
public final class i {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final t f73253a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean[] f73254b;

    /* renamed from: c  reason: collision with root package name */
    public final g f73255c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f73256d;

    /* renamed from: e  reason: collision with root package name */
    public final d.f.b.a.t[] f73257e;

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
        this.f73253a = tVar;
        this.f73254b = zArr;
        this.f73255c = gVar;
        this.f73256d = obj;
        this.f73257e = tVarArr;
    }

    public boolean a(i iVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, iVar)) == null) {
            if (iVar == null) {
                return false;
            }
            for (int i2 = 0; i2 < this.f73255c.f73250a; i2++) {
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
        return (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, iVar, i2)) == null) ? iVar != null && this.f73254b[i2] == iVar.f73254b[i2] && v.a(this.f73255c.a(i2), iVar.f73255c.a(i2)) && v.a(this.f73257e[i2], iVar.f73257e[i2]) : invokeLI.booleanValue;
    }
}
