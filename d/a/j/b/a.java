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
    public static Comparator<a> f48441e = new C1084a();

    /* renamed from: a  reason: collision with root package name */
    public b f48442a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1087a f48443b;

    /* renamed from: c  reason: collision with root package name */
    public final String f48444c;

    /* renamed from: d  reason: collision with root package name */
    public long f48445d;

    /* renamed from: d.a.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C1084a implements Comparator<a> {
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
        public Context f48446a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.j.g.a f48447b;
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C1087a f48448a;

        /* renamed from: b  reason: collision with root package name */
        public String f48449b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f48450c = true;

        public c(a.C1087a c1087a, String str) {
            this.f48448a = c1087a;
            this.f48449b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void b(boolean z) {
            this.f48450c = z;
        }

        public boolean c() {
            String c2 = this.f48448a.c(this.f48449b, true);
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
            if (this.f48450c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    d(jSONObject);
                    this.f48448a.e(this.f48449b, jSONObject.toString(), true);
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
        public boolean f48451a;
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public l.a f48452a;

        /* renamed from: b  reason: collision with root package name */
        public int f48453b;

        public h(int i2, l.a aVar, Exception exc) {
            this.f48453b = i2;
            this.f48452a = aVar;
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
            return this.f48453b == 0;
        }
    }

    public a(String str, long j) {
        this.f48444c = str;
        this.f48445d = j;
    }

    public abstract f a(e eVar, l.a aVar);

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f48444c;
    }

    public final void d(b bVar) {
        this.f48442a = bVar;
        this.f48443b = bVar.f48447b.e().b("cs");
    }

    public abstract void e(d dVar);

    public long f() {
        return this.f48445d;
    }
}
