package d.a.j0.r.f0.p;

import android.text.Editable;
import androidx.annotation.NonNull;
import com.baidu.adp.lib.util.BdLog;
import d.a.j0.r.f0.p.a;
/* loaded from: classes3.dex */
public abstract class a<T extends a> {

    /* renamed from: h  reason: collision with root package name */
    public static int f49722h = 1;

    /* renamed from: a  reason: collision with root package name */
    public final int f49723a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f49724b;

    /* renamed from: c  reason: collision with root package name */
    public Editable f49725c;

    /* renamed from: d  reason: collision with root package name */
    public int f49726d;

    /* renamed from: e  reason: collision with root package name */
    public int f49727e;

    /* renamed from: f  reason: collision with root package name */
    public int f49728f;

    /* renamed from: g  reason: collision with root package name */
    public InterfaceC1127a f49729g;

    /* renamed from: d.a.j0.r.f0.p.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC1127a {
        void a(int i2, boolean z);
    }

    public a() {
        int i2 = f49722h;
        f49722h = i2 + 1;
        this.f49723a = i2;
    }

    public void a(Editable editable, int i2, int i3, int i4) {
        this.f49725c = editable;
        this.f49726d = i2;
        this.f49727e = i3;
        this.f49728f = i4;
    }

    public void b(T t) {
        this.f49724b = t.h();
        this.f49725c = t.g();
        this.f49726d = t.f();
        this.f49727e = t.c();
        this.f49728f = t.d();
    }

    public int c() {
        return this.f49727e;
    }

    public int d() {
        return this.f49728f;
    }

    public int e() {
        return this.f49723a;
    }

    public int f() {
        return this.f49726d;
    }

    public Editable g() {
        return this.f49725c;
    }

    public boolean h() {
        return this.f49724b;
    }

    public void i(@NonNull CharSequence charSequence) {
        Editable editable = this.f49725c;
        if (editable == null || charSequence == null) {
            return;
        }
        try {
            editable.replace(this.f49726d, this.f49727e, charSequence);
        } catch (Exception e2) {
            BdLog.e(e2);
        }
        this.f49727e = this.f49726d + charSequence.length();
    }

    public void j(int i2) {
        this.f49727e = i2;
    }

    public void k(InterfaceC1127a interfaceC1127a) {
        this.f49729g = interfaceC1127a;
    }

    public void l(Object obj, int i2, int i3, int i4) {
        Editable editable = this.f49725c;
        if (editable == null) {
            return;
        }
        editable.setSpan(obj, i2, i3, i4);
    }

    public void m(int i2) {
        this.f49726d = i2;
    }

    public void n(Editable editable) {
        this.f49725c = editable;
    }

    public void o(boolean z) {
        InterfaceC1127a interfaceC1127a;
        boolean z2 = this.f49724b;
        this.f49724b = z;
        if (z2 == z || (interfaceC1127a = this.f49729g) == null) {
            return;
        }
        interfaceC1127a.a(this.f49723a, z);
    }

    public abstract void p(Editable editable);

    public abstract void q(Editable editable, int i2);
}
