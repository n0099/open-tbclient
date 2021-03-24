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
    public TbPageContext<?> f57504e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f57505f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.p0.f2.a.a f57506g;

    /* renamed from: h  reason: collision with root package name */
    public d f57507h;
    public int i;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57508e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f57509f;

        public a(String str, d.b.h0.r.s.a aVar) {
            this.f57508e = str;
            this.f57509f = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.f57504e.getPageActivity());
            membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f57508e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            this.f57509f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f57511e;

        public b(c cVar, d.b.h0.r.s.a aVar) {
            this.f57511e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f57511e.dismiss();
        }
    }

    /* renamed from: d.b.i0.p0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1384c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f57512e;

        public C1384c(c cVar, d.b.h0.r.s.a aVar) {
            this.f57512e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f57512e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f57504e = tbPageContext;
        d.b.i0.p0.f2.a.a aVar = new d.b.i0.p0.f2.a.a();
        this.f57506g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f57505f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.V(this);
    }

    public final void b(d.b.i0.p0.f2.a.b bVar) {
        if (bVar != null && bVar.f57501f == 0) {
            if (!bVar.f57500e && bVar.f57503h == 2) {
                m(bVar.i);
            }
            d dVar = this.f57507h;
            if (dVar != null) {
                dVar.c(bVar.f57500e);
            }
        }
    }

    public final void c(d.b.i0.p0.f2.a.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (bVar.f57501f != 0) {
            if (StringUtils.isNull(bVar.f57502g)) {
                this.f57504e.showToast(R.string.neterror);
                return;
            } else {
                this.f57504e.showToast(bVar.f57502g);
                return;
            }
        }
        if (!bVar.f57500e) {
            int i = bVar.f57503h;
            if (i == 1) {
                l(bVar.i, str);
            } else if (i == 3) {
                m(bVar.i);
            }
        }
        d dVar = this.f57507h;
        if (dVar != null) {
            dVar.b(bVar.f57500e);
        }
    }

    public final void d(d.b.i0.p0.f2.a.b bVar, int i) {
        if (bVar == null) {
            return;
        }
        if (bVar.f57501f != 0) {
            if (StringUtils.isNull(bVar.f57502g)) {
                this.f57504e.showToast(R.string.neterror);
                return;
            } else {
                this.f57504e.showToast(bVar.f57502g);
                return;
            }
        }
        d dVar = this.f57507h;
        if (dVar != null) {
            dVar.a(bVar.f57500e, i);
        }
    }

    public final void e() {
        if (this.f57505f.M()) {
            return;
        }
        this.f57505f.N();
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
        int i = aVar.f57499h;
        if (i == 1) {
            b(bVar);
        } else if (i == 2) {
            d(bVar, aVar.f57496e);
        } else if (i != 3) {
        } else {
            c(bVar, aVar.f57498g);
        }
    }

    public void g(String str) {
        d.b.i0.p0.f2.a.a aVar = this.f57506g;
        aVar.f57499h = 1;
        aVar.f57498g = str;
        e();
    }

    public void h(String str, long j) {
        d.b.i0.p0.f2.a.a aVar = this.f57506g;
        aVar.f57498g = str;
        aVar.f57497f = j;
        aVar.f57499h = 3;
        e();
    }

    public void i(String str, int i) {
        d.b.i0.p0.f2.a.a aVar = this.f57506g;
        aVar.f57496e = i;
        aVar.f57498g = str;
        aVar.f57499h = 2;
        e();
    }

    public void j(d dVar) {
        this.f57507h = dVar;
    }

    public void k(int i) {
        this.i = i;
        this.f57506g.i = i;
    }

    public final void l(String str, String str2) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57504e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.comfirm_imediate, new a(str2, aVar));
        aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
        aVar.create(this.f57504e);
        aVar.show();
    }

    public void m(String str) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57504e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new C1384c(this, aVar));
        aVar.create(this.f57504e);
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
        int i = aVar.f57499h;
        if (i == 1) {
            b(bVar);
        } else if (i == 2) {
            d(bVar, aVar.f57496e);
        } else if (i != 3) {
        } else {
            c(bVar, aVar.f57498g);
        }
    }
}
