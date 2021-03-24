package d.b.i0.z0.j.a.d;

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
import d.b.b.e.p.l;
import d.b.h0.r.q.a2;
import d.b.i0.x.e0.k;
import java.util.Date;
import tbclient.GetMyPost.DataRes;
import tbclient.GetMyPost.GetMyPostResIdl;
import tbclient.GetMyPost.User_Info;
import tbclient.ThreadInfo;
import tbclient.User;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public BdUniqueId f63333a;

    /* renamed from: b  reason: collision with root package name */
    public TopicDetailView f63334b;

    /* renamed from: c  reason: collision with root package name */
    public final d.b.b.c.g.a f63335c = new C1708a(CmdConfigHttp.CMD_GET_MY_POST, 303111);

    /* renamed from: d.b.i0.z0.j.a.d.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1708a extends d.b.b.c.g.a {
        public C1708a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
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
        public long f63337e;

        /* renamed from: f  reason: collision with root package name */
        public long f63338f;

        public b(long j, long j2) {
            this.f63337e = j;
            this.f63338f = j2;
        }

        @Override // java.lang.Runnable
        public void run() {
            int k = l.k(TbadkCoreApplication.getInst());
            int i = l.i(TbadkCoreApplication.getInst());
            float f2 = TbadkCoreApplication.getInst().getApp().getResources().getDisplayMetrics().density;
            int i2 = TbImageHelper.getInstance().isShowBigImage() ? 2 : 1;
            RequestGetMyPostNetMessage requestGetMyPostNetMessage = new RequestGetMyPostNetMessage();
            requestGetMyPostNetMessage.setTag(a.this.f63333a);
            requestGetMyPostNetMessage.setParams(this.f63337e, this.f63338f, 0L, k, i, f2, i2);
            MessageManager.getInstance().sendMessage(requestGetMyPostNetMessage);
        }
    }

    public a(TopicDetailView topicDetailView) {
        this.f63334b = topicDetailView;
    }

    public b c(long j, long j2) {
        return new b(j2, j);
    }

    public final void d(int i, GetMyPostResIdl getMyPostResIdl) {
        DataRes dataRes;
        ThreadInfo threadInfo;
        if (i != 0 || getMyPostResIdl == null || (dataRes = getMyPostResIdl.data) == null || (threadInfo = dataRes.thread_info) == null) {
            return;
        }
        ThreadInfo.Builder builder = new ThreadInfo.Builder(threadInfo);
        User.Builder builder2 = new User.Builder(builder.author);
        e(builder2, getMyPostResIdl.data.user_info);
        builder2.portrait = TbadkCoreApplication.getCurrentPortrait();
        builder.author = builder2.build(true);
        ThreadInfo build = builder.build(true);
        a2 a2Var = new a2();
        a2Var.Q2(build);
        a2Var.t4(new Date().getTime());
        if (k.i0(a2Var)) {
            this.f63334b.z(a2Var);
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
        this.f63333a = bdUniqueId;
        this.f63335c.setTag(bdUniqueId);
        this.f63335c.getHttpMessageListener().setSelfListener(true);
        this.f63335c.getSocketMessageListener().setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f63335c);
    }
}
