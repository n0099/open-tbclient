package d.b.i0.f3;

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
    public Runnable D;

    /* renamed from: a  reason: collision with root package name */
    public MainTabActivity f54835a;

    /* renamed from: b  reason: collision with root package name */
    public FragmentTabHost f54836b;

    /* renamed from: c  reason: collision with root package name */
    public NavigationBar f54837c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f54838d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f54839e;

    /* renamed from: f  reason: collision with root package name */
    public ImageView f54840f;

    /* renamed from: g  reason: collision with root package name */
    public ImageView f54841g;

    /* renamed from: h  reason: collision with root package name */
    public ImageView f54842h;
    public TextView i;
    public ImageView j;
    public TextView k;
    public boolean n;
    public PopupWindow o;
    public d.b.i0.b0.h r;
    public d.b.i0.p3.e s;
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
    public CustomMessageListener A = new j(2921492);
    public CustomMessageListener B = new k(2921382);
    public CustomMessageListener C = new l(2921410);
    public Runnable E = new f();
    public Runnable F = new g();

    /* loaded from: classes5.dex */
    public class a implements FragmentTabHost.a {

        /* renamed from: d.b.i0.f3.d$a$a  reason: collision with other inner class name */
        /* loaded from: classes5.dex */
        public class RunnableC1252a implements Runnable {

            /* renamed from: e  reason: collision with root package name */
            public final /* synthetic */ CustomResponsedMessage f54844e;

            public RunnableC1252a(a aVar, CustomResponsedMessage customResponsedMessage) {
                this.f54844e = customResponsedMessage;
            }

            @Override // java.lang.Runnable
            public void run() {
                MessageManager.getInstance().dispatchResponsedMessage(this.f54844e);
            }
        }

        public a() {
        }

        public final void a(int i) {
            String m;
            if (d.this.f54836b.f(i).f13310a == 2) {
                m = TbPageExtraHelper.l(d.this.f54835a.getPageContext().getContext());
            } else {
                m = TbPageExtraHelper.m();
            }
            d.b.b.e.m.e.a().postDelayed(new RunnableC1252a(this, new CustomResponsedMessage(2921520, m)), 100L);
        }

        public final void b(int i) {
            int i2 = d.this.f54836b.f(i).f13310a;
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
            FragmentTabHost.b f2 = d.this.f54836b.f(i);
            int i2 = f2.f13310a;
            if (i2 != 9) {
                if (i2 == 8 && !ViewHelper.checkUpIsLogin(d.this.f54835a.getActivity())) {
                    if (d.this.t != null) {
                        d.this.t.n();
                    }
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
                    return false;
                }
                int i3 = f2.f13310a;
                if (i3 != 15) {
                    if (i3 == 3 && !ViewHelper.checkUpIsLogin(d.this.f54835a.getActivity())) {
                        return false;
                    }
                    if (f2.f13310a == 1) {
                        TiebaStatic.log(new StatisticItem("c13001"));
                    }
                } else {
                    CustomResponsedMessage runTask = MessageManager.getInstance().runTask(2911006, String.class);
                    if (runTask != null && !StringUtils.isNull((String) runTask.getData())) {
                        UrlManager.getInstance().dealOneLink((TbPageContext<?>) d.this.f54835a.getPageContext(), new String[]{(String) runTask.getData()}, true);
                        return false;
                    }
                }
                return true;
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921452, new d.b.h0.t.j(0)));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921308, Integer.valueOf(i)));
            return false;
        }

        @Override // com.baidu.tbadk.core.tabHost.FragmentTabHost.a
        public void onTabSelectionChanged(int i, boolean z) {
            FragmentTabHost.b f2 = d.this.f54836b.f(i);
            int i2 = f2.f13310a;
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
            if (f2.f13310a == 2) {
                if (d.this.w) {
                    MessageManager.getInstance().runTask(2921405, Boolean.class, Boolean.TRUE);
                }
                d.this.w = true;
                int homeBarShowType = TbadkCoreApplication.getInst().getHomeBarShowType();
                if (d.this.x != 2 || d.this.v == i || homeBarShowType != 1) {
                    if (d.this.x == 1) {
                        d.this.u.v(d.this.w);
                    }
                } else {
                    d.this.u.w();
                }
                d.this.y = false;
            } else {
                d.this.y = true;
                if (d.this.w) {
                    d.this.u.v(d.this.w);
                }
                d.this.w = false;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921415));
            }
            if (d.this.A() != null) {
                d.this.A().z = d.this.w;
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
            d.this.f54835a.sendMessage(new CustomMessage(2015003, new IntentConfig(d.this.f54835a.getPageContext().getPageActivity())));
            int i = 3;
            if (d.this.f54836b.getCurrentTabType() != 3) {
                i = d.this.f54836b.getCurrentTabType() == 2 ? 1 : 0;
            }
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.SEARCH_BAR_CLICK).param("obj_type", i));
        }
    }

    /* loaded from: classes5.dex */
    public class c implements View.OnClickListener {
        public c() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (TbadkCoreApplication.getInst().appResponseToIntentClass(SignAllForumActivityConfig.class)) {
                d.this.f54835a.sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(d.this.f54835a.getPageContext().getPageActivity())));
                TiebaStatic.log("c10085");
            }
        }
    }

    /* renamed from: d.b.i0.f3.d$d  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class View$OnClickListenerC1253d implements View.OnClickListener {
        public View$OnClickListenerC1253d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(d.this.f54835a.getPageContext().getPageActivity(), "notlogin_4", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            ViewHelper.skipToLoginActivity(d.this.f54835a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class e implements View.OnClickListener {
        public e() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            TiebaStatic.eventStat(d.this.f54835a.getPageContext().getPageActivity(), "notlogin_3", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            int i = d.this.m;
            TiebaStatic.log(new StatisticItem("c10517").param("obj_source", i != 1 ? i != 2 ? i != 3 ? i != 8 ? "" : "profile" : "message" : "kantie" : "forum"));
            ViewHelper.skipToRegisterActivity(d.this.f54835a.getPageContext().getPageActivity());
        }
    }

    /* loaded from: classes5.dex */
    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            TbFragmentTabIndicator tbFragmentTabIndicator;
            if (d.this.f54836b == null || d.this.o == null) {
                return;
            }
            FragmentTabWidget fragmentTabWidget = d.this.f54836b.getFragmentTabWidget();
            d.b.b.e.p.l.k(d.this.f54835a.getActivity());
            int g2 = d.b.b.e.p.l.g(d.this.f54835a.getActivity(), R.dimen.ds178);
            View contentView = d.this.o.getContentView();
            if (contentView == null) {
                return;
            }
            contentView.measure(0, 0);
            int measuredWidth = contentView.getMeasuredWidth();
            FragmentTabHost.b g3 = d.this.f54836b.g(3);
            if (g3 == null || (tbFragmentTabIndicator = g3.f13311b) == null) {
                return;
            }
            int[] iArr = new int[2];
            tbFragmentTabIndicator.getLocationInWindow(iArr);
            int measuredWidth2 = (iArr[0] + (tbFragmentTabIndicator.getMeasuredWidth() / 2)) - (measuredWidth / 2);
            if (measuredWidth2 <= 0) {
                measuredWidth2 = d.b.b.e.p.l.g(d.this.f54835a.getActivity(), R.dimen.tbds570);
            }
            d.b.b.e.m.g.l(d.this.o, fragmentTabWidget, measuredWidth2, -g2);
            d.b.h0.r.d0.b.i().s("show_maintab_last_message_tips", true);
            d.this.p = true;
            d.this.q.postDelayed(d.this.F, 5000L);
        }
    }

    /* loaded from: classes5.dex */
    public class g implements Runnable {
        public g() {
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.z();
        }
    }

    /* loaded from: classes5.dex */
    public class h implements a.e {
        public h(d dVar) {
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
    public class i implements a.e {
        public i(d dVar) {
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            StatisticItem statisticItem = new StatisticItem("c12137");
            statisticItem.param("obj_locate", "2");
            TiebaStatic.log(statisticItem);
            aVar.dismiss();
            d.b.i0.w0.a.d();
        }
    }

    /* loaded from: classes5.dex */
    public class j extends CustomMessageListener {
        public j(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            d.b.h0.e0.c cVar;
            if (customResponsedMessage == null || d.this.f54836b == null || !(customResponsedMessage.getData() instanceof d.b.h0.e0.c) || (cVar = (d.b.h0.e0.c) customResponsedMessage.getData()) == null || d.this.f54836b.g(cVar.f50158e) == null || d.this.f54836b.getCurrentTabType() == 21) {
                return;
            }
            TbFragmentTabIndicator tbFragmentTabIndicator = d.this.f54836b.g(cVar.f50158e).f13311b;
            if (tbFragmentTabIndicator instanceof MaintabBottomIndicator) {
                ((MaintabBottomIndicator) tbFragmentTabIndicator).setImageIconUrl(cVar.f50160g, cVar.f50156c);
            }
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
                        if (d.this.u.p()) {
                            d.this.u.v(d.this.w);
                            return;
                        }
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
                d.this.A().y = true;
                d.this.A().A = d.this.x;
                d.this.A().z = d.this.w;
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
            d.this.w = true;
            if (d.this.A() != null) {
                d.this.A().z = d.this.w;
            }
        }
    }

    /* loaded from: classes5.dex */
    public class m implements ViewPager.OnPageChangeListener {
        public m() {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrollStateChanged(int i) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageScrolled(int i, float f2, int i2) {
        }

        @Override // androidx.viewpager.widget.ViewPager.OnPageChangeListener
        public void onPageSelected(int i) {
            if (d.this.f54836b.getCurrentTabType() != 2) {
                if (d.this.f54836b.getCurrentTabType() == 15) {
                    TiebaStatic.log("c12124");
                }
            } else {
                TiebaStatic.log("kantie_entry");
            }
            d.this.N();
            if (d.this.f54836b.getCurrentTabType() != d.this.f54836b.f(i).f13310a) {
                d.this.f54836b.setCurrentTab(i);
            }
            if (d.this.f54836b.getCurrentTabType() != 1) {
                d.this.f54839e.setVisibility(8);
                d.this.f54842h.setVisibility(0);
            }
            if (d.this.f54836b.getCurrentTabType() == 1 && !d.b.h0.r.d0.b.i().g("has_guide_popup_window_been_shown", false)) {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921474));
            }
            d dVar = d.this;
            dVar.m = dVar.f54836b.getCurrentTabType();
            d.this.Q();
            if (d.b.h0.r.d0.b.i().g("enter_forum_edit_mode", false)) {
                if (d.this.f54836b.getCurrentTabType() != 3) {
                    if (d.this.f54836b.getCurrentTabType() == 2) {
                        TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_RECOMMENDFRS_CLICK);
                    }
                } else {
                    TiebaStatic.log(TbadkCoreStatisticKey.ENTER_FORUM_EDIT_MENTION_CLICK);
                }
            }
            if (d.this.f54836b.getCurrentTabType() == 3) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_MESSAGE_AGGREGATION_PV).param("nobatch", "1"));
            }
        }
    }

    /* loaded from: classes5.dex */
    public class n implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ String f54855e;

        public n(String str) {
            this.f54855e = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.S(this.f54855e);
        }
    }

    /* loaded from: classes5.dex */
    public class o implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f54857e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f54858f;

        public o(d.b.h0.r.s.a aVar, int i) {
            this.f54857e = aVar;
            this.f54858f = i;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            this.f54857e.dismiss();
            int i = this.f54858f;
            if (i == 0) {
                TiebaStatic.eventStat(d.this.f54835a.getPageContext().getPageActivity(), "user_overdue_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            } else if (i == 1) {
                TiebaStatic.eventStat(d.this.f54835a.getPageContext().getPageActivity(), "user_expire_know", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class p implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f54860e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f54861f;

        public p(d.b.h0.r.s.a aVar, int i) {
            this.f54860e = aVar;
            this.f54861f = i;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            String str;
            this.f54860e.dismiss();
            int i = this.f54861f;
            if (i == 0) {
                TiebaStatic.eventStat(d.this.f54835a.getPageContext().getPageActivity(), "user_overdue_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                str = "4006001000";
            } else if (i == 1) {
                TiebaStatic.eventStat(d.this.f54835a.getPageContext().getPageActivity(), "user_expire_pay", PrefetchEvent.STATE_CLICK, 1, new Object[0]);
                str = "4005001000";
            } else {
                str = null;
            }
            MemberPayActivityConfig memberPayActivityConfig = new MemberPayActivityConfig(d.this.f54835a.getPageContext().getPageActivity(), 2);
            if (!StringUtils.isNULL(str)) {
                memberPayActivityConfig.setSceneId(str);
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, memberPayActivityConfig));
        }
    }

    /* loaded from: classes5.dex */
    public class q implements View.OnClickListener {
        public q() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            d.this.P(false);
            d.this.f54841g.setVisibility(8);
            d.b.h0.r.d0.b.i().s("game_is_show_tip", false);
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001230, Boolean.FALSE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016508, d.this.f54835a.getPageContext()));
            TiebaStatic.eventStat(d.this.f54835a.getPageContext().getPageActivity(), "tb_gamecenter", PrefetchEvent.STATE_CLICK, 1, "ref_type", "601");
        }
    }

    public d(MainTabActivity mainTabActivity) {
        this.f54835a = mainTabActivity;
    }

    public MaintabBottomIndicator A() {
        return this.u;
    }

    public MaintabBottomIndicator B() {
        return this.t;
    }

    public FragmentTabHost C() {
        return this.f54836b;
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
        NavigationBar navigationBar = (NavigationBar) this.f54835a.findViewById(R.id.view_navigation_bar);
        this.f54837c = navigationBar;
        if (navigationBar != null) {
            this.f54838d = (TextView) navigationBar.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_LEFT, R.layout.maintab_title_layout, (View.OnClickListener) null).findViewById(R.id.title_textview);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
            int dimension = (int) this.f54835a.getResources().getDimension(R.dimen.ds16);
            layoutParams.setMargins(dimension, dimension, 0, dimension);
            this.f54838d.setLayoutParams(layoutParams);
            View addCustomView = this.f54837c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.game_tip_view, (View.OnClickListener) null);
            this.f54840f = (ImageView) addCustomView.findViewById(R.id.game_button_iv);
            this.f54841g = (ImageView) addCustomView.findViewById(R.id.game_tip_msg_iv);
            this.f54840f.setOnClickListener(new q());
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
            layoutParams2.setMargins(0, 0, d.b.b.e.p.l.g(this.f54835a.getPageContext().getPageActivity(), R.dimen.ds16), 0);
            ImageView imageView = (ImageView) this.f54837c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_search, (View.OnClickListener) null);
            this.f54842h = imageView;
            imageView.setLayoutParams(layoutParams2);
            this.f54842h.setVisibility(8);
            this.f54842h.setOnClickListener(new b());
            ImageView imageView2 = (ImageView) this.f54837c.addCustomView(NavigationBar.ControlAlign.HORIZONTAL_RIGHT, R.layout.widget_nb_item_signall, (View.OnClickListener) null);
            this.f54839e = imageView2;
            imageView2.setLayoutParams(layoutParams2);
            this.f54839e.setVisibility(8);
            this.f54839e.setOnClickListener(new c());
            this.f54837c.setLoginClickListener(new View$OnClickListenerC1253d());
            this.f54837c.setRegisterClickListener(new e());
        }
    }

    public void F(ArrayList<d.b.h0.e0.b> arrayList) {
        this.f54836b.p();
        Iterator<d.b.h0.e0.b> it = arrayList.iterator();
        while (it.hasNext()) {
            d.b.h0.e0.b next = it.next();
            if (next != null && next.isAvailable()) {
                y(next, next.getFragmentTabStructure(), next.getTabIndicator(this.f54835a.getPageContext().getPageActivity()));
            }
        }
        if (TbadkCoreApplication.getInst().getSkinType() == 2 && TbadkCoreApplication.getInst().isThemeIconCover()) {
            this.f54836b.k(2);
        } else if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.f54836b.k(1);
        } else {
            this.f54836b.k(0);
        }
        this.f54836b.setViewPagerScrollable(false);
    }

    public void G() {
        this.y = false;
        this.x = 1;
        if (A() != null) {
            A().A = this.x;
        }
    }

    public boolean H() {
        ImageView imageView = this.f54840f;
        return imageView != null && imageView.getVisibility() == 0;
    }

    public boolean I() {
        return this.n;
    }

    public void J(int i2) {
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.f54836b.setShouldDrawTopLine(false);
        }
        if (this.f54836b.getFragmentTabWidget() != null) {
            this.f54836b.getFragmentTabWidget().setBackGroundDrawableResId(R.color.CAM_X0207);
        }
        this.f54836b.o(i2);
        this.f54837c.onChangeSkinType(this.f54835a.getPageContext(), i2);
        SkinManager.setNavbarTitleColor(this.f54838d, R.color.CAM_X0105, R.color.s_navbar_title_color, i2);
        SkinManager.setImageResource(this.f54841g, R.drawable.icon_news_down_bar_one);
        SkinManager.setNavbarIconSrc(this.f54840f, R.drawable.icon_game_bg_s, R.drawable.icon_game_bg);
        SkinManager.setViewTextColor(this.k, R.color.CAM_X0106);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54842h, R.drawable.icon_pure_topbar_search44_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL_PRESS);
        SvgManager.getInstance().setPureDrawableWithDayNightModeAutoChange(this.f54839e, R.drawable.icon_pure_topbar_sign44_svg, R.color.CAM_X0107, SvgManager.SvgResourceStateType.NORMAL_PRESS);
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
        d.b.i0.p3.e eVar = this.s;
        if (eVar != null) {
            eVar.e();
        }
    }

    public void L(boolean z) {
        FragmentTabHost fragmentTabHost = this.f54836b;
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
        FragmentTabHost fragmentTabHost = (FragmentTabHost) this.f54835a.findViewById(R.id.tab_host);
        this.f54836b = fragmentTabHost;
        fragmentTabHost.setup(this.f54835a.getSupportFragmentManager());
        this.f54836b.setAbsoluteWeight(true);
        this.f54836b.setOnTabSelectionListener(this.z);
        if (MainTabActivityConfig.IS_INDICATOR_BOTTOM) {
            this.f54836b.setShouldDrawIndicatorLine(false);
            this.f54836b.setShouldDrawTopLine(true);
        }
        this.f54836b.setOnPageChangeListener(new m());
        this.l = d.b.h0.r.d0.b.i().g("has_show_message_tab_tips", false);
        E();
        this.j = (ImageView) this.f54835a.findViewById(R.id.home_page_new_write_icon);
        this.k = (TextView) this.f54835a.findViewById(R.id.view_bottom_text);
        this.i = (TextView) this.f54835a.findViewById(R.id.activity_prize_my_tip);
        this.f54836b.setUIType(0);
        this.f54836b.setTabContainerShadowShow(false);
        this.f54836b.setBackGroundStyle(0);
        this.f54836b.setTabWidgetViewHeight(TbadkCoreApplication.getInst().getMainTabBottomBarHeight());
        D();
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001307, this.f54835a.getPageContext()));
        b0(z);
        if (!TbSingleton.getInstance().isShowHomeFloatRefreshButton()) {
            this.f54835a.registerListener(this.B);
        }
        this.f54835a.registerListener(this.C);
        this.f54835a.registerListener(this.A);
    }

    public void N() {
        FragmentTabHost fragmentTabHost = this.f54836b;
        if (fragmentTabHost != null) {
            if (fragmentTabHost.getCurrentTabType() == 8 || this.f54836b.getCurrentTabType() == 3 || this.f54836b.getCurrentTabType() == 2 || this.f54836b.getCurrentTabType() == 15 || this.f54836b.getCurrentTabType() == 1) {
                NavigationBar navigationBar = this.f54837c;
                if (navigationBar != null) {
                    navigationBar.setVisibility(8);
                }
                this.f54842h.setVisibility(8);
            }
        }
    }

    public void O(int i2) {
        C().setCurrentTabByType(i2);
        if (i2 != 2) {
            this.y = true;
            if (this.w) {
                this.u.v(false);
            }
            this.w = false;
            if (A() != null) {
                A().z = this.w;
            }
        }
    }

    public final void P(boolean z) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.f54840f.getLayoutParams();
        if (layoutParams != null) {
            if (z) {
                layoutParams.rightMargin = d.b.b.e.p.l.g(this.f54835a.getPageContext().getPageActivity(), R.dimen.ds32);
            } else {
                layoutParams.rightMargin = d.b.b.e.p.l.g(this.f54835a.getPageContext().getPageActivity(), R.dimen.ds20);
            }
            this.f54840f.setLayoutParams(layoutParams);
        }
    }

    public void Q() {
        FragmentTabHost.b g2;
        d.b.h0.e0.b bVar;
        FragmentTabHost fragmentTabHost = this.f54836b;
        if (fragmentTabHost == null || (g2 = fragmentTabHost.g(fragmentTabHost.getCurrentTabType())) == null || (bVar = g2.f13313d) == null || bVar.getFragmentTabStructure() == null) {
            return;
        }
        String string = this.f54835a.getPageContext().getString(g2.f13313d.getFragmentTabStructure().f50155b);
        TextView textView = this.f54838d;
        if (textView != null) {
            textView.setText(string);
        }
    }

    public void R() {
        d.b.h0.r.d0.b.i().s("has_show_message_tab_tips", this.l);
    }

    public void S(String str) {
        PopupWindow popupWindow;
        if (StringUtils.isNull(str)) {
            this.i.setVisibility(8);
            return;
        }
        FragmentTabHost.b g2 = this.f54836b.g(8);
        if (g2 != null) {
            if (this.p && ((popupWindow = this.o) == null || !popupWindow.isShowing())) {
                T(str, g2);
                return;
            }
            if (this.D == null) {
                this.D = new n(str);
            }
            TbadkCoreApplication.getInst().handler.removeCallbacks(this.D);
            TbadkCoreApplication.getInst().handler.postDelayed(this.D, 5000L);
            return;
        }
        this.i.setVisibility(8);
    }

    public final void T(String str, FragmentTabHost.b bVar) {
        int[] iArr = new int[2];
        bVar.f13311b.getLocationInWindow(iArr);
        int width = iArr[0] + (bVar.f13311b.getWidth() / 2);
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.i.getLayoutParams();
        layoutParams.rightMargin = (d.b.b.e.p.l.q(this.f54835a).widthPixels - width) - d.b.b.e.p.l.g(this.f54835a.getPageContext().getPageActivity(), R.dimen.ds26);
        this.i.setLayoutParams(layoutParams);
        this.i.setVisibility(0);
        this.i.setText(str);
    }

    public void U(String str) {
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f54835a.getActivity());
        aVar.setMessage(str);
        aVar.setPositiveButton(R.string.close, new h(this));
        aVar.setNegativeButton(R.string.check, new i(this));
        aVar.create(this.f54835a.getPageContext()).show();
    }

    public void V(boolean z) {
        ImageView imageView = this.f54840f;
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
                if (this.f54841g.getVisibility() != 0) {
                    this.f54841g.setVisibility(0);
                    P(true);
                    SkinManager.setImageResource(this.f54841g, R.drawable.icon_news_down_bar_one);
                    return;
                }
                return;
            }
            P(false);
            this.f54841g.setVisibility(8);
        }
    }

    public void X(PayMemberInfoData payMemberInfoData, int i2) {
        if (payMemberInfoData == null) {
            return;
        }
        View inflate = LayoutInflater.from(this.f54835a.getPageContext().getPageActivity()).inflate(R.layout.show_member_died_line_layout, (ViewGroup) null);
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
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f54835a.getPageContext().getPageActivity());
        aVar.setContentView(inflate);
        aVar.setButtonTextColor(R.color.CAM_X0305);
        aVar.setNegativeButton(R.string.know, new o(aVar, i2));
        String string = this.f54835a.getPageContext().getString(R.string.member_continue_pay);
        if (i2 == 0) {
            string = this.f54835a.getPageContext().getString(R.string.open_member);
        }
        aVar.setPositiveButton(string, new p(aVar, i2));
        aVar.setCanceledOnTouchOutside(false);
        aVar.create(this.f54835a.getPageContext()).show();
        d.b.h0.r.d0.b.i().s("show_member_deid_line", false);
    }

    public void Y(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.mFrom != 1) {
            return;
        }
        if (this.s == null) {
            MainTabActivity mainTabActivity = this.f54835a;
            this.s = new d.b.i0.p3.e(mainTabActivity, mainTabActivity.getActivityRootView());
        }
        this.s.g(postWriteCallBackData);
    }

    public void Z(boolean z) {
        if (z) {
            this.f54839e.setVisibility(0);
            this.f54842h.setVisibility(8);
            return;
        }
        this.f54839e.setVisibility(8);
        this.f54842h.setVisibility(0);
    }

    public void a0(PostWriteCallBackData postWriteCallBackData) {
        if (this.r == null) {
            this.r = new d.b.i0.b0.h(this.f54835a.getPageContext(), (NavigationBarCoverTip) this.f54835a.findViewById(R.id.navigation_cover_tip));
        }
        this.r.m(postWriteCallBackData);
    }

    public void b0(boolean z) {
        NavigationBar navigationBar = this.f54837c;
        if (navigationBar != null) {
            navigationBar.switchNaviBarStatus(z);
        }
    }

    public void w(boolean z) {
        this.n = z;
        if (z) {
            return;
        }
        d.b.h0.r.d0.b.i().s("enter_forum_edit_mode", false);
    }

    public boolean x(PostWriteCallBackData postWriteCallBackData) {
        if (postWriteCallBackData == null || postWriteCallBackData.getVideoEasterEggData() == null || d.b.b.e.p.k.isEmpty(postWriteCallBackData.getVideoEasterEggData().getVideoUrl())) {
            return false;
        }
        if (d.b.h0.r.d0.b.i().g(d.b.h0.r.d0.b.m(postWriteCallBackData.getVideoEasterEggData().getActivityID()), true)) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VideoEasterEggActivityConfig(this.f54835a).createNormalConfig("from_maintab", postWriteCallBackData.getVideoEasterEggData())));
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
        bVar2.f13312c = cVar.f50154a;
        bVar2.f13310a = cVar.f50158e;
        maintabBottomIndicator.setShowIconType(cVar.f50161h);
        int i2 = cVar.f50161h;
        if (i2 == d.b.h0.e0.c.i) {
            maintabBottomIndicator.setWriteIconView();
            z = true;
        } else if (i2 == d.b.h0.e0.c.l) {
            maintabBottomIndicator.setText(cVar.f50155b);
            maintabBottomIndicator.setAnimationResId(cVar.f50159f);
            this.t = maintabBottomIndicator;
        } else {
            maintabBottomIndicator.setText(cVar.f50155b);
            maintabBottomIndicator.setAnimationResId(cVar.f50159f);
        }
        if (!d.b.b.e.p.k.isEmpty(cVar.f50160g)) {
            maintabBottomIndicator.setImageIconUrl(cVar.f50160g, cVar.f50156c);
        }
        if (bVar2.f13310a == 2) {
            this.u = maintabBottomIndicator;
        }
        tbFragmentTabIndicator.e(TbadkCoreApplication.getInst().getSkinType());
        tbFragmentTabIndicator.setTipPosType(1);
        bVar2.f13311b = maintabBottomIndicator;
        bVar2.f13313d = bVar;
        this.f54836b.c(bVar2, -1, z);
    }

    public void z() {
        this.q.removeCallbacks(this.E);
        this.q.removeCallbacks(this.F);
        d.b.b.e.m.g.c(this.o);
    }
}
