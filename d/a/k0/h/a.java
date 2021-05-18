package d.a.k0.h;

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
    public JSONArray f55381a;

    /* renamed from: b  reason: collision with root package name */
    public String f55382b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f55383c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f55384d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f55385e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f55386f = new b(2000994);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f55387g = new c(2016488);

    /* renamed from: d.a.k0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1347a extends HttpMessageListener {
        public C1347a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                a.this.f55381a = null;
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
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.A() && a.this.f55381a != null) {
                a aVar = a.this;
                aVar.h(aVar.f55381a, a.this.f55385e);
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
        this.f55382b = str;
        if (this.f55383c == null) {
            this.f55383c = new C1347a(CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.f55383c.setTag(this.f55385e);
        MessageManager.getInstance().registerListener(this.f55383c);
        MessageManager.getInstance().registerListener(this.f55386f);
        this.f55387g.setTag(tbPageContext.getUniqueId());
        this.f55387g.setSelfListener(true);
        this.f55387g.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.f55387g);
    }

    public final void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (j.A()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            h(jSONArray, this.f55384d);
            return;
        }
        if (this.f55381a == null) {
            this.f55381a = new JSONArray();
        }
        if (this.f55381a.length() <= 100) {
            this.f55381a.put(jSONObject);
        }
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f55383c);
        MessageManager.getInstance().unRegisterListener(this.f55386f);
        MessageManager.getInstance().unRegisterListener(this.f55387g);
        this.f55381a = null;
    }

    public final void h(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.f55382b);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
