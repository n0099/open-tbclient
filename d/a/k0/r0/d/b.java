package d.a.k0.r0.d;

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
    public static volatile b f60263b;

    /* renamed from: a  reason: collision with root package name */
    public Map<String, FunAdSidConfigData> f60264a;

    public b() {
        HashMap hashMap = new HashMap();
        this.f60264a = hashMap;
        hashMap.clear();
        this.f60264a.putAll(c());
    }

    public static b e() {
        if (f60263b == null) {
            synchronized (b.class) {
                if (f60263b == null) {
                    f60263b = new b();
                }
            }
        }
        return f60263b;
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
        if (this.f60264a == null || TextUtils.isEmpty(str) || !this.f60264a.containsKey(str)) {
            return null;
        }
        return this.f60264a.get(str);
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
        if (this.f60264a == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f60264a.put(str, funAdSidConfigData);
        g(str);
    }

    public final void g(String str) {
        FunAdSidConfigData funAdSidConfigData;
        JSONObject json;
        if (this.f60264a == null || TextUtils.isEmpty(str) || !this.f60264a.containsKey(str) || (funAdSidConfigData = this.f60264a.get(str)) == null || (json = funAdSidConfigData.toJson()) == null) {
            return;
        }
        EditorHelper.putString(c.g(), str, json.toString());
    }
}
