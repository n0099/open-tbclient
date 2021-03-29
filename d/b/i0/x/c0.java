package d.b.i0.x;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForbidActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.BlueCheckRadioButton;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.model.ForumManageModel;
import d.b.h0.r.q.a2;
import d.b.h0.r.q.l0;
import d.b.h0.r.s.a;
import d.b.h0.r.s.l;
import d.b.i0.p0.w0;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import tbclient.BawuThrones;
/* loaded from: classes4.dex */
public class c0 extends d.b.h0.r.s.j {
    public boolean A;
    public final CompoundButton.OnCheckedChangeListener B;
    public final d.b.b.a.e C;
    public final l.e D;
    public TbPageContext o;
    public Context p;
    public final d.b.h0.r.s.l q;
    public d.b.h0.r.s.a r;
    public d.b.h0.r.s.a s;
    public Dialog t;
    public final List<d.b.h0.r.s.h> u;
    public String v;
    public String w;
    public List<BlueCheckRadioButton> x;
    public a2 y;
    public ForumManageModel z;

    /* loaded from: classes4.dex */
    public class a implements a.e {
        public a() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
            if (!d.b.b.e.p.j.A()) {
                d.b.b.e.p.l.K(c0.this.p, R.string.neterror);
            } else {
                c0.this.b0(null);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {
        public b() {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            if (aVar != null) {
                aVar.dismiss();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.m.g.b(c0.this.t, c0.this.o);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.b.b.e.m.g.b(c0.this.t, c0.this.o);
            c0 c0Var = c0.this;
            c0Var.d0(c0Var.w, false);
        }
    }

    /* loaded from: classes4.dex */
    public class e implements CompoundButton.OnCheckedChangeListener {
        public e() {
        }

        @Override // android.widget.CompoundButton.OnCheckedChangeListener
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (z && (compoundButton.getTag() instanceof String)) {
                c0.this.w = (String) compoundButton.getTag();
                if (c0.this.x != null) {
                    for (BlueCheckRadioButton blueCheckRadioButton : c0.this.x) {
                        String str = (String) blueCheckRadioButton.getTag();
                        if (str != null && c0.this.w != null && !str.equals(c0.this.w)) {
                            blueCheckRadioButton.setChecked(false);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public class f extends d.b.b.a.e {

        /* loaded from: classes4.dex */
        public class a implements a.e {
            public a(f fVar) {
            }

            @Override // d.b.h0.r.s.a.e
            public void onClick(d.b.h0.r.s.a aVar) {
                if (aVar != null) {
                    aVar.dismiss();
                }
            }
        }

        public f() {
        }

        @Override // d.b.b.a.e
        public void c(Object obj) {
            if (obj == null || c0.this.z == null) {
                return;
            }
            switch (c0.this.z.getLoadDataMode()) {
                case 0:
                    ForumManageModel.b bVar = (ForumManageModel.b) obj;
                    if (bVar == null || bVar.f21383d != 0) {
                        d.b.b.e.p.l.L(c0.this.p, c0.this.T(R.string.delete_fail, new Object[0]));
                        return;
                    } else if (bVar.f21380a) {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921031, c0.this.y.o0()));
                        d.b.b.e.p.l.K(c0.this.p, R.string.delete_success);
                        return;
                    } else {
                        String T = !TextUtils.isEmpty(bVar.f21381b) ? bVar.f21381b : c0.this.T(R.string.delete_fail, new Object[0]);
                        if (bVar.f21382c == 1211066) {
                            if (c0.this.s == null) {
                                c0 c0Var = c0.this;
                                c0Var.s = new d.b.h0.r.s.a(c0Var.o.getPageActivity());
                                c0.this.s.setMessage(T);
                                c0.this.s.setPositiveButton(R.string.dialog_known, new a(this));
                                c0.this.s.setCancelable(true);
                                c0.this.s.create(c0.this.o);
                            }
                            c0.this.s.show();
                            return;
                        }
                        d.b.b.e.p.l.L(c0.this.p, T);
                        return;
                    }
                case 1:
                    ForumManageModel.d dVar = (ForumManageModel.d) obj;
                    if (dVar == null) {
                        d.b.b.e.p.l.L(c0.this.p, c0.this.T(R.string.mute_fail, new Object[0]));
                        return;
                    } else if (dVar.f21387a) {
                        d.b.b.e.p.l.L(c0.this.p, !TextUtils.isEmpty(dVar.f21388b) ? dVar.f21388b : c0.this.T(R.string.mute_success, new Object[0]));
                        return;
                    } else {
                        d.b.b.e.p.l.L(c0.this.p, !TextUtils.isEmpty(dVar.f21388b) ? dVar.f21388b : c0.this.T(R.string.mute_fail, new Object[0]));
                        return;
                    }
                case 2:
                case 3:
                case 4:
                case 5:
                    c0 c0Var2 = c0.this;
                    c0Var2.S(c0Var2.z.getLoadDataMode(), (ForumManageModel.g) obj);
                    return;
                case 6:
                    ForumManageModel.g gVar = (ForumManageModel.g) obj;
                    if (gVar == null || !gVar.f21401a) {
                        d.b.b.e.p.l.L(c0.this.p, c0.this.T(R.string.operation_failed, new Object[0]));
                        return;
                    } else {
                        c0.this.a0(gVar.f21403c);
                        return;
                    }
                default:
                    return;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class g implements l.e {
        public g() {
        }

        @Override // d.b.h0.r.s.l.e
        public void onItemClick(d.b.h0.r.s.l lVar, int i, View view) {
            c0.this.dismiss();
            if (!d.b.b.e.p.j.z()) {
                d.b.b.e.p.l.K(c0.this.p, R.string.network_not_available);
                return;
            }
            if (i == 1) {
                if (c0.this.y != null && c0.this.y.T() != null) {
                    if (UtilHelper.isCurrentAccount(c0.this.y.T().getUserId())) {
                        c0 c0Var = c0.this;
                        c0Var.Z(c0Var.y.V1());
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921515, new d.b.i0.h.g(1, c0.this.z, c0.this.y)));
                    }
                }
            } else if (i == 2) {
                c0.this.c0();
            } else if (i == 3) {
                c0.this.e0();
            } else if (i == 4) {
                c0 c0Var2 = c0.this;
                c0Var2.d0(c0Var2.v, true);
            } else if (i == 5) {
                c0.this.L();
            } else if (i == 6) {
                c0.this.X();
            } else if (i == 7) {
                c0.this.K();
            } else if (i == 8) {
                c0.this.J();
            }
            c0.this.V(i);
        }
    }

    public c0(TbPageContext tbPageContext, boolean z) {
        super(tbPageContext);
        this.v = "0";
        this.w = "0";
        this.A = false;
        this.B = new e();
        this.C = new f();
        this.D = new g();
        this.o = tbPageContext;
        this.p = tbPageContext.getPageActivity();
        this.u = new ArrayList();
        d.b.h0.r.s.l lVar = new d.b.h0.r.s.l(this.p);
        this.q = lVar;
        lVar.q(T(R.string.thread_manager, new Object[0]));
        this.q.n(this.D);
        ForumManageModel forumManageModel = new ForumManageModel(this.o);
        this.z = forumManageModel;
        forumManageModel.setLoadDataCallBack(this.C);
        this.A = z;
        h(this.q);
    }

    public final void J() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921475, this.y));
    }

    public final void K() {
        d.b.i0.p0.a.h().p(true, false);
    }

    public final void L() {
        d.b.i0.p0.b.e().m(true, false);
    }

    public final BlueCheckRadioButton M(String str, String str2) {
        BlueCheckRadioButton blueCheckRadioButton = new BlueCheckRadioButton(this.p);
        RadioGroup.LayoutParams layoutParams = new RadioGroup.LayoutParams(-1, d.b.b.e.p.l.g(this.p, R.dimen.ds100));
        blueCheckRadioButton.setOnCheckedChangeListener(this.B);
        blueCheckRadioButton.setTag(str);
        blueCheckRadioButton.setText(str2);
        blueCheckRadioButton.setLayoutParams(layoutParams);
        return blueCheckRadioButton;
    }

    public final void N() {
        List<d.b.h0.r.s.h> list;
        if (this.y == null || (list = this.u) == null || this.q == null) {
            return;
        }
        list.clear();
        if (d.b.i0.p0.j.c(d.b.i0.p0.j.a()) && !d.b.i0.p0.j.e()) {
            if (!this.y.S1() && (this.y.T() == null || !this.y.T().isForumBusinessAccount() || this.y.s() || w0.isOn())) {
                int i = R.string.delete_page;
                if (this.y.V1()) {
                    i = R.string.delete_page_work;
                }
                this.u.add(new d.b.h0.r.s.h(1, T(i, new Object[0]), this.q));
            }
            if (!UtilHelper.isCurrentAccount(this.y.T() != null ? this.y.T().getUserId() : "") && (this.y.T() == null || !this.y.T().isForumBusinessAccount())) {
                this.u.add(new d.b.h0.r.s.h(2, T(R.string.thread_forbid, new Object[0]), this.q));
            }
        }
        if (d.b.i0.p0.j.d() || d.b.i0.p0.j.e()) {
            this.u.add(new d.b.h0.r.s.h(3, T(this.y.x0() == 1 ? R.string.cancel_top : R.string.top, new Object[0]), this.q));
        }
        if (d.b.i0.p0.j.d() || d.b.i0.p0.j.f()) {
            this.u.add(new d.b.h0.r.s.h(4, T(this.y.w0() == 1 ? R.string.cancel_good : R.string.commit_good, new Object[0]), this.q));
        }
        if (d.b.i0.p0.j.d()) {
            this.u.add(new d.b.h0.r.s.h(6, T(R.string.frs_recommend_thread, new Object[0]), this.q));
        }
        if (d.b.i0.p0.j.d() && this.A) {
            this.u.add(new d.b.h0.r.s.h(7, T(R.string.frs_move_area_thread, new Object[0]), this.q));
        }
        if (d.b.i0.p0.j.d() || d.b.i0.p0.j.e()) {
            this.u.add(new d.b.h0.r.s.h(8, T(R.string.frs_forum_bawu_send_broadcast, new Object[0]), this.q));
        }
        if (!d.b.i0.p0.j.e() && d.b.i0.p0.b.e().h() && this.A && (this.y.T() == null || !this.y.T().isForumBusinessAccount() || this.y.s() || w0.isOn())) {
            this.u.add(new d.b.h0.r.s.h(5, T(R.string.multi_delete, new Object[0]), this.q));
        }
        this.q.k(this.u);
    }

    public void O() {
        P();
    }

    public void P() {
        Q();
        R();
        dismiss();
    }

    public void Q() {
        d.b.h0.r.s.a aVar = this.r;
        if (aVar == null || !aVar.isShowing()) {
            return;
        }
        this.r.dismiss();
    }

    public void R() {
        Dialog dialog = this.t;
        if (dialog == null || !dialog.isShowing()) {
            return;
        }
        this.t.dismiss();
    }

    public final void S(int i, ForumManageModel.g gVar) {
        String T;
        a2 a2Var = this.y;
        if (a2Var != null && gVar != null && gVar.f21401a) {
            String str = "";
            boolean z = true;
            if (i == 2) {
                a2Var.K3(1);
                d.b.h0.r.q.z zVar = new d.b.h0.r.q.z();
                zVar.f50944a = 2;
                zVar.f50945b = this.y.w1();
                if (d.b.i0.p0.j.d()) {
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, zVar));
                } else {
                    str = U(gVar.f21402b, R.string.set_good_success);
                    z = false;
                }
            } else {
                if (i == 3) {
                    a2Var.K3(0);
                    str = U(gVar.f21402b, R.string.operation_success);
                } else if (i == 4) {
                    a2Var.L3(1);
                    d.b.h0.r.q.z zVar2 = new d.b.h0.r.q.z();
                    zVar2.f50944a = 1;
                    zVar2.f50945b = this.y.w1();
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921469, zVar2));
                } else if (i == 5) {
                    a2Var.L3(0);
                    str = U(gVar.f21402b, R.string.operation_success);
                }
                z = false;
            }
            ForumManageModel.e eVar = new ForumManageModel.e();
            eVar.f21389a = this.y.o0();
            eVar.f21391c = this.y.i0();
            eVar.f21390b = String.valueOf(this.y.c0());
            eVar.f21392d = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921316, eVar));
            if (TextUtils.isEmpty(str)) {
                str = T(R.string.operation_success, new Object[0]);
            }
            if (z) {
                return;
            }
            d.b.b.e.p.l.L(this.p, str);
            return;
        }
        if (gVar != null && !TextUtils.isEmpty(gVar.f21402b)) {
            T = gVar.f21402b;
        } else {
            T = T(R.string.operation_failed, new Object[0]);
        }
        d.b.b.e.p.l.L(this.p, T);
    }

    public final String T(int i, Object... objArr) {
        Context context = this.p;
        if (context == null) {
            return null;
        }
        return context.getString(i, objArr);
    }

    public final String U(String str, int i) {
        return !TextUtils.isEmpty(str) ? str : T(i, new Object[0]);
    }

    public final void V(int i) {
        if (this.y == null) {
            return;
        }
        TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MANAGE_ITEM_CLICK).param("obj_type", i).param("uid", TbadkCoreApplication.getCurrentAccountId()).param("fid", this.y.c0()).param("tid", this.y.o0()));
    }

    public void W() {
        d.b.h0.r.s.l lVar = this.q;
        if (lVar != null) {
            lVar.j();
        }
        d.b.h0.r.s.a aVar = this.r;
        if (aVar != null) {
            d.b.h0.s0.a.a(this.o, aVar.getRealView());
        }
        d.b.h0.r.s.a aVar2 = this.s;
        if (aVar2 != null) {
            d.b.h0.s0.a.a(this.o, aVar2.getRealView());
        }
    }

    public final void X() {
        if (this.o == null || this.y == null) {
            return;
        }
        BawuThrones b2 = d.b.i0.p0.c.c().b();
        if (b2 == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (b2.total_recommend_num.intValue() == b2.used_recommend_num.intValue()) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921465));
        } else if (d.b.h0.r.d0.b.i().g("key_frs_recommend_tip", true)) {
            d.b.i0.p0.c.c().f(this.o, String.valueOf(this.y.c0()), this.y.o0());
        } else {
            d.b.i0.p0.c.c().d(String.valueOf(this.y.c0()), this.y.o0());
        }
    }

    public void Y(a2 a2Var) {
        this.y = a2Var;
        N();
    }

    public void Z(boolean z) {
        Q();
        TbPageContext tbPageContext = this.o;
        if (tbPageContext == null) {
            return;
        }
        if (this.r == null) {
            d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(tbPageContext.getPageActivity());
            this.r = aVar;
            if (z) {
                aVar.setMessageId(R.string.del_work_thread_confirm);
            } else {
                aVar.setMessageId(R.string.del_thread_confirm);
            }
            this.r.setPositiveButton(R.string.dialog_ok, new a());
            this.r.setNegativeButton(R.string.dialog_cancel, new b());
            this.r.setCancelable(true);
            this.r.create(this.o);
        }
        this.r.show();
    }

    public final void a0(ArrayList<l0> arrayList) {
        if (this.t == null) {
            View inflate = LayoutInflater.from(this.p).inflate(R.layout.commit_good, (ViewGroup) null);
            Dialog dialog = new Dialog(this.p, R.style.common_alert_dialog);
            this.t = dialog;
            dialog.setCanceledOnTouchOutside(true);
            this.t.setCancelable(true);
            this.t.setContentView(inflate);
            WindowManager.LayoutParams attributes = this.t.getWindow().getAttributes();
            attributes.width = d.b.b.e.p.l.g(this.p, R.dimen.ds540);
            this.t.getWindow().setAttributes(attributes);
            inflate.findViewById(R.id.dialog_button_cancel).setOnClickListener(new c());
            inflate.findViewById(R.id.dialog_button_ok).setOnClickListener(new d());
        }
        d.b.h0.s0.a.a(this.o, this.t.findViewById(R.id.commit_good_layout));
        LinearLayout linearLayout = (LinearLayout) this.t.findViewById(R.id.good_class_group);
        linearLayout.removeAllViews();
        this.x = new ArrayList();
        BlueCheckRadioButton M = M(this.v, T(R.string.thread_good_class, new Object[0]));
        M.setChecked(true);
        linearLayout.addView(M);
        this.x.add(M);
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                l0 l0Var = arrayList.get(i);
                if (l0Var != null && !TextUtils.isEmpty(l0Var.b()) && l0Var.a() > 0) {
                    BlueCheckRadioButton M2 = M(String.valueOf(l0Var.a()), l0Var.b());
                    this.x.add(M2);
                    View view = new View(this.p);
                    view.setLayoutParams(new LinearLayout.LayoutParams(-1, d.b.b.e.p.l.g(this.p, R.dimen.ds1)));
                    linearLayout.addView(view);
                    linearLayout.addView(M2);
                    SkinManager.setBackgroundColor(view, R.color.CAM_X0204);
                }
            }
            ScrollView scrollView = (ScrollView) this.t.findViewById(R.id.good_scroll);
            ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
            int size2 = arrayList.size();
            if (size2 == 0 || size2 == 1) {
                layoutParams.height = d.b.b.e.p.l.e(this.p, 120.0f);
            } else if (size2 != 2) {
                layoutParams.height = d.b.b.e.p.l.e(this.p, 220.0f);
            } else {
                layoutParams.height = d.b.b.e.p.l.e(this.p, 186.0f);
            }
            scrollView.setLayoutParams(layoutParams);
            scrollView.removeAllViews();
            scrollView.addView(linearLayout);
        }
        d.b.b.e.m.g.j(this.t, this.o);
    }

    public final void b0(JSONArray jSONArray) {
        a2 a2Var;
        if (this.z == null || (a2Var = this.y) == null || a2Var.T() == null) {
            return;
        }
        String userId = this.y.T().getUserId();
        String o0 = this.y.o0();
        String i0 = this.y.i0();
        String valueOf = String.valueOf(this.y.c0());
        boolean isCurrentAccount = UtilHelper.isCurrentAccount(userId);
        if (jSONArray != null) {
            this.z.M(StringHelper.JsonArrayToString(jSONArray));
        }
        this.z.N(valueOf, i0, o0, null, 0, 1, isCurrentAccount, this.y.V());
    }

    public final void c0() {
        a2 a2Var;
        if (this.p == null || (a2Var = this.y) == null || a2Var.T() == null) {
            return;
        }
        String userId = this.y.T().getUserId();
        String userName = this.y.T().getUserName();
        String name_show = this.y.T().getName_show();
        String o0 = this.y.o0();
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new ForbidActivityConfig(this.p, String.valueOf(this.y.c0()), this.y.i0(), o0, userId, userName, name_show, null, this.y.T().getPortrait())));
    }

    public final void d0(String str, boolean z) {
        a2 a2Var = this.y;
        if (a2Var == null || this.z == null) {
            return;
        }
        int i = a2Var.w0() == 1 ? 3 : z ? 6 : 2;
        this.z.O(String.valueOf(this.y.c0()), this.y.i0(), this.y.o0(), i, str);
    }

    public final void e0() {
        a2 a2Var = this.y;
        if (a2Var == null || this.z == null) {
            return;
        }
        int i = a2Var.x0() == 1 ? 5 : 4;
        String o0 = this.y.o0();
        this.z.O(String.valueOf(this.y.c0()), this.y.i0(), o0, i, null);
    }
}
