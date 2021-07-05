package d.b.c.b.h.a;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.b.c.b.l;
import d.b.c.b.m;
/* loaded from: classes10.dex */
public class a extends c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a(Context context, b bVar, d dVar) {
        super(com.bytedance.tea.crash.c.f32271d, context, bVar, dVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bVar, dVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((com.bytedance.tea.crash.c) objArr2[0], (Context) objArr2[1], (b) objArr2[2], (d) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
    }

    @Override // d.b.c.b.h.a.c
    public d.b.c.b.e.a a(d.b.c.b.e.a aVar) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, aVar)) == null) {
            d.b.c.b.e.a a2 = super.a(aVar);
            d.b.c.b.e.b a3 = d.b.c.b.e.b.a(this.f71870b);
            a3.d(m.a().a());
            a3.c(m.d().a());
            a3.g(this.f71871c.c());
            a2.d(a3);
            a2.k("process_name", l.b.k(this.f71870b));
            l.C1997l.b(a2, a3, this.f71869a);
            return a2;
        }
        return (d.b.c.b.e.a) invokeL.objValue;
    }
}
