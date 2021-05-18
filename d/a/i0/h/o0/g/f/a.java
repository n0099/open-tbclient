package d.a.i0.h.o0.g.f;

import com.baidu.android.imsdk.internal.Constants;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes3.dex */
public class a {
    public static void a(Callback callback) {
        b(callback, "6");
    }

    public static void b(Callback callback, String str) {
        if (d.a.i0.a.a2.e.i() == null) {
            return;
        }
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/exchange/list").newBuilder();
        newBuilder.addQueryParameter(Constants.EXTRA_CONFIG_LIMIT, str);
        newBuilder.addQueryParameter("app_key", d.a.i0.a.a2.e.i().D());
        newBuilder.addQueryParameter("source", "4");
        ((d.a.i0.h.y.b) d.a.i0.a.a2.e.i().X()).b(new Request.Builder().url(newBuilder.build()).build(), callback);
    }
}
