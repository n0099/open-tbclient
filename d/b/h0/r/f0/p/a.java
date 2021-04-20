package d.b.h0.r.f0.p;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import d.b.h0.r.f0.p.a;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {

    /* renamed from: h  reason: collision with root package name */
    public static int f50944h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f50945a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50946b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f50947c;

    /* renamed from: d  reason: collision with root package name */
    public int f50948d;

    /* renamed from: e  reason: collision with root package name */
    public int f50949e;

    /* renamed from: f  reason: collision with root package name */
    public int f50950f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1090a f50951g;

    /* renamed from: d.b.h0.r.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1090a {
        void a(int i, boolean z);
    }

    public a() {
        int i = f50944h;
        f50944h = i + 1;
        this.f50945a = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.f50947c = editable;
        this.f50948d = i;
        this.f50949e = i2;
        this.f50950f = i3;
    }

    public void b(T t) {
        this.f50946b = t.h();
        this.f50947c = t.g();
        this.f50948d = t.f();
        this.f50949e = t.c();
        this.f50950f = t.d();
    }

    public int c() {
        return this.f50949e;
    }

    public int d() {
        return this.f50950f;
    }

    public int e() {
        return this.f50945a;
    }

    public int f() {
        return this.f50948d;
    }

    public Editable g() {
        return this.f50947c;
    }

    public boolean h() {
        return this.f50946b;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable = this.f50947c;
        if (editable == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f50948d, this.f50949e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f50949e = this.f50948d + charSequence.length();
    }

    public void j(int i) {
        this.f50949e = i;
    }

    public void k(InterfaceC1090a interfaceC1090a) {
        this.f50951g = interfaceC1090a;
    }

    public void l(Object obj, int i, int i2, int i3) {
        Editable editable = this.f50947c;
        if (editable == null) {
            return;
        }
        editable.setSpan(obj, i, i2, i3);
    }

    public void m(int i) {
        this.f50948d = i;
    }

    public void n(Editable editable) {
        this.f50947c = editable;
    }

    public void o(boolean z) {
        InterfaceC1090a interfaceC1090a;
        boolean z2 = this.f50946b;
        this.f50946b = z;
        if (z2 == z || (interfaceC1090a = this.f50951g) == null) {
            return;
        }
        interfaceC1090a.a(this.f50945a, z);
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i);
}
