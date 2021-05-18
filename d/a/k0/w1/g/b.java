package d.a.k0.w1.g;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.myCollection.baseEditMark.MarkModel;
import d.a.j0.h.a;
/* loaded from: classes3.dex */
public class b extends d.a.j0.h.a {

    /* renamed from: a  reason: collision with root package name */
    public MarkModel f63099a;

    public b(BaseActivity baseActivity) {
        this.f63099a = null;
        this.f63099a = new MarkModel(baseActivity);
    }

    @Override // d.a.j0.h.a
    public void a() {
        this.f63099a.v();
    }

    @Override // d.a.j0.h.a
    public void d() {
        this.f63099a.w();
    }

    @Override // d.a.j0.h.a
    public boolean e() {
        return this.f63099a.x();
    }

    @Override // d.a.j0.h.a
    public MarkData f() {
        return this.f63099a.y();
    }

    @Override // d.a.j0.h.a
    public String g() {
        return this.f63099a.z();
    }

    @Override // d.a.j0.h.a
    public void h(boolean z) {
        this.f63099a.A(z);
    }

    @Override // d.a.j0.h.a
    public void i(MarkData markData) {
        this.f63099a.B(markData);
    }

    @Override // d.a.j0.h.a
    public void j(a.InterfaceC1115a interfaceC1115a) {
        this.f63099a.C(interfaceC1115a);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f63099a = null;
        this.f63099a = new MarkModel(baseFragmentActivity);
    }
}
