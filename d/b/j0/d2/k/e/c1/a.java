package d.b.j0.d2.k.e.c1;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import d.b.i.a;
import d.b.j0.x.b0;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f54471a;

    /* renamed from: b  reason: collision with root package name */
    public b0 f54472b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1070a f54473c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f54474d;

    /* renamed from: e  reason: collision with root package name */
    public int f54475e = 3;

    public a(TbPageContext tbPageContext) {
        this.f54471a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC1070a interfaceC1070a) {
        this.f54473c = interfaceC1070a;
    }

    public void e(b0 b0Var) {
        this.f54472b = b0Var;
    }
}
