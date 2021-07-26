package d.a.p0.t.c;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class w {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f53847a;

    /* renamed from: b  reason: collision with root package name */
    public String f53848b;

    /* renamed from: c  reason: collision with root package name */
    public String f53849c;

    /* renamed from: d  reason: collision with root package name */
    public int f53850d;

    /* renamed from: e  reason: collision with root package name */
    public int f53851e;

    /* renamed from: f  reason: collision with root package name */
    public int f53852f;

    /* renamed from: g  reason: collision with root package name */
    public int f53853g;

    /* renamed from: h  reason: collision with root package name */
    public int f53854h;

    public w() {
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
