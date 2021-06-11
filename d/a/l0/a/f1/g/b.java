package d.a.l0.a.f1.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45535e = k.f46875a;

    /* renamed from: a  reason: collision with root package name */
    public String f45536a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.v2.e1.b<b> f45537b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0691b> f45538c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f45539d = b.class.getPackage().getName();

    /* renamed from: d.a.l0.a.f1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0691b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f45540a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f45541b;

        /* renamed from: c  reason: collision with root package name */
        public String f45542c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f45543d;

        public synchronized C0691b a(String str) {
            List<String> list = this.f45540a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public C0691b b(String str) {
            this.f45542c = str;
            return this;
        }

        public synchronized C0691b c() {
            d(this.f45543d.size());
            return this;
        }

        public synchronized C0691b d(int i2) {
            if (i2 < 1) {
                i2 = 1;
            }
            if (i2 > this.f45543d.size()) {
                i2 = this.f45543d.size();
            }
            for (int i3 = 0; i3 < i2; i3++) {
                b bVar = b.this;
                bVar.e("[Trace]==> " + this.f45543d.get(i3).toString());
            }
            return this;
        }

        public synchronized C0691b e() {
            d(1);
            return this;
        }

        public C0691b() {
            StackTraceElement[] stackTrace;
            this.f45540a = new ArrayList();
            this.f45541b = new ArrayList();
            this.f45543d = new ArrayList();
            int i2 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i2++;
                if (i2 > 2 && !stackTraceElement.getClassName().startsWith(b.this.f45539d)) {
                    this.f45543d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.v2.e1.b<b> {
        public c(b bVar) {
        }

        public final void a(String str, String str2) {
            if (b.f45535e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (b.f45535e) {
                for (C0691b c0691b : bVar.f45538c) {
                    for (String str : c0691b.f45540a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0691b.f45542c) ? h2 : c0691b.f45542c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }
    }

    public synchronized C0691b d() {
        C0691b c0691b;
        c0691b = new C0691b();
        this.f45538c.add(c0691b);
        return c0691b;
    }

    public synchronized C0691b e(String str) {
        C0691b d2;
        d2 = d();
        d2.a(str);
        return d2;
    }

    public synchronized C0691b f(String str, String str2) {
        C0691b e2;
        e2 = e(str2);
        e2.b(str);
        return e2;
    }

    public b g(String str) {
        this.f45536a = str;
        return this;
    }

    public String h() {
        return this.f45536a;
    }

    public synchronized List<C0691b> i() {
        return new ArrayList(this.f45538c);
    }

    public synchronized b j() {
        k(this.f45537b);
        return this;
    }

    public synchronized b k(d.a.l0.a.v2.e1.b<b> bVar) {
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

    public b l(d.a.l0.a.v2.e1.b<b> bVar) {
        this.f45537b = bVar;
        return this;
    }
}
