package d.a.s0.e1.j.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.r0.r.q.l0;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f58980a;

    /* renamed from: b  reason: collision with root package name */
    public int f58981b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58982c;

    /* renamed from: d  reason: collision with root package name */
    public int f58983d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.r0.r.q.n f58984e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f58985f;

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
        this.f58981b = 0;
        this.f58982c = true;
        this.f58983d = 1;
    }
}
