package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.ac;
/* loaded from: classes10.dex */
public final class ab {
    @WorkerThread
    public static String a(Context context, String str, ac.a aVar, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String am = ac.am(context, ac.a(str, aVar));
        String cx = av.cx(context);
        if (!TextUtils.isEmpty(cx)) {
            am = am.replace("__MAC__", cx).replace("__MAC2__", ad.bn(cx)).replace("__MAC3__", ad.bn(cx.replace(":", "")));
        }
        String cv = av.cv(context);
        if (!TextUtils.isEmpty(cv)) {
            am = am.replace("__IMEI__", cv).replace("__IMEI2__", ad.bn(cv)).replace("__IMEI3__", ad.fQ(cv));
        }
        String oaid = av.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            am = am.replace("__OAID__", oaid).replace("__OAID2__", ad.bn(oaid));
        }
        String cw = av.cw(context);
        if (!TextUtils.isEmpty(cw)) {
            am = am.replace("__ANDROIDID2__", ad.bn(cw)).replace("__ANDROIDID3__", ad.fQ(cw)).replace("__ANDROIDID__", cw);
        }
        return ac.c(context, am, z);
    }
}
