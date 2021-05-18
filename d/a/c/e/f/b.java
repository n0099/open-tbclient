package d.a.c.e.f;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public String f38902d;

    /* renamed from: e  reason: collision with root package name */
    public a f38903e;

    /* renamed from: f  reason: collision with root package name */
    public int f38904f;

    /* renamed from: a  reason: collision with root package name */
    public int f38899a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String[] f38900b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f38901c = 0;

    /* renamed from: g  reason: collision with root package name */
    public String[] f38905g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38906h = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i2, boolean z);
    }

    public b(String str, int i2, a aVar) {
        this.f38902d = null;
        this.f38903e = null;
        this.f38904f = 0;
        if (str != null) {
            this.f38902d = str;
            this.f38903e = aVar;
            this.f38904f = i2;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i2, boolean z) {
        a aVar = this.f38903e;
        if (aVar != null) {
            aVar.a(this.f38902d, i2, z);
        }
    }

    public int b() {
        return this.f38904f;
    }

    public String[] c() {
        return this.f38900b;
    }

    public int d() {
        return this.f38899a;
    }

    public String e() {
        return this.f38902d;
    }

    public int f() {
        return this.f38901c;
    }

    public String[] g() {
        return this.f38905g;
    }

    public boolean h() {
        return this.f38906h;
    }

    public void i(int i2, String[] strArr, int i3) {
        this.f38899a = i2;
        this.f38900b = strArr;
        this.f38901c = i3;
    }

    public void j(boolean z) {
        this.f38906h = z;
    }

    public void k(String[] strArr) {
        this.f38905g = strArr;
    }
}
