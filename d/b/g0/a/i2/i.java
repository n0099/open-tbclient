package d.b.g0.a.i2;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class i {

    /* renamed from: a  reason: collision with root package name */
    public static final boolean f44690a = d.b.g0.a.k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public static List<String> f44691b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public static List<String> f44692c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public static final Object f44693d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public static int f44694e = 0;

    public static boolean a() {
        if (f44694e != 2) {
            return d.b.g0.a.w0.a.N().h() && !d.b.g0.a.a2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false);
        }
        if (f44690a) {
            Log.d("SwanAppCompat", "has used ab description");
        }
        return true;
    }

    public static boolean b() {
        String str = d.b.g0.a.u0.d.d().getPath() + File.separator + "js_native" + File.separator;
        String str2 = str + "swan_js_native_v8_ab.txt";
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append("swan_js_native_webview_ab.txt");
        return d.b.g0.p.d.x(str2) && d.b.g0.p.d.x(sb.toString());
    }

    @Nullable
    public static List<JSONObject> c(String str) {
        String schemesDes = SchemeCollecter.getSchemesDes(str, 0);
        ArrayList arrayList = new ArrayList();
        try {
            JSONObject jSONObject = new JSONObject(schemesDes);
            arrayList.add(jSONObject);
            int i = jSONObject.getInt("totalSlices");
            for (int i2 = 1; i2 < i; i2++) {
                arrayList.add(new JSONObject(SchemeCollecter.getSchemesDes(str, i2)));
            }
            return arrayList;
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public static String d(int i, boolean z) {
        List<String> list;
        String str = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
        if (f44694e == 1) {
            if (f44690a) {
                Log.d("SwanAppCompat", "type support default");
            }
            return SchemeCollecter.getSchemesDes(str, i);
        }
        if (a()) {
            synchronized (f44693d) {
                if (z) {
                    list = f44691b;
                } else {
                    list = f44692c;
                }
                if (list != null && list.size() > 0) {
                    if (f44690a) {
                        Log.d("SwanAppCompat", "support ab js native descriptions");
                    }
                    f44694e = 2;
                    return list.get(i);
                }
            }
        }
        if (f44690a) {
            Log.d("SwanAppCompat", "use default descriptions");
        }
        f44694e = 1;
        return SchemeCollecter.getSchemesDes(str, i);
    }

    public static boolean e() {
        return g0.b("3.200.100");
    }

    public static void f(boolean z, String str) {
        String str2 = z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW;
        String str3 = z ? "swan/v8_ab" : "swan/webview_ab";
        List<JSONObject> c2 = c(str2);
        List<JSONObject> c3 = c(str3);
        if (c2 == null || c3 == null) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < c3.size(); i++) {
            try {
                JSONArray jSONArray = c3.get(i).getJSONArray("descriptions");
                if (jSONArray != null) {
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        arrayList.add(jSONArray.getJSONObject(i2));
                    }
                }
            } catch (JSONException e2) {
                if (f44690a) {
                    e2.printStackTrace();
                    return;
                }
                return;
            }
        }
        if (arrayList.size() != 0 && g(c2, arrayList)) {
            File file = new File(str);
            ArrayList arrayList2 = new ArrayList();
            for (JSONObject jSONObject : c2) {
                if (jSONObject != null) {
                    arrayList2.add(jSONObject.toString());
                }
            }
            if (file.exists()) {
                d.b.g0.p.d.w(file);
            }
            d.b.g0.p.d.e(file);
            d.b.g0.p.d.A(arrayList2, file);
            n(arrayList2, z);
        }
    }

    public static boolean g(List<JSONObject> list, List<JSONObject> list2) {
        try {
            for (JSONObject jSONObject : list2) {
                String string = jSONObject.getString("name");
                boolean z = false;
                for (JSONObject jSONObject2 : list) {
                    JSONArray jSONArray = jSONObject2.getJSONArray("descriptions");
                    if (jSONArray != null) {
                        int i = 0;
                        while (true) {
                            if (i >= jSONArray.length()) {
                                break;
                            } else if (TextUtils.equals(string, jSONArray.getJSONObject(i).getString("name"))) {
                                jSONArray.remove(i);
                                jSONArray.put(jSONObject);
                                z = true;
                                break;
                            } else {
                                i++;
                            }
                        }
                        if (z) {
                            break;
                        }
                    }
                }
            }
            return true;
        } catch (JSONException e2) {
            if (f44690a) {
                e2.printStackTrace();
            }
            return false;
        }
    }

    public static boolean h() {
        SwanCoreVersion T = d.b.g0.a.e0.w.d.L().T();
        if (T == null) {
            if (f44690a) {
                Log.d("Api-Base", "isSupportBindApi: false => null cur ver");
            }
            return false;
        }
        boolean z = T.swanCoreVersion >= 12892110851L;
        if (f44690a) {
            String q = d.b.g0.a.b2.b.q(T.swanCoreVersion);
            String q2 = d.b.g0.a.b2.b.q(12892110851L);
            Log.d("Api-Base", "isSupportBindApi: " + z + " => cur【" + q + "】support 【" + q2 + "】");
        }
        return z;
    }

    public static boolean i() {
        return !g0.b("3.120.2");
    }

    public static void j() {
        if (f44690a) {
            Log.d("SwanAppCompat", "on App upgrade");
        }
        d.b.g0.a.a2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", true);
    }

    public static void k() {
        if (f44690a) {
            Log.d("SwanAppCompat", "start release descriptions");
        }
        synchronized (f44693d) {
            f44694e = 0;
            f44691b = new ArrayList();
            f44692c = new ArrayList();
        }
    }

    public static void l() {
        if (f44690a) {
            Log.d("SwanAppCompat", "start prepare ab description");
        }
        m(true);
        m(false);
        if (f44690a) {
            Log.d("SwanAppCompat", "end prepare ab description");
        }
    }

    public static void m(boolean z) {
        if (f44690a) {
            StringBuilder sb = new StringBuilder();
            sb.append("start prepare ab description :");
            sb.append(z ? V8Engine.TYPE_V8 : "webview");
            Log.d("SwanAppCompat", sb.toString());
        }
        String str = d.b.g0.a.u0.d.d().getPath() + File.separator + "js_native" + File.separator + (z ? "swan_js_native_v8_ab.txt" : "swan_js_native_webview_ab.txt");
        if (d.b.g0.p.d.n(str)) {
            if (d.b.g0.a.a2.g.h.a().getBoolean("swan_app_js_native_ab_update_key", false)) {
                if (f44690a) {
                    Log.d("SwanAppCompat", "need delete file case update");
                }
                if (!b()) {
                    return;
                }
                d.b.g0.a.a2.g.h.a().putBoolean("swan_app_js_native_ab_update_key", false);
            } else {
                if (f44690a) {
                    Log.d("SwanAppCompat", "start create cache");
                }
                n(d.b.g0.p.d.s(new File(str)), z);
                return;
            }
        }
        f(z, str);
    }

    public static void n(List<String> list, boolean z) {
        if (list == null) {
            return;
        }
        synchronized (f44693d) {
            if (f44694e != 0) {
                return;
            }
            if (z) {
                f44691b = list;
            } else {
                f44692c = list;
            }
            if (f44690a) {
                StringBuilder sb = new StringBuilder();
                sb.append("has update descriptions, list :");
                sb.append(list.toString());
                sb.append(" type :");
                sb.append(z ? V8Engine.TYPE_V8 : "webview");
                Log.d("SwanAppCompat", sb.toString());
            }
        }
    }
}
