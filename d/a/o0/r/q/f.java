package d.a.o0.r.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52646a;

    /* renamed from: b  reason: collision with root package name */
    public int f52647b;

    /* renamed from: c  reason: collision with root package name */
    public int f52648c;

    /* renamed from: d  reason: collision with root package name */
    public int f52649d;

    /* renamed from: e  reason: collision with root package name */
    public int f52650e;

    /* renamed from: f  reason: collision with root package name */
    public int f52651f;

    /* renamed from: g  reason: collision with root package name */
    public int f52652g;

    /* renamed from: h  reason: collision with root package name */
    public int f52653h;

    /* renamed from: i  reason: collision with root package name */
    public int f52654i;

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
        this.f52646a = 0;
        this.f52647b = 0;
        this.f52648c = 1;
        this.f52649d = 1;
        this.f52650e = 0;
        this.f52651f = 0;
        this.f52652g = 1;
        this.f52653h = 0;
        this.f52654i = 0;
    }
}
