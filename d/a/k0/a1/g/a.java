package d.a.k0.a1.g;

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
    public ScrollFragmentTabHost f51468a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f51469b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f51470c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f51471d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f51472e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f51473f = new RunnableC1185a();

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f51474g = new b(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f51475h = new c(2921064);

    /* renamed from: d.a.k0.a1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1185a implements Runnable {
        public RunnableC1185a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f51469b != null) {
                if (a.this.f51470c != null) {
                    a.this.f51469b.removeView(a.this.f51470c);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
                }
                a.this.f51469b.setIsUnreadTipShow(false);
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
            if (a.this.f51470c == null || a.this.f51470c.f16560e == null) {
                return;
            }
            if (view.getId() != a.this.f51470c.f16560e.getId()) {
                if (a.this.f51468a != null) {
                    a.this.f51468a.setCurrentTab(0);
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
        this.f51471d = tbPageContext;
        tbPageContext.registerListener(this.f51474g);
        tbPageContext.registerListener(this.f51475h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, d.a.k0.d3.d0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        d.a.j0.v0.b bVar = new d.a.j0.v0.b(309541);
        bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void e(d.a.k0.a1.g.j.e eVar) {
        if (eVar == null || !eVar.a()) {
            return;
        }
        k(eVar);
    }

    public void f(boolean z) {
        d.a.c.e.m.e.a().removeCallbacks(this.f51473f);
        PersonalizePageView personalizePageView = this.f51469b;
        if (personalizePageView != null) {
            ConcernUnreadTipView concernUnreadTipView = this.f51470c;
            if (concernUnreadTipView != null) {
                personalizePageView.removeView(concernUnreadTipView);
                if (z && this.f51469b.getIsUnreadTipShow()) {
                    d.a.j0.r.d0.b.j().w(d.a.j0.r.d0.b.n("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                }
            }
            this.f51469b.setIsUnreadTipShow(false);
        }
    }

    public void g() {
        this.f51469b = null;
        this.f51468a = null;
        if (this.f51473f != null) {
            d.a.c.e.m.e.a().removeCallbacks(this.f51473f);
        }
        MessageManager.getInstance().unRegisterListener(this.f51474g);
        MessageManager.getInstance().unRegisterListener(this.f51475h);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.f51472e = bdUniqueId;
    }

    public void i(PersonalizePageView personalizePageView) {
        this.f51469b = personalizePageView;
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.f51468a = scrollFragmentTabHost;
    }

    public void k(d.a.k0.a1.g.j.e eVar) {
        if (this.f51469b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f51471d.getContext());
        this.f51470c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f51472e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f51470c.setLayoutParams(layoutParams);
        this.f51470c.setData(eVar);
        this.f51470c.setClickListener(new d());
        this.f51469b.setIsUnreadTipShow(true);
        this.f51469b.addView(this.f51470c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.f51639a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f51643e));
        }
        d.a.c.e.m.e.a().postDelayed(this.f51473f, 5000L);
    }
}
