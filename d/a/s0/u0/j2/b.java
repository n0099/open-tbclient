package d.a.s0.u0.j2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f66175a;

    /* renamed from: b  reason: collision with root package name */
    public int f66176b;

    /* renamed from: c  reason: collision with root package name */
    public String f66177c;

    /* renamed from: d  reason: collision with root package name */
    public int f66178d;

    /* renamed from: e  reason: collision with root package name */
    public int f66179e;

    /* renamed from: f  reason: collision with root package name */
    public int f66180f;

    /* renamed from: g  reason: collision with root package name */
    public int f66181g;

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
        this.f66175a = false;
        this.f66176b = 0;
        this.f66177c = null;
        this.f66178d = -1;
        this.f66179e = -1;
        this.f66180f = -1;
        this.f66181g = -1;
    }
}
