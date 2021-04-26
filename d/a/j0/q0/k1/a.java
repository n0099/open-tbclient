package d.a.j0.q0.k1;

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
import d.a.i0.r.s.a;
import d.a.j0.d3.h0.m;
import java.util.HashMap;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f57914a;

    /* renamed from: b  reason: collision with root package name */
    public int f57915b;

    /* renamed from: c  reason: collision with root package name */
    public String f57916c;

    /* renamed from: d  reason: collision with root package name */
    public String f57917d;

    /* renamed from: e  reason: collision with root package name */
    public String f57918e;

    /* renamed from: f  reason: collision with root package name */
    public HttpMessageListener f57919f = new c(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);

    /* renamed from: d.a.j0.q0.k1.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1415a implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f57920e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f57921f;

        /* renamed from: d.a.j0.q0.k1.a$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class View$OnClickListenerC1416a implements View.OnClickListener {
            public View$OnClickListenerC1416a() {
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                HashMap hashMap = new HashMap();
                hashMap.put("_forumId", a.this.f57916c);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new m(a.this.f57914a.getPageActivity(), "ForumGradePage", hashMap)));
            }
        }

        public C1415a(d.a.i0.r.s.a aVar, int i2) {
            this.f57920e = aVar;
            this.f57921f = i2;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            d.a.i0.r.d0.b.j().t("key_forum_broadcast_no_tip_again", this.f57920e.isNoTipAgainChecked());
            this.f57920e.dismiss();
            if (this.f57921f == 0) {
                ScreenTopToast screenTopToast = new ScreenTopToast(a.this.f57914a.getPageActivity());
                screenTopToast.m(a.this.f57914a.getPageActivity().getString(R.string.frs_forum_bawu_send_broadcast_none_tip));
                screenTopToast.k(a.this.f57914a.getString(R.string.frs_recommend_fail_tip_btn));
                screenTopToast.j(new View$OnClickListenerC1416a());
                screenTopToast.n((ViewGroup) a.this.f57914a.getPageActivity().findViewById(R.id.frs));
                return;
            }
            ForumBroadcastHelper forumBroadcastHelper = new ForumBroadcastHelper(a.this.f57914a.getPageActivity());
            if (a.this.f57915b == 1) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f57916c, a.this.f57917d, "3");
            } else if (a.this.f57915b == 2) {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f57916c, a.this.f57917d, "4");
            } else {
                forumBroadcastHelper.jumpFlutterEditGenear(a.this.f57916c, a.this.f57917d, "0");
            }
            forumBroadcastHelper.clipCopy(a.this.f57918e);
            forumBroadcastHelper.start();
        }
    }

    /* loaded from: classes4.dex */
    public class b implements a.e {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ d.a.i0.r.s.a f57924e;

        public b(a aVar, d.a.i0.r.s.a aVar2) {
            this.f57924e = aVar2;
        }

        @Override // d.a.i0.r.s.a.e
        public void onClick(d.a.i0.r.s.a aVar) {
            d.a.i0.r.d0.b.j().t("key_call_fans_no_tip_again", false);
            this.f57924e.dismiss();
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
                boolean g2 = d.a.i0.r.d0.b.j().g("key_forum_broadcast_no_tip_again", false);
                int i2 = forumManagerRightsResMsg.broadcastTotalCount - forumManagerRightsResMsg.broadcastUsedCount;
                if (!g2) {
                    a.this.j(i2);
                } else if (a.this.f57915b == 1) {
                    a.this.f57914a.showToast(R.string.top_success);
                } else if (a.this.f57915b == 2) {
                    a.this.f57914a.showToast(R.string.set_good_success);
                }
            }
        }
    }

    public a(TbPageContext tbPageContext) {
        this.f57914a = tbPageContext;
        i();
        tbPageContext.registerListener(this.f57919f);
    }

    public void g(int i2, String str, String str2, String str3) {
        this.f57915b = i2;
        this.f57916c = str;
        this.f57917d = str2;
        this.f57918e = str3;
        h(str);
    }

    public final void h(String str) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GET_FORUM_MANAGER_RIGHTS);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.addParam("forum_id", str);
        this.f57914a.sendMessage(httpMessage);
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
        d.a.i0.r.s.a aVar = new d.a.i0.r.s.a(this.f57914a.getPageActivity());
        aVar.setUseNoTipAgainStyle(true);
        aVar.setNegativeTextColor(R.color.CAM_X0105);
        int i3 = this.f57915b;
        if (i3 == 1) {
            aVar.setTitle(R.string.top_success);
        } else if (i3 == 2) {
            aVar.setTitle(R.string.set_good_success);
        }
        aVar.setMessage(String.format(this.f57914a.getString(R.string.forum_broadcast_intro), Integer.valueOf(i2)));
        aVar.setContentViewSize(1);
        aVar.setPositiveButton(this.f57914a.getString(R.string.send_forum_broadcast), new C1415a(aVar, i2));
        aVar.setNegativeButton(this.f57914a.getString(R.string.next_time), new b(this, aVar));
        aVar.create(this.f57914a).show();
    }
}
