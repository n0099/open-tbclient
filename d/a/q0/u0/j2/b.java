package d.a.q0.u0.j2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f63599a;

    /* renamed from: b  reason: collision with root package name */
    public int f63600b;

    /* renamed from: c  reason: collision with root package name */
    public String f63601c;

    /* renamed from: d  reason: collision with root package name */
    public int f63602d;

    /* renamed from: e  reason: collision with root package name */
    public int f63603e;

    /* renamed from: f  reason: collision with root package name */
    public int f63604f;

    /* renamed from: g  reason: collision with root package name */
    public int f63605g;

    public b() {
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
        this.f63599a = false;
        this.f63600b = 0;
        this.f63601c = null;
        this.f63602d = -1;
        this.f63603e = -1;
        this.f63604f = -1;
        this.f63605g = -1;
    }
}
