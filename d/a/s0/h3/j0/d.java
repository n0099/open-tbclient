package d.a.s0.h3.j0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f61300a;

    /* renamed from: b  reason: collision with root package name */
    public long f61301b;

    /* renamed from: c  reason: collision with root package name */
    public long f61302c;

    /* renamed from: d  reason: collision with root package name */
    public long f61303d;

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
        this.f61300a = 0L;
        this.f61301b = 0L;
        this.f61302c = 0L;
        this.f61303d = 0L;
    }

    public void a() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.f61300a = 0L;
            this.f61301b = 0L;
            this.f61302c = 0L;
            this.f61303d = 0L;
        }
    }
}
