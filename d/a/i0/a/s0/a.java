package d.a.i0.a.s0;

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
import d.a.i0.a.c2.f.a0;
import d.a.i0.a.s0.c;
import d.a.i0.a.v2.q;
import d.a.i0.a.v2.q0;
import d.a.i0.a.v2.w;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends a0 {

    /* renamed from: c  reason: collision with root package name */
    public Context f44424c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.a.a2.e f44425d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f44426e;

    /* renamed from: d.a.i0.a.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0805a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f44427a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f44428b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44429c;

        public C0805a(l lVar, String[] strArr, String str) {
            this.f44427a = lVar;
            this.f44428b = strArr;
            this.f44429c = str;
        }

        @Override // d.a.i0.a.s0.a.k
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                a.this.B(this.f44427a, Arrays.asList(this.f44428b), this.f44429c);
                return;
            }
            a.this.C(this.f44427a, this.f44429c, linkedHashMap, list);
            if (a0.f40775b) {
                Iterator<String> it = linkedHashMap.keySet().iterator();
                while (it.hasNext()) {
                    Log.i("GetFormIdAction", "querySubscribeInfo unallowedTemplateId=" + it.next());
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44431e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f44432f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f44433g;

        public b(String str, String[] strArr, k kVar) {
            this.f44431e = str;
            this.f44432f = strArr;
            this.f44433g = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            HashMap hashMap = new HashMap();
            if (a.this.w()) {
                Cursor query = a.this.f44424c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f44431e}, null);
                if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                    do {
                        hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                    } while (query.moveToNext());
                    d.a.i0.t.d.d(query);
                }
            }
            LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
            ArrayList arrayList = new ArrayList();
            for (String str : this.f44432f) {
                Integer num = (Integer) hashMap.get(str);
                if (num == null) {
                    linkedHashMap.put(str, Boolean.FALSE);
                } else if (num.intValue() != 1) {
                    linkedHashMap.put(str, Boolean.TRUE);
                } else {
                    arrayList.add(str);
                }
            }
            this.f44433g.a(linkedHashMap, arrayList);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44435a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f44436b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f44437c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f44438d;

        /* renamed from: d.a.i0.a.s0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0806a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f44440e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f44441f;

            public RunnableC0806a(List list, String str) {
                this.f44440e = list;
                this.f44441f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = a.this.f44424c.getContentResolver();
                for (d.a.i0.a.s0.d dVar : this.f44440e) {
                    String str = dVar.f44488a;
                    Boolean bool = (Boolean) c.this.f44436b.get(str);
                    if (bool != null && !bool.booleanValue()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appKey", c.this.f44437c.f44468a);
                        contentValues.put("templateId", str);
                        contentValues.put("result", (Integer) 0);
                        contentValues.put("title", dVar.f44489b);
                        contentValues.put("tips", this.f44441f);
                        contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f44443e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f44444f;

            public b(String str, List list) {
                this.f44443e = str;
                this.f44444f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                a.this.D(cVar.f44437c, this.f44443e, cVar.f44435a, this.f44444f, cVar.f44438d);
            }
        }

        public c(String str, LinkedHashMap linkedHashMap, l lVar, List list) {
            this.f44435a = str;
            this.f44436b = linkedHashMap;
            this.f44437c = lVar;
            this.f44438d = list;
        }

        @Override // d.a.i0.a.s0.a.j
        public void a(@Nullable String str, List<d.a.i0.a.s0.d> list, boolean z) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                q.j(new RunnableC0806a(list, str), "createFormDataBase");
                if (z && this.f44437c.f44472e) {
                    a.this.x(this.f44437c, this.f44435a, str, list, this.f44438d);
                    return;
                } else {
                    q0.X(new b(str, list));
                    return;
                }
            }
            a.this.f44426e.handleSchemeDispatchCallback(this.f44435a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f44446a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f44447b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44448c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44449d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44450e;

        public d(l lVar, List list, String str, String str2, List list2) {
            this.f44446a = lVar;
            this.f44447b = list;
            this.f44448c = str;
            this.f44449d = str2;
            this.f44450e = list2;
        }

        @Override // d.a.i0.a.s0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<d.a.i0.a.s0.d> list) {
            boolean z = i2 == -1;
            if (a0.f40775b) {
                Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z);
            }
            if (z && list.size() == 0) {
                return false;
            }
            a.this.z(z ? "permit_click" : "reject_click", this.f44446a.f44471d, this.f44447b, list);
            if (z) {
                a.this.x(this.f44446a, this.f44448c, this.f44449d, list, this.f44450e);
                return true;
            }
            if (a.this.w()) {
                a.this.F(this.f44446a.f44468a, list, this.f44449d, false);
            }
            a.this.f44426e.handleSchemeDispatchCallback(this.f44448c, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44452e;

        public e(String str) {
            this.f44452e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.this.f44426e.handleSchemeDispatchCallback(this.f44452e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class f implements d.a.i0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f44455f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44456g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44457h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f44458i;
        public final /* synthetic */ List j;

        public f(boolean z, l lVar, String str, String str2, List list, List list2) {
            this.f44454e = z;
            this.f44455f = lVar;
            this.f44456g = str;
            this.f44457h = str2;
            this.f44458i = list;
            this.j = list2;
        }

        @Override // d.a.i0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                if (!this.f44454e && a.this.w()) {
                    d.a.i0.a.j2.k.M("success", 12, "component");
                }
                a.this.E(this.f44455f, this.f44456g, this.f44457h, this.f44458i, this.j);
                return;
            }
            if (!this.f44454e && !a.this.w()) {
                d.a.i0.a.j2.k.M("fail", 12, "component");
            }
            a.this.f44426e.handleSchemeDispatchCallback(this.f44456g, UnitedSchemeUtility.wrapCallbackParams(500106, "用户未登录").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44459e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44460f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44461g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44462h;

        public g(List list, String str, boolean z, String str2) {
            this.f44459e = list;
            this.f44460f = str;
            this.f44461g = z;
            this.f44462h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver contentResolver = a.this.f44424c.getContentResolver();
            for (d.a.i0.a.s0.d dVar : this.f44459e) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", dVar.f44489b);
                contentValues.put("tips", this.f44460f);
                contentValues.put("result", Integer.valueOf(this.f44461g ? 1 : -1));
                contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f44462h, dVar.f44488a});
            }
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.a.i0.a.s0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44464a;

        public h(String str) {
            this.f44464a = str;
        }

        @Override // d.a.i0.a.x1.a
        public void a(String str) {
            a.this.f44426e.handleSchemeDispatchCallback(this.f44464a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }

        @Override // d.a.i0.a.x1.a
        public void b(JSONObject jSONObject) {
            a.this.f44426e.handleSchemeDispatchCallback(this.f44464a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.i0.a.x1.c.f45586c.c()) {
                return;
            }
            if (d.a.i0.a.c1.a.a0().e(a.this.f44424c)) {
                d.a.i0.a.x1.c.f45586c.e();
            } else {
                d.a.i0.a.x1.c.f45586c.f();
            }
        }
    }

    /* loaded from: classes2.dex */
    public class i implements d.a.i0.a.s0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44466a;

        public i(String str) {
            this.f44466a = str;
        }

        @Override // d.a.i0.a.x1.a
        public void a(String str) {
            a.this.f44426e.handleSchemeDispatchCallback(this.f44466a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }

        @Override // d.a.i0.a.x1.a
        public void b(JSONObject jSONObject) {
            a.this.f44426e.handleSchemeDispatchCallback(this.f44466a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.i0.a.c1.a.a0().e(a.this.f44424c)) {
                d.a.i0.a.x1.c.f45586c.e();
            } else {
                d.a.i0.a.x1.c.f45586c.f();
            }
        }
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(@Nullable String str, @Nullable List<d.a.i0.a.s0.d> list, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface k {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    /* loaded from: classes2.dex */
    public static class l {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        public final String f44468a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f44469b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f44470c;

        /* renamed from: d  reason: collision with root package name */
        public String f44471d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44472e;

        public l(@NonNull String str, @NonNull String str2) {
            this.f44468a = str;
            this.f44469b = str2;
        }
    }

    public a(d.a.i0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getFormId");
    }

    public final void A(@NonNull String str, @NonNull String str2) {
        if (!w()) {
            this.f44426e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(w.f(null, "data", w.f(null, "formid", "")), 0).toString());
            return;
        }
        d.a.i0.a.c1.a.R().c(str, new h(str2));
    }

    public final void B(@NonNull l lVar, @NonNull List<String> list, @NonNull String str) {
        d.a.i0.a.c1.a.R().d(lVar.f44468a, list, lVar.f44469b, lVar.f44470c, new i(str));
    }

    @AnyThread
    public final void C(@NonNull l lVar, String str, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
        d.a.i0.a.c1.a.R().a(lVar.f44468a, linkedHashMap.keySet(), new c(str, linkedHashMap, lVar, list));
    }

    public final void D(@NonNull l lVar, String str, String str2, List<d.a.i0.a.s0.d> list, @NonNull List<String> list2) {
        d.a.i0.a.s0.c.a((Activity) this.f44424c, this.f44425d, str, list, new d(lVar, list, str2, str, list2), new e(str2)).show();
        z("show", lVar.f44471d, list, list);
    }

    public final void E(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.i0.a.s0.d> list, @NonNull List<String> list2) {
        F(lVar.f44468a, list, str2, true);
        for (d.a.i0.a.s0.d dVar : list) {
            list2.add(dVar.f44488a);
        }
        B(lVar, list2, str);
    }

    public final void F(String str, List<d.a.i0.a.s0.d> list, String str2, boolean z) {
        q.f().execute(new g(list, str2, z, str));
    }

    @Override // d.a.i0.a.c2.f.a0
    public boolean d(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.i0.a.a2.e eVar) {
        String[] strArr;
        if (unitedSchemeEntity == null) {
            if (a0.f40775b) {
                Log.w("GetFormIdAction", "entity is null");
            }
            return false;
        } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
            this.f44424c = context;
            this.f44425d = eVar;
            this.f44426e = callbackHandler;
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && a2.length() != 0) {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (a0.f40775b) {
                        Log.w("GetFormIdAction", "cb is empty");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                    return false;
                }
                String D = eVar.D();
                if (TextUtils.isEmpty(D)) {
                    if (a0.f40775b) {
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
                    lVar.f44471d = a2.optString("invokeFrom", "form");
                    lVar.f44472e = a2.optBoolean("skipSubscribeAuthorize");
                    lVar.f44470c = optJSONArray == null;
                    if (lVar.f44470c) {
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
                    y(D, strArr, new C0805a(lVar, strArr, optString));
                } else {
                    A(D, optString);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        } else {
            if (a0.f40775b) {
                Log.d("GetFormIdAction", "runtime parameter error");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
            return false;
        }
    }

    public final JSONArray v(List<d.a.i0.a.s0.d> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (d.a.i0.a.s0.d dVar : list) {
                jSONArray.put(dVar.f44489b);
            }
        }
        return jSONArray;
    }

    public final boolean w() {
        return d.a.i0.a.a2.d.g().r().j().e(d.a.i0.a.c1.a.b());
    }

    public final void x(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.i0.a.s0.d> list, @NonNull List<String> list2) {
        boolean w = w();
        if (w()) {
            E(lVar, str, str2, list, list2);
            return;
        }
        if (!w) {
            d.a.i0.a.j2.k.M("show", 12, "component");
        }
        d.a.i0.a.a2.d.g().r().j().f(d.a.i0.a.g1.f.V().getActivity(), null, new f(w, lVar, str, str2, list, list2));
    }

    @AnyThread
    public final void y(String str, String[] strArr, k kVar) {
        q.j(new b(str, strArr, kVar), "querySubscribeInfo");
    }

    public final void z(String str, String str2, List<d.a.i0.a.s0.d> list, List<d.a.i0.a.s0.d> list2) {
        d.a.i0.a.j2.p.e eVar = new d.a.i0.a.j2.p.e();
        eVar.f43011a = "swan";
        eVar.f43012b = str;
        eVar.f43017g = str2;
        if (list2 != null) {
            eVar.f43015e = String.valueOf(list2.size());
        }
        eVar.a("appkey", this.f44425d.getAppId());
        eVar.a("tpl", v(list));
        eVar.a("selected_tpl", v(list2));
        if (a0.f40775b) {
            Log.d("GetFormIdAction", "event: " + eVar.f());
        }
        d.a.i0.a.j2.k.v("1311", "92", eVar);
    }
}
