package d.r.b.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import java.util.Locale;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f67622a;

    /* renamed from: b  reason: collision with root package name */
    public int f67623b;

    /* renamed from: c  reason: collision with root package name */
    public int f67624c;

    /* renamed from: d  reason: collision with root package name */
    public int f67625d;

    /* renamed from: e  reason: collision with root package name */
    public d.r.b.a.a.f.c.d f67626e;

    /* renamed from: f  reason: collision with root package name */
    public String f67627f;

    /* renamed from: g  reason: collision with root package name */
    public String f67628g;

    /* renamed from: h  reason: collision with root package name */
    public Context f67629h;

    /* renamed from: i  reason: collision with root package name */
    public String f67630i;
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
        public d.r.b.a.a.f.c.d f67635e;

        /* renamed from: h  reason: collision with root package name */
        public Context f67638h;
        public d.r.b.a.a.f.f.c p;

        /* renamed from: a  reason: collision with root package name */
        public long f67631a = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f67633c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f67634d = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f67636f = Locale.getDefault().getCountry();

        /* renamed from: g  reason: collision with root package name */
        public String f67637g = Locale.getDefault().getLanguage();

        /* renamed from: i  reason: collision with root package name */
        public String f67639i = "";
        public String j = "";
        public String k = "";
        public String l = "";
        public ProtocolType m = ProtocolType.SERVICE;
        public int n = 4;
        public boolean o = false;

        /* renamed from: b  reason: collision with root package name */
        public int f67632b = 0;

        public static a a() {
            return new a();
        }

        public b b() {
            b bVar = new b();
            bVar.f67625d = this.f67634d;
            bVar.f67626e = this.f67635e;
            bVar.f67624c = this.f67633c;
            bVar.f67627f = this.f67636f;
            bVar.f67628g = this.f67637g;
            bVar.f67622a = this.f67631a;
            bVar.f67629h = this.f67638h;
            bVar.f67630i = this.f67639i;
            bVar.j = this.j;
            bVar.k = this.k;
            bVar.l = this.l;
            bVar.m = this.m;
            bVar.n = this.n;
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.f67623b = this.f67632b;
            return bVar;
        }

        public a c(int i2) {
            this.f67632b = i2;
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
            this.f67638h = context;
            return this;
        }

        public a g(@NonNull String str) {
            this.f67636f = str;
            return this;
        }

        public a h(int i2) {
            this.f67634d = i2;
            return this;
        }

        public a i(@NonNull d.r.b.a.a.f.c.d dVar) {
            this.f67635e = dVar;
            return this;
        }

        public a j(@NonNull boolean z) {
            this.o = z;
            return this;
        }

        public a k(@NonNull String str) {
            this.f67637g = str;
            return this;
        }

        public a l(@NonNull String str) {
            this.f67639i = str;
            return this;
        }

        public a m(@NonNull d.r.b.a.a.f.f.c cVar) {
            this.p = cVar;
            return this;
        }

        public a n(long j) {
            this.f67631a = j;
            return this;
        }

        public a o(int i2) {
            this.f67633c = i2;
            return this;
        }
    }

    public long A() {
        return this.f67622a;
    }

    public int B() {
        return this.f67624c;
    }

    public void C(String str) {
        this.f67627f = str;
    }

    public void D(long j) {
        this.f67622a = j;
    }

    public int q() {
        return this.f67623b;
    }

    public String r() {
        return this.j;
    }

    public Context s() {
        return this.f67629h;
    }

    public String t() {
        return this.f67627f;
    }

    public int u() {
        return this.f67625d;
    }

    public d.r.b.a.a.f.c.d v() {
        return this.f67626e;
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
