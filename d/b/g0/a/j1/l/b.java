package d.b.g0.a.j1.l;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes2.dex */
public class b implements d {
    public static final boolean j = k.f45443a;

    /* renamed from: b  reason: collision with root package name */
    public c f45299b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f45300c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, List<d.b.g0.a.j1.l.a>> f45301d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f45302e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public String f45303f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f45304g;

    /* renamed from: h  reason: collision with root package name */
    public long f45305h;
    public long i;

    /* loaded from: classes2.dex */
    public class a implements c {
        public a() {
        }

        @Override // d.b.g0.a.j1.l.c
        public boolean a(d.b.g0.a.j1.l.a aVar) {
            if (aVar == null || aVar.b() < 0) {
                return false;
            }
            if (b.j || !d.f45307a.contains(aVar.a())) {
                return b.this.k(aVar.d());
            }
            return false;
        }
    }

    @Override // d.b.g0.a.j1.l.e
    public void b(long j2) {
        l();
        n();
        this.f45305h = j2;
        m("launch start time-" + j2);
    }

    @Override // d.b.g0.a.j1.l.e
    public void e(long j2) {
        this.f45304g = true;
        this.i = j2;
        o(j());
        m("launch end time-" + (this.f45305h + this.i));
    }

    public String j() {
        int i;
        int i2;
        if (this.f45304g) {
            StringBuilder sb = new StringBuilder();
            sb.append("----- ");
            sb.append("launch start time ");
            sb.append(this.f45300c.format(Long.valueOf(this.f45305h)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("launch end time ");
            sb.append(this.f45300c.format(Long.valueOf(this.f45305h + this.i)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("swan js version ");
            sb.append(this.f45303f);
            sb.append("\n");
            synchronized (this.f45302e) {
                i = 0;
                i2 = 0;
                for (Map.Entry<String, List<d.b.g0.a.j1.l.a>> entry : this.f45301d.entrySet()) {
                    List<d.b.g0.a.j1.l.a> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        int i3 = 0;
                        for (d.b.g0.a.j1.l.a aVar : value) {
                            if (this.f45299b == null || this.f45299b.a(aVar)) {
                                sb2.append("----- start time ");
                                sb2.append(this.f45300c.format(Long.valueOf(aVar.d())));
                                sb2.append("\n");
                                sb2.append("----- end time ");
                                sb2.append(this.f45300c.format(Long.valueOf(aVar.c())));
                                sb2.append("\n");
                                sb2.append("----- cost time ");
                                sb2.append(aVar.b());
                                sb2.append("ms\n");
                                sb2.append("----------------------------\n");
                                i2++;
                                i3++;
                            }
                        }
                        if (i3 > 0) {
                            sb.append("\n===== ");
                            sb.append(entry.getKey());
                            sb.append(" ");
                            sb.append(i3);
                            sb.append(" times\n");
                            sb.append((CharSequence) sb2);
                            i++;
                        }
                    }
                }
            }
            sb.append("===== total: ");
            sb.append(i);
            sb.append(" apis, ");
            sb.append(i2);
            sb.append(" times");
            String sb3 = sb.toString();
            d.b.g0.a.c0.c.a("ApiCalledMarker", sb3);
            return sb3;
        }
        return "";
    }

    public final boolean k(long j2) {
        long j3 = this.f45305h;
        return j2 >= j3 && j2 <= j3 + this.i;
    }

    public final void l() {
        if (this.f45301d != null) {
            return;
        }
        synchronized (this.f45302e) {
            if (this.f45301d == null) {
                this.f45301d = new HashMap<>();
                this.f45300c = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                this.f45299b = new a();
            }
        }
    }

    public final void m(String str) {
        if (j) {
            Log.d("ApiCalledMarker", str);
        }
    }

    public final void n() {
        if (this.f45301d.size() > 0) {
            synchronized (this.f45302e) {
                this.f45301d.clear();
            }
        }
        this.f45304g = false;
        this.i = 0L;
        this.f45305h = 0L;
        this.f45303f = null;
        o("===== loading... =====");
    }

    public final void o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.g0.a.f2.d.j.d(str);
    }
}
