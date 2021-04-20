package d.b.i0.q0.f2.a;

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
    public TbPageContext<?> f59204e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f59205f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.i0.q0.f2.a.a f59206g;

    /* renamed from: h  reason: collision with root package name */
    public d f59207h;
    public int i;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59208e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f59209f;

        public a(String str, d.b.h0.r.s.a aVar) {
            this.f59208e = str;
            this.f59209f = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.f59204e.getPageActivity());
            membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f59208e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            this.f59209f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f59211e;

        public b(c cVar, d.b.h0.r.s.a aVar) {
            this.f59211e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f59211e.dismiss();
        }
    }

    /* renamed from: d.b.i0.q0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1447c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f59212e;

        public C1447c(c cVar, d.b.h0.r.s.a aVar) {
            this.f59212e = aVar;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f59212e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f59204e = tbPageContext;
        d.b.i0.q0.f2.a.a aVar = new d.b.i0.q0.f2.a.a();
        this.f59206g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f59205f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.V(this);
    }

    public final void b(d.b.i0.q0.f2.a.b bVar) {
        if (bVar != null && bVar.f59201f == 0) {
            if (!bVar.f59200e && bVar.f59203h == 2) {
                m(bVar.i);
            }
            d dVar = this.f59207h;
            if (dVar != null) {
                dVar.c(bVar.f59200e);
            }
        }
    }

    public final void c(d.b.i0.q0.f2.a.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (bVar.f59201f != 0) {
            if (StringUtils.isNull(bVar.f59202g)) {
                this.f59204e.showToast(R.string.neterror);
                return;
            } else {
                this.f59204e.showToast(bVar.f59202g);
                return;
            }
        }
        if (!bVar.f59200e) {
            int i = bVar.f59203h;
            if (i == 1) {
                l(bVar.i, str);
            } else if (i == 3) {
                m(bVar.i);
            }
        }
        d dVar = this.f59207h;
        if (dVar != null) {
            dVar.b(bVar.f59200e);
        }
    }

    public final void d(d.b.i0.q0.f2.a.b bVar, int i) {
        if (bVar == null) {
            return;
        }
        if (bVar.f59201f != 0) {
            if (StringUtils.isNull(bVar.f59202g)) {
                this.f59204e.showToast(R.string.neterror);
                return;
            } else {
                this.f59204e.showToast(bVar.f59202g);
                return;
            }
        }
        d dVar = this.f59207h;
        if (dVar != null) {
            dVar.a(bVar.f59200e, i);
        }
    }

    public final void e() {
        if (this.f59205f.M()) {
            return;
        }
        this.f59205f.N();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void f(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.b.i0.q0.f2.a.a) || mvcHttpResponsedMessage == null || !(mvcHttpResponsedMessage.getData() instanceof d.b.i0.q0.f2.a.b)) {
            return;
        }
        d.b.i0.q0.f2.a.a aVar = (d.b.i0.q0.f2.a.a) mvcNetMessage.getRequestData();
        d.b.i0.q0.f2.a.b bVar = (d.b.i0.q0.f2.a.b) mvcHttpResponsedMessage.getData();
        if (aVar.i != this.i) {
            return;
        }
        int i = aVar.f59199h;
        if (i == 1) {
            b(bVar);
        } else if (i == 2) {
            d(bVar, aVar.f59196e);
        } else if (i != 3) {
        } else {
            c(bVar, aVar.f59198g);
        }
    }

    public void g(String str) {
        d.b.i0.q0.f2.a.a aVar = this.f59206g;
        aVar.f59199h = 1;
        aVar.f59198g = str;
        e();
    }

    public void h(String str, long j) {
        d.b.i0.q0.f2.a.a aVar = this.f59206g;
        aVar.f59198g = str;
        aVar.f59197f = j;
        aVar.f59199h = 3;
        e();
    }

    public void i(String str, int i) {
        d.b.i0.q0.f2.a.a aVar = this.f59206g;
        aVar.f59196e = i;
        aVar.f59198g = str;
        aVar.f59199h = 2;
        e();
    }

    public void j(d dVar) {
        this.f59207h = dVar;
    }

    public void k(int i) {
        this.i = i;
        this.f59206g.i = i;
    }

    public final void l(String str, String str2) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f59204e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.comfirm_imediate, new a(str2, aVar));
        aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
        aVar.create(this.f59204e);
        aVar.show();
    }

    public void m(String str) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f59204e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new C1447c(this, aVar));
        aVar.create(this.f59204e);
        aVar.show();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.b.i0.q0.f2.a.a) || mvcSocketResponsedMessage == null || !(mvcSocketResponsedMessage.getData() instanceof d.b.i0.q0.f2.a.b)) {
            return;
        }
        d.b.i0.q0.f2.a.a aVar = (d.b.i0.q0.f2.a.a) mvcNetMessage.getRequestData();
        d.b.i0.q0.f2.a.b bVar = (d.b.i0.q0.f2.a.b) mvcSocketResponsedMessage.getData();
        if (aVar.i != this.i) {
            return;
        }
        int i = aVar.f59199h;
        if (i == 1) {
            b(bVar);
        } else if (i == 2) {
            d(bVar, aVar.f59196e);
        } else if (i != 3) {
        } else {
            c(bVar, aVar.f59198g);
        }
    }
}
