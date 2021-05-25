package d.r.b.a.a;

import android.content.Context;
import androidx.annotation.NonNull;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import java.util.Locale;
/* loaded from: classes7.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public long f67665a;

    /* renamed from: b  reason: collision with root package name */
    public int f67666b;

    /* renamed from: c  reason: collision with root package name */
    public int f67667c;

    /* renamed from: d  reason: collision with root package name */
    public int f67668d;

    /* renamed from: e  reason: collision with root package name */
    public d.r.b.a.a.f.c.d f67669e;

    /* renamed from: f  reason: collision with root package name */
    public String f67670f;

    /* renamed from: g  reason: collision with root package name */
    public String f67671g;

    /* renamed from: h  reason: collision with root package name */
    public Context f67672h;

    /* renamed from: i  reason: collision with root package name */
    public String f67673i;
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
        public d.r.b.a.a.f.c.d f67678e;

        /* renamed from: h  reason: collision with root package name */
        public Context f67681h;
        public d.r.b.a.a.f.f.c p;

        /* renamed from: a  reason: collision with root package name */
        public long f67674a = 0;

        /* renamed from: c  reason: collision with root package name */
        public int f67676c = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f67677d = 0;

        /* renamed from: f  reason: collision with root package name */
        public String f67679f = Locale.getDefault().getCountry();

        /* renamed from: g  reason: collision with root package name */
        public String f67680g = Locale.getDefault().getLanguage();

        /* renamed from: i  reason: collision with root package name */
        public String f67682i = "";
        public String j = "";
        public String k = "";
        public String l = "";
        public ProtocolType m = ProtocolType.SERVICE;
        public int n = 4;
        public boolean o = false;

        /* renamed from: b  reason: collision with root package name */
        public int f67675b = 0;

        public static a a() {
            return new a();
        }

        public b b() {
            b bVar = new b();
            bVar.f67668d = this.f67677d;
            bVar.f67669e = this.f67678e;
            bVar.f67667c = this.f67676c;
            bVar.f67670f = this.f67679f;
            bVar.f67671g = this.f67680g;
            bVar.f67665a = this.f67674a;
            bVar.f67672h = this.f67681h;
            bVar.f67673i = this.f67682i;
            bVar.j = this.j;
            bVar.k = this.k;
            bVar.l = this.l;
            bVar.m = this.m;
            bVar.n = this.n;
            bVar.o = this.o;
            bVar.p = this.p;
            bVar.f67666b = this.f67675b;
            return bVar;
        }

        public a c(int i2) {
            this.f67675b = i2;
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
            this.f67681h = context;
            return this;
        }

        public a g(@NonNull String str) {
            this.f67679f = str;
            return this;
        }

        public a h(int i2) {
            this.f67677d = i2;
            return this;
        }

        public a i(@NonNull d.r.b.a.a.f.c.d dVar) {
            this.f67678e = dVar;
            return this;
        }

        public a j(@NonNull boolean z) {
            this.o = z;
            return this;
        }

        public a k(@NonNull String str) {
            this.f67680g = str;
            return this;
        }

        public a l(@NonNull String str) {
            this.f67682i = str;
            return this;
        }

        public a m(@NonNull d.r.b.a.a.f.f.c cVar) {
            this.p = cVar;
            return this;
        }

        public a n(long j) {
            this.f67674a = j;
            return this;
        }

        public a o(int i2) {
            this.f67676c = i2;
            return this;
        }
    }

    public long A() {
        return this.f67665a;
    }

    public int B() {
        return this.f67667c;
    }

    public void C(String str) {
        this.f67670f = str;
    }

    public void D(long j) {
        this.f67665a = j;
    }

    public int q() {
        return this.f67666b;
    }

    public String r() {
        return this.j;
    }

    public Context s() {
        return this.f67672h;
    }

    public String t() {
        return this.f67670f;
    }

    public int u() {
        return this.f67668d;
    }

    public d.r.b.a.a.f.c.d v() {
        return this.f67669e;
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
