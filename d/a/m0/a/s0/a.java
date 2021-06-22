package d.a.m0.a.s0;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.database.Cursor;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.searchbox.unitedscheme.CallbackHandler;
import com.baidu.searchbox.unitedscheme.UnitedSchemeEntity;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import com.baidu.swan.apps.database.subscribe.SwanAppSubscribeMsgProvider;
import d.a.m0.a.c2.f.a0;
import d.a.m0.a.s0.c;
import d.a.m0.a.v2.q;
import d.a.m0.a.v2.q0;
import d.a.m0.a.v2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public Context f48382c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.a.a2.e f48383d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f48384e;

    /* renamed from: d.a.m0.a.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0875a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f48385a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f48386b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48387c;

        public C0875a(l lVar, String[] strArr, String str) {
            this.f48385a = lVar;
            this.f48386b = strArr;
            this.f48387c = str;
        }

        @Override // d.a.m0.a.s0.a.k
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                a.this.B(this.f48385a, Arrays.asList(this.f48386b), this.f48387c);
                return;
            }
            a.this.C(this.f48385a, this.f48387c, linkedHashMap, list);
            if (a0.f44733b) {
                Iterator<String> it = linkedHashMap.keySet().iterator();
                while (it.hasNext()) {
                    Log.i("GetFormIdAction", "querySubscribeInfo unallowedTemplateId=" + it.next());
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48389e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f48390f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f48391g;

        public b(String str, String[] strArr, k kVar) {
            this.f48389e = str;
            this.f48390f = strArr;
            this.f48391g = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            HashMap hashMap = new HashMap();
            if (a.this.w()) {
                Cursor query = a.this.f48382c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f48389e}, null);
                if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                    do {
                        hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                    } while (query.moveToNext());
                    d.a.m0.t.d.d(query);
                }
            }
            LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
            ArrayList arrayList = new ArrayList();
            for (String str : this.f48390f) {
                Integer num = (Integer) hashMap.get(str);
                if (num == null) {
                    linkedHashMap.put(str, Boolean.FALSE);
                } else if (num.intValue() != 1) {
                    linkedHashMap.put(str, Boolean.TRUE);
                } else {
                    arrayList.add(str);
                }
            }
            this.f48391g.a(linkedHashMap, arrayList);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48393a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f48394b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f48395c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f48396d;

        /* renamed from: d.a.m0.a.s0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0876a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f48398e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f48399f;

            public RunnableC0876a(List list, String str) {
                this.f48398e = list;
                this.f48399f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = a.this.f48382c.getContentResolver();
                for (d.a.m0.a.s0.d dVar : this.f48398e) {
                    String str = dVar.f48446a;
                    Boolean bool = (Boolean) c.this.f48394b.get(str);
                    if (bool != null && !bool.booleanValue()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appKey", c.this.f48395c.f48426a);
                        contentValues.put("templateId", str);
                        contentValues.put("result", (Integer) 0);
                        contentValues.put("title", dVar.f48447b);
                        contentValues.put("tips", this.f48399f);
                        contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48401e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f48402f;

            public b(String str, List list) {
                this.f48401e = str;
                this.f48402f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                a.this.D(cVar.f48395c, this.f48401e, cVar.f48393a, this.f48402f, cVar.f48396d);
            }
        }

        public c(String str, LinkedHashMap linkedHashMap, l lVar, List list) {
            this.f48393a = str;
            this.f48394b = linkedHashMap;
            this.f48395c = lVar;
            this.f48396d = list;
        }

        @Override // d.a.m0.a.s0.a.j
        public void a(@Nullable String str, List<d.a.m0.a.s0.d> list, boolean z) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                q.j(new RunnableC0876a(list, str), "createFormDataBase");
                if (z && this.f48395c.f48430e) {
                    a.this.x(this.f48395c, this.f48393a, str, list, this.f48396d);
                    return;
                } else {
                    q0.X(new b(str, list));
                    return;
                }
            }
            a.this.f48384e.handleSchemeDispatchCallback(this.f48393a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f48404a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f48405b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48406c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f48407d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f48408e;

        public d(l lVar, List list, String str, String str2, List list2) {
            this.f48404a = lVar;
            this.f48405b = list;
            this.f48406c = str;
            this.f48407d = str2;
            this.f48408e = list2;
        }

        @Override // d.a.m0.a.s0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<d.a.m0.a.s0.d> list) {
            boolean z = i2 == -1;
            if (a0.f44733b) {
                Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z);
            }
            if (z && list.size() == 0) {
                return false;
            }
            a.this.z(z ? "permit_click" : "reject_click", this.f48404a.f48429d, this.f48405b, list);
            if (z) {
                a.this.x(this.f48404a, this.f48406c, this.f48407d, list, this.f48408e);
                return true;
            }
            if (a.this.w()) {
                a.this.F(this.f48404a.f48426a, list, this.f48407d, false);
            }
            a.this.f48384e.handleSchemeDispatchCallback(this.f48406c, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48410e;

        public e(String str) {
            this.f48410e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.this.f48384e.handleSchemeDispatchCallback(this.f48410e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.m0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48412e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f48413f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48414g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48415h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f48416i;
        public final /* synthetic */ List j;

        public f(boolean z, l lVar, String str, String str2, List list, List list2) {
            this.f48412e = z;
            this.f48413f = lVar;
            this.f48414g = str;
            this.f48415h = str2;
            this.f48416i = list;
            this.j = list2;
        }

        @Override // d.a.m0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                if (!this.f48412e && a.this.w()) {
                    d.a.m0.a.j2.k.M("success", 12, "component");
                }
                a.this.E(this.f48413f, this.f48414g, this.f48415h, this.f48416i, this.j);
                return;
            }
            if (!this.f48412e && !a.this.w()) {
                d.a.m0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.a.g0, 12, "component");
            }
            a.this.f48384e.handleSchemeDispatchCallback(this.f48414g, UnitedSchemeUtility.wrapCallbackParams(500106, "用户未登录").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f48417e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48418f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f48419g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48420h;

        public g(List list, String str, boolean z, String str2) {
            this.f48417e = list;
            this.f48418f = str;
            this.f48419g = z;
            this.f48420h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver contentResolver = a.this.f48382c.getContentResolver();
            for (d.a.m0.a.s0.d dVar : this.f48417e) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", dVar.f48447b);
                contentValues.put("tips", this.f48418f);
                contentValues.put("result", Integer.valueOf(this.f48419g ? 1 : -1));
                contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f48420h, dVar.f48446a});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.m0.a.s0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48422a;

        public h(String str) {
            this.f48422a = str;
        }

        @Override // d.a.m0.a.x1.a
        public void a(JSONObject jSONObject) {
            a.this.f48384e.handleSchemeDispatchCallback(this.f48422a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.m0.a.x1.c.f49544c.c()) {
                return;
            }
            if (d.a.m0.a.c1.a.a0().e(a.this.f48382c)) {
                d.a.m0.a.x1.c.f49544c.e();
            } else {
                d.a.m0.a.x1.c.f49544c.f();
            }
        }

        @Override // d.a.m0.a.x1.a
        public void onFail(String str) {
            a.this.f48384e.handleSchemeDispatchCallback(this.f48422a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.m0.a.s0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48424a;

        public i(String str) {
            this.f48424a = str;
        }

        @Override // d.a.m0.a.x1.a
        public void a(JSONObject jSONObject) {
            a.this.f48384e.handleSchemeDispatchCallback(this.f48424a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.m0.a.c1.a.a0().e(a.this.f48382c)) {
                d.a.m0.a.x1.c.f49544c.e();
            } else {
                d.a.m0.a.x1.c.f49544c.f();
            }
        }

        @Override // d.a.m0.a.x1.a
        public void onFail(String str) {
            a.this.f48384e.handleSchemeDispatchCallback(this.f48424a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(@Nullable String str, @Nullable List<d.a.m0.a.s0.d> list, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface k {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    /* loaded from: classes3.dex */
    public static class l {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f48426a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f48427b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48428c;

        /* renamed from: d  reason: collision with root package name */
        public String f48429d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f48430e;

        public l(@NonNull String str, @NonNull String str2) {
            this.f48426a = str;
            this.f48427b = str2;
        }
    }

    public a(d.a.m0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getFormId");
    }

    public final void A(@NonNull String str, @NonNull String str2) {
        if (!w()) {
            this.f48384e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(w.f(null, "data", w.f(null, "formid", "")), 0).toString());
            return;
        }
        d.a.m0.a.c1.a.R().c(str, new h(str2));
    }

    public final void B(@NonNull l lVar, @NonNull List<String> list, @NonNull String str) {
        d.a.m0.a.c1.a.R().d(lVar.f48426a, list, lVar.f48427b, lVar.f48428c, new i(str));
    }

    @AnyThread
    public final void C(@NonNull l lVar, String str, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
        d.a.m0.a.c1.a.R().a(lVar.f48426a, linkedHashMap.keySet(), new c(str, linkedHashMap, lVar, list));
    }

    public final void D(@NonNull l lVar, String str, String str2, List<d.a.m0.a.s0.d> list, @NonNull List<String> list2) {
        d.a.m0.a.s0.c.a((Activity) this.f48382c, this.f48383d, str, list, new d(lVar, list, str2, str, list2), new e(str2)).show();
        z("show", lVar.f48429d, list, list);
    }

    public final void E(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.m0.a.s0.d> list, @NonNull List<String> list2) {
        F(lVar.f48426a, list, str2, true);
        for (d.a.m0.a.s0.d dVar : list) {
            list2.add(dVar.f48446a);
        }
        B(lVar, list2, str);
    }

    public final void F(String str, List<d.a.m0.a.s0.d> list, String str2, boolean z) {
        q.f().execute(new g(list, str2, z, str));
    }

    @Override // d.a.m0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.m0.a.a2.e eVar) {
        String[] strArr;
        if (unitedSchemeEntity == null) {
            if (a0.f44733b) {
                Log.w("GetFormIdAction", "entity is null");
            }
            return false;
        } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
            this.f48382c = context;
            this.f48383d = eVar;
            this.f48384e = callbackHandler;
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && a2.length() != 0) {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (a0.f44733b) {
                        Log.w("GetFormIdAction", "cb is empty");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                    return false;
                }
                String D = eVar.D();
                if (TextUtils.isEmpty(D)) {
                    if (a0.f44733b) {
                        Log.w("GetFormIdAction", "appKey is empty");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "appKey is empty");
                    return false;
                }
                if (TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE.equals(a2.optString("reportType"))) {
                    JSONArray optJSONArray = a2.optJSONArray("templateId");
                    String optString2 = a2.optString("templateId");
                    String optString3 = a2.optString("subscribeId");
                    if (TextUtils.isEmpty(optString3)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "subscribeId is empty");
                        return false;
                    }
                    l lVar = new l(D, optString3);
                    lVar.f48429d = a2.optString("invokeFrom", "form");
                    lVar.f48430e = a2.optBoolean("skipSubscribeAuthorize");
                    lVar.f48428c = optJSONArray == null;
                    if (lVar.f48428c) {
                        if (TextUtils.isEmpty(optString2)) {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "templateId is empty");
                            return false;
                        }
                        strArr = new String[]{optString2};
                    } else {
                        int length = optJSONArray.length();
                        if (length >= 1 && length <= 3) {
                            String[] strArr2 = new String[length];
                            for (int i2 = 0; i2 < length; i2++) {
                                strArr2[i2] = optJSONArray.optString(i2);
                            }
                            strArr = strArr2;
                        } else {
                            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202);
                            return false;
                        }
                    }
                    y(D, strArr, new C0875a(lVar, strArr, optString));
                } else {
                    A(D, optString);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        } else {
            if (a0.f44733b) {
                Log.d("GetFormIdAction", "runtime parameter error");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
            return false;
        }
    }

    public final JSONArray v(List<d.a.m0.a.s0.d> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (d.a.m0.a.s0.d dVar : list) {
                jSONArray.put(dVar.f48447b);
            }
        }
        return jSONArray;
    }

    public final boolean w() {
        return d.a.m0.a.a2.d.g().r().j().e(d.a.m0.a.c1.a.b());
    }

    public final void x(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.m0.a.s0.d> list, @NonNull List<String> list2) {
        boolean w = w();
        if (w()) {
            E(lVar, str, str2, list, list2);
            return;
        }
        if (!w) {
            d.a.m0.a.j2.k.M("show", 12, "component");
        }
        d.a.m0.a.a2.d.g().r().j().f(d.a.m0.a.g1.f.V().getActivity(), null, new f(w, lVar, str, str2, list, list2));
    }

    @AnyThread
    public final void y(String str, String[] strArr, k kVar) {
        q.j(new b(str, strArr, kVar), "querySubscribeInfo");
    }

    public final void z(String str, String str2, List<d.a.m0.a.s0.d> list, List<d.a.m0.a.s0.d> list2) {
        d.a.m0.a.j2.p.e eVar = new d.a.m0.a.j2.p.e();
        eVar.f46969a = "swan";
        eVar.f46970b = str;
        eVar.f46975g = str2;
        if (list2 != null) {
            eVar.f46973e = String.valueOf(list2.size());
        }
        eVar.a("appkey", this.f48383d.getAppId());
        eVar.a("tpl", v(list));
        eVar.a("selected_tpl", v(list2));
        if (a0.f44733b) {
            Log.d("GetFormIdAction", "event: " + eVar.f());
        }
        d.a.m0.a.j2.k.v("1311", "92", eVar);
    }
}
