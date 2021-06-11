package d.a.t.a.a;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c {

    /* renamed from: g  reason: collision with root package name */
    public static String f68225g = "Flow";

    /* renamed from: a  reason: collision with root package name */
    public int f68226a;

    /* renamed from: b  reason: collision with root package name */
    public int f68227b;

    /* renamed from: e  reason: collision with root package name */
    public Context f68230e;

    /* renamed from: d  reason: collision with root package name */
    public long f68229d = 0;

    /* renamed from: c  reason: collision with root package name */
    public final long f68228c = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f68231f = new ConcurrentHashMap();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f68232e;

        /* renamed from: f  reason: collision with root package name */
        public String f68233f;

        public a(String str, String str2) {
            this.f68232e = str;
            this.f68233f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f68231f.put(this.f68232e, this.f68233f);
        }
    }

    public c(Context context, int i2, int i3) {
        this.f68230e = context;
        this.f68226a = i2;
        this.f68227b = i3;
    }

    public c b(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            d.a.t.a.a.a.h(this.f68230e).f().execute(new a(str, String.valueOf(i2)));
        }
        String str2 = f68225g;
        d.a.t.a.h.e.a(str2, "flow addEvent id:" + str + ",value:" + i2);
        return this;
    }

    public c c(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            d.a.t.a.a.a.h(this.f68230e).f().execute(new a(str, String.valueOf(j)));
        }
        String str2 = f68225g;
        d.a.t.a.h.e.a(str2, "flow addEvent id:" + str + ",value:" + j);
        return this;
    }

    public c d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            d.a.t.a.a.a.h(this.f68230e).f().execute(new a(str, str2));
        }
        String str3 = f68225g;
        d.a.t.a.h.e.a(str3, "flow addEvent id:" + str + ",value:" + str2);
        return this;
    }

    public void e() {
        this.f68229d = System.currentTimeMillis();
        d.a.t.a.a.a.h(this.f68230e).e(this);
    }

    public String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.f68231f.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public Map<String, String> g() {
        return this.f68231f;
    }
}
