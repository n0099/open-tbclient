package d.a.n0.n.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public abstract class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f50630a;

    /* renamed from: b  reason: collision with root package name */
    public long f50631b;

    /* renamed from: c  reason: collision with root package name */
    public long f50632c;

    /* renamed from: d  reason: collision with root package name */
    public long f50633d;

    /* renamed from: e  reason: collision with root package name */
    public int f50634e;

    /* renamed from: f  reason: collision with root package name */
    public long f50635f;

    public c() {
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
        this.f50630a = "";
        this.f50631b = 0L;
        this.f50632c = 0L;
        this.f50633d = 0L;
        this.f50634e = 0;
    }
}
