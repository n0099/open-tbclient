package d.a.r0.r.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f55931a;

    /* renamed from: b  reason: collision with root package name */
    public int f55932b;

    /* renamed from: c  reason: collision with root package name */
    public int f55933c;

    /* renamed from: d  reason: collision with root package name */
    public int f55934d;

    /* renamed from: e  reason: collision with root package name */
    public int f55935e;

    /* renamed from: f  reason: collision with root package name */
    public int f55936f;

    /* renamed from: g  reason: collision with root package name */
    public int f55937g;

    /* renamed from: h  reason: collision with root package name */
    public int f55938h;

    /* renamed from: i  reason: collision with root package name */
    public int f55939i;

    public f() {
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
        this.f55931a = 0;
        this.f55932b = 0;
        this.f55933c = 1;
        this.f55934d = 1;
        this.f55935e = 0;
        this.f55936f = 0;
        this.f55937g = 1;
        this.f55938h = 0;
        this.f55939i = 0;
    }
}
