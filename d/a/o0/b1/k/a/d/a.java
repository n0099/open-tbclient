package d.a.o0.b1.k.a.d;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.TbImageHelper;
import com.baidu.tieba.homepage.GetMyPostHttpResponseMessage;
import com.baidu.tieba.homepage.GetMyPostSocketResponseMessage;
import com.baidu.tieba.homepage.RequestGetMyPostNetMessage;
import com.baidu.tieba.homepage.topic.topicdetail.view.TopicDetailView;
import d.a.c.e.p.l;
import d.a.n0.r.q.a2;
import d.a.o0.z.e0.k;
import java.util.Date;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f55778a;

    /* renamed from: b  reason: collision with root package name */
    public TopicDetailView f55779b;

    /* renamed from: c  reason: collision with root package name */
    public final d.a.c.c.g.a f55780c = new C1272a(CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* renamed from: d.a.o0.b1.k.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1272a extends d.a.c.c.g.a {
        public C1272a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage instanceof GetMyPostHttpResponseMessage) {
                GetMyPostHttpResponseMessage getMyPostHttpResponseMessage = (GetMyPostHttpResponseMessage) responsedMessage;
                a.this.d(getMyPostHttpResponseMessage.getError(), getMyPostHttpResponseMessage.getResponseData());
            } else if (responsedMessage instanceof GetMyPostSocketResponseMessage) {
                GetMyPostSocketResponseMessage getMyPostSocketResponseMessage = (GetMyPostSocketResponseMessage) responsedMessage;
                a.this.d(getMyPostSocketResponseMessage.getError(), getMyPostSocketResponseMessage.getResponseData());
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public long f55782e;

        /* renamed from: f  reason: collision with root package name */
        public long f55783f;

        public b(long j, long j2) {
            this.f55782e = j;
            this.f55783f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int k = l.k(TbadkCoreApplication.getInst());
            int i2 = l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i3 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(a.this.f55778a);
            requestGetMyPostNetMessage.setParams(this.f55782e, this.f55783f, 0L, k, i2, f2, i3);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public a(TopicDetailView topicDetailView) {
        this.f55779b = topicDetailView;
    }

    public b c(long j, long j2) {
        return new b(j2, j);
    }

    public final void d(int i2, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        ThreadInfo threadInfo;
        if (i2 != 0 || getMyPostResIdl == null || (dataRes = getMyPostResIdl.data) == null || (threadInfo = dataRes.thread_info) == null) {
            return;
        }
        ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
        User.Builder builder2 = new User.Builder(builder.author);
        e(builder2, getMyPostResIdl.data.user_info);
        builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
        builder.author = builder2.build(true);
        ThreadInfo build = builder.build(true);
        a2 a2Var = new a2();
        a2Var.V2(build);
        a2Var.y4(new Date().getTime());
        if (k.i0(a2Var)) {
            this.f55779b.y(a2Var);
        }
    }

    public final void e(User.Builder builder, User_Info user_Info) {
        if (user_Info == null) {
            return;
        }
        builder.id = user_Info.id;
        builder.gender = user_Info.gender;
        builder.type = user_Info.type;
        builder.name = user_Info.name;
        builder.name_show = user_Info.name_show;
        builder.portrait = user_Info.portrait;
        builder.god_data = user_Info.god_data;
        builder.fans_num = user_Info.fans_num;
    }

    public void f(BdUniqueId bdUniqueId) {
        this.f55778a = bdUniqueId;
        this.f55780c.setTag(bdUniqueId);
        this.f55780c.getHttpMessageListener().setSelfListener(true);
        this.f55780c.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f55780c);
    }
}
