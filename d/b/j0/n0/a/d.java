package d.b.j0.n0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.R;
import d.b.j0.n0.a.c;
import d.b.j0.u3.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58879a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f58880b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.j0.n0.a.c f58881c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.j0.f2.e f58882d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.j0.u3.a f58883e;

    /* renamed from: f  reason: collision with root package name */
    public e f58884f;

    /* loaded from: classes4.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // d.b.j0.n0.a.c.b
        public void a(int i, String str, boolean z) {
            if (d.this.f58884f != null) {
                d.this.f58884f.b(i, str, z, 0, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public b() {
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            if (d.this.f58884f != null) {
                d.this.f58884f.b(i, str, z, 1, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.d {
        public c() {
        }

        @Override // d.b.j0.u3.a.d
        public void onClick() {
            d.this.f58882d.dismiss();
            if (d.this.f58884f != null) {
                d.this.f58884f.a();
            }
            d.this.f58881c.d();
        }
    }

    /* renamed from: d.b.j0.n0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1422d implements a.c {
        public C1422d() {
        }

        @Override // d.b.j0.u3.a.c
        public void onClick() {
            if (d.this.f58882d == null) {
                return;
            }
            d.this.f58882d.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b(int i, String str, boolean z, int i2, long j);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f58879a = tbPageContext;
        d.b.j0.n0.a.c cVar = new d.b.j0.n0.a.c(tbPageContext, bdUniqueId);
        this.f58881c = cVar;
        cVar.e(new a());
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f58880b = removeFansController;
        removeFansController.setResultCallBack(new b());
    }

    public void d() {
        d.b.j0.u3.a aVar = this.f58883e;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void e() {
        h();
    }

    public void f(long j) {
        this.f58880b.removeFans(j);
    }

    public void g(e eVar) {
        this.f58884f = eVar;
    }

    public final void h() {
        if (this.f58882d == null) {
            d.b.j0.u3.a aVar = new d.b.j0.u3.a(this.f58879a.getContext());
            this.f58883e = aVar;
            aVar.i(this.f58879a.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.b bVar = new a.b(this.f58879a.getString(R.string.confirm), this.f58883e);
            bVar.h(new c());
            arrayList.add(bVar);
            this.f58883e.h(new C1422d());
            this.f58883e.g(arrayList);
            d.b.j0.f2.e eVar = new d.b.j0.f2.e(this.f58879a.getPageActivity(), this.f58883e.b());
            this.f58882d = eVar;
            eVar.a(0.7f);
        }
        this.f58882d.show();
    }
}
