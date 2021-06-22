package d.a.o0.x1.g;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.myCollection.baseEditMark.MarkModel;
import d.a.n0.h.a;
/* loaded from: classes4.dex */
public class b extends d.a.n0.h.a {

    /* renamed from: a  reason: collision with root package name */
    public MarkModel f67124a;

    public b(BaseActivity baseActivity) {
        this.f67124a = null;
        this.f67124a = new MarkModel(baseActivity);
    }

    @Override // d.a.n0.h.a
    public void a() {
        this.f67124a.z();
    }

    @Override // d.a.n0.h.a
    public void d() {
        this.f67124a.A();
    }

    @Override // d.a.n0.h.a
    public boolean e() {
        return this.f67124a.B();
    }

    @Override // d.a.n0.h.a
    public MarkData f() {
        return this.f67124a.C();
    }

    @Override // d.a.n0.h.a
    public String g() {
        return this.f67124a.D();
    }

    @Override // d.a.n0.h.a
    public void h(boolean z) {
        this.f67124a.E(z);
    }

    @Override // d.a.n0.h.a
    public void i(MarkData markData) {
        this.f67124a.F(markData);
    }

    @Override // d.a.n0.h.a
    public void j(a.InterfaceC1183a interfaceC1183a) {
        this.f67124a.G(interfaceC1183a);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f67124a = null;
        this.f67124a = new MarkModel(baseFragmentActivity);
    }
}
