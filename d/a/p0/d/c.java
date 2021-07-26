package d.a.p0.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f52224a;

    /* renamed from: b  reason: collision with root package name */
    public int f52225b;

    /* renamed from: c  reason: collision with root package name */
    public String f52226c;

    /* renamed from: d  reason: collision with root package name */
    public String f52227d;

    /* renamed from: e  reason: collision with root package name */
    public String f52228e;

    /* renamed from: f  reason: collision with root package name */
    public int f52229f;

    public c() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f52224a = -1;
        this.f52225b = -1;
        this.f52229f = -1;
    }
}
