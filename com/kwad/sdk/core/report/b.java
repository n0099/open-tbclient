package com.kwad.sdk.core.report;

import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.kwad.sdk.core.report.y;
import com.kwad.sdk.core.response.model.AdInfo;
import com.kwad.sdk.core.response.model.AdTemplate;
import com.kwad.sdk.export.proxy.AdHttpProxy;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ab;
import com.kwad.sdk.utils.ac;
import com.kwad.sdk.utils.ah;
import com.kwad.sdk.utils.bn;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class b {
    public static boolean cz(int i) {
        return i >= 200 && i < 300;
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x004b, code lost:
        r4.addAll(r6.urls);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static List<String> a(int i, y.b bVar, List<String> list, AdInfo adInfo, List<AdInfo.AdTrackInfo> list2) {
        int i2;
        if (i == 402 && com.kwad.sdk.core.response.b.a.bl(adInfo)) {
            try {
                if (!TextUtils.isEmpty(bVar.Xd)) {
                    i2 = new JSONObject(bVar.Xd).optInt("photoPlaySecond");
                } else {
                    i2 = bVar.axk;
                }
                JSONObject jSONObject = new JSONObject(adInfo.adBaseInfo.videoPlayedNSConfig);
                Iterator<AdInfo.AdTrackInfo> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    AdInfo.AdTrackInfo next = it.next();
                    if (next.type == jSONObject.optInt(String.valueOf(i2)) && next.urls != null) {
                        break;
                    }
                }
            } catch (Throwable unused) {
            }
            return list;
        }
        return null;
    }

    public static void a(@NonNull AdTemplate adTemplate, int i, @NonNull y.b bVar) {
        ac.a aVar;
        int i2;
        List<String> b = b(adTemplate, i, bVar);
        if (ah.M(b)) {
            return;
        }
        for (String str : b) {
            com.kwad.sdk.commercial.j.a.p(adTemplate, i, str);
            if (adTemplate.isCheatingFlow()) {
                com.kwad.sdk.commercial.j.a.o(adTemplate, i, str);
                return;
            } else if (bn.gt(str)) {
                com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, "", 100001, "", 0);
                return;
            } else {
                if (i == 2) {
                    aVar = bVar.km;
                } else {
                    aVar = null;
                }
                String a = ab.a(ServiceProvider.getContext(), str, aVar, com.kwad.sdk.core.response.b.a.aB(com.kwad.sdk.core.response.b.e.dP(adTemplate)));
                AdHttpProxy xI = com.kwad.sdk.f.xI();
                if (xI instanceof com.kwad.sdk.core.network.c.a) {
                    i2 = 2;
                } else {
                    i2 = 1;
                }
                com.kwad.sdk.core.network.c doGetWithoutResponse = xI.doGetWithoutResponse(a, null);
                if (cz(doGetWithoutResponse.code)) {
                    com.kwad.sdk.core.e.c.d("AdTrackUtil", "trackUrl request success actionType: " + i);
                    com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, doGetWithoutResponse.code, i2);
                } else {
                    com.kwad.sdk.commercial.j.a.a(adTemplate, i, str, a, com.kwad.sdk.commercial.c.bU(doGetWithoutResponse.code), doGetWithoutResponse.atm, i2);
                }
            }
        }
    }

    public static List<String> b(AdTemplate adTemplate, int i, @NonNull y.b bVar) {
        List<String> list;
        ArrayList arrayList = new ArrayList();
        AdInfo dP = com.kwad.sdk.core.response.b.e.dP(adTemplate);
        List<AdInfo.AdTrackInfo> list2 = dP.adTrackInfoList;
        if (ah.M(list2)) {
            return arrayList;
        }
        List<String> a = a(i, bVar, arrayList, dP, list2);
        if (a != null) {
            return a;
        }
        Iterator<AdInfo.AdTrackInfo> it = list2.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            AdInfo.AdTrackInfo next = it.next();
            if (next.type == i && (list = next.urls) != null) {
                arrayList.addAll(list);
                break;
            }
        }
        return arrayList;
    }
}
