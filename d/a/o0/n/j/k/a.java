package d.a.o0.n.j.k;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.n.h.h;
import d.a.o0.n.h.i;
import java.util.Collection;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public d.a.o0.n.h.d f51301a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.o0.n.h.d f51302b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.n.h.b f51303c;

    /* renamed from: d  reason: collision with root package name */
    public Collection<i> f51304d;

    /* renamed from: e  reason: collision with root package name */
    public Collection<h> f51305e;

    public a() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
