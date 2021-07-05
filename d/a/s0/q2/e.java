package d.a.s0.q2;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public final boolean f64943a;

    /* renamed from: b  reason: collision with root package name */
    public final int f64944b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f64945c;

    /* renamed from: d  reason: collision with root package name */
    public final String f64946d;

    public e(boolean z, int i2, boolean z2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Boolean.valueOf(z), Integer.valueOf(i2), Boolean.valueOf(z2), str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f64943a = z;
        this.f64944b = i2;
        this.f64945c = z2;
        this.f64946d = str;
    }
}
