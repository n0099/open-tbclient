package d.a.j0.q0.f2.a;

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
import d.a.i0.r.s.a;
/* loaded from: classes4.dex */
public class c implements NetModel.k {

    /* renamed from: e  reason: collision with root package name */
    public TbPageContext<?> f57684e;

    /* renamed from: f  reason: collision with root package name */
    public FrsProfessionPermissionModel f57685f;

    /* renamed from: g  reason: collision with root package name */
    public d.a.j0.q0.f2.a.a f57686g;

    /* renamed from: h  reason: collision with root package name */
    public d f57687h;

    /* renamed from: i  reason: collision with root package name */
    public int f57688i;

    /* loaded from: classes4.dex */
    public class a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f57689e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f57690f;

        public a(String str, d.a.i0.r.s.a aVar) {
            this.f57689e = str;
            this.f57690f = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            MembercenterActivityConfig membercenterActivityConfig = new MembercenterActivityConfig(c.this.f57684e.getPageActivity());
            membercenterActivityConfig.setUrl("https://tieba.baidu.com/mo/q/prozone/view?fid=" + this.f57689e);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, membercenterActivityConfig));
            this.f57690f.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f57692e;

        public b(c cVar, d.a.i0.r.s.a aVar) {
            this.f57692e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f57692e.dismiss();
        }
    }

    /* renamed from: d.a.j0.q0.f2.a.c$c  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1409c implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f57693e;

        public C1409c(c cVar, d.a.i0.r.s.a aVar) {
            this.f57693e = aVar;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            this.f57693e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public interface d {
        void a(boolean z, int i2);

        void b(boolean z);

        void c(boolean z);
    }

    public c(TbPageContext<?> tbPageContext) {
        this.f57684e = tbPageContext;
        d.a.j0.q0.f2.a.a aVar = new d.a.j0.q0.f2.a.a();
        this.f57686g = aVar;
        FrsProfessionPermissionModel frsProfessionPermissionModel = new FrsProfessionPermissionModel(tbPageContext, aVar);
        this.f57685f = frsProfessionPermissionModel;
        frsProfessionPermissionModel.V(this);
    }

    public final void b(d.a.j0.q0.f2.a.b bVar) {
        if (bVar != null && bVar.f57680f == 0) {
            if (!bVar.f57679e && bVar.f57682h == 2) {
                n(bVar.f57683i);
            }
            d dVar = this.f57687h;
            if (dVar != null) {
                dVar.c(bVar.f57679e);
            }
        }
    }

    public final void c(d.a.j0.q0.f2.a.b bVar, String str) {
        if (bVar == null) {
            return;
        }
        if (bVar.f57680f != 0) {
            if (StringUtils.isNull(bVar.f57681g)) {
                this.f57684e.showToast(R.string.neterror);
                return;
            } else {
                this.f57684e.showToast(bVar.f57681g);
                return;
            }
        }
        if (!bVar.f57679e) {
            int i2 = bVar.f57682h;
            if (i2 == 1) {
                m(bVar.f57683i, str);
            } else if (i2 == 3) {
                n(bVar.f57683i);
            }
        }
        d dVar = this.f57687h;
        if (dVar != null) {
            dVar.b(bVar.f57679e);
        }
    }

    public final void d(d.a.j0.q0.f2.a.b bVar, int i2) {
        if (bVar == null) {
            return;
        }
        if (bVar.f57680f != 0) {
            if (StringUtils.isNull(bVar.f57681g)) {
                this.f57684e.showToast(R.string.neterror);
                return;
            } else {
                this.f57684e.showToast(bVar.f57681g);
                return;
            }
        }
        d dVar = this.f57687h;
        if (dVar != null) {
            dVar.a(bVar.f57679e, i2);
        }
    }

    public final void e() {
        if (this.f57685f.M()) {
            return;
        }
        this.f57685f.N();
    }

    public void f(String str) {
        d.a.j0.q0.f2.a.a aVar = this.f57686g;
        aVar.f57677h = 1;
        aVar.f57676g = str;
        e();
    }

    public void g(String str, long j) {
        d.a.j0.q0.f2.a.a aVar = this.f57686g;
        aVar.f57676g = str;
        aVar.f57675f = j;
        aVar.f57677h = 3;
        e();
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.m
    public void h(MvcSocketResponsedMessage mvcSocketResponsedMessage, MvcSocketMessage mvcSocketMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.j0.q0.f2.a.a) || mvcSocketResponsedMessage == null || !(mvcSocketResponsedMessage.getData() instanceof d.a.j0.q0.f2.a.b)) {
            return;
        }
        d.a.j0.q0.f2.a.a aVar = (d.a.j0.q0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.j0.q0.f2.a.b bVar = (d.a.j0.q0.f2.a.b) mvcSocketResponsedMessage.getData();
        if (aVar.f57678i != this.f57688i) {
            return;
        }
        int i2 = aVar.f57677h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f57674e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f57676g);
        }
    }

    public void i(String str, int i2) {
        d.a.j0.q0.f2.a.a aVar = this.f57686g;
        aVar.f57674e = i2;
        aVar.f57676g = str;
        aVar.f57677h = 2;
        e();
    }

    public void j(d dVar) {
        this.f57687h = dVar;
    }

    public void k(int i2) {
        this.f57688i = i2;
        this.f57686g.f57678i = i2;
    }

    @Override // com.baidu.tbadk.mvc.model.NetModel.l
    public void l(MvcHttpResponsedMessage mvcHttpResponsedMessage, MvcHttpMessage mvcHttpMessage, MvcNetMessage mvcNetMessage) {
        if (mvcNetMessage == null || !(mvcNetMessage.getRequestData() instanceof d.a.j0.q0.f2.a.a) || mvcHttpResponsedMessage == null || !(mvcHttpResponsedMessage.getData() instanceof d.a.j0.q0.f2.a.b)) {
            return;
        }
        d.a.j0.q0.f2.a.a aVar = (d.a.j0.q0.f2.a.a) mvcNetMessage.getRequestData();
        d.a.j0.q0.f2.a.b bVar = (d.a.j0.q0.f2.a.b) mvcHttpResponsedMessage.getData();
        if (aVar.f57678i != this.f57688i) {
            return;
        }
        int i2 = aVar.f57677h;
        if (i2 == 1) {
            b(bVar);
        } else if (i2 == 2) {
            d(bVar, aVar.f57674e);
        } else if (i2 != 3) {
        } else {
            c(bVar, aVar.f57676g);
        }
    }

    public final void m(String str, String str2) {
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f57684e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.comfirm_imediate, new a(str2, aVar));
        aVar.setNegativeButton(R.string.comfirm_cancel, new b(this, aVar));
        aVar.create(this.f57684e);
        aVar.show();
    }

    public void n(String str) {
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f57684e.getPageActivity());
        aVar.setCanceledOnTouchOutside(false);
        aVar.setCancelable(false);
        aVar.setMessage(str);
        aVar.setNegativeButton(R.string.know, new C1409c(this, aVar));
        aVar.create(this.f57684e);
        aVar.show();
    }
}
