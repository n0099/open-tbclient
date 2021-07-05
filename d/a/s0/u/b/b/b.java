package d.a.s0.u.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f65644a;

    /* renamed from: b  reason: collision with root package name */
    public String f65645b;

    /* renamed from: c  reason: collision with root package name */
    public String f65646c;

    /* renamed from: d  reason: collision with root package name */
    public String f65647d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f65648e;

    /* renamed from: f  reason: collision with root package name */
    public String f65649f;

    /* renamed from: g  reason: collision with root package name */
    public String f65650g;

    /* renamed from: h  reason: collision with root package name */
    public String f65651h;

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
            }
        }
    }
}
