package d.b.b.e.f;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public String f41725d;

    /* renamed from: e  reason: collision with root package name */
    public a f41726e;

    /* renamed from: f  reason: collision with root package name */
    public int f41727f;

    /* renamed from: a  reason: collision with root package name */
    public int f41722a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String[] f41723b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f41724c = 0;

    /* renamed from: g  reason: collision with root package name */
    public String[] f41728g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41729h = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.f41725d = null;
        this.f41726e = null;
        this.f41727f = 0;
        if (str != null) {
            this.f41725d = str;
            this.f41726e = aVar;
            this.f41727f = i;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i, boolean z) {
        a aVar = this.f41726e;
        if (aVar != null) {
            aVar.a(this.f41725d, i, z);
        }
    }

    public int b() {
        return this.f41727f;
    }

    public String[] c() {
        return this.f41723b;
    }

    public int d() {
        return this.f41722a;
    }

    public String e() {
        return this.f41725d;
    }

    public int f() {
        return this.f41724c;
    }

    public String[] g() {
        return this.f41728g;
    }

    public boolean h() {
        return this.f41729h;
    }

    public void i(int i, String[] strArr, int i2) {
        this.f41722a = i;
        this.f41723b = strArr;
        this.f41724c = i2;
    }

    public void j(boolean z) {
        this.f41729h = z;
    }

    public void k(String[] strArr) {
        this.f41728g = strArr;
    }
}
