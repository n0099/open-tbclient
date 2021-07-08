package d.a.p0.l0.l.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.q.p1;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p1 f59782a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f59783b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59784c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59785d;

    /* renamed from: e  reason: collision with root package name */
    public int f59786e;

    /* renamed from: f  reason: collision with root package name */
    public int f59787f;

    /* renamed from: g  reason: collision with root package name */
    public c f59788g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f59789h;

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
        this.f59784c = true;
        this.f59785d = true;
        this.f59786e = 0;
        this.f59787f = 0;
        this.f59789h = true;
        this.f59783b = new ArrayList<>();
        this.f59782a = new p1();
    }
}
