package d.b.i0.z0.g;

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
/* loaded from: classes3.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public ScrollFragmentTabHost f63025a;

    /* renamed from: b  reason: collision with root package name */
    public PersonalizePageView f63026b;

    /* renamed from: c  reason: collision with root package name */
    public ConcernUnreadTipView f63027c;

    /* renamed from: d  reason: collision with root package name */
    public TbPageContext f63028d;

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f63029e;

    /* renamed from: f  reason: collision with root package name */
    public Runnable f63030f = new RunnableC1699a();

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f63031g = new b(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, 309541);

    /* renamed from: h  reason: collision with root package name */
    public CustomMessageListener f63032h = new c(2921064);

    /* renamed from: d.b.i0.z0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class RunnableC1699a implements Runnable {
        public RunnableC1699a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            if (a.this.f63026b != null) {
                if (a.this.f63027c != null) {
                    a.this.f63026b.removeView(a.this.f63027c);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 3));
                }
                a.this.f63026b.setIsUnreadTipShow(false);
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends d.b.b.c.g.a {
        public b(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof ConcernUnreadTipHttpResMsg) {
                a.this.e(((ConcernUnreadTipHttpResMsg) responsedMessage).mData);
            } else if (responsedMessage instanceof ConcernUnreadTipSocketResMsg) {
                a.this.e(((ConcernUnreadTipSocketResMsg) responsedMessage).mData);
            }
        }
    }

    /* loaded from: classes3.dex */
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

    /* loaded from: classes3.dex */
    public class d implements View.OnClickListener {
        public d() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (a.this.f63027c == null || a.this.f63027c.f17288e == null) {
                return;
            }
            if (view.getId() != a.this.f63027c.f17288e.getId()) {
                if (a.this.f63025a != null) {
                    a.this.f63025a.setCurrentTab(0);
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
        this.f63028d = tbPageContext;
        tbPageContext.registerListener(this.f63031g);
        tbPageContext.registerListener(this.f63032h);
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_CONCERN_UNREAD_TIP, d.b.i0.c3.d0.a.a(TbConfig.URL_CONCERN_UNREAD_TIP, 309541));
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        tbHttpMessageTask.setResponsedClass(ConcernUnreadTipHttpResMsg.class);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(309541);
        bVar.setResponsedClass(ConcernUnreadTipSocketResMsg.class);
        bVar.g(true);
        MessageManager.getInstance().registerTask(bVar);
    }

    public final void e(d.b.i0.z0.g.j.e eVar) {
        if (eVar == null || !eVar.a()) {
            return;
        }
        k(eVar);
    }

    public void f(boolean z) {
        d.b.b.e.m.e.a().removeCallbacks(this.f63030f);
        PersonalizePageView personalizePageView = this.f63026b;
        if (personalizePageView != null) {
            ConcernUnreadTipView concernUnreadTipView = this.f63027c;
            if (concernUnreadTipView != null) {
                personalizePageView.removeView(concernUnreadTipView);
                if (z && this.f63026b.getIsUnreadTipShow()) {
                    d.b.h0.r.d0.b.i().v(d.b.h0.r.d0.b.m("concern_unread_tip_next_show_time"), 0L);
                    TiebaStatic.log(new StatisticItem("c12632").param("obj_locate", 2));
                }
            }
            this.f63026b.setIsUnreadTipShow(false);
        }
    }

    public void g() {
        this.f63026b = null;
        this.f63025a = null;
        if (this.f63030f != null) {
            d.b.b.e.m.e.a().removeCallbacks(this.f63030f);
        }
        MessageManager.getInstance().unRegisterListener(this.f63031g);
        MessageManager.getInstance().unRegisterListener(this.f63032h);
    }

    public void h(BdUniqueId bdUniqueId) {
        this.f63029e = bdUniqueId;
    }

    public void i(PersonalizePageView personalizePageView) {
        this.f63026b = personalizePageView;
    }

    public void j(ScrollFragmentTabHost scrollFragmentTabHost) {
        this.f63025a = scrollFragmentTabHost;
    }

    public void k(d.b.i0.z0.g.j.e eVar) {
        if (this.f63026b == null) {
            return;
        }
        ConcernUnreadTipView concernUnreadTipView = new ConcernUnreadTipView(this.f63028d.getContext());
        this.f63027c = concernUnreadTipView;
        concernUnreadTipView.setBdUniqueId(this.f63029e);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 49;
        this.f63027c.setLayoutParams(layoutParams);
        this.f63027c.setData(eVar);
        this.f63027c.setClickListener(new d());
        this.f63026b.setIsUnreadTipShow(true);
        this.f63026b.addView(this.f63027c);
        if (eVar != null) {
            TiebaStatic.log(new StatisticItem("c12631").param("obj_param1", eVar.f63184a).param(TiebaStatic.Params.OBJ_PARAM2, eVar.f63188e));
        }
        d.b.b.e.m.e.a().postDelayed(this.f63030f, 5000L);
    }
}
