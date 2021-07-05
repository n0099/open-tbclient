package d.a.s0.u0.p2.j;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import d.a.r0.r.d0.b;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: a  reason: collision with root package name */
    public int f66833a;

    /* renamed from: b  reason: collision with root package name */
    public Set<String> f66834b;

    /* renamed from: c  reason: collision with root package name */
    public int f66835c;

    /* renamed from: d  reason: collision with root package name */
    public long f66836d;

    public a() {
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
        this.f66835c = -1;
        this.f66836d = -1L;
        this.f66833a = b.j().k("nani_key_download_show_position", 3);
        new HashSet();
        this.f66834b = new HashSet();
    }

    public void a(int i2, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048576, this, i2, str) == null) {
            this.f66834b.add(str);
            if (this.f66835c >= 0 || this.f66833a != this.f66834b.size()) {
                return;
            }
            this.f66835c = i2;
        }
    }

    public int b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.f66835c : invokeV.intValue;
    }

    public void c(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.f66836d = j;
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int k = b.j().k("nani_key_download_show_rate", 2);
            if (this.f66836d <= 0 || k == 1) {
                return;
            }
            b.j().w("key_horizontal_shown_time", this.f66836d);
        }
    }
}
