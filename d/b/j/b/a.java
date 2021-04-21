package d.b.j.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import d.b.j.g.a;
import d.b.j.l;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static Comparator<a> f52538e = new C1151a();

    /* renamed from: a  reason: collision with root package name */
    public b f52539a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1154a f52540b;

    /* renamed from: c  reason: collision with root package name */
    public final String f52541c;

    /* renamed from: d  reason: collision with root package name */
    public long f52542d;

    /* renamed from: d.b.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C1151a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int i = ((aVar.f() - aVar2.f()) > 0L ? 1 : ((aVar.f() - aVar2.f()) == 0L ? 0 : -1));
            return i != 0 ? i > 0 ? -1 : 1 : aVar.c().compareTo(aVar2.c());
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f52543a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.j.g.a f52544b;
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C1154a f52545a;

        /* renamed from: b  reason: collision with root package name */
        public String f52546b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f52547c = true;

        public c(a.C1154a c1154a, String str) {
            this.f52545a = c1154a;
            this.f52546b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void b(boolean z) {
            this.f52547c = z;
        }

        public boolean c() {
            String c2 = this.f52545a.c(this.f52546b, true);
            if (!TextUtils.isEmpty(c2)) {
                try {
                    a(new JSONObject(c2));
                    b(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void d(JSONObject jSONObject);

        public boolean e() {
            if (this.f52547c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    d(jSONObject);
                    this.f52545a.e(this.f52546b, jSONObject.toString(), true);
                    b(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
    }

    /* loaded from: classes.dex */
    public static class d {
    }

    /* loaded from: classes.dex */
    public static class e {
    }

    /* loaded from: classes.dex */
    public static class f {
        public f(int i, int i2, Exception exc) {
        }

        public static f a(int i) {
            return new f(-1, i, null);
        }

        public static f b() {
            return new f(0, 0, null);
        }

        public static f c() {
            return a(0);
        }
    }

    /* loaded from: classes.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public boolean f52548a;
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public l.a f52549a;

        /* renamed from: b  reason: collision with root package name */
        public int f52550b;

        public h(int i, l.a aVar, Exception exc) {
            this.f52550b = i;
            this.f52549a = aVar;
        }

        public static h a(int i) {
            return new h(i, null, null);
        }

        public static h b(l.a aVar) {
            return new h(0, aVar, null);
        }

        public static h d() {
            return new h(-1, null, null);
        }

        public boolean c() {
            return this.f52550b == 0;
        }
    }

    public a(String str, long j) {
        this.f52541c = str;
        this.f52542d = j;
    }

    public abstract f a(e eVar, l.a aVar);

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f52541c;
    }

    public final void d(b bVar) {
        this.f52539a = bVar;
        this.f52540b = bVar.f52544b.e().b("cs");
    }

    public abstract void e(d dVar);

    public long f() {
        return this.f52542d;
    }
}
