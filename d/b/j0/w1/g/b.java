package d.b.j0.w1.g;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.myCollection.baseEditMark.MarkModel;
import d.b.i0.h.a;
/* loaded from: classes3.dex */
public class b extends d.b.i0.h.a {

    /* renamed from: a  reason: collision with root package name */
    public MarkModel f64121a;

    public b(BaseActivity baseActivity) {
        this.f64121a = null;
        this.f64121a = new MarkModel(baseActivity);
    }

    @Override // d.b.i0.h.a
    public void a() {
        this.f64121a.v();
    }

    @Override // d.b.i0.h.a
    public void d() {
        this.f64121a.w();
    }

    @Override // d.b.i0.h.a
    public boolean e() {
        return this.f64121a.x();
    }

    @Override // d.b.i0.h.a
    public MarkData f() {
        return this.f64121a.y();
    }

    @Override // d.b.i0.h.a
    public String g() {
        return this.f64121a.z();
    }

    @Override // d.b.i0.h.a
    public void h(boolean z) {
        this.f64121a.A(z);
    }

    @Override // d.b.i0.h.a
    public void i(MarkData markData) {
        this.f64121a.B(markData);
    }

    @Override // d.b.i0.h.a
    public void j(a.InterfaceC1100a interfaceC1100a) {
        this.f64121a.C(interfaceC1100a);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f64121a = null;
        this.f64121a = new MarkModel(baseFragmentActivity);
    }
}
