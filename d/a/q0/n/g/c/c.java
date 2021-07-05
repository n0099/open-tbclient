package d.a.q0.n.g.c;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f53913a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f53914b;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        c();
    }

    public <T> b<T> a(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.f53913a.get(cls) : (b) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? this.f53914b.get(cls) : (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f53913a = new ConcurrentHashMap<>();
            this.f53914b = new ConcurrentHashMap<>();
            this.f53913a.put(d.a.q0.n.h.f.class, new f());
            this.f53913a.put(d.a.q0.n.h.g.class, new g());
            this.f53913a.put(d.a.q0.n.h.d.class, new e());
            this.f53913a.put(d.a.q0.n.h.b.class, new d());
            this.f53913a.put(PMSAppInfo.class, new a());
            this.f53913a.put(d.a.q0.n.h.h.class, new h());
            this.f53913a.put(d.a.q0.n.h.i.class, new i());
            this.f53914b.put(d.a.q0.n.h.f.class, d.a.q0.n.g.e.b.f53922e);
            this.f53914b.put(d.a.q0.n.h.g.class, d.a.q0.n.g.e.b.f53923f);
            this.f53914b.put(d.a.q0.n.h.d.class, d.a.q0.n.g.e.b.f53920c);
            this.f53914b.put(d.a.q0.n.h.b.class, d.a.q0.n.g.e.b.f53924g);
            this.f53914b.put(PMSAppInfo.class, d.a.q0.n.g.e.b.f53921d);
            this.f53914b.put(d.a.q0.n.h.h.class, d.a.q0.n.g.e.b.f53925h);
            this.f53914b.put(d.a.q0.n.h.i.class, d.a.q0.n.g.e.b.f53926i);
        }
    }
}
