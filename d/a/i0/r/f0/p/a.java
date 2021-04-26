package d.a.i0.r.f0.p;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import d.a.i0.r.f0.p.a;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {

    /* renamed from: h  reason: collision with root package name */
    public static int f48893h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f48894a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f48895b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f48896c;

    /* renamed from: d  reason: collision with root package name */
    public int f48897d;

    /* renamed from: e  reason: collision with root package name */
    public int f48898e;

    /* renamed from: f  reason: collision with root package name */
    public int f48899f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1051a f48900g;

    /* renamed from: d.a.i0.r.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1051a {
        void a(int i2, boolean z);
    }

    public a() {
        int i2 = f48893h;
        f48893h = i2 + 1;
        this.f48894a = i2;
    }

    public void a(Editable editable, int i2, int i3, int i4) {
        this.f48896c = editable;
        this.f48897d = i2;
        this.f48898e = i3;
        this.f48899f = i4;
    }

    public void b(T t) {
        this.f48895b = t.h();
        this.f48896c = t.g();
        this.f48897d = t.f();
        this.f48898e = t.c();
        this.f48899f = t.d();
    }

    public int c() {
        return this.f48898e;
    }

    public int d() {
        return this.f48899f;
    }

    public int e() {
        return this.f48894a;
    }

    public int f() {
        return this.f48897d;
    }

    public Editable g() {
        return this.f48896c;
    }

    public boolean h() {
        return this.f48895b;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable = this.f48896c;
        if (editable == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f48897d, this.f48898e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f48898e = this.f48897d + charSequence.length();
    }

    public void j(int i2) {
        this.f48898e = i2;
    }

    public void k(InterfaceC1051a interfaceC1051a) {
        this.f48900g = interfaceC1051a;
    }

    public void l(Object obj, int i2, int i3, int i4) {
        Editable editable = this.f48896c;
        if (editable == null) {
            return;
        }
        editable.setSpan(obj, i2, i3, i4);
    }

    public void m(int i2) {
        this.f48897d = i2;
    }

    public void n(Editable editable) {
        this.f48896c = editable;
    }

    public void o(boolean z) {
        InterfaceC1051a interfaceC1051a;
        boolean z2 = this.f48895b;
        this.f48895b = z;
        if (z2 == z || (interfaceC1051a = this.f48900g) == null) {
            return;
        }
        interfaceC1051a.a(this.f48894a, z);
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i2);
}
