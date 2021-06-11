package d.a.c.e.f;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public String f42219d;

    /* renamed from: e  reason: collision with root package name */
    public a f42220e;

    /* renamed from: f  reason: collision with root package name */
    public int f42221f;

    /* renamed from: a  reason: collision with root package name */
    public int f42216a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String[] f42217b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f42218c = 0;

    /* renamed from: g  reason: collision with root package name */
    public String[] f42222g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42223h = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i2, boolean z);
    }

    public b(String str, int i2, a aVar) {
        this.f42219d = null;
        this.f42220e = null;
        this.f42221f = 0;
        if (str != null) {
            this.f42219d = str;
            this.f42220e = aVar;
            this.f42221f = i2;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i2, boolean z) {
        a aVar = this.f42220e;
        if (aVar != null) {
            aVar.a(this.f42219d, i2, z);
        }
    }

    public int b() {
        return this.f42221f;
    }

    public String[] c() {
        return this.f42217b;
    }

    public int d() {
        return this.f42216a;
    }

    public String e() {
        return this.f42219d;
    }

    public int f() {
        return this.f42218c;
    }

    public String[] g() {
        return this.f42222g;
    }

    public boolean h() {
        return this.f42223h;
    }

    public void i(int i2, String[] strArr, int i3) {
        this.f42216a = i2;
        this.f42217b = strArr;
        this.f42218c = i3;
    }

    public void j(boolean z) {
        this.f42223h = z;
    }

    public void k(String[] strArr) {
        this.f42222g = strArr;
    }
}
