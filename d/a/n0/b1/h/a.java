package d.a.n0.b1.h;

import android.view.View;
import android.widget.FrameLayout;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.homepage.framework.indicator.ScrollFragmentTabHost;
import com.baidu.tieba.homepage.personalize.PersonalizePageView;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipHttpResMsg;
import com.baidu.tieba.homepage.personalize.data.ConcernUnreadTipSocketResMsg;
import com.baidu.tieba.homepage.personalize.view.ConcernUnreadTipView;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ScrollFragmentTabHost f55316a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f55317b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f55318c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f55319d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f55320e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f55321f = new RunnableC1258a();

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f55322g = new b(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f55323h = new c(2921064);

    /* renamed from: d.a.n0.b1.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1258a implements Runnable {
        public RunnableC1258a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f55317b != null) {
                if (a.this.f55318c != null) {
                    a.this.f55317b.removeView(a.this.f55318c);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
                }
                a.this.f55317b.setIsUnreadTipShow(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.a.c.c.g.a {
        public b(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.e(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.e(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            a.this.f(true);
        }
    }

    /* loaded from: classes4.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f55318c == null || a.this.f55318c.f16533e == null) {
                return;
            }
            if (view.getId() != a.this.f55318c.f16533e.getId()) {
                if (a.this.f55316a != null) {
                    a.this.f55316a.setCurrentTab(0);
                    return;
                }
                return;
            }
            a.this.f(false);
            TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 1));
        }
    }

    public a(TbPageContext tbPageContext) {
        if (tbPageContext == null) {
            return;
        }
        this.f55319d = tbPageContext;
        tbPageContext.registerListener(this.f55322g);
        tbPageContext.registerListener(this.f55323h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, d.a.n0.e3.d0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        d.a.m0.v0.b bVar = new d.a.m0.v0.b(309541);
        bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void e(d.a.n0.b1.h.j.e eVar) {
        if (eVar == null || !eVar.a()) {
            return;
        }
        k(eVar);
    }

    public void f(boolean z) {
        d.a.c.e.m.e.a().removeCallbacks(this.f55321f);
        PersonalizePageView personalizePageView = this.f55317b;
        if (personalizePageView != null) {
            ConcernUnreadTipView concernUnreadTipView = this.f55318c;
            if (concernUnreadTipView != null) {
                personalizePageView.removeView(concernUnreadTipView);
                if (z && this.f55317b.getIsUnreadTipShow()) {
                    d.a.m0.r.d0.b.j().w(d.a.m0.r.d0.b.n("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                }
            }
            this.f55317b.setIsUnreadTipShow(false);
        }
    }

    public void g() {
        this.f55317b = null;
        this.f55316a = null;
        if (this.f55321f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f55321f);
        }
        MessageManager.getInstance().unRegisterListener(this.f55322g);
        MessageManager.getInstance().unRegisterListener(this.f55323h);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.f55320e = bdUniqueId;
    }

    public void i(PersonalizePageView personalizePageView) {
        this.f55317b = personalizePageView;
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.f55316a = scrollFragmentTabHost;
    }

    public void k(d.a.n0.b1.h.j.e eVar) {
        if (this.f55317b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f55319d.getContext());
        this.f55318c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f55320e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f55318c.setLayoutParams(layoutParams);
        this.f55318c.setData(eVar);
        this.f55318c.setClickListener(new d());
        this.f55317b.setIsUnreadTipShow(true);
        this.f55317b.addView(this.f55318c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.f55489a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f55493e));
        }
        d.a.c.e.m.e.a().postDelayed(this.f55321f, 5000L);
    }
}
