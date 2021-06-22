package d.a.o0.h3;

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
import com.baidu.tbadk.core.util.FullBrowseHelper;
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
import d.a.n0.r.s.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes5.dex */
public class d {
    public Runnable E;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f59426a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f59427b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f59428c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f59429d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f59430e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f59431f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f59432g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f59433h;

    /* renamed from: i  reason: collision with root package name */
    public TextView f59434i;
    public ImageView j;
    public TextView k;
    public boolean n;
    public PopupWindow o;
    public d.a.o0.d0.h r;
    public d.a.o0.r3.e s;
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
    public CustomMessageListener B = new l(2921551);
    public CustomMessageListener C = new m(2921382);
    public CustomMessageListener D = new n(2921410);
    public Runnable F = new g();
    public Runnable G = new h();

    /* loaded from: classes5.dex */
    public class a implements FragmentTabHost.a {

        /* renamed from: d.a.o0.h3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1426a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f59436e;

            public RunnableC1426a(a aVar, CustomResponsedMessage customResponsedMessage) {
                this.f59436e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(this.f59436e);
            }
        }

        public a() {
        }

        public final void a(int i2) {
            String m;
            if (d.this.f59427b.f(i2).f12293a == 2) {
                m = TbPageExtraHelper.l(d.this.f59426a.getPageContext().getContext());
            } else {
                m = TbPageExtraHelper.m();
            }
            d.a.c.e.m.e.a().postDelayed(new RunnableC1426a(this, new CustomResponsedMessage(2921520, m)), 100L);
        }

        public final void b(int i2) {
            int i3 = d.this.f59427b.f(i2).f12293a;
            if (i3 == 8) {
                TbPageExtraHelper.u("a011");
            } else if (i3 == 2) {
                TbPageExtraHelper.u("a002");
            } else if (i3 == 3) {
                TbPageExtraHelper.u("a079");
            } else if (i3 == 1) {
                TbPageExtraHelper.u("a025");
            } else if (i3 == 21) {
                TbPageExtraHelper.u("a075");
            } else if (i3 == 22) {
                TbPageExtraHelper.u("a088");
            }
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public boolean onPreTabSelectionChange(int i2, boolean z) {
            FragmentTabHost.b f2 = d.this.f59427b.f(i2);
            if (f2.f12293a == 2 || !FullBrowseHelper.checkAndShowFullBrowseModeDialog(d.this.f59426a.getPageContext(), null)) {
                int i3 = f2.f12293a;
                if (i3 != 9) {
                    if (i3 == 8 && !ViewHelper.checkUpIsLogin(d.this.f59426a.getActivity())) {
                        if (d.this.t != null) {
                            d.this.t.n();
                        }
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                        return false;
                    }
                    int i4 = f2.f12293a;
                    if (i4 != 15) {
                        if (i4 == 3 && !ViewHelper.checkUpIsLogin(d.this.f59426a.getActivity())) {
                            return false;
                        }
                        if (f2.f12293a == 1) {
                            TiebaStatic.log(new StatisticItem("c13001"));
                        }
                    } else {
                        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                        if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                            UrlManager.getInstance().dealOneLink((TbPageContext<?>) d.this.f59426a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                            return false;
                        }
                    }
                    return true;
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new d.a.n0.t.k(0)));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i2)));
                return false;
            }
            return false;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i2, boolean z) {
            FragmentTabHost.b f2 = d.this.f59427b.f(i2);
            int i3 = f2.f12293a;
            if (i3 == 8) {
                if (d.this.t != null && d.this.t.getAnimationView() != null && d.this.t.getAnimationView().getVisibility() == 0) {
                    TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 1));
                } else {
                    TiebaStatic.log(new StatisticItem("c10605").param("obj_type", 0));
                }
                if (d.this.t != null) {
                    d.this.t.n();
                }
                TiebaStatic.log("c13841");
            } else if (i3 == 3) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.PERSON_CENTER_FUNCTION_CLICK).param("obj_locate", 1));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.MESSAGE_ENTER_ICON_CLICK).param("obj_locate", 1));
            }
            if (f2.f12293a == 2) {
                if (d.this.w) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                }
                d.this.w = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.x != 2 || d.this.v == i2 || homeBarShowType != 1 || d.this.u == null) {
                    if (d.this.x == 1 && d.this.u != null) {
                        d.this.u.x(d.this.w);
                    }
                } else {
                    d.this.u.y();
                }
                d.this.y = false;
            } else {
                d.this.y = true;
                if (d.this.w && d.this.u != null) {
                    d.this.u.x(d.this.w);
                }
                d.this.w = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.A() != null) {
                d.this.A().A = d.this.w;
            }
            b(d.this.v);
            a(d.this.v);
            d.this.v = i2;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001384, Integer.valueOf(i2)));
            if (f2.f12293a != 22) {
                if (d.this.f59427b.getFragmentTabWidget() != null) {
                    d.this.f59427b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
                }
                d.this.f59427b.n(false);
                return;
            }
            TiebaStatic.log(new StatisticItem("c14178").param("uid", TbadkCoreApplication.getCurrentAccount()).param("obj_source", 1));
            if (d.this.f59427b.f(d.this.f59427b.getCurrentTabIndex()).f12293a != 22) {
                if (d.this.f59427b.getFragmentTabWidget() != null) {
                    d.this.f59427b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
                }
                d.this.f59427b.n(true);
                if (d.a.c.e.p.j.z()) {
                    return;
                }
                d.a.c.e.p.l.J(d.this.f59426a, d.this.f59426a.getResources().getString(R.string.neterror));
                return;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921567));
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public b() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.P(false);
            d.this.f59432g.setVisibility(8);
            d.a.n0.r.d0.b.j().t("game_is_show_tip", false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, Boolean.FALSE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.f59426a.getPageContext()));
            TiebaStatic.eventStat(d.this.f59426a.getPageContext().getPageActivity(), "tb_gamecenter", PrefetchEvent.STATE_CLICK, 1, "ref_type", "601");
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.f59426a.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.f59426a.getPageContext().getPageActivity())));
            int i2 = 3;
            if (d.this.f59427b.getCurrentTabType() != 3) {
                i2 = d.this.f59427b.getCurrentTabType() == 2 ? 1 : 0;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", i2));
        }
    }

    /* renamed from: d.a.o0.h3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1427d implements View.OnClickListener {
        public View$OnClickListenerC1427d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                d.this.f59426a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.f59426a.getPageContext().getPageActivity())));
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
            TiebaStatic.eventStat(d.this.f59426a.getPageContext().getPageActivity(), "notlogin_4", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            ViewHelper.skipToLoginActivity(d.this.f59426a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class f implements View.OnClickListener {
        public f() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(d.this.f59426a.getPageContext().getPageActivity(), "notlogin_3", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            int i2 = d.this.m;
            TiebaStatic.log(new StatisticItem("c10517").param("obj_source", i2 != 1 ? i2 != 2 ? i2 != 3 ? i2 != 8 ? "" : "profile" : "message" : "kantie" : "forum"));
            ViewHelper.skipToRegisterActivity(d.this.f59426a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.f59427b == null || d.this.o == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = d.this.f59427b.getFragmentTabWidget();
            d.a.c.e.p.l.k(d.this.f59426a.getActivity());
            int g2 = d.a.c.e.p.l.g(d.this.f59426a.getActivity(), R.dimen.ds178);
            View contentView = d.this.o.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b g3 = d.this.f59427b.g(3);
            if (g3 == null || (tbFragmentTabIndicator = g3.f12294b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = d.a.c.e.p.l.g(d.this.f59426a.getActivity(), R.dimen.tbds570);
            }
            d.a.c.e.m.g.l(d.this.o, fragmentTabWidget, measuredWidth2, -g2);
            d.a.n0.r.d0.b.j().t("show_maintab_last_message_tips", true);
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

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
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

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            StatisticItem statisticItem = new StatisticItem("c12137");
            statisticItem.param("obj_locate", "2");
            TiebaStatic.log(statisticItem);
            aVar.dismiss();
            d.a.o0.y0.a.d();
        }
    }

    /* loaded from: classes5.dex */
    public class k extends CustomMessageListener {
        public k(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.e0.c cVar;
            if (customResponsedMessage == null || d.this.f59427b == null || !(customResponsedMessage.getData() instanceof d.a.n0.e0.c) || (cVar = (d.a.n0.e0.c) customResponsedMessage.getData()) == null || d.this.f59427b.g(cVar.f53119e) == null || d.this.f59427b.getCurrentTabType() == 21) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = d.this.f59427b.g(cVar.f53119e).f12294b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f53121g, cVar.f53117c);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class l extends CustomMessageListener {
        public l(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.a.n0.e0.e.a c2;
            d.a.n0.e0.e.a c3;
            d.a.n0.e0.e.a c4;
            d.a.n0.e0.e.a c5;
            d.a.n0.e0.e.a c6;
            if (customResponsedMessage == null || d.this.f59427b == null || !(customResponsedMessage.getData() instanceof Boolean) || !((Boolean) customResponsedMessage.getData()).booleanValue()) {
                return;
            }
            FragmentTabHost.b g2 = d.this.f59427b.g(2);
            if (g2 != null && (g2.f12294b instanceof MaintabBottomIndicator) && (c6 = d.a.n0.e0.e.c.d().c("homePage")) != null) {
                ((MaintabBottomIndicator) g2.f12294b).setDynamicIconData(c6);
            }
            FragmentTabHost.b g3 = d.this.f59427b.g(1);
            if (g3 != null && (g3.f12294b instanceof MaintabBottomIndicator) && (c5 = d.a.n0.e0.e.c.d().c("enterForum")) != null) {
                ((MaintabBottomIndicator) g3.f12294b).setDynamicIconData(c5);
            }
            FragmentTabHost.b g4 = d.this.f59427b.g(22);
            if (g4 != null && (g4.f12294b instanceof MaintabBottomIndicator) && (c4 = d.a.n0.e0.e.c.d().c("channel")) != null) {
                ((MaintabBottomIndicator) g4.f12294b).setDynamicIconData(c4);
            }
            FragmentTabHost.b g5 = d.this.f59427b.g(3);
            if (g5 != null && (g5.f12294b instanceof MaintabBottomIndicator) && (c3 = d.a.n0.e0.e.c.d().c("message")) != null) {
                ((MaintabBottomIndicator) g5.f12294b).setDynamicIconData(c3);
            }
            FragmentTabHost.b g6 = d.this.f59427b.g(8);
            if (g6 == null || !(g6.f12294b instanceof MaintabBottomIndicator) || (c2 = d.a.n0.e0.e.c.d().c("person")) == null) {
                return;
            }
            ((MaintabBottomIndicator) g6.f12294b).setDynamicIconData(c2);
        }
    }

