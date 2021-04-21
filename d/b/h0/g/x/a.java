package d.b.h0.g.x;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.down.retry.HttpRetryStatistic;
import com.baidu.searchbox.http.callback.ResponseCallback;
import d.b.h0.a.k;
/* loaded from: classes3.dex */
public class a extends d.b.h0.g.d.i.a {

    /* renamed from: h  reason: collision with root package name */
    public static final boolean f49354h = k.f45772a;

    public <T> void q(String str, String str2, ResponseCallback<T> responseCallback) {
        if (f49354h) {
            Log.d("requestWithUrlAndBody", HttpRetryStatistic.RETRY_URL + str + "\nbody:" + str2);
        }
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (d.b.h0.g.d.c.b().c() && d.b.h0.g.d.c.b().d(str)) {
            p(str, str2, responseCallback);
            return;
        }
        d.b.h0.k.e.a.f().postStringRequest().url(str).cookieManager(d.b.h0.a.w0.a.m().a()).mediaType("application/json;charset=utf-8").content(str2).build().executeAsync(responseCallback);
    }
}
