package d.b.g0.a.n0;

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
import d.b.g0.a.i2.k0;
import d.b.g0.a.i2.p;
import d.b.g0.a.n0.c;
import d.b.g0.a.t1.k.a0;
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
    public Context f45274c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.g0.a.r1.e f45275d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f45276e;

    /* renamed from: d.b.g0.a.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0739a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45277a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f45278b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45279c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f45280d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45281e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f45282f;

        public C0739a(String str, String[] strArr, String str2, boolean z, String str3, boolean z2) {
            this.f45277a = str;
            this.f45278b = strArr;
            this.f45279c = str2;
            this.f45280d = z;
            this.f45281e = str3;
            this.f45282f = z2;
        }

        @Override // d.b.g0.a.n0.a.j
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                a.this.w(this.f45277a, Arrays.asList(this.f45278b), this.f45279c, this.f45280d, this.f45281e);
                return;
            }
            a.this.x(this.f45281e, this.f45277a, this.f45279c, linkedHashMap, list, this.f45280d, this.f45282f);
            if (a0.f46288b) {
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
        public final /* synthetic */ String f45284e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f45285f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f45286g;

        public b(String str, String[] strArr, j jVar) {
            this.f45284e = str;
            this.f45285f = strArr;
            this.f45286g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            Cursor query = a.this.f45274c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f45284e}, null);
            HashMap hashMap = new HashMap();
            if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                do {
                    hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                } while (query.moveToNext());
                d.b.g0.p.d.a(query);
            }
            LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
            ArrayList arrayList = new ArrayList();
            for (String str : this.f45285f) {
                Integer num = (Integer) hashMap.get(str);
                if (num == null) {
                    linkedHashMap.put(str, Boolean.FALSE);
                } else if (num.intValue() != 1) {
                    linkedHashMap.put(str, Boolean.TRUE);
                } else {
                    arrayList.add(str);
                }
            }
            this.f45286g.a(linkedHashMap, arrayList);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45288a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f45289b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45290c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f45291d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45292e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45293f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f45294g;

        /* renamed from: d.b.g0.a.n0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0740a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f45296e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f45297f;

            public RunnableC0740a(List list, String str) {
                this.f45296e = list;
                this.f45297f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = a.this.f45274c.getContentResolver();
                for (d.b.g0.a.n0.d dVar : this.f45296e) {
                    String str = dVar.f45334a;
                    Boolean bool = (Boolean) c.this.f45289b.get(str);
                    if (bool != null && !bool.booleanValue()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appKey", c.this.f45290c);
                        contentValues.put("templateId", str);
                        contentValues.put("result", (Integer) 0);
                        contentValues.put("title", dVar.f45335b);
                        contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, this.f45297f);
                        contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f45299e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f45300f;

            public b(String str, List list) {
                this.f45299e = str;
                this.f45300f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                a.this.y(cVar.f45288a, cVar.f45290c, cVar.f45293f, this.f45299e, this.f45300f, cVar.f45292e, cVar.f45294g);
            }
        }

        public c(String str, LinkedHashMap linkedHashMap, String str2, boolean z, List list, String str3, boolean z2) {
            this.f45288a = str;
            this.f45289b = linkedHashMap;
            this.f45290c = str2;
            this.f45291d = z;
            this.f45292e = list;
            this.f45293f = str3;
            this.f45294g = z2;
        }

        @Override // d.b.g0.a.n0.a.i
        public void a(@Nullable String str, List<d.b.g0.a.n0.d> list, boolean z) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                p.k(new RunnableC0740a(list, str), "createFormDataBase");
                if (z && this.f45291d) {
                    a.this.z(this.f45290c, list, str, true);
                    for (d.b.g0.a.n0.d dVar : list) {
                        this.f45292e.add(dVar.f45334a);
                    }
                    a.this.w(this.f45290c, this.f45292e, this.f45293f, this.f45294g, this.f45288a);
                    return;
                }
                k0.T(new b(str, list));
                return;
            }
            a.this.f45276e.handleSchemeDispatchCallback(this.f45288a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45302a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45303b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f45304c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f45305d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f45306e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45307f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f45308g;

        public d(String str, String str2, List list, String str3, boolean z, String str4, List list2) {
            this.f45302a = str;
            this.f45303b = str2;
            this.f45304c = list;
            this.f45305d = str3;
            this.f45306e = z;
            this.f45307f = str4;
            this.f45308g = list2;
        }

        @Override // d.b.g0.a.n0.c.f
        public boolean a(DialogInterface dialogInterface, int i, List<d.b.g0.a.n0.d> list) {
            String str;
            boolean z = i == -1;
            if (a0.f46288b) {
                Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z);
            }
            if (z && list.size() == 0) {
                return false;
            }
            a.this.z(this.f45302a, list, this.f45303b, z);
            if (z) {
                for (d.b.g0.a.n0.d dVar : list) {
                    this.f45304c.add(dVar.f45334a);
                }
                a.this.w(this.f45302a, this.f45304c, this.f45305d, this.f45306e, this.f45307f);
                str = "permit_click";
            } else {
                a.this.f45276e.handleSchemeDispatchCallback(this.f45307f, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
                str = "reject_click";
            }
            a.this.u(str, this.f45308g, list);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f45310e;

        public e(String str) {
            this.f45310e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.this.f45276e.handleSchemeDispatchCallback(this.f45310e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f45312e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f45313f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f45314g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f45315h;

        public f(List list, String str, boolean z, String str2) {
            this.f45312e = list;
            this.f45313f = str;
            this.f45314g = z;
            this.f45315h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver contentResolver = a.this.f45274c.getContentResolver();
            for (d.b.g0.a.n0.d dVar : this.f45312e) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", dVar.f45335b);
                contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, this.f45313f);
                contentValues.put("result", Integer.valueOf(this.f45314g ? 1 : -1));
                contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f45315h, dVar.f45334a});
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.b.g0.a.n0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45316a;

        public g(String str) {
            this.f45316a = str;
        }

        @Override // d.b.g0.a.o1.a
        public void a(JSONObject jSONObject) {
            a.this.f45276e.handleSchemeDispatchCallback(this.f45316a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.b.g0.a.w0.a.O().g(a.this.f45274c)) {
                d.b.g0.a.o1.c.f45429b.d();
            } else {
                d.b.g0.a.o1.c.f45429b.e();
            }
        }

        @Override // d.b.g0.a.o1.a
        public void onFail(String str) {
            a.this.f45276e.handleSchemeDispatchCallback(this.f45316a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.b.g0.a.n0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45318a;

        public h(String str) {
            this.f45318a = str;
        }

        @Override // d.b.g0.a.o1.a
        public void a(JSONObject jSONObject) {
            a.this.f45276e.handleSchemeDispatchCallback(this.f45318a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.b.g0.a.w0.a.O().g(a.this.f45274c)) {
                d.b.g0.a.o1.c.f45429b.d();
            } else {
                d.b.g0.a.o1.c.f45429b.e();
            }
        }

        @Override // d.b.g0.a.o1.a
        public void onFail(String str) {
            a.this.f45276e.handleSchemeDispatchCallback(this.f45318a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a(@Nullable String str, @Nullable List<d.b.g0.a.n0.d> list, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    public a(d.b.g0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getFormId");
    }

    @Override // d.b.g0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.g0.a.r1.e eVar) {
        String[] strArr;
        if (unitedSchemeEntity == null) {
            if (a0.f46288b) {
                Log.w("GetFormIdAction", "entity is null");
            }
            return false;
        } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
            this.f45274c = context;
            this.f45275d = eVar;
            this.f45276e = callbackHandler;
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && a2.length() != 0) {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (a0.f46288b) {
                        Log.w("GetFormIdAction", "cb is empty");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                    return false;
                }
                String B = eVar.B();
                if (TextUtils.isEmpty(B)) {
                    if (a0.f46288b) {
                        Log.w("GetFormIdAction", "appKey is empty");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "appKey is empty");
                    return false;
                }
                if (TableDefine.PaSubscribeColumns.COLUMN_SUBSCRIBE.equals(a2.optString("reportType"))) {
                    JSONArray optJSONArray = a2.optJSONArray("templateId");
                    String optString2 = a2.optString("templateId");
                    String optString3 = a2.optString("subscribeId");
                    boolean optBoolean = a2.optBoolean("skipSubscribeAuthorize");
                    if (TextUtils.isEmpty(optString3)) {
                        unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "subscribeId is empty");
                        return false;
                    }
                    boolean z = optJSONArray == null;
                    if (z) {
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
                    t(B, strArr, new C0739a(B, strArr, optString3, z, optString, optBoolean));
                } else {
                    v(B, optString);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        } else {
            if (a0.f46288b) {
                Log.d("GetFormIdAction", "runtime parameter error");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
            return false;
        }
    }

    public final JSONArray s(List<d.b.g0.a.n0.d> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (d.b.g0.a.n0.d dVar : list) {
                jSONArray.put(dVar.f45335b);
            }
        }
        return jSONArray;
    }

    @AnyThread
    public final void t(String str, String[] strArr, j jVar) {
        p.k(new b(str, strArr, jVar), "querySubscribeInfo");
    }

    public final void u(String str, List<d.b.g0.a.n0.d> list, List<d.b.g0.a.n0.d> list2) {
        d.b.g0.a.z1.k.e eVar = new d.b.g0.a.z1.k.e();
        eVar.f47251a = "swan";
        eVar.f47252b = str;
        if (list2 != null) {
            eVar.f47254d = String.valueOf(list2.size());
        }
        eVar.a("appkey", this.f45275d.getAppId());
        eVar.a("tpl", s(list));
        eVar.a("selected_tpl", s(list2));
        if (a0.f46288b) {
            Log.d("GetFormIdAction", "event: " + eVar.f());
        }
        d.b.g0.a.z1.h.u("1311", eVar);
    }

    public final void v(@NonNull String str, @NonNull String str2) {
        d.b.g0.a.w0.a.G().e(str, new g(str2));
    }

    public final void w(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, @NonNull String str3) {
        d.b.g0.a.w0.a.G().c(str, list, str2, z, new h(str3));
    }

    @AnyThread
    public final void x(String str, String str2, String str3, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list, boolean z, boolean z2) {
        d.b.g0.a.w0.a.G().a(str2, linkedHashMap.keySet(), new c(str, linkedHashMap, str2, z2, list, str3, z));
    }

    public final void y(String str, String str2, String str3, String str4, List<d.b.g0.a.n0.d> list, @NonNull List<String> list2, boolean z) {
        d.b.g0.a.n0.c.a((Activity) this.f45274c, this.f45275d, str4, list, new d(str2, str4, list2, str3, z, str, list), new e(str)).show();
        u("show", list, list);
    }

    public final void z(String str, List<d.b.g0.a.n0.d> list, String str2, boolean z) {
        p.g().execute(new f(list, str2, z, str));
    }
}
