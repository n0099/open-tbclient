package d.a.m0.h.z;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.m0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f51550a = k.f46983a;

    public <T> void a(String str, String str2, ResponseCallback<T> responseCallback) {
        if (f51550a) {
            Log.d("requestWithUrlAndBody", HttpRetryStatistic.RETRY_URL + str + "\nbody:" + str2);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.m0.a.p.d.d d2 = d.a.m0.a.c1.a.d();
        if (d2.h() && d2.g(str)) {
            d2.e(str, str2, responseCallback);
            return;
        }
        d.a.m0.m.e.a.g().postStringRequest().url(str).cookieManager(d.a.m0.a.c1.a.p().a()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
    }
}
