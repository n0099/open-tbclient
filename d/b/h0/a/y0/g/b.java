package d.b.h0.a.y0.g;

import android.text.TextUtils;
import android.util.Log;
import d.b.h0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes2.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f47835e = k.f45772a;

    /* renamed from: a  reason: collision with root package name */
    public String f47836a;

    /* renamed from: b  reason: collision with root package name */
    public d.b.h0.a.i2.u0.b<b> f47837b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0918b> f47838c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f47839d = b.class.getPackage().getName();

    /* renamed from: d.b.h0.a.y0.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public class C0918b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f47840a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f47841b;

        /* renamed from: c  reason: collision with root package name */
        public String f47842c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f47843d;

        public synchronized C0918b a(String str) {
            List<String> list = this.f47840a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public C0918b b(String str) {
            this.f47842c = str;
            return this;
        }

        public synchronized C0918b c() {
            d(this.f47843d.size());
            return this;
        }

        public synchronized C0918b d(int i) {
            if (i < 1) {
                i = 1;
            }
            if (i > this.f47843d.size()) {
                i = this.f47843d.size();
            }
            for (int i2 = 0; i2 < i; i2++) {
                b bVar = b.this;
                bVar.e("[Trace]==> " + this.f47843d.get(i2).toString());
            }
            return this;
        }

        public synchronized C0918b e() {
            d(1);
            return this;
        }

        public C0918b() {
            StackTraceElement[] stackTrace;
            this.f47840a = new ArrayList();
            this.f47841b = new ArrayList();
            this.f47843d = new ArrayList();
            int i = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i++;
                if (i > 2 && !stackTraceElement.getClassName().startsWith(b.this.f47839d)) {
                    this.f47843d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes2.dex */
    public class c implements d.b.h0.a.i2.u0.b<b> {
        public c(b bVar) {
        }

        public final void a(String str, String str2) {
            if (b.f47835e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.b.h0.a.i2.u0.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (b.f47835e) {
                for (C0918b c0918b : bVar.f47838c) {
                    for (String str : c0918b.f47840a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0918b.f47842c) ? h2 : c0918b.f47842c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }
    }

    public synchronized C0918b d() {
        C0918b c0918b;
        c0918b = new C0918b();
        this.f47838c.add(c0918b);
        return c0918b;
    }

    public synchronized C0918b e(String str) {
        C0918b d2;
        d2 = d();
        d2.a(str);
        return d2;
    }

    public synchronized C0918b f(String str, String str2) {
        C0918b e2;
        e2 = e(str2);
        e2.b(str);
        return e2;
    }

    public b g(String str) {
        this.f47836a = str;
        return this;
    }

    public String h() {
        return this.f47836a;
    }

    public synchronized List<C0918b> i() {
        return new ArrayList(this.f47838c);
    }

    public synchronized b j() {
        k(this.f47837b);
        return this;
    }

    public synchronized b k(d.b.h0.a.i2.u0.b<b> bVar) {
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

    public b l(d.b.h0.a.i2.u0.b<b> bVar) {
        this.f47837b = bVar;
        return this;
    }
}
