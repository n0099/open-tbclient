package d.a.q0.a.o0.d;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import io.flutter.embedding.android.FlutterActivityLaunchConfigs;
/* loaded from: classes8.dex */
public class e extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public String f49847c;

    /* renamed from: d  reason: collision with root package name */
    public String f49848d;

    /* renamed from: e  reason: collision with root package name */
    public String f49849e;

    /* renamed from: f  reason: collision with root package name */
    public String f49850f;

    /* renamed from: g  reason: collision with root package name */
    public String f49851g;

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
        this.f49835a = FlutterActivityLaunchConfigs.EXTRA_INITIAL_ROUTE;
    }

    @Override // d.a.q0.a.o0.d.a
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            String str2 = (d.a.q0.a.o0.a.c(str, "fromId", this.f49847c) + d.a.q0.a.o0.a.c(str, "toId", this.f49848d)) + d.a.q0.a.o0.a.c(str, "toTabIndex", this.f49851g);
            if (!TextUtils.isEmpty(this.f49849e)) {
                str2 = str2 + d.a.q0.a.o0.a.c(str, "routeType", this.f49849e);
            }
            if (TextUtils.isEmpty(this.f49850f)) {
                return str2;
            }
            return str2 + d.a.q0.a.o0.a.c(str, "toPage", this.f49850f);
        }
        return (String) invokeL.objValue;
    }
}
