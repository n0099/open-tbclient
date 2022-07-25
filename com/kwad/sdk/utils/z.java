package com.kwad.sdk.utils;

import android.content.Context;
import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import com.kwad.sdk.utils.aa;
/* loaded from: classes5.dex */
public final class z {
    @WorkerThread
    public static String a(Context context, String str, aa.a aVar) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String S = aa.S(context, aa.a(str, aVar));
        String cK = ar.cK(context);
        if (!TextUtils.isEmpty(cK)) {
            S = S.replace("__MAC__", cK).replace("__MAC2__", ab.dI(cK)).replace("__MAC3__", ab.dI(cK.replace(":", "")));
        }
        String cI = ar.cI(context);
        if (!TextUtils.isEmpty(cI)) {
            S = S.replace("__IMEI__", cI).replace("__IMEI2__", ab.dI(cI)).replace("__IMEI3__", ab.dJ(cI));
        }
        String oaid = ar.getOaid();
        if (!TextUtils.isEmpty(oaid)) {
            S = S.replace("__OAID__", oaid).replace("__OAID2__", ab.dI(oaid));
        }
        String cJ = ar.cJ(context);
        if (!TextUtils.isEmpty(cJ)) {
            S = S.replace("__ANDROIDID2__", ab.dI(cJ)).replace("__ANDROIDID3__", ab.dJ(cJ)).replace("__ANDROIDID__", cJ);
        }
        return aa.R(context, S);
    }
}
