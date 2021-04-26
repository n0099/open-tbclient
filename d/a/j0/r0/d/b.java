package d.a.j0.r0.d;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tieba.compatible.EditorHelper;
import com.baidu.tieba.funAd.strategy.FunAdSidConfigData;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: b  reason: collision with root package name */
    public static volatile b f59518b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, FunAdSidConfigData> f59519a;

    public b() {
        HashMap hashMap = new HashMap();
        this.f59519a = hashMap;
        hashMap.clear();
        this.f59519a.putAll(c());
    }

    public static b e() {
        if (f59518b == null) {
            synchronized (b.class) {
                if (f59518b == null) {
                    f59518b = new b();
                }
            }
        }
        return f59518b;
    }

    public final FunAdSidConfigData a(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        FunAdSidConfigData funAdSidConfigData = new FunAdSidConfigData();
        funAdSidConfigData.parserJson(jSONObject);
        return funAdSidConfigData;
    }

    public FunAdSidConfigData b(String str) {
        if (this.f59519a == null || TextUtils.isEmpty(str) || !this.f59519a.containsKey(str)) {
            return null;
        }
        return this.f59519a.get(str);
    }

    public final Map<String, FunAdSidConfigData> c() {
        FunAdSidConfigData d2;
        HashMap hashMap = new HashMap();
        for (String str : c.e().c()) {
            if (!TextUtils.isEmpty(str) && (d2 = d(str)) != null) {
                hashMap.put(str, d2);
            }
        }
        return hashMap;
    }

    public final FunAdSidConfigData d(String str) {
        JSONObject jSONObject = null;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String string = c.g().getString(str, "");
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            jSONObject = new JSONObject(string);
        } catch (JSONException e2) {
            BdLog.detailException(e2);
        }
        return a(jSONObject);
    }

    public void f(String str, FunAdSidConfigData funAdSidConfigData) {
        if (this.f59519a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f59519a.put(str, funAdSidConfigData);
        g(str);
    }

    public final void g(String str) {
        FunAdSidConfigData funAdSidConfigData;
        JSONObject json;
        if (this.f59519a == null || TextUtils.isEmpty(str) || !this.f59519a.containsKey(str) || (funAdSidConfigData = this.f59519a.get(str)) == null || (json = funAdSidConfigData.toJson()) == null) {
            return;
        }
        EditorHelper.putString(c.g(), str, json.toString());
    }
}
