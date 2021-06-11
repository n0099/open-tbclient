package d.a.n0.o0.a;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.RemoveFansController;
import com.baidu.tieba.R;
import d.a.n0.o0.a.c;
import d.a.n0.v3.a;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f61462a;

    /* renamed from: b  reason: collision with root package name */
    public RemoveFansController f61463b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.o0.a.c f61464c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.g2.e f61465d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.v3.a f61466e;

    /* renamed from: f  reason: collision with root package name */
    public e f61467f;

    /* loaded from: classes4.dex */
    public class a implements c.b {
        public a() {
        }

        @Override // d.a.n0.o0.a.c.b
        public void a(int i2, String str, boolean z) {
            if (d.this.f61467f != null) {
                d.this.f61467f.b(i2, str, z, 0, 0L);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements RemoveFansController.IResultCallBack {
        public b() {
        }

        @Override // com.baidu.tbadk.core.util.RemoveFansController.IResultCallBack
        public void onResultCallBack(int i2, String str, long j, boolean z) {
            if (d.this.f61467f != null) {
                d.this.f61467f.b(i2, str, z, 1, j);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.d {
        public c() {
        }

        @Override // d.a.n0.v3.a.d
        public void onClick() {
            d.this.f61465d.dismiss();
            if (d.this.f61467f != null) {
                d.this.f61467f.a();
            }
            d.this.f61464c.d();
        }
    }

    /* renamed from: d.a.n0.o0.a.d$d  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1505d implements a.c {
        public C1505d() {
        }

        @Override // d.a.n0.v3.a.c
        public void onClick() {
            if (d.this.f61465d == null) {
                return;
            }
            d.this.f61465d.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface e {
        void a();

        void b(int i2, String str, boolean z, int i3, long j);
    }

    public d(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        this.f61462a = tbPageContext;
        d.a.n0.o0.a.c cVar = new d.a.n0.o0.a.c(tbPageContext, bdUniqueId);
        this.f61464c = cVar;
        cVar.e(new a());
        RemoveFansController removeFansController = new RemoveFansController(tbPageContext, bdUniqueId);
        this.f61463b = removeFansController;
        removeFansController.setResultCallBack(new b());
    }

    public void d() {
        d.a.n0.v3.a aVar = this.f61466e;
        if (aVar != null) {
            aVar.f();
        }
    }

    public void e() {
        h();
    }

    public void f(long j) {
        this.f61463b.removeFans(j);
    }

    public void g(e eVar) {
        this.f61467f = eVar;
    }

    public final void h() {
        if (this.f61465d == null) {
            d.a.n0.v3.a aVar = new d.a.n0.v3.a(this.f61462a.getContext());
            this.f61466e = aVar;
            aVar.i(this.f61462a.getString(R.string.confirm_remove_all_forbidden_fans));
            ArrayList arrayList = new ArrayList();
            a.b bVar = new a.b(this.f61462a.getString(R.string.confirm), this.f61466e);
            bVar.h(new c());
            arrayList.add(bVar);
            this.f61466e.h(new C1505d());
            this.f61466e.g(arrayList);
            d.a.n0.g2.e eVar = new d.a.n0.g2.e(this.f61462a.getPageActivity(), this.f61466e.b());
            this.f61465d = eVar;
            eVar.a(0.7f);
        }
        this.f61465d.show();
    }
}
