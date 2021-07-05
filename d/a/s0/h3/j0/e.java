package d.a.s0.h3.j0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f61304a;

    /* renamed from: b  reason: collision with root package name */
    public String f61305b;

    /* renamed from: c  reason: collision with root package name */
    public String f61306c;

    /* renamed from: d  reason: collision with root package name */
    public d f61307d;

    /* renamed from: e  reason: collision with root package name */
    public d f61308e;

    /* renamed from: f  reason: collision with root package name */
    public d f61309f;

    public e(String str, String str2, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f61304a = false;
        this.f61305b = null;
        this.f61306c = null;
        this.f61307d = new d();
        this.f61308e = new d();
        this.f61309f = new d();
        this.f61306c = str;
        this.f61305b = str2;
        this.f61304a = z;
    }
}
