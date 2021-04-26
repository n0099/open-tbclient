package d.a.j0.a1.g;

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
    public ScrollFragmentTabHost f50771a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f50772b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f50773c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f50774d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f50775e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f50776f = new RunnableC1113a();

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f50777g = new b(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f50778h = new c(2921064);

    /* renamed from: d.a.j0.a1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1113a implements Runnable {
        public RunnableC1113a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f50772b != null) {
                if (a.this.f50773c != null) {
                    a.this.f50772b.removeView(a.this.f50773c);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
                }
                a.this.f50772b.setIsUnreadTipShow(false);
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
            if (a.this.f50773c == null || a.this.f50773c.f17245e == null) {
                return;
            }
            if (view.getId() != a.this.f50773c.f17245e.getId()) {
                if (a.this.f50771a != null) {
                    a.this.f50771a.setCurrentTab(0);
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
        this.f50774d = tbPageContext;
        tbPageContext.registerListener(this.f50777g);
        tbPageContext.registerListener(this.f50778h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, d.a.j0.d3.d0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        d.a.i0.v0.b bVar = new d.a.i0.v0.b(309541);
        bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void e(d.a.j0.a1.g.j.e eVar) {
        if (eVar == null || !eVar.a()) {
            return;
        }
        k(eVar);
    }

    public void f(boolean z) {
        d.a.c.e.m.e.a().removeCallbacks(this.f50776f);
        PersonalizePageView personalizePageView = this.f50772b;
        if (personalizePageView != null) {
            ConcernUnreadTipView concernUnreadTipView = this.f50773c;
            if (concernUnreadTipView != null) {
                personalizePageView.removeView(concernUnreadTipView);
                if (z && this.f50772b.getIsUnreadTipShow()) {
                    d.a.i0.r.d0.b.j().w(d.a.i0.r.d0.b.n("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                }
            }
            this.f50772b.setIsUnreadTipShow(false);
        }
    }

    public void g() {
        this.f50772b = null;
        this.f50771a = null;
        if (this.f50776f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f50776f);
        }
        MessageManager.getInstance().unRegisterListener(this.f50777g);
        MessageManager.getInstance().unRegisterListener(this.f50778h);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.f50775e = bdUniqueId;
    }

    public void i(PersonalizePageView personalizePageView) {
        this.f50772b = personalizePageView;
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.f50771a = scrollFragmentTabHost;
    }

    public void k(d.a.j0.a1.g.j.e eVar) {
        if (this.f50772b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f50774d.getContext());
        this.f50773c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f50775e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f50773c.setLayoutParams(layoutParams);
        this.f50773c.setData(eVar);
        this.f50773c.setClickListener(new d());
        this.f50772b.setIsUnreadTipShow(true);
        this.f50772b.addView(this.f50773c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.f50940a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f50944e));
        }
        d.a.c.e.m.e.a().postDelayed(this.f50776f, 5000L);
    }
}
