package d.a.p0.s.q;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f53310a;

    /* renamed from: b  reason: collision with root package name */
    public int f53311b;

    /* renamed from: c  reason: collision with root package name */
    public int f53312c;

    /* renamed from: d  reason: collision with root package name */
    public int f53313d;

    /* renamed from: e  reason: collision with root package name */
    public int f53314e;

    /* renamed from: f  reason: collision with root package name */
    public int f53315f;

    /* renamed from: g  reason: collision with root package name */
    public int f53316g;

    /* renamed from: h  reason: collision with root package name */
    public int f53317h;

    /* renamed from: i  reason: collision with root package name */
    public int f53318i;
    public String j;

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
        this.f53310a = 0;
        this.f53311b = 0;
        this.f53312c = 1;
        this.f53313d = 1;
        this.f53314e = 0;
        this.f53315f = 0;
        this.f53316g = 1;
        this.f53317h = 0;
        this.f53318i = 0;
    }
}
