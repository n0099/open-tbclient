package d.a.o0.n.i.l;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.o0.n.h.f;
import d.a.o0.n.h.g;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f51216a;

    /* renamed from: b  reason: collision with root package name */
    public List<g> f51217b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.o0.n.h.d f51218c;

    /* renamed from: d  reason: collision with root package name */
    public PMSAppInfo f51219d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.n.h.b f51220e;

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
