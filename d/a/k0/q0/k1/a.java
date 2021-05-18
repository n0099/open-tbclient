package d.a.k0.q0.k1;

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
import d.a.j0.r.s.a;
import d.a.k0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f58656a;

    /* renamed from: b  reason: collision with root package name */
    public int f58657b;

    /* renamed from: c  reason: collision with root package name */
    public String f58658c;

    /* renamed from: d  reason: collision with root package name */
    public String f58659d;

    /* renamed from: e  reason: collision with root package name */
    public String f58660e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f58661f = new c(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);

    /* renamed from: d.a.k0.q0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1489a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f58662e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f58663f;

        /* renamed from: d.a.k0.q0.k1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1490a implements View.OnClickListener {
            public View$OnClickListenerC1490a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", a.this.f58658c);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.f58656a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }

        public C1489a(d.a.j0.r.s.a aVar, int i2) {
            this.f58662e = aVar;
            this.f58663f = i2;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            d.a.j0.r.d0.b.j().t("key_forum_broadcast_no_tip_again", this.f58662e.isNoTipAgainChecked());
            this.f58662e.dismiss();
            if (this.f58663f == 0) {
                ScreenTopToast screenTopToast = new ScreenTopToast(a.this.f58656a.getPageActivity());
                screenTopToast.m(a.this.f58656a.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(a.this.f58656a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new View$OnClickListenerC1490a());
                screenTopToast.n((ViewGroup) a.this.f58656a.getPageActivity().findViewById(R.id.frs));
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f58656a.getPageActivity());
            if (a.this.f58657b == 1) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f58658c, a.this.f58659d, "3");
            } else if (a.this.f58657b == 2) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f58658c, a.this.f58659d, "4");
            } else {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f58658c, a.this.f58659d, "0");
            }
            forumBroadcastHelper.clipCopy(a.this.f58660e);
            forumBroadcastHelper.start();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.j0.r.s.a f58666e;

        public b(a aVar, d.a.j0.r.s.a aVar2) {
            this.f58666e = aVar2;
        }

        @Override // d.a.j0.r.s.a.e
        public void onClick(d.a.j0.r.s.a aVar) {
            d.a.j0.r.d0.b.j().t("key_call_fans_no_tip_again", false);
            this.f58666e.dismiss();
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
                boolean g2 = d.a.j0.r.d0.b.j().g("key_forum_broadcast_no_tip_again", false);
                int i2 = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    a.this.j(i2);
                } else if (a.this.f58657b == 1) {
                    a.this.f58656a.showToast(R.string.top_success);
                } else if (a.this.f58657b == 2) {
                    a.this.f58656a.showToast(R.string.set_good_success);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f58656a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f58661f);
    }

    public void g(int i2, String str, String str2, String str3) {
        this.f58657b = i2;
        this.f58658c = str;
        this.f58659d = str2;
        this.f58660e = str3;
        h(str);
    }

    public final void h(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("forum_id", str);
        this.f58656a.sendMessage(httpMessage);
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
        d.a.j0.r.s.a aVar = new d.a.j0.r.s.a(this.f58656a.getPageActivity());
        aVar.setUseNoTipAgainStyle(true);
        aVar.setNegativeTextColor(R.color.CAM_X0105);
        int i3 = this.f58657b;
        if (i3 == 1) {
            aVar.setTitle(R.string.top_success);
        } else if (i3 == 2) {
            aVar.setTitle(R.string.set_good_success);
        }
        aVar.setMessage(String.format(this.f58656a.getString(R.string.forum_broadcast_intro), Integer.valueOf(i2)));
        aVar.setContentViewSize(1);
        aVar.setPositiveButton(this.f58656a.getString(R.string.send_forum_broadcast), new C1489a(aVar, i2));
        aVar.setNegativeButton(this.f58656a.getString(R.string.next_time), new b(this, aVar));
        aVar.create(this.f58656a).show();
    }
}
