package d.b.i0.p0.k1;

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
import d.b.h0.r.s.a;
import d.b.i0.c3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57722a;

    /* renamed from: b  reason: collision with root package name */
    public int f57723b;

    /* renamed from: c  reason: collision with root package name */
    public String f57724c;

    /* renamed from: d  reason: collision with root package name */
    public String f57725d;

    /* renamed from: e  reason: collision with root package name */
    public String f57726e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f57727f = new c(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);

    /* renamed from: d.b.i0.p0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1390a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f57728e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57729f;

        /* renamed from: d.b.i0.p0.k1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1391a implements View.OnClickListener {
            public View$OnClickListenerC1391a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", a.this.f57724c);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.f57722a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }

        public C1390a(d.b.h0.r.s.a aVar, int i) {
            this.f57728e = aVar;
            this.f57729f = i;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.b.h0.r.d0.b.i().s("key_forum_broadcast_no_tip_again", this.f57728e.isNoTipAgainChecked());
            this.f57728e.dismiss();
            if (this.f57729f == 0) {
                ScreenTopToast screenTopToast = new ScreenTopToast(a.this.f57722a.getPageActivity());
                screenTopToast.m(a.this.f57722a.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(a.this.f57722a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new View$OnClickListenerC1391a());
                screenTopToast.n((ViewGroup) a.this.f57722a.getPageActivity().findViewById(R.id.frs));
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f57722a.getPageActivity());
            if (a.this.f57723b == 1) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f57724c, a.this.f57725d, "3");
            } else if (a.this.f57723b == 2) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f57724c, a.this.f57725d, "4");
            } else {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f57724c, a.this.f57725d, "0");
            }
            forumBroadcastHelper.clipCopy(a.this.f57726e);
            forumBroadcastHelper.start();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.b.h0.r.s.a f57732e;

        public b(a aVar, d.b.h0.r.s.a aVar2) {
            this.f57732e = aVar2;
        }

        @Override // d.b.h0.r.s.a.e
        public void onClick(d.b.h0.r.s.a aVar) {
            d.b.h0.r.d0.b.i().s("key_call_fans_no_tip_again", false);
            this.f57732e.dismiss();
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
                boolean g2 = d.b.h0.r.d0.b.i().g("key_forum_broadcast_no_tip_again", false);
                int i = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    a.this.j(i);
                } else if (a.this.f57723b == 1) {
                    a.this.f57722a.showToast(R.string.top_success);
                } else if (a.this.f57723b == 2) {
                    a.this.f57722a.showToast(R.string.set_good_success);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f57722a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f57727f);
    }

    public void g(int i, String str, String str2, String str3) {
        this.f57723b = i;
        this.f57724c = str;
        this.f57725d = str2;
        this.f57726e = str3;
        h(str);
    }

    public final void h(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("forum_id", str);
        this.f57722a.sendMessage(httpMessage);
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
        d.b.h0.r.s.a aVar = new d.b.h0.r.s.a(this.f57722a.getPageActivity());
        aVar.setUseNoTipAgainStyle(true);
        aVar.setNegativeTextColor(R.color.CAM_X0105);
        int i2 = this.f57723b;
        if (i2 == 1) {
            aVar.setTitle(R.string.top_success);
        } else if (i2 == 2) {
            aVar.setTitle(R.string.set_good_success);
        }
        aVar.setMessage(String.format(this.f57722a.getString(R.string.forum_broadcast_intro), Integer.valueOf(i)));
        aVar.setContentViewSize(1);
        aVar.setPositiveButton(this.f57722a.getString(R.string.send_forum_broadcast), new C1390a(aVar, i));
        aVar.setNegativeButton(this.f57722a.getString(R.string.next_time), new b(this, aVar));
        aVar.create(this.f57722a).show();
    }
}
