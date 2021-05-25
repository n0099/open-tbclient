package d.a.n0.r0.f2.a;

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
import d.a.m0.r.s.a;
/* loaded from: classes4.dex */
public class c implements NetModel.k {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f58567e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f58568f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r0.f2.a.a f58569g;

    /* renamed from: h  reason: collision with root package name */
    public d f58570h;

    /* renamed from: i  reason: collision with root package name */
    public int f58571i;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f58572e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f58573f;

        public a(String str, d.a.m0.r.s.a aVar) {
            this.f58572e = str;
            this.f58573f = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.f58567e.getPageActivity());
            membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f58572e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            this.f58573f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f58575e;

        public b(c cVar, d.a.m0.r.s.a aVar) {
            this.f58575e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f58575e.dismiss();
        }
    }

    /* renamed from: d.a.n0.r0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1496c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f58576e;

        public C1496c(c cVar, d.a.m0.r.s.a aVar) {
            this.f58576e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f58576e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i2);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f58567e = tbPageContext;
        d.a.n0.r0.f2.a.a aVar = new d.a.n0.r0.f2.a.a();
        this.f58569g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f58568f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.V(this);
    }

    public final void b(d.a.n0.r0.f2.a.b bVar) {
        if (bVar != null && bVar.f58563f == 0) {
            if (!bVar.f58562e && bVar.f58565h == 2) {
                n(bVar.f58566i);
            }
            d dVar = this.f58570h;
            if (dVar != null) {
                dVar.c(bVar.f58562e);
            }
        }
    }

    public final void c(d.a.n0.r0.f2.a.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (bVar.f58563f != 0) {
            if (StringUtils.isNull(bVar.f58564g)) {
                this.f58567e.showToast(R.string.neterror);
                return;
            } else {
                this.f58567e.showToast(bVar.f58564g);
                return;
            }
        }
        if (!bVar.f58562e) {
            int i2 = bVar.f58565h;
            if (i2 == 1) {
                m(bVar.f58566i, str);
            } else if (i2 == 3) {
                n(bVar.f58566i);
            }
        }
        d dVar = this.f58570h;
        if (dVar != null) {
            dVar.b(bVar.f58562e);
        }
    }

    public final void d(d.a.n0.r0.f2.a.b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        if (bVar.f58563f != 0) {
            if (StringUtils.isNull(bVar.f58564g)) {
                this.f58567e.showToast(R.string.neterror);
                return;
            } else {
                this.f58567e.showToast(bVar.f58564g);
                return;
            }
        }
        d dVar = this.f58570h;
        if (dVar != null) {
            dVar.a(bVar.f58562e, i2);
        }
    }

    public final void e() {
        if (this.f58568f.M()) {
            return;
        }
        this.f58568f.N();
    }

    public void f(String str) {
        d.a.n0.r0.f2.a.a aVar = this.f58569g;
        aVar.f58560h = 1;
        aVar.f58559g = str;
        e();
    }

    public void g(String str, long j) {
        d.a.n0.r0.f2.a.a aVar = this.f58569g;
        aVar.f58559g = str;
        aVar.f58558f = j;
        aVar.f58560h = 3;
        e();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void h(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.n0.r0.f2.a.a) || mvcSocketResponsedMessage == null || !(mvcSocketResponsedMessage.getData() instanceof d.a.n0.r0.f2.a.b)) {
            return;
        }
        d.a.n0.r0.f2.a.a aVar = (d.a.n0.r0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.n0.r0.f2.a.b bVar = (d.a.n0.r0.f2.a.b) mvcSocketResponsedMessage.getData();
        if (aVar.f58561i != this.f58571i) {
            return;
        }
        int i2 = aVar.f58560h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f58557e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f58559g);
        }
    }

    public void i(String str, int i2) {
        d.a.n0.r0.f2.a.a aVar = this.f58569g;
        aVar.f58557e = i2;
        aVar.f58559g = str;
        aVar.f58560h = 2;
        e();
    }

    public void j(d dVar) {
        this.f58570h = dVar;
    }

    public void k(int i2) {
        this.f58571i = i2;
        this.f58569g.f58561i = i2;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.n0.r0.f2.a.a) || mvcHttpResponsedMessage == null || !(mvcHttpResponsedMessage.getData() instanceof d.a.n0.r0.f2.a.b)) {
            return;
        }
        d.a.n0.r0.f2.a.a aVar = (d.a.n0.r0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.n0.r0.f2.a.b bVar = (d.a.n0.r0.f2.a.b) mvcHttpResponsedMessage.getData();
        if (aVar.f58561i != this.f58571i) {
            return;
        }
        int i2 = aVar.f58560h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f58557e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f58559g);
        }
    }

    public final void m(String str, String str2) {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f58567e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.comfirm_imediate, new a(str2, aVar));
        aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
        aVar.create(this.f58567e);
        aVar.show();
    }

    public void n(String str) {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f58567e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new C1496c(this, aVar));
        aVar.create(this.f58567e);
        aVar.show();
    }
}
