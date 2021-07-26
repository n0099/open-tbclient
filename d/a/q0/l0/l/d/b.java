package d.a.q0.l0.l.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.p1;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p1 f60396a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f60397b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f60398c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f60399d;

    /* renamed from: e  reason: collision with root package name */
    public int f60400e;

    /* renamed from: f  reason: collision with root package name */
    public int f60401f;

    /* renamed from: g  reason: collision with root package name */
    public c f60402g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60403h;

    public b() {
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
        this.f60398c = true;
        this.f60399d = true;
        this.f60400e = 0;
        this.f60401f = 0;
        this.f60403h = true;
        this.f60397b = new ArrayList<>();
        this.f60396a = new p1();
    }
}
