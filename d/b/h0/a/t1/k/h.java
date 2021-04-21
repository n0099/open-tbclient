package d.b.h0.a.t1.k;

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
import d.b.h0.a.i2.i0;
import d.b.h0.a.i2.m0;
import d.b.h0.a.v1.c.i.b;
import d.b.h0.l.l.k.e;
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
        public final /* synthetic */ JSONObject f47085e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47086f;

        public a(JSONObject jSONObject, String str) {
            this.f47085e = jSONObject;
            this.f47086f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            h.this.o(this.f47085e, this.f47086f);
        }
    }

    /* loaded from: classes3.dex */
    public class b implements d.b.h0.a.i2.u0.b<d.b.h0.a.v1.c.h<b.e>> {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ UnitedSchemeEntity f47088e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ CallbackHandler f47089f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ JSONArray f47090g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f47091h;

        public b(UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
            this.f47088e = unitedSchemeEntity;
            this.f47089f = callbackHandler;
            this.f47090g = jSONArray;
            this.f47091h = str;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: a */
        public void onCallback(d.b.h0.a.v1.c.h<b.e> hVar) {
            h.this.m(hVar, this.f47088e, this.f47089f, this.f47090g, this.f47091h);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f47092e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f47093f;

        public c(h hVar, List list, String str) {
            this.f47092e = list;
            this.f47093f = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            List<String> h2 = d.b.h0.a.e0.p.p.a.h(this.f47092e);
            if (h2.isEmpty()) {
                return;
            }
            d.b.h0.l.l.k.b bVar = new d.b.h0.l.l.k.b((Collection<String>) h2, (d.b.h0.l.r.a) m0.b());
            bVar.e(this.f47093f);
            bVar.d("1");
            d.b.h0.a.e0.p.d dVar = new d.b.h0.a.e0.p.d();
            dVar.K(5);
            d.b.h0.l.c.b(bVar, dVar);
        }
    }

    public h(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/downloadPackages");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        d.b.h0.a.c0.c.g("DownloadPackagesAction", "call DownloadPackagesAction, thread=" + Thread.currentThread().getName());
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
        if (!d.b.h0.a.e0.h.a.a.c(optString)) {
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
            d.b.h0.a.i2.p.j(new a(optJSONObject, l), "handlePreDownloadByCommand");
        }
        UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
        return true;
    }

    @NonNull
    public final String l(CallbackHandler callbackHandler) {
        return q(callbackHandler) ? "10" : "2";
    }

    public final void m(d.b.h0.a.v1.c.h<b.e> hVar, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, JSONArray jSONArray, String str) {
        if (!d.b.h0.a.v1.c.c.h(hVar)) {
            d.b.h0.a.v1.c.c.n(hVar, callbackHandler, unitedSchemeEntity);
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
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.optString(i));
        }
        d.b.h0.a.i2.p.k(new c(this, arrayList, str), "小程序端能力-批量下载");
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
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        String optString = optJSONArray.optString(i);
                        if (!TextUtils.isEmpty(optString)) {
                            try {
                                Uri parse = Uri.parse(optString);
                                if (parse != null) {
                                    arrayList2.add(i0.m(next, parse, false));
                                }
                            } catch (Exception e2) {
                                if (a0.f47009b) {
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
        d.b.h0.a.e0.h.a.a.a(arrayList, str);
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
