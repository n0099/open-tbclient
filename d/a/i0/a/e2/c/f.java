package d.a.i0.a.e2.c;

import android.text.TextUtils;
import com.baidu.searchbox.v8engine.WebGLImageLoader;
import com.heytap.mcssdk.mode.Message;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f41520a;

    /* renamed from: b  reason: collision with root package name */
    public final String f41521b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f41522c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f41523d;

    /* renamed from: e  reason: collision with root package name */
    public String f41524e = "";

    /* renamed from: f  reason: collision with root package name */
    public String f41525f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f41526g = "";

    /* renamed from: h  reason: collision with root package name */
    public List<String> f41527h = new ArrayList();

    /* renamed from: i  reason: collision with root package name */
    public final List<String> f41528i = new ArrayList();
    public int j = -1;
    public String k = "";
    public String l = "";
    public String m = "";
    public a n;
    public JSONObject o;
    public String p;
    public String q;
    public String r;
    public List<f> s;

    /* loaded from: classes3.dex */
    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public String f41529a;

        /* renamed from: b  reason: collision with root package name */
        public String f41530b;

        /* renamed from: c  reason: collision with root package name */
        public String f41531c;

        /* renamed from: d  reason: collision with root package name */
        public String f41532d;

        /* renamed from: e  reason: collision with root package name */
        public String f41533e;

        /* renamed from: f  reason: collision with root package name */
        public JSONArray f41534f;
    }

    public f(String str) {
        this.f41521b = str;
    }

    public static f d(String str, JSONObject jSONObject) {
        f fVar = new f(str);
        fVar.f41520a = jSONObject;
        fVar.f41522c = jSONObject.optBoolean("permit", false);
        fVar.f41523d = jSONObject.optBoolean("forbidden", true);
        fVar.f41524e = jSONObject.optString("grade");
        fVar.k = jSONObject.optString("type", "");
        fVar.f41525f = jSONObject.optString("name", "");
        fVar.f41526g = jSONObject.optString("short_name", "");
        jSONObject.optString("description", "");
        fVar.j = jSONObject.optInt("tip_status", -1);
        fVar.l = jSONObject.optString("explain", "");
        fVar.m = jSONObject.optString("sub_explain", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("ext");
        if (optJSONArray != null) {
            int length = optJSONArray.length();
            for (int i2 = 0; i2 < length; i2++) {
                fVar.f41528i.add(optJSONArray.optString(i2));
            }
        }
        JSONArray optJSONArray2 = jSONObject.optJSONArray(Message.RULE);
        if (optJSONArray2 != null) {
            int length2 = optJSONArray2.length();
            for (int i3 = 0; i3 < length2; i3++) {
                fVar.f41527h.add(optJSONArray2.optString(i3));
            }
        }
        fVar.o = jSONObject.optJSONObject("other");
        fVar.p = jSONObject.optString("plugin_app_name");
        fVar.q = jSONObject.optString("plugin_icon_url");
        if (!jSONObject.has("forbidden")) {
            d.a.i0.a.e0.d.h("SwanAppUpdateManager", "scope:" + str + WebGLImageLoader.DATA_URL + jSONObject);
        }
        return fVar;
    }

    public static f e(JSONObject jSONObject) {
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
        aVar.f41529a = this.o.optString("detail_text");
        this.n.f41531c = this.o.optString("detail_url");
        this.n.f41530b = this.o.optString("text_color");
        this.n.f41532d = this.o.optString("keyword");
        this.n.f41533e = this.o.optString("key_color");
        JSONObject optJSONObject = this.o.optJSONObject("developer_agreements");
        if (optJSONObject != null) {
            this.n.f41534f = optJSONObject.optJSONArray("details");
        }
    }

    public void g(List<f> list) {
        this.s = list;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Scope(%s) tipStatus=%d", this.f41521b, Integer.valueOf(this.j));
    }
}
