package d.a.o0.h;

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
    public JSONArray f59070a;

    /* renamed from: b  reason: collision with root package name */
    public String f59071b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f59072c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f59073d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f59074e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f59075f = new b(2000994);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f59076g = new c(2016488);

    /* renamed from: d.a.o0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1415a extends HttpMessageListener {
        public C1415a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                a.this.f59070a = null;
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
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.A() && a.this.f59070a != null) {
                a aVar = a.this;
                aVar.h(aVar.f59070a, a.this.f59074e);
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
        this.f59071b = str;
        if (this.f59072c == null) {
            this.f59072c = new C1415a(CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.f59072c.setTag(this.f59074e);
        MessageManager.getInstance().registerListener(this.f59072c);
        MessageManager.getInstance().registerListener(this.f59075f);
        this.f59076g.setTag(tbPageContext.getUniqueId());
        this.f59076g.setSelfListener(true);
        this.f59076g.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.f59076g);
    }

    public final void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (j.A()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            h(jSONArray, this.f59073d);
            return;
        }
        if (this.f59070a == null) {
            this.f59070a = new JSONArray();
        }
        if (this.f59070a.length() <= 100) {
            this.f59070a.put(jSONObject);
        }
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f59072c);
        MessageManager.getInstance().unRegisterListener(this.f59075f);
        MessageManager.getInstance().unRegisterListener(this.f59076g);
        this.f59070a = null;
    }

    public final void h(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.f59071b);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
