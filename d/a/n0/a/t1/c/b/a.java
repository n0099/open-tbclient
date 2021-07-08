package d.a.n0.a.t1.c.b;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public String f47372a;

    /* renamed from: b  reason: collision with root package name */
    public String f47373b;

    /* renamed from: c  reason: collision with root package name */
    public String f47374c;

    /* renamed from: d  reason: collision with root package name */
    public int f47375d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f47376e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47377f;

    public a() {
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
        this.f47375d = -1;
        this.f47376e = false;
        this.f47377f = false;
    }
}
