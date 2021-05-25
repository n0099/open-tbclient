package d.a.c.e.f;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public String f38566d;

    /* renamed from: e  reason: collision with root package name */
    public a f38567e;

    /* renamed from: f  reason: collision with root package name */
    public int f38568f;

    /* renamed from: a  reason: collision with root package name */
    public int f38563a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String[] f38564b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f38565c = 0;

    /* renamed from: g  reason: collision with root package name */
    public String[] f38569g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f38570h = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i2, boolean z);
    }

    public b(String str, int i2, a aVar) {
        this.f38566d = null;
        this.f38567e = null;
        this.f38568f = 0;
        if (str != null) {
            this.f38566d = str;
            this.f38567e = aVar;
            this.f38568f = i2;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i2, boolean z) {
        a aVar = this.f38567e;
        if (aVar != null) {
            aVar.a(this.f38566d, i2, z);
        }
    }

    public int b() {
        return this.f38568f;
    }

    public String[] c() {
        return this.f38564b;
    }

    public int d() {
        return this.f38563a;
    }

    public String e() {
        return this.f38566d;
    }

    public int f() {
        return this.f38565c;
    }

    public String[] g() {
        return this.f38569g;
    }

    public boolean h() {
        return this.f38570h;
    }

    public void i(int i2, String[] strArr, int i3) {
        this.f38563a = i2;
        this.f38564b = strArr;
        this.f38565c = i3;
    }

    public void j(boolean z) {
        this.f38570h = z;
    }

    public void k(String[] strArr) {
        this.f38569g = strArr;
    }
}
