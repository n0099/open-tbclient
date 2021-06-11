package d.a.n0.j0.g;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.OrmObject.toolsystem.orm.object.OrmObject;
import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.data.VisitedForumData;
import com.baidu.tieba.enterForum.data.RecentlyVisitedForumData;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumHttpResponseMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumRequestMessage;
import com.baidu.tieba.enterForum.home.RecentlyVisitedForumSocketResponseMessage;
import d.a.c.e.d.l;
import d.a.c.e.p.k;
import d.a.m0.z0.f0;
import d.a.m0.z0.h0;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RecentlyVisitedForumData f59551a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f59552b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f59553c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f59554d;

    /* renamed from: e  reason: collision with root package name */
    public f f59555e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f59556f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f59557g;

    /* renamed from: h  reason: collision with root package name */
    public d.a.c.c.g.a f59558h;

    /* renamed from: d.a.n0.j0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1429a extends f0<Object> {
        public C1429a() {
        }

        @Override // d.a.m0.z0.f0
        public Object doInBackground() {
            l<String> h2 = d.a.m0.r.r.a.f().h("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? "local" : TbadkCoreApplication.getCurrentAccount());
            if (h2 != null && a.this.f59551a != null) {
                h2.g("recently_visited_forum", OrmObject.jsonStrWithObject(a.this.f59551a));
            }
            return null;
        }
    }

    /* loaded from: classes4.dex */
    public class b extends BdAsyncTask<Void, Void, RecentlyVisitedForumData> {
        public b() {
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: b */
        public RecentlyVisitedForumData doInBackground(Void... voidArr) {
            l<String> h2 = d.a.m0.r.r.a.f().h("tb.recently_visited_forum", "local");
            RecentlyVisitedForumData recentlyVisitedForumData = null;
            RecentlyVisitedForumData recentlyVisitedForumData2 = (h2 == null || k.isEmpty(h2.get("recently_visited_forum"))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                if (h2 != null) {
                    h2.g("recently_visited_forum", "");
                }
                l<String> h3 = d.a.m0.r.r.a.f().h("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                if (h3 == null || StringUtils.isNull(h3.get("recently_visited_forum"))) {
                    return recentlyVisitedForumData2;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h3.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (recentlyVisitedForumData2 != null) {
                    recentlyVisitedForumData2.A(recentlyVisitedForumData);
                    h3.g("recently_visited_forum", OrmObject.jsonStrWithObject(recentlyVisitedForumData2));
                    return recentlyVisitedForumData2;
                }
                return recentlyVisitedForumData;
            }
            return recentlyVisitedForumData2;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
        /* renamed from: c */
        public void onPostExecute(RecentlyVisitedForumData recentlyVisitedForumData) {
            a.this.f59552b = false;
            if (recentlyVisitedForumData != null) {
                a.this.x(recentlyVisitedForumData.y(), true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null || customResponsedMessage.getData() == null) {
                return;
            }
            a.this.q((VisitedForumData) customResponsedMessage.getData());
        }
    }

    /* loaded from: classes4.dex */
    public class d extends CustomMessageListener {
        public d(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage == null) {
                return;
            }
            a.this.m();
        }
    }

    /* loaded from: classes4.dex */
    public class e extends d.a.c.c.g.a {
        public e(int i2, int i3) {
            super(i2, i3);
        }

        @Override // d.a.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a.this.f59553c = false;
            if (responsedMessage == null) {
                return;
            }
            if (responsedMessage instanceof RecentlyVisitedForumHttpResponseMessage) {
                a.this.s((RecentlyVisitedForumHttpResponseMessage) responsedMessage);
            } else if (responsedMessage instanceof RecentlyVisitedForumSocketResponseMessage) {
                a.this.t((RecentlyVisitedForumSocketResponseMessage) responsedMessage);
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface f {
        void a(LinkedList<VisitedForumData> linkedList, boolean z);

        void b(int i2);

        void onNotify();
    }

    /* loaded from: classes4.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static a f59564a = new a(null);
    }

    public /* synthetic */ a(C1429a c1429a) {
        this();
    }

    public static a l() {
        return g.f59564a;
    }

    public void i(VisitedForumData visitedForumData) {
        p(visitedForumData);
    }

    public RecentlyVisitedForumData j() {
        return this.f59551a;
    }

    public String k() {
        RecentlyVisitedForumData recentlyVisitedForumData = this.f59551a;
        if (recentlyVisitedForumData == null || recentlyVisitedForumData.y() == null || this.f59551a.y().size() < 1) {
            return "";
        }
        ArrayList<VisitedForumData> arrayList = new ArrayList(this.f59551a.y());
        JSONArray jSONArray = new JSONArray();
        for (VisitedForumData visitedForumData : arrayList) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_id", d.a.c.e.m.b.f(visitedForumData.getForumId(), 0L));
                jSONObject.put("visit_time", visitedForumData.E());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public final void m() {
        this.f59552b = true;
        b bVar = new b();
        bVar.setPriority(3);
        bVar.execute(new Void[0]);
    }

    public void n() {
        if (this.f59553c) {
            return;
        }
        RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
        recentlyVisitedForumRequestMessage.setForumData(this.f59551a.y());
        this.f59553c = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
    }

    public void o() {
        f fVar = this.f59555e;
        if (fVar != null) {
            fVar.a(this.f59551a.y(), this.f59554d);
        }
    }

    public final void p(VisitedForumData visitedForumData) {
        int x;
        if (visitedForumData != null && (x = this.f59551a.x(visitedForumData)) >= 0) {
            f fVar = this.f59555e;
            if (fVar != null) {
                fVar.b(x);
            }
            v(visitedForumData);
            y();
        }
    }

    public final void q(VisitedForumData visitedForumData) {
        if (visitedForumData == null) {
            return;
        }
        this.f59551a.w(visitedForumData);
        this.f59551a.C(20);
        o();
        y();
        l().n();
    }

    public void r() {
        f fVar = this.f59555e;
        if (fVar != null) {
            fVar.onNotify();
        }
    }

    public final void s(RecentlyVisitedForumHttpResponseMessage recentlyVisitedForumHttpResponseMessage) {
        if (recentlyVisitedForumHttpResponseMessage == null || recentlyVisitedForumHttpResponseMessage.getForumData() == null) {
            return;
        }
        x(recentlyVisitedForumHttpResponseMessage.getForumData(), false);
    }

    public final void t(RecentlyVisitedForumSocketResponseMessage recentlyVisitedForumSocketResponseMessage) {
        if (recentlyVisitedForumSocketResponseMessage == null || recentlyVisitedForumSocketResponseMessage.getForumData() == null) {
            return;
        }
        x(recentlyVisitedForumSocketResponseMessage.getForumData(), false);
    }

    public final void u() {
        MessageManager.getInstance().registerListener(this.f59558h);
        MessageManager.getInstance().registerListener(this.f59556f);
        MessageManager.getInstance().registerListener(this.f59557g);
    }

    public final void v(VisitedForumData visitedForumData) {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM);
            httpMessage.addParam("forum_id", d.a.c.e.m.b.f(visitedForumData.getForumId(), 0L));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void w(f fVar) {
        this.f59555e = fVar;
    }

    public final void x(LinkedList<VisitedForumData> linkedList, boolean z) {
        if (linkedList == null) {
            return;
        }
        this.f59551a.B(linkedList);
        this.f59551a.C(20);
        this.f59554d = z;
        o();
    }

    public void y() {
        if (this.f59552b) {
            return;
        }
        h0.b(new C1429a(), null);
    }

    public a() {
        this.f59552b = false;
        this.f59553c = false;
        this.f59556f = new c(2016564);
        this.f59557g = new d(2005016);
        this.f59558h = new e(CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601);
        this.f59551a = new RecentlyVisitedForumData();
        u();
        m();
    }
}
