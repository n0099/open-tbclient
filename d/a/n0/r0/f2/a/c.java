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
    public TbPageContext<?> f62258e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f62259f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.n0.r0.f2.a.a f62260g;

    /* renamed from: h  reason: collision with root package name */
    public d f62261h;

    /* renamed from: i  reason: collision with root package name */
    public int f62262i;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f62263e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f62264f;

        public a(String str, d.a.m0.r.s.a aVar) {
            this.f62263e = str;
            this.f62264f = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.f62258e.getPageActivity());
            membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f62263e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            this.f62264f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f62266e;

        public b(c cVar, d.a.m0.r.s.a aVar) {
            this.f62266e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f62266e.dismiss();
        }
    }

    /* renamed from: d.a.n0.r0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1552c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f62267e;

        public C1552c(c cVar, d.a.m0.r.s.a aVar) {
            this.f62267e = aVar;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            this.f62267e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i2);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f62258e = tbPageContext;
        d.a.n0.r0.f2.a.a aVar = new d.a.n0.r0.f2.a.a();
        this.f62260g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f62259f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.Z(this);
    }

    public final void b(d.a.n0.r0.f2.a.b bVar) {
        if (bVar != null && bVar.f62254f == 0) {
            if (!bVar.f62253e && bVar.f62256h == 2) {
                m(bVar.f62257i);
            }
            d dVar = this.f62261h;
            if (dVar != null) {
                dVar.c(bVar.f62253e);
            }
        }
    }

    public final void c(d.a.n0.r0.f2.a.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (bVar.f62254f != 0) {
            if (StringUtils.isNull(bVar.f62255g)) {
                this.f62258e.showToast(R.string.neterror);
                return;
            } else {
                this.f62258e.showToast(bVar.f62255g);
                return;
            }
        }
        if (!bVar.f62253e) {
            int i2 = bVar.f62256h;
            if (i2 == 1) {
                l(bVar.f62257i, str);
            } else if (i2 == 3) {
                m(bVar.f62257i);
            }
        }
        d dVar = this.f62261h;
        if (dVar != null) {
            dVar.b(bVar.f62253e);
        }
    }

    public final void d(d.a.n0.r0.f2.a.b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        if (bVar.f62254f != 0) {
            if (StringUtils.isNull(bVar.f62255g)) {
                this.f62258e.showToast(R.string.neterror);
                return;
            } else {
                this.f62258e.showToast(bVar.f62255g);
                return;
            }
        }
        d dVar = this.f62261h;
        if (dVar != null) {
            dVar.a(bVar.f62253e, i2);
        }
    }

    public final void e() {
        if (this.f62259f.Q()) {
            return;
        }
        this.f62259f.R();
    }

    public void f(String str) {
        d.a.n0.r0.f2.a.a aVar = this.f62260g;
        aVar.f62251h = 1;
        aVar.f62250g = str;
        e();
    }

    public void g(String str, long j) {
        d.a.n0.r0.f2.a.a aVar = this.f62260g;
        aVar.f62250g = str;
        aVar.f62249f = j;
        aVar.f62251h = 3;
        e();
    }

    public void h(String str, int i2) {
        d.a.n0.r0.f2.a.a aVar = this.f62260g;
        aVar.f62248e = i2;
        aVar.f62250g = str;
        aVar.f62251h = 2;
        e();
    }

    public void i(d dVar) {
        this.f62261h = dVar;
    }

    public void j(int i2) {
        this.f62262i = i2;
        this.f62260g.f62252i = i2;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void k(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.n0.r0.f2.a.a) || mvcSocketResponsedMessage == null || !(mvcSocketResponsedMessage.getData() instanceof d.a.n0.r0.f2.a.b)) {
            return;
        }
        d.a.n0.r0.f2.a.a aVar = (d.a.n0.r0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.n0.r0.f2.a.b bVar = (d.a.n0.r0.f2.a.b) mvcSocketResponsedMessage.getData();
        if (aVar.f62252i != this.f62262i) {
            return;
        }
        int i2 = aVar.f62251h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f62248e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f62250g);
        }
    }

    public final void l(String str, String str2) {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f62258e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.comfirm_imediate, new a(str2, aVar));
        aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
        aVar.create(this.f62258e);
        aVar.show();
    }

    public void m(String str) {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f62258e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new C1552c(this, aVar));
        aVar.create(this.f62258e);
        aVar.show();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void p(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.n0.r0.f2.a.a) || mvcHttpResponsedMessage == null || !(mvcHttpResponsedMessage.getData() instanceof d.a.n0.r0.f2.a.b)) {
            return;
        }
        d.a.n0.r0.f2.a.a aVar = (d.a.n0.r0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.n0.r0.f2.a.b bVar = (d.a.n0.r0.f2.a.b) mvcHttpResponsedMessage.getData();
        if (aVar.f62252i != this.f62262i) {
            return;
        }
        int i2 = aVar.f62251h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f62248e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f62250g);
        }
    }
}
