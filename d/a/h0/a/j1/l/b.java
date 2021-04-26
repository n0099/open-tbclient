package d.a.h0.a.j1.l;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
/* loaded from: classes3.dex */
public class b implements d {
    public static final boolean j = k.f43101a;

    /* renamed from: b  reason: collision with root package name */
    public c f42951b;

    /* renamed from: c  reason: collision with root package name */
    public SimpleDateFormat f42952c;

    /* renamed from: d  reason: collision with root package name */
    public HashMap<String, List<d.a.h0.a.j1.l.a>> f42953d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f42954e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public String f42955f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f42956g;

    /* renamed from: h  reason: collision with root package name */
    public long f42957h;

    /* renamed from: i  reason: collision with root package name */
    public long f42958i;

    /* loaded from: classes3.dex */
    public class a implements c {
        public a() {
        }

        @Override // d.a.h0.a.j1.l.c
        public boolean a(d.a.h0.a.j1.l.a aVar) {
            if (aVar == null || aVar.b() < 0) {
                return false;
            }
            if (b.j || !d.f42960a.contains(aVar.a())) {
                return b.this.k(aVar.d());
            }
            return false;
        }
    }

    @Override // d.a.h0.a.j1.l.e
    public void b(long j2) {
        l();
        n();
        this.f42957h = j2;
        m("launch start time-" + j2);
    }

    @Override // d.a.h0.a.j1.l.e
    public void c(long j2) {
        this.f42956g = true;
        this.f42958i = j2;
        o(j());
        m("launch end time-" + (this.f42957h + this.f42958i));
    }

    public String j() {
        int i2;
        int i3;
        if (this.f42956g) {
            StringBuilder sb = new StringBuilder();
            sb.append("----- ");
            sb.append("launch start time ");
            sb.append(this.f42952c.format(Long.valueOf(this.f42957h)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("launch end time ");
            sb.append(this.f42952c.format(Long.valueOf(this.f42957h + this.f42958i)));
            sb.append("\n");
            sb.append("----- ");
            sb.append("swan js version ");
            sb.append(this.f42955f);
            sb.append("\n");
            synchronized (this.f42954e) {
                i2 = 0;
                i3 = 0;
                for (Map.Entry<String, List<d.a.h0.a.j1.l.a>> entry : this.f42953d.entrySet()) {
                    List<d.a.h0.a.j1.l.a> value = entry.getValue();
                    if (value != null && value.size() > 0) {
                        StringBuilder sb2 = new StringBuilder();
                        int i4 = 0;
                        for (d.a.h0.a.j1.l.a aVar : value) {
                            if (this.f42951b == null || this.f42951b.a(aVar)) {
                                sb2.append("----- start time ");
                                sb2.append(this.f42952c.format(Long.valueOf(aVar.d())));
                                sb2.append("\n");
                                sb2.append("----- end time ");
                                sb2.append(this.f42952c.format(Long.valueOf(aVar.c())));
                                sb2.append("\n");
                                sb2.append("----- cost time ");
                                sb2.append(aVar.b());
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
            d.a.h0.a.c0.c.a("ApiCalledMarker", sb3);
            return sb3;
        }
        return "";
    }

    public final boolean k(long j2) {
        long j3 = this.f42957h;
        return j2 >= j3 && j2 <= j3 + this.f42958i;
    }

    public final void l() {
        if (this.f42953d != null) {
            return;
        }
        synchronized (this.f42954e) {
            if (this.f42953d == null) {
                this.f42953d = new HashMap<>();
                this.f42952c = new SimpleDateFormat("HH:mm:ss:SSS", Locale.getDefault());
                this.f42951b = new a();
            }
        }
    }

    public final void m(String str) {
        if (j) {
            Log.d("ApiCalledMarker", str);
        }
    }

    public final void n() {
        if (this.f42953d.size() > 0) {
            synchronized (this.f42954e) {
                this.f42953d.clear();
            }
        }
        this.f42956g = false;
        this.f42958i = 0L;
        this.f42957h = 0L;
        this.f42955f = null;
        o("===== loading... =====");
    }

    public final void o(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        d.a.h0.a.f2.d.j.d(str);
    }
}
