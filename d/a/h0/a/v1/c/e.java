package d.a.h0.a.v1.c;

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
    public JSONObject f44910a;

    /* renamed from: b  reason: collision with root package name */
    public final String f44911b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f44912c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f44913d;

    /* renamed from: e  reason: collision with root package name */
    public String f44914e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f44915f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f44916g = "";

    /* renamed from: h  reason: collision with root package name */
    public List<String> f44917h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final List<String> f44918i = new ArrayList();
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
        public String f44919a;

        /* renamed from: b  reason: collision with root package name */
        public String f44920b;

        /* renamed from: c  reason: collision with root package name */
        public String f44921c;

        /* renamed from: d  reason: collision with root package name */
        public String f44922d;

        /* renamed from: e  reason: collision with root package name */
        public String f44923e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f44924f;
    }

    public e(String str) {
        this.f44911b = str;
    }

    public static e d(String str, JSONObject jSONObject) {
        e eVar = new e(str);
        eVar.f44910a = jSONObject;
        eVar.f44912c = jSONObject.optBoolean("permit", false);
        eVar.f44913d = jSONObject.optBoolean("forbidden", true);
        eVar.f44914e = jSONObject.optString("grade");
        eVar.k = jSONObject.optString("type", "");
        eVar.f44915f = jSONObject.optString("name", "");
        eVar.f44916g = jSONObject.optString("short_name", "");
        jSONObject.optString("description", "");
        eVar.j = jSONObject.optInt("tip_status", -1);
        eVar.l = jSONObject.optString("explain", "");
        eVar.m = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                eVar.f44918i.add(optJSONArray.optString(i2));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                eVar.f44917h.add(optJSONArray2.optString(i3));
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
        aVar.f44919a = this.o.optString("detail_text");
        this.n.f44921c = this.o.optString("detail_url");
        this.n.f44920b = this.o.optString("text_color");
        this.n.f44922d = this.o.optString("keyword");
        this.n.f44923e = this.o.optString("key_color");
        JSONObject optJSONObject = this.o.optJSONObject("developer_agreements");
        if (optJSONObject != null) {
            this.n.f44924f = optJSONObject.optJSONArray("details");
        }
    }

    public void g(List<e> list) {
        this.s = list;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.f44911b, Integer.valueOf(this.j));
    }
}
