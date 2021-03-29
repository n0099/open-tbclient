package d.b.b.e.f;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public String f41726d;

    /* renamed from: e  reason: collision with root package name */
    public a f41727e;

    /* renamed from: f  reason: collision with root package name */
    public int f41728f;

    /* renamed from: a  reason: collision with root package name */
    public int f41723a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String[] f41724b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f41725c = 0;

    /* renamed from: g  reason: collision with root package name */
    public String[] f41729g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f41730h = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.f41726d = null;
        this.f41727e = null;
        this.f41728f = 0;
        if (str != null) {
            this.f41726d = str;
            this.f41727e = aVar;
            this.f41728f = i;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i, boolean z) {
        a aVar = this.f41727e;
        if (aVar != null) {
            aVar.a(this.f41726d, i, z);
        }
    }

    public int b() {
        return this.f41728f;
    }

    public String[] c() {
        return this.f41724b;
    }

    public int d() {
        return this.f41723a;
    }

    public String e() {
        return this.f41726d;
    }

    public int f() {
        return this.f41725c;
    }

    public String[] g() {
        return this.f41729g;
    }

    public boolean h() {
        return this.f41730h;
    }

    public void i(int i, String[] strArr, int i2) {
        this.f41723a = i;
        this.f41724b = strArr;
        this.f41725c = i2;
    }

    public void j(boolean z) {
        this.f41730h = z;
    }

    public void k(String[] strArr) {
        this.f41729g = strArr;
    }
}
