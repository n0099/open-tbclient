package d.b.i0.t;

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
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public JSONObject f61788a;

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageListener f61789b;

    /* renamed from: c  reason: collision with root package name */
    public BdUniqueId f61790c = BdUniqueId.gen();

    /* renamed from: d  reason: collision with root package name */
    public BdUniqueId f61791d = BdUniqueId.gen();

    /* renamed from: e  reason: collision with root package name */
    public CustomMessageListener f61792e = new b(2000994);

    /* renamed from: f  reason: collision with root package name */
    public CustomMessageListener f61793f = new c(2921324);

    /* renamed from: d.b.i0.t.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1590a extends HttpMessageListener {
        public C1590a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1003390 && httpResponsedMessage.getError() == 0) {
                a.this.f61788a = null;
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
            if (getCmd() == 2000994 && (customResponsedMessage instanceof NetWorkChangedMessage) && !customResponsedMessage.hasError() && j.A() && a.this.f61788a != null) {
                a aVar = a.this;
                aVar.h(aVar.f61788a, a.this.f61791d);
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

    public a(TbPageContext tbPageContext) {
        if (this.f61789b == null) {
            this.f61789b = new C1590a(CmdConfigHttp.CMD_FRS_STAGE_FEED_BACK);
        }
        MessageManager.getInstance().registerListener(this.f61789b);
        MessageManager.getInstance().registerListener(this.f61792e);
        this.f61793f.setTag(tbPageContext.getUniqueId());
        this.f61793f.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f61793f);
    }

    public final void f(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        if (j.A()) {
            h(jSONObject, this.f61790c);
        } else {
            this.f61788a = jSONObject;
        }
    }

    public void g() {
        MessageManager.getInstance().unRegisterListener(this.f61789b);
        MessageManager.getInstance().unRegisterListener(this.f61792e);
        MessageManager.getInstance().unRegisterListener(this.f61793f);
        this.f61788a = null;
    }

    public final void h(JSONObject jSONObject, BdUniqueId bdUniqueId) {
        if (jSONObject == null) {
            return;
        }
        String optString = jSONObject.optString("tid");
        String optString2 = jSONObject.optString("fid");
        String optString3 = jSONObject.optString("dislike_ids");
        String optString4 = jSONObject.optString("type");
        int i = 1;
        if ("ala_frs_stage_live_feed_back_type".equals(optString4)) {
            i = 2;
        } else {
            "ala_frs_demo_hell_live_feed_back_type".equals(optString4);
        }
        HttpMessage httpMessage = new HttpMessage(CmdConfigHttp.CMD_FRS_STAGE_FEED_BACK);
        httpMessage.addParam("thread_id", optString);
        httpMessage.addParam("forum_id", optString2);
        httpMessage.addParam("dislike_reason_id", optString3);
        httpMessage.addParam("reason_type", i);
        httpMessage.setTag(bdUniqueId);
        MessageManager.getInstance().sendMessage(httpMessage);
    }
}
