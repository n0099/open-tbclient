package d.a.n0.j2.d;

import android.view.View;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragment;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tieba.R;
import com.baidu.tieba.personPolymeric.mode.PersonPolymericModel;
import com.baidu.tieba.personPolymeric.mode.PersonPostModel;
import d.a.n0.j2.j.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends e implements d.a.n0.t1.a, b {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f60064f;

    /* renamed from: g  reason: collision with root package name */
    public long f60065g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f60066h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f60067i;
    public g j;
    public p k;
    public PersonPolymericModel l;
    public f m;
    public BaseFragmentActivity n;
    public View o;
    public PersonPostModel p;
    public int q;
    public List<d.a.n0.g2.i.e> r;

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.f60066h = true;
        this.q = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.n = baseFragmentActivity;
        this.f60064f = baseFragmentActivity.getPageContext();
        this.f60065g = j;
        this.j = gVar;
        this.f60067i = bdUniqueId;
        this.o = gVar.f60028i;
        this.p = new PersonPostModel(this.f60064f, bdUniqueId, null, this.f60014e, PersonPostModel.FROM_PERSON_POLYMERIC);
        p pVar = new p(baseFragment, gVar, bdUniqueId, z, this.f60065g);
        this.k = pVar;
        pVar.a0(this);
        f();
        this.l = this.j.q();
        this.m = this.j.l();
        ArrayList arrayList = new ArrayList(2);
        this.r = arrayList;
        arrayList.add(new d.a.n0.g2.i.e());
        this.r.add(new d.a.n0.g2.i.e());
    }

    @Override // d.a.n0.j2.d.b
    public p a() {
        return this.k;
    }

    @Override // d.a.n0.j2.d.b
    public void c(String str) {
    }

    @Override // d.a.n0.j2.d.b
    public void d() {
        p pVar = this.k;
        if (pVar != null) {
            pVar.Q();
        }
    }

    @Override // d.a.n0.j2.d.b
    public void e(String str) {
    }

    @Override // d.a.n0.t1.a
    public void f() {
        this.p.resetThreadPn();
        PersonPolymericModel personPolymericModel = this.l;
        if (personPolymericModel != null) {
            personPolymericModel.K();
        }
    }

    @Override // d.a.n0.t1.a
    public void h() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.h();
        }
    }

    public void j(d.a.n0.v3.f fVar) {
        this.k.b0(fVar);
    }

    public void k(int i2) {
        if (this.q == i2) {
            return;
        }
        p pVar = this.k;
        if (pVar != null) {
            pVar.X(i2);
        }
        this.q = i2;
    }

    public void l() {
        MessageManager.getInstance().unRegisterListener(this.f60067i);
        p pVar = this.k;
        if (pVar != null) {
            pVar.Y();
        }
    }

    @Override // d.a.n0.t1.a
    public void loadData() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.loadData();
        }
    }

    public void m(boolean z) {
        if (z && this.f60066h) {
            loadData();
        }
    }

    public void n() {
        if (TbadkCoreApplication.isLogin() && !this.f60014e && this.f60065g == TbadkCoreApplication.getCurrentAccountId()) {
            this.f60014e = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f60064f.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.n.finish();
        }
    }

    public void o(d.a.n0.j2.e.a aVar) {
        this.k.R();
        this.n.hideLoadingView(this.o);
        boolean z = true;
        if (aVar == null) {
            this.m.x(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.m.m();
            this.m.s(8);
            return;
        }
        this.m.o();
        if (aVar.e() != null && ((aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 1) || (aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 2))) {
            this.m.u(this.f60014e);
            this.m.s(8);
            return;
        }
        this.m.s(0);
        aVar.b();
        z = (aVar.f() == null || aVar.f().size() < 20) ? false : false;
        if (aVar.j() != null) {
            aVar.j().getSex();
        }
        this.f60066h = false;
        if (this.f60014e && aVar.j() != null) {
            aVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            d.a.m0.z.b.a().e(aVar.j());
        }
        d.a.n0.g2.i.e eVar = this.r.get(0);
        eVar.a(aVar.f());
        eVar.b(z);
        this.k.d0(aVar, z, i(aVar));
    }
}
