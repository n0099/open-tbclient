package d.a.n0.z;

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
import d.a.m0.r.q.a2;
import d.a.m0.r.s.a;
import d.a.m0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f63548a;

    /* renamed from: b  reason: collision with root package name */
    public Context f63549b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.m0.r.s.j f63550c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.m0.r.s.l f63551d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.m0.r.s.a f63552e;

    /* renamed from: f  reason: collision with root package name */
    public i f63553f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f63554g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.a.m0.r.s.h> f63555h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.m0.r.s.h f63556i;
    public d.a.m0.r.s.h j;
    public d.a.m0.r.s.h k;
    public SetPrivacyModel l;
    public ForumManageModel m;
    public d.a.n0.y.a o;
    public boolean n = false;
    public l.d p = new b();
    public SetPrivacyModel.a q = new e();
    public l.d r = new f();
    public l.d s = new g();
    public d.a.c.a.e t = new h();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.a.m0.r.s.l.c
        public void onClick() {
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l.d {
        public b() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            int i2;
            if (q.this.f63554g == null) {
                return;
            }
            q.this.q();
            int i3 = 2;
            if (q.this.f63554g.s == 1) {
                i2 = 2;
            } else {
                int i4 = q.this.f63554g.s;
                i2 = 1;
            }
            if (q.this.f63554g == null || !q.this.f63554g.q) {
                if (q.this.f63554g.m() != null) {
                    q.this.o.i(q.this.f63554g.m().y1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || q.this.f63554g.m() == null || !TbSingleton.getInstance().mCallFansTid.equals(q.this.f63554g.m().y1())) ? 1 : 1;
                q.this.o.c();
                if (q.this.f63554g.m() != null) {
                    q.this.o.e(i2, i3, q.this.f63554g.m().y1());
                    return;
                }
                return;
            }
            q.this.f63548a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (q.this.f63554g.m() != null) {
                q.this.o.e(i2, 3, q.this.f63554g.m().y1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            if (!d.a.c.e.p.j.A()) {
                d.a.c.e.p.l.L(q.this.f63549b, R.string.neterror);
                return;
            }
            if (q.this.f63554g.s != 1) {
                if (q.this.f63554g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
            }
            if (q.this.n) {
                q.this.m.L(q.this.f63554g.r);
            }
            q.this.m.N(q.this.f63554g.f14275e, q.this.f63554g.j, q.this.f63554g.f14276f, q.this.f63554g.f14277g, 0, 0, true, q.this.f63554g.r.V());
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d(q qVar) {
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements SetPrivacyModel.a {
        public e() {
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            d.a.c.e.p.l.M(q.this.f63549b, str);
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.f63554g.q) {
                q.this.f63554g.q = false;
                d.a.c.e.p.l.L(q.this.f63549b, R.string.thread_has_open);
                if (q.this.f63556i != null) {
                    q.this.f63556i.n(q.this.f63549b.getString(R.string.set_thread_privacy));
                }
                if (q.this.f63553f != null) {
                    q.this.f63553f.a(false);
                    return;
                }
                return;
            }
            q.this.f63554g.q = true;
            if (q.this.f63556i != null) {
                q.this.f63556i.n(q.this.f63549b.getString(R.string.set_thread_public_open));
            }
            if (q.this.f63553f != null) {
                q.this.f63553f.a(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.f63554g.f14276f));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements l.d {
        public f() {
        }

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            if (!d.a.c.e.p.j.A()) {
                d.a.c.e.p.l.L(q.this.f63549b, R.string.neterror);
                return;
            }
            if (q.this.f63554g.q) {
                if (q.this.f63554g.s == 1) {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                }
            } else if (q.this.f63554g.s != 1) {
                if (q.this.f63554g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
            }
            if (q.this.l == null) {
                q.this.l = new SetPrivacyModel(q.this.f63548a, q.this.f63554g);
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

        @Override // d.a.m0.r.s.l.d
        public void onClick() {
            if (!d.a.c.e.p.j.A()) {
                d.a.c.e.p.l.L(q.this.f63549b, R.string.neterror);
                return;
            }
            if (q.this.f63554g != null && q.this.m != null) {
                q.this.p();
                q.this.f63552e.show();
            }
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class h extends d.a.c.a.e {
        public h() {
        }

        @Override // d.a.c.a.e
        public void c(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f20827c == 0) {
                    d.a.c.e.p.l.L(q.this.f63549b, R.string.delete_success);
                    if (q.this.f63554g != null) {
                        if (d.a.c.e.p.k.isEmpty(q.this.f63554g.I)) {
                            if (d.a.c.e.p.k.isEmpty(q.this.f63554g.f14276f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.f63554g.f14276f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.f63554g.I));
                    }
                } else if (!d.a.c.e.p.k.isEmpty(bVar.f20826b)) {
                    d.a.c.e.p.l.M(q.this.f63549b, bVar.f20826b);
                } else {
                    d.a.c.e.p.l.L(q.this.f63549b, R.string.delete_fail);
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
        this.f63548a = tbPageContext;
        this.f63549b = tbPageContext.getPageActivity();
        this.f63555h = new ArrayList();
        this.f63551d = new d.a.m0.r.s.l(this.f63549b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f63548a);
        this.m = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.t);
        this.o = new d.a.n0.y.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        d.a.m0.r.s.h hVar;
        this.f63554g = cardPersonDynamicThreadData;
        if (cardPersonDynamicThreadData == null || (hVar = this.f63556i) == null) {
            return;
        }
        if (cardPersonDynamicThreadData.q) {
            hVar.n(this.f63549b.getString(R.string.set_thread_public_open));
        } else {
            hVar.n(this.f63549b.getString(R.string.set_thread_privacy));
        }
        this.f63556i.p(z);
        if (this.j != null) {
            if (TbSingleton.getInstance().mCanCallFans) {
                this.j.n(this.f63549b.getString(R.string.call_fans));
            } else {
                if (TbSingleton.getInstance().mCallFansTid != null && this.f63554g.m() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f63554g.m().y1())) {
                    this.j.n(this.f63549b.getString(R.string.have_called_fans));
                } else {
                    this.j.n(this.f63549b.getString(R.string.call_fans));
                }
                this.j.o(R.color.cp_cont_b_alpha33);
            }
            this.j.p(z);
        }
    }

    public void o() {
        if (this.f63550c != null) {
            return;
        }
        d.a.m0.r.s.h hVar = new d.a.m0.r.s.h(this.f63551d);
        this.f63556i = hVar;
        hVar.m(this.r);
        if (!this.n) {
            this.f63555h.add(this.f63556i);
        }
        if (TbSingleton.getInstance().mShowCallFans && !this.n) {
            d.a.m0.r.s.h hVar2 = new d.a.m0.r.s.h(this.f63549b.getString(R.string.call_fans), this.f63551d);
            this.j = hVar2;
            hVar2.m(this.p);
            this.f63555h.add(this.j);
        }
        d.a.m0.r.s.h hVar3 = new d.a.m0.r.s.h(this.f63549b.getString(R.string.delete), this.f63551d);
        this.k = hVar3;
        hVar3.m(this.s);
        this.f63555h.add(this.k);
        this.f63551d.m(new a());
        this.f63551d.k(this.f63555h);
        this.f63550c = new d.a.m0.r.s.j(this.f63548a, this.f63551d);
    }

    public final void p() {
        a2 a2Var;
        if (this.f63552e != null) {
            return;
        }
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f63548a.getPageActivity());
        this.f63552e = aVar;
        if (this.n) {
            aVar.setMessageId(R.string.del_dynamic_confirm);
        } else {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f63554g;
            if (cardPersonDynamicThreadData != null && (a2Var = cardPersonDynamicThreadData.r) != null && a2Var.X1()) {
                this.f63552e.setMessageId(R.string.del_work_thread_confirm);
            } else {
                this.f63552e.setMessageId(R.string.del_thread_confirm);
            }
        }
        this.f63552e.setPositiveButton(R.string.dialog_ok, new c());
        this.f63552e.setNegativeButton(R.string.dialog_cancel, new d(this));
        this.f63552e.setCancelable(true);
        this.f63552e.create(this.f63548a);
    }

    public void q() {
        d.a.m0.r.s.j jVar = this.f63550c;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f63550c.dismiss();
    }

    public void r() {
        d.a.m0.r.s.l lVar = this.f63551d;
        if (lVar != null) {
            lVar.j();
        }
        d.a.m0.r.s.a aVar = this.f63552e;
        if (aVar != null) {
            d.a.m0.s0.a.a(this.f63548a, aVar.getRealView());
        }
    }

    public void s(i iVar) {
        this.f63553f = iVar;
    }

    public void t(boolean z) {
        this.n = z;
    }

    public void u() {
        d.a.m0.r.s.j jVar = this.f63550c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
