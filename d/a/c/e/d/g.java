package d.a.c.e.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class g<T> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f44089a;

    /* renamed from: b  reason: collision with root package name */
    public T f44090b;

    /* renamed from: c  reason: collision with root package name */
    public String f44091c;

    /* renamed from: d  reason: collision with root package name */
    public long f44092d;

    /* renamed from: e  reason: collision with root package name */
    public long f44093e;

    /* renamed from: f  reason: collision with root package name */
    public long f44094f;

    public g() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }
}
