package d.b.j0.x;

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
import d.b.i0.r.q.a2;
import d.b.i0.r.s.a;
import d.b.i0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f64277a;

    /* renamed from: b  reason: collision with root package name */
    public Context f64278b;

    /* renamed from: c  reason: collision with root package name */
    public d.b.i0.r.s.j f64279c;

    /* renamed from: d  reason: collision with root package name */
    public d.b.i0.r.s.l f64280d;

    /* renamed from: e  reason: collision with root package name */
    public d.b.i0.r.s.a f64281e;

    /* renamed from: f  reason: collision with root package name */
    public i f64282f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f64283g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.b.i0.r.s.h> f64284h;
    public d.b.i0.r.s.h i;
    public d.b.i0.r.s.h j;
    public d.b.i0.r.s.h k;
    public SetPrivacyModel l;
    public ForumManageModel m;
    public d.b.j0.w.a o;
    public boolean n = false;
    public l.d p = new b();
    public SetPrivacyModel.a q = new e();
    public l.d r = new f();
    public l.d s = new g();
    public d.b.c.a.e t = new h();

    /* loaded from: classes4.dex */
    public class a implements l.c {
        public a() {
        }

        @Override // d.b.i0.r.s.l.c
        public void onClick() {
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l.d {
        public b() {
        }

        @Override // d.b.i0.r.s.l.d
        public void onClick() {
            int i;
            if (q.this.f64283g == null) {
                return;
            }
            q.this.q();
            int i2 = 2;
            if (q.this.f64283g.s == 1) {
                i = 2;
            } else {
                int i3 = q.this.f64283g.s;
                i = 1;
            }
            if (q.this.f64283g == null || !q.this.f64283g.q) {
                if (q.this.f64283g.n() != null) {
                    q.this.o.i(q.this.f64283g.n().w1());
                }
                i2 = (TbSingleton.getInstance().mCallFansTid == null || q.this.f64283g.n() == null || !TbSingleton.getInstance().mCallFansTid.equals(q.this.f64283g.n().w1())) ? 1 : 1;
                q.this.o.c();
                if (q.this.f64283g.n() != null) {
                    q.this.o.e(i, i2, q.this.f64283g.n().w1());
                    return;
                }
                return;
            }
            q.this.f64277a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (q.this.f64283g.n() != null) {
                q.this.o.e(i, 3, q.this.f64283g.n().w1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            if (!d.b.c.e.p.j.A()) {
                d.b.c.e.p.l.K(q.this.f64278b, R.string.neterror);
                return;
            }
            if (q.this.f64283g.s != 1) {
                if (q.this.f64283g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
            }
            if (q.this.n) {
                q.this.m.L(q.this.f64283g.r);
            }
            q.this.m.N(q.this.f64283g.f14946e, q.this.f64283g.j, q.this.f64283g.f14947f, q.this.f64283g.f14948g, 0, 0, true, q.this.f64283g.r.V());
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d(q qVar) {
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements SetPrivacyModel.a {
        public e() {
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            d.b.c.e.p.l.L(q.this.f64278b, str);
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.f64283g.q) {
                q.this.f64283g.q = false;
                d.b.c.e.p.l.K(q.this.f64278b, R.string.thread_has_open);
                if (q.this.i != null) {
                    q.this.i.n(q.this.f64278b.getString(R.string.set_thread_privacy));
                }
                if (q.this.f64282f != null) {
                    q.this.f64282f.a(false);
                    return;
                }
                return;
            }
            q.this.f64283g.q = true;
            if (q.this.i != null) {
                q.this.i.n(q.this.f64278b.getString(R.string.set_thread_public_open));
            }
            if (q.this.f64282f != null) {
                q.this.f64282f.a(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.f64283g.f14947f));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements l.d {
        public f() {
        }

        @Override // d.b.i0.r.s.l.d
        public void onClick() {
            if (!d.b.c.e.p.j.A()) {
                d.b.c.e.p.l.K(q.this.f64278b, R.string.neterror);
                return;
            }
            if (q.this.f64283g.q) {
                if (q.this.f64283g.s == 1) {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                }
            } else if (q.this.f64283g.s != 1) {
                if (q.this.f64283g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
            }
            if (q.this.l == null) {
                q.this.l = new SetPrivacyModel(q.this.f64277a, q.this.f64283g);
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

        @Override // d.b.i0.r.s.l.d
        public void onClick() {
            if (!d.b.c.e.p.j.A()) {
                d.b.c.e.p.l.K(q.this.f64278b, R.string.neterror);
                return;
            }
            if (q.this.f64283g != null && q.this.m != null) {
                q.this.p();
                q.this.f64281e.show();
            }
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class h extends d.b.c.a.e {
        public h() {
        }

        @Override // d.b.c.a.e
        public void c(Object obj) {
            if (obj instanceof ForumManageModel.b) {
                ForumManageModel.b bVar = (ForumManageModel.b) obj;
                if (bVar.f21075c == 0) {
                    d.b.c.e.p.l.K(q.this.f64278b, R.string.delete_success);
                    if (q.this.f64283g != null) {
                        if (d.b.c.e.p.k.isEmpty(q.this.f64283g.I)) {
                            if (d.b.c.e.p.k.isEmpty(q.this.f64283g.f14947f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.f64283g.f14947f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.f64283g.I));
                    }
                } else if (!d.b.c.e.p.k.isEmpty(bVar.f21074b)) {
                    d.b.c.e.p.l.L(q.this.f64278b, bVar.f21074b);
                } else {
                    d.b.c.e.p.l.K(q.this.f64278b, R.string.delete_fail);
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
        this.f64277a = tbPageContext;
        this.f64278b = tbPageContext.getPageActivity();
        this.f64284h = new ArrayList();
        this.f64280d = new d.b.i0.r.s.l(this.f64278b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f64277a);
        this.m = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.t);
        this.o = new d.b.j0.w.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        d.b.i0.r.s.h hVar;
        this.f64283g = cardPersonDynamicThreadData;
        if (cardPersonDynamicThreadData == null || (hVar = this.i) == null) {
            return;
        }
        if (cardPersonDynamicThreadData.q) {
            hVar.n(this.f64278b.getString(R.string.set_thread_public_open));
        } else {
            hVar.n(this.f64278b.getString(R.string.set_thread_privacy));
        }
        this.i.p(z);
        if (this.j != null) {
            if (TbSingleton.getInstance().mCanCallFans) {
                this.j.n(this.f64278b.getString(R.string.call_fans));
            } else {
                if (TbSingleton.getInstance().mCallFansTid != null && this.f64283g.n() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f64283g.n().w1())) {
                    this.j.n(this.f64278b.getString(R.string.have_called_fans));
                } else {
                    this.j.n(this.f64278b.getString(R.string.call_fans));
                }
                this.j.o(R.color.cp_cont_b_alpha33);
            }
            this.j.p(z);
        }
    }

    public void o() {
        if (this.f64279c != null) {
            return;
        }
        d.b.i0.r.s.h hVar = new d.b.i0.r.s.h(this.f64280d);
        this.i = hVar;
        hVar.m(this.r);
        if (!this.n) {
            this.f64284h.add(this.i);
        }
        if (TbSingleton.getInstance().mShowCallFans && !this.n) {
            d.b.i0.r.s.h hVar2 = new d.b.i0.r.s.h(this.f64278b.getString(R.string.call_fans), this.f64280d);
            this.j = hVar2;
            hVar2.m(this.p);
            this.f64284h.add(this.j);
        }
        d.b.i0.r.s.h hVar3 = new d.b.i0.r.s.h(this.f64278b.getString(R.string.delete), this.f64280d);
        this.k = hVar3;
        hVar3.m(this.s);
        this.f64284h.add(this.k);
        this.f64280d.m(new a());
        this.f64280d.k(this.f64284h);
        this.f64279c = new d.b.i0.r.s.j(this.f64277a, this.f64280d);
    }

    public final void p() {
        a2 a2Var;
        if (this.f64281e != null) {
            return;
        }
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f64277a.getPageActivity());
        this.f64281e = aVar;
        if (this.n) {
            aVar.setMessageId(R.string.del_dynamic_confirm);
        } else {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f64283g;
            if (cardPersonDynamicThreadData != null && (a2Var = cardPersonDynamicThreadData.r) != null && a2Var.V1()) {
                this.f64281e.setMessageId(R.string.del_work_thread_confirm);
            } else {
                this.f64281e.setMessageId(R.string.del_thread_confirm);
            }
        }
        this.f64281e.setPositiveButton(R.string.dialog_ok, new c());
        this.f64281e.setNegativeButton(R.string.dialog_cancel, new d(this));
        this.f64281e.setCancelable(true);
        this.f64281e.create(this.f64277a);
    }

    public void q() {
        d.b.i0.r.s.j jVar = this.f64279c;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f64279c.dismiss();
    }

    public void r() {
        d.b.i0.r.s.l lVar = this.f64280d;
        if (lVar != null) {
            lVar.j();
        }
        d.b.i0.r.s.a aVar = this.f64281e;
        if (aVar != null) {
            d.b.i0.s0.a.a(this.f64277a, aVar.getRealView());
        }
    }

    public void s(i iVar) {
        this.f64282f = iVar;
    }

    public void t(boolean z) {
        this.n = z;
    }

    public void u() {
        d.b.i0.r.s.j jVar = this.f64279c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
