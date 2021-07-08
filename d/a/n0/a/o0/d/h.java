package d.a.n0.a.o0.d;

import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class h extends a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: c  reason: collision with root package name */
    public final String f46554c;

    /* renamed from: d  reason: collision with root package name */
    public final String f46555d;

    public h(@Nullable String str, @Nullable String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f46554c = str;
        this.f46555d = str2;
        this.f46533a = "firstMeaningfulPainted";
    }

    @Override // d.a.n0.a.o0.d.a
    public String f(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append(d.a.n0.a.o0.a.c(str, PrefetchEvent.EVENT_DATA_WEBVIEW_ID, TextUtils.isEmpty(this.f46554c) ? "" : this.f46554c));
            sb.append(d.a.n0.a.o0.a.c(str, "pageUrl", TextUtils.isEmpty(this.f46555d) ? "" : this.f46555d));
            return sb.toString();
        }
        return (String) invokeL.objValue;
    }
}
