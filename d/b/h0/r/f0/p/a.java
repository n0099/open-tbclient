package d.b.h0.r.f0.p;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import d.b.h0.r.f0.p.a;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {

    /* renamed from: h  reason: collision with root package name */
    public static int f50536h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f50537a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f50538b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f50539c;

    /* renamed from: d  reason: collision with root package name */
    public int f50540d;

    /* renamed from: e  reason: collision with root package name */
    public int f50541e;

    /* renamed from: f  reason: collision with root package name */
    public int f50542f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1076a f50543g;

    /* renamed from: d.b.h0.r.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1076a {
        void a(int i, boolean z);
    }

    public a() {
        int i = f50536h;
        f50536h = i + 1;
        this.f50537a = i;
    }

    public void a(Editable editable, int i, int i2, int i3) {
        this.f50539c = editable;
        this.f50540d = i;
        this.f50541e = i2;
        this.f50542f = i3;
    }

    public void b(T t) {
        this.f50538b = t.h();
        this.f50539c = t.g();
        this.f50540d = t.f();
        this.f50541e = t.c();
        this.f50542f = t.d();
    }

    public int c() {
        return this.f50541e;
    }

    public int d() {
        return this.f50542f;
    }

    public int e() {
        return this.f50537a;
    }

    public int f() {
        return this.f50540d;
    }

    public Editable g() {
        return this.f50539c;
    }

    public boolean h() {
        return this.f50538b;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable = this.f50539c;
        if (editable == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f50540d, this.f50541e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f50541e = this.f50540d + charSequence.length();
    }

    public void j(int i) {
        this.f50541e = i;
    }

    public void k(InterfaceC1076a interfaceC1076a) {
        this.f50543g = interfaceC1076a;
    }

    public void l(Object obj, int i, int i2, int i3) {
        Editable editable = this.f50539c;
        if (editable == null) {
            return;
        }
        editable.setSpan(obj, i, i2, i3);
    }

    public void m(int i) {
        this.f50540d = i;
    }

    public void n(Editable editable) {
        this.f50539c = editable;
    }

    public void o(boolean z) {
        InterfaceC1076a interfaceC1076a;
        boolean z2 = this.f50538b;
        this.f50538b = z;
        if (z2 == z || (interfaceC1076a = this.f50543g) == null) {
            return;
        }
        interfaceC1076a.a(this.f50537a, z);
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i);
}
