package d.b.h0.a.n0;

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
import d.b.h0.a.i2.k0;
import d.b.h0.a.i2.p;
import d.b.h0.a.n0.c;
import d.b.h0.a.t1.k.a0;
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
    public Context f45995c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.a.r1.e f45996d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f45997e;

    /* renamed from: d.b.h0.a.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0771a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f45998a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f45999b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46000c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f46001d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46002e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f46003f;

        public C0771a(String str, String[] strArr, String str2, boolean z, String str3, boolean z2) {
            this.f45998a = str;
            this.f45999b = strArr;
            this.f46000c = str2;
            this.f46001d = z;
            this.f46002e = str3;
            this.f46003f = z2;
        }

        @Override // d.b.h0.a.n0.a.j
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                a.this.w(this.f45998a, Arrays.asList(this.f45999b), this.f46000c, this.f46001d, this.f46002e);
                return;
            }
            a.this.x(this.f46002e, this.f45998a, this.f46000c, linkedHashMap, list, this.f46001d, this.f46003f);
            if (a0.f47009b) {
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
        public final /* synthetic */ String f46005e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f46006f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f46007g;

        public b(String str, String[] strArr, j jVar) {
            this.f46005e = str;
            this.f46006f = strArr;
            this.f46007g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            Cursor query = a.this.f45995c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f46005e}, null);
            HashMap hashMap = new HashMap();
            if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                do {
                    hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                } while (query.moveToNext());
                d.b.h0.p.d.a(query);
            }
            LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
            ArrayList arrayList = new ArrayList();
            for (String str : this.f46006f) {
                Integer num = (Integer) hashMap.get(str);
                if (num == null) {
                    linkedHashMap.put(str, Boolean.FALSE);
                } else if (num.intValue() != 1) {
                    linkedHashMap.put(str, Boolean.TRUE);
                } else {
                    arrayList.add(str);
                }
            }
            this.f46007g.a(linkedHashMap, arrayList);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46009a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f46010b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f46011c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f46012d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46013e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46014f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46015g;

        /* renamed from: d.b.h0.a.n0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0772a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f46017e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f46018f;

            public RunnableC0772a(List list, String str) {
                this.f46017e = list;
                this.f46018f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = a.this.f45995c.getContentResolver();
                for (d.b.h0.a.n0.d dVar : this.f46017e) {
                    String str = dVar.f46055a;
                    Boolean bool = (Boolean) c.this.f46010b.get(str);
                    if (bool != null && !bool.booleanValue()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appKey", c.this.f46011c);
                        contentValues.put("templateId", str);
                        contentValues.put("result", (Integer) 0);
                        contentValues.put("title", dVar.f46056b);
                        contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, this.f46018f);
                        contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f46020e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f46021f;

            public b(String str, List list) {
                this.f46020e = str;
                this.f46021f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                a.this.y(cVar.f46009a, cVar.f46011c, cVar.f46014f, this.f46020e, this.f46021f, cVar.f46013e, cVar.f46015g);
            }
        }

        public c(String str, LinkedHashMap linkedHashMap, String str2, boolean z, List list, String str3, boolean z2) {
            this.f46009a = str;
            this.f46010b = linkedHashMap;
            this.f46011c = str2;
            this.f46012d = z;
            this.f46013e = list;
            this.f46014f = str3;
            this.f46015g = z2;
        }

        @Override // d.b.h0.a.n0.a.i
        public void a(@Nullable String str, List<d.b.h0.a.n0.d> list, boolean z) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                p.k(new RunnableC0772a(list, str), "createFormDataBase");
                if (z && this.f46012d) {
                    a.this.z(this.f46011c, list, str, true);
                    for (d.b.h0.a.n0.d dVar : list) {
                        this.f46013e.add(dVar.f46055a);
                    }
                    a.this.w(this.f46011c, this.f46013e, this.f46014f, this.f46015g, this.f46009a);
                    return;
                }
                k0.T(new b(str, list));
                return;
            }
            a.this.f45997e.handleSchemeDispatchCallback(this.f46009a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46023a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f46024b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f46025c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f46026d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f46027e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46028f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f46029g;

        public d(String str, String str2, List list, String str3, boolean z, String str4, List list2) {
            this.f46023a = str;
            this.f46024b = str2;
            this.f46025c = list;
            this.f46026d = str3;
            this.f46027e = z;
            this.f46028f = str4;
            this.f46029g = list2;
        }

        @Override // d.b.h0.a.n0.c.f
        public boolean a(DialogInterface dialogInterface, int i, List<d.b.h0.a.n0.d> list) {
            String str;
            boolean z = i == -1;
            if (a0.f47009b) {
                Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z);
            }
            if (z && list.size() == 0) {
                return false;
            }
            a.this.z(this.f46023a, list, this.f46024b, z);
            if (z) {
                for (d.b.h0.a.n0.d dVar : list) {
                    this.f46025c.add(dVar.f46055a);
                }
                a.this.w(this.f46023a, this.f46025c, this.f46026d, this.f46027e, this.f46028f);
                str = "permit_click";
            } else {
                a.this.f45997e.handleSchemeDispatchCallback(this.f46028f, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
                str = "reject_click";
            }
            a.this.u(str, this.f46029g, list);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f46031e;

        public e(String str) {
            this.f46031e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.this.f45997e.handleSchemeDispatchCallback(this.f46031e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f46033e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f46034f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f46035g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f46036h;

        public f(List list, String str, boolean z, String str2) {
            this.f46033e = list;
            this.f46034f = str;
            this.f46035g = z;
            this.f46036h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver contentResolver = a.this.f45995c.getContentResolver();
            for (d.b.h0.a.n0.d dVar : this.f46033e) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", dVar.f46056b);
                contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, this.f46034f);
                contentValues.put("result", Integer.valueOf(this.f46035g ? 1 : -1));
                contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f46036h, dVar.f46055a});
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.b.h0.a.n0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46037a;

        public g(String str) {
            this.f46037a = str;
        }

        @Override // d.b.h0.a.o1.a
        public void a(JSONObject jSONObject) {
            a.this.f45997e.handleSchemeDispatchCallback(this.f46037a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.b.h0.a.w0.a.O().g(a.this.f45995c)) {
                d.b.h0.a.o1.c.f46150b.d();
            } else {
                d.b.h0.a.o1.c.f46150b.e();
            }
        }

        @Override // d.b.h0.a.o1.a
        public void onFail(String str) {
            a.this.f45997e.handleSchemeDispatchCallback(this.f46037a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.b.h0.a.n0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f46039a;

        public h(String str) {
            this.f46039a = str;
        }

        @Override // d.b.h0.a.o1.a
        public void a(JSONObject jSONObject) {
            a.this.f45997e.handleSchemeDispatchCallback(this.f46039a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.b.h0.a.w0.a.O().g(a.this.f45995c)) {
                d.b.h0.a.o1.c.f46150b.d();
            } else {
                d.b.h0.a.o1.c.f46150b.e();
            }
        }

        @Override // d.b.h0.a.o1.a
        public void onFail(String str) {
            a.this.f45997e.handleSchemeDispatchCallback(this.f46039a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a(@Nullable String str, @Nullable List<d.b.h0.a.n0.d> list, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    public a(d.b.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getFormId");
    }

    @Override // d.b.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.b.h0.a.r1.e eVar) {
        String[] strArr;
        if (unitedSchemeEntity == null) {
            if (a0.f47009b) {
                Log.w("GetFormIdAction", "entity is null");
            }
            return false;
        } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
            this.f45995c = context;
            this.f45996d = eVar;
            this.f45997e = callbackHandler;
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && a2.length() != 0) {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (a0.f47009b) {
                        Log.w("GetFormIdAction", "cb is empty");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                    return false;
                }
                String B = eVar.B();
                if (TextUtils.isEmpty(B)) {
                    if (a0.f47009b) {
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
                    t(B, strArr, new C0771a(B, strArr, optString3, z, optString, optBoolean));
                } else {
                    v(B, optString);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        } else {
            if (a0.f47009b) {
                Log.d("GetFormIdAction", "runtime parameter error");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
            return false;
        }
    }

    public final JSONArray s(List<d.b.h0.a.n0.d> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (d.b.h0.a.n0.d dVar : list) {
                jSONArray.put(dVar.f46056b);
            }
        }
        return jSONArray;
    }

    @AnyThread
    public final void t(String str, String[] strArr, j jVar) {
        p.k(new b(str, strArr, jVar), "querySubscribeInfo");
    }

    public final void u(String str, List<d.b.h0.a.n0.d> list, List<d.b.h0.a.n0.d> list2) {
        d.b.h0.a.z1.k.e eVar = new d.b.h0.a.z1.k.e();
        eVar.f47972a = "swan";
        eVar.f47973b = str;
        if (list2 != null) {
            eVar.f47975d = String.valueOf(list2.size());
        }
        eVar.a("appkey", this.f45996d.getAppId());
        eVar.a("tpl", s(list));
        eVar.a("selected_tpl", s(list2));
        if (a0.f47009b) {
            Log.d("GetFormIdAction", "event: " + eVar.f());
        }
        d.b.h0.a.z1.h.u("1311", eVar);
    }

    public final void v(@NonNull String str, @NonNull String str2) {
        d.b.h0.a.w0.a.G().e(str, new g(str2));
    }

    public final void w(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, @NonNull String str3) {
        d.b.h0.a.w0.a.G().c(str, list, str2, z, new h(str3));
    }

    @AnyThread
    public final void x(String str, String str2, String str3, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list, boolean z, boolean z2) {
        d.b.h0.a.w0.a.G().a(str2, linkedHashMap.keySet(), new c(str, linkedHashMap, str2, z2, list, str3, z));
    }

    public final void y(String str, String str2, String str3, String str4, List<d.b.h0.a.n0.d> list, @NonNull List<String> list2, boolean z) {
        d.b.h0.a.n0.c.a((Activity) this.f45995c, this.f45996d, str4, list, new d(str2, str4, list2, str3, z, str, list), new e(str)).show();
        u("show", list, list);
    }

    public final void z(String str, List<d.b.h0.a.n0.d> list, String str2, boolean z) {
        p.g().execute(new f(list, str2, z, str));
    }
}
