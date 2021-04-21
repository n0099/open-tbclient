package d.b.i0.r.f0.p;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import d.b.i0.r.f0.p.a;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {

    /* renamed from: h  reason: collision with root package name */
    public static int f51280h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f51281a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f51282b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f51283c;

    /* renamed from: d  reason: collision with root package name */
    public int f51284d;

    /* renamed from: e  reason: collision with root package name */
    public int f51285e;

    /* renamed from: f  reason: collision with root package name */
    public int f51286f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1112a f51287g;

    /* renamed from: d.b.i0.r.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1112a {
        void a(int i, boolean z);
    }

    public a() {
        int i = f51280h;
        f51280h = i + 1;
        this.f51281a = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.f51283c = editable;
        this.f51284d = i;
        this.f51285e = i2;
        this.f51286f = i3;
    }

    public void b(T t) {
        this.f51282b = t.h();
        this.f51283c = t.g();
        this.f51284d = t.f();
        this.f51285e = t.c();
        this.f51286f = t.d();
    }

    public int c() {
        return this.f51285e;
    }

    public int d() {
        return this.f51286f;
    }

    public int e() {
        return this.f51281a;
    }

    public int f() {
        return this.f51284d;
    }

    public Editable g() {
        return this.f51283c;
    }

    public boolean h() {
        return this.f51282b;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable = this.f51283c;
        if (editable == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f51284d, this.f51285e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f51285e = this.f51284d + charSequence.length();
    }

    public void j(int i) {
        this.f51285e = i;
    }

    public void k(InterfaceC1112a interfaceC1112a) {
        this.f51287g = interfaceC1112a;
    }

    public void l(Object obj, int i, int i2, int i3) {
        Editable editable = this.f51283c;
        if (editable == null) {
            return;
        }
        editable.setSpan(obj, i, i2, i3);
    }

    public void m(int i) {
        this.f51284d = i;
    }

    public void n(Editable editable) {
        this.f51283c = editable;
    }

    public void o(boolean z) {
        InterfaceC1112a interfaceC1112a;
        boolean z2 = this.f51282b;
        this.f51282b = z;
        if (z2 == z || (interfaceC1112a = this.f51287g) == null) {
            return;
        }
        interfaceC1112a.a(this.f51281a, z);
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i);
}
