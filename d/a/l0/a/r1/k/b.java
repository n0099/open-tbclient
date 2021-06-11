package d.a.l0.a.r1.k;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
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
    public static final boolean k = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public c f48138a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f48139b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, List<d.a.l0.a.r1.k.a>> f48140c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f48141d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public String f48142e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f48143f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f48144g;

    /* renamed from: h  reason: collision with root package name */
    public long f48145h;

    /* renamed from: i  reason: collision with root package name */
    public long f48146i;
    public volatile d.a.l0.a.r1.k.j.c j;

    /* loaded from: classes3.dex */
    public class a implements c {
        public a() {
        }

        @Override // d.a.l0.a.r1.k.c
        public boolean a(d.a.l0.a.r1.k.a aVar) {
            if (aVar == null || aVar.c() < 0) {
                return false;
            }
            if (b.k || aVar.b() == 0) {
                return b.this.o(aVar.e());
            }
            return false;
        }
    }

    @Override // d.a.l0.a.r1.k.e
    public void b(long j) {
        p();
        u();
        this.f48145h = j;
        q("launch start time-" + j);
    }

    @Override // d.a.l0.a.r1.k.e
    public void c(long j) {
        this.f48144g = true;
        this.f48146i = j;
        v(k());
        q("launch end time-" + (this.f48145h + this.f48146i));
    }

    @Override // d.a.l0.a.r1.k.d
    public void d(JSONObject jSONObject) {
        if (f.j().m()) {
            p();
            if (this.f48143f) {
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
                            if (TextUtils.isEmpty(this.f48142e)) {
                                this.f48142e = optJSONObject.optString("swan");
                                q("current swan version " + this.f48142e);
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
        if (this.f48144g && this.f48139b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("----- ");
            sb.append("launch start time ");
            sb.append(this.f48139b.format(Long.valueOf(this.f48145h)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("launch end time ");
            sb.append(this.f48139b.format(Long.valueOf(this.f48145h + this.f48146i)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("swan js version ");
            sb.append(this.f48142e);
            sb.append("\n");
            synchronized (this.f48141d) {
                i2 = 0;
                i3 = 0;
                for (Map.Entry<String, List<d.a.l0.a.r1.k.a>> entry : this.f48140c.entrySet()) {
                    List<d.a.l0.a.r1.k.a> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        int i4 = 0;
                        for (d.a.l0.a.r1.k.a aVar : value) {
                            if (this.f48138a == null || this.f48138a.a(aVar)) {
                                sb2.append("----- start time ");
                                sb2.append(this.f48139b.format(Long.valueOf(aVar.e())));
                                sb2.append("\n");
                                sb2.append("----- end time ");
                                sb2.append(this.f48139b.format(Long.valueOf(aVar.d())));
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
            d.a.l0.a.e0.d.a("ApiCalledMarker", sb3);
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
            synchronized (this.f48141d) {
                if (this.j == null) {
                    this.j = jSONObject.has("caller") ? new d.a.l0.a.r1.k.j.b() : new d.a.l0.a.r1.k.j.a();
                }
            }
        }
    }

    public final boolean o(long j) {
        long j2 = this.f48145h;
        return j >= j2 && j <= j2 + this.f48146i;
    }

    public final void p() {
        if (this.f48140c != null) {
            return;
        }
        synchronized (this.f48141d) {
            if (this.f48140c == null) {
                this.f48140c = new HashMap<>();
                this.f48139b = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                this.f48138a = new a();
            }
        }
    }

    public final void q(String str) {
        if (k) {
            Log.d("ApiCalledMarker", str);
        }
    }

    public final boolean r(long j) {
        return this.f48144g && j > this.f48145h + this.f48146i;
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
        this.f48143f = z;
        q("start done " + this.f48143f);
    }

    public final boolean t(JSONObject jSONObject) {
        List<d.a.l0.a.r1.k.a> a2;
        n(jSONObject);
        String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
        if (TextUtils.isEmpty(optString) || (a2 = this.j.a(jSONObject)) == null || a2.size() <= 0) {
            return true;
        }
        boolean z = a2.size() > 0;
        synchronized (this.f48141d) {
            List<d.a.l0.a.r1.k.a> list = this.f48140c.get(optString);
            if (list == null) {
                list = new ArrayList<>();
                this.f48140c.put(optString, list);
            }
            list.addAll(a2);
            for (d.a.l0.a.r1.k.a aVar : a2) {
                z &= r(aVar.e());
            }
        }
        if (k) {
            Log.d("ApiCalledMarker", "api - " + optString + ", all after fmp - " + z);
        }
        return !z;
    }

    public final void u() {
        if (this.f48140c.size() > 0) {
            synchronized (this.f48141d) {
                this.f48140c.clear();
            }
        }
        this.f48143f = false;
        this.f48144g = false;
        this.f48146i = 0L;
        this.f48145h = 0L;
        this.f48142e = null;
        v("===== loading... =====");
    }

    public final void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.l0.a.q2.d.j.d(str);
    }
}
