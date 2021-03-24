package d.b.i0.t.j.g;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.personcenter.privilege.AlaTDouBuyPrivilegeResponsedMessage;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f60876a;

    /* renamed from: b  reason: collision with root package name */
    public b f60877b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f60878c;

    /* renamed from: d.b.i0.t.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1568a extends HttpMessageListener {
        public C1568a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaTDouBuyPrivilegeResponsedMessage) {
                AlaTDouBuyPrivilegeResponsedMessage alaTDouBuyPrivilegeResponsedMessage = (AlaTDouBuyPrivilegeResponsedMessage) httpResponsedMessage;
                boolean z = alaTDouBuyPrivilegeResponsedMessage.getError() == 0;
                String errorString = alaTDouBuyPrivilegeResponsedMessage.getErrorString();
                if (a.this.f60877b != null) {
                    a.this.f60877b.a(z, errorString);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        C1568a c1568a = new C1568a(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        this.f60878c = c1568a;
        this.f60876a = tbPageContext;
        this.f60877b = bVar;
        tbPageContext.registerListener(c1568a);
    }

    public void b(String str, int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("props_id", i);
        httpMessage.addParam("effect_id", str);
        httpMessage.addParam("buy_action", 0);
        this.f60876a.sendMessage(httpMessage);
    }

    public void c(int i, int i2, boolean z) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("props_id", i2);
        httpMessage.addParam("mark_id", i);
        httpMessage.addParam("buy_action", z ? 1 : 0);
        this.f60876a.sendMessage(httpMessage);
    }
}
