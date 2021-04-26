package d.a.h0.g.k0.i.f;

import com.baidu.android.imsdk.internal.Constants;
import d.a.h0.a.r1.e;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.Request;
/* loaded from: classes3.dex */
public class a {
    public static void a(Callback callback) {
        b(callback, "6");
    }

    public static void b(Callback callback, String str) {
        if (e.h() == null) {
            return;
        }
        d.a.h0.g.w.b V = e.h().V();
        HttpUrl.Builder newBuilder = HttpUrl.parse("https://gamecenter.baidu.com/api/exchange/list").newBuilder();
        newBuilder.addQueryParameter(Constants.EXTRA_CONFIG_LIMIT, str);
        newBuilder.addQueryParameter(com.alipay.sdk.cons.b.f1831h, e.h().B());
        newBuilder.addQueryParameter("source", "4");
        V.b(new Request.Builder().url(newBuilder.build()).build(), callback);
    }
}
