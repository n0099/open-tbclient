package d.a.j.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import d.a.j.g.a;
import d.a.j.l;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static Comparator<a> f40105e = new C0545a();

    /* renamed from: a  reason: collision with root package name */
    public b f40106a;

    /* renamed from: b  reason: collision with root package name */
    public a.C0548a f40107b;

    /* renamed from: c  reason: collision with root package name */
    public final String f40108c;

    /* renamed from: d  reason: collision with root package name */
    public long f40109d;

    /* renamed from: d.a.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C0545a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int i2 = ((aVar.f() - aVar2.f()) > 0L ? 1 : ((aVar.f() - aVar2.f()) == 0L ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : aVar.c().compareTo(aVar2.c());
        }
    }

    /* loaded from: classes.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f40110a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.j.g.a f40111b;
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C0548a f40112a;

        /* renamed from: b  reason: collision with root package name */
        public String f40113b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f40114c = true;

        public c(a.C0548a c0548a, String str) {
            this.f40112a = c0548a;
            this.f40113b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void b(boolean z) {
            this.f40114c = z;
        }

        public boolean c() {
            String c2 = this.f40112a.c(this.f40113b, true);
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
            if (this.f40114c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    d(jSONObject);
                    this.f40112a.e(this.f40113b, jSONObject.toString(), true);
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
        public f(int i2, int i3, Exception exc) {
        }

        public static f a(int i2) {
            return new f(-1, i2, null);
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
        public boolean f40115a;
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public l.a f40116a;

        /* renamed from: b  reason: collision with root package name */
        public int f40117b;

        public h(int i2, l.a aVar, Exception exc) {
            this.f40117b = i2;
            this.f40116a = aVar;
        }

        public static h a(int i2) {
            return new h(i2, null, null);
        }

        public static h b(l.a aVar) {
            return new h(0, aVar, null);
        }

        public static h d() {
            return new h(-1, null, null);
        }

        public boolean c() {
            return this.f40117b == 0;
        }
    }

    public a(String str, long j) {
        this.f40108c = str;
        this.f40109d = j;
    }

    public abstract f a(e eVar, l.a aVar);

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f40108c;
    }

    public final void d(b bVar) {
        this.f40106a = bVar;
        this.f40107b = bVar.f40111b.e().b("cs");
    }

    public abstract void e(d dVar);

    public long f() {
        return this.f40109d;
    }
}
