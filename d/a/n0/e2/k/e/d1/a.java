package d.a.n0.e2.k.e.d1;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import d.a.i.a;
import d.a.n0.z.b0;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56914a;

    /* renamed from: b  reason: collision with root package name */
    public b0 f56915b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0598a f56916c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f56917d;

    /* renamed from: e  reason: collision with root package name */
    public int f56918e = 3;

    public a(TbPageContext tbPageContext) {
        this.f56914a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i2);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC0598a interfaceC0598a) {
        this.f56916c = interfaceC0598a;
    }

    public void e(b0 b0Var) {
        this.f56915b = b0Var;
    }
}
