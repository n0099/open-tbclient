package d.a.n0.h;

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
import d.a.c.e.p.j;
import org.json.JSONArray;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public JSONArray f58945a;

    /* renamed from: b  reason: collision with root package name */
    public String f58946b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f58947c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f58948d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f58949e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f58950f = new b(2000994);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f58951g = new c(2016488);

    /* renamed from: d.a.n0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1411a extends HttpMessageListener {
        public C1411a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                a.this.f58945a = null;
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public b(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.A() && a.this.f58945a != null) {
                a aVar = a.this;
                aVar.h(aVar.f58945a, a.this.f58949e);
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
            if (customResponsedMessage == null || !(customResponsedMessage.getData() instanceof JSONObject)) {
                return;
            }
            a.this.f((JSONObject) customResponsedMessage.getData());
        }
    }

    public a(TbPageContext tbPageContext, String str) {
        this.f58946b = str;
        if (this.f58947c == null) {
            this.f58947c = new C1411a(CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.f58947c.setTag(this.f58949e);
        MessageManager.getInstance().registerListener(this.f58947c);
        MessageManager.getInstance().registerListener(this.f58950f);
        this.f58951g.setTag(tbPageContext.getUniqueId());
        this.f58951g.setSelfListener(true);
        this.f58951g.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.f58951g);
    }

    public final void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (j.A()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            h(jSONArray, this.f58948d);
            return;
        }
        if (this.f58945a == null) {
            this.f58945a = new JSONArray();
        }
        if (this.f58945a.length() <= 100) {
            this.f58945a.put(jSONObject);
        }
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f58947c);
        MessageManager.getInstance().unRegisterListener(this.f58950f);
        MessageManager.getInstance().unRegisterListener(this.f58951g);
        this.f58945a = null;
    }

    public final void h(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.f58946b);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
