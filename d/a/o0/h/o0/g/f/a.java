package d.a.o0.h.o0.g.f;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes7.dex */
public class a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(Callback callback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65536, null, callback) == null) {
            b(callback, "6");
        }
    }

    public static void b(Callback callback, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(65537, null, callback, str) == null) || d.a.o0.a.a2.e.i() == null) {
            return;
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/exchange/list").newBuilder();
        newBuilder.addQueryParameter(Constants.EXTRA_CONFIG_LIMIT, str);
        newBuilder.addQueryParameter("app_key", d.a.o0.a.a2.e.i().D());
        newBuilder.addQueryParameter("source", "4");
        ((d.a.o0.h.y.b) d.a.o0.a.a2.e.i().X()).b(new Request.Builder().url(newBuilder.build()).build(), callback);
    }
}
