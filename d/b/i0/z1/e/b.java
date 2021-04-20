package d.b.i0.z1.e;

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
/* loaded from: classes3.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f64253a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f64254b;

    /* renamed from: d  reason: collision with root package name */
    public d f64256d;

    /* renamed from: e  reason: collision with root package name */
    public c f64257e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.z1.c.b> f64258f;

    /* renamed from: c  reason: collision with root package name */
    public Gson f64255c = new Gson();

    /* renamed from: g  reason: collision with root package name */
    public d.b.c.c.g.a f64259g = new a(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f64260h = new C1736b(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);

    /* loaded from: classes3.dex */
    public class a extends d.b.c.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == b.this.f64254b) {
                d.b.i0.z1.c.c cVar = null;
                if (responsedMessage instanceof InterestedForumHttpResMsg) {
                    cVar = ((InterestedForumHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof InterestedForumSocketResMsg) {
                    cVar = ((InterestedForumSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() != 0) {
                    if (b.this.f64256d != null) {
                        b.this.f64256d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                } else if (cVar == null || ListUtils.isEmpty(cVar.f64248a)) {
                    if (b.this.f64256d != null) {
                        b.this.f64256d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    }
                } else if (cVar == null || b.this.f64256d == null) {
                } else {
                    b.c(b.this);
                    b.this.f64256d.b(cVar);
                }
            }
        }
    }

    /* renamed from: d.b.i0.z1.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public class C1736b extends HttpMessageListener {
        public C1736b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            if ((httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == b.this.f64254b) && (httpResponsedMessage instanceof InterestCommitHttpResMsg)) {
                InterestCommitHttpResMsg interestCommitHttpResMsg = (InterestCommitHttpResMsg) httpResponsedMessage;
                if (interestCommitHttpResMsg.hasError() || interestCommitHttpResMsg.getErrno() != 0) {
                    if (b.this.f64256d != null) {
                        b.this.f64256d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                } else if (b.this.f64257e != null) {
                    b.this.f64257e.a();
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes3.dex */
    public interface d {
        void b(d.b.i0.z1.c.c cVar);

        void onError(int i, String str);
    }

    public b(BdUniqueId bdUniqueId) {
        this.f64254b = bdUniqueId;
        this.f64259g.setTag(bdUniqueId);
        this.f64260h.setTag(this.f64254b);
        MessageManager.getInstance().registerListener(this.f64259g);
        MessageManager.getInstance().registerListener(this.f64260h);
        k();
        j();
    }

    public static /* synthetic */ int c(b bVar) {
        int i = bVar.f64253a;
        bVar.f64253a = i + 1;
        return i;
    }

    public static void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT, TbConfig.SERVER_ADDRESS + TbConfig.GUIDE_INTEREST_COMMIT_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(InterestCommitHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void e(List<d.b.i0.z1.c.a> list) throws UnsupportedEncodingException {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        String encode = URLEncoder.encode(g(list), "utf-8");
        if (d.b.h0.b.d.l() && !TbadkCoreApplication.isLogin()) {
            d.b.h0.r.d0.b.j().x("user_interest_info", encode);
        }
        httpMessage.addParam("interestList", encode);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.setTag(this.f64254b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final List<Integer> f(List<d.b.i0.z1.c.b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (d.b.i0.z1.c.b bVar : list) {
                arrayList.add(Integer.valueOf(bVar.b()));
            }
        }
        return arrayList;
    }

    public final String g(List<d.b.i0.z1.c.a> list) {
        HashMap hashMap = new HashMap();
        for (d.b.i0.z1.c.a aVar : list) {
            HashMap hashMap2 = new HashMap();
            for (d.b.i0.z1.c.d dVar : aVar.f64240a) {
                if (dVar.f64250b) {
                    RecommendForumInfo recommendForumInfo = dVar.f64249a;
                    hashMap2.put(recommendForumInfo.forum_id, recommendForumInfo.forum_name);
                }
            }
            hashMap.put(aVar.f64242c, hashMap2);
        }
        return this.f64255c.toJson(hashMap);
    }

    public void h() {
        InterestedForumReqMsg interestedForumReqMsg = new InterestedForumReqMsg();
        List<d.b.i0.z1.c.b> list = this.f64258f;
        if (list == null) {
            interestedForumReqMsg.classidList = f(null);
        } else {
            interestedForumReqMsg.classidList = f(list.subList((this.f64253a - 1) * 3, Math.min(list.size(), this.f64253a * 3)));
        }
        interestedForumReqMsg.setTag(this.f64254b);
        MessageManager.getInstance().sendMessage(interestedForumReqMsg);
    }

    public boolean i() {
        return (this.f64253a - 1) * 3 < this.f64258f.size();
    }

    public final void j() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, d.b.i0.d3.d0.a.a(TbConfig.GUIDE_INTERESTED_FORUM_URL, 309654));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(InterestedForumHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void k() {
        d.b.h0.v0.b bVar = new d.b.h0.v0.b(309654);
        bVar.setResponsedClass(InterestedForumSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void m(List<d.b.i0.z1.c.b> list) {
        this.f64258f = list;
        this.f64253a = 1;
    }

    public void n(c cVar) {
        this.f64257e = cVar;
    }

    public void o(d dVar) {
        this.f64256d = dVar;
    }
}
