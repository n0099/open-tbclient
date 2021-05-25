package d.a.n0.r0.k1;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ForumBroadcastHelper;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.broadcast.ForumManagerRightsResMsg;
import com.baidu.tieba.view.ScreenTopToast;
import d.a.m0.r.s.a;
import d.a.n0.e3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58797a;

    /* renamed from: b  reason: collision with root package name */
    public int f58798b;

    /* renamed from: c  reason: collision with root package name */
    public String f58799c;

    /* renamed from: d  reason: collision with root package name */
    public String f58800d;

    /* renamed from: e  reason: collision with root package name */
    public String f58801e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f58802f = new c(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);

    /* renamed from: d.a.n0.r0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1502a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f58803e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58804f;

        /* renamed from: d.a.n0.r0.k1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1503a implements View.OnClickListener {
            public View$OnClickListenerC1503a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", a.this.f58799c);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.f58797a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }

        public C1502a(d.a.m0.r.s.a aVar, int i2) {
            this.f58803e = aVar;
            this.f58804f = i2;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            d.a.m0.r.d0.b.j().t("key_forum_broadcast_no_tip_again", this.f58803e.isNoTipAgainChecked());
            this.f58803e.dismiss();
            if (this.f58804f == 0) {
                ScreenTopToast screenTopToast = new ScreenTopToast(a.this.f58797a.getPageActivity());
                screenTopToast.m(a.this.f58797a.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(a.this.f58797a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new View$OnClickListenerC1503a());
                screenTopToast.n((ViewGroup) a.this.f58797a.getPageActivity().findViewById(R.id.frs));
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f58797a.getPageActivity());
            if (a.this.f58798b == 1) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f58799c, a.this.f58800d, "3");
            } else if (a.this.f58798b == 2) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f58799c, a.this.f58800d, "4");
            } else {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f58799c, a.this.f58800d, "0");
            }
            forumBroadcastHelper.clipCopy(a.this.f58801e);
            forumBroadcastHelper.start();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.m0.r.s.a f58807e;

        public b(a aVar, d.a.m0.r.s.a aVar2) {
            this.f58807e = aVar2;
        }

        @Override // d.a.m0.r.s.a.e
        public void onClick(d.a.m0.r.s.a aVar) {
            d.a.m0.r.d0.b.j().t("key_call_fans_no_tip_again", false);
            this.f58807e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ForumManagerRightsResMsg) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean g2 = d.a.m0.r.d0.b.j().g("key_forum_broadcast_no_tip_again", false);
                int i2 = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    a.this.j(i2);
                } else if (a.this.f58798b == 1) {
                    a.this.f58797a.showToast(R.string.top_success);
                } else if (a.this.f58798b == 2) {
                    a.this.f58797a.showToast(R.string.set_good_success);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f58797a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f58802f);
    }

    public void g(int i2, String str, String str2, String str3) {
        this.f58798b = i2;
        this.f58799c = str;
        this.f58800d = str2;
        this.f58801e = str3;
        h(str);
    }

    public final void h(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("forum_id", str);
        this.f58797a.sendMessage(httpMessage);
    }

    public final void i() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS, TbConfig.SERVER_ADDRESS + "c/f/forum/getForumMangerRights");
        tbHttpMessageTask.setResponsedClass(ForumManagerRightsResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public final void j(int i2) {
        d.a.m0.r.s.a aVar = new d.a.m0.r.s.a(this.f58797a.getPageActivity());
        aVar.setUseNoTipAgainStyle(true);
        aVar.setNegativeTextColor(R.color.CAM_X0105);
        int i3 = this.f58798b;
        if (i3 == 1) {
            aVar.setTitle(R.string.top_success);
        } else if (i3 == 2) {
            aVar.setTitle(R.string.set_good_success);
        }
        aVar.setMessage(String.format(this.f58797a.getString(R.string.forum_broadcast_intro), Integer.valueOf(i2)));
        aVar.setContentViewSize(1);
        aVar.setPositiveButton(this.f58797a.getString(R.string.send_forum_broadcast), new C1502a(aVar, i2));
        aVar.setNegativeButton(this.f58797a.getString(R.string.next_time), new b(this, aVar));
        aVar.create(this.f58797a).show();
    }
}
