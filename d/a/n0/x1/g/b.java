package d.a.n0.x1.g;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.myCollection.baseEditMark.MarkModel;
import d.a.m0.h.a;
/* loaded from: classes4.dex */
public class b extends d.a.m0.h.a {

    /* renamed from: a  reason: collision with root package name */
    public MarkModel f66999a;

    public b(BaseActivity baseActivity) {
        this.f66999a = null;
        this.f66999a = new MarkModel(baseActivity);
    }

    @Override // d.a.m0.h.a
    public void a() {
        this.f66999a.z();
    }

    @Override // d.a.m0.h.a
    public void d() {
        this.f66999a.A();
    }

    @Override // d.a.m0.h.a
    public boolean e() {
        return this.f66999a.B();
    }

    @Override // d.a.m0.h.a
    public MarkData f() {
        return this.f66999a.C();
    }

    @Override // d.a.m0.h.a
    public String g() {
        return this.f66999a.D();
    }

    @Override // d.a.m0.h.a
    public void h(boolean z) {
        this.f66999a.E(z);
    }

    @Override // d.a.m0.h.a
    public void i(MarkData markData) {
        this.f66999a.F(markData);
    }

    @Override // d.a.m0.h.a
    public void j(a.InterfaceC1180a interfaceC1180a) {
        this.f66999a.G(interfaceC1180a);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f66999a = null;
        this.f66999a = new MarkModel(baseFragmentActivity);
    }
}
