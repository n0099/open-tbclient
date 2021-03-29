package d.b.i0.v1.g;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.myCollection.baseEditMark.MarkModel;
import d.b.h0.h.a;
/* loaded from: classes3.dex */
public class b extends d.b.h0.h.a {

    /* renamed from: a  reason: collision with root package name */
    public MarkModel f62034a;

    public b(BaseActivity baseActivity) {
        this.f62034a = null;
        this.f62034a = new MarkModel(baseActivity);
    }

    @Override // d.b.h0.h.a
    public void a() {
        this.f62034a.v();
    }

    @Override // d.b.h0.h.a
    public void d() {
        this.f62034a.w();
    }

    @Override // d.b.h0.h.a
    public boolean e() {
        return this.f62034a.x();
    }

    @Override // d.b.h0.h.a
    public MarkData f() {
        return this.f62034a.y();
    }

    @Override // d.b.h0.h.a
    public String g() {
        return this.f62034a.z();
    }

    @Override // d.b.h0.h.a
    public void h(boolean z) {
        this.f62034a.A(z);
    }

    @Override // d.b.h0.h.a
    public void i(MarkData markData) {
        this.f62034a.B(markData);
    }

    @Override // d.b.h0.h.a
    public void j(a.InterfaceC1065a interfaceC1065a) {
        this.f62034a.C(interfaceC1065a);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f62034a = null;
        this.f62034a = new MarkModel(baseFragmentActivity);
    }
}