    /* loaded from: classes5.dex */
    public class m extends CustomMessageListener {
        public m(int i2) {
            super(i2);
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
                        d.this.u.x(d.this.w);
                        return;
                    }
                    d.this.A().w();
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
                    d.this.A().x(d.this.w);
                } else if (d.this.x == 2) {
                    d.this.A().y();
                } else if (intValue == 5) {
                    d.this.x = 1;
                    d.this.w = true;
                    if (!d.this.y) {
                        d.this.A().w();
                    }
                } else {
                    d.this.A().v();
                }
                d.this.A().z = true;
                d.this.A().B = d.this.x;
                d.this.A().A = d.this.w;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n extends CustomMessageListener {
        public n(int i2) {
            super(i2);
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
        public void onPageScrollStateChanged(int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i2, float f2, int i3) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i2) {
            if (d.this.f59427b.getCurrentTabType() != 2) {
                if (d.this.f59427b.getCurrentTabType() == 15) {
                    TiebaStatic.log("c12124");
                }
            } else {
                TiebaStatic.log("kantie_entry");
            }
            d.this.N();
            if (d.this.f59427b.getCurrentTabType() != d.this.f59427b.f(i2).f12293a) {
                d.this.f59427b.setCurrentTab(i2);
            }
            if (d.this.f59427b.getCurrentTabType() != 1) {
                d.this.f59430e.setVisibility(8);
                d.this.f59433h.setVisibility(0);
            }
            if (d.this.f59427b.getCurrentTabType() == 1 && !d.a.n0.r.d0.b.j().g("has_guide_popup_window_been_shown", false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
            }
            d dVar = d.this;
            dVar.m = dVar.f59427b.getCurrentTabType();
            d.this.Q();
            if (d.a.n0.r.d0.b.j().g("enter_forum_edit_mode", false)) {
                if (d.this.f59427b.getCurrentTabType() != 3) {
                    if (d.this.f59427b.getCurrentTabType() == 2) {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                    }
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                }
            }
            if (d.this.f59427b.getCurrentTabType() == 3) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f59449e;

        public p(String str) {
            this.f59449e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.S(this.f59449e);
        }
    }

    /* loaded from: classes5.dex */
    public class q implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f59451e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59452f;

        public q(d.a.n0.r.s.a aVar, int i2) {
            this.f59451e = aVar;
            this.f59452f = i2;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            this.f59451e.dismiss();
            int i2 = this.f59452f;
            if (i2 == 0) {
                TiebaStatic.eventStat(d.this.f59426a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (i2 == 1) {
                TiebaStatic.eventStat(d.this.f59426a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class r implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.n0.r.s.a f59454e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59455f;

        public r(d.a.n0.r.s.a aVar, int i2) {
            this.f59454e = aVar;
            this.f59455f = i2;
        }

        @Override // d.a.n0.r.s.a.e
        public void onClick(d.a.n0.r.s.a aVar) {
            String str;
            this.f59454e.dismiss();
            int i2 = this.f59455f;
            if (i2 == 0) {
                TiebaStatic.eventStat(d.this.f59426a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                str = "4006001000";
            } else if (i2 == 1) {
                TiebaStatic.eventStat(d.this.f59426a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                str = "4005001000";
            } else {
                str = null;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.f59426a.getPageContext().getPageActivity(), 2);
            if (!StringUtils.isNULL(str)) {
                memberPayActivityConfig.setSceneId(str);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.f59426a = mainTabActivity;
    }

    public MaintabBottomIndicator A() {
        return this.u;
    }

    public MaintabBottomIndicator B() {
        return this.t;
    }

    public FragmentTabHost C() {
        return this.f59427b;
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
        NavigationBar navigationBar = (NavigationBar) this.f59426a.findViewById(R.id.view_navigation_bar);
        this.f59428c = navigationBar;
        if (navigationBar != null) {
            this.f59429d = (TextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.f59426a.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.f59429d.setLayoutParams(layoutParams);
            View addCustomView = this.f59428c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.f59431f = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.f59432g = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.f59431f.setOnClickListener(new b());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, d.a.c.e.p.l.g(this.f59426a.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            ImageView imageView = (ImageView) this.f59428c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.f59433h = imageView;
            imageView.setLayoutParams(layoutParams2);
            this.f59433h.setVisibility(8);
            this.f59433h.setOnClickListener(new c());
            ImageView imageView2 = (ImageView) this.f59428c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.f59430e = imageView2;
            imageView2.setLayoutParams(layoutParams2);
            this.f59430e.setVisibility(8);
            this.f59430e.setOnClickListener(new View$OnClickListenerC1427d());
            this.f59428c.setLoginClickListener(new e());
            this.f59428c.setRegisterClickListener(new f());
        }
    }

    public void F(ArrayList<d.a.n0.e0.b> arrayList) {
        this.f59427b.q();
        Iterator<d.a.n0.e0.b> it = arrayList.iterator();
        while (it.hasNext()) {
            d.a.n0.e0.b next = it.next();
            if (next != null && next.isAvailable()) {
                y(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f59426a.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.f59427b.k(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.f59427b.k(1);
        } else {
            this.f59427b.k(0);
        }
        this.f59427b.setViewPagerScrollable(false);
    }

    public void G() {
        this.y = false;
        this.x = 1;
        if (A() != null) {
            A().B = this.x;
        }
    }

    public boolean H() {
        ImageView imageView = this.f59431f;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public boolean I() {
        return this.n;
    }

    public void J(int i2) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.f59427b.setShouldDrawTopLine(false);
        }
        this.f59427b.p(i2);
        FragmentTabHost fragmentTabHost = this.f59427b;
        FragmentTabHost.b f2 = fragmentTabHost.f(fragmentTabHost.getCurrentTabIndex());
        if (f2 != null && f2.f12293a == 22) {
            if (this.f59427b.getFragmentTabWidget() != null) {
                this.f59427b.getFragmentTabWidget().g(true, R.color.CAM_X0215);
            }
            this.f59427b.n(true);
        } else {
            if (this.f59427b.getFragmentTabWidget() != null) {
                this.f59427b.getFragmentTabWidget().g(false, R.color.CAM_X0207);
            }
            this.f59427b.n(false);
        }
        this.f59428c.onChangeSkinType(this.f59426a.getPageContext(), i2);
        SkinManager.setNavbarTitleColor(this.f59429d, R.color.CAM_X0105, R.color.s_navbar_title_color, i2);
        SkinManager.setImageResource(this.f59432g, R.drawable.icon_news_down_bar_one);
        SkinManager.setNavbarIconSrc(this.f59431f, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59433h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f59430e, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    public void K() {
        R();
        if (C() != null) {
            C().q();
        }
        z();
        d.a.o0.d0.h hVar = this.r;
        if (hVar != null) {
            hVar.i();
        }
        d.a.o0.r3.e eVar = this.s;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void L(boolean z) {
        FragmentTabHost fragmentTabHost = this.f59427b;
        if (fragmentTabHost != null) {
            if (z) {
                fragmentTabHost.h();
                D();
                return;
            }
            fragmentTabHost.r();
        }
    }

    public void M(boolean z) {
        FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f59426a.findViewById(R.id.tab_host);
        this.f59427b = fragmentTabHost;
        fragmentTabHost.setup(this.f59426a.getSupportFragmentManager());
        this.f59427b.setAbsoluteWeight(true);
        this.f59427b.setOnTabSelectionListener(this.z);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.f59427b.setShouldDrawIndicatorLine(false);
            this.f59427b.setShouldDrawTopLine(true);
        }
        this.f59427b.setOnPageChangeListener(new o());
        this.l = d.a.n0.r.d0.b.j().g("has_show_message_tab_tips", false);
        E();
        this.j = (ImageView) this.f59426a.findViewById(R.id.home_page_new_write_icon);
        this.k = (TextView) this.f59426a.findViewById(R.id.view_bottom_text);
        this.f59434i = (TextView) this.f59426a.findViewById(R.id.activity_prize_my_tip);
        this.f59427b.setUIType(0);
        this.f59427b.setTabContainerShadowShow(false);
        this.f59427b.setBackGroundStyle(0);
        this.f59427b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        D();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f59426a.getPageContext()));
        b0(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.f59426a.registerListener(this.C);
        }
        this.f59426a.registerListener(this.D);
        this.f59426a.registerListener(this.A);
        this.f59426a.registerListener(this.B);
    }

    public void N() {
        FragmentTabHost fragmentTabHost = this.f59427b;
        if (fragmentTabHost != null) {
            if (fragmentTabHost.getCurrentTabType() == 8 || this.f59427b.getCurrentTabType() == 3 || this.f59427b.getCurrentTabType() == 2 || this.f59427b.getCurrentTabType() == 15 || this.f59427b.getCurrentTabType() == 1) {
                NavigationBar navigationBar = this.f59428c;
                if (navigationBar != null) {
                    navigationBar.setVisibility(8);
                }
                this.f59433h.setVisibility(8);
            }
        }
    }

    public void O(int i2) {
        MaintabBottomIndicator maintabBottomIndicator;
        C().setCurrentTabByType(i2);
        if (i2 != 2) {
            this.y = true;
            if (this.w && (maintabBottomIndicator = this.u) != null) {
                maintabBottomIndicator.x(false);
            }
            this.w = false;
            if (A() != null) {
                A().A = this.w;
            }
        }
    }

    public final void P(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f59431f.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = d.a.c.e.p.l.g(this.f59426a.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = d.a.c.e.p.l.g(this.f59426a.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.f59431f.setLayoutParams(layoutParams);
        }
    }

    public void Q() {
        FragmentTabHost.b g2;
        d.a.n0.e0.b bVar;
        FragmentTabHost fragmentTabHost = this.f59427b;
        if (fragmentTabHost == null || (g2 = fragmentTabHost.g(fragmentTabHost.getCurrentTabType())) == null || (bVar = g2.f12296d) == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        String string = this.f59426a.getPageContext().getString(g2.f12296d.getFragmentTabStructure().f53116b);
        TextView textView = this.f59429d;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public void R() {
        d.a.n0.r.d0.b.j().t("has_show_message_tab_tips", this.l);
    }

    public void S(String str) {
        PopupWindow popupWindow;
        if (StringUtils.isNull(str)) {
            this.f59434i.setVisibility(8);
            return;
        }
        FragmentTabHost.b g2 = this.f59427b.g(8);
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
        this.f59434i.setVisibility(8);
    }

    public final void T(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.f12294b.getLocationInWindow(iArr);
        int width = iArr[0] + (bVar.f12294b.getWidth() / 2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f59434i.getLayoutParams();
        layoutParams.rightMargin = (d.a.c.e.p.l.q(this.f59426a).widthPixels - width) - d.a.c.e.p.l.g(this.f59426a.getPageContext().getPageActivity(), R.dimen.ds26);
        this.f59434i.setLayoutParams(layoutParams);
        this.f59434i.setVisibility(0);
        this.f59434i.setText(str);
    }

    public void U(String str) {
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f59426a.getActivity());
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.close, new i(this));
        aVar.setNegativeButton(R.string.check, new j(this));
        aVar.create(this.f59426a.getPageContext()).show();
    }

    public void V(boolean z) {
        ImageView imageView = this.f59431f;
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
                if (this.f59432g.getVisibility() != 0) {
                    this.f59432g.setVisibility(0);
                    P(true);
                    SkinManager.setImageResource(this.f59432g, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            P(false);
            this.f59432g.setVisibility(8);
        }
    }

    public void X(PayMemberInfoData payMemberInfoData, int i2) {
        if (payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f59426a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
        TbImageView tbImageView = (TbImageView) inflate.findViewById(R.id.member_icon);
        TextView textView = (TextView) inflate.findViewById(R.id.member_died_line_tip);
        boolean z = TbadkCoreApplication.getInst().getSkinType() == 1;
        SkinManager.setViewTextColor(textView, R.color.CAM_X0105, 1);
        if (!StringUtils.isNull(payMemberInfoData.x())) {
            textView.setText(payMemberInfoData.x());
        }
        if (!StringUtils.isNull(payMemberInfoData.getUrl())) {
            tbImageView.U(payMemberInfoData.getUrl(), 21, false);
            tbImageView.setIsNight(z);
        } else {
            SkinManager.setImageResource(tbImageView, R.drawable.icon_vip_advanced);
        }
        d.a.n0.r.s.a aVar = new d.a.n0.r.s.a(this.f59426a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new q(aVar, i2));
        String string = this.f59426a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f59426a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new r(aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f59426a.getPageContext()).show();
        d.a.n0.r.d0.b.j().t("show_member_deid_line", false);
    }

    public void Y(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.s == null) {
            MainTabActivity mainTabActivity = this.f59426a;
            this.s = new d.a.o0.r3.e(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.s.g(postWriteCallBackData);
    }

    public void Z(boolean z) {
        if (z) {
            this.f59430e.setVisibility(0);
            this.f59433h.setVisibility(8);
            return;
        }
        this.f59430e.setVisibility(8);
        this.f59433h.setVisibility(0);
    }

    public void a0(PostWriteCallBackData postWriteCallBackData) {
        if (this.r == null) {
            this.r = new d.a.o0.d0.h(this.f59426a.getPageContext(), (NavigationBarCoverTip) this.f59426a.findViewById(R.id.navigation_cover_tip));
        }
        this.r.m(postWriteCallBackData);
    }

    public void b0(boolean z) {
        NavigationBar navigationBar = this.f59428c;
        if (navigationBar != null) {
            navigationBar.switchNaviBarStatus(z);
        }
    }

    public void w(boolean z) {
        this.n = z;
        if (z) {
            return;
        }
        d.a.n0.r.d0.b.j().t("enter_forum_edit_mode", false);
    }

    public boolean x(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.a.c.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (d.a.n0.r.d0.b.j().g(d.a.n0.r.d0.b.n(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f59426a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
            return true;
        }
        return false;
    }

    public final void y(d.a.n0.e0.b bVar, d.a.n0.e0.c cVar, TbFragmentTabIndicator tbFragmentTabIndicator) {
        if (cVar == null || !(tbFragmentTabIndicator instanceof MaintabBottomIndicator)) {
            return;
        }
        MaintabBottomIndicator maintabBottomIndicator = (MaintabBottomIndicator) tbFragmentTabIndicator;
        FragmentTabHost.b bVar2 = new FragmentTabHost.b();
        boolean z = false;
        bVar2.f12295c = cVar.f53115a;
        bVar2.f12293a = cVar.f53119e;
        maintabBottomIndicator.setShowIconType(cVar.f53123i);
        int i2 = cVar.f53123i;
        if (i2 == d.a.n0.e0.c.j) {
            maintabBottomIndicator.setWriteIconView();
            z = true;
        } else if (i2 == d.a.n0.e0.c.m) {
            maintabBottomIndicator.setText(cVar.f53116b);
            maintabBottomIndicator.setAnimationResId(cVar.f53120f);
            this.t = maintabBottomIndicator;
        } else {
            maintabBottomIndicator.setText(cVar.f53116b);
            maintabBottomIndicator.setAnimationResId(cVar.f53120f);
        }
        if (!d.a.c.e.p.k.isEmpty(cVar.f53121g)) {
            maintabBottomIndicator.setImageIconUrl(cVar.f53121g, cVar.f53117c);
        }
        d.a.n0.e0.e.a aVar = cVar.f53122h;
        if (aVar != null) {
            maintabBottomIndicator.setDynamicIconData(aVar);
        }
        if (bVar2.f12293a == 2) {
            maintabBottomIndicator.D = true;
            this.u = maintabBottomIndicator;
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        bVar2.f12294b = maintabBottomIndicator;
        bVar2.f12296d = bVar;
        this.f59427b.c(bVar2, -1, z);
    }

    public void z() {
        this.q.removeCallbacks(this.F);
        this.q.removeCallbacks(this.G);
        d.a.c.e.m.g.c(this.o);
    }
}
