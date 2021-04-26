package d.a.c.e.f;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public String f39657d;

    /* renamed from: e  reason: collision with root package name */
    public a f39658e;

    /* renamed from: f  reason: collision with root package name */
    public int f39659f;

    /* renamed from: a  reason: collision with root package name */
    public int f39654a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String[] f39655b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f39656c = 0;

    /* renamed from: g  reason: collision with root package name */
    public String[] f39660g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f39661h = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i2, boolean z);
    }

    public b(String str, int i2, a aVar) {
        this.f39657d = null;
        this.f39658e = null;
        this.f39659f = 0;
        if (str != null) {
            this.f39657d = str;
            this.f39658e = aVar;
            this.f39659f = i2;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i2, boolean z) {
        a aVar = this.f39658e;
        if (aVar != null) {
            aVar.a(this.f39657d, i2, z);
        }
    }

    public int b() {
        return this.f39659f;
    }

    public String[] c() {
        return this.f39655b;
    }

    public int d() {
        return this.f39654a;
    }

    public String e() {
        return this.f39657d;
    }

    public int f() {
        return this.f39656c;
    }

    public String[] g() {
        return this.f39660g;
    }

    public boolean h() {
        return this.f39661h;
    }

    public void i(int i2, String[] strArr, int i3) {
        this.f39654a = i2;
        this.f39655b = strArr;
        this.f39656c = i3;
    }

    public void j(boolean z) {
        this.f39661h = z;
    }

    public void k(String[] strArr) {
        this.f39660g = strArr;
    }
}
