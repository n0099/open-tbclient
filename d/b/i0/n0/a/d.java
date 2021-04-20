package d.b.i0.n0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.R;
import d.b.i0.n0.a.c;
import d.b.i0.u3.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58458a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f58459b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.n0.a.c f58460c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.f2.e f58461d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.u3.a f58462e;

    /* renamed from: f  reason: collision with root package name */
    public e f58463f;

    /* loaded from: classes4.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // d.b.i0.n0.a.c.b
        public void a(int i, String str, boolean z) {
            if (d.this.f58463f != null) {
                d.this.f58463f.b(i, str, z, 0, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public b() {
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            if (d.this.f58463f != null) {
                d.this.f58463f.b(i, str, z, 1, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.d {
        public c() {
        }

        @Override // d.b.i0.u3.a.d
        public void onClick() {
            d.this.f58461d.dismiss();
            if (d.this.f58463f != null) {
                d.this.f58463f.a();
            }
            d.this.f58460c.d();
        }
    }

    /* renamed from: d.b.i0.n0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1399d implements a.c {
        public C1399d() {
        }

        @Override // d.b.i0.u3.a.c
        public void onClick() {
            if (d.this.f58461d == null) {
                return;
            }
            d.this.f58461d.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b(int i, String str, boolean z, int i2, long j);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f58458a = tbPageContext;
        d.b.i0.n0.a.c cVar = new d.b.i0.n0.a.c(tbPageContext, bdUniqueId);
        this.f58460c = cVar;
        cVar.e(new a());
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f58459b = removeFansController;
        removeFansController.setResultCallBack(new b());
    }

    public void d() {
        d.b.i0.u3.a aVar = this.f58462e;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void e() {
        h();
    }

    public void f(long j) {
        this.f58459b.removeFans(j);
    }

    public void g(e eVar) {
        this.f58463f = eVar;
    }

    public final void h() {
        if (this.f58461d == null) {
            d.b.i0.u3.a aVar = new d.b.i0.u3.a(this.f58458a.getContext());
            this.f58462e = aVar;
            aVar.i(this.f58458a.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.b bVar = new a.b(this.f58458a.getString(R.string.confirm), this.f58462e);
            bVar.h(new c());
            arrayList.add(bVar);
            this.f58462e.h(new C1399d());
            this.f58462e.g(arrayList);
            d.b.i0.f2.e eVar = new d.b.i0.f2.e(this.f58458a.getPageActivity(), this.f58462e.b());
            this.f58461d = eVar;
            eVar.a(0.7f);
        }
        this.f58461d.show();
    }
}
