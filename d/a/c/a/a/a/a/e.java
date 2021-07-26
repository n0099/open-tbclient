package d.a.c.a.a.a.a;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f41361a;

    /* renamed from: b  reason: collision with root package name */
    public String f41362b;

    public e() {
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
        d.a.c.a.a.c.a.a aVar = new d.a.c.a.a.c.a.a();
        try {
            this.f41361a = new String(aVar.a(j.e()), "UTF-8");
            this.f41362b = new String(aVar.a(j.f()), "UTF-8");
        } catch (Exception unused) {
            throw new IllegalStateException("");
        }
    }

    public /* synthetic */ e(d dVar) {
        this();
    }
}
