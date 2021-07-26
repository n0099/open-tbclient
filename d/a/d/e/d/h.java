package d.a.d.e.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f41615a;

    /* renamed from: b  reason: collision with root package name */
    public String f41616b;

    /* renamed from: c  reason: collision with root package name */
    public int f41617c;

    /* renamed from: d  reason: collision with root package name */
    public String f41618d;

    /* renamed from: e  reason: collision with root package name */
    public int f41619e;

    /* renamed from: f  reason: collision with root package name */
    public long f41620f;

    public h() {
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
