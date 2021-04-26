package d.a.j0.w1.g;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.baseEditMark.MarkData;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.myCollection.baseEditMark.MarkModel;
import d.a.i0.h.a;
/* loaded from: classes3.dex */
public class b extends d.a.i0.h.a {

    /* renamed from: a  reason: collision with root package name */
    public MarkModel f62375a;

    public b(BaseActivity baseActivity) {
        this.f62375a = null;
        this.f62375a = new MarkModel(baseActivity);
    }

    @Override // d.a.i0.h.a
    public void a() {
        this.f62375a.v();
    }

    @Override // d.a.i0.h.a
    public void d() {
        this.f62375a.w();
    }

    @Override // d.a.i0.h.a
    public boolean e() {
        return this.f62375a.x();
    }

    @Override // d.a.i0.h.a
    public MarkData f() {
        return this.f62375a.y();
    }

    @Override // d.a.i0.h.a
    public String g() {
        return this.f62375a.z();
    }

    @Override // d.a.i0.h.a
    public void h(boolean z) {
        this.f62375a.A(z);
    }

    @Override // d.a.i0.h.a
    public void i(MarkData markData) {
        this.f62375a.B(markData);
    }

    @Override // d.a.i0.h.a
    public void j(a.InterfaceC1039a interfaceC1039a) {
        this.f62375a.C(interfaceC1039a);
    }

    public b(BaseFragmentActivity baseFragmentActivity) {
        this.f62375a = null;
        this.f62375a = new MarkModel(baseFragmentActivity);
    }
}
