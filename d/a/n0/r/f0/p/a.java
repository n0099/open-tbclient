package d.a.n0.r.f0.p;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import d.a.n0.r.f0.p.a;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {

    /* renamed from: h  reason: collision with root package name */
    public static int f53548h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f53549a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f53550b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f53551c;

    /* renamed from: d  reason: collision with root package name */
    public int f53552d;

    /* renamed from: e  reason: collision with root package name */
    public int f53553e;

    /* renamed from: f  reason: collision with root package name */
    public int f53554f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1195a f53555g;

    /* renamed from: d.a.n0.r.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1195a {
        void a(int i2, boolean z);
    }

    public a() {
        int i2 = f53548h;
        f53548h = i2 + 1;
        this.f53549a = i2;
    }

    public void a(Editable editable, int i2, int i3, int i4) {
        this.f53551c = editable;
        this.f53552d = i2;
        this.f53553e = i3;
        this.f53554f = i4;
    }

    public void b(T t) {
        this.f53550b = t.h();
        this.f53551c = t.g();
        this.f53552d = t.f();
        this.f53553e = t.c();
        this.f53554f = t.d();
    }

    public int c() {
        return this.f53553e;
    }

    public int d() {
        return this.f53554f;
    }

    public int e() {
        return this.f53549a;
    }

    public int f() {
        return this.f53552d;
    }

    public Editable g() {
        return this.f53551c;
    }

    public boolean h() {
        return this.f53550b;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable = this.f53551c;
        if (editable == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f53552d, this.f53553e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f53553e = this.f53552d + charSequence.length();
    }

    public void j(int i2) {
        this.f53553e = i2;
    }

    public void k(InterfaceC1195a interfaceC1195a) {
        this.f53555g = interfaceC1195a;
    }

    public void l(Object obj, int i2, int i3, int i4) {
        Editable editable = this.f53551c;
        if (editable == null) {
            return;
        }
        editable.setSpan(obj, i2, i3, i4);
    }

    public void m(int i2) {
        this.f53552d = i2;
    }

    public void n(Editable editable) {
        this.f53551c = editable;
    }

    public void o(boolean z) {
        InterfaceC1195a interfaceC1195a;
        boolean z2 = this.f53550b;
        this.f53550b = z;
        if (z2 == z || (interfaceC1195a = this.f53555g) == null) {
            return;
        }
        interfaceC1195a.a(this.f53549a, z);
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i2);
}
