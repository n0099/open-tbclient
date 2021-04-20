package d.b.i0.d2.k.e.c1;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import d.b.i.a;
import d.b.i0.x.b0;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54050a;

    /* renamed from: b  reason: collision with root package name */
    public b0 f54051b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1129a f54052c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f54053d;

    /* renamed from: e  reason: collision with root package name */
    public int f54054e = 3;

    public a(TbPageContext tbPageContext) {
        this.f54050a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC1129a interfaceC1129a) {
        this.f54052c = interfaceC1129a;
    }

    public void e(b0 b0Var) {
        this.f54051b = b0Var;
    }
}
