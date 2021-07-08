package d.a.n0.n.i.l;

import com.baidu.swan.pms.model.PMSAppInfo;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.n0.n.h.f;
import d.a.n0.n.h.g;
import java.util.List;
/* loaded from: classes7.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public f f50712a;

    /* renamed from: b  reason: collision with root package name */
    public List<g> f50713b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.n.h.d f50714c;

    /* renamed from: d  reason: collision with root package name */
    public PMSAppInfo f50715d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.n.h.b f50716e;

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
