package d.b.i0.x;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.card.data.CardPersonDynamicThreadData;
import com.baidu.tieba.model.SetPrivacyModel;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import d.b.h0.r.q.a2;
import d.b.h0.r.s.a;
import d.b.h0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62281a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62282b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.h0.r.s.j f62283c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.h0.r.s.l f62284d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.h0.r.s.a f62285e;

    /* renamed from: f  reason: collision with root package name */
    public i f62286f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f62287g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.b.h0.r.s.h> f62288h;
    public d.b.h0.r.s.h i;
    public d.b.h0.r.s.h j;
    public d.b.h0.r.s.h k;
    public SetPrivacyModel l;
    public ForumManageModel m;
    public d.b.i0.w.a o;
    public boolean n = false;
    public l.d p = new b();
    public SetPrivacyModel.a q = new e();
    public l.d r = new f();
    public l.d s = new g();
    public d.b.b.a.e t = new h();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.b.h0.r.s.l.c
        public void onClick() {
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l.d {
        public b() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            int i;
            if (q.this.f62287g == null) {
                return;
            }
            q.this.q();
            int i2 = 2;
            if (q.this.f62287g.s == 1) {
                i = 2;
            } else {
                int i3 = q.this.f62287g.s;
                i = 1;
            }
            if (q.this.f62287g == null || !q.this.f62287g.q) {
                if (q.this.f62287g.n() != null) {
                    q.this.o.i(q.this.f62287g.n().w1());
                }
                i2 = (TbSingleton.getInstance().mCallFansTid == null || q.this.f62287g.n() == null || !TbSingleton.getInstance().mCallFansTid.equals(q.this.f62287g.n().w1())) ? 1 : 1;
                q.this.o.c();
                if (q.this.f62287g.n() != null) {
                    q.this.o.e(i, i2, q.this.f62287g.n().w1());
                    return;
                }
                return;
            }
            q.this.f62281a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (q.this.f62287g.n() != null) {
                q.this.o.e(i, 3, q.this.f62287g.n().w1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (!d.b.b.e.p.j.A()) {
                d.b.b.e.p.l.K(q.this.f62282b, R.string.neterror);
                return;
            }
            if (q.this.f62287g.s != 1) {
                if (q.this.f62287g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
            }
            if (q.this.n) {
                q.this.m.L(q.this.f62287g.r);
            }
            q.this.m.N(q.this.f62287g.f15275e, q.this.f62287g.j, q.this.f62287g.f15276f, q.this.f62287g.f15277g, 0, 0, true, q.this.f62287g.r.V());
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d(q qVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements SetPrivacyModel.a {
        public e() {
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            d.b.b.e.p.l.L(q.this.f62282b, str);
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.f62287g.q) {
                q.this.f62287g.q = false;
                d.b.b.e.p.l.K(q.this.f62282b, R.string.thread_has_open);
                if (q.this.i != null) {
                    q.this.i.n(q.this.f62282b.getString(R.string.set_thread_privacy));
                }
                if (q.this.f62286f != null) {
                    q.this.f62286f.a(false);
                    return;
                }
                return;
            }
            q.this.f62287g.q = true;
            if (q.this.i != null) {
                q.this.i.n(q.this.f62282b.getString(R.string.set_thread_public_open));
            }
            if (q.this.f62286f != null) {
                q.this.f62286f.a(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.f62287g.f15276f));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements l.d {
        public f() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            if (!d.b.b.e.p.j.A()) {
                d.b.b.e.p.l.K(q.this.f62282b, R.string.neterror);
                return;
            }
            if (q.this.f62287g.q) {
                if (q.this.f62287g.s == 1) {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                }
            } else if (q.this.f62287g.s != 1) {
                if (q.this.f62287g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
            }
            if (q.this.l == null) {
                q.this.l = new SetPrivacyModel(q.this.f62281a, q.this.f62287g);
            }
            if (!q.this.l.y()) {
                q.this.l.z(q.this.q);
                q.this.l.LoadData();
            }
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements l.d {
        public g() {
        }

        @Override // d.b.h0.r.s.l.d
        public void onClick() {
            if (!d.b.b.e.p.j.A()) {
                d.b.b.e.p.l.K(q.this.f62282b, R.string.neterror);
                return;
            }
            if (q.this.f62287g != null && q.this.m != null) {
                q.this.p();
                q.this.f62285e.show();
            }
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class h extends d.b.b.a.e {
        public h() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f21382c == 0) {
                    d.b.b.e.p.l.K(q.this.f62282b, R.string.delete_success);
                    if (q.this.f62287g != null) {
                        if (d.b.b.e.p.k.isEmpty(q.this.f62287g.I)) {
                            if (d.b.b.e.p.k.isEmpty(q.this.f62287g.f15276f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.f62287g.f15276f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.f62287g.I));
                    }
                } else if (!d.b.b.e.p.k.isEmpty(bVar.f21381b)) {
                    d.b.b.e.p.l.L(q.this.f62282b, bVar.f21381b);
                } else {
                    d.b.b.e.p.l.K(q.this.f62282b, R.string.delete_fail);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface i {
        void a(boolean z);
    }

    public q(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        this.f62281a = tbPageContext;
        this.f62282b = tbPageContext.getPageActivity();
        this.f62288h = new ArrayList();
        this.f62284d = new d.b.h0.r.s.l(this.f62282b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f62281a);
        this.m = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.t);
        this.o = new d.b.i0.w.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        d.b.h0.r.s.h hVar;
        this.f62287g = cardPersonDynamicThreadData;
        if (cardPersonDynamicThreadData == null || (hVar = this.i) == null) {
            return;
        }
        if (cardPersonDynamicThreadData.q) {
            hVar.n(this.f62282b.getString(R.string.set_thread_public_open));
        } else {
            hVar.n(this.f62282b.getString(R.string.set_thread_privacy));
        }
        this.i.p(z);
        if (this.j != null) {
            if (TbSingleton.getInstance().mCanCallFans) {
                this.j.n(this.f62282b.getString(R.string.call_fans));
            } else {
                if (TbSingleton.getInstance().mCallFansTid != null && this.f62287g.n() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f62287g.n().w1())) {
                    this.j.n(this.f62282b.getString(R.string.have_called_fans));
                } else {
                    this.j.n(this.f62282b.getString(R.string.call_fans));
                }
                this.j.o(R.color.cp_cont_b_alpha33);
            }
            this.j.p(z);
        }
    }

    public void o() {
        if (this.f62283c != null) {
            return;
        }
        d.b.h0.r.s.h hVar = new d.b.h0.r.s.h(this.f62284d);
        this.i = hVar;
        hVar.m(this.r);
        if (!this.n) {
            this.f62288h.add(this.i);
        }
        if (TbSingleton.getInstance().mShowCallFans && !this.n) {
            d.b.h0.r.s.h hVar2 = new d.b.h0.r.s.h(this.f62282b.getString(R.string.call_fans), this.f62284d);
            this.j = hVar2;
            hVar2.m(this.p);
            this.f62288h.add(this.j);
        }
        d.b.h0.r.s.h hVar3 = new d.b.h0.r.s.h(this.f62282b.getString(R.string.delete), this.f62284d);
        this.k = hVar3;
        hVar3.m(this.s);
        this.f62288h.add(this.k);
        this.f62284d.m(new a());
        this.f62284d.k(this.f62288h);
        this.f62283c = new d.b.h0.r.s.j(this.f62281a, this.f62284d);
    }

    public final void p() {
        a2 a2Var;
        if (this.f62285e != null) {
            return;
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f62281a.getPageActivity());
        this.f62285e = aVar;
        if (this.n) {
            aVar.setMessageId(R.string.del_dynamic_confirm);
        } else {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f62287g;
            if (cardPersonDynamicThreadData != null && (a2Var = cardPersonDynamicThreadData.r) != null && a2Var.V1()) {
                this.f62285e.setMessageId(R.string.del_work_thread_confirm);
            } else {
                this.f62285e.setMessageId(R.string.del_thread_confirm);
            }
        }
        this.f62285e.setPositiveButton(R.string.dialog_ok, new c());
        this.f62285e.setNegativeButton(R.string.dialog_cancel, new d(this));
        this.f62285e.setCancelable(true);
        this.f62285e.create(this.f62281a);
    }

    public void q() {
        d.b.h0.r.s.j jVar = this.f62283c;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f62283c.dismiss();
    }

    public void r() {
        d.b.h0.r.s.l lVar = this.f62284d;
        if (lVar != null) {
            lVar.j();
        }
        d.b.h0.r.s.a aVar = this.f62285e;
        if (aVar != null) {
            d.b.h0.s0.a.a(this.f62281a, aVar.getRealView());
        }
    }

    public void s(i iVar) {
        this.f62286f = iVar;
    }

    public void t(boolean z) {
        this.n = z;
    }

    public void u() {
        d.b.h0.r.s.j jVar = this.f62283c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
