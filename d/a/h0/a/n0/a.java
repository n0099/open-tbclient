package d.a.h0.a.n0;

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
import d.a.h0.a.i2.k0;
import d.a.h0.a.i2.p;
import d.a.h0.a.n0.c;
import d.a.h0.a.t1.k.a0;
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
    public Context f43336c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.h0.a.r1.e f43337d;

    /* renamed from: e  reason: collision with root package name */
    public CallbackHandler f43338e;

    /* renamed from: d.a.h0.a.n0.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0710a implements j {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43339a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String[] f43340b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43341c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f43342d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43343e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ boolean f43344f;

        public C0710a(String str, String[] strArr, String str2, boolean z, String str3, boolean z2) {
            this.f43339a = str;
            this.f43340b = strArr;
            this.f43341c = str2;
            this.f43342d = z;
            this.f43343e = str3;
            this.f43344f = z2;
        }

        @Override // d.a.h0.a.n0.a.j
        public void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list) {
            if (linkedHashMap == null || linkedHashMap.size() == 0) {
                a.this.w(this.f43339a, Arrays.asList(this.f43340b), this.f43341c, this.f43342d, this.f43343e);
                return;
            }
            a.this.x(this.f43343e, this.f43339a, this.f43341c, linkedHashMap, list, this.f43342d, this.f43344f);
            if (a0.f44398b) {
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
        public final /* synthetic */ String f43346e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String[] f43347f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ j f43348g;

        public b(String str, String[] strArr, j jVar) {
            this.f43346e = str;
            this.f43347f = strArr;
            this.f43348g = jVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            String[] strArr;
            Cursor query = a.this.f43336c.getContentResolver().query(SwanAppSubscribeMsgProvider.CONTENT_URI, new String[]{"templateId", "result"}, "appKey=?", new String[]{this.f43346e}, null);
            HashMap hashMap = new HashMap();
            if (query != null && query.getCount() > 0 && query.moveToFirst()) {
                do {
                    hashMap.put(query.getString(query.getColumnIndex("templateId")), Integer.valueOf(query.getInt(query.getColumnIndex("result"))));
                } while (query.moveToNext());
                d.a.h0.p.d.a(query);
            }
            LinkedHashMap<String, Boolean> linkedHashMap = new LinkedHashMap<>();
            ArrayList arrayList = new ArrayList();
            for (String str : this.f43347f) {
                Integer num = (Integer) hashMap.get(str);
                if (num == null) {
                    linkedHashMap.put(str, Boolean.FALSE);
                } else if (num.intValue() != 1) {
                    linkedHashMap.put(str, Boolean.TRUE);
                } else {
                    arrayList.add(str);
                }
            }
            this.f43348g.a(linkedHashMap, arrayList);
        }
    }

    /* loaded from: classes2.dex */
    public class c implements i {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43350a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LinkedHashMap f43351b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f43352c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ boolean f43353d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f43354e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43355f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f43356g;

        /* renamed from: d.a.h0.a.n0.a$c$a  reason: collision with other inner class name */
        /* loaded from: classes2.dex */
        public class RunnableC0711a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ List f43358e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ String f43359f;

            public RunnableC0711a(List list, String str) {
                this.f43358e = list;
                this.f43359f = str;
            }

            @Override // java.lang.Runnable
            public void run() {
                ContentResolver contentResolver = a.this.f43336c.getContentResolver();
                for (d.a.h0.a.n0.d dVar : this.f43358e) {
                    String str = dVar.f43398a;
                    Boolean bool = (Boolean) c.this.f43351b.get(str);
                    if (bool != null && !bool.booleanValue()) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("appKey", c.this.f43352c);
                        contentValues.put("templateId", str);
                        contentValues.put("result", (Integer) 0);
                        contentValues.put("title", dVar.f43399b);
                        contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, this.f43359f);
                        contentResolver.insert(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues);
                    }
                }
            }
        }

        /* loaded from: classes2.dex */
        public class b implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ String f43361e;

            /* renamed from: f  reason: collision with root package name */
            public final /* synthetic */ List f43362f;

            public b(String str, List list) {
                this.f43361e = str;
                this.f43362f = list;
            }

            @Override // java.lang.Runnable
            public void run() {
                c cVar = c.this;
                a.this.y(cVar.f43350a, cVar.f43352c, cVar.f43355f, this.f43361e, this.f43362f, cVar.f43354e, cVar.f43356g);
            }
        }

        public c(String str, LinkedHashMap linkedHashMap, String str2, boolean z, List list, String str3, boolean z2) {
            this.f43350a = str;
            this.f43351b = linkedHashMap;
            this.f43352c = str2;
            this.f43353d = z;
            this.f43354e = list;
            this.f43355f = str3;
            this.f43356g = z2;
        }

        @Override // d.a.h0.a.n0.a.i
        public void a(@Nullable String str, List<d.a.h0.a.n0.d> list, boolean z) {
            if (!TextUtils.isEmpty(str) && list != null && list.size() > 0) {
                p.k(new RunnableC0711a(list, str), "createFormDataBase");
                if (z && this.f43353d) {
                    a.this.z(this.f43352c, list, str, true);
                    for (d.a.h0.a.n0.d dVar : list) {
                        this.f43354e.add(dVar.f43398a);
                    }
                    a.this.w(this.f43352c, this.f43354e, this.f43355f, this.f43356g, this.f43350a);
                    return;
                }
                k0.T(new b(str, list));
                return;
            }
            a.this.f43338e.handleSchemeDispatchCallback(this.f43350a, UnitedSchemeUtility.wrapCallbackParams(500104, "请求模板内容失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class d implements c.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43364a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f43365b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ List f43366c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f43367d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ boolean f43368e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43369f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ List f43370g;

        public d(String str, String str2, List list, String str3, boolean z, String str4, List list2) {
            this.f43364a = str;
            this.f43365b = str2;
            this.f43366c = list;
            this.f43367d = str3;
            this.f43368e = z;
            this.f43369f = str4;
            this.f43370g = list2;
        }

        @Override // d.a.h0.a.n0.c.f
        public boolean a(DialogInterface dialogInterface, int i2, List<d.a.h0.a.n0.d> list) {
            String str;
            boolean z = i2 == -1;
            if (a0.f44398b) {
                Log.i("GetFormIdAction", "showSubscribeDialog isPositive=" + z);
            }
            if (z && list.size() == 0) {
                return false;
            }
            a.this.z(this.f43364a, list, this.f43365b, z);
            if (z) {
                for (d.a.h0.a.n0.d dVar : list) {
                    this.f43366c.add(dVar.f43398a);
                }
                a.this.w(this.f43364a, this.f43366c, this.f43367d, this.f43368e, this.f43369f);
                str = "permit_click";
            } else {
                a.this.f43338e.handleSchemeDispatchCallback(this.f43369f, UnitedSchemeUtility.wrapCallbackParams(500102, "用户单次拒绝授权").toString());
                str = "reject_click";
            }
            a.this.u(str, this.f43370g, list);
            return true;
        }
    }

    /* loaded from: classes2.dex */
    public class e implements DialogInterface.OnCancelListener {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f43372e;

        public e(String str) {
            this.f43372e = str;
        }

        @Override // android.content.DialogInterface.OnCancelListener
        public void onCancel(DialogInterface dialogInterface) {
            a.this.f43338e.handleSchemeDispatchCallback(this.f43372e, UnitedSchemeUtility.wrapCallbackParams(500103, "用户取消授权").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class f implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ List f43374e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ String f43375f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ boolean f43376g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ String f43377h;

        public f(List list, String str, boolean z, String str2) {
            this.f43374e = list;
            this.f43375f = str;
            this.f43376g = z;
            this.f43377h = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            ContentResolver contentResolver = a.this.f43336c.getContentResolver();
            for (d.a.h0.a.n0.d dVar : this.f43374e) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", dVar.f43399b);
                contentValues.put(TableDefine.MessageColumns.COLUME_TIPS, this.f43375f);
                contentValues.put("result", Integer.valueOf(this.f43376g ? 1 : -1));
                contentResolver.update(SwanAppSubscribeMsgProvider.CONTENT_URI, contentValues, "appKey=? and templateId=?", new String[]{this.f43377h, dVar.f43398a});
            }
        }
    }

    /* loaded from: classes2.dex */
    public class g implements d.a.h0.a.n0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43379a;

        public g(String str) {
            this.f43379a = str;
        }

        @Override // d.a.h0.a.o1.a
        public void a(JSONObject jSONObject) {
            a.this.f43338e.handleSchemeDispatchCallback(this.f43379a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.h0.a.w0.a.O().d(a.this.f43336c)) {
                d.a.h0.a.o1.c.f43497b.d();
            } else {
                d.a.h0.a.o1.c.f43497b.e();
            }
        }

        @Override // d.a.h0.a.o1.a
        public void onFail(String str) {
            a.this.f43338e.handleSchemeDispatchCallback(this.f43379a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public class h implements d.a.h0.a.n0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ String f43381a;

        public h(String str) {
            this.f43381a = str;
        }

        @Override // d.a.h0.a.o1.a
        public void a(JSONObject jSONObject) {
            a.this.f43338e.handleSchemeDispatchCallback(this.f43381a, UnitedSchemeUtility.wrapCallbackParams(jSONObject, 0).toString());
            if (d.a.h0.a.w0.a.O().d(a.this.f43336c)) {
                d.a.h0.a.o1.c.f43497b.d();
            } else {
                d.a.h0.a.o1.c.f43497b.e();
            }
        }

        @Override // d.a.h0.a.o1.a
        public void onFail(String str) {
            a.this.f43338e.handleSchemeDispatchCallback(this.f43381a, UnitedSchemeUtility.wrapCallbackParams(500105, "请求formId失败").toString());
        }
    }

    /* loaded from: classes2.dex */
    public interface i {
        void a(@Nullable String str, @Nullable List<d.a.h0.a.n0.d> list, boolean z);
    }

    /* loaded from: classes2.dex */
    public interface j {
        void a(@NonNull LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list);
    }

    public a(d.a.h0.a.t1.j jVar) {
        super(jVar, "/swanAPI/getFormId");
    }

    @Override // d.a.h0.a.t1.k.a0
    public boolean g(Context context, UnitedSchemeEntity unitedSchemeEntity, CallbackHandler callbackHandler, d.a.h0.a.r1.e eVar) {
        String[] strArr;
        if (unitedSchemeEntity == null) {
            if (a0.f44398b) {
                Log.w("GetFormIdAction", "entity is null");
            }
            return false;
        } else if (eVar != null && (context instanceof Activity) && callbackHandler != null) {
            this.f43336c = context;
            this.f43337d = eVar;
            this.f43338e = callbackHandler;
            JSONObject a2 = a0.a(unitedSchemeEntity, "params");
            if (a2 != null && a2.length() != 0) {
                String optString = a2.optString("cb");
                if (TextUtils.isEmpty(optString)) {
                    if (a0.f44398b) {
                        Log.w("GetFormIdAction", "cb is empty");
                    }
                    unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "cb is empty");
                    return false;
                }
                String B = eVar.B();
                if (TextUtils.isEmpty(B)) {
                    if (a0.f44398b) {
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
                    t(B, strArr, new C0710a(B, strArr, optString3, z, optString, optBoolean));
                } else {
                    v(B, optString);
                }
                UnitedSchemeUtility.callCallback(callbackHandler, unitedSchemeEntity, UnitedSchemeUtility.wrapCallbackParams(0));
                return true;
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(202, "illegal params");
            return false;
        } else {
            if (a0.f44398b) {
                Log.d("GetFormIdAction", "runtime parameter error");
            }
            unitedSchemeEntity.result = UnitedSchemeUtility.wrapCallbackParams(201, "runtime parameter error");
            return false;
        }
    }

    public final JSONArray s(List<d.a.h0.a.n0.d> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null && list.size() > 0) {
            for (d.a.h0.a.n0.d dVar : list) {
                jSONArray.put(dVar.f43399b);
            }
        }
        return jSONArray;
    }

    @AnyThread
    public final void t(String str, String[] strArr, j jVar) {
        p.k(new b(str, strArr, jVar), "querySubscribeInfo");
    }

    public final void u(String str, List<d.a.h0.a.n0.d> list, List<d.a.h0.a.n0.d> list2) {
        d.a.h0.a.z1.k.e eVar = new d.a.h0.a.z1.k.e();
        eVar.f45411a = "swan";
        eVar.f45412b = str;
        if (list2 != null) {
            eVar.f45414d = String.valueOf(list2.size());
        }
        eVar.a("appkey", this.f43337d.getAppId());
        eVar.a("tpl", s(list));
        eVar.a("selected_tpl", s(list2));
        if (a0.f44398b) {
            Log.d("GetFormIdAction", "event: " + eVar.f());
        }
        d.a.h0.a.z1.h.u("1311", eVar);
    }

    public final void v(@NonNull String str, @NonNull String str2) {
        d.a.h0.a.w0.a.G().c(str, new g(str2));
    }

    public final void w(@NonNull String str, @NonNull List<String> list, @Nullable String str2, boolean z, @NonNull String str3) {
        d.a.h0.a.w0.a.G().d(str, list, str2, z, new h(str3));
    }

    @AnyThread
    public final void x(String str, String str2, String str3, LinkedHashMap<String, Boolean> linkedHashMap, @NonNull List<String> list, boolean z, boolean z2) {
        d.a.h0.a.w0.a.G().a(str2, linkedHashMap.keySet(), new c(str, linkedHashMap, str2, z2, list, str3, z));
    }

    public final void y(String str, String str2, String str3, String str4, List<d.a.h0.a.n0.d> list, @NonNull List<String> list2, boolean z) {
        d.a.h0.a.n0.c.a((Activity) this.f43336c, this.f43337d, str4, list, new d(str2, str4, list2, str3, z, str, list), new e(str)).show();
        u("show", list, list);
    }

    public final void z(String str, List<d.a.h0.a.n0.d> list, String str2, boolean z) {
        p.g().execute(new f(list, str2, z, str));
    }
}
