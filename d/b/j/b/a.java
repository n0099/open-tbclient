package d.b.j.b;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.baidu.mobads.interfaces.IXAdRequestInfo;
import d.b.j.g.a;
import d.b.j.l;
import java.util.Comparator;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: e  reason: collision with root package name */
    public static Comparator<a> f63642e = new C1724a();

    /* renamed from: a  reason: collision with root package name */
    public b f63643a;

    /* renamed from: b  reason: collision with root package name */
    public a.C1727a f63644b;

    /* renamed from: c  reason: collision with root package name */
    public final String f63645c;

    /* renamed from: d  reason: collision with root package name */
    public long f63646d;

    /* renamed from: d.b.j.b.a$a  reason: collision with other inner class name */
    /* loaded from: classes2.dex */
    public static class C1724a implements Comparator<a> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(a aVar, a aVar2) {
            long f2 = aVar.f() - aVar2.f();
            return f2 != 0 ? f2 > 0 ? -1 : 1 : aVar.c().compareTo(aVar2.c());
        }
    }

    /* loaded from: classes2.dex */
    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public Context f63647a;

        /* renamed from: b  reason: collision with root package name */
        public d.b.j.g.a f63648b;
    }

    /* loaded from: classes2.dex */
    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public a.C1727a f63649a;

        /* renamed from: b  reason: collision with root package name */
        public String f63650b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f63651c = true;

        public c(a.C1727a c1727a, String str) {
            this.f63649a = c1727a;
            this.f63650b = "target-pkg-" + Base64.encodeToString(str.getBytes(), 3);
        }

        public abstract void a(JSONObject jSONObject);

        public void b(boolean z) {
            this.f63651c = z;
        }

        public boolean c() {
            String c2 = this.f63649a.c(this.f63650b, true);
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
            if (this.f63651c) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    d(jSONObject);
                    this.f63649a.e(this.f63650b, jSONObject.toString(), true);
                    b(false);
                    return true;
                } catch (Exception unused) {
                }
            }
            return false;
        }
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

    /* loaded from: classes2.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public boolean f63652a;
    }

    /* loaded from: classes2.dex */
    public static class h {

        /* renamed from: a  reason: collision with root package name */
        public l.a f63653a;

        /* renamed from: b  reason: collision with root package name */
        public int f63654b;

        public h(int i, l.a aVar, Exception exc) {
            this.f63654b = i;
            this.f63653a = aVar;
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
            return this.f63654b == 0;
        }
    }

    public a(String str, long j) {
        this.f63645c = str;
        this.f63646d = j;
    }

    public abstract f a(e eVar, l.a aVar);

    public abstract h b(String str, g gVar);

    public String c() {
        return this.f63645c;
    }

    public final void d(b bVar) {
        this.f63643a = bVar;
        this.f63644b = bVar.f63648b.e().b(IXAdRequestInfo.CS);
    }

    public abstract void e(d dVar);

    public long f() {
        return this.f63646d;
    }
}
