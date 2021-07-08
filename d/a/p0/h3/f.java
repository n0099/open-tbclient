package d.a.p0.h3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f57933a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f57934b;

    /* renamed from: c  reason: collision with root package name */
    public int f57935c;

    /* renamed from: d  reason: collision with root package name */
    public String f57936d;

    /* renamed from: e  reason: collision with root package name */
    public long f57937e;

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
        this.f57933a = false;
        this.f57934b = false;
        this.f57935c = 0;
        this.f57936d = "";
        this.f57937e = 0L;
    }
}
