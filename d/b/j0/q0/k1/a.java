package d.b.j0.q0.k1;

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
import d.b.i0.r.s.a;
import d.b.j0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f59843a;

    /* renamed from: b  reason: collision with root package name */
    public int f59844b;

    /* renamed from: c  reason: collision with root package name */
    public String f59845c;

    /* renamed from: d  reason: collision with root package name */
    public String f59846d;

    /* renamed from: e  reason: collision with root package name */
    public String f59847e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f59848f = new c(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);

    /* renamed from: d.b.j0.q0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1476a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f59849e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f59850f;

        /* renamed from: d.b.j0.q0.k1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1477a implements View.OnClickListener {
            public View$OnClickListenerC1477a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", a.this.f59845c);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.f59843a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }

        public C1476a(d.b.i0.r.s.a aVar, int i) {
            this.f59849e = aVar;
            this.f59850f = i;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            d.b.i0.r.d0.b.j().t("key_forum_broadcast_no_tip_again", this.f59849e.isNoTipAgainChecked());
            this.f59849e.dismiss();
            if (this.f59850f == 0) {
                ScreenTopToast screenTopToast = new ScreenTopToast(a.this.f59843a.getPageActivity());
                screenTopToast.m(a.this.f59843a.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(a.this.f59843a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new View$OnClickListenerC1477a());
                screenTopToast.n((ViewGroup) a.this.f59843a.getPageActivity().findViewById(R.id.frs));
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f59843a.getPageActivity());
            if (a.this.f59844b == 1) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f59845c, a.this.f59846d, "3");
            } else if (a.this.f59844b == 2) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f59845c, a.this.f59846d, "4");
            } else {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f59845c, a.this.f59846d, "0");
            }
            forumBroadcastHelper.clipCopy(a.this.f59847e);
            forumBroadcastHelper.start();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.i0.r.s.a f59853e;

        public b(a aVar, d.b.i0.r.s.a aVar2) {
            this.f59853e = aVar2;
        }

        @Override // d.b.i0.r.s.a.e
        public void onClick(d.b.i0.r.s.a aVar) {
            d.b.i0.r.d0.b.j().t("key_call_fans_no_tip_again", false);
            this.f59853e.dismiss();
        }
    }

    /* loaded from: classes4.dex */
    public class c extends HttpMessageListener {
        public c(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof ForumManagerRightsResMsg) {
                ForumManagerRightsResMsg forumManagerRightsResMsg = (ForumManagerRightsResMsg) httpResponsedMessage;
                boolean g2 = d.b.i0.r.d0.b.j().g("key_forum_broadcast_no_tip_again", false);
                int i = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    a.this.j(i);
                } else if (a.this.f59844b == 1) {
                    a.this.f59843a.showToast(R.string.top_success);
                } else if (a.this.f59844b == 2) {
                    a.this.f59843a.showToast(R.string.set_good_success);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f59843a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f59848f);
    }

    public void g(int i, String str, String str2, String str3) {
        this.f59844b = i;
        this.f59845c = str;
        this.f59846d = str2;
        this.f59847e = str3;
        h(str);
    }

    public final void h(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("forum_id", str);
        this.f59843a.sendMessage(httpMessage);
    }

    public final void i() {
        MessageManager messageManager = MessageManager.getInstance();
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS, TbConfig.SERVER_ADDRESS + "c/f/forum/getForumMangerRights");
        tbHttpMessageTask.setResponsedClass(ForumManagerRightsResMsg.class);
        tbHttpMessageTask.setIsNeedTbs(true);
        tbHttpMessageTask.setIsNeedAddCommenParam(true);
        messageManager.registerTask(tbHttpMessageTask);
    }

    public final void j(int i) {
        d.b.i0.r.s.a aVar = new d.b.i0.r.s.a(this.f59843a.getPageActivity());
        aVar.setUseNoTipAgainStyle(true);
        aVar.setNegativeTextColor(R.color.CAM_X0105);
        int i2 = this.f59844b;
        if (i2 == 1) {
            aVar.setTitle(R.string.top_success);
        } else if (i2 == 2) {
            aVar.setTitle(R.string.set_good_success);
        }
        aVar.setMessage(String.format(this.f59843a.getString(R.string.forum_broadcast_intro), Integer.valueOf(i)));
        aVar.setContentViewSize(1);
        aVar.setPositiveButton(this.f59843a.getString(R.string.send_forum_broadcast), new C1476a(aVar, i));
        aVar.setNegativeButton(this.f59843a.getString(R.string.next_time), new b(this, aVar));
        aVar.create(this.f59843a).show();
    }
}
