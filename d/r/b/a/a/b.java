package d.r.b.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import java.util.Locale;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f66936a;

    /* renamed from: b  reason: collision with root package name */
    public int f66937b;

    /* renamed from: c  reason: collision with root package name */
    public int f66938c;

    /* renamed from: d  reason: collision with root package name */
    public int f66939d;

    /* renamed from: e  reason: collision with root package name */
    public d.r.b.a.a.f.c.d f66940e;

    /* renamed from: f  reason: collision with root package name */
    public String f66941f;

    /* renamed from: g  reason: collision with root package name */
    public String f66942g;

    /* renamed from: h  reason: collision with root package name */
    public Context f66943h;

    /* renamed from: i  reason: collision with root package name */
    public String f66944i;
    public String j;
    public String k;
    public String l;
    public ProtocolType m;
    public int n;
    public boolean o;
    public d.r.b.a.a.f.f.c p;

    /* loaded from: classes7.dex */
    public static final class a {

        /* renamed from: e  reason: collision with root package name */
        public d.r.b.a.a.f.c.d f66949e;

        /* renamed from: h  reason: collision with root package name */
        public Context f66952h;
        public d.r.b.a.a.f.f.c p;

        /* renamed from: a  reason: collision with root package name */
        public long f66945a = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f66947c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f66948d = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f66950f = Locale.getDefault().getCountry();

        /* renamed from: g  reason: collision with root package name */
        public String f66951g = Locale.getDefault().getLanguage();

        /* renamed from: i  reason: collision with root package name */
        public String f66953i = "";
        public String j = "";
        public String k = "";
        public String l = "";
        public ProtocolType m = ProtocolType.SERVICE;
        public int n = 4;
        public boolean o = false;

        /* renamed from: b  reason: collision with root package name */
        public int f66946b = 0;

        public static a a() {
            return new a();
        }

        public b b() {
            b bVar = new b();
            bVar.f66939d = this.f66948d;
            bVar.f66940e = this.f66949e;
            bVar.f66938c = this.f66947c;
            bVar.f66941f = this.f66950f;
            bVar.f66942g = this.f66951g;
            bVar.f66936a = this.f66945a;
            bVar.f66943h = this.f66952h;
            bVar.f66944i = this.f66953i;
            bVar.j = this.j;
            bVar.k = this.k;
            bVar.l = this.l;
            bVar.m = this.m;
            bVar.n = this.n;
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.f66937b = this.f66946b;
            return bVar;
        }

        public a c(int i2) {
            this.f66946b = i2;
            return this;
        }

        public a d(@NonNull int i2) {
            this.n = i2;
            return this;
        }

        public a e(@NonNull String str) {
            this.j = str;
            return this;
        }

        public a f(@NonNull Context context) {
            this.f66952h = context;
            return this;
        }

        public a g(@NonNull String str) {
            this.f66950f = str;
            return this;
        }

        public a h(int i2) {
            this.f66948d = i2;
            return this;
        }

        public a i(@NonNull d.r.b.a.a.f.c.d dVar) {
            this.f66949e = dVar;
            return this;
        }

        public a j(@NonNull boolean z) {
            this.o = z;
            return this;
        }

        public a k(@NonNull String str) {
            this.f66951g = str;
            return this;
        }

        public a l(@NonNull String str) {
            this.f66953i = str;
            return this;
        }

        public a m(@NonNull d.r.b.a.a.f.f.c cVar) {
            this.p = cVar;
            return this;
        }

        public a n(long j) {
            this.f66945a = j;
            return this;
        }

        public a o(int i2) {
            this.f66947c = i2;
            return this;
        }
    }

    public long A() {
        return this.f66936a;
    }

    public int B() {
        return this.f66938c;
    }

    public void C(String str) {
        this.f66941f = str;
    }

    public void D(long j) {
        this.f66936a = j;
    }

    public int q() {
        return this.f66937b;
    }

    public String r() {
        return this.j;
    }

    public Context s() {
        return this.f66943h;
    }

    public String t() {
        return this.f66941f;
    }

    public int u() {
        return this.f66939d;
    }

    public d.r.b.a.a.f.c.d v() {
        return this.f66940e;
    }

    public String w() {
        return this.l;
    }

    public boolean x() {
        return this.o;
    }

    public d.r.b.a.a.f.f.c y() {
        return this.p;
    }

    public String z() {
        return this.k;
    }
}
