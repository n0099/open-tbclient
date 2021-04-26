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
    public static Comparator<a> f63577e = new C1715a();

    /* renamed from: a  reason: collision with root package name */
    public b f63578a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1722a f63579b;

    /* renamed from: c  reason: collision with root package name */
    public final String f63580c;

    /* renamed from: d  reason: collision with root package name */
    public long f63581d;

    /* renamed from: d.a.q.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1715a implements Comparator<a> {
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
        public Context f63582a;

        /* renamed from: b  reason: collision with root package name */
        public d.a.q.g.d.a f63583b;

        /* renamed from: c  reason: collision with root package name */
        public d.a.q.h.b f63584c;
    }

    /* loaded from: classes2.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C1722a f63585a;

        /* renamed from: b  reason: collision with root package name */
        public String f63586b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f63587c = true;

        public c(a.C1722a c1722a, String str) {
            this.f63585a = c1722a;
            this.f63586b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void a(boolean z) {
            this.f63587c = z;
        }

        public boolean b() {
            if (this.f63587c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    e(jSONObject);
                    this.f63585a.i(this.f63586b, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void c(JSONObject jSONObject);

        public boolean d() {
            String g2 = this.f63585a.g(this.f63586b, true);
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
        public boolean f63588a;
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public String f63589a;

        /* renamed from: b  reason: collision with root package name */
        public int f63590b;

        public h(int i2, String str, Exception exc) {
            this.f63590b = i2;
            this.f63589a = str;
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
            return this.f63590b == 0;
        }
    }

    public a(String str, long j) {
        this.f63580c = str;
        this.f63581d = j;
    }

    public final void a(b bVar) {
        this.f63578a = bVar;
        this.f63579b = bVar.f63583b.d().f("cs");
    }

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f63580c;
    }

    public long d() {
        return this.f63581d;
    }

    public abstract void e(d dVar);

    public abstract f f(e eVar);

    public void g(long j) {
        this.f63581d = j;
    }
}
