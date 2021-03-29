package d.b.g0.a.v1.c;

import android.text.TextUtils;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f46768a;

    /* renamed from: b  reason: collision with root package name */
    public final String f46769b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f46770c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f46771d;

    /* renamed from: e  reason: collision with root package name */
    public String f46772e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f46773f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f46774g = "";

    /* renamed from: h  reason: collision with root package name */
    public List<String> f46775h = new ArrayList();
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

    /* loaded from: classes2.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f46776a;

        /* renamed from: b  reason: collision with root package name */
        public String f46777b;

        /* renamed from: c  reason: collision with root package name */
        public String f46778c;

        /* renamed from: d  reason: collision with root package name */
        public String f46779d;

        /* renamed from: e  reason: collision with root package name */
        public String f46780e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f46781f;
    }

    public e(String str) {
        this.f46769b = str;
    }

    public static e d(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.f46768a = jSONObject;
        eVar.f46770c = jSONObject.optBoolean("permit", false);
        eVar.f46771d = jSONObject.optBoolean("forbidden", true);
        eVar.f46772e = jSONObject.optString("grade");
        eVar.k = jSONObject.optString("type", "");
        eVar.f46773f = jSONObject.optString("name", "");
        eVar.f46774g = jSONObject.optString("short_name", "");
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
                eVar.f46775h.add(optJSONArray2.optString(i2));
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
        aVar.f46776a = this.o.optString("detail_text");
        this.n.f46778c = this.o.optString("detail_url");
        this.n.f46777b = this.o.optString("text_color");
        this.n.f46779d = this.o.optString("keyword");
        this.n.f46780e = this.o.optString("key_color");
        JSONObject optJSONObject = this.o.optJSONObject("developer_agreements");
        if (optJSONObject != null) {
            this.n.f46781f = optJSONObject.optJSONArray("details");
        }
    }

    public void g(List<e> list) {
        this.s = list;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.f46769b, Integer.valueOf(this.j));
    }
}
