package d.b.j0.q0.f2.a;

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
import d.b.i0.r.s.a;
/* loaded from: classes4.dex */
public class c implements NetModel.k {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f59625e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f59626f;

    /* renamed from: g  reason: collision with root package name */
    public d.b.j0.q0.f2.a.a f59627g;

    /* renamed from: h  reason: collision with root package name */
    public d f59628h;
    public int i;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59629e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f59630f;

        public a(String str, d.b.i0.r.s.a aVar) {
            this.f59629e = str;
            this.f59630f = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.f59625e.getPageActivity());
            membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f59629e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            this.f59630f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f59632e;

        public b(c cVar, d.b.i0.r.s.a aVar) {
            this.f59632e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f59632e.dismiss();
        }
    }

    /* renamed from: d.b.j0.q0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1470c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f59633e;

        public C1470c(c cVar, d.b.i0.r.s.a aVar) {
            this.f59633e = aVar;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            this.f59633e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f59625e = tbPageContext;
        d.b.j0.q0.f2.a.a aVar = new d.b.j0.q0.f2.a.a();
        this.f59627g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f59626f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.V(this);
    }

    public final void b(d.b.j0.q0.f2.a.b bVar) {
        if (bVar != null && bVar.f59622f == 0) {
            if (!bVar.f59621e && bVar.f59624h == 2) {
                m(bVar.i);
            }
            d dVar = this.f59628h;
            if (dVar != null) {
                dVar.c(bVar.f59621e);
            }
        }
    }

    public final void c(d.b.j0.q0.f2.a.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (bVar.f59622f != 0) {
            if (StringUtils.isNull(bVar.f59623g)) {
                this.f59625e.showToast(R.string.neterror);
                return;
            } else {
                this.f59625e.showToast(bVar.f59623g);
                return;
            }
        }
        if (!bVar.f59621e) {
            int i = bVar.f59624h;
            if (i == 1) {
                l(bVar.i, str);
            } else if (i == 3) {
                m(bVar.i);
            }
        }
        d dVar = this.f59628h;
        if (dVar != null) {
            dVar.b(bVar.f59621e);
        }
    }

    public final void d(d.b.j0.q0.f2.a.b bVar, int i) {
        if (bVar == null) {
            return;
        }
        if (bVar.f59622f != 0) {
            if (StringUtils.isNull(bVar.f59623g)) {
                this.f59625e.showToast(R.string.neterror);
                return;
            } else {
                this.f59625e.showToast(bVar.f59623g);
                return;
            }
        }
        d dVar = this.f59628h;
        if (dVar != null) {
            dVar.a(bVar.f59621e, i);
        }
    }

    public final void e() {
        if (this.f59626f.M()) {
            return;
        }
        this.f59626f.N();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void f(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.b.j0.q0.f2.a.a) || mvcHttpResponsedMessage == null || !(mvcHttpResponsedMessage.getData() instanceof d.b.j0.q0.f2.a.b)) {
            return;
        }
        d.b.j0.q0.f2.a.a aVar = (d.b.j0.q0.f2.a.a) mvcNetMessage.getRequestData();
        d.b.j0.q0.f2.a.b bVar = (d.b.j0.q0.f2.a.b) mvcHttpResponsedMessage.getData();
        if (aVar.i != this.i) {
            return;
        }
        int i = aVar.f59620h;
        if (i == 1) {
            b(bVar);
        } else if (i == 2) {
            d(bVar, aVar.f59617e);
        } else if (i != 3) {
        } else {
            c(bVar, aVar.f59619g);
        }
    }

    public void g(String str) {
        d.b.j0.q0.f2.a.a aVar = this.f59627g;
        aVar.f59620h = 1;
        aVar.f59619g = str;
        e();
    }

    public void h(String str, long j) {
        d.b.j0.q0.f2.a.a aVar = this.f59627g;
        aVar.f59619g = str;
        aVar.f59618f = j;
        aVar.f59620h = 3;
        e();
    }

    public void i(String str, int i) {
        d.b.j0.q0.f2.a.a aVar = this.f59627g;
        aVar.f59617e = i;
        aVar.f59619g = str;
        aVar.f59620h = 2;
        e();
    }

    public void j(d dVar) {
        this.f59628h = dVar;
    }

    public void k(int i) {
        this.i = i;
        this.f59627g.i = i;
    }

    public final void l(String str, String str2) {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f59625e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.comfirm_imediate, new a(str2, aVar));
        aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
        aVar.create(this.f59625e);
        aVar.show();
    }

    public void m(String str) {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f59625e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new C1470c(this, aVar));
        aVar.create(this.f59625e);
        aVar.show();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void n(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.b.j0.q0.f2.a.a) || mvcSocketResponsedMessage == null || !(mvcSocketResponsedMessage.getData() instanceof d.b.j0.q0.f2.a.b)) {
            return;
        }
        d.b.j0.q0.f2.a.a aVar = (d.b.j0.q0.f2.a.a) mvcNetMessage.getRequestData();
        d.b.j0.q0.f2.a.b bVar = (d.b.j0.q0.f2.a.b) mvcSocketResponsedMessage.getData();
        if (aVar.i != this.i) {
            return;
        }
        int i = aVar.f59620h;
        if (i == 1) {
            b(bVar);
        } else if (i == 2) {
            d(bVar, aVar.f59617e);
        } else if (i != 3) {
        } else {
            c(bVar, aVar.f59619g);
        }
    }
}
