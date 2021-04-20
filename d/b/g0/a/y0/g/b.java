package d.b.g0.a.y0.g;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47506e = k.f45443a;

    /* renamed from: a  reason: collision with root package name */
    public String f47507a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<b> f47508b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0898b> f47509c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f47510d = b.class.getPackage().getName();

    /* renamed from: d.b.g0.a.y0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0898b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f47511a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f47512b;

        /* renamed from: c  reason: collision with root package name */
        public String f47513c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f47514d;

        public synchronized C0898b a(String str) {
            List<String> list = this.f47511a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public C0898b b(String str) {
            this.f47513c = str;
            return this;
        }

        public synchronized C0898b c() {
            d(this.f47514d.size());
            return this;
        }

        public synchronized C0898b d(int i) {
            if (i < 1) {
                i = 1;
            }
            if (i > this.f47514d.size()) {
                i = this.f47514d.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                b bVar = b.this;
                bVar.e("[Trace]==> " + this.f47514d.get(i2).toString());
            }
            return this;
        }

        public synchronized C0898b e() {
            d(1);
            return this;
        }

        public C0898b() {
            StackTraceElement[] stackTrace;
            this.f47511a = new ArrayList();
            this.f47512b = new ArrayList();
            this.f47514d = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(b.this.f47510d)) {
                    this.f47514d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.i2.u0.b<b> {
        public c(b bVar) {
        }

        public final void a(String str, String str2) {
            if (b.f47506e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (b.f47506e) {
                for (C0898b c0898b : bVar.f47509c) {
                    for (String str : c0898b.f47511a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0898b.f47513c) ? h2 : c0898b.f47513c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }
    }

    public synchronized C0898b d() {
        C0898b c0898b;
        c0898b = new C0898b();
        this.f47509c.add(c0898b);
        return c0898b;
    }

    public synchronized C0898b e(String str) {
        C0898b d2;
        d2 = d();
        d2.a(str);
        return d2;
    }

    public synchronized C0898b f(String str, String str2) {
        C0898b e2;
        e2 = e(str2);
        e2.b(str);
        return e2;
    }

    public b g(String str) {
        this.f47507a = str;
        return this;
    }

    public String h() {
        return this.f47507a;
    }

    public synchronized List<C0898b> i() {
        return new ArrayList(this.f47509c);
    }

    public synchronized b j() {
        k(this.f47508b);
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
        this.f47508b = bVar;
        return this;
    }
}
