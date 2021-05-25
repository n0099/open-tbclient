package d.a.q.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import d.a.q.g.d.a;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static Comparator<a> f64090e = new C1781a();

    /* renamed from: a  reason: collision with root package name */
    public b f64091a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1788a f64092b;

    /* renamed from: c  reason: collision with root package name */
    public final String f64093c;

    /* renamed from: d  reason: collision with root package name */
    public long f64094d;

    /* renamed from: d.a.q.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1781a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            int i2 = ((aVar.d() - aVar2.d()) > 0L ? 1 : ((aVar.d() - aVar2.d()) == 0L ? 0 : -1));
            return i2 != 0 ? i2 > 0 ? -1 : 1 : aVar.c().compareTo(aVar2.c());
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f64095a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q.g.d.a f64096b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.h.b f64097c;
    }

    /* loaded from: classes2.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C1788a f64098a;

        /* renamed from: b  reason: collision with root package name */
        public String f64099b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64100c = true;

        public c(a.C1788a c1788a, String str) {
            this.f64098a = c1788a;
            this.f64099b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void a(boolean z) {
            this.f64100c = z;
        }

        public boolean b() {
            if (this.f64100c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    e(jSONObject);
                    this.f64098a.i(this.f64099b, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void c(JSONObject jSONObject);

        public boolean d() {
            String g2 = this.f64098a.g(this.f64099b, true);
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
        public f(int i2, int i3, Exception exc) {
        }

        public static f a() {
            return b(0);
        }

        public static f b(int i2) {
            return new f(-1, i2, null);
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
        public boolean f64101a;
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public String f64102a;

        /* renamed from: b  reason: collision with root package name */
        public int f64103b;

        public h(int i2, String str, Exception exc) {
            this.f64103b = i2;
            this.f64102a = str;
        }

        public static h a(int i2) {
            return new h(i2, null, null);
        }

        public static h b(int i2, Exception exc) {
            return new h(i2, null, exc);
        }

        public static h c(Exception exc) {
            return new h(-1, null, exc);
        }

        public static h e(String str) {
            return new h(0, str, null);
        }

        public boolean d() {
            return this.f64103b == 0;
        }
    }

    public a(String str, long j) {
        this.f64093c = str;
        this.f64094d = j;
    }

    public final void a(b bVar) {
        this.f64091a = bVar;
        this.f64092b = bVar.f64096b.d().f("cs");
    }

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f64093c;
    }

    public long d() {
        return this.f64094d;
    }

    public abstract void e(d dVar);

    public abstract f f(e eVar);

    public void g(long j) {
        this.f64094d = j;
    }
}
