package d.b.g0.a.y0.g;

import android.text.TextUtils;
import android.util.Log;
import d.b.g0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47114e = k.f45051a;

    /* renamed from: a  reason: collision with root package name */
    public String f47115a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.g0.a.i2.u0.b<b> f47116b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0886b> f47117c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f47118d = b.class.getPackage().getName();

    /* renamed from: d.b.g0.a.y0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0886b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f47119a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f47120b;

        /* renamed from: c  reason: collision with root package name */
        public String f47121c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f47122d;

        public synchronized C0886b a(String str) {
            List<String> list = this.f47119a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public C0886b b(String str) {
            this.f47121c = str;
            return this;
        }

        public synchronized C0886b c() {
            d(this.f47122d.size());
            return this;
        }

        public synchronized C0886b d(int i) {
            if (i < 1) {
                i = 1;
            }
            if (i > this.f47122d.size()) {
                i = this.f47122d.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                b bVar = b.this;
                bVar.e("[Trace]==> " + this.f47122d.get(i2).toString());
            }
            return this;
        }

        public synchronized C0886b e() {
            d(1);
            return this;
        }

        public C0886b() {
            StackTraceElement[] stackTrace;
            this.f47119a = new ArrayList();
            this.f47120b = new ArrayList();
            this.f47122d = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(b.this.f47118d)) {
                    this.f47122d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.g0.a.i2.u0.b<b> {
        public c(b bVar) {
        }

        public final void a(String str, String str2) {
            if (b.f47114e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.g0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (b.f47114e) {
                for (C0886b c0886b : bVar.f47117c) {
                    for (String str : c0886b.f47119a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0886b.f47121c) ? h2 : c0886b.f47121c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }
    }

    public synchronized C0886b d() {
        C0886b c0886b;
        c0886b = new C0886b();
        this.f47117c.add(c0886b);
        return c0886b;
    }

    public synchronized C0886b e(String str) {
        C0886b d2;
        d2 = d();
        d2.a(str);
        return d2;
    }

    public synchronized C0886b f(String str, String str2) {
        C0886b e2;
        e2 = e(str2);
        e2.b(str);
        return e2;
    }

    public b g(String str) {
        this.f47115a = str;
        return this;
    }

    public String h() {
        return this.f47115a;
    }

    public synchronized List<C0886b> i() {
        return new ArrayList(this.f47117c);
    }

    public synchronized b j() {
        k(this.f47116b);
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
        this.f47116b = bVar;
        return this;
    }
}
