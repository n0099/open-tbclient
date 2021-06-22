package d.a.m0.a.f1.g;

import android.text.TextUtils;
import android.util.Log;
import d.a.m0.a.k;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes3.dex */
public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final boolean f45643e = k.f46983a;

    /* renamed from: a  reason: collision with root package name */
    public String f45644a;

    /* renamed from: b  reason: collision with root package name */
    public d.a.m0.a.v2.e1.b<b> f45645b;

    /* renamed from: c  reason: collision with root package name */
    public final List<C0694b> f45646c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public String f45647d = b.class.getPackage().getName();

    /* renamed from: d.a.m0.a.f1.g.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C0694b {

        /* renamed from: a  reason: collision with root package name */
        public final List<String> f45648a;

        /* renamed from: b  reason: collision with root package name */
        public final List<String> f45649b;

        /* renamed from: c  reason: collision with root package name */
        public String f45650c;

        /* renamed from: d  reason: collision with root package name */
        public final List<StackTraceElement> f45651d;

        public synchronized C0694b a(String str) {
            List<String> list = this.f45648a;
            if (TextUtils.isEmpty(str)) {
                str = "";
            }
            list.add(str);
            return this;
        }

        public C0694b b(String str) {
            this.f45650c = str;
            return this;
        }

        public synchronized C0694b c() {
            d(this.f45651d.size());
            return this;
        }

        public synchronized C0694b d(int i2) {
            if (i2 < 1) {
                i2 = 1;
            }
            if (i2 > this.f45651d.size()) {
                i2 = this.f45651d.size();
            }
            for (int i3 = 0; i3 < i2; i3++) {
                b bVar = b.this;
                bVar.e("[Trace]==> " + this.f45651d.get(i3).toString());
            }
            return this;
        }

        public synchronized C0694b e() {
            d(1);
            return this;
        }

        public C0694b() {
            StackTraceElement[] stackTrace;
            this.f45648a = new ArrayList();
            this.f45649b = new ArrayList();
            this.f45651d = new ArrayList();
            int i2 = 0;
            for (StackTraceElement stackTraceElement : Thread.currentThread().getStackTrace()) {
                i2++;
                if (i2 > 2 && !stackTraceElement.getClassName().startsWith(b.this.f45647d)) {
                    this.f45651d.add(stackTraceElement);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c implements d.a.m0.a.v2.e1.b<b> {
        public c(b bVar) {
        }

        public final void a(String str, String str2) {
            if (b.f45643e) {
                Log.i(str, str2);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // d.a.m0.a.v2.e1.b
        /* renamed from: b */
        public void onCallback(b bVar) {
            if (b.f45643e) {
                for (C0694b c0694b : bVar.f45646c) {
                    for (String str : c0694b.f45648a) {
                        String h2 = bVar.h();
                        String str2 = TextUtils.isEmpty(c0694b.f45650c) ? h2 : c0694b.f45650c;
                        a(str2, h2 + " >>> " + str);
                    }
                }
            }
        }
    }

    public synchronized C0694b d() {
        C0694b c0694b;
        c0694b = new C0694b();
        this.f45646c.add(c0694b);
        return c0694b;
    }

    public synchronized C0694b e(String str) {
        C0694b d2;
        d2 = d();
        d2.a(str);
        return d2;
    }

    public synchronized C0694b f(String str, String str2) {
        C0694b e2;
        e2 = e(str2);
        e2.b(str);
        return e2;
    }

    public b g(String str) {
        this.f45644a = str;
        return this;
    }

    public String h() {
        return this.f45644a;
    }

    public synchronized List<C0694b> i() {
        return new ArrayList(this.f45646c);
    }

    public synchronized b j() {
        k(this.f45645b);
        return this;
    }

    public synchronized b k(d.a.m0.a.v2.e1.b<b> bVar) {
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

    public b l(d.a.m0.a.v2.e1.b<b> bVar) {
        this.f45645b = bVar;
        return this;
    }
}
