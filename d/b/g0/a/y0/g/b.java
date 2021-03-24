package d.b.g0.a.y0.g;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47113e = k.f45050a;

    /* renamed from: a  reason: collision with root package name */
    public String f47114a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<b> f47115b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0885b> f47116c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f47117d = b.class.getPackage().getName();

    /* renamed from: d.b.g0.a.y0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0885b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f47118a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f47119b;

        /* renamed from: c  reason: collision with root package name */
        public String f47120c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f47121d;

        public synchronized C0885b a(String str) {
            List<String> list = this.f47118a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public C0885b b(String str) {
            this.f47120c = str;
            return this;
        }

        public synchronized C0885b c() {
            d(this.f47121d.size());
            return this;
        }

        public synchronized C0885b d(int i) {
            if (i < 1) {
                i = 1;
            }
            if (i > this.f47121d.size()) {
                i = this.f47121d.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                b bVar = b.this;
                bVar.e("[Trace]==> " + this.f47121d.get(i2).toString());
            }
            return this;
        }

        public synchronized C0885b e() {
            d(1);
            return this;
        }

        public C0885b() {
            StackTraceElement[] stackTrace;
            this.f47118a = new ArrayList();
            this.f47119b = new ArrayList();
            this.f47121d = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(b.this.f47117d)) {
                    this.f47121d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.b.g0.a.i2.u0.b<b> {
        public c(b bVar) {
        }

        public final void a(String str, String str2) {
            if (b.f47113e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (b.f47113e) {
                for (C0885b c0885b : bVar.f47116c) {
                    for (String str : c0885b.f47118a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0885b.f47120c) ? h2 : c0885b.f47120c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }
    }

    public synchronized C0885b d() {
        C0885b c0885b;
        c0885b = new C0885b();
        this.f47116c.add(c0885b);
        return c0885b;
    }

    public synchronized C0885b e(String str) {
        C0885b d2;
        d2 = d();
        d2.a(str);
        return d2;
    }

    public synchronized C0885b f(String str, String str2) {
        C0885b e2;
        e2 = e(str2);
        e2.b(str);
        return e2;
    }

    public b g(String str) {
        this.f47114a = str;
        return this;
    }

    public String h() {
        return this.f47114a;
    }

    public synchronized List<C0885b> i() {
        return new ArrayList(this.f47116c);
    }

    public synchronized b j() {
        k(this.f47115b);
        return this;
    }

    public synchronized b k(d.b.g0.a.i2.u0.b<b> bVar) {
        if (bVar == null) {
            try {
                bVar = new c();
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.onCallback(this);
        return this;
    }

    public b l(d.b.g0.a.i2.u0.b<b> bVar) {
        this.f47115b = bVar;
        return this;
    }
}
