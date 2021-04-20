package d.b.i0.i0.g;

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
import d.b.c.e.d.l;
import d.b.c.e.p.k;
import d.b.h0.z0.f0;
import d.b.h0.z0.h0;
import java.util.ArrayList;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public RecentlyVisitedForumData f56624a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f56625b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f56626c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f56627d;

    /* renamed from: e  reason: collision with root package name */
    public f f56628e;

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f56629f;

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f56630g;

    /* renamed from: h  reason: collision with root package name */
    public d.b.c.c.g.a f56631h;

    /* renamed from: d.b.i0.i0.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1321a extends f0<Object> {
        public C1321a() {
        }

        @Override // d.b.h0.z0.f0
        public Object doInBackground() {
            l<String> h2 = d.b.h0.r.r.a.f().h("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount() == null ? "local" : TbadkCoreApplication.getCurrentAccount());
            if (h2 != null && a.this.f56624a != null) {
                h2.g("recently_visited_forum", OrmObject.jsonStrWithObject(a.this.f56624a));
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
            l<String> h2 = d.b.h0.r.r.a.f().h("tb.recently_visited_forum", "local");
            RecentlyVisitedForumData recentlyVisitedForumData = null;
            RecentlyVisitedForumData recentlyVisitedForumData2 = (h2 == null || k.isEmpty(h2.get("recently_visited_forum"))) ? null : (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h2.get("recently_visited_forum"), RecentlyVisitedForumData.class);
            if (TbadkCoreApplication.getCurrentAccount() != null) {
                if (h2 != null) {
                    h2.g("recently_visited_forum", "");
                }
                l<String> h3 = d.b.h0.r.r.a.f().h("tb.recently_visited_forum", TbadkCoreApplication.getCurrentAccount());
                if (h3 == null || StringUtils.isNull(h3.get("recently_visited_forum"))) {
                    return recentlyVisitedForumData2;
                }
                try {
                    recentlyVisitedForumData = (RecentlyVisitedForumData) OrmObject.objectWithJsonStr(h3.get("recently_visited_forum"), RecentlyVisitedForumData.class);
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                if (recentlyVisitedForumData2 != null) {
                    recentlyVisitedForumData2.w(recentlyVisitedForumData);
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
            a.this.f56625b = false;
            if (recentlyVisitedForumData != null) {
                a.this.x(recentlyVisitedForumData.u(), true);
            }
        }
    }

    /* loaded from: classes4.dex */
    public class c extends CustomMessageListener {
        public c(int i) {
            super(i);
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
        public d(int i) {
            super(i);
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
    public class e extends d.b.c.c.g.a {
        public e(int i, int i2) {
            super(i, i2);
        }

        @Override // d.b.c.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            a.this.f56626c = false;
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

        void b(int i);

        void onNotify();
    }

    /* loaded from: classes4.dex */
    public static class g {

        /* renamed from: a  reason: collision with root package name */
        public static a f56637a = new a(null);
    }

    public /* synthetic */ a(C1321a c1321a) {
        this();
    }

    public static a l() {
        return g.f56637a;
    }

    public void i(VisitedForumData visitedForumData) {
        p(visitedForumData);
    }

    public RecentlyVisitedForumData j() {
        return this.f56624a;
    }

    public String k() {
        RecentlyVisitedForumData recentlyVisitedForumData = this.f56624a;
        if (recentlyVisitedForumData == null || recentlyVisitedForumData.u() == null || this.f56624a.u().size() < 1) {
            return "";
        }
        ArrayList<VisitedForumData> arrayList = new ArrayList(this.f56624a.u());
        JSONArray jSONArray = new JSONArray();
        for (VisitedForumData visitedForumData : arrayList) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("forum_id", d.b.c.e.m.b.f(visitedForumData.getForumId(), 0L));
                jSONObject.put("visit_time", visitedForumData.A());
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            jSONArray.put(jSONObject);
        }
        return jSONArray.toString();
    }

    public final void m() {
        this.f56625b = true;
        b bVar = new b();
        bVar.setPriority(3);
        bVar.execute(new Void[0]);
    }

    public void n() {
        if (this.f56626c) {
            return;
        }
        RecentlyVisitedForumRequestMessage recentlyVisitedForumRequestMessage = new RecentlyVisitedForumRequestMessage();
        recentlyVisitedForumRequestMessage.setForumData(this.f56624a.u());
        this.f56626c = MessageManager.getInstance().sendMessage(recentlyVisitedForumRequestMessage);
    }

    public void o() {
        f fVar = this.f56628e;
        if (fVar != null) {
            fVar.a(this.f56624a.u(), this.f56627d);
        }
    }

    public final void p(VisitedForumData visitedForumData) {
        int t;
        if (visitedForumData != null && (t = this.f56624a.t(visitedForumData)) >= 0) {
            f fVar = this.f56628e;
            if (fVar != null) {
                fVar.b(t);
            }
            v(visitedForumData);
            y();
        }
    }

    public final void q(VisitedForumData visitedForumData) {
        if (visitedForumData == null) {
            return;
        }
        this.f56624a.s(visitedForumData);
        this.f56624a.y(20);
        o();
        y();
        l().n();
    }

    public void r() {
        f fVar = this.f56628e;
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
        MessageManager.getInstance().registerListener(this.f56631h);
        MessageManager.getInstance().registerListener(this.f56629f);
        MessageManager.getInstance().registerListener(this.f56630g);
    }

    public final void v(VisitedForumData visitedForumData) {
        if (TbadkCoreApplication.isLogin()) {
            HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_DELETE_HISTORY_FORUM);
            httpMessage.addParam("forum_id", d.b.c.e.m.b.f(visitedForumData.getForumId(), 0L));
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    public void w(f fVar) {
        this.f56628e = fVar;
    }

    public final void x(LinkedList<VisitedForumData> linkedList, boolean z) {
        if (linkedList == null) {
            return;
        }
        this.f56624a.x(linkedList);
        this.f56624a.y(20);
        this.f56627d = z;
        o();
    }

    public void y() {
        if (this.f56625b) {
            return;
        }
        h0.b(new C1321a(), null);
    }

    public a() {
        this.f56625b = false;
        this.f56626c = false;
        this.f56629f = new c(2016564);
        this.f56630g = new d(2005016);
        this.f56631h = new e(CmdConfigHttp.CMD_GET_HISTORY_FORUM, 309601);
        this.f56624a = new RecentlyVisitedForumData();
        u();
        m();
    }
}
