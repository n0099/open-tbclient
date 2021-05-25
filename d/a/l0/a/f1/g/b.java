package d.a.l0.a.f1.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.l0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f41859e = k.f43199a;

    /* renamed from: a  reason: collision with root package name */
    public String f41860a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.l0.a.v2.e1.b<b> f41861b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0635b> f41862c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f41863d = b.class.getPackage().getName();

    /* renamed from: d.a.l0.a.f1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0635b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f41864a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f41865b;

        /* renamed from: c  reason: collision with root package name */
        public String f41866c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f41867d;

        public synchronized C0635b a(String str) {
            List<String> list = this.f41864a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public C0635b b(String str) {
            this.f41866c = str;
            return this;
        }

        public synchronized C0635b c() {
            d(this.f41867d.size());
            return this;
        }

        public synchronized C0635b d(int i2) {
            if (i2 < 1) {
                i2 = 1;
            }
            if (i2 > this.f41867d.size()) {
                i2 = this.f41867d.size();
            }
            for (int i3 = 0; i3 < i2; i3++) {
                b bVar = b.this;
                bVar.e("[Trace]==> " + this.f41867d.get(i3).toString());
            }
            return this;
        }

        public synchronized C0635b e() {
            d(1);
            return this;
        }

        public C0635b() {
            StackTraceElement[] stackTrace;
            this.f41864a = new ArrayList();
            this.f41865b = new ArrayList();
            this.f41867d = new ArrayList();
            int i2 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i2++;
                if (i2 > 2 && !stackTraceElement.getClassName().startsWith(b.this.f41863d)) {
                    this.f41867d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.l0.a.v2.e1.b<b> {
        public c(b bVar) {
        }

        public final void a(String str, String str2) {
            if (b.f41859e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.l0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (b.f41859e) {
                for (C0635b c0635b : bVar.f41862c) {
                    for (String str : c0635b.f41864a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0635b.f41866c) ? h2 : c0635b.f41866c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }
    }

    public synchronized C0635b d() {
        C0635b c0635b;
        c0635b = new C0635b();
        this.f41862c.add(c0635b);
        return c0635b;
    }

    public synchronized C0635b e(String str) {
        C0635b d2;
        d2 = d();
        d2.a(str);
        return d2;
    }

    public synchronized C0635b f(String str, String str2) {
        C0635b e2;
        e2 = e(str2);
        e2.b(str);
        return e2;
    }

    public b g(String str) {
        this.f41860a = str;
        return this;
    }

    public String h() {
        return this.f41860a;
    }

    public synchronized List<C0635b> i() {
        return new ArrayList(this.f41862c);
    }

    public synchronized b j() {
        k(this.f41861b);
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
        this.f41861b = bVar;
        return this;
    }
}
