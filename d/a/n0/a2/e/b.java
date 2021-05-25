package d.a.n0.a2.e;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.task.TbHttpMessageTask;
import com.baidu.tieba.R;
import com.baidu.tieba.newinterest.data.InterestCommitHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumHttpResMsg;
import com.baidu.tieba.newinterest.data.InterestedForumReqMsg;
import com.baidu.tieba.newinterest.data.InterestedForumSocketResMsg;
import com.google.gson.Gson;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import tbclient.RecommendForumInfo;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f51173a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f51174b;

    /* renamed from: d  reason: collision with root package name */
    public d f51176d;

    /* renamed from: e  reason: collision with root package name */
    public c f51177e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.n0.a2.c.b> f51178f;

    /* renamed from: c  reason: collision with root package name */
    public Gson f51175c = new Gson();

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f51179g = new a(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f51180h = new C1181b(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);

    /* loaded from: classes4.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == b.this.f51174b) {
                d.a.n0.a2.c.c cVar = null;
                if (responsedMessage instanceof InterestedForumHttpResMsg) {
                    cVar = ((InterestedForumHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof InterestedForumSocketResMsg) {
                    cVar = ((InterestedForumSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() != 0) {
                    if (b.this.f51176d != null) {
                        b.this.f51176d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                } else if (cVar == null || ListUtils.isEmpty(cVar.f51168a)) {
                    if (b.this.f51176d != null) {
                        b.this.f51176d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    }
                } else if (cVar == null || b.this.f51176d == null) {
                } else {
                    b.c(b.this);
                    b.this.f51176d.b(cVar);
                }
            }
        }
    }

    /* renamed from: d.a.n0.a2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1181b extends HttpMessageListener {
        public C1181b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            if ((httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == b.this.f51174b) && (httpResponsedMessage instanceof InterestCommitHttpResMsg)) {
                InterestCommitHttpResMsg interestCommitHttpResMsg = (InterestCommitHttpResMsg) httpResponsedMessage;
                if (interestCommitHttpResMsg.hasError() || interestCommitHttpResMsg.getErrno() != 0) {
                    if (b.this.f51176d != null) {
                        b.this.f51176d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                } else if (b.this.f51177e != null) {
                    b.this.f51177e.a();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes4.dex */
    public interface d {
        void b(d.a.n0.a2.c.c cVar);

        void onError(int i2, String str);
    }

    public b(BdUniqueId bdUniqueId) {
        this.f51174b = bdUniqueId;
        this.f51179g.setTag(bdUniqueId);
        this.f51180h.setTag(this.f51174b);
        MessageManager.getInstance().registerListener(this.f51179g);
        MessageManager.getInstance().registerListener(this.f51180h);
        k();
        j();
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f51173a;
        bVar.f51173a = i2 + 1;
        return i2;
    }

    public static void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT, TbConfig.SERVER_ADDRESS + TbConfig.GUIDE_INTEREST_COMMIT_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(InterestCommitHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void e(List<d.a.n0.a2.c.a> list) throws UnsupportedEncodingException {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        String encode = URLEncoder.encode(g(list), "utf-8");
        if (d.a.m0.b.d.l() && !TbadkCoreApplication.isLogin()) {
            d.a.m0.r.d0.b.j().x("user_interest_info", encode);
        }
        httpMessage.addParam("interestList", encode);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.setTag(this.f51174b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final List<Integer> f(List<d.a.n0.a2.c.b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (d.a.n0.a2.c.b bVar : list) {
                arrayList.add(Integer.valueOf(bVar.b()));
            }
        }
        return arrayList;
    }

    public final String g(List<d.a.n0.a2.c.a> list) {
        HashMap hashMap = new HashMap();
        for (d.a.n0.a2.c.a aVar : list) {
            HashMap hashMap2 = new HashMap();
            for (d.a.n0.a2.c.d dVar : aVar.f51160a) {
                if (dVar.f51170b) {
                    RecommendForumInfo recommendForumInfo = dVar.f51169a;
                    hashMap2.put(recommendForumInfo.forum_id, recommendForumInfo.forum_name);
                }
            }
            hashMap.put(aVar.f51162c, hashMap2);
        }
        return this.f51175c.toJson(hashMap);
    }

    public void h() {
        InterestedForumReqMsg interestedForumReqMsg = new InterestedForumReqMsg();
        List<d.a.n0.a2.c.b> list = this.f51178f;
        if (list == null) {
            interestedForumReqMsg.classidList = f(null);
        } else {
            interestedForumReqMsg.classidList = f(list.subList((this.f51173a - 1) * 3, Math.min(list.size(), this.f51173a * 3)));
        }
        interestedForumReqMsg.setTag(this.f51174b);
        MessageManager.getInstance().sendMessage(interestedForumReqMsg);
    }

    public boolean i() {
        return (this.f51173a - 1) * 3 < this.f51178f.size();
    }

    public final void j() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, d.a.n0.e3.d0.a.a(TbConfig.GUIDE_INTERESTED_FORUM_URL, 309654));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(InterestedForumHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void k() {
        d.a.m0.v0.b bVar = new d.a.m0.v0.b(309654);
        bVar.setResponsedClass(InterestedForumSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void m(List<d.a.n0.a2.c.b> list) {
        this.f51178f = list;
        this.f51173a = 1;
    }

    public void n(c cVar) {
        this.f51177e = cVar;
    }

    public void o(d dVar) {
        this.f51176d = dVar;
    }
}
