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
    public static Comparator<a> f50220e = new C1090a();

    /* renamed from: a  reason: collision with root package name */
    public b f50221a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1093a f50222b;

    /* renamed from: c  reason: collision with root package name */
    public final String f50223c;

    /* renamed from: d  reason: collision with root package name */
    public long f50224d;

    /* renamed from: d.a.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static class C1090a implements Comparator<a> {
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
        public Context f50225a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.j.g.a f50226b;
    }

    /* loaded from: classes.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C1093a f50227a;

        /* renamed from: b  reason: collision with root package name */
        public String f50228b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f50229c = true;

        public c(a.C1093a c1093a, String str) {
            this.f50227a = c1093a;
            this.f50228b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void b(boolean z) {
            this.f50229c = z;
        }

        public boolean c() {
            String c2 = this.f50227a.c(this.f50228b, true);
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
            if (this.f50229c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    d(jSONObject);
                    this.f50227a.e(this.f50228b, jSONObject.toString(), true);
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
        public boolean f50230a;
    }

    /* loaded from: classes.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public l.a f50231a;

        /* renamed from: b  reason: collision with root package name */
        public int f50232b;

        public h(int i2, l.a aVar, Exception exc) {
            this.f50232b = i2;
            this.f50231a = aVar;
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
            return this.f50232b == 0;
        }
    }

    public a(String str, long j) {
        this.f50223c = str;
        this.f50224d = j;
    }

    public abstract f a(e eVar, l.a aVar);

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f50223c;
    }

    public final void d(b bVar) {
        this.f50221a = bVar;
        this.f50222b = bVar.f50226b.e().b("cs");
    }

    public abstract void e(d dVar);

    public long f() {
        return this.f50224d;
    }
}
