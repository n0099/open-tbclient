package d.b.c.e.f;

import java.security.InvalidParameterException;
/* loaded from: classes.dex */
public class b {

    /* renamed from: d  reason: collision with root package name */
    public String f42463d;

    /* renamed from: e  reason: collision with root package name */
    public a f42464e;

    /* renamed from: f  reason: collision with root package name */
    public int f42465f;

    /* renamed from: a  reason: collision with root package name */
    public int f42460a = 0;

    /* renamed from: b  reason: collision with root package name */
    public String[] f42461b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f42462c = 0;

    /* renamed from: g  reason: collision with root package name */
    public String[] f42466g = null;

    /* renamed from: h  reason: collision with root package name */
    public boolean f42467h = false;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, int i, boolean z);
    }

    public b(String str, int i, a aVar) {
        this.f42463d = null;
        this.f42464e = null;
        this.f42465f = 0;
        if (str != null) {
            this.f42463d = str;
            this.f42464e = aVar;
            this.f42465f = i;
            return;
        }
        throw new InvalidParameterException("SwitchData name is null");
    }

    public void a(int i, boolean z) {
        a aVar = this.f42464e;
        if (aVar != null) {
            aVar.a(this.f42463d, i, z);
        }
    }

    public int b() {
        return this.f42465f;
    }

    public String[] c() {
        return this.f42461b;
    }

    public int d() {
        return this.f42460a;
    }

    public String e() {
        return this.f42463d;
    }

    public int f() {
        return this.f42462c;
    }

    public String[] g() {
        return this.f42466g;
    }

    public boolean h() {
        return this.f42467h;
    }

    public void i(int i, String[] strArr, int i2) {
        this.f42460a = i;
        this.f42461b = strArr;
        this.f42462c = i2;
    }

    public void j(boolean z) {
        this.f42467h = z;
    }

    public void k(String[] strArr) {
        this.f42466g = strArr;
    }
}
