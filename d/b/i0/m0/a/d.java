package d.b.i0.m0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.R;
import d.b.i0.m0.a.c;
import d.b.i0.t3.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56821a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f56822b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.m0.a.c f56823c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.e2.e f56824d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.t3.a f56825e;

    /* renamed from: f  reason: collision with root package name */
    public e f56826f;

    /* loaded from: classes4.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // d.b.i0.m0.a.c.b
        public void a(int i, String str, boolean z) {
            if (d.this.f56826f != null) {
                d.this.f56826f.b(i, str, z, 0, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public b() {
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i, String str, long j, boolean z) {
            if (d.this.f56826f != null) {
                d.this.f56826f.b(i, str, z, 1, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.d {
        public c() {
        }

        @Override // d.b.i0.t3.a.d
        public void onClick() {
            d.this.f56824d.dismiss();
            if (d.this.f56826f != null) {
                d.this.f56826f.a();
            }
            d.this.f56823c.d();
        }
    }

    /* renamed from: d.b.i0.m0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1341d implements a.c {
        public C1341d() {
        }

        @Override // d.b.i0.t3.a.c
        public void onClick() {
            if (d.this.f56824d == null) {
                return;
            }
            d.this.f56824d.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b(int i, String str, boolean z, int i2, long j);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56821a = tbPageContext;
        d.b.i0.m0.a.c cVar = new d.b.i0.m0.a.c(tbPageContext, bdUniqueId);
        this.f56823c = cVar;
        cVar.e(new a());
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f56822b = removeFansController;
        removeFansController.setResultCallBack(new b());
    }

    public void d() {
        d.b.i0.t3.a aVar = this.f56825e;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void e() {
        h();
    }

    public void f(long j) {
        this.f56822b.removeFans(j);
    }

    public void g(e eVar) {
        this.f56826f = eVar;
    }

    public final void h() {
        if (this.f56824d == null) {
            d.b.i0.t3.a aVar = new d.b.i0.t3.a(this.f56821a.getContext());
            this.f56825e = aVar;
            aVar.i(this.f56821a.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.b bVar = new a.b(this.f56821a.getString(R.string.confirm), this.f56825e);
            bVar.h(new c());
            arrayList.add(bVar);
            this.f56825e.h(new C1341d());
            this.f56825e.g(arrayList);
            d.b.i0.e2.e eVar = new d.b.i0.e2.e(this.f56821a.getPageActivity(), this.f56825e.b());
            this.f56824d = eVar;
            eVar.a(0.7f);
        }
        this.f56824d.show();
    }
}
