package d.a.o0.z;

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
import d.a.n0.r.q.a2;
import d.a.n0.r.s.a;
import d.a.n0.r.s.l;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes4.dex */
public class q {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f67391a;

    /* renamed from: b  reason: collision with root package name */
    public Context f67392b;

    /* renamed from: c  reason: collision with root package name */
    public d.a.n0.r.s.j f67393c;

    /* renamed from: d  reason: collision with root package name */
    public d.a.n0.r.s.l f67394d;

    /* renamed from: e  reason: collision with root package name */
    public d.a.n0.r.s.a f67395e;

    /* renamed from: f  reason: collision with root package name */
    public i f67396f;

    /* renamed from: g  reason: collision with root package name */
    public CardPersonDynamicThreadData f67397g;

    /* renamed from: h  reason: collision with root package name */
    public List<d.a.n0.r.s.h> f67398h;

    /* renamed from: i  reason: collision with root package name */
    public d.a.n0.r.s.h f67399i;
    public d.a.n0.r.s.h j;
    public d.a.n0.r.s.h k;
    public SetPrivacyModel l;
    public ForumManageModel m;
    public d.a.o0.y.a o;
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

        @Override // d.a.n0.r.s.l.c
        public void onClick() {
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements l.d {
        public b() {
        }

        @Override // d.a.n0.r.s.l.d
        public void onClick() {
            int i2;
            if (q.this.f67397g == null) {
                return;
            }
            q.this.q();
            int i3 = 2;
            if (q.this.f67397g.s == 1) {
                i2 = 2;
            } else {
                int i4 = q.this.f67397g.s;
                i2 = 1;
            }
            if (q.this.f67397g == null || !q.this.f67397g.q) {
                if (q.this.f67397g.i() != null) {
                    q.this.o.i(q.this.f67397g.i().z1());
                }
                i3 = (TbSingleton.getInstance().mCallFansTid == null || q.this.f67397g.i() == null || !TbSingleton.getInstance().mCallFansTid.equals(q.this.f67397g.i().z1())) ? 1 : 1;
                q.this.o.c();
                if (q.this.f67397g.i() != null) {
                    q.this.o.e(i2, i3, q.this.f67397g.i().z1());
                    return;
                }
                return;
            }
            q.this.f67391a.showToast(R.string.privacy_thread_can_not_use_call_fans);
            if (q.this.f67397g.i() != null) {
                q.this.o.e(i2, 3, q.this.f67397g.i().z1());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements a.e {
        public c() {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            if (!d.a.c.e.p.j.A()) {
                d.a.c.e.p.l.L(q.this.f67392b, R.string.neterror);
                return;
            }
            if (q.this.f67397g.s != 1) {
                if (q.this.f67397g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 1));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 3));
            }
            if (q.this.n) {
                q.this.m.P(q.this.f67397g.r);
            }
            q.this.m.R(q.this.f67397g.f14414e, q.this.f67397g.j, q.this.f67397g.f14415f, q.this.f67397g.f14416g, 0, 0, true, q.this.f67397g.r.V());
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements a.e {
        public d(q qVar) {
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            aVar.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements SetPrivacyModel.a {
        public e() {
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onError(String str) {
            d.a.c.e.p.l.M(q.this.f67392b, str);
        }

        @Override // com.baidu.tieba.model.SetPrivacyModel.a
        public void onSuccess() {
            if (q.this.f67397g.q) {
                q.this.f67397g.q = false;
                d.a.c.e.p.l.L(q.this.f67392b, R.string.thread_has_open);
                if (q.this.f67399i != null) {
                    q.this.f67399i.n(q.this.f67392b.getString(R.string.set_thread_privacy));
                }
                if (q.this.f67396f != null) {
                    q.this.f67396f.a(false);
                    return;
                }
                return;
            }
            q.this.f67397g.q = true;
            if (q.this.f67399i != null) {
                q.this.f67399i.n(q.this.f67392b.getString(R.string.set_thread_public_open));
            }
            if (q.this.f67396f != null) {
                q.this.f67396f.a(true);
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016558, q.this.f67397g.f14415f));
        }
    }

    /* loaded from: classes4.dex */
    public class f implements l.d {
        public f() {
        }

        @Override // d.a.n0.r.s.l.d
        public void onClick() {
            if (!d.a.c.e.p.j.A()) {
                d.a.c.e.p.l.L(q.this.f67392b, R.string.neterror);
                return;
            }
            if (q.this.f67397g.q) {
                if (q.this.f67397g.s == 1) {
                    TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 2));
                }
            } else if (q.this.f67397g.s != 1) {
                if (q.this.f67397g.s == 3) {
                    TiebaStatic.log(new StatisticItem("c12600").param("obj_type", 2));
                }
            } else {
                TiebaStatic.log(new StatisticItem("c12599").param("obj_type", 1));
            }
            if (q.this.l == null) {
                q.this.l = new SetPrivacyModel(q.this.f67391a, q.this.f67397g);
            }
            if (!q.this.l.C()) {
                q.this.l.D(q.this.q);
                q.this.l.LoadData();
            }
            q.this.q();
        }
    }

    /* loaded from: classes4.dex */
    public class g implements l.d {
        public g() {
        }

        @Override // d.a.n0.r.s.l.d
        public void onClick() {
            if (!d.a.c.e.p.j.A()) {
                d.a.c.e.p.l.L(q.this.f67392b, R.string.neterror);
                return;
            }
            if (q.this.f67397g != null && q.this.m != null) {
                q.this.p();
                q.this.f67395e.show();
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
                if (bVar.f20986c == 0) {
                    d.a.c.e.p.l.L(q.this.f67392b, R.string.delete_success);
                    if (q.this.f67397g != null) {
                        if (d.a.c.e.p.k.isEmpty(q.this.f67397g.I)) {
                            if (d.a.c.e.p.k.isEmpty(q.this.f67397g.f14415f)) {
                                return;
                            }
                            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016557, q.this.f67397g.f14415f));
                            return;
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921436, q.this.f67397g.I));
                    }
                } else if (!d.a.c.e.p.k.isEmpty(bVar.f20985b)) {
                    d.a.c.e.p.l.M(q.this.f67392b, bVar.f20985b);
                } else {
                    d.a.c.e.p.l.L(q.this.f67392b, R.string.delete_fail);
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
        this.f67391a = tbPageContext;
        this.f67392b = tbPageContext.getPageActivity();
        this.f67398h = new ArrayList();
        this.f67394d = new d.a.n0.r.s.l(this.f67392b);
        ForumManageModel forumManageModel = new ForumManageModel(this.f67391a);
        this.m = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.t);
        this.o = new d.a.o0.y.a(tbPageContext);
    }

    public void n(CardPersonDynamicThreadData cardPersonDynamicThreadData, boolean z) {
        d.a.n0.r.s.h hVar;
        this.f67397g = cardPersonDynamicThreadData;
        if (cardPersonDynamicThreadData == null || (hVar = this.f67399i) == null) {
            return;
        }
        if (cardPersonDynamicThreadData.q) {
            hVar.n(this.f67392b.getString(R.string.set_thread_public_open));
        } else {
            hVar.n(this.f67392b.getString(R.string.set_thread_privacy));
        }
        this.f67399i.p(z);
        if (this.j != null) {
            if (TbSingleton.getInstance().mCanCallFans) {
                this.j.n(this.f67392b.getString(R.string.call_fans));
            } else {
                if (TbSingleton.getInstance().mCallFansTid != null && this.f67397g.i() != null && TbSingleton.getInstance().mCallFansTid.equals(this.f67397g.i().z1())) {
                    this.j.n(this.f67392b.getString(R.string.have_called_fans));
                } else {
                    this.j.n(this.f67392b.getString(R.string.call_fans));
                }
                this.j.o(R.color.cp_cont_b_alpha33);
            }
            this.j.p(z);
        }
    }

    public void o() {
        if (this.f67393c != null) {
            return;
        }
        d.a.n0.r.s.h hVar = new d.a.n0.r.s.h(this.f67394d);
        this.f67399i = hVar;
        hVar.m(this.r);
        if (!this.n) {
            this.f67398h.add(this.f67399i);
        }
        if (TbSingleton.getInstance().mShowCallFans && !this.n) {
            d.a.n0.r.s.h hVar2 = new d.a.n0.r.s.h(this.f67392b.getString(R.string.call_fans), this.f67394d);
            this.j = hVar2;
            hVar2.m(this.p);
            this.f67398h.add(this.j);
        }
        d.a.n0.r.s.h hVar3 = new d.a.n0.r.s.h(this.f67392b.getString(R.string.delete), this.f67394d);
        this.k = hVar3;
        hVar3.m(this.s);
        this.f67398h.add(this.k);
        this.f67394d.m(new a());
        this.f67394d.k(this.f67398h);
        this.f67393c = new d.a.n0.r.s.j(this.f67391a, this.f67394d);
    }

    public final void p() {
        a2 a2Var;
        if (this.f67395e != null) {
            return;
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f67391a.getPageActivity());
        this.f67395e = aVar;
        if (this.n) {
            aVar.setMessageId(R.string.del_dynamic_confirm);
        } else {
            CardPersonDynamicThreadData cardPersonDynamicThreadData = this.f67397g;
            if (cardPersonDynamicThreadData != null && (a2Var = cardPersonDynamicThreadData.r) != null && a2Var.Y1()) {
                this.f67395e.setMessageId(R.string.del_work_thread_confirm);
            } else {
                this.f67395e.setMessageId(R.string.del_thread_confirm);
            }
        }
        this.f67395e.setPositiveButton(R.string.dialog_ok, new c());
        this.f67395e.setNegativeButton(R.string.dialog_cancel, new d(this));
        this.f67395e.setCancelable(true);
        this.f67395e.create(this.f67391a);
    }

    public void q() {
        d.a.n0.r.s.j jVar = this.f67393c;
        if (jVar == null || !jVar.isShowing()) {
            return;
        }
        this.f67393c.dismiss();
    }

    public void r() {
        d.a.n0.r.s.l lVar = this.f67394d;
        if (lVar != null) {
            lVar.j();
        }
        d.a.n0.r.s.a aVar = this.f67395e;
        if (aVar != null) {
            d.a.n0.s0.a.a(this.f67391a, aVar.getRealView());
        }
    }

    public void s(i iVar) {
        this.f67396f = iVar;
    }

    public void t(boolean z) {
        this.n = z;
    }

    public void u() {
        d.a.n0.r.s.j jVar = this.f67393c;
        if (jVar == null) {
            return;
        }
        jVar.l();
    }
}
