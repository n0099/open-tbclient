package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.y;
/* loaded from: classes5.dex */
public final class x {
    @WorkerThread
    public static String a(Context context, String str, y.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String b = y.b(context, y.a(str, aVar));
        String d = ao.d(context);
        if (!TextUtils.isEmpty(d)) {
            b = b.replace("__MAC__", d).replace("__MAC2__", z.a(d)).replace("__MAC3__", z.a(d.replace(":", "")));
        }
        String b2 = ao.b(context);
        if (!TextUtils.isEmpty(b2)) {
            b = b.replace("__IMEI__", b2).replace("__IMEI2__", z.a(b2)).replace("__IMEI3__", z.b(b2));
        }
        String a = ao.a();
        if (!TextUtils.isEmpty(a)) {
            b = b.replace("__OAID__", a).replace("__OAID2__", z.a(a));
        }
        String c = ao.c(context);
        if (!TextUtils.isEmpty(c)) {
            b = b.replace("__ANDROIDID2__", z.a(c)).replace("__ANDROIDID3__", z.b(c)).replace("__ANDROIDID__", c);
        }
        return y.a(context, b);
    }
}
