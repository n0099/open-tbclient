package d.a.p0.n0;

import android.content.Context;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class f {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public Context f52785a;

    /* renamed from: b  reason: collision with root package name */
    public int f52786b;

    /* renamed from: c  reason: collision with root package name */
    public String f52787c;

    /* renamed from: d  reason: collision with root package name */
    public Long f52788d;

    /* renamed from: e  reason: collision with root package name */
    public b f52789e;

    public f(Context context, int i2, String str, Long l, b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Integer.valueOf(i2), str, l, bVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52785a = context;
        this.f52786b = i2;
        this.f52787c = str;
        this.f52788d = l;
        this.f52789e = bVar;
    }
}
