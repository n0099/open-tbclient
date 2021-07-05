package d.a.s0.a4.p;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f57533a;

    /* renamed from: b  reason: collision with root package name */
    public String f57534b;

    /* renamed from: c  reason: collision with root package name */
    public String f57535c;

    /* renamed from: d  reason: collision with root package name */
    public String f57536d;

    /* renamed from: e  reason: collision with root package name */
    public String f57537e;

    /* renamed from: f  reason: collision with root package name */
    public String f57538f;

    /* renamed from: g  reason: collision with root package name */
    public String f57539g;

    /* renamed from: h  reason: collision with root package name */
    public String f57540h;

    /* renamed from: i  reason: collision with root package name */
    public String f57541i;
    public String j;
    public String k;
    public String l;
    public String m;

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
            }
        }
    }
}
