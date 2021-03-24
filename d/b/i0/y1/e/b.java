package d.b.i0.y1.e;

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
    public int f62591a;

    /* renamed from: b  reason: collision with root package name */
    public final BdUniqueId f62592b;

    /* renamed from: d  reason: collision with root package name */
    public d f62594d;

    /* renamed from: e  reason: collision with root package name */
    public c f62595e;

    /* renamed from: f  reason: collision with root package name */
    public List<d.b.i0.y1.c.b> f62596f;

    /* renamed from: c  reason: collision with root package name */
    public Gson f62593c = new Gson();

    /* renamed from: g  reason: collision with root package name */
    public d.b.b.c.g.a f62597g = new a(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, 309654);

    /* renamed from: h  reason: collision with root package name */
    public HttpMessageListener f62598h = new C1677b(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);

    /* loaded from: classes4.dex */
    public class a extends d.b.b.c.g.a {
        public a(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.b.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage.getOrginalMessage() == null || responsedMessage.getOrginalMessage().getTag() == b.this.f62592b) {
                d.b.i0.y1.c.c cVar = null;
                if (responsedMessage instanceof InterestedForumHttpResMsg) {
                    cVar = ((InterestedForumHttpResMsg) responsedMessage).getPageData();
                } else if (responsedMessage instanceof InterestedForumSocketResMsg) {
                    cVar = ((InterestedForumSocketResMsg) responsedMessage).getPageData();
                }
                if (responsedMessage.getError() != 0) {
                    if (b.this.f62594d != null) {
                        b.this.f62594d.onError(responsedMessage.getError(), responsedMessage.getErrorString());
                    }
                } else if (cVar == null || ListUtils.isEmpty(cVar.f62586a)) {
                    if (b.this.f62594d != null) {
                        b.this.f62594d.onError(-1, TbadkCoreApplication.getInst().getString(R.string.neterror));
                    }
                } else if (cVar == null || b.this.f62594d == null) {
                } else {
                    b.c(b.this);
                    b.this.f62594d.b(cVar);
                }
            }
        }
    }

    /* renamed from: d.b.i0.y1.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1677b extends HttpMessageListener {
        public C1677b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage == null) {
                return;
            }
            if ((httpResponsedMessage.getOrginalMessage() == null || httpResponsedMessage.getOrginalMessage().getTag() == b.this.f62592b) && (httpResponsedMessage instanceof InterestCommitHttpResMsg)) {
                InterestCommitHttpResMsg interestCommitHttpResMsg = (InterestCommitHttpResMsg) httpResponsedMessage;
                if (interestCommitHttpResMsg.hasError() || interestCommitHttpResMsg.getErrno() != 0) {
                    if (b.this.f62594d != null) {
                        b.this.f62594d.onError(httpResponsedMessage.getError(), httpResponsedMessage.getErrorString());
                    }
                } else if (b.this.f62595e != null) {
                    b.this.f62595e.a();
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
        void b(d.b.i0.y1.c.c cVar);

        void onError(int i, String str);
    }

    public b(BdUniqueId bdUniqueId) {
        this.f62592b = bdUniqueId;
        this.f62597g.setTag(bdUniqueId);
        this.f62598h.setTag(this.f62592b);
        MessageManager.getInstance().registerListener(this.f62597g);
        MessageManager.getInstance().registerListener(this.f62598h);
        k();
        j();
    }

    public static /* synthetic */ int c(b bVar) {
        int i = bVar.f62591a;
        bVar.f62591a = i + 1;
        return i;
    }

    public static void l() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT, TbConfig.SERVER_ADDRESS + TbConfig.GUIDE_INTEREST_COMMIT_URL);
        tbHttpMessageTask.setIsNeedAddCommenParam(false);
        tbHttpMessageTask.setResponsedClass(InterestCommitHttpResMsg.class);
        tbHttpMessageTask.setPriority(4);
        MessageManager.getInstance().registerTask(tbHttpMessageTask);
    }

    public void e(List<d.b.i0.y1.c.a> list) throws UnsupportedEncodingException {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_GUIDE_INTEREST_COMMIT);
        String encode = URLEncoder.encode(g(list), "utf-8");
        if (d.b.h0.b.d.k() && !TbadkCoreApplication.isLogin()) {
            d.b.h0.r.d0.b.i().w("user_interest_info", encode);
        }
        httpMessage.addParam("interestList", encode);
        httpMessage.addParam("user_id", TbadkCoreApplication.getCurrentAccount());
        httpMessage.setTag(this.f62592b);
        MessageManager.getInstance().sendMessage(httpMessage);
    }

    public final List<Integer> f(List<d.b.i0.y1.c.b> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (d.b.i0.y1.c.b bVar : list) {
                arrayList.add(Integer.valueOf(bVar.b()));
            }
        }
        return arrayList;
    }

    public final String g(List<d.b.i0.y1.c.a> list) {
        HashMap hashMap = new HashMap();
        for (d.b.i0.y1.c.a aVar : list) {
            HashMap hashMap2 = new HashMap();
            for (d.b.i0.y1.c.d dVar : aVar.f62578a) {
                if (dVar.f62588b) {
                    RecommendForumInfo recommendForumInfo = dVar.f62587a;
                    hashMap2.put(recommendForumInfo.forum_id, recommendForumInfo.forum_name);
                }
            }
            hashMap.put(aVar.f62580c, hashMap2);
        }
        return this.f62593c.toJson(hashMap);
    }

    public void h() {
        InterestedForumReqMsg interestedForumReqMsg = new InterestedForumReqMsg();
        List<d.b.i0.y1.c.b> list = this.f62596f;
        if (list == null) {
            interestedForumReqMsg.classidList = f(null);
        } else {
            interestedForumReqMsg.classidList = f(list.subList((this.f62591a - 1) * 3, Math.min(list.size(), this.f62591a * 3)));
        }
        interestedForumReqMsg.setTag(this.f62592b);
        MessageManager.getInstance().sendMessage(interestedForumReqMsg);
    }

    public boolean i() {
        return (this.f62591a - 1) * 3 < this.f62596f.size();
    }

    public final void j() {
        TbHttpMessageTask tbHttpMessageTask = new TbHttpMessageTask(CmdConfigHttp.CMD_GUIDE_INTERESTED_FORUM, d.b.i0.c3.d0.a.a(TbConfig.GUIDE_INTERESTED_FORUM_URL, 309654));
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

    public void m(List<d.b.i0.y1.c.b> list) {
        this.f62596f = list;
        this.f62591a = 1;
    }

    public void n(c cVar) {
        this.f62595e = cVar;
    }

    public void o(d dVar) {
        this.f62594d = dVar;
    }
}
