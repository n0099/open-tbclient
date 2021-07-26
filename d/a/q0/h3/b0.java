package d.a.q0.h3;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes8.dex */
public class b0 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f58486a;

    /* renamed from: b  reason: collision with root package name */
    public String f58487b;

    /* renamed from: c  reason: collision with root package name */
    public String f58488c;

    /* renamed from: d  reason: collision with root package name */
    public String f58489d;

    /* renamed from: e  reason: collision with root package name */
    public String f58490e;

    /* renamed from: f  reason: collision with root package name */
    public c0 f58491f;

    /* renamed from: g  reason: collision with root package name */
    public String f58492g;

    /* renamed from: h  reason: collision with root package name */
    public int f58493h;

    /* renamed from: i  reason: collision with root package name */
    public List<String> f58494i;

    public b0() {
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
