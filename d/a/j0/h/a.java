package d.a.j0.h;

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
    public JSONArray f54674a;

    /* renamed from: b  reason: collision with root package name */
    public String f54675b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f54676c;

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f54677d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public BdUniqueId f54678e = BdUniqueId.gen();

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f54679f = new b(2000994);

    /* renamed from: g  reason: collision with root package name */
    public CustomMessageListener f54680g = new c(2016488);

    /* renamed from: d.a.j0.h.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1275a extends HttpMessageListener {
        public C1275a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003184 && httpResponsedMessage.getError() == 0) {
                a.this.f54674a = null;
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
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.A() && a.this.f54674a != null) {
                a aVar = a.this;
                aVar.h(aVar.f54674a, a.this.f54678e);
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
        this.f54675b = str;
        if (this.f54676c == null) {
            this.f54676c = new C1275a(CmdConfigHttp.CMD_NEG_FEED_BACK);
        }
        this.f54676c.setTag(this.f54678e);
        MessageManager.getInstance().registerListener(this.f54676c);
        MessageManager.getInstance().registerListener(this.f54679f);
        this.f54680g.setTag(tbPageContext.getUniqueId());
        this.f54680g.setSelfListener(true);
        this.f54680g.setPriority(Integer.MIN_VALUE);
        MessageManager.getInstance().registerListener(this.f54680g);
    }

    public final void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (j.A()) {
            JSONArray jSONArray = new JSONArray();
            jSONArray.put(jSONObject);
            h(jSONArray, this.f54677d);
            return;
        }
        if (this.f54674a == null) {
            this.f54674a = new JSONArray();
        }
        if (this.f54674a.length() <= 100) {
            this.f54674a.put(jSONObject);
        }
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f54676c);
        MessageManager.getInstance().unRegisterListener(this.f54679f);
        MessageManager.getInstance().unRegisterListener(this.f54680g);
        this.f54674a = null;
    }

    public final void h(JSONArray jSONArray, BdUniqueId bdUniqueId) {
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_NEG_FEED_BACK);
        httpMessage.addParam("dislike", jSONArray.toString());
        httpMessage.addParam("dislike_from", this.f54675b);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
