package d.a.q0.e1.j.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.d.k.e.n;
import d.a.p0.s.q.l0;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f56269a;

    /* renamed from: b  reason: collision with root package name */
    public int f56270b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56271c;

    /* renamed from: d  reason: collision with root package name */
    public int f56272d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.p0.s.q.n f56273e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f56274f;

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
        this.f56270b = 0;
        this.f56271c = true;
        this.f56272d = 1;
    }
}
