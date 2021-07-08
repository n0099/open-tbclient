package d.a.p0.w2.c0.m;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes8.dex */
public class e {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public long f65860a;

    /* renamed from: b  reason: collision with root package name */
    public long f65861b;

    /* renamed from: c  reason: collision with root package name */
    public long f65862c;

    /* renamed from: d  reason: collision with root package name */
    public long f65863d;

    /* renamed from: e  reason: collision with root package name */
    public long f65864e;

    /* renamed from: f  reason: collision with root package name */
    public String f65865f;

    /* renamed from: g  reason: collision with root package name */
    public int f65866g;

    /* renamed from: h  reason: collision with root package name */
    public int f65867h;

    /* renamed from: i  reason: collision with root package name */
    public String f65868i;
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
        this.f65861b = -1L;
        this.f65864e = -1L;
        this.f65865f = "";
        this.f65868i = null;
    }
}
