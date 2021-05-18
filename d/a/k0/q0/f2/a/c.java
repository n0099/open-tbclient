package d.a.k0.q0.f2.a;

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
import d.a.j0.r.s.a;
/* loaded from: classes4.dex */
public class c implements NetModel.k {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f58426e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f58427f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.k0.q0.f2.a.a f58428g;

    /* renamed from: h  reason: collision with root package name */
    public d f58429h;

    /* renamed from: i  reason: collision with root package name */
    public int f58430i;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58431e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f58432f;

        public a(String str, d.a.j0.r.s.a aVar) {
            this.f58431e = str;
            this.f58432f = aVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.f58426e.getPageActivity());
            membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f58431e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            this.f58432f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f58434e;

        public b(c cVar, d.a.j0.r.s.a aVar) {
            this.f58434e = aVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f58434e.dismiss();
        }
    }

    /* renamed from: d.a.k0.q0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1483c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f58435e;

        public C1483c(c cVar, d.a.j0.r.s.a aVar) {
            this.f58435e = aVar;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            this.f58435e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i2);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f58426e = tbPageContext;
        d.a.k0.q0.f2.a.a aVar = new d.a.k0.q0.f2.a.a();
        this.f58428g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f58427f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.V(this);
    }

    public final void b(d.a.k0.q0.f2.a.b bVar) {
        if (bVar != null && bVar.f58422f == 0) {
            if (!bVar.f58421e && bVar.f58424h == 2) {
                n(bVar.f58425i);
            }
            d dVar = this.f58429h;
            if (dVar != null) {
                dVar.c(bVar.f58421e);
            }
        }
    }

    public final void c(d.a.k0.q0.f2.a.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (bVar.f58422f != 0) {
            if (StringUtils.isNull(bVar.f58423g)) {
                this.f58426e.showToast(R.string.neterror);
                return;
            } else {
                this.f58426e.showToast(bVar.f58423g);
                return;
            }
        }
        if (!bVar.f58421e) {
            int i2 = bVar.f58424h;
            if (i2 == 1) {
                m(bVar.f58425i, str);
            } else if (i2 == 3) {
                n(bVar.f58425i);
            }
        }
        d dVar = this.f58429h;
        if (dVar != null) {
            dVar.b(bVar.f58421e);
        }
    }

    public final void d(d.a.k0.q0.f2.a.b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        if (bVar.f58422f != 0) {
            if (StringUtils.isNull(bVar.f58423g)) {
                this.f58426e.showToast(R.string.neterror);
                return;
            } else {
                this.f58426e.showToast(bVar.f58423g);
                return;
            }
        }
        d dVar = this.f58429h;
        if (dVar != null) {
            dVar.a(bVar.f58421e, i2);
        }
    }

    public final void e() {
        if (this.f58427f.M()) {
            return;
        }
        this.f58427f.N();
    }

    public void f(String str) {
        d.a.k0.q0.f2.a.a aVar = this.f58428g;
        aVar.f58419h = 1;
        aVar.f58418g = str;
        e();
    }

    public void g(String str, long j) {
        d.a.k0.q0.f2.a.a aVar = this.f58428g;
        aVar.f58418g = str;
        aVar.f58417f = j;
        aVar.f58419h = 3;
        e();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void h(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.k0.q0.f2.a.a) || mvcSocketResponsedMessage == null || !(mvcSocketResponsedMessage.getData() instanceof d.a.k0.q0.f2.a.b)) {
            return;
        }
        d.a.k0.q0.f2.a.a aVar = (d.a.k0.q0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.k0.q0.f2.a.b bVar = (d.a.k0.q0.f2.a.b) mvcSocketResponsedMessage.getData();
        if (aVar.f58420i != this.f58430i) {
            return;
        }
        int i2 = aVar.f58419h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f58416e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f58418g);
        }
    }

    public void i(String str, int i2) {
        d.a.k0.q0.f2.a.a aVar = this.f58428g;
        aVar.f58416e = i2;
        aVar.f58418g = str;
        aVar.f58419h = 2;
        e();
    }

    public void j(d dVar) {
        this.f58429h = dVar;
    }

    public void k(int i2) {
        this.f58430i = i2;
        this.f58428g.f58420i = i2;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.k0.q0.f2.a.a) || mvcHttpResponsedMessage == null || !(mvcHttpResponsedMessage.getData() instanceof d.a.k0.q0.f2.a.b)) {
            return;
        }
        d.a.k0.q0.f2.a.a aVar = (d.a.k0.q0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.k0.q0.f2.a.b bVar = (d.a.k0.q0.f2.a.b) mvcHttpResponsedMessage.getData();
        if (aVar.f58420i != this.f58430i) {
            return;
        }
        int i2 = aVar.f58419h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f58416e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f58418g);
        }
    }

    public final void m(String str, String str2) {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f58426e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.comfirm_imediate, new a(str2, aVar));
        aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
        aVar.create(this.f58426e);
        aVar.show();
    }

    public void n(String str) {
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f58426e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new C1483c(this, aVar));
        aVar.create(this.f58426e);
        aVar.show();
    }
}
