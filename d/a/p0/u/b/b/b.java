package d.a.p0.u.b.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f62425a;

    /* renamed from: b  reason: collision with root package name */
    public String f62426b;

    /* renamed from: c  reason: collision with root package name */
    public String f62427c;

    /* renamed from: d  reason: collision with root package name */
    public String f62428d;

    /* renamed from: e  reason: collision with root package name */
    public Map<String, String> f62429e;

    /* renamed from: f  reason: collision with root package name */
    public String f62430f;

    /* renamed from: g  reason: collision with root package name */
    public String f62431g;

    /* renamed from: h  reason: collision with root package name */
    public String f62432h;

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
