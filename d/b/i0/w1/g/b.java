package d.b.i0.w1.g;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.myCollection.baseEditMark.MarkModel;
import d.b.h0.h.a;
/* loaded from: classes3.dex */
public class b extends d.b.h0.h.a {

    /* renamed from: a  reason: collision with root package name */
    public MarkModel f63700a;

    public b(BaseActivity baseActivity) {
        this.f63700a = null;
        this.f63700a = new MarkModel(baseActivity);
    }

    @Override // d.b.h0.h.a
    public void a() {
        this.f63700a.v();
    }

    @Override // d.b.h0.h.a
    public void d() {
        this.f63700a.w();
    }

    @Override // d.b.h0.h.a
    public boolean e() {
        return this.f63700a.x();
    }

    @Override // d.b.h0.h.a
    public MarkData f() {
        return this.f63700a.y();
    }

    @Override // d.b.h0.h.a
    public String g() {
        return this.f63700a.z();
    }

    @Override // d.b.h0.h.a
    public void h(boolean z) {
        this.f63700a.A(z);
    }

    @Override // d.b.h0.h.a
    public void i(MarkData markData) {
        this.f63700a.B(markData);
    }

    @Override // d.b.h0.h.a
    public void j(a.InterfaceC1078a interfaceC1078a) {
        this.f63700a.C(interfaceC1078a);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f63700a = null;
        this.f63700a = new MarkModel(baseFragmentActivity);
    }
}
