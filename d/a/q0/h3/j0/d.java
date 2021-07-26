package d.a.q0.h3.j0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f58631a;

    /* renamed from: b  reason: collision with root package name */
    public long f58632b;

    /* renamed from: c  reason: collision with root package name */
    public long f58633c;

    /* renamed from: d  reason: collision with root package name */
    public long f58634d;

    public d() {
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
        this.f58631a = 0L;
        this.f58632b = 0L;
        this.f58633c = 0L;
        this.f58634d = 0L;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f58631a = 0L;
            this.f58632b = 0L;
            this.f58633c = 0L;
            this.f58634d = 0L;
        }
    }
}
