package d.a.s0.l0.l.d;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.q.p1;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public p1 f63019a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<n> f63020b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f63021c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f63022d;

    /* renamed from: e  reason: collision with root package name */
    public int f63023e;

    /* renamed from: f  reason: collision with root package name */
    public int f63024f;

    /* renamed from: g  reason: collision with root package name */
    public c f63025g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f63026h;

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
        this.f63021c = true;
        this.f63022d = true;
        this.f63023e = 0;
        this.f63024f = 0;
        this.f63026h = true;
        this.f63020b = new ArrayList<>();
        this.f63019a = new p1();
    }
}
