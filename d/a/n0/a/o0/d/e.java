package d.a.n0.a.o0.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes7.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f46545c;

    /* renamed from: d  reason: collision with root package name */
    public String f46546d;

    /* renamed from: e  reason: collision with root package name */
    public String f46547e;

    /* renamed from: f  reason: collision with root package name */
    public String f46548f;

    /* renamed from: g  reason: collision with root package name */
    public String f46549g;

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
        this.f46533a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.a.n0.a.o0.d.a
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = (d.a.n0.a.o0.a.c(str, "fromId", this.f46545c) + d.a.n0.a.o0.a.c(str, "toId", this.f46546d)) + d.a.n0.a.o0.a.c(str, "toTabIndex", this.f46549g);
            if (!TextUtils.isEmpty(this.f46547e)) {
                str2 = str2 + d.a.n0.a.o0.a.c(str, "routeType", this.f46547e);
            }
            if (TextUtils.isEmpty(this.f46548f)) {
                return str2;
            }
            return str2 + d.a.n0.a.o0.a.c(str, "toPage", this.f46548f);
        }
        return (String) invokeL.objValue;
    }
}
