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
    public static String f64507g = "Flow";

    /* renamed from: a  reason: collision with root package name */
    public int f64508a;

    /* renamed from: b  reason: collision with root package name */
    public int f64509b;

    /* renamed from: e  reason: collision with root package name */
    public Context f64512e;

    /* renamed from: d  reason: collision with root package name */
    public long f64511d = 0;

    /* renamed from: c  reason: collision with root package name */
    public final long f64510c = System.currentTimeMillis();

    /* renamed from: f  reason: collision with root package name */
    public Map<String, String> f64513f = new ConcurrentHashMap();

    /* loaded from: classes2.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public String f64514e;

        /* renamed from: f  reason: collision with root package name */
        public String f64515f;

        public a(String str, String str2) {
            this.f64514e = str;
            this.f64515f = str2;
        }

        @Override // java.lang.Runnable
        public void run() {
            c.this.f64513f.put(this.f64514e, this.f64515f);
        }
    }

    public c(Context context, int i2, int i3) {
        this.f64512e = context;
        this.f64508a = i2;
        this.f64509b = i3;
    }

    public c b(String str, int i2) {
        if (!TextUtils.isEmpty(str)) {
            d.a.t.a.a.a.h(this.f64512e).f().execute(new a(str, String.valueOf(i2)));
        }
        String str2 = f64507g;
        d.a.t.a.h.e.a(str2, "flow addEvent id:" + str + ",value:" + i2);
        return this;
    }

    public c c(String str, long j) {
        if (!TextUtils.isEmpty(str)) {
            d.a.t.a.a.a.h(this.f64512e).f().execute(new a(str, String.valueOf(j)));
        }
        String str2 = f64507g;
        d.a.t.a.h.e.a(str2, "flow addEvent id:" + str + ",value:" + j);
        return this;
    }

    public c d(String str, String str2) {
        if (!TextUtils.isEmpty(str) && str2 != null) {
            d.a.t.a.a.a.h(this.f64512e).f().execute(new a(str, str2));
        }
        String str3 = f64507g;
        d.a.t.a.h.e.a(str3, "flow addEvent id:" + str + ",value:" + str2);
        return this;
    }

    public void e() {
        this.f64511d = System.currentTimeMillis();
        d.a.t.a.a.a.h(this.f64512e).e(this);
    }

    public String f() {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, String> entry : this.f64513f.entrySet()) {
                jSONObject.put(entry.getKey(), entry.getValue());
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return jSONObject.toString();
    }

    public Map<String, String> g() {
        return this.f64513f;
    }
}
