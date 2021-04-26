package d.a.j0.x;

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
import d.a.i0.r.q.a2;
import d.a.i0.r.s.a;
import d.a.i0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f62544a;

    /* renamed from: b  reason: collision with root package name */
    public Context f62545b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.i0.r.s.j f62546c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.i0.r.s.l f62547d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.i0.r.s.a f62548e;

    /* renamed from: f  reason: collision with root package name */
    public i f62549f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f62550g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.a.i0.r.s.h> f62551h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.i0.r.s.h f62552i;
    public d.a.i0.r.s.h j;
    public d.a.i0.r.s.h k;
    public SetPrivacyModel l;
    public ForumManageModel m;
    public d.a.j0.w.a o;
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

        @Override // d.a.i0.r.s.l.c
        public void onClick() {
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l.d {
        public b() {
        }

        @Override // d.a.i0.r.s.l.d
        public void onClick() {
            int i2;
            if (q.this.f62550g == null) {
                return;
            }
            q.this.q();
            int i3 = 2;
            if (q.this.f62550g.s == 1) {
                i2 = 2;
            } else {
                int i4 = q.this.f62550g.s;
                i2 = 1;
            }
            if (q.this.f62550g == null || !q.this.f62550g.q) {
                if (q.this.f62550g.m() != null) {
                    q.this.o.i(q.this.f62550g.m().w1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || q.this.f62550g.m() == null || !TbSingleton.getInstance().mCallFansTid.equals(q.this.f62550g.m().w1())) ? 1 : 1;
                q.this.o.c();
                if (q.this.f62550g.m() != null) {
                    q.this.o.e(i2, i3, q.this.f62550g.m().w1());
                    return;
                }
                return;
            }
            q.this.f62544a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (q.this.f62550g.m() != null) {
                q.this.o.e(i2, 3, q.this.f62550g.m().w1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            if (!d.a.c.e.p.j.A()) {
                d.a.c.e.p.l.L(q.this.f62545b, R.string.neterror);
                return;
            }
            if (q.this.f62550g.s != 1) {
                if (q.this.f62550g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
            }
            if (q.this.n) {
                q.this.m.L(q.this.f62550g.r);
            }
            q.this.m.N(q.this.f62550g.f15057e, q.this.f62550g.j, q.this.f62550g.f15058f, q.this.f62550g.f15059g, 0, 0, true, q.this.f62550g.r.V());
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d(q qVar) {
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements SetPrivacyModel.a {
        public e() {
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            d.a.c.e.p.l.M(q.this.f62545b, str);
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.f62550g.q) {
                q.this.f62550g.q = false;
                d.a.c.e.p.l.L(q.this.f62545b, R.string.thread_has_open);
                if (q.this.f62552i != null) {
                    q.this.f62552i.n(q.this.f62545b.getString(R.string.set_thread_privacy));
                }
                if (q.this.f62549f != null) {
                    q.this.f62549f.a(false);
                    return;
                }
                return;
            }
            q.this.f62550g.q = true;
            if (q.this.f62552i != null) {
                q.this.f62552i.n(q.this.f62545b.getString(R.string.set_thread_public_open));
            }
            if (q.this.f62549f != null) {
                q.this.f62549f.a(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.f62550g.f15058f));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements l.d {
        public f() {
        }

        @Override // d.a.i0.r.s.l.d
        public void onClick() {
            if (!d.a.c.e.p.j.A()) {
                d.a.c.e.p.l.L(q.this.f62545b, R.string.neterror);
                return;
            }
            if (q.this.f62550g.q) {
                if (q.this.f62550g.s == 1) {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                }
            } else if (q.this.f62550g.s != 1) {
                if (q.this.f62550g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
            }
            if (q.this.l == null) {
                q.this.l = new SetPrivacyModel(q.this.f62544a, q.this.f62550g);
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

        @Override // d.a.i0.r.s.l.d
        public void onClick() {
            if (!d.a.c.e.p.j.A()) {
                d.a.c.e.p.l.L(q.this.f62545b, R.string.neterror);
                return;
            }
            if (q.this.f62550g != null && q.this.m != null) {
                q.this.p();
                q.this.f62548e.show();
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
                if (bVar.f21663c == 0) {
                    d.a.c.e.p.l.L(q.this.f62545b, R.string.delete_success);
                    if (q.this.f62550g != null) {
                        if (d.a.c.e.p.k.isEmpty(q.this.f62550g.I)) {
                            if (d.a.c.e.p.k.isEmpty(q.this.f62550g.f15058f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.f62550g.f15058f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.f62550g.I));
                    }
                } else if (!d.a.c.e.p.k.isEmpty(bVar.f21662b)) {
                    d.a.c.e.p.l.M(q.this.f62545b, bVar.f21662b);
                } else {
                    d.a.c.e.p.l.L(q.this.f62545b, R.string.delete_fail);
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
        this.f62544a = tbPageContext;
        this.f62545b = tbPageContext.getPageActivity();
        this.f62551h = new ArrayList();
        this.f62547d = new d.a.i0.r.s.l(this.f62545b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f62544a);
        this.m = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.t);
        this.o = new d.a.j0.w.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        d.a.i0.r.s.h hVar;
        this.f62550g = cardPersonDynamicThreadData;
        if (cardPersonDynamicThreadData == null || (hVar = this.f62552i) == null) {
            return;
        }
        if (cardPersonDynamicThreadData.q) {
            hVar.n(this.f62545b.getString(R.string.set_thread_public_open));
        } else {
            hVar.n(this.f62545b.getString(R.string.set_thread_privacy));
        }
        this.f62552i.p(z);
        if (this.j != null) {
            if (TbSingleton.getInstance().mCanCallFans) {
                this.j.n(this.f62545b.getString(R.string.call_fans));
            } else {
                if (TbSingleton.getInstance().mCallFansTid != null && this.f62550g.m() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f62550g.m().w1())) {
                    this.j.n(this.f62545b.getString(R.string.have_called_fans));
                } else {
                    this.j.n(this.f62545b.getString(R.string.call_fans));
                }
                this.j.o(R.color.cp_cont_b_alpha33);
            }
            this.j.p(z);
        }
    }

    public void o() {
        if (this.f62546c != null) {
            return;
        }
        d.a.i0.r.s.h hVar = new d.a.i0.r.s.h(this.f62547d);
        this.f62552i = hVar;
        hVar.m(this.r);
        if (!this.n) {
            this.f62551h.add(this.f62552i);
        }
        if (TbSingleton.getInstance().mShowCallFans && !this.n) {
            d.a.i0.r.s.h hVar2 = new d.a.i0.r.s.h(this.f62545b.getString(R.string.call_fans), this.f62547d);
            this.j = hVar2;
            hVar2.m(this.p);
            this.f62551h.add(this.j);
        }
        d.a.i0.r.s.h hVar3 = new d.a.i0.r.s.h(this.f62545b.getString(R.string.delete), this.f62547d);
        this.k = hVar3;
        hVar3.m(this.s);
        this.f62551h.add(this.k);
        this.f62547d.m(new a());
        this.f62547d.k(this.f62551h);
        this.f62546c = new d.a.i0.r.s.j(this.f62544a, this.f62547d);
    }

    public final void p() {
        a2 a2Var;
        if (this.f62548e != null) {
            return;
        }
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f62544a.getPageActivity());
        this.f62548e = aVar;
        if (this.n) {
            aVar.setMessageId(R.string.del_dynamic_confirm);
        } else {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f62550g;
            if (cardPersonDynamicThreadData != null && (a2Var = cardPersonDynamicThreadData.r) != null && a2Var.V1()) {
                this.f62548e.setMessageId(R.string.del_work_thread_confirm);
            } else {
                this.f62548e.setMessageId(R.string.del_thread_confirm);
            }
        }
        this.f62548e.setPositiveButton(R.string.dialog_ok, new c());
        this.f62548e.setNegativeButton(R.string.dialog_cancel, new d(this));
        this.f62548e.setCancelable(true);
        this.f62548e.create(this.f62544a);
    }

    public void q() {
        d.a.i0.r.s.j jVar = this.f62546c;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f62546c.dismiss();
    }

    public void r() {
        d.a.i0.r.s.l lVar = this.f62547d;
        if (lVar != null) {
            lVar.j();
        }
        d.a.i0.r.s.a aVar = this.f62548e;
        if (aVar != null) {
            d.a.i0.s0.a.a(this.f62544a, aVar.getRealView());
        }
    }

    public void s(i iVar) {
        this.f62549f = iVar;
    }

    public void t(boolean z) {
        this.n = z;
    }

    public void u() {
        d.a.i0.r.s.j jVar = this.f62546c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
