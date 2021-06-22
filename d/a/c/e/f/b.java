package d.a.c.e.f;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public String f42322d;

    /* renamed from: e  reason: collision with root package name */
    public a f42323e;

    /* renamed from: f  reason: collision with root package name */
    public int f42324f;

    /* renamed from: a  reason: collision with root package name */
    public int f42319a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String[] f42320b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f42321c = 0;

    /* renamed from: g  reason: collision with root package name */
    public String[] f42325g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42326h = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i2, boolean z);
    }

    public b(String str, int i2, a aVar) {
        this.f42322d = null;
        this.f42323e = null;
        this.f42324f = 0;
        if (str != null) {
            this.f42322d = str;
            this.f42323e = aVar;
            this.f42324f = i2;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i2, boolean z) {
        a aVar = this.f42323e;
        if (aVar != null) {
            aVar.a(this.f42322d, i2, z);
        }
    }

    public int b() {
        return this.f42324f;
    }

    public String[] c() {
        return this.f42320b;
    }

    public int d() {
        return this.f42319a;
    }

    public String e() {
        return this.f42322d;
    }

    public int f() {
        return this.f42321c;
    }

    public String[] g() {
        return this.f42325g;
    }

    public boolean h() {
        return this.f42326h;
    }

    public void i(int i2, String[] strArr, int i3) {
        this.f42319a = i2;
        this.f42320b = strArr;
        this.f42321c = i3;
    }

    public void j(boolean z) {
        this.f42326h = z;
    }

    public void k(String[] strArr) {
        this.f42325g = strArr;
    }
}
