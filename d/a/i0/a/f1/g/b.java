package d.a.i0.a.f1.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.i0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f41685e = k.f43025a;

    /* renamed from: a  reason: collision with root package name */
    public String f41686a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.i0.a.v2.e1.b<b> f41687b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0624b> f41688c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f41689d = b.class.getPackage().getName();

    /* renamed from: d.a.i0.a.f1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0624b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f41690a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f41691b;

        /* renamed from: c  reason: collision with root package name */
        public String f41692c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f41693d;

        public synchronized C0624b a(String str) {
            List<String> list = this.f41690a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public C0624b b(String str) {
            this.f41692c = str;
            return this;
        }

        public synchronized C0624b c() {
            d(this.f41693d.size());
            return this;
        }

        public synchronized C0624b d(int i2) {
            if (i2 < 1) {
                i2 = 1;
            }
            if (i2 > this.f41693d.size()) {
                i2 = this.f41693d.size();
            }
            for (int i3 = 0; i3 < i2; i3++) {
                b bVar = b.this;
                bVar.e("[Trace]==> " + this.f41693d.get(i3).toString());
            }
            return this;
        }

        public synchronized C0624b e() {
            d(1);
            return this;
        }

        public C0624b() {
            StackTraceElement[] stackTrace;
            this.f41690a = new ArrayList();
            this.f41691b = new ArrayList();
            this.f41693d = new ArrayList();
            int i2 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i2++;
                if (i2 > 2 && !stackTraceElement.getClassName().startsWith(b.this.f41689d)) {
                    this.f41693d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.i0.a.v2.e1.b<b> {
        public c(b bVar) {
        }

        public final void a(String str, String str2) {
            if (b.f41685e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.i0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (b.f41685e) {
                for (C0624b c0624b : bVar.f41688c) {
                    for (String str : c0624b.f41690a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0624b.f41692c) ? h2 : c0624b.f41692c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }
    }

    public synchronized C0624b d() {
        C0624b c0624b;
        c0624b = new C0624b();
        this.f41688c.add(c0624b);
        return c0624b;
    }

    public synchronized C0624b e(String str) {
        C0624b d2;
        d2 = d();
        d2.a(str);
        return d2;
    }

    public synchronized C0624b f(String str, String str2) {
        C0624b e2;
        e2 = e(str2);
        e2.b(str);
        return e2;
    }

    public b g(String str) {
        this.f41686a = str;
        return this;
    }

    public String h() {
        return this.f41686a;
    }

    public synchronized List<C0624b> i() {
        return new ArrayList(this.f41688c);
    }

    public synchronized b j() {
        k(this.f41687b);
        return this;
    }

    public synchronized b k(d.a.i0.a.v2.e1.b<b> bVar) {
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

    public b l(d.a.i0.a.v2.e1.b<b> bVar) {
        this.f41687b = bVar;
        return this;
    }
}
