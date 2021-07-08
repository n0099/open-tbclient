package d.a.n0.n.g.c;

import android.net.Uri;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.concurrent.ConcurrentHashMap;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, b> f50611a;

    /* renamed from: b  reason: collision with root package name */
    public ConcurrentHashMap<Class<?>, Uri> f50612b;

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
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, cls)) == null) ? this.f50611a.get(cls) : (b) invokeL.objValue;
    }

    public <T> Uri b(Class<T> cls) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cls)) == null) ? this.f50612b.get(cls) : (Uri) invokeL.objValue;
    }

    public final void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.f50611a = new ConcurrentHashMap<>();
            this.f50612b = new ConcurrentHashMap<>();
            this.f50611a.put(d.a.n0.n.h.f.class, new f());
            this.f50611a.put(d.a.n0.n.h.g.class, new g());
            this.f50611a.put(d.a.n0.n.h.d.class, new e());
            this.f50611a.put(d.a.n0.n.h.b.class, new d());
            this.f50611a.put(PMSAppInfo.class, new a());
            this.f50611a.put(d.a.n0.n.h.h.class, new h());
            this.f50611a.put(d.a.n0.n.h.i.class, new i());
            this.f50612b.put(d.a.n0.n.h.f.class, d.a.n0.n.g.e.b.f50620e);
            this.f50612b.put(d.a.n0.n.h.g.class, d.a.n0.n.g.e.b.f50621f);
            this.f50612b.put(d.a.n0.n.h.d.class, d.a.n0.n.g.e.b.f50618c);
            this.f50612b.put(d.a.n0.n.h.b.class, d.a.n0.n.g.e.b.f50622g);
            this.f50612b.put(PMSAppInfo.class, d.a.n0.n.g.e.b.f50619d);
            this.f50612b.put(d.a.n0.n.h.h.class, d.a.n0.n.g.e.b.f50623h);
            this.f50612b.put(d.a.n0.n.h.i.class, d.a.n0.n.g.e.b.f50624i);
        }
    }
}
