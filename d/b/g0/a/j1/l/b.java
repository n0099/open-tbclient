package d.b.g0.a.j1.l;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements d {
    public static final boolean j = k.f45050a;

    /* renamed from: b  reason: collision with root package name */
    public c f44906b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f44907c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, List<d.b.g0.a.j1.l.a>> f44908d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f44909e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public String f44910f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f44911g;

    /* renamed from: h  reason: collision with root package name */
    public long f44912h;
    public long i;

    /* loaded from: classes3.dex */
    public class a implements c {
        public a() {
        }

        @Override // d.b.g0.a.j1.l.c
        public boolean a(d.b.g0.a.j1.l.a aVar) {
            if (aVar == null || aVar.b() < 0) {
                return false;
            }
            if (b.j || !d.f44914a.contains(aVar.a())) {
                return b.this.k(aVar.d());
            }
            return false;
        }
    }

    @Override // d.b.g0.a.j1.l.e
    public void b(long j2) {
        l();
        n();
        this.f44912h = j2;
        m("launch start time-" + j2);
    }

    @Override // d.b.g0.a.j1.l.e
    public void e(long j2) {
        this.f44911g = true;
        this.i = j2;
        o(j());
        m("launch end time-" + (this.f44912h + this.i));
    }

    public String j() {
        int i;
        int i2;
        if (this.f44911g) {
            StringBuilder sb = new StringBuilder();
            sb.append("----- ");
            sb.append("launch start time ");
            sb.append(this.f44907c.format(Long.valueOf(this.f44912h)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("launch end time ");
            sb.append(this.f44907c.format(Long.valueOf(this.f44912h + this.i)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("swan js version ");
            sb.append(this.f44910f);
            sb.append("\n");
            synchronized (this.f44909e) {
                i = 0;
                i2 = 0;
                for (Map.Entry<String, List<d.b.g0.a.j1.l.a>> entry : this.f44908d.entrySet()) {
                    List<d.b.g0.a.j1.l.a> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        int i3 = 0;
                        for (d.b.g0.a.j1.l.a aVar : value) {
                            if (this.f44906b == null || this.f44906b.a(aVar)) {
                                sb2.append("----- start time ");
                                sb2.append(this.f44907c.format(Long.valueOf(aVar.d())));
                                sb2.append("\n");
                                sb2.append("----- end time ");
                                sb2.append(this.f44907c.format(Long.valueOf(aVar.c())));
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
        long j3 = this.f44912h;
        return j2 >= j3 && j2 <= j3 + this.i;
    }

    public final void l() {
        if (this.f44908d != null) {
            return;
        }
        synchronized (this.f44909e) {
            if (this.f44908d == null) {
                this.f44908d = new HashMap<>();
                this.f44907c = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                this.f44906b = new a();
            }
        }
    }

    public final void m(String str) {
        if (j) {
            Log.d("ApiCalledMarker", str);
        }
    }

    public final void n() {
        if (this.f44908d.size() > 0) {
            synchronized (this.f44909e) {
                this.f44908d.clear();
            }
        }
        this.f44911g = false;
        this.i = 0L;
        this.f44912h = 0L;
        this.f44910f = null;
        o("===== loading... =====");
    }

    public final void o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.b.g0.a.f2.d.j.d(str);
    }
}
