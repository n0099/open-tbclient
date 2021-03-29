package d.b.i0.h2.d;

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
import d.b.i0.h2.j.p;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class k extends e implements d.b.i0.r1.a, b {

    /* renamed from: f  reason: collision with root package name */
    public TbPageContext f55258f;

    /* renamed from: g  reason: collision with root package name */
    public long f55259g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f55260h;
    public BdUniqueId i;
    public g j;
    public p k;
    public PersonPolymericModel l;
    public f m;
    public BaseFragmentActivity n;
    public View o;
    public PersonPostModel p;
    public int q;
    public List<d.b.i0.e2.i.e> r;

    public k(BaseFragment baseFragment, g gVar, BdUniqueId bdUniqueId, long j, boolean z) {
        super(z);
        this.f55260h = true;
        this.q = 3;
        BaseFragmentActivity baseFragmentActivity = baseFragment.getBaseFragmentActivity();
        this.n = baseFragmentActivity;
        this.f55258f = baseFragmentActivity.getPageContext();
        this.f55259g = j;
        this.j = gVar;
        this.i = bdUniqueId;
        this.o = gVar.i;
        this.p = new PersonPostModel(this.f55258f, bdUniqueId, null, this.f55214e, PersonPostModel.FROM_PERSON_POLYMERIC);
        p pVar = new p(baseFragment, gVar, bdUniqueId, z, this.f55259g);
        this.k = pVar;
        pVar.a0(this);
        c();
        this.l = this.j.q();
        this.m = this.j.l();
        ArrayList arrayList = new ArrayList(2);
        this.r = arrayList;
        arrayList.add(new d.b.i0.e2.i.e());
        this.r.add(new d.b.i0.e2.i.e());
    }

    @Override // d.b.i0.h2.d.b
    public p a() {
        return this.k;
    }

    @Override // d.b.i0.r1.a
    public void c() {
        this.p.resetThreadPn();
        PersonPolymericModel personPolymericModel = this.l;
        if (personPolymericModel != null) {
            personPolymericModel.G();
        }
    }

    @Override // d.b.i0.h2.d.b
    public void d(String str) {
    }

    @Override // d.b.i0.h2.d.b
    public void e() {
        p pVar = this.k;
        if (pVar != null) {
            pVar.Q();
        }
    }

    @Override // d.b.i0.h2.d.b
    public void f(String str) {
    }

    @Override // d.b.i0.r1.a
    public void h() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.h();
        }
    }

    public void j(d.b.i0.t3.f fVar) {
        this.k.b0(fVar);
    }

    public void k(int i) {
        if (this.q == i) {
            return;
        }
        p pVar = this.k;
        if (pVar != null) {
            pVar.X(i);
        }
        this.q = i;
    }

    public void l() {
        MessageManager.getInstance().unRegisterListener(this.i);
        p pVar = this.k;
        if (pVar != null) {
            pVar.Y();
        }
    }

    @Override // d.b.i0.r1.a
    public void loadData() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.loadData();
        }
    }

    public void m(boolean z) {
        if (z && this.f55260h) {
            loadData();
        }
    }

    public void n() {
        if (TbadkCoreApplication.isLogin() && !this.f55214e && this.f55259g == TbadkCoreApplication.getCurrentAccountId()) {
            this.f55214e = true;
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.f55258f.getPageActivity()).createNormalConfig(d.b.b.e.m.b.f(TbadkCoreApplication.getCurrentAccount(), 0L), true, TbadkCoreApplication.getCurrentAccountInfo() == null ? false : TbadkCoreApplication.getCurrentAccountInfo().isBigV())));
            this.n.finish();
        }
    }

    public void o(d.b.i0.h2.e.a aVar) {
        this.k.R();
        this.n.hideLoadingView(this.o);
        boolean z = true;
        if (aVar == null) {
            this.m.y(TbadkCoreApplication.getInst().getString(R.string.neterror), true);
            this.m.m();
            this.m.s(8);
            return;
        }
        this.m.o();
        if (aVar.e() != null && ((aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 1) || (aVar.e().getHide_stat() == 1 && aVar.e().getBlock_stat() == 2))) {
            this.m.v(this.f55214e);
            this.m.s(8);
            return;
        }
        this.m.s(0);
        aVar.b();
        z = (aVar.f() == null || aVar.f().size() < 20) ? false : false;
        if (aVar.j() != null) {
            aVar.j().getSex();
        }
        this.f55260h = false;
        if (this.f55214e && aVar.j() != null) {
            aVar.j().setBimg_url(TbadkCoreApplication.getInst().getDefaultBubble());
            d.b.h0.z.b.a().e(aVar.j());
        }
        d.b.i0.e2.i.e eVar = this.r.get(0);
        eVar.a(aVar.f());
        eVar.b(z);
        this.k.d0(aVar, z, i(aVar));
    }
}
