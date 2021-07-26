package d.a.q0.w2.c0.o;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f66535a;

    /* renamed from: b  reason: collision with root package name */
    public long f66536b;

    /* renamed from: c  reason: collision with root package name */
    public long f66537c;

    /* renamed from: d  reason: collision with root package name */
    public long f66538d;

    /* renamed from: e  reason: collision with root package name */
    public long f66539e;

    /* renamed from: f  reason: collision with root package name */
    public String f66540f;

    /* renamed from: g  reason: collision with root package name */
    public int f66541g;

    /* renamed from: h  reason: collision with root package name */
    public int f66542h;

    /* renamed from: i  reason: collision with root package name */
    public String f66543i;
    public String j;
    public String k;
    public String l;

    public e() {
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
        this.f66536b = -1L;
        this.f66539e = -1L;
        this.f66540f = "";
        this.f66543i = null;
    }
}
