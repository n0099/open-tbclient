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
    public TbPageContext f62441a;

    /* renamed from: b  reason: collision with root package name */
    public b f62442b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f62443c;

    /* renamed from: d.b.i0.t.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1622a extends HttpMessageListener {
        public C1622a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaTDouBuyPrivilegeResponsedMessage) {
                AlaTDouBuyPrivilegeResponsedMessage alaTDouBuyPrivilegeResponsedMessage = (AlaTDouBuyPrivilegeResponsedMessage) httpResponsedMessage;
                boolean z = alaTDouBuyPrivilegeResponsedMessage.getError() == 0;
                String errorString = alaTDouBuyPrivilegeResponsedMessage.getErrorString();
                if (a.this.f62442b != null) {
                    a.this.f62442b.a(z, errorString);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        C1622a c1622a = new C1622a(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        this.f62443c = c1622a;
        this.f62441a = tbPageContext;
        this.f62442b = bVar;
        tbPageContext.registerListener(c1622a);
    }

    public void b(String str, int i) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("props_id", i);
        httpMessage.addParam("effect_id", str);
        httpMessage.addParam("buy_action", 0);
        this.f62441a.sendMessage(httpMessage);
    }

    public void c(int i, int i2, boolean z) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("props_id", i2);
        httpMessage.addParam("mark_id", i);
        httpMessage.addParam("buy_action", z ? 1 : 0);
        this.f62441a.sendMessage(httpMessage);
    }
}
