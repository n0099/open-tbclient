package d.a.h0.a.t1.k;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.TypedCallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import d.a.h0.a.i2.i0;
import d.a.h0.a.i2.m0;
import d.a.h0.a.v1.c.i.b;
import d.a.h0.l.l.k.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class h extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44477e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44478f;

        public a(JSONObject jSONObject, String str) {
            this.f44477e = jSONObject;
            this.f44478f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.o(this.f44477e, this.f44478f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.h0.a.i2.u0.b<d.a.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44480e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44481f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44482g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44483h;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
            this.f44480e = unitedSchemeEntity;
            this.f44481f = callbackHandler;
            this.f44482g = jSONArray;
            this.f44483h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.a.h0.a.v1.c.h<b.e> hVar) {
            h.this.m(hVar, this.f44480e, this.f44481f, this.f44482g, this.f44483h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44485e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44486f;

        public c(h hVar, List list, String str) {
            this.f44485e = list;
            this.f44486f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> h2 = d.a.h0.a.e0.p.p.a.h(this.f44485e);
            if (h2.isEmpty()) {
                return;
            }
            d.a.h0.l.l.k.b bVar = new d.a.h0.l.l.k.b((Collection<String>) h2, (d.a.h0.l.r.a) m0.b());
            bVar.e(this.f44486f);
            bVar.d("1");
            d.a.h0.a.e0.p.d dVar = new d.a.h0.a.e0.p.d();
            dVar.K(5);
            d.a.h0.l.c.b(bVar, dVar);
        }
    }

    public h(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/downloadPackages");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        d.a.h0.a.c0.c.g("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
        JSONObject a2 = a0.a(unitedSchemeEntity, "params");
        if (a2 == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "invalid parameter");
            return false;
        }
        JSONArray optJSONArray = a2.optJSONArray("appKeys");
        JSONObject optJSONObject = a2.optJSONObject("appList");
        if ((optJSONArray == null || optJSONArray.length() == 0) && optJSONObject == null) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "appKeys must not empty");
            return false;
        }
        String optString = a2.optString("netconf");
        if (TextUtils.isEmpty(optString)) {
            optString = "0";
        }
        if (!d.a.h0.a.e0.h.a.a.c(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
            return false;
        }
        String l = l(callbackHandler);
        if (p(callbackHandler)) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            eVar.R().g(context, "mapp_pre_download", new b(unitedSchemeEntity, callbackHandler, optJSONArray, l));
            return true;
        }
        if (optJSONArray != null) {
            n(optJSONArray, l);
        }
        if (optJSONObject != null) {
            d.a.h0.a.i2.p.j(new a(optJSONObject, l), "handlePreDownloadByCommand");
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @NonNull
    public final String l(CallbackHandler callbackHandler) {
        return q(callbackHandler) ? "10" : "2";
    }

    public final void m(d.a.h0.a.v1.c.h<b.e> hVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
        if (!d.a.h0.a.v1.c.c.h(hVar)) {
            d.a.h0.a.v1.c.c.n(hVar, callbackHandler, unitedSchemeEntity);
            return;
        }
        n(jSONArray, str);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void n(@Nullable JSONArray jSONArray, String str) {
        if (jSONArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optString(i2));
        }
        d.a.h0.a.i2.p.k(new c(this, arrayList, str), "小程序端能力-批量下载");
    }

    @AnyThread
    public final void o(@NonNull JSONObject jSONObject, String str) {
        JSONArray optJSONArray;
        ArrayList arrayList = new ArrayList();
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            if (!TextUtils.isEmpty(next)) {
                e.b bVar = new e.b(next);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                if (optJSONObject != null && (optJSONArray = optJSONObject.optJSONArray("commands")) != null && optJSONArray.length() > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                        String optString = optJSONArray.optString(i2);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                Uri parse = Uri.parse(optString);
                                if (parse != null) {
                                    arrayList2.add(i0.m(next, parse, false));
                                }
                            } catch (Exception e2) {
                                if (a0.f44398b) {
                                    e2.printStackTrace();
                                }
                            }
                        }
                    }
                    if (!arrayList2.isEmpty()) {
                        bVar.j((String[]) arrayList2.toArray(new String[arrayList2.size()]));
                    }
                }
                arrayList.add(bVar);
            }
        }
        d.a.h0.a.e0.h.a.a.a(arrayList, str);
    }

    public final boolean p(CallbackHandler callbackHandler) {
        return q(callbackHandler);
    }

    public final boolean q(CallbackHandler callbackHandler) {
        if (callbackHandler instanceof TypedCallbackHandler) {
            int invokeSourceType = ((TypedCallbackHandler) callbackHandler).getInvokeSourceType();
            return invokeSourceType == 0 || invokeSourceType == 1;
        }
        return false;
    }
}
