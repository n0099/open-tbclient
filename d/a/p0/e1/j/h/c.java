package d.a.p0.e1.j.h;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.c.k.e.n;
import d.a.o0.r.q.l0;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class c {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<n> f55725a;

    /* renamed from: b  reason: collision with root package name */
    public int f55726b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f55727c;

    /* renamed from: d  reason: collision with root package name */
    public int f55728d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.o0.r.q.n f55729e;

    /* renamed from: f  reason: collision with root package name */
    public l0 f55730f;

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
        this.f55726b = 0;
        this.f55727c = true;
        this.f55728d = 1;
    }
}
