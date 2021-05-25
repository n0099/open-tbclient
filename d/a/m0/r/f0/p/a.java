package d.a.m0.r.f0.p;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import d.a.m0.r.f0.p.a;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {

    /* renamed from: h  reason: collision with root package name */
    public static int f49766h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f49767a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49768b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f49769c;

    /* renamed from: d  reason: collision with root package name */
    public int f49770d;

    /* renamed from: e  reason: collision with root package name */
    public int f49771e;

    /* renamed from: f  reason: collision with root package name */
    public int f49772f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1136a f49773g;

    /* renamed from: d.a.m0.r.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1136a {
        void a(int i2, boolean z);
    }

    public a() {
        int i2 = f49766h;
        f49766h = i2 + 1;
        this.f49767a = i2;
    }

    public void a(Editable editable, int i2, int i3, int i4) {
        this.f49769c = editable;
        this.f49770d = i2;
        this.f49771e = i3;
        this.f49772f = i4;
    }

    public void b(T t) {
        this.f49768b = t.h();
        this.f49769c = t.g();
        this.f49770d = t.f();
        this.f49771e = t.c();
        this.f49772f = t.d();
    }

    public int c() {
        return this.f49771e;
    }

    public int d() {
        return this.f49772f;
    }

    public int e() {
        return this.f49767a;
    }

    public int f() {
        return this.f49770d;
    }

    public Editable g() {
        return this.f49769c;
    }

    public boolean h() {
        return this.f49768b;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable = this.f49769c;
        if (editable == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f49770d, this.f49771e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f49771e = this.f49770d + charSequence.length();
    }

    public void j(int i2) {
        this.f49771e = i2;
    }

    public void k(InterfaceC1136a interfaceC1136a) {
        this.f49773g = interfaceC1136a;
    }

    public void l(Object obj, int i2, int i3, int i4) {
        Editable editable = this.f49769c;
        if (editable == null) {
            return;
        }
        editable.setSpan(obj, i2, i3, i4);
    }

    public void m(int i2) {
        this.f49770d = i2;
    }

    public void n(Editable editable) {
        this.f49769c = editable;
    }

    public void o(boolean z) {
        InterfaceC1136a interfaceC1136a;
        boolean z2 = this.f49768b;
        this.f49768b = z;
        if (z2 == z || (interfaceC1136a = this.f49773g) == null) {
            return;
        }
        interfaceC1136a.a(this.f49767a, z);
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i2);
}
