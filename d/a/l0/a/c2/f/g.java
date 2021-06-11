package d.a.l0.a.c2.f;

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
import d.a.l0.a.e2.c.j.b;
import d.a.l0.a.v2.o0;
import d.a.l0.a.v2.t0;
import d.a.l0.n.i.m.e;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class g extends a0 {

    /* loaded from: classes3.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ JSONObject f44696e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44697f;

        public a(JSONObject jSONObject, String str) {
            this.f44696e = jSONObject;
            this.f44697f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            g.this.o(this.f44696e, this.f44697f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.a.l0.a.v2.e1.b<d.a.l0.a.e2.c.i<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f44699e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f44700f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f44701g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44702h;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
            this.f44699e = unitedSchemeEntity;
            this.f44700f = callbackHandler;
            this.f44701g = jSONArray;
            this.f44702h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: a */
        public void onCallback(d.a.l0.a.e2.c.i<b.e> iVar) {
            g.this.m(iVar, this.f44699e, this.f44700f, this.f44701g, this.f44702h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44704e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44705f;

        public c(g gVar, List list, String str) {
            this.f44704e = list;
            this.f44705f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> h2 = d.a.l0.a.h0.m.p.a.h(this.f44704e);
            if (h2.isEmpty()) {
                return;
            }
            d.a.l0.n.i.m.b bVar = new d.a.l0.n.i.m.b((Collection<String>) h2, (d.a.l0.n.o.a) t0.b());
            bVar.e(this.f44705f);
            bVar.d("1");
            d.a.l0.a.h0.m.d dVar = new d.a.l0.a.h0.m.d();
            dVar.K(5);
            d.a.l0.n.b.d(bVar, dVar);
        }
    }

    public g(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/downloadPackages");
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        d.a.l0.a.e0.d.g("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
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
        if (!d.a.l0.a.h0.c.a.b.c(optString)) {
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "Network limitation");
            return false;
        }
        String l = l(callbackHandler);
        if (p(callbackHandler)) {
            if (eVar == null) {
                unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(1001, "swanApp is null");
                return false;
            }
            eVar.T().g(context, "mapp_pre_download", new b(unitedSchemeEntity, callbackHandler, optJSONArray, l));
            return true;
        }
        if (optJSONArray != null) {
            n(optJSONArray, l, false);
        }
        if (optJSONObject != null) {
            d.a.l0.a.v2.q.i(new a(optJSONObject, l), "handlePreDownloadByCommand");
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @NonNull
    public final String l(CallbackHandler callbackHandler) {
        return q(callbackHandler) ? "10" : "2";
    }

    public final void m(d.a.l0.a.e2.c.i<b.e> iVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
        if (!d.a.l0.a.e2.c.d.h(iVar)) {
            d.a.l0.a.e2.c.d.o(iVar, callbackHandler, unitedSchemeEntity);
            return;
        }
        n(jSONArray, str, true);
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
    }

    public final void n(@Nullable JSONArray jSONArray, String str, boolean z) {
        if (jSONArray == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            arrayList.add(jSONArray.optString(i2));
        }
        d.a.l0.a.v2.q.j(new c(this, arrayList, str), "小程序端能力-批量下载");
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
                                    arrayList2.add(o0.n(next, parse, false));
                                }
                            } catch (Exception e2) {
                                if (a0.f44625b) {
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
        d.a.l0.a.h0.c.a.b.a(arrayList, str, null);
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
