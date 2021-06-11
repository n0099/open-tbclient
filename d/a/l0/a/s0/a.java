package d.a.l0.a.s0;

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
import d.a.l0.a.c2.f.a0;
import d.a.l0.a.s0.c;
import d.a.l0.a.v2.q;
import d.a.l0.a.v2.q0;
import d.a.l0.a.v2.w;
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
    public Context f48274c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.a2.e f48275d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f48276e;

    /* renamed from: d.a.l0.a.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0872a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f48277a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f48278b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48279c;

        public C0872a(l lVar, String[] strArr, String str) {
            this.f48277a = lVar;
            this.f48278b = strArr;
            this.f48279c = str;
        }

        @Override // d.a.l0.a.s0.a.k
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                a.this.B(this.f48277a, Arrays.asList(this.f48278b), this.f48279c);
                return;
            }
            a.this.C(this.f48277a, this.f48279c, linkedHashMap, list);
            if (a0.f44625b) {
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
        public final /* synthetic */ String f48281e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f48282f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f48283g;

        public b(String str, String[] strArr, k kVar) {
            this.f48281e = str;
            this.f48282f = strArr;
            this.f48283g = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            HashMap hashMap = new HashMap();
            if (a.this.w()) {
                Cursor query = a.this.f48274c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f48281e}, null);
                if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                    do {
                        hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                    } while (query.moveToNext());
                    d.a.l0.t.d.d(query);
                }
            }
            LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
            ArrayList arrayList = new ArrayList();
            for (String str : this.f48282f) {
                Integer num = (Integer) hashMap.get(str);
                if (num == null) {
                    linkedHashMap.put(str, Boolean.FALSE);
                } else if (num.intValue() != 1) {
                    linkedHashMap.put(str, Boolean.TRUE);
                } else {
                    arrayList.add(str);
                }
            }
            this.f48283g.a(linkedHashMap, arrayList);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48285a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f48286b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f48287c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f48288d;

        /* renamed from: d.a.l0.a.s0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0873a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f48290e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f48291f;

            public RunnableC0873a(List list, String str) {
                this.f48290e = list;
                this.f48291f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = a.this.f48274c.getContentResolver();
                for (d.a.l0.a.s0.d dVar : this.f48290e) {
                    String str = dVar.f48338a;
                    Boolean bool = (Boolean) c.this.f48286b.get(str);
                    if (bool != null && !bool.booleanValue()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appKey", c.this.f48287c.f48318a);
                        contentValues.put("templateId", str);
                        contentValues.put("result", (Integer) 0);
                        contentValues.put("title", dVar.f48339b);
                        contentValues.put("tips", this.f48291f);
                        contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f48293e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f48294f;

            public b(String str, List list) {
                this.f48293e = str;
                this.f48294f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                a.this.D(cVar.f48287c, this.f48293e, cVar.f48285a, this.f48294f, cVar.f48288d);
            }
        }

        public c(String str, LinkedHashMap linkedHashMap, l lVar, List list) {
            this.f48285a = str;
            this.f48286b = linkedHashMap;
            this.f48287c = lVar;
            this.f48288d = list;
        }

        @Override // d.a.l0.a.s0.a.j
        public void a(@Nullable String str, List<d.a.l0.a.s0.d> list, boolean z) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                q.j(new RunnableC0873a(list, str), "createFormDataBase");
                if (z && this.f48287c.f48322e) {
                    a.this.x(this.f48287c, this.f48285a, str, list, this.f48288d);
                    return;
                } else {
                    q0.X(new b(str, list));
                    return;
                }
            }
            a.this.f48276e.handleSchemeDispatchCallback(this.f48285a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f48296a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f48297b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f48298c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f48299d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f48300e;

        public d(l lVar, List list, String str, String str2, List list2) {
            this.f48296a = lVar;
            this.f48297b = list;
            this.f48298c = str;
            this.f48299d = str2;
            this.f48300e = list2;
        }

        @Override // d.a.l0.a.s0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<d.a.l0.a.s0.d> list) {
            boolean z = i2 == -1;
            if (a0.f44625b) {
                Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z);
            }
            if (z && list.size() == 0) {
                return false;
            }
            a.this.z(z ? "permit_click" : "reject_click", this.f48296a.f48321d, this.f48297b, list);
            if (z) {
                a.this.x(this.f48296a, this.f48298c, this.f48299d, list, this.f48300e);
                return true;
            }
            if (a.this.w()) {
                a.this.F(this.f48296a.f48318a, list, this.f48299d, false);
            }
            a.this.f48276e.handleSchemeDispatchCallback(this.f48298c, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f48302e;

        public e(String str) {
            this.f48302e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.this.f48276e.handleSchemeDispatchCallback(this.f48302e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f48304e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f48305f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f48306g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48307h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f48308i;
        public final /* synthetic */ List j;

        public f(boolean z, l lVar, String str, String str2, List list, List list2) {
            this.f48304e = z;
            this.f48305f = lVar;
            this.f48306g = str;
            this.f48307h = str2;
            this.f48308i = list;
            this.j = list2;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                if (!this.f48304e && a.this.w()) {
                    d.a.l0.a.j2.k.M("success", 12, "component");
                }
                a.this.E(this.f48305f, this.f48306g, this.f48307h, this.f48308i, this.j);
                return;
            }
            if (!this.f48304e && !a.this.w()) {
                d.a.l0.a.j2.k.M(com.baidu.pass.biometrics.face.liveness.b.b.g0, 12, "component");
            }
            a.this.f48276e.handleSchemeDispatchCallback(this.f48306g, UnitedSchemeUtility.wrapCallbackParams(500106, "用户未登录").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f48309e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f48310f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f48311g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f48312h;

        public g(List list, String str, boolean z, String str2) {
            this.f48309e = list;
            this.f48310f = str;
            this.f48311g = z;
            this.f48312h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver contentResolver = a.this.f48274c.getContentResolver();
            for (d.a.l0.a.s0.d dVar : this.f48309e) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", dVar.f48339b);
                contentValues.put("tips", this.f48310f);
                contentValues.put("result", Integer.valueOf(this.f48311g ? 1 : -1));
                contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f48312h, dVar.f48338a});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.l0.a.s0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48314a;

        public h(String str) {
            this.f48314a = str;
        }

        @Override // d.a.l0.a.x1.a
        public void a(JSONObject jSONObject) {
            a.this.f48276e.handleSchemeDispatchCallback(this.f48314a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.l0.a.x1.c.f49436c.c()) {
                return;
            }
            if (d.a.l0.a.c1.a.a0().e(a.this.f48274c)) {
                d.a.l0.a.x1.c.f49436c.e();
            } else {
                d.a.l0.a.x1.c.f49436c.f();
            }
        }

        @Override // d.a.l0.a.x1.a
        public void onFail(String str) {
            a.this.f48276e.handleSchemeDispatchCallback(this.f48314a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.l0.a.s0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f48316a;

        public i(String str) {
            this.f48316a = str;
        }

        @Override // d.a.l0.a.x1.a
        public void a(JSONObject jSONObject) {
            a.this.f48276e.handleSchemeDispatchCallback(this.f48316a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.l0.a.c1.a.a0().e(a.this.f48274c)) {
                d.a.l0.a.x1.c.f49436c.e();
            } else {
                d.a.l0.a.x1.c.f49436c.f();
            }
        }

        @Override // d.a.l0.a.x1.a
        public void onFail(String str) {
            a.this.f48276e.handleSchemeDispatchCallback(this.f48316a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes3.dex */
    public interface j {
        void a(@Nullable String str, @Nullable List<d.a.l0.a.s0.d> list, boolean z);
    }

    /* loaded from: classes3.dex */
    public interface k {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    /* loaded from: classes3.dex */
    public static class l {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f48318a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f48319b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48320c;

        /* renamed from: d  reason: collision with root package name */
        public String f48321d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f48322e;

        public l(@NonNull String str, @NonNull String str2) {
            this.f48318a = str;
            this.f48319b = str2;
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getFormId");
    }

    public final void A(@NonNull String str, @NonNull String str2) {
        if (!w()) {
            this.f48276e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(w.f(null, "data", w.f(null, "formid", "")), 0).toString());
            return;
        }
        d.a.l0.a.c1.a.R().c(str, new h(str2));
    }

    public final void B(@NonNull l lVar, @NonNull List<String> list, @NonNull String str) {
        d.a.l0.a.c1.a.R().d(lVar.f48318a, list, lVar.f48319b, lVar.f48320c, new i(str));
    }

    @AnyThread
    public final void C(@NonNull l lVar, String str, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
        d.a.l0.a.c1.a.R().a(lVar.f48318a, linkedHashMap.keySet(), new c(str, linkedHashMap, lVar, list));
    }

    public final void D(@NonNull l lVar, String str, String str2, List<d.a.l0.a.s0.d> list, @NonNull List<String> list2) {
        d.a.l0.a.s0.c.a((Activity) this.f48274c, this.f48275d, str, list, new d(lVar, list, str2, str, list2), new e(str2)).show();
        z("show", lVar.f48321d, list, list);
    }

    public final void E(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.l0.a.s0.d> list, @NonNull List<String> list2) {
        F(lVar.f48318a, list, str2, true);
        for (d.a.l0.a.s0.d dVar : list) {
            list2.add(dVar.f48338a);
        }
        B(lVar, list2, str);
    }

    public final void F(String str, List<d.a.l0.a.s0.d> list, String str2, boolean z) {
        q.f().execute(new g(list, str2, z, str));
    }

    @Override // d.a.l0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.l0.a.a2.e eVar) {
        String[] strArr;
        if (unitedSchemeEntity == null) {
            if (a0.f44625b) {
                Log.w("GetFormIdAction", "entity is null");
            }
            return false;
        } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
            this.f48274c = context;
            this.f48275d = eVar;
            this.f48276e = callbackHandler;
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && a2.length() != 0) {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (a0.f44625b) {
                        Log.w("GetFormIdAction", "cb is empty");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                    return false;
                }
                String D = eVar.D();
                if (TextUtils.isEmpty(D)) {
                    if (a0.f44625b) {
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
                    lVar.f48321d = a2.optString("invokeFrom", "form");
                    lVar.f48322e = a2.optBoolean("skipSubscribeAuthorize");
                    lVar.f48320c = optJSONArray == null;
                    if (lVar.f48320c) {
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
                    y(D, strArr, new C0872a(lVar, strArr, optString));
                } else {
                    A(D, optString);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        } else {
            if (a0.f44625b) {
                Log.d("GetFormIdAction", "runtime parameter error");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
            return false;
        }
    }

    public final JSONArray v(List<d.a.l0.a.s0.d> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (d.a.l0.a.s0.d dVar : list) {
                jSONArray.put(dVar.f48339b);
            }
        }
        return jSONArray;
    }

    public final boolean w() {
        return d.a.l0.a.a2.d.g().r().j().e(d.a.l0.a.c1.a.b());
    }

    public final void x(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.l0.a.s0.d> list, @NonNull List<String> list2) {
        boolean w = w();
        if (w()) {
            E(lVar, str, str2, list, list2);
            return;
        }
        if (!w) {
            d.a.l0.a.j2.k.M("show", 12, "component");
        }
        d.a.l0.a.a2.d.g().r().j().f(d.a.l0.a.g1.f.V().getActivity(), null, new f(w, lVar, str, str2, list, list2));
    }

    @AnyThread
    public final void y(String str, String[] strArr, k kVar) {
        q.j(new b(str, strArr, kVar), "querySubscribeInfo");
    }

    public final void z(String str, String str2, List<d.a.l0.a.s0.d> list, List<d.a.l0.a.s0.d> list2) {
        d.a.l0.a.j2.p.e eVar = new d.a.l0.a.j2.p.e();
        eVar.f46861a = "swan";
        eVar.f46862b = str;
        eVar.f46867g = str2;
        if (list2 != null) {
            eVar.f46865e = String.valueOf(list2.size());
        }
        eVar.a("appkey", this.f48275d.getAppId());
        eVar.a("tpl", v(list));
        eVar.a("selected_tpl", v(list2));
        if (a0.f44625b) {
            Log.d("GetFormIdAction", "event: " + eVar.f());
        }
        d.a.l0.a.j2.k.v("1311", "92", eVar);
    }
}
