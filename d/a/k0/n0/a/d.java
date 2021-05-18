package d.a.k0.n0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.R;
import d.a.k0.n0.a.c;
import d.a.k0.u3.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57601a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f57602b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.k0.n0.a.c f57603c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.k0.f2.e f57604d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.k0.u3.a f57605e;

    /* renamed from: f  reason: collision with root package name */
    public e f57606f;

    /* loaded from: classes4.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // d.a.k0.n0.a.c.b
        public void a(int i2, String str, boolean z) {
            if (d.this.f57606f != null) {
                d.this.f57606f.b(i2, str, z, 0, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public b() {
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j, boolean z) {
            if (d.this.f57606f != null) {
                d.this.f57606f.b(i2, str, z, 1, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.d {
        public c() {
        }

        @Override // d.a.k0.u3.a.d
        public void onClick() {
            d.this.f57604d.dismiss();
            if (d.this.f57606f != null) {
                d.this.f57606f.a();
            }
            d.this.f57603c.d();
        }
    }

    /* renamed from: d.a.k0.n0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1433d implements a.c {
        public C1433d() {
        }

        @Override // d.a.k0.u3.a.c
        public void onClick() {
            if (d.this.f57604d == null) {
                return;
            }
            d.this.f57604d.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b(int i2, String str, boolean z, int i3, long j);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f57601a = tbPageContext;
        d.a.k0.n0.a.c cVar = new d.a.k0.n0.a.c(tbPageContext, bdUniqueId);
        this.f57603c = cVar;
        cVar.e(new a());
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f57602b = removeFansController;
        removeFansController.setResultCallBack(new b());
    }

    public void d() {
        d.a.k0.u3.a aVar = this.f57605e;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void e() {
        h();
    }

    public void f(long j) {
        this.f57602b.removeFans(j);
    }

    public void g(e eVar) {
        this.f57606f = eVar;
    }

    public final void h() {
        if (this.f57604d == null) {
            d.a.k0.u3.a aVar = new d.a.k0.u3.a(this.f57601a.getContext());
            this.f57605e = aVar;
            aVar.i(this.f57601a.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.b bVar = new a.b(this.f57601a.getString(R.string.confirm), this.f57605e);
            bVar.h(new c());
            arrayList.add(bVar);
            this.f57605e.h(new C1433d());
            this.f57605e.g(arrayList);
            d.a.k0.f2.e eVar = new d.a.k0.f2.e(this.f57601a.getPageActivity(), this.f57605e.b());
            this.f57604d = eVar;
            eVar.a(0.7f);
        }
        this.f57604d.show();
    }
}
