package d.a.j0.d2.k.e.c1;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import d.a.i.a;
import d.a.j0.x.b0;
/* loaded from: classes3.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52266a;

    /* renamed from: b  reason: collision with root package name */
    public b0 f52267b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC1009a f52268c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f52269d;

    /* renamed from: e  reason: collision with root package name */
    public int f52270e = 3;

    public a(TbPageContext tbPageContext) {
        this.f52266a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i2);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC1009a interfaceC1009a) {
        this.f52268c = interfaceC1009a;
    }

    public void e(b0 b0Var) {
        this.f52267b = b0Var;
    }
}
