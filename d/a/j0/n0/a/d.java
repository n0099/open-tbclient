package d.a.j0.n0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.R;
import d.a.j0.n0.a.c;
import d.a.j0.u3.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f56894a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f56895b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.j0.n0.a.c f56896c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.j0.f2.e f56897d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.j0.u3.a f56898e;

    /* renamed from: f  reason: collision with root package name */
    public e f56899f;

    /* loaded from: classes4.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // d.a.j0.n0.a.c.b
        public void a(int i2, String str, boolean z) {
            if (d.this.f56899f != null) {
                d.this.f56899f.b(i2, str, z, 0, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public b() {
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j, boolean z) {
            if (d.this.f56899f != null) {
                d.this.f56899f.b(i2, str, z, 1, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.d {
        public c() {
        }

        @Override // d.a.j0.u3.a.d
        public void onClick() {
            d.this.f56897d.dismiss();
            if (d.this.f56899f != null) {
                d.this.f56899f.a();
            }
            d.this.f56896c.d();
        }
    }

    /* renamed from: d.a.j0.n0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1361d implements a.c {
        public C1361d() {
        }

        @Override // d.a.j0.u3.a.c
        public void onClick() {
            if (d.this.f56897d == null) {
                return;
            }
            d.this.f56897d.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b(int i2, String str, boolean z, int i3, long j);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f56894a = tbPageContext;
        d.a.j0.n0.a.c cVar = new d.a.j0.n0.a.c(tbPageContext, bdUniqueId);
        this.f56896c = cVar;
        cVar.e(new a());
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f56895b = removeFansController;
        removeFansController.setResultCallBack(new b());
    }

    public void d() {
        d.a.j0.u3.a aVar = this.f56898e;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void e() {
        h();
    }

    public void f(long j) {
        this.f56895b.removeFans(j);
    }

    public void g(e eVar) {
        this.f56899f = eVar;
    }

    public final void h() {
        if (this.f56897d == null) {
            d.a.j0.u3.a aVar = new d.a.j0.u3.a(this.f56894a.getContext());
            this.f56898e = aVar;
            aVar.i(this.f56894a.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.b bVar = new a.b(this.f56894a.getString(R.string.confirm), this.f56898e);
            bVar.h(new c());
            arrayList.add(bVar);
            this.f56898e.h(new C1361d());
            this.f56898e.g(arrayList);
            d.a.j0.f2.e eVar = new d.a.j0.f2.e(this.f56894a.getPageActivity(), this.f56898e.b());
            this.f56897d = eVar;
            eVar.a(0.7f);
        }
        this.f56897d.show();
    }
}
