package d.a.k0.t;

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
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f61110a;

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageListener f61111b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f61112c = BdUniqueId.gen();

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f61113d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f61114e = new b(2000994);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f61115f = new c(2921324);

    /* renamed from: d.a.k0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1618a extends HttpMessageListener {
        public C1618a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003390 && httpResponsedMessage.getError() == 0) {
                a.this.f61110a = null;
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
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.A() && a.this.f61110a != null) {
                a aVar = a.this;
                aVar.h(aVar.f61110a, a.this.f61113d);
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

    public a(TbPageContext tbPageContext) {
        if (this.f61111b == null) {
            this.f61111b = new C1618a(CmdConfigHttp.CMD_FRS_STAGE_FEED_BACK);
        }
        MessageManager.getInstance().registerListener(this.f61111b);
        MessageManager.getInstance().registerListener(this.f61114e);
        this.f61115f.setTag(tbPageContext.getUniqueId());
        this.f61115f.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f61115f);
    }

    public final void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (j.A()) {
            h(jSONObject, this.f61112c);
        } else {
            this.f61110a = jSONObject;
        }
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f61111b);
        MessageManager.getInstance().unRegisterListener(this.f61114e);
        MessageManager.getInstance().unRegisterListener(this.f61115f);
        this.f61110a = null;
    }

    public final void h(JSONObject jSONObject, BdUniqueId bdUniqueId) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("tid");
        String optString2 = jSONObject.optString("fid");
        String optString3 = jSONObject.optString("dislike_ids");
        String optString4 = jSONObject.optString("type");
        int i2 = 1;
        if ("ala_frs_stage_live_feed_back_type".equals(optString4)) {
            i2 = 2;
        } else {
            "ala_frs_demo_hell_live_feed_back_type".equals(optString4);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_STAGE_FEED_BACK);
        httpMessage.addParam("thread_id", optString);
        httpMessage.addParam("forum_id", optString2);
        httpMessage.addParam("dislike_reason_id", optString3);
        httpMessage.addParam("reason_type", i2);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
