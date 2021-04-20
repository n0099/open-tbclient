package d.b.c.e.f;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public String f42223d;

    /* renamed from: e  reason: collision with root package name */
    public a f42224e;

    /* renamed from: f  reason: collision with root package name */
    public int f42225f;

    /* renamed from: a  reason: collision with root package name */
    public int f42220a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String[] f42221b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f42222c = 0;

    /* renamed from: g  reason: collision with root package name */
    public String[] f42226g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42227h = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.f42223d = null;
        this.f42224e = null;
        this.f42225f = 0;
        if (str != null) {
            this.f42223d = str;
            this.f42224e = aVar;
            this.f42225f = i;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i, boolean z) {
        a aVar = this.f42224e;
        if (aVar != null) {
            aVar.a(this.f42223d, i, z);
        }
    }

    public int b() {
        return this.f42225f;
    }

    public String[] c() {
        return this.f42221b;
    }

    public int d() {
        return this.f42220a;
    }

    public String e() {
        return this.f42223d;
    }

    public int f() {
        return this.f42222c;
    }

    public String[] g() {
        return this.f42226g;
    }

    public boolean h() {
        return this.f42227h;
    }

    public void i(int i, String[] strArr, int i2) {
        this.f42220a = i;
        this.f42221b = strArr;
        this.f42222c = i2;
    }

    public void j(boolean z) {
        this.f42227h = z;
    }

    public void k(String[] strArr) {
        this.f42226g = strArr;
    }
}
