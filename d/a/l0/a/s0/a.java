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
    public Context f44600c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.l0.a.a2.e f44601d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f44602e;

    /* renamed from: d.a.l0.a.s0.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0816a implements k {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f44603a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f44604b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44605c;

        public C0816a(l lVar, String[] strArr, String str) {
            this.f44603a = lVar;
            this.f44604b = strArr;
            this.f44605c = str;
        }

        @Override // d.a.l0.a.s0.a.k
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                a.this.B(this.f44603a, Arrays.asList(this.f44604b), this.f44605c);
                return;
            }
            a.this.C(this.f44603a, this.f44605c, linkedHashMap, list);
            if (a0.f40949b) {
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
        public final /* synthetic */ String f44607e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f44608f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ k f44609g;

        public b(String str, String[] strArr, k kVar) {
            this.f44607e = str;
            this.f44608f = strArr;
            this.f44609g = kVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            HashMap hashMap = new HashMap();
            if (a.this.w()) {
                Cursor query = a.this.f44600c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f44607e}, null);
                if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                    do {
                        hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                    } while (query.moveToNext());
                    d.a.l0.t.d.d(query);
                }
            }
            LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
            ArrayList arrayList = new ArrayList();
            for (String str : this.f44608f) {
                Integer num = (Integer) hashMap.get(str);
                if (num == null) {
                    linkedHashMap.put(str, Boolean.FALSE);
                } else if (num.intValue() != 1) {
                    linkedHashMap.put(str, Boolean.TRUE);
                } else {
                    arrayList.add(str);
                }
            }
            this.f44609g.a(linkedHashMap, arrayList);
        }
    }

    /* loaded from: classes3.dex */
    public class c implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44611a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f44612b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ l f44613c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ List f44614d;

        /* renamed from: d.a.l0.a.s0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0817a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f44616e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f44617f;

            public RunnableC0817a(List list, String str) {
                this.f44616e = list;
                this.f44617f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = a.this.f44600c.getContentResolver();
                for (d.a.l0.a.s0.d dVar : this.f44616e) {
                    String str = dVar.f44664a;
                    Boolean bool = (Boolean) c.this.f44612b.get(str);
                    if (bool != null && !bool.booleanValue()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appKey", c.this.f44613c.f44644a);
                        contentValues.put("templateId", str);
                        contentValues.put("result", (Integer) 0);
                        contentValues.put("title", dVar.f44665b);
                        contentValues.put("tips", this.f44617f);
                        contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                    }
                }
            }
        }

        /* loaded from: classes3.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f44619e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f44620f;

            public b(String str, List list) {
                this.f44619e = str;
                this.f44620f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                a.this.D(cVar.f44613c, this.f44619e, cVar.f44611a, this.f44620f, cVar.f44614d);
            }
        }

        public c(String str, LinkedHashMap linkedHashMap, l lVar, List list) {
            this.f44611a = str;
            this.f44612b = linkedHashMap;
            this.f44613c = lVar;
            this.f44614d = list;
        }

        @Override // d.a.l0.a.s0.a.j
        public void a(@Nullable String str, List<d.a.l0.a.s0.d> list, boolean z) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                q.j(new RunnableC0817a(list, str), "createFormDataBase");
                if (z && this.f44613c.f44648e) {
                    a.this.x(this.f44613c, this.f44611a, str, list, this.f44614d);
                    return;
                } else {
                    q0.X(new b(str, list));
                    return;
                }
            }
            a.this.f44602e.handleSchemeDispatchCallback(this.f44611a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class d implements c.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l f44622a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List f44623b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f44624c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f44625d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44626e;

        public d(l lVar, List list, String str, String str2, List list2) {
            this.f44622a = lVar;
            this.f44623b = list;
            this.f44624c = str;
            this.f44625d = str2;
            this.f44626e = list2;
        }

        @Override // d.a.l0.a.s0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<d.a.l0.a.s0.d> list) {
            boolean z = i2 == -1;
            if (a0.f40949b) {
                Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z);
            }
            if (z && list.size() == 0) {
                return false;
            }
            a.this.z(z ? "permit_click" : "reject_click", this.f44622a.f44647d, this.f44623b, list);
            if (z) {
                a.this.x(this.f44622a, this.f44624c, this.f44625d, list, this.f44626e);
                return true;
            }
            if (a.this.w()) {
                a.this.F(this.f44622a.f44644a, list, this.f44625d, false);
            }
            a.this.f44602e.handleSchemeDispatchCallback(this.f44624c, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
            return true;
        }
    }

    /* loaded from: classes3.dex */
    public class e implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f44628e;

        public e(String str) {
            this.f44628e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.this.f44602e.handleSchemeDispatchCallback(this.f44628e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class f implements d.a.l0.a.m.a {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f44630e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ l f44631f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f44632g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44633h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ List f44634i;
        public final /* synthetic */ List j;

        public f(boolean z, l lVar, String str, String str2, List list, List list2) {
            this.f44630e = z;
            this.f44631f = lVar;
            this.f44632g = str;
            this.f44633h = str2;
            this.f44634i = list;
            this.j = list2;
        }

        @Override // d.a.l0.a.m.a
        public void onResult(int i2) {
            if (i2 == 0) {
                if (!this.f44630e && a.this.w()) {
                    d.a.l0.a.j2.k.M("success", 12, "component");
                }
                a.this.E(this.f44631f, this.f44632g, this.f44633h, this.f44634i, this.j);
                return;
            }
            if (!this.f44630e && !a.this.w()) {
                d.a.l0.a.j2.k.M("fail", 12, "component");
            }
            a.this.f44602e.handleSchemeDispatchCallback(this.f44632g, UnitedSchemeUtility.wrapCallbackParams(500106, "用户未登录").toString());
        }
    }

    /* loaded from: classes3.dex */
    public class g implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f44635e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f44636f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f44637g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f44638h;

        public g(List list, String str, boolean z, String str2) {
            this.f44635e = list;
            this.f44636f = str;
            this.f44637g = z;
            this.f44638h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver contentResolver = a.this.f44600c.getContentResolver();
            for (d.a.l0.a.s0.d dVar : this.f44635e) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", dVar.f44665b);
                contentValues.put("tips", this.f44636f);
                contentValues.put("result", Integer.valueOf(this.f44637g ? 1 : -1));
                contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f44638h, dVar.f44664a});
            }
        }
    }

    /* loaded from: classes3.dex */
    public class h implements d.a.l0.a.s0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44640a;

        public h(String str) {
            this.f44640a = str;
        }

        @Override // d.a.l0.a.x1.a
        public void a(String str) {
            a.this.f44602e.handleSchemeDispatchCallback(this.f44640a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }

        @Override // d.a.l0.a.x1.a
        public void b(JSONObject jSONObject) {
            a.this.f44602e.handleSchemeDispatchCallback(this.f44640a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.l0.a.x1.c.f45762c.c()) {
                return;
            }
            if (d.a.l0.a.c1.a.a0().e(a.this.f44600c)) {
                d.a.l0.a.x1.c.f45762c.e();
            } else {
                d.a.l0.a.x1.c.f45762c.f();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class i implements d.a.l0.a.s0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f44642a;

        public i(String str) {
            this.f44642a = str;
        }

        @Override // d.a.l0.a.x1.a
        public void a(String str) {
            a.this.f44602e.handleSchemeDispatchCallback(this.f44642a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }

        @Override // d.a.l0.a.x1.a
        public void b(JSONObject jSONObject) {
            a.this.f44602e.handleSchemeDispatchCallback(this.f44642a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.l0.a.c1.a.a0().e(a.this.f44600c)) {
                d.a.l0.a.x1.c.f45762c.e();
            } else {
                d.a.l0.a.x1.c.f45762c.f();
            }
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
        public final String f44644a;
        @NonNull

        /* renamed from: b  reason: collision with root package name */
        public final String f44645b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f44646c;

        /* renamed from: d  reason: collision with root package name */
        public String f44647d;

        /* renamed from: e  reason: collision with root package name */
        public boolean f44648e;

        public l(@NonNull String str, @NonNull String str2) {
            this.f44644a = str;
            this.f44645b = str2;
        }
    }

    public a(d.a.l0.a.c2.e eVar) {
        super(eVar, "/swanAPI/getFormId");
    }

    public final void A(@NonNull String str, @NonNull String str2) {
        if (!w()) {
            this.f44602e.handleSchemeDispatchCallback(str2, UnitedSchemeUtility.wrapCallbackParams(w.f(null, "data", w.f(null, "formid", "")), 0).toString());
            return;
        }
        d.a.l0.a.c1.a.R().c(str, new h(str2));
    }

    public final void B(@NonNull l lVar, @NonNull List<String> list, @NonNull String str) {
        d.a.l0.a.c1.a.R().d(lVar.f44644a, list, lVar.f44645b, lVar.f44646c, new i(str));
    }

    @AnyThread
    public final void C(@NonNull l lVar, String str, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
        d.a.l0.a.c1.a.R().a(lVar.f44644a, linkedHashMap.keySet(), new c(str, linkedHashMap, lVar, list));
    }

    public final void D(@NonNull l lVar, String str, String str2, List<d.a.l0.a.s0.d> list, @NonNull List<String> list2) {
        d.a.l0.a.s0.c.a((Activity) this.f44600c, this.f44601d, str, list, new d(lVar, list, str2, str, list2), new e(str2)).show();
        z("show", lVar.f44647d, list, list);
    }

    public final void E(@NonNull l lVar, @NonNull String str, String str2, @NonNull List<d.a.l0.a.s0.d> list, @NonNull List<String> list2) {
        F(lVar.f44644a, list, str2, true);
        for (d.a.l0.a.s0.d dVar : list) {
            list2.add(dVar.f44664a);
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
            if (a0.f40949b) {
                Log.w("GetFormIdAction", "entity is null");
            }
            return false;
        } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
            this.f44600c = context;
            this.f44601d = eVar;
            this.f44602e = callbackHandler;
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && a2.length() != 0) {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (a0.f40949b) {
                        Log.w("GetFormIdAction", "cb is empty");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                    return false;
                }
                String D = eVar.D();
                if (TextUtils.isEmpty(D)) {
                    if (a0.f40949b) {
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
                    lVar.f44647d = a2.optString("invokeFrom", "form");
                    lVar.f44648e = a2.optBoolean("skipSubscribeAuthorize");
                    lVar.f44646c = optJSONArray == null;
                    if (lVar.f44646c) {
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
                    y(D, strArr, new C0816a(lVar, strArr, optString));
                } else {
                    A(D, optString);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        } else {
            if (a0.f40949b) {
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
                jSONArray.put(dVar.f44665b);
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
        eVar.f43185a = "swan";
        eVar.f43186b = str;
        eVar.f43191g = str2;
        if (list2 != null) {
            eVar.f43189e = String.valueOf(list2.size());
        }
        eVar.a("appkey", this.f44601d.getAppId());
        eVar.a("tpl", v(list));
        eVar.a("selected_tpl", v(list2));
        if (a0.f40949b) {
            Log.d("GetFormIdAction", "event: " + eVar.f());
        }
        d.a.l0.a.j2.k.v("1311", "92", eVar);
    }
}
