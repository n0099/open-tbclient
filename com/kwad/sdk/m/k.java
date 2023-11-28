package com.kwad.sdk.m;

import android.content.Context;
import com.ksad.json.annotation.KsJson;
import com.kwad.sdk.service.ServiceProvider;
import com.kwad.sdk.utils.ah;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class k {
    public static a aRJ;

    @KsJson
    /* loaded from: classes10.dex */
    public static class a extends com.kwad.sdk.core.response.a.a {
        public List<String> aRK;
        public List<C0724a> aRL;

        @KsJson
        /* renamed from: com.kwad.sdk.m.k$a$a  reason: collision with other inner class name */
        /* loaded from: classes10.dex */
        public static class C0724a extends com.kwad.sdk.core.response.a.a {
            public String aRM;
            public String aRN;
        }
    }

    public static a Mx() {
        a aVar = aRJ;
        if (aVar != null) {
            return aVar;
        }
        JSONObject jSONObject = (JSONObject) ((com.kwad.sdk.service.a.h) ServiceProvider.get(com.kwad.sdk.service.a.h.class)).getAppConfigData(null, new com.kwad.sdk.g.b<JSONObject, JSONObject>() { // from class: com.kwad.sdk.m.k.1
            public static JSONObject m(JSONObject jSONObject2) {
                if (jSONObject2 != null) {
                    jSONObject2.optJSONObject("wrapperBlackConfig");
                    return null;
                }
                return null;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
            /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
            @Override // com.kwad.sdk.g.b
            public final /* synthetic */ JSONObject apply(JSONObject jSONObject2) {
                return m(jSONObject2);
            }
        });
        a aVar2 = new a();
        aRJ = aVar2;
        if (jSONObject == null) {
            return aVar2;
        }
        try {
            aVar2.parseJson(jSONObject);
        } catch (Throwable unused) {
        }
        return aRJ;
    }

    public static boolean a(Context context, a aVar) {
        String name = context.getClass().getName();
        for (String str : new CopyOnWriteArrayList(aVar.aRK)) {
            if (ah.a(str, name)) {
                com.kwad.sdk.core.e.c.d("WrapperBlackHelper", "isBlackClass");
                return true;
            }
        }
        return false;
    }

    public static boolean a(StackTraceElement stackTraceElement, a aVar) {
        String className = stackTraceElement.getClassName();
        String methodName = stackTraceElement.getMethodName();
        for (a.C0724a c0724a : new CopyOnWriteArrayList(aVar.aRL)) {
            String str = c0724a.aRM;
            String str2 = c0724a.aRN;
            if (ah.a(str, className) && ah.a(str2, methodName)) {
                com.kwad.sdk.core.e.c.d("WrapperBlackHelper", "isBlackMethod");
                return true;
            }
        }
        return false;
    }

    public static boolean dm(Context context) {
        a Mx = Mx();
        if (ah.M(Mx.aRK) || ah.M(Mx.aRL) || !a(context, Mx)) {
            return false;
        }
        for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
            if (a(stackTraceElement, Mx)) {
                return true;
            }
        }
        return false;
    }
}
