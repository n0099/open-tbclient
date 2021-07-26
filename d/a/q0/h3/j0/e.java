package d.a.q0.h3.j0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58635a;

    /* renamed from: b  reason: collision with root package name */
    public String f58636b;

    /* renamed from: c  reason: collision with root package name */
    public String f58637c;

    /* renamed from: d  reason: collision with root package name */
    public d f58638d;

    /* renamed from: e  reason: collision with root package name */
    public d f58639e;

    /* renamed from: f  reason: collision with root package name */
    public d f58640f;

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
        this.f58635a = false;
        this.f58636b = null;
        this.f58637c = null;
        this.f58638d = new d();
        this.f58639e = new d();
        this.f58640f = new d();
        this.f58637c = str;
        this.f58636b = str2;
        this.f58635a = z;
    }
}
