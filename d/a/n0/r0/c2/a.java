package d.a.n0.r0.c2;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.live.FrsLiveTipResponseMessage;
import d.a.c.e.p.l;
import d.a.n0.r0.c2.c;
import d.a.n0.r0.d1;
import d.a.n0.r0.r;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public FrameLayout f58412a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f58413b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f58414c;

    /* renamed from: d  reason: collision with root package name */
    public d1 f58415d;

    /* renamed from: g  reason: collision with root package name */
    public FrsFragment f58418g;

    /* renamed from: h  reason: collision with root package name */
    public int f58419h;

    /* renamed from: i  reason: collision with root package name */
    public String f58420i;
    public AlaLiveInfoCoreData j;
    public AlaLiveInfoListCoreData k;
    public d.a.n0.r0.c2.c l;
    public int m;

    /* renamed from: e  reason: collision with root package name */
    public boolean f58416e = true;
    public c.b n = new C1490a();
    public Runnable o = new b();

    /* renamed from: f  reason: collision with root package name */
    public int f58417f = n();

    /* renamed from: d.a.n0.r0.c2.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1490a implements c.b {
        public C1490a() {
        }

        @Override // d.a.n0.r0.c2.c.b
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.f58419h = frsLiveTipResponseMessage.remindType;
                a.this.f58420i = frsLiveTipResponseMessage.remindText;
                a.this.j = frsLiveTipResponseMessage.infoCoreData;
                a.this.k = frsLiveTipResponseMessage.listCoreData;
                if (a.this.f58415d != null) {
                    a.this.f58415d.f();
                }
                if (a.this.f58419h == 0) {
                    return;
                }
                a.this.y();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.l != null) {
                a.this.l.b(a.this.m);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.u();
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            a.this.t();
        }
    }

    /* loaded from: classes4.dex */
    public class e implements Runnable {
        public e() {
        }

        @Override // java.lang.Runnable
        public void run() {
            a.this.l();
        }
    }

    public a(FrsFragment frsFragment, int i2) {
        this.f58418g = frsFragment;
        this.m = i2;
    }

    public final void k() {
        this.f58417f++;
        d.a.m0.r.d0.b.j().v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f58417f);
    }

    public void l() {
        FrsFragment frsFragment = this.f58418g;
        if (frsFragment == null) {
            return;
        }
        frsFragment.y2().b(49);
    }

    public final void m() {
        this.f58417f = 0;
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.v("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), this.f58417f);
    }

    public final int n() {
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        return j.k("FRS_HOT_LIVE_TIP_CLOSE_NUM" + p(), 0);
    }

    public final long o() {
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        return j.l("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + p(), 0L);
    }

    public final String p() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            String id = currentAccountInfo.getID();
            return !TextUtils.isEmpty(id) ? id : "";
        }
        return "";
    }

    public final void q(Context context) {
        if (context != null && this.f58412a == null) {
            FrameLayout frameLayout = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.f58412a = frameLayout;
            frameLayout.setOnClickListener(new c());
            this.f58413b = (TextView) this.f58412a.findViewById(R.id.frs_hot_live_tip_content);
            ImageView imageView = (ImageView) this.f58412a.findViewById(R.id.frs_hot_live_tip_close);
            this.f58414c = imageView;
            imageView.setOnClickListener(new d());
            s();
        }
    }

    public final boolean r() {
        return this.f58416e;
    }

    public final void s() {
        SkinManager.setBackgroundResource(this.f58412a, R.drawable.bg_frs_hot_live_tip_selector);
        SkinManager.setViewTextColor(this.f58413b, R.color.CAM_X0101);
        SkinManager.setImageResource(this.f58414c, R.drawable.icon_home_card_close_white);
        this.f58413b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    public final void t() {
        if (this.f58419h == 2) {
            k();
        }
        d1 d1Var = this.f58415d;
        if (d1Var != null) {
            d1Var.d();
        }
    }

    public final void u() {
        FrsFragment frsFragment;
        String str;
        m();
        if (this.j == null || (frsFragment = this.f58418g) == null || !frsFragment.isAdded()) {
            return;
        }
        boolean equals = TextUtils.equals(p(), String.valueOf(this.j.userID));
        int i2 = this.f58419h;
        if (i2 == 1) {
            TiebaStatic.log(new StatisticItem("c12540"));
            d1 d1Var = this.f58415d;
            if (d1Var != null) {
                d1Var.d();
            }
            str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
        } else if (i2 == 2) {
            TiebaStatic.log(new StatisticItem("c12331"));
            str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
        } else {
            str = "";
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.f58418g.getPageContext().getPageActivity(), this.j, this.k, str, p(), equals, null, null)));
        if (this.f58418g.g0().getForum().isGameForumType()) {
            CustomMessage customMessage = new CustomMessage(2001622);
            customMessage.setTag(this.f58418g.getBaseFragmentActivity().getUniqueId());
            CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
            customResponsedMessage.setOrginalMessage(customMessage);
            MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
            return;
        }
        d.a.c.e.m.e.a().post(new e());
    }

    public void v() {
        d1 d1Var = this.f58415d;
        if (d1Var != null) {
            d1Var.f();
        }
        d.a.c.e.m.e.a().removeCallbacks(this.o);
        d.a.n0.r0.c2.c cVar = this.l;
        if (cVar != null) {
            cVar.c();
        }
    }

    public void w() {
        FrsFragment frsFragment = this.f58418g;
        if (frsFragment == null || !frsFragment.isAdded()) {
            return;
        }
        if (System.currentTimeMillis() - o() < 1800000) {
            return;
        }
        if (this.f58418g.M2() && r()) {
            this.f58416e = false;
            return;
        }
        if (this.l == null) {
            this.l = new d.a.n0.r0.c2.c(this.n);
        }
        d.a.c.e.m.e.a().removeCallbacks(this.o);
        d.a.c.e.m.e.a().postDelayed(this.o, 5000L);
    }

    public final void x() {
        long currentTimeMillis = System.currentTimeMillis();
        d.a.m0.r.d0.b j = d.a.m0.r.d0.b.j();
        j.w("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + p(), currentTimeMillis);
    }

    public void y() {
        if (StringUtils.isNull(this.f58420i) || this.j == null) {
            return;
        }
        if (this.f58419h != 2 || n() < 3) {
            q(this.f58418g.getPageContext().getPageActivity());
            TextView textView = this.f58413b;
            if (textView != null) {
                textView.setText(this.f58420i);
            }
            s();
            z();
            x();
        }
    }

    public final void z() {
        r y0;
        FrameLayout frameLayout;
        FrsFragment frsFragment = this.f58418g;
        if (frsFragment == null || (y0 = frsFragment.y0()) == null || y0.Z() == null || (frameLayout = (FrameLayout) y0.S()) == null) {
            return;
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
        if (this.f58415d == null) {
            this.f58415d = new d1();
        }
        int i2 = this.f58419h;
        if (i2 == 2) {
            this.f58415d.h(this.f58412a, frameLayout, layoutParams, 5000);
        } else if (i2 == 1) {
            this.f58415d.g(this.f58412a, frameLayout, layoutParams);
            TiebaStatic.log(new StatisticItem("c12539"));
        }
    }
}
