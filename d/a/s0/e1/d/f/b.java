package d.a.s0.e1.d.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.s0.e1.d.e;
/* loaded from: classes9.dex */
public class b {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f58499a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f58500b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f58501c;

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
        this.f58499a = -1;
        this.f58500b = false;
        this.f58501c = false;
    }

    public void a(e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, eVar) == null) {
            this.f58500b = true;
            int i2 = this.f58499a;
            if (i2 == -1 || !this.f58501c) {
                return;
            }
            eVar.a(i2);
        }
    }

    public void b(int i2, e eVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, eVar) == null) {
            this.f58499a = i2;
            if (this.f58500b && this.f58501c) {
                eVar.a(i2);
            }
        }
    }
}
