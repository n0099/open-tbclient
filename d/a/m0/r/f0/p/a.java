package d.a.m0.r.f0.p;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import d.a.m0.r.f0.p.a;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {

    /* renamed from: h  reason: collision with root package name */
    public static int f53441h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f53442a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53443b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f53444c;

    /* renamed from: d  reason: collision with root package name */
    public int f53445d;

    /* renamed from: e  reason: collision with root package name */
    public int f53446e;

    /* renamed from: f  reason: collision with root package name */
    public int f53447f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1192a f53448g;

    /* renamed from: d.a.m0.r.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1192a {
        void a(int i2, boolean z);
    }

    public a() {
        int i2 = f53441h;
        f53441h = i2 + 1;
        this.f53442a = i2;
    }

    public void a(Editable editable, int i2, int i3, int i4) {
        this.f53444c = editable;
        this.f53445d = i2;
        this.f53446e = i3;
        this.f53447f = i4;
    }

    public void b(T t) {
        this.f53443b = t.h();
        this.f53444c = t.g();
        this.f53445d = t.f();
        this.f53446e = t.c();
        this.f53447f = t.d();
    }

    public int c() {
        return this.f53446e;
    }

    public int d() {
        return this.f53447f;
    }

    public int e() {
        return this.f53442a;
    }

    public int f() {
        return this.f53445d;
    }

    public Editable g() {
        return this.f53444c;
    }

    public boolean h() {
        return this.f53443b;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable = this.f53444c;
        if (editable == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f53445d, this.f53446e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f53446e = this.f53445d + charSequence.length();
    }

    public void j(int i2) {
        this.f53446e = i2;
    }

    public void k(InterfaceC1192a interfaceC1192a) {
        this.f53448g = interfaceC1192a;
    }

    public void l(Object obj, int i2, int i3, int i4) {
        Editable editable = this.f53444c;
        if (editable == null) {
            return;
        }
        editable.setSpan(obj, i2, i3, i4);
    }

    public void m(int i2) {
        this.f53445d = i2;
    }

    public void n(Editable editable) {
        this.f53444c = editable;
    }

    public void o(boolean z) {
        InterfaceC1192a interfaceC1192a;
        boolean z2 = this.f53443b;
        this.f53443b = z;
        if (z2 == z || (interfaceC1192a = this.f53448g) == null) {
            return;
        }
        interfaceC1192a.a(this.f53442a, z);
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i2);
}
