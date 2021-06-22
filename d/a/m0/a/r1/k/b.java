package d.a.m0.a.r1.k;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.k;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b implements d {
    public static final boolean k = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public c f48246a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f48247b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, List<d.a.m0.a.r1.k.a>> f48248c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f48249d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public String f48250e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48251f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48252g;

    /* renamed from: h  reason: collision with root package name */
    public long f48253h;

    /* renamed from: i  reason: collision with root package name */
    public long f48254i;
    public volatile d.a.m0.a.r1.k.j.c j;

    /* loaded from: classes3.dex */
    public class a implements c {
        public a() {
        }

        @Override // d.a.m0.a.r1.k.c
        public boolean a(d.a.m0.a.r1.k.a aVar) {
            if (aVar == null || aVar.c() < 0) {
                return false;
            }
            if (b.k || aVar.b() == 0) {
                return b.this.o(aVar.e());
            }
            return false;
        }
    }

    @Override // d.a.m0.a.r1.k.e
    public void b(long j) {
        p();
        u();
        this.f48253h = j;
        q("launch start time-" + j);
    }

    @Override // d.a.m0.a.r1.k.e
    public void c(long j) {
        this.f48252g = true;
        this.f48254i = j;
        v(k());
        q("launch end time-" + (this.f48253h + this.f48254i));
    }

    @Override // d.a.m0.a.r1.k.d
    public void d(JSONObject jSONObject) {
        if (f.j().m()) {
            p();
            if (this.f48251f) {
                q("aiapp start finish");
                return;
            }
            q("ubcReport enter");
            if (jSONObject != null && jSONObject.length() > 0) {
                String m = m(jSONObject);
                q("Id " + m);
                if (TextUtils.equals(m, "786")) {
                    if (k) {
                        Log.d("ApiCalledMarker", jSONObject.toString());
                    }
                    JSONObject l = l(jSONObject);
                    if (l != null && l.length() > 0) {
                        JSONObject optJSONObject = l.optJSONObject("ext");
                        if (optJSONObject != null && optJSONObject.length() > 0) {
                            if (TextUtils.isEmpty(this.f48250e)) {
                                this.f48250e = optJSONObject.optString("swan");
                                q("current swan version " + this.f48250e);
                            }
                            JSONArray optJSONArray = optJSONObject.optJSONArray("list");
                            if (optJSONArray != null && optJSONArray.length() > 0) {
                                s(optJSONArray);
                                q("ubcReport over");
                                v(k());
                                return;
                            }
                            q("value-ext-list is empty");
                            return;
                        }
                        q("value-ext is empty");
                        return;
                    }
                    q("value is empty");
                    return;
                }
                return;
            }
            q("json data is empty");
        }
    }

    public String k() {
        int i2;
        int i3;
        if (this.f48252g && this.f48247b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("----- ");
            sb.append("launch start time ");
            sb.append(this.f48247b.format(Long.valueOf(this.f48253h)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("launch end time ");
            sb.append(this.f48247b.format(Long.valueOf(this.f48253h + this.f48254i)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("swan js version ");
            sb.append(this.f48250e);
            sb.append("\n");
            synchronized (this.f48249d) {
                i2 = 0;
                i3 = 0;
                for (Map.Entry<String, List<d.a.m0.a.r1.k.a>> entry : this.f48248c.entrySet()) {
                    List<d.a.m0.a.r1.k.a> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        int i4 = 0;
                        for (d.a.m0.a.r1.k.a aVar : value) {
                            if (this.f48246a == null || this.f48246a.a(aVar)) {
                                sb2.append("----- start time ");
                                sb2.append(this.f48247b.format(Long.valueOf(aVar.e())));
                                sb2.append("\n");
                                sb2.append("----- end time ");
                                sb2.append(this.f48247b.format(Long.valueOf(aVar.d())));
                                sb2.append("\n");
                                sb2.append("----- cost time ");
                                sb2.append(aVar.c());
                                sb2.append("ms\n");
                                sb2.append("----------------------------\n");
                                i3++;
                                i4++;
                            }
                        }
                        if (i4 > 0) {
                            sb.append("\n===== ");
                            sb.append(entry.getKey());
                            sb.append(" ");
                            sb.append(i4);
                            sb.append(" times\n");
                            sb.append((CharSequence) sb2);
                            i2++;
                        }
                    }
                }
            }
            sb.append("===== total: ");
            sb.append(i2);
            sb.append(" apis, ");
            sb.append(i3);
            sb.append(" times");
            String sb3 = sb.toString();
            d.a.m0.a.e0.d.a("ApiCalledMarker", sb3);
            return sb3;
        }
        return "";
    }

    public final JSONObject l(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("content");
        return optJSONObject == null ? jSONObject.optJSONObject("value") : optJSONObject;
    }

    public final String m(JSONObject jSONObject) {
        String optString = jSONObject.optString("ubcId");
        return TextUtils.isEmpty(optString) ? jSONObject.optString("actionId") : optString;
    }

    public final void n(JSONObject jSONObject) {
        if (this.j == null) {
            synchronized (this.f48249d) {
                if (this.j == null) {
                    this.j = jSONObject.has("caller") ? new d.a.m0.a.r1.k.j.b() : new d.a.m0.a.r1.k.j.a();
                }
            }
        }
    }

    public final boolean o(long j) {
        long j2 = this.f48253h;
        return j >= j2 && j <= j2 + this.f48254i;
    }

    public final void p() {
        if (this.f48248c != null) {
            return;
        }
        synchronized (this.f48249d) {
            if (this.f48248c == null) {
                this.f48248c = new HashMap<>();
                this.f48247b = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                this.f48246a = new a();
            }
        }
    }

    public final void q(String str) {
        if (k) {
            Log.d("ApiCalledMarker", str);
        }
    }

    public final boolean r(long j) {
        return this.f48252g && j > this.f48253h + this.f48254i;
    }

    public final void s(JSONArray jSONArray) {
        q("start parse api info");
        int length = jSONArray.length();
        boolean z = length > 0;
        for (int i2 = 0; i2 < length; i2++) {
            JSONObject optJSONObject = jSONArray.optJSONObject(i2);
            if (optJSONObject != null && optJSONObject.length() > 0 && optJSONObject.optInt("success") == 1) {
                z &= !t(optJSONObject);
            }
        }
        this.f48251f = z;
        q("start done " + this.f48251f);
    }

    public final boolean t(JSONObject jSONObject) {
        List<d.a.m0.a.r1.k.a> a2;
        n(jSONObject);
        String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
        if (TextUtils.isEmpty(optString) || (a2 = this.j.a(jSONObject)) == null || a2.size() <= 0) {
            return true;
        }
        boolean z = a2.size() > 0;
        synchronized (this.f48249d) {
            List<d.a.m0.a.r1.k.a> list = this.f48248c.get(optString);
            if (list == null) {
                list = new ArrayList<>();
                this.f48248c.put(optString, list);
            }
            list.addAll(a2);
            for (d.a.m0.a.r1.k.a aVar : a2) {
                z &= r(aVar.e());
            }
        }
        if (k) {
            Log.d("ApiCalledMarker", "api - " + optString + ", all after fmp - " + z);
        }
        return !z;
    }

    public final void u() {
        if (this.f48248c.size() > 0) {
            synchronized (this.f48249d) {
                this.f48248c.clear();
            }
        }
        this.f48251f = false;
        this.f48252g = false;
        this.f48254i = 0L;
        this.f48253h = 0L;
        this.f48250e = null;
        v("===== loading... =====");
    }

    public final void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.m0.a.q2.d.j.d(str);
    }
}
