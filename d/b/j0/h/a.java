package d.b.j0.h;

import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.adp.lib.util.NetWorkChangedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import d.b.c.e.p.j;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f56769a;

    /* renamed from: b  reason: collision with root package name */
    public String f56770b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f56771c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f56772d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f56773e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f56774f = new b(2000994);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f56775g = new c(2016488);

    /* renamed from: d.b.j0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1336a extends HttpMessageListener {
        public C1336a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                a.this.f56769a = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.A() && a.this.f56769a != null) {
                a aVar = a.this;
                aVar.h(aVar.f56769a, a.this.f56773e);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
                return;
            }
            a.this.f((JSONObject) customResponsedMessage.getData());
        }
    }

    public a(TbPageContext tbPageContext, String str) {
        this.f56770b = str;
        if (this.f56771c == null) {
            this.f56771c = new C1336a(CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.f56771c.setTag(this.f56773e);
        MessageManager.getInstance().registerListener(this.f56771c);
        MessageManager.getInstance().registerListener(this.f56774f);
        this.f56775g.setTag(tbPageContext.getUniqueId());
        this.f56775g.setSelfListener(true);
        this.f56775g.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.f56775g);
    }

    public final void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (j.A()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            h(jSONArray, this.f56772d);
            return;
        }
        if (this.f56769a == null) {
            this.f56769a = new JSONArray();
        }
        if (this.f56769a.length() <= 100) {
            this.f56769a.put(jSONObject);
        }
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f56771c);
        MessageManager.getInstance().unRegisterListener(this.f56774f);
        MessageManager.getInstance().unRegisterListener(this.f56775g);
        this.f56769a = null;
    }

    public final void h(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.f56770b);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
