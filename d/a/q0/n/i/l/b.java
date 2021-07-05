package d.a.q0.n.i.l;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.q0.n.h.f;
import d.a.q0.n.h.g;
import java.util.List;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f54014a;

    /* renamed from: b  reason: collision with root package name */
    public List<g> f54015b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.q0.n.h.d f54016c;

    /* renamed from: d  reason: collision with root package name */
    public PMSAppInfo f54017d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.q0.n.h.b f54018e;

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
