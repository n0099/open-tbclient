package d.a.m0.a.v2.b1.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import d.a.m0.a.a1.e;
import d.a.m0.a.k;
import d.a.m0.a.v2.b1.a.b;
import d.a.m0.a.v2.j;
import d.a.m0.n.j.i.m;
import d.a.m0.t.d;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends j.a {

    /* renamed from: c  reason: collision with root package name */
    public static final boolean f49142c = k.f46983a;

    /* renamed from: b  reason: collision with root package name */
    public final String f49143b;

    public a(boolean z) {
        super(z);
        String str = z ? "swan_js_native_v8_ab.txt" : "swan_js_native_webview_ab.txt";
        this.f49143b = e.g().getPath() + File.separator + "js_native" + File.separator + str;
    }

    public boolean a(int i2) {
        boolean z;
        String str = e.g().getPath() + File.separator + "js_native" + File.separator;
        if ((i2 & 1) != 0) {
            z = d.L(str + "swan_js_native_v8_ab.txt");
        } else {
            z = true;
        }
        if ((i2 & 2) != 0) {
            return z & d.L(str + "swan_js_native_webview_ab.txt");
        }
        return z;
    }

    @Nullable
    public final List<String> b(boolean z, String str) {
        List<JSONObject> b2 = d.a.m0.a.v2.b1.a.a.b(z ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW, z ? "swan/v8_ab" : "swan/webview_ab");
        if (b2 != null) {
            File file = new File(str);
            ArrayList arrayList = new ArrayList();
            for (JSONObject jSONObject : b2) {
                if (jSONObject != null) {
                    arrayList.add(jSONObject.toString());
                }
            }
            if (file.exists()) {
                d.K(file);
            }
            d.h(file);
            d.O(arrayList, file);
            return arrayList;
        }
        return null;
    }

    public boolean c(@NonNull JSONArray jSONArray) {
        if (jSONArray.length() <= 0 || !d.u(this.f49143b)) {
            return false;
        }
        return b.a(jSONArray, new File(this.f49143b), SchemeCollecter.getSchemesDesListSize(this.f49199a ? SchemeCollecter.CLASSIFY_SWAN_V8 : SchemeCollecter.CLASSIFY_SWAN_WEBVIEW));
    }

    public List<String> d() {
        if (f49142c) {
            Log.i("SwanAppCompat", "FileDescriptionsManager obtain desc...");
        }
        if (!m.b() && !TextUtils.equals(m.a(), "0")) {
            File file = new File(this.f49143b);
            if (file.exists()) {
                d.K(file);
            }
        }
        if (d.u(this.f49143b)) {
            if (f49142c) {
                Log.d("SwanAppCompat", "start create cache");
            }
            return d.E(new File(this.f49143b));
        }
        return b(this.f49199a, this.f49143b);
    }
}
