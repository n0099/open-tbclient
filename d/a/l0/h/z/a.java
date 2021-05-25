package d.a.l0.h.z;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.a.l0.a.k;
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f47768a = k.f43199a;

    public <T> void a(String str, String str2, ResponseCallback<T> responseCallback) {
        if (f47768a) {
            Log.d("requestWithUrlAndBody", HttpRetryStatistic.RETRY_URL + str + "\nbody:" + str2);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.l0.a.p.d.d d2 = d.a.l0.a.c1.a.d();
        if (d2.h() && d2.g(str)) {
            d2.e(str, str2, responseCallback);
            return;
        }
        d.a.l0.m.e.a.g().postStringRequest().url(str).cookieManager(d.a.l0.a.c1.a.p().a()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
    }
}
