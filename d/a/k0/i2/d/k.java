package d.a.k0.i2.d;

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
import d.a.k0.i2.j.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends e implements d.a.k0.s1.a, b {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f56191f;

    /* renamed from: g  reason: collision with root package name */
    public long f56192g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f56193h;

    /* renamed from: i  reason: collision with root package name */
    public BdUniqueId f56194i;
    public g j;
    public p k;
    public PersonPolymericModel l;
    public f m;
    public BaseFragmentActivity n;
    public View o;
    public PersonPostModel p;
    public int q;
    public List<d.a.k0.f2.i.e> r;

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.f56193h = true;
        this.q = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.n = baseFragmentActivity;
        this.f56191f = baseFragmentActivity.getPageContext();
        this.f56192g = j;
        this.j = gVar;
        this.f56194i = bdUniqueId;
        this.o = gVar.f56155i;
        this.p = new PersonPostModel(this.f56191f, bdUniqueId, null, this.f56141e, PersonPostModel.FROM_PERSON_POLYMERIC);
        p pVar = new p(baseFragment, gVar, bdUniqueId, z, this.f56192g);
        this.k = pVar;
        pVar.a0(this);
        f();
        this.l = this.j.q();
        this.m = this.j.l();
        ArrayList arrayList = new ArrayList(2);
        this.r = arrayList;
        arrayList.add(new d.a.k0.f2.i.e());
        this.r.add(new d.a.k0.f2.i.e());
    }

    @Override // d.a.k0.i2.d.b
    public p a() {
        return this.k;
    }

    @Override // d.a.k0.i2.d.b
    public void c(String str) {
    }

    @Override // d.a.k0.i2.d.b
    public void d() {
        p pVar = this.k;
        if (pVar != null) {
            pVar.Q();
        }
    }

    @Override // d.a.k0.i2.d.b
    public void e(String str) {
    }

    @Override // d.a.k0.s1.a
    public void f() {
        this.p.resetThreadPn();
        PersonPolymericModel personPolymericModel = this.l;
        if (personPolymericModel != null) {
            personPolymericModel.G();
        }
    }

    @Override // d.a.k0.s1.a
    public void g() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.g();
        }
    }

    public void j(d.a.k0.u3.f fVar) {
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
        MessageManager.getInstance().unRegisterListener(this.f56194i);
        p pVar = this.k;
        if (pVar != null) {
            pVar.Y();
        }
    }

    @Override // d.a.k0.s1.a
    public void loadData() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.loadData();
        }
    }

    public void m(boolean z) {
        if (z && this.f56193h) {
            loadData();
        }
    }

    public void n() {
        if (TbadkCoreApplication.isLogin() && !this.f56141e && this.f56192g == TbadkCoreApplication.getCurrentAccountId()) {
            this.f56141e = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f56191f.getPageActivity()).createNormalConfig(d.a.c.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.n.finish();
        }
    }

    public void o(d.a.k0.i2.e.a aVar) {
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
            this.m.u(this.f56141e);
            this.m.s(8);
            return;
        }
        this.m.s(0);
        aVar.b();
        z = (aVar.f() == null || aVar.f().size() < 20) ? false : false;
        if (aVar.j() != null) {
            aVar.j().getSex();
        }
        this.f56193h = false;
        if (this.f56141e && aVar.j() != null) {
            aVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            d.a.j0.z.b.a().e(aVar.j());
        }
        d.a.k0.f2.i.e eVar = this.r.get(0);
        eVar.a(aVar.f());
        eVar.b(z);
        this.k.d0(aVar, z, i(aVar));
    }
}
