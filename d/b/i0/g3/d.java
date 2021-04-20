package d.b.i0.g3;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.viewpager.widget.ViewPager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.MainTabActivityConfig;
import com.baidu.tbadk.core.atomData.MemberPayActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.atomData.VideoEasterEggActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.tabHost.FragmentTabHost;
import com.baidu.tbadk.core.tabHost.FragmentTabWidget;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.ViewHelper;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.data.PayMemberInfoData;
import com.baidu.tbadk.mainTab.MaintabBottomIndicator;
import com.baidu.tbadk.mainTab.TbFragmentTabIndicator;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.tieba.tblauncher.MainTabActivity;
import com.baidu.tieba.view.NavigationBarCoverTip;
import d.b.h0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class d {
    public Runnable E;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f56306a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f56307b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f56308c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f56309d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f56310e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f56311f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f56312g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f56313h;
    public TextView i;
    public ImageView j;
    public TextView k;
    public boolean n;
    public PopupWindow o;
    public d.b.i0.b0.h r;
    public d.b.i0.q3.e s;
    public MaintabBottomIndicator t;
    public MaintabBottomIndicator u;
    public boolean l = false;
    public int m = -1;
    public boolean p = false;
    public Handler q = new Handler();
    public int v = 0;
    public boolean w = true;
    public int x = 1;
    public boolean y = false;
    public FragmentTabHost.a z = new a();
    public CustomMessageListener A = new k(2921492);
    public CustomMessageListener B = new l(2921541);
    public CustomMessageListener C = new m(2921382);
    public CustomMessageListener D = new n(2921410);
    public Runnable F = new g();
    public Runnable G = new h();

    /* loaded from: classes5.dex */
    public class a implements FragmentTabHost.a {

        /* renamed from: d.b.i0.g3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1310a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f56315e;

            public RunnableC1310a(a aVar, CustomResponsedMessage customResponsedMessage) {
                this.f56315e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(this.f56315e);
            }
        }

        public a() {
        }

        public final void a(int i) {
            String m;
            if (d.this.f56307b.f(i).f12972a == 2) {
                m = TbPageExtraHelper.l(d.this.f56306a.getPageContext().getContext());
            } else {
                m = TbPageExtraHelper.m();
            }
            d.b.c.e.m.e.a().postDelayed(new RunnableC1310a(this, new CustomResponsedMessage(2921520, m)), 100L);
        }

        public final void b(int i) {
            int i2 = d.this.f56307b.f(i).f12972a;
            if (i2 == 8) {
                TbPageExtraHelper.u("a011");
            } else if (i2 == 2) {
                TbPageExtraHelper.u("a002");
            } else if (i2 == 3) {
                TbPageExtraHelper.u("a079");
            } else if (i2 == 1) {
                TbPageExtraHelper.u("a025");
            } else if (i2 == 21) {
                TbPageExtraHelper.u("a075");
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i, boolean z) {
            FragmentTabHost.b f2 = d.this.f56307b.f(i);
            int i2 = f2.f12972a;
            if (i2 != 9) {
                if (i2 == 8 && !ViewHelper.checkUpIsLogin(d.this.f56306a.getActivity())) {
                    if (d.this.t != null) {
                        d.this.t.n();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                    return false;
                }
                int i3 = f2.f12972a;
                if (i3 != 15) {
                    if (i3 == 3 && !ViewHelper.checkUpIsLogin(d.this.f56306a.getActivity())) {
                        return false;
                    }
                    if (f2.f12972a == 1) {
                        TiebaStatic.log(new StatisticItem("c13001"));
                    }
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) d.this.f56306a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                }
                return true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new d.b.h0.t.k(0)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
            return false;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b f2 = d.this.f56307b.f(i);
            int i2 = f2.f12972a;
            if (i2 == 8) {
                if (d.this.t != null && d.this.t.getAnimationView() != null && d.this.t.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                } else {
                    TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                }
                if (d.this.t != null) {
                    d.this.t.n();
                }
                TiebaStatic.log("c13841");
            } else if (i2 == 3) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
            }
            if (f2.f12972a == 2) {
                if (d.this.w) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                }
                d.this.w = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.x != 2 || d.this.v == i || homeBarShowType != 1 || d.this.u == null) {
                    if (d.this.x == 1 && d.this.u != null) {
                        d.this.u.v(d.this.w);
                    }
                } else {
                    d.this.u.w();
                }
                d.this.y = false;
            } else {
                d.this.y = true;
                if (d.this.w && d.this.u != null) {
                    d.this.u.v(d.this.w);
                }
                d.this.w = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.A() != null) {
                d.this.A().A = d.this.w;
            }
            b(d.this.v);
            a(d.this.v);
            d.this.v = i;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i)));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.P(false);
            d.this.f56312g.setVisibility(8);
            d.b.h0.r.d0.b.j().t("game_is_show_tip", false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, Boolean.FALSE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.f56306a.getPageContext()));
            TiebaStatic.eventStat(d.this.f56306a.getPageContext().getPageActivity(), "tb_gamecenter", PrefetchEvent.STATE_CLICK, 1, "ref_type", "601");
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f56306a.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.f56306a.getPageContext().getPageActivity())));
            int i = 3;
            if (d.this.f56307b.getCurrentTabType() != 3) {
                i = d.this.f56307b.getCurrentTabType() == 2 ? 1 : 0;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", i));
        }
    }

    /* renamed from: d.b.i0.g3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1311d implements View.OnClickListener {
        public View$OnClickListenerC1311d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                d.this.f56306a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.f56306a.getPageContext().getPageActivity())));
                TiebaStatic.log("c10085");
            }
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(d.this.f56306a.getPageContext().getPageActivity(), "notlogin_4", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            ViewHelper.skipToLoginActivity(d.this.f56306a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(d.this.f56306a.getPageContext().getPageActivity(), "notlogin_3", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            int i = d.this.m;
            TiebaStatic.log(new StatisticItem("c10517").param("obj_source", i != 1 ? i != 2 ? i != 3 ? i != 8 ? "" : "profile" : "message" : "kantie" : "forum"));
            ViewHelper.skipToRegisterActivity(d.this.f56306a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.f56307b == null || d.this.o == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = d.this.f56307b.getFragmentTabWidget();
            d.b.c.e.p.l.k(d.this.f56306a.getActivity());
            int g2 = d.b.c.e.p.l.g(d.this.f56306a.getActivity(), R.dimen.ds178);
            View contentView = d.this.o.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b g3 = d.this.f56307b.g(3);
            if (g3 == null || (tbFragmentTabIndicator = g3.f12973b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = d.b.c.e.p.l.g(d.this.f56306a.getActivity(), R.dimen.tbds570);
            }
            d.b.c.e.m.g.l(d.this.o, fragmentTabWidget, measuredWidth2, -g2);
            d.b.h0.r.d0.b.j().t("show_maintab_last_message_tips", true);
            d.this.p = true;
            d.this.q.postDelayed(d.this.G, 5000L);
        }
    }

    /* loaded from: classes5.dex */
    public class h implements Runnable {
        public h() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.z();
        }
    }

    /* loaded from: classes5.dex */
    public class i implements a.e {
        public i(d dVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            StatisticItem statisticItem = new StatisticItem("c12137");
            statisticItem.param("obj_locate", "1");
            TiebaStatic.log(statisticItem);
            aVar.dismiss();
        }
    }

    /* loaded from: classes5.dex */
    public class j implements a.e {
        public j(d dVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            StatisticItem statisticItem = new StatisticItem("c12137");
            statisticItem.param("obj_locate", "2");
            TiebaStatic.log(statisticItem);
            aVar.dismiss();
            d.b.i0.x0.a.d();
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public k(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.h0.e0.c cVar;
            if (customResponsedMessage == null || d.this.f56307b == null || !(customResponsedMessage.getData() instanceof d.b.h0.e0.c) || (cVar = (d.b.h0.e0.c) customResponsedMessage.getData()) == null || d.this.f56307b.g(cVar.f50552e) == null || d.this.f56307b.getCurrentTabType() == 21) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = d.this.f56307b.g(cVar.f50552e).f12973b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f50554g, cVar.f50550c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public l(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.h0.e0.e.a c2;
            d.b.h0.e0.e.a c3;
            d.b.h0.e0.e.a c4;
            d.b.h0.e0.e.a c5;
            d.b.h0.e0.e.a c6;
            if (customResponsedMessage == null || d.this.f56307b == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            FragmentTabHost.b g2 = d.this.f56307b.g(2);
            if (g2 != null && (g2.f12973b instanceof MaintabBottomIndicator) && (c6 = d.b.h0.e0.e.c.d().c("homePage")) != null) {
                ((MaintabBottomIndicator) g2.f12973b).setDynamicIconData(c6);
            }
            FragmentTabHost.b g3 = d.this.f56307b.g(1);
            if (g3 != null && (g3.f12973b instanceof MaintabBottomIndicator) && (c5 = d.b.h0.e0.e.c.d().c("enterForum")) != null) {
                ((MaintabBottomIndicator) g3.f12973b).setDynamicIconData(c5);
            }
            FragmentTabHost.b g4 = d.this.f56307b.g(21);
            if (g4 != null && (g4.f12973b instanceof MaintabBottomIndicator) && (c4 = d.b.h0.e0.e.c.d().c("channel")) != null) {
                ((MaintabBottomIndicator) g4.f12973b).setDynamicIconData(c4);
            }
            FragmentTabHost.b g5 = d.this.f56307b.g(3);
            if (g5 != null && (g5.f12973b instanceof MaintabBottomIndicator) && (c3 = d.b.h0.e0.e.c.d().c("message")) != null) {
                ((MaintabBottomIndicator) g5.f12973b).setDynamicIconData(c3);
            }
            FragmentTabHost.b g6 = d.this.f56307b.g(8);
            if (g6 == null || !(g6.f12973b instanceof MaintabBottomIndicator) || (c2 = d.b.h0.e0.e.c.d().c("person")) == null) {
                return;
            }
            ((MaintabBottomIndicator) g6.f12973b).setDynamicIconData(c2);
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public m(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || d.this.A() == null) {
                return;
            }
            Object data = customResponsedMessage.getData();
            if (data instanceof Integer) {
                int intValue = ((Integer) data).intValue();
                if (intValue == 4) {
                    d.this.y = true;
                    d.this.w = true;
                    if (d.this.x != 2) {
                        if (d.this.u == null || !d.this.u.p()) {
                            return;
                        }
                        d.this.u.v(d.this.w);
                        return;
                    }
                    d.this.A().u();
                    return;
                }
                if (intValue == 6) {
                    d.this.y = false;
                    if (d.this.x == 1) {
                        return;
                    }
                } else {
                    d.this.x = intValue;
                }
                if (d.this.x == 1) {
                    d.this.A().v(d.this.w);
                } else if (d.this.x == 2) {
                    d.this.A().w();
                } else if (intValue == 5) {
                    d.this.x = 1;
                    d.this.w = true;
                    if (!d.this.y) {
                        d.this.A().u();
                    }
                } else {
                    d.this.A().t();
                }
                d.this.A().z = true;
                d.this.A().B = d.this.x;
                d.this.A().A = d.this.w;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends CustomMessageListener {
        public n(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.this.w = true;
            if (d.this.A() != null) {
                d.this.A().A = d.this.w;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class o implements ViewPager.OnPageChangeListener {
        public o() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (d.this.f56307b.getCurrentTabType() != 2) {
                if (d.this.f56307b.getCurrentTabType() == 15) {
                    TiebaStatic.log("c12124");
                }
            } else {
                TiebaStatic.log("kantie_entry");
            }
            d.this.N();
            if (d.this.f56307b.getCurrentTabType() != d.this.f56307b.f(i).f12972a) {
                d.this.f56307b.setCurrentTab(i);
            }
            if (d.this.f56307b.getCurrentTabType() != 1) {
                d.this.f56310e.setVisibility(8);
                d.this.f56313h.setVisibility(0);
            }
            if (d.this.f56307b.getCurrentTabType() == 1 && !d.b.h0.r.d0.b.j().g("has_guide_popup_window_been_shown", false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
            }
            d dVar = d.this;
            dVar.m = dVar.f56307b.getCurrentTabType();
            d.this.Q();
            if (d.b.h0.r.d0.b.j().g("enter_forum_edit_mode", false)) {
                if (d.this.f56307b.getCurrentTabType() != 3) {
                    if (d.this.f56307b.getCurrentTabType() == 2) {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                    }
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                }
            }
            if (d.this.f56307b.getCurrentTabType() == 3) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f56328e;

        public p(String str) {
            this.f56328e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.S(this.f56328e);
        }
    }

    /* loaded from: classes5.dex */
    public class q implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f56330e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f56331f;

        public q(d.b.h0.r.s.a aVar, int i) {
            this.f56330e = aVar;
            this.f56331f = i;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f56330e.dismiss();
            int i = this.f56331f;
            if (i == 0) {
                TiebaStatic.eventStat(d.this.f56306a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (i == 1) {
                TiebaStatic.eventStat(d.this.f56306a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f56333e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f56334f;

        public r(d.b.h0.r.s.a aVar, int i) {
            this.f56333e = aVar;
            this.f56334f = i;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            String str;
            this.f56333e.dismiss();
            int i = this.f56334f;
            if (i == 0) {
                TiebaStatic.eventStat(d.this.f56306a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                str = "4006001000";
            } else if (i == 1) {
                TiebaStatic.eventStat(d.this.f56306a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                str = "4005001000";
            } else {
                str = null;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.f56306a.getPageContext().getPageActivity(), 2);
            if (!StringUtils.isNULL(str)) {
                memberPayActivityConfig.setSceneId(str);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.f56306a = mainTabActivity;
    }

    public MaintabBottomIndicator A() {
        return this.u;
    }

    public MaintabBottomIndicator B() {
        return this.t;
    }

    public FragmentTabHost C() {
        return this.f56307b;
    }

    public void D() {
        ImageView imageView = this.j;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        TextView textView = this.k;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    public void E() {
        NavigationBar navigationBar = (NavigationBar) this.f56306a.findViewById(R.id.view_navigation_bar);
        this.f56308c = navigationBar;
        if (navigationBar != null) {
            this.f56309d = (TextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.f56306a.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.f56309d.setLayoutParams(layoutParams);
            View addCustomView = this.f56308c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.f56311f = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.f56312g = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.f56311f.setOnClickListener(new b());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, d.b.c.e.p.l.g(this.f56306a.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            ImageView imageView = (ImageView) this.f56308c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.f56313h = imageView;
            imageView.setLayoutParams(layoutParams2);
            this.f56313h.setVisibility(8);
            this.f56313h.setOnClickListener(new c());
            ImageView imageView2 = (ImageView) this.f56308c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.f56310e = imageView2;
            imageView2.setLayoutParams(layoutParams2);
            this.f56310e.setVisibility(8);
            this.f56310e.setOnClickListener(new View$OnClickListenerC1311d());
            this.f56308c.setLoginClickListener(new e());
            this.f56308c.setRegisterClickListener(new f());
        }
    }

    public void F(ArrayList<d.b.h0.e0.b> arrayList) {
        this.f56307b.p();
        Iterator<d.b.h0.e0.b> it = arrayList.iterator();
        while (it.hasNext()) {
            d.b.h0.e0.b next = it.next();
            if (next != null && next.isAvailable()) {
                y(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f56306a.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.f56307b.k(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.f56307b.k(1);
        } else {
            this.f56307b.k(0);
        }
        this.f56307b.setViewPagerScrollable(false);
    }

    public void G() {
        this.y = false;
        this.x = 1;
        if (A() != null) {
            A().B = this.x;
        }
    }

    public boolean H() {
        ImageView imageView = this.f56311f;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public boolean I() {
        return this.n;
    }

    public void J(int i2) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.f56307b.setShouldDrawTopLine(false);
        }
        if (this.f56307b.getFragmentTabWidget() != null) {
            this.f56307b.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        }
        this.f56307b.o(i2);
        this.f56308c.onChangeSkinType(this.f56306a.getPageContext(), i2);
        SkinManager.setNavbarTitleColor(this.f56309d, R.color.CAM_X0105, R.color.s_navbar_title_color, i2);
        SkinManager.setImageResource(this.f56312g, R.drawable.icon_news_down_bar_one);
        SkinManager.setNavbarIconSrc(this.f56311f, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56313h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f56310e, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void K() {
        R();
        if (C() != null) {
            C().p();
        }
        z();
        d.b.i0.b0.h hVar = this.r;
        if (hVar != null) {
            hVar.i();
        }
        d.b.i0.q3.e eVar = this.s;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void L(boolean z) {
        FragmentTabHost fragmentTabHost = this.f56307b;
        if (fragmentTabHost != null) {
            if (z) {
                fragmentTabHost.h();
                D();
                return;
            }
            fragmentTabHost.q();
        }
    }

    public void M(boolean z) {
        FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f56306a.findViewById(R.id.tab_host);
        this.f56307b = fragmentTabHost;
        fragmentTabHost.setup(this.f56306a.getSupportFragmentManager());
        this.f56307b.setAbsoluteWeight(true);
        this.f56307b.setOnTabSelectionListener(this.z);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.f56307b.setShouldDrawIndicatorLine(false);
            this.f56307b.setShouldDrawTopLine(true);
        }
        this.f56307b.setOnPageChangeListener(new o());
        this.l = d.b.h0.r.d0.b.j().g("has_show_message_tab_tips", false);
        E();
        this.j = (ImageView) this.f56306a.findViewById(R.id.home_page_new_write_icon);
        this.k = (TextView) this.f56306a.findViewById(R.id.view_bottom_text);
        this.i = (TextView) this.f56306a.findViewById(R.id.activity_prize_my_tip);
        this.f56307b.setUIType(0);
        this.f56307b.setTabContainerShadowShow(false);
        this.f56307b.setBackGroundStyle(0);
        this.f56307b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        D();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f56306a.getPageContext()));
        b0(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.f56306a.registerListener(this.C);
        }
        this.f56306a.registerListener(this.D);
        this.f56306a.registerListener(this.A);
        this.f56306a.registerListener(this.B);
    }

    public void N() {
        FragmentTabHost fragmentTabHost = this.f56307b;
        if (fragmentTabHost != null) {
            if (fragmentTabHost.getCurrentTabType() == 8 || this.f56307b.getCurrentTabType() == 3 || this.f56307b.getCurrentTabType() == 2 || this.f56307b.getCurrentTabType() == 15 || this.f56307b.getCurrentTabType() == 1) {
                NavigationBar navigationBar = this.f56308c;
                if (navigationBar != null) {
                    navigationBar.setVisibility(8);
                }
                this.f56313h.setVisibility(8);
            }
        }
    }

    public void O(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        C().setCurrentTabByType(i2);
        if (i2 != 2) {
            this.y = true;
            if (this.w && (maintabBottomIndicator = this.u) != null) {
                maintabBottomIndicator.v(false);
            }
            this.w = false;
            if (A() != null) {
                A().A = this.w;
            }
        }
    }

    public final void P(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f56311f.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = d.b.c.e.p.l.g(this.f56306a.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = d.b.c.e.p.l.g(this.f56306a.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.f56311f.setLayoutParams(layoutParams);
        }
    }

    public void Q() {
        FragmentTabHost.b g2;
        d.b.h0.e0.b bVar;
        FragmentTabHost fragmentTabHost = this.f56307b;
        if (fragmentTabHost == null || (g2 = fragmentTabHost.g(fragmentTabHost.getCurrentTabType())) == null || (bVar = g2.f12975d) == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        String string = this.f56306a.getPageContext().getString(g2.f12975d.getFragmentTabStructure().f50549b);
        TextView textView = this.f56309d;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public void R() {
        d.b.h0.r.d0.b.j().t("has_show_message_tab_tips", this.l);
    }

    public void S(String str) {
        PopupWindow popupWindow;
        if (StringUtils.isNull(str)) {
            this.i.setVisibility(8);
            return;
        }
        FragmentTabHost.b g2 = this.f56307b.g(8);
        if (g2 != null) {
            if (this.p && ((popupWindow = this.o) == null || !popupWindow.isShowing())) {
                T(str, g2);
                return;
            }
            if (this.E == null) {
                this.E = new p(str);
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.E);
            TbadkCoreApplication.getInst().handler.postDelayed(this.E, 5000L);
            return;
        }
        this.i.setVisibility(8);
    }

    public final void T(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.f12973b.getLocationInWindow(iArr);
        int width = iArr[0] + (bVar.f12973b.getWidth() / 2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.rightMargin = (d.b.c.e.p.l.q(this.f56306a).widthPixels - width) - d.b.c.e.p.l.g(this.f56306a.getPageContext().getPageActivity(), R.dimen.ds26);
        this.i.setLayoutParams(layoutParams);
        this.i.setVisibility(0);
        this.i.setText(str);
    }

    public void U(String str) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f56306a.getActivity());
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.close, new i(this));
        aVar.setNegativeButton(R.string.check, new j(this));
        aVar.create(this.f56306a.getPageContext()).show();
    }

    public void V(boolean z) {
        ImageView imageView = this.f56311f;
        if (imageView == null) {
            return;
        }
        if (z) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(8);
        }
    }

    public void W(boolean z) {
        if (H()) {
            if (z) {
                if (this.f56312g.getVisibility() != 0) {
                    this.f56312g.setVisibility(0);
                    P(true);
                    SkinManager.setImageResource(this.f56312g, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            P(false);
            this.f56312g.setVisibility(8);
        }
    }

    public void X(PayMemberInfoData payMemberInfoData, int i2) {
        if (payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f56306a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        if (!StringUtils.isNull(payMemberInfoData.t())) {
            textView.setText(payMemberInfoData.t());
        }
        if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
            tbImageView.W(payMemberInfoData.getUrl(), 21, false);
            tbImageView.setIsNight(z);
        } else {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
        }
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f56306a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new q(aVar, i2));
        String string = this.f56306a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f56306a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new r(aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f56306a.getPageContext()).show();
        d.b.h0.r.d0.b.j().t("show_member_deid_line", false);
    }

    public void Y(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.s == null) {
            MainTabActivity mainTabActivity = this.f56306a;
            this.s = new d.b.i0.q3.e(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.s.g(postWriteCallBackData);
    }

    public void Z(boolean z) {
        if (z) {
            this.f56310e.setVisibility(0);
            this.f56313h.setVisibility(8);
            return;
        }
        this.f56310e.setVisibility(8);
        this.f56313h.setVisibility(0);
    }

    public void a0(PostWriteCallBackData postWriteCallBackData) {
        if (this.r == null) {
            this.r = new d.b.i0.b0.h(this.f56306a.getPageContext(), (NavigationBarCoverTip) this.f56306a.findViewById(R.id.navigation_cover_tip));
        }
        this.r.m(postWriteCallBackData);
    }

    public void b0(boolean z) {
        NavigationBar navigationBar = this.f56308c;
        if (navigationBar != null) {
            navigationBar.switchNaviBarStatus(z);
        }
    }

    public void w(boolean z) {
        this.n = z;
        if (z) {
            return;
        }
        d.b.h0.r.d0.b.j().t("enter_forum_edit_mode", false);
    }

    public boolean x(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.b.c.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (d.b.h0.r.d0.b.j().g(d.b.h0.r.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f56306a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public final void y(d.b.h0.e0.b bVar, d.b.h0.e0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar == null || !(tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            return;
        }
        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        boolean z = false;
        bVar2.f12974c = cVar.f50548a;
        bVar2.f12972a = cVar.f50552e;
        maintabBottomIndicator.setShowIconType(cVar.i);
        int i2 = cVar.i;
        if (i2 == d.b.h0.e0.c.j) {
            maintabBottomIndicator.setWriteIconView();
            z = true;
        } else if (i2 == d.b.h0.e0.c.m) {
            maintabBottomIndicator.setText(cVar.f50549b);
            maintabBottomIndicator.setAnimationResId(cVar.f50553f);
            this.t = maintabBottomIndicator;
        } else {
            maintabBottomIndicator.setText(cVar.f50549b);
            maintabBottomIndicator.setAnimationResId(cVar.f50553f);
        }
        if (!d.b.c.e.p.k.isEmpty(cVar.f50554g)) {
            maintabBottomIndicator.setImageIconUrl(cVar.f50554g, cVar.f50550c);
        }
        d.b.h0.e0.e.a aVar = cVar.f50555h;
        if (aVar != null) {
            maintabBottomIndicator.setDynamicIconData(aVar);
        }
        if (bVar2.f12972a == 2) {
            maintabBottomIndicator.D = true;
            this.u = maintabBottomIndicator;
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        bVar2.f12973b = maintabBottomIndicator;
        bVar2.f12975d = bVar;
        this.f56307b.c(bVar2, -1, z);
    }

    public void z() {
        this.q.removeCallbacks(this.F);
        this.q.removeCallbacks(this.G);
        d.b.c.e.m.g.c(this.o);
    }
}
