package d.a.q0.h3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58508a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58509b;

    /* renamed from: c  reason: collision with root package name */
    public int f58510c;

    /* renamed from: d  reason: collision with root package name */
    public String f58511d;

    /* renamed from: e  reason: collision with root package name */
    public long f58512e;

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
        this.f58508a = false;
        this.f58509b = false;
        this.f58510c = 0;
        this.f58511d = "";
        this.f58512e = 0L;
    }
}
