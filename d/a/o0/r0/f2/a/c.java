package d.a.o0.r0.f2.a;

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
import d.a.n0.r.s.a;
/* loaded from: classes4.dex */
public class c implements NetModel.k {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f62383e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f62384f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.o0.r0.f2.a.a f62385g;

    /* renamed from: h  reason: collision with root package name */
    public d f62386h;

    /* renamed from: i  reason: collision with root package name */
    public int f62387i;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62388e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f62389f;

        public a(String str, d.a.n0.r.s.a aVar) {
            this.f62388e = str;
            this.f62389f = aVar;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.f62383e.getPageActivity());
            membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f62388e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            this.f62389f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f62391e;

        public b(c cVar, d.a.n0.r.s.a aVar) {
            this.f62391e = aVar;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            this.f62391e.dismiss();
        }
    }

    /* renamed from: d.a.o0.r0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1556c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f62392e;

        public C1556c(c cVar, d.a.n0.r.s.a aVar) {
            this.f62392e = aVar;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            this.f62392e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i2);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f62383e = tbPageContext;
        d.a.o0.r0.f2.a.a aVar = new d.a.o0.r0.f2.a.a();
        this.f62385g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f62384f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.Z(this);
    }

    public final void b(d.a.o0.r0.f2.a.b bVar) {
        if (bVar != null && bVar.f62379f == 0) {
            if (!bVar.f62378e && bVar.f62381h == 2) {
                m(bVar.f62382i);
            }
            d dVar = this.f62386h;
            if (dVar != null) {
                dVar.c(bVar.f62378e);
            }
        }
    }

    public final void c(d.a.o0.r0.f2.a.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (bVar.f62379f != 0) {
            if (StringUtils.isNull(bVar.f62380g)) {
                this.f62383e.showToast(R.string.neterror);
                return;
            } else {
                this.f62383e.showToast(bVar.f62380g);
                return;
            }
        }
        if (!bVar.f62378e) {
            int i2 = bVar.f62381h;
            if (i2 == 1) {
                l(bVar.f62382i, str);
            } else if (i2 == 3) {
                m(bVar.f62382i);
            }
        }
        d dVar = this.f62386h;
        if (dVar != null) {
            dVar.b(bVar.f62378e);
        }
    }

    public final void d(d.a.o0.r0.f2.a.b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        if (bVar.f62379f != 0) {
            if (StringUtils.isNull(bVar.f62380g)) {
                this.f62383e.showToast(R.string.neterror);
                return;
            } else {
                this.f62383e.showToast(bVar.f62380g);
                return;
            }
        }
        d dVar = this.f62386h;
        if (dVar != null) {
            dVar.a(bVar.f62378e, i2);
        }
    }

    public final void e() {
        if (this.f62384f.Q()) {
            return;
        }
        this.f62384f.R();
    }

    public void f(String str) {
        d.a.o0.r0.f2.a.a aVar = this.f62385g;
        aVar.f62376h = 1;
        aVar.f62375g = str;
        e();
    }

    public void g(String str, long j) {
        d.a.o0.r0.f2.a.a aVar = this.f62385g;
        aVar.f62375g = str;
        aVar.f62374f = j;
        aVar.f62376h = 3;
        e();
    }

    public void h(String str, int i2) {
        d.a.o0.r0.f2.a.a aVar = this.f62385g;
        aVar.f62373e = i2;
        aVar.f62375g = str;
        aVar.f62376h = 2;
        e();
    }

    public void i(d dVar) {
        this.f62386h = dVar;
    }

    public void j(int i2) {
        this.f62387i = i2;
        this.f62385g.f62377i = i2;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.o0.r0.f2.a.a) || mvcSocketResponsedMessage == null || !(mvcSocketResponsedMessage.getData() instanceof d.a.o0.r0.f2.a.b)) {
            return;
        }
        d.a.o0.r0.f2.a.a aVar = (d.a.o0.r0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.o0.r0.f2.a.b bVar = (d.a.o0.r0.f2.a.b) mvcSocketResponsedMessage.getData();
        if (aVar.f62377i != this.f62387i) {
            return;
        }
        int i2 = aVar.f62376h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f62373e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f62375g);
        }
    }

    public final void l(String str, String str2) {
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f62383e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.comfirm_imediate, new a(str2, aVar));
        aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
        aVar.create(this.f62383e);
        aVar.show();
    }

    public void m(String str) {
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f62383e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new C1556c(this, aVar));
        aVar.create(this.f62383e);
        aVar.show();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.o0.r0.f2.a.a) || mvcHttpResponsedMessage == null || !(mvcHttpResponsedMessage.getData() instanceof d.a.o0.r0.f2.a.b)) {
            return;
        }
        d.a.o0.r0.f2.a.a aVar = (d.a.o0.r0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.o0.r0.f2.a.b bVar = (d.a.o0.r0.f2.a.b) mvcHttpResponsedMessage.getData();
        if (aVar.f62377i != this.f62387i) {
            return;
        }
        int i2 = aVar.f62376h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f62373e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f62375g);
        }
    }
}
