package d.b.q.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import d.b.q.g.d.a;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static Comparator<a> f65260e = new C1777a();

    /* renamed from: a  reason: collision with root package name */
    public b f65261a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1784a f65262b;

    /* renamed from: c  reason: collision with root package name */
    public final String f65263c;

    /* renamed from: d  reason: collision with root package name */
    public long f65264d;

    /* renamed from: d.b.q.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1777a implements Comparator<a> {
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
        public Context f65265a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.q.g.d.a f65266b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.q.h.b f65267c;
    }

    /* loaded from: classes2.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C1784a f65268a;

        /* renamed from: b  reason: collision with root package name */
        public String f65269b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f65270c = true;

        public c(a.C1784a c1784a, String str) {
            this.f65268a = c1784a;
            this.f65269b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void a(boolean z) {
            this.f65270c = z;
        }

        public boolean b() {
            if (this.f65270c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    e(jSONObject);
                    this.f65268a.i(this.f65269b, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void c(JSONObject jSONObject);

        public boolean d() {
            String g2 = this.f65268a.g(this.f65269b, true);
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
        public boolean f65271a;
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public String f65272a;

        /* renamed from: b  reason: collision with root package name */
        public int f65273b;

        public h(int i, String str, Exception exc) {
            this.f65273b = i;
            this.f65272a = str;
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
            return this.f65273b == 0;
        }
    }

    public a(String str, long j) {
        this.f65263c = str;
        this.f65264d = j;
    }

    public final void a(b bVar) {
        this.f65261a = bVar;
        this.f65262b = bVar.f65266b.d().f("cs");
    }

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f65263c;
    }

    public long d() {
        return this.f65264d;
    }

    public abstract void e(d dVar);

    public abstract f f(e eVar);

    public void g(long j) {
        this.f65264d = j;
    }
}
