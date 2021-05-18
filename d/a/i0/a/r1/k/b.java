package d.a.i0.a.r1.k;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
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
    public static final boolean k = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public c f44288a;

    /* renamed from: b  reason: collision with root package name */
    public SimpleDateFormat f44289b;

    /* renamed from: c  reason: collision with root package name */
    public HashMap<String, List<d.a.i0.a.r1.k.a>> f44290c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f44291d = new Object();

    /* renamed from: e  reason: collision with root package name */
    public String f44292e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f44293f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44294g;

    /* renamed from: h  reason: collision with root package name */
    public long f44295h;

    /* renamed from: i  reason: collision with root package name */
    public long f44296i;
    public volatile d.a.i0.a.r1.k.j.c j;

    /* loaded from: classes3.dex */
    public class a implements c {
        public a() {
        }

        @Override // d.a.i0.a.r1.k.c
        public boolean a(d.a.i0.a.r1.k.a aVar) {
            if (aVar == null || aVar.c() < 0) {
                return false;
            }
            if (b.k || aVar.b() == 0) {
                return b.this.o(aVar.e());
            }
            return false;
        }
    }

    @Override // d.a.i0.a.r1.k.e
    public void b(long j) {
        p();
        u();
        this.f44295h = j;
        q("launch start time-" + j);
    }

    @Override // d.a.i0.a.r1.k.e
    public void c(long j) {
        this.f44294g = true;
        this.f44296i = j;
        v(k());
        q("launch end time-" + (this.f44295h + this.f44296i));
    }

    @Override // d.a.i0.a.r1.k.d
    public void d(JSONObject jSONObject) {
        if (f.j().m()) {
            p();
            if (this.f44293f) {
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
                            if (TextUtils.isEmpty(this.f44292e)) {
                                this.f44292e = optJSONObject.optString("swan");
                                q("current swan version " + this.f44292e);
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
        if (this.f44294g && this.f44289b != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("----- ");
            sb.append("launch start time ");
            sb.append(this.f44289b.format(Long.valueOf(this.f44295h)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("launch end time ");
            sb.append(this.f44289b.format(Long.valueOf(this.f44295h + this.f44296i)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("swan js version ");
            sb.append(this.f44292e);
            sb.append("\n");
            synchronized (this.f44291d) {
                i2 = 0;
                i3 = 0;
                for (Map.Entry<String, List<d.a.i0.a.r1.k.a>> entry : this.f44290c.entrySet()) {
                    List<d.a.i0.a.r1.k.a> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        int i4 = 0;
                        for (d.a.i0.a.r1.k.a aVar : value) {
                            if (this.f44288a == null || this.f44288a.a(aVar)) {
                                sb2.append("----- start time ");
                                sb2.append(this.f44289b.format(Long.valueOf(aVar.e())));
                                sb2.append("\n");
                                sb2.append("----- end time ");
                                sb2.append(this.f44289b.format(Long.valueOf(aVar.d())));
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
            d.a.i0.a.e0.d.a("ApiCalledMarker", sb3);
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
            synchronized (this.f44291d) {
                if (this.j == null) {
                    this.j = jSONObject.has("caller") ? new d.a.i0.a.r1.k.j.b() : new d.a.i0.a.r1.k.j.a();
                }
            }
        }
    }

    public final boolean o(long j) {
        long j2 = this.f44295h;
        return j >= j2 && j <= j2 + this.f44296i;
    }

    public final void p() {
        if (this.f44290c != null) {
            return;
        }
        synchronized (this.f44291d) {
            if (this.f44290c == null) {
                this.f44290c = new HashMap<>();
                this.f44289b = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                this.f44288a = new a();
            }
        }
    }

    public final void q(String str) {
        if (k) {
            Log.d("ApiCalledMarker", str);
        }
    }

    public final boolean r(long j) {
        return this.f44294g && j > this.f44295h + this.f44296i;
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
        this.f44293f = z;
        q("start done " + this.f44293f);
    }

    public final boolean t(JSONObject jSONObject) {
        List<d.a.i0.a.r1.k.a> a2;
        n(jSONObject);
        String optString = jSONObject.optString(com.alipay.sdk.cons.c.n);
        if (TextUtils.isEmpty(optString) || (a2 = this.j.a(jSONObject)) == null || a2.size() <= 0) {
            return true;
        }
        boolean z = a2.size() > 0;
        synchronized (this.f44291d) {
            List<d.a.i0.a.r1.k.a> list = this.f44290c.get(optString);
            if (list == null) {
                list = new ArrayList<>();
                this.f44290c.put(optString, list);
            }
            list.addAll(a2);
            for (d.a.i0.a.r1.k.a aVar : a2) {
                z &= r(aVar.e());
            }
        }
        if (k) {
            Log.d("ApiCalledMarker", "api - " + optString + ", all after fmp - " + z);
        }
        return !z;
    }

    public final void u() {
        if (this.f44290c.size() > 0) {
            synchronized (this.f44291d) {
                this.f44290c.clear();
            }
        }
        this.f44293f = false;
        this.f44294g = false;
        this.f44296i = 0L;
        this.f44295h = 0L;
        this.f44292e = null;
        v("===== loading... =====");
    }

    public final void v(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.i0.a.q2.d.j.d(str);
    }
}
