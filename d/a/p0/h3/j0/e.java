package d.a.p0.h3.j0;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public boolean f58060a;

    /* renamed from: b  reason: collision with root package name */
    public String f58061b;

    /* renamed from: c  reason: collision with root package name */
    public String f58062c;

    /* renamed from: d  reason: collision with root package name */
    public d f58063d;

    /* renamed from: e  reason: collision with root package name */
    public d f58064e;

    /* renamed from: f  reason: collision with root package name */
    public d f58065f;

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
        this.f58060a = false;
        this.f58061b = null;
        this.f58062c = null;
        this.f58063d = new d();
        this.f58064e = new d();
        this.f58065f = new d();
        this.f58062c = str;
        this.f58061b = str2;
        this.f58060a = z;
    }
}
