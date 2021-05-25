package d.a.n0.x1.g;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.myCollection.baseEditMark.MarkModel;
import d.a.m0.h.a;
/* loaded from: classes3.dex */
public class b extends d.a.m0.h.a {

    /* renamed from: a  reason: collision with root package name */
    public MarkModel f63284a;

    public b(BaseActivity baseActivity) {
        this.f63284a = null;
        this.f63284a = new MarkModel(baseActivity);
    }

    @Override // d.a.m0.h.a
    public void a() {
        this.f63284a.v();
    }

    @Override // d.a.m0.h.a
    public void d() {
        this.f63284a.w();
    }

    @Override // d.a.m0.h.a
    public boolean e() {
        return this.f63284a.x();
    }

    @Override // d.a.m0.h.a
    public MarkData f() {
        return this.f63284a.y();
    }

    @Override // d.a.m0.h.a
    public String g() {
        return this.f63284a.z();
    }

    @Override // d.a.m0.h.a
    public void h(boolean z) {
        this.f63284a.A(z);
    }

    @Override // d.a.m0.h.a
    public void i(MarkData markData) {
        this.f63284a.B(markData);
    }

    @Override // d.a.m0.h.a
    public void j(a.InterfaceC1124a interfaceC1124a) {
        this.f63284a.C(interfaceC1124a);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f63284a = null;
        this.f63284a = new MarkModel(baseFragmentActivity);
    }
}
