package d.a.o0.a2.e;

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
/* loaded from: classes5.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f54975a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f54976b;

    /* renamed from: d  reason: collision with root package name */
    public d f54978d;

    /* renamed from: e  reason: collision with root package name */
    public c f54979e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.a.o0.a2.c.b> f54980f;

    /* renamed from: c  reason: collision with root package name */
    public Gson f54977c = new Gson();

    /* renamed from: g  reason: collision with root package name */
    public d.a.c.c.g.a f54981g = new a(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f54982h = new C1241b(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);

    /* loaded from: classes5.dex */
    public class a extends d.a.c.c.g.a {
        public a(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == b.this.f54976b) {
                d.a.o0.a2.c.c cVar = null;
                if (responsedMessage instanceof InterestedForumHttpResMsg) {
                    cVar = ((InterestedForumHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof InterestedForumSocketResMsg) {
                    cVar = ((InterestedForumSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() != 0) {
                    if (b.this.f54978d != null) {
                        b.this.f54978d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                } else if (cVar == null || ListUtils.isEmpty(cVar.f54970a)) {
                    if (b.this.f54978d != null) {
                        b.this.f54978d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    }
                } else if (cVar == null || b.this.f54978d == null) {
                } else {
                    b.c(b.this);
                    b.this.f54978d.b(cVar);
                }
            }
        }
    }

    /* renamed from: d.a.o0.a2.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes5.dex */
    public class C1241b extends HttpMessageListener {
        public C1241b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            if ((httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == b.this.f54976b) && (httpResponsedMessage instanceof InterestCommitHttpResMsg)) {
                InterestCommitHttpResMsg interestCommitHttpResMsg = (InterestCommitHttpResMsg) httpResponsedMessage;
                if (interestCommitHttpResMsg.hasError() || interestCommitHttpResMsg.getErrno() != 0) {
                    if (b.this.f54978d != null) {
                        b.this.f54978d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                } else if (b.this.f54979e != null) {
                    b.this.f54979e.a();
                }
            }
        }
    }

    /* loaded from: classes5.dex */
    public interface c {
        void a();
    }

    /* loaded from: classes5.dex */
    public interface d {
        void b(d.a.o0.a2.c.c cVar);

        void onError(int i2, String str);
    }

    public b(BdUniqueId bdUniqueId) {
        this.f54976b = bdUniqueId;
        this.f54981g.setTag(bdUniqueId);
        this.f54982h.setTag(this.f54976b);
        MessageManager.getInstance().registerListener(this.f54981g);
        MessageManager.getInstance().registerListener(this.f54982h);
        m();
        l();
    }

    public static /* synthetic */ int c(b bVar) {
        int i2 = bVar.f54975a;
        bVar.f54975a = i2 + 1;
        return i2;
    }

    public static void n() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT, TbConfig.SERVER_ADDRESS + TbConfig.GUIDE_INTEREST_COMMIT_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(InterestCommitHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void e() {
        String str;
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        try {
            str = URLEncoder.encode(g(), "utf-8");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            str = null;
        }
        httpMessage.addParam("interestList", str);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.setTag(this.f54976b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public void f(List<d.a.o0.a2.c.a> list) throws UnsupportedEncodingException {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        String encode = URLEncoder.encode(i(list), "utf-8");
        if (d.a.n0.b.d.l() && !TbadkCoreApplication.isLogin()) {
            d.a.n0.r.d0.b.j().x("user_interest_info", encode);
        }
        httpMessage.addParam("interestList", encode);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.setTag(this.f54976b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final String g() {
        HashMap hashMap = new HashMap();
        if (!ListUtils.isEmpty(this.f54980f)) {
            for (d.a.o0.a2.c.b bVar : this.f54980f) {
                if (bVar != null) {
                    hashMap.put(bVar.c(), new HashMap());
                }
            }
        }
        return this.f54977c.toJson(hashMap);
    }

    public final List<Integer> h(List<d.a.o0.a2.c.b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (d.a.o0.a2.c.b bVar : list) {
                arrayList.add(Integer.valueOf(bVar.b()));
            }
        }
        return arrayList;
    }

    public final String i(List<d.a.o0.a2.c.a> list) {
        HashMap hashMap = new HashMap();
        for (d.a.o0.a2.c.a aVar : list) {
            HashMap hashMap2 = new HashMap();
            for (d.a.o0.a2.c.d dVar : aVar.f54962a) {
                if (dVar.f54972b) {
                    RecommendForumInfo recommendForumInfo = dVar.f54971a;
                    hashMap2.put(recommendForumInfo.forum_id, recommendForumInfo.forum_name);
                }
            }
            hashMap.put(aVar.f54964c, hashMap2);
        }
        if (!ListUtils.isEmpty(this.f54980f)) {
            for (d.a.o0.a2.c.b bVar : this.f54980f) {
                if (bVar != null && !hashMap.containsKey(bVar.c())) {
                    hashMap.put(bVar.c(), new HashMap());
                }
            }
        }
        return this.f54977c.toJson(hashMap);
    }

    public void j() {
        InterestedForumReqMsg interestedForumReqMsg = new InterestedForumReqMsg();
        List<d.a.o0.a2.c.b> list = this.f54980f;
        if (list == null) {
            interestedForumReqMsg.classidList = h(null);
        } else {
            interestedForumReqMsg.classidList = h(list.subList((this.f54975a - 1) * 3, Math.min(list.size(), this.f54975a * 3)));
        }
        interestedForumReqMsg.setTag(this.f54976b);
        MessageManager.getInstance().sendMessage(interestedForumReqMsg);
    }

    public boolean k() {
        return (this.f54975a - 1) * 3 < this.f54980f.size();
    }

    public final void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, d.a.o0.e3.d0.a.a(TbConfig.GUIDE_INTERESTED_FORUM_URL, 309654));
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(InterestedForumHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public final void m() {
        d.a.n0.v0.b bVar = new d.a.n0.v0.b(309654);
        bVar.setResponsedClass(InterestedForumSocketResMsg.class);
        bVar.g(true);
        bVar.setPriority(4);
        MessageManager.getInstance().registerTask(bVar);
    }

    public void o(List<d.a.o0.a2.c.b> list) {
        this.f54980f = list;
        this.f54975a = 1;
    }

    public void p(c cVar) {
        this.f54979e = cVar;
    }

    public void q(d dVar) {
        this.f54978d = dVar;
    }
}
