package d.b.i0.c2.k.e.a1;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import d.b.i.a;
import d.b.i0.x.b0;
/* loaded from: classes4.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52564a;

    /* renamed from: b  reason: collision with root package name */
    public b0 f52565b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1115a f52566c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f52567d;

    /* renamed from: e  reason: collision with root package name */
    public int f52568e = 3;

    public a(TbPageContext tbPageContext) {
        this.f52564a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC1115a interfaceC1115a) {
        this.f52566c = interfaceC1115a;
    }

    public void e(b0 b0Var) {
        this.f52565b = b0Var;
    }
}
