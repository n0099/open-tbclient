package d.b.p.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import d.b.p.g.d.a;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static Comparator<a> f64996e = new C1758a();

    /* renamed from: a  reason: collision with root package name */
    public b f64997a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1765a f64998b;

    /* renamed from: c  reason: collision with root package name */
    public final String f64999c;

    /* renamed from: d  reason: collision with root package name */
    public long f65000d;

    /* renamed from: d.b.p.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1758a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int i = ((aVar.d() - aVar2.d()) > 0L ? 1 : ((aVar.d() - aVar2.d()) == 0L ? 0 : -1));
            return i != 0 ? i > 0 ? -1 : 1 : aVar.c().compareTo(aVar2.c());
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f65001a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.p.g.d.a f65002b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.p.h.b f65003c;
    }

    /* loaded from: classes2.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C1765a f65004a;

        /* renamed from: b  reason: collision with root package name */
        public String f65005b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65006c = true;

        public c(a.C1765a c1765a, String str) {
            this.f65004a = c1765a;
            this.f65005b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void a(boolean z) {
            this.f65006c = z;
        }

        public boolean b() {
            if (this.f65006c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    e(jSONObject);
                    this.f65004a.i(this.f65005b, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void c(JSONObject jSONObject);

        public boolean d() {
            String g2 = this.f65004a.g(this.f65005b, true);
            if (!TextUtils.isEmpty(g2)) {
                try {
                    c(new JSONObject(g2));
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void e(JSONObject jSONObject);
    }

    /* loaded from: classes2.dex */
    public static class d {
    }

    /* loaded from: classes2.dex */
    public static class e {
    }

    /* loaded from: classes2.dex */
    public static class f {
        public f(int i, int i2, Exception exc) {
        }

        public static f a() {
            return b(0);
        }

        public static f b(int i) {
            return new f(-1, i, null);
        }

        public static f c(Exception exc) {
            return new f(-1, 0, exc);
        }

        public static f d() {
            return new f(0, 0, null);
        }
    }

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public boolean f65007a;
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public String f65008a;

        /* renamed from: b  reason: collision with root package name */
        public int f65009b;

        public h(int i, String str, Exception exc) {
            this.f65009b = i;
            this.f65008a = str;
        }

        public static h a(int i) {
            return new h(i, null, null);
        }

        public static h b(int i, Exception exc) {
            return new h(i, null, exc);
        }

        public static h c(Exception exc) {
            return new h(-1, null, exc);
        }

        public static h e(String str) {
            return new h(0, str, null);
        }

        public boolean d() {
            return this.f65009b == 0;
        }
    }

    public a(String str, long j) {
        this.f64999c = str;
        this.f65000d = j;
    }

    public final void a(b bVar) {
        this.f64997a = bVar;
        this.f64998b = bVar.f65002b.d().f("cs");
    }

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f64999c;
    }

    public long d() {
        return this.f65000d;
    }

    public abstract void e(d dVar);

    public abstract f f(e eVar);

    public void g(long j) {
        this.f65000d = j;
    }
}
