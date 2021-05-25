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
    public JSONArray f55256a;

    /* renamed from: b  reason: collision with root package name */
    public String f55257b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f55258c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f55259d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f55260e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f55261f = new b(2000994);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f55262g = new c(2016488);

    /* renamed from: d.a.n0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1355a extends HttpMessageListener {
        public C1355a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                a.this.f55256a = null;
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
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.A() && a.this.f55256a != null) {
                a aVar = a.this;
                aVar.h(aVar.f55256a, a.this.f55260e);
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
        this.f55257b = str;
        if (this.f55258c == null) {
            this.f55258c = new C1355a(CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.f55258c.setTag(this.f55260e);
        MessageManager.getInstance().registerListener(this.f55258c);
        MessageManager.getInstance().registerListener(this.f55261f);
        this.f55262g.setTag(tbPageContext.getUniqueId());
        this.f55262g.setSelfListener(true);
        this.f55262g.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.f55262g);
    }

    public final void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (j.A()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            h(jSONArray, this.f55259d);
            return;
        }
        if (this.f55256a == null) {
            this.f55256a = new JSONArray();
        }
        if (this.f55256a.length() <= 100) {
            this.f55256a.put(jSONObject);
        }
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f55258c);
        MessageManager.getInstance().unRegisterListener(this.f55261f);
        MessageManager.getInstance().unRegisterListener(this.f55262g);
        this.f55256a = null;
    }

    public final void h(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.f55257b);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
