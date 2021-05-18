package d.a.k0.d2.k.e.c1;

import android.view.View;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.OriginalThreadInfo;
import d.a.i.a;
import d.a.k0.x.b0;
/* loaded from: classes5.dex */
public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f52965a;

    /* renamed from: b  reason: collision with root package name */
    public b0 f52966b;

    /* renamed from: c  reason: collision with root package name */
    public a.InterfaceC0547a f52967c;

    /* renamed from: d  reason: collision with root package name */
    public OriginalThreadInfo f52968d;

    /* renamed from: e  reason: collision with root package name */
    public int f52969e = 3;

    public a(TbPageContext tbPageContext) {
        this.f52965a = tbPageContext;
    }

    public abstract View a();

    public abstract void b(TbPageContext tbPageContext, int i2);

    public abstract void c(OriginalThreadInfo originalThreadInfo);

    public void d(a.InterfaceC0547a interfaceC0547a) {
        this.f52967c = interfaceC0547a;
    }

    public void e(b0 b0Var) {
        this.f52966b = b0Var;
    }
}
