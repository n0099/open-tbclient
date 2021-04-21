package d.b.h0.a.v1.c;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f47489a;

    /* renamed from: b  reason: collision with root package name */
    public final String f47490b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f47491c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f47492d;

    /* renamed from: e  reason: collision with root package name */
    public String f47493e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f47494f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f47495g = "";

    /* renamed from: h  reason: collision with root package name */
    public List<String> f47496h = new ArrayList();
    public final List<String> i = new ArrayList();
    public int j = -1;
    public String k = "";
    public String l = "";
    public String m = "";
    public a n;
    public JSONObject o;
    public String p;
    public String q;
    public String r;
    public List<e> s;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f47497a;

        /* renamed from: b  reason: collision with root package name */
        public String f47498b;

        /* renamed from: c  reason: collision with root package name */
        public String f47499c;

        /* renamed from: d  reason: collision with root package name */
        public String f47500d;

        /* renamed from: e  reason: collision with root package name */
        public String f47501e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f47502f;
    }

    public e(String str) {
        this.f47490b = str;
    }

    public static e d(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.f47489a = jSONObject;
        eVar.f47491c = jSONObject.optBoolean("permit", false);
        eVar.f47492d = jSONObject.optBoolean("forbidden", true);
        eVar.f47493e = jSONObject.optString("grade");
        eVar.k = jSONObject.optString("type", "");
        eVar.f47494f = jSONObject.optString("name", "");
        eVar.f47495g = jSONObject.optString("short_name", "");
        jSONObject.optString("description", "");
        eVar.j = jSONObject.optInt("tip_status", -1);
        eVar.l = jSONObject.optString("explain", "");
        eVar.m = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i = 0; i < length; i++) {
                eVar.i.add(optJSONArray.optString(i));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i2 = 0; i2 < length2; i2++) {
                eVar.f47496h.add(optJSONArray2.optString(i2));
            }
        }
        eVar.o = jSONObject.optJSONObject("other");
        eVar.p = jSONObject.optString("plugin_app_name");
        eVar.q = jSONObject.optString("plugin_icon_url");
        return eVar;
    }

    public static e e(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("id", "");
        if (TextUtils.isEmpty(optString)) {
            return null;
        }
        return d(optString, jSONObject);
    }

    public boolean a() {
        return this.j > 0;
    }

    public boolean b() {
        return this.j != 0;
    }

    public boolean c() {
        return "1".equals(this.k);
    }

    public void f() {
        JSONObject jSONObject = this.o;
        if (jSONObject == null || jSONObject.keys() == null || !this.o.keys().hasNext()) {
            return;
        }
        a aVar = new a();
        this.n = aVar;
        aVar.f47497a = this.o.optString("detail_text");
        this.n.f47499c = this.o.optString("detail_url");
        this.n.f47498b = this.o.optString("text_color");
        this.n.f47500d = this.o.optString("keyword");
        this.n.f47501e = this.o.optString("key_color");
        JSONObject optJSONObject = this.o.optJSONObject("developer_agreements");
        if (optJSONObject != null) {
            this.n.f47502f = optJSONObject.optJSONArray("details");
        }
    }

    public void g(List<e> list) {
        this.s = list;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.f47490b, Integer.valueOf(this.j));
    }
}
