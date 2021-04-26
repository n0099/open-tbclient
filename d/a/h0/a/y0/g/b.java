package d.a.h0.a.y0.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.h0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45270e = k.f43101a;

    /* renamed from: a  reason: collision with root package name */
    public String f45271a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.h0.a.i2.u0.b<b> f45272b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0857b> f45273c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f45274d = b.class.getPackage().getName();

    /* renamed from: d.a.h0.a.y0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0857b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f45275a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f45276b;

        /* renamed from: c  reason: collision with root package name */
        public String f45277c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f45278d;

        public synchronized C0857b a(String str) {
            List<String> list = this.f45275a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public C0857b b(String str) {
            this.f45277c = str;
            return this;
        }

        public synchronized C0857b c() {
            d(this.f45278d.size());
            return this;
        }

        public synchronized C0857b d(int i2) {
            if (i2 < 1) {
                i2 = 1;
            }
            if (i2 > this.f45278d.size()) {
                i2 = this.f45278d.size();
            }
            for (int i3 = 0; i3 < i2; i3++) {
                b bVar = b.this;
                bVar.e("[Trace]==> " + this.f45278d.get(i3).toString());
            }
            return this;
        }

        public synchronized C0857b e() {
            d(1);
            return this;
        }

        public C0857b() {
            StackTraceElement[] stackTrace;
            this.f45275a = new ArrayList();
            this.f45276b = new ArrayList();
            this.f45278d = new ArrayList();
            int i2 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i2++;
                if (i2 > 2 && !stackTraceElement.getClassName().startsWith(b.this.f45274d)) {
                    this.f45278d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.a.h0.a.i2.u0.b<b> {
        public c(b bVar) {
        }

        public final void a(String str, String str2) {
            if (b.f45270e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.h0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (b.f45270e) {
                for (C0857b c0857b : bVar.f45273c) {
                    for (String str : c0857b.f45275a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0857b.f45277c) ? h2 : c0857b.f45277c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }
    }

    public synchronized C0857b d() {
        C0857b c0857b;
        c0857b = new C0857b();
        this.f45273c.add(c0857b);
        return c0857b;
    }

    public synchronized C0857b e(String str) {
        C0857b d2;
        d2 = d();
        d2.a(str);
        return d2;
    }

    public synchronized C0857b f(String str, String str2) {
        C0857b e2;
        e2 = e(str2);
        e2.b(str);
        return e2;
    }

    public b g(String str) {
        this.f45271a = str;
        return this;
    }

    public String h() {
        return this.f45271a;
    }

    public synchronized List<C0857b> i() {
        return new ArrayList(this.f45273c);
    }

    public synchronized b j() {
        k(this.f45272b);
        return this;
    }

    public synchronized b k(d.a.h0.a.i2.u0.b<b> bVar) {
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

    public b l(d.a.h0.a.i2.u0.b<b> bVar) {
        this.f45272b = bVar;
        return this;
    }
}
