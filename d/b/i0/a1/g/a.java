package d.b.i0.a1.g;

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
    public ScrollFragmentTabHost f52644a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f52645b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f52646c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f52647d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f52648e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f52649f = new RunnableC1151a();

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f52650g = new b(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f52651h = new c(2921064);

    /* renamed from: d.b.i0.a1.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class RunnableC1151a implements Runnable {
        public RunnableC1151a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f52645b != null) {
                if (a.this.f52646c != null) {
                    a.this.f52645b.removeView(a.this.f52646c);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
                }
                a.this.f52645b.setIsUnreadTipShow(false);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends d.b.c.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
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
        public c(int i) {
            super(i);
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
            if (a.this.f52646c == null || a.this.f52646c.f16965e == null) {
                return;
            }
            if (view.getId() != a.this.f52646c.f16965e.getId()) {
                if (a.this.f52644a != null) {
                    a.this.f52644a.setCurrentTab(0);
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
        this.f52647d = tbPageContext;
        tbPageContext.registerListener(this.f52650g);
        tbPageContext.registerListener(this.f52651h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, d.b.i0.d3.d0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(309541);
        bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void e(d.b.i0.a1.g.j.e eVar) {
        if (eVar == null || !eVar.a()) {
            return;
        }
        k(eVar);
    }

    public void f(boolean z) {
        d.b.c.e.m.e.a().removeCallbacks(this.f52649f);
        PersonalizePageView personalizePageView = this.f52645b;
        if (personalizePageView != null) {
            ConcernUnreadTipView concernUnreadTipView = this.f52646c;
            if (concernUnreadTipView != null) {
                personalizePageView.removeView(concernUnreadTipView);
                if (z && this.f52645b.getIsUnreadTipShow()) {
                    d.b.h0.r.d0.b.j().w(d.b.h0.r.d0.b.n("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                }
            }
            this.f52645b.setIsUnreadTipShow(false);
        }
    }

    public void g() {
        this.f52645b = null;
        this.f52644a = null;
        if (this.f52649f != null) {
            d.b.c.e.m.e.a().removeCallbacks(this.f52649f);
        }
        MessageManager.getInstance().unRegisterListener(this.f52650g);
        MessageManager.getInstance().unRegisterListener(this.f52651h);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.f52648e = bdUniqueId;
    }

    public void i(PersonalizePageView personalizePageView) {
        this.f52645b = personalizePageView;
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.f52644a = scrollFragmentTabHost;
    }

    public void k(d.b.i0.a1.g.j.e eVar) {
        if (this.f52645b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f52647d.getContext());
        this.f52646c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f52648e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f52646c.setLayoutParams(layoutParams);
        this.f52646c.setData(eVar);
        this.f52646c.setClickListener(new d());
        this.f52645b.setIsUnreadTipShow(true);
        this.f52645b.addView(this.f52646c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.f52803a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f52807e));
        }
        d.b.c.e.m.e.a().postDelayed(this.f52649f, 5000L);
    }
}
