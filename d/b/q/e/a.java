package d.b.q.e;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import d.b.q.g.d.a;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static Comparator<a> f64301e = new C1745a();

    /* renamed from: a  reason: collision with root package name */
    public b f64302a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1752a f64303b;

    /* renamed from: c  reason: collision with root package name */
    public final String f64304c;

    /* renamed from: d  reason: collision with root package name */
    public long f64305d;

    /* renamed from: d.b.q.e.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1745a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long d2 = aVar.d() - aVar2.d();
            return d2 != 0 ? d2 > 0 ? -1 : 1 : aVar.c().compareTo(aVar2.c());
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f64306a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.q.g.d.a f64307b;

        /* renamed from: c  reason: collision with root package name */
        public d.b.q.h.b f64308c;
    }

    /* loaded from: classes2.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C1752a f64309a;

        /* renamed from: b  reason: collision with root package name */
        public String f64310b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f64311c = true;

        public c(a.C1752a c1752a, String str) {
            this.f64309a = c1752a;
            this.f64310b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public void a(boolean z) {
            this.f64311c = z;
        }

        public boolean b() {
            if (this.f64311c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    e(jSONObject);
                    this.f64309a.i(this.f64310b, jSONObject.toString(), true);
                    a(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }

        public abstract void c(JSONObject jSONObject);

        public boolean d() {
            String g2 = this.f64309a.g(this.f64310b, true);
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
        public boolean f64312a;
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public String f64313a;

        /* renamed from: b  reason: collision with root package name */
        public int f64314b;

        public h(int i, String str, Exception exc) {
            this.f64314b = i;
            this.f64313a = str;
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
            return this.f64314b == 0;
        }
    }

    public a(String str, long j) {
        this.f64304c = str;
        this.f64305d = j;
    }

    public final void a(b bVar) {
        this.f64302a = bVar;
        this.f64303b = bVar.f64307b.d().f(IXAdRequestInfo.CS);
    }

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f64304c;
    }

    public long d() {
        return this.f64305d;
    }

    public abstract void e(d dVar);

    public abstract f f(e eVar);

    public void g(long j) {
        this.f64305d = j;
    }
}
