package d.b.i0.p0.f2.a;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.MembercenterActivityConfig;
import com.baidu.tbadk.mvc.message.MvcHttpMessage;
import com.baidu.tbadk.mvc.message.MvcHttpResponsedMessage;
import com.baidu.tbadk.mvc.message.MvcNetMessage;
import com.baidu.tbadk.mvc.message.MvcSocketMessage;
import com.baidu.tbadk.mvc.message.MvcSocketResponsedMessage;
import com.baidu.tbadk.mvc.model.NetModel;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.profession.permission.FrsProfessionPermissionModel;
import d.b.h0.r.s.a;
/* loaded from: classes4.dex */
public class c implements NetModel.k {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f57505e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f57506f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.p0.f2.a.a f57507g;

    /* renamed from: h  reason: collision with root package name */
    public d f57508h;
    public int i;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57509e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f57510f;

        public a(String str, d.b.h0.r.s.a aVar) {
            this.f57509e = str;
            this.f57510f = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.f57505e.getPageActivity());
            membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f57509e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            this.f57510f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f57512e;

        public b(c cVar, d.b.h0.r.s.a aVar) {
            this.f57512e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f57512e.dismiss();
        }
    }

    /* renamed from: d.b.i0.p0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1385c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f57513e;

        public C1385c(c cVar, d.b.h0.r.s.a aVar) {
            this.f57513e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f57513e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f57505e = tbPageContext;
        d.b.i0.p0.f2.a.a aVar = new d.b.i0.p0.f2.a.a();
        this.f57507g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f57506f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.V(this);
    }

    public final void b(d.b.i0.p0.f2.a.b bVar) {
        if (bVar != null && bVar.f57502f == 0) {
            if (!bVar.f57501e && bVar.f57504h == 2) {
                m(bVar.i);
            }
            d dVar = this.f57508h;
            if (dVar != null) {
                dVar.c(bVar.f57501e);
            }
        }
    }

    public final void c(d.b.i0.p0.f2.a.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (bVar.f57502f != 0) {
            if (StringUtils.isNull(bVar.f57503g)) {
                this.f57505e.showToast(R.string.neterror);
                return;
            } else {
                this.f57505e.showToast(bVar.f57503g);
                return;
            }
        }
        if (!bVar.f57501e) {
            int i = bVar.f57504h;
            if (i == 1) {
                l(bVar.i, str);
            } else if (i == 3) {
                m(bVar.i);
            }
        }
        d dVar = this.f57508h;
        if (dVar != null) {
            dVar.b(bVar.f57501e);
        }
    }

    public final void d(d.b.i0.p0.f2.a.b bVar, int i) {
        if (bVar == null) {
            return;
        }
        if (bVar.f57502f != 0) {
            if (StringUtils.isNull(bVar.f57503g)) {
                this.f57505e.showToast(R.string.neterror);
                return;
            } else {
                this.f57505e.showToast(bVar.f57503g);
                return;
            }
        }
        d dVar = this.f57508h;
        if (dVar != null) {
            dVar.a(bVar.f57501e, i);
        }
    }

    public final void e() {
        if (this.f57506f.M()) {
            return;
        }
        this.f57506f.N();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void f(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.b.i0.p0.f2.a.a) || mvcHttpResponsedMessage == null || !(mvcHttpResponsedMessage.getData() instanceof d.b.i0.p0.f2.a.b)) {
            return;
        }
        d.b.i0.p0.f2.a.a aVar = (d.b.i0.p0.f2.a.a) mvcNetMessage.getRequestData();
        d.b.i0.p0.f2.a.b bVar = (d.b.i0.p0.f2.a.b) mvcHttpResponsedMessage.getData();
        if (aVar.i != this.i) {
            return;
        }
        int i = aVar.f57500h;
        if (i == 1) {
            b(bVar);
        } else if (i == 2) {
            d(bVar, aVar.f57497e);
        } else if (i != 3) {
        } else {
            c(bVar, aVar.f57499g);
        }
    }

    public void g(String str) {
        d.b.i0.p0.f2.a.a aVar = this.f57507g;
        aVar.f57500h = 1;
        aVar.f57499g = str;
        e();
    }

    public void h(String str, long j) {
        d.b.i0.p0.f2.a.a aVar = this.f57507g;
        aVar.f57499g = str;
        aVar.f57498f = j;
        aVar.f57500h = 3;
        e();
    }

    public void i(String str, int i) {
        d.b.i0.p0.f2.a.a aVar = this.f57507g;
        aVar.f57497e = i;
        aVar.f57499g = str;
        aVar.f57500h = 2;
        e();
    }

    public void j(d dVar) {
        this.f57508h = dVar;
    }

    public void k(int i) {
        this.i = i;
        this.f57507g.i = i;
    }

    public final void l(String str, String str2) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57505e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.comfirm_imediate, new a(str2, aVar));
        aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
        aVar.create(this.f57505e);
        aVar.show();
    }

    public void m(String str) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57505e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new C1385c(this, aVar));
        aVar.create(this.f57505e);
        aVar.show();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.b.i0.p0.f2.a.a) || mvcSocketResponsedMessage == null || !(mvcSocketResponsedMessage.getData() instanceof d.b.i0.p0.f2.a.b)) {
            return;
        }
        d.b.i0.p0.f2.a.a aVar = (d.b.i0.p0.f2.a.a) mvcNetMessage.getRequestData();
        d.b.i0.p0.f2.a.b bVar = (d.b.i0.p0.f2.a.b) mvcSocketResponsedMessage.getData();
        if (aVar.i != this.i) {
            return;
        }
        int i = aVar.f57500h;
        if (i == 1) {
            b(bVar);
        } else if (i == 2) {
            d(bVar, aVar.f57497e);
        } else if (i != 3) {
        } else {
            c(bVar, aVar.f57499g);
        }
    }
}
