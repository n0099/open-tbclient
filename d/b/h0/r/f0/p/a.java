package d.b.h0.r.f0.p;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import d.b.h0.r.f0.p.a;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {

    /* renamed from: h  reason: collision with root package name */
    public static int f50537h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f50538a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50539b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f50540c;

    /* renamed from: d  reason: collision with root package name */
    public int f50541d;

    /* renamed from: e  reason: collision with root package name */
    public int f50542e;

    /* renamed from: f  reason: collision with root package name */
    public int f50543f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1077a f50544g;

    /* renamed from: d.b.h0.r.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1077a {
        void a(int i, boolean z);
    }

    public a() {
        int i = f50537h;
        f50537h = i + 1;
        this.f50538a = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.f50540c = editable;
        this.f50541d = i;
        this.f50542e = i2;
        this.f50543f = i3;
    }

    public void b(T t) {
        this.f50539b = t.h();
        this.f50540c = t.g();
        this.f50541d = t.f();
        this.f50542e = t.c();
        this.f50543f = t.d();
    }

    public int c() {
        return this.f50542e;
    }

    public int d() {
        return this.f50543f;
    }

    public int e() {
        return this.f50538a;
    }

    public int f() {
        return this.f50541d;
    }

    public Editable g() {
        return this.f50540c;
    }

    public boolean h() {
        return this.f50539b;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable = this.f50540c;
        if (editable == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f50541d, this.f50542e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f50542e = this.f50541d + charSequence.length();
    }

    public void j(int i) {
        this.f50542e = i;
    }

    public void k(InterfaceC1077a interfaceC1077a) {
        this.f50544g = interfaceC1077a;
    }

    public void l(Object obj, int i, int i2, int i3) {
        Editable editable = this.f50540c;
        if (editable == null) {
            return;
        }
        editable.setSpan(obj, i, i2, i3);
    }

    public void m(int i) {
        this.f50541d = i;
    }

    public void n(Editable editable) {
        this.f50540c = editable;
    }

    public void o(boolean z) {
        InterfaceC1077a interfaceC1077a;
        boolean z2 = this.f50539b;
        this.f50539b = z;
        if (z2 == z || (interfaceC1077a = this.f50544g) == null) {
            return;
        }
        interfaceC1077a.a(this.f50538a, z);
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i);
}
