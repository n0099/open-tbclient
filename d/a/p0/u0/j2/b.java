package d.a.p0.u0.j2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f62956a;

    /* renamed from: b  reason: collision with root package name */
    public int f62957b;

    /* renamed from: c  reason: collision with root package name */
    public String f62958c;

    /* renamed from: d  reason: collision with root package name */
    public int f62959d;

    /* renamed from: e  reason: collision with root package name */
    public int f62960e;

    /* renamed from: f  reason: collision with root package name */
    public int f62961f;

    /* renamed from: g  reason: collision with root package name */
    public int f62962g;

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
        this.f62956a = false;
        this.f62957b = 0;
        this.f62958c = null;
        this.f62959d = -1;
        this.f62960e = -1;
        this.f62961f = -1;
        this.f62962g = -1;
    }
}
