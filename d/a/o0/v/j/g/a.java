package d.a.o0.v.j.g;

import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpMessage;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tieba.ala.personcenter.privilege.AlaTDouBuyPrivilegeResponsedMessage;
/* loaded from: classes4.dex */
public class a {

    /* renamed from: a  reason: collision with root package name */
    public TbPageContext f65913a;

    /* renamed from: b  reason: collision with root package name */
    public b f65914b;

    /* renamed from: c  reason: collision with root package name */
    public HttpMessageListener f65915c;

    /* renamed from: d.a.o0.v.j.g.a$a  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public class C1731a extends HttpMessageListener {
        public C1731a(int i2) {
            super(i2);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaTDouBuyPrivilegeResponsedMessage) {
                AlaTDouBuyPrivilegeResponsedMessage alaTDouBuyPrivilegeResponsedMessage = (AlaTDouBuyPrivilegeResponsedMessage) httpResponsedMessage;
                boolean z = alaTDouBuyPrivilegeResponsedMessage.getError() == 0;
                String errorString = alaTDouBuyPrivilegeResponsedMessage.getErrorString();
                if (a.this.f65914b != null) {
                    a.this.f65914b.a(z, errorString);
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public interface b {
        void a(boolean z, String str);
    }

    public a(TbPageContext tbPageContext, b bVar) {
        C1731a c1731a = new C1731a(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        this.f65915c = c1731a;
        this.f65913a = tbPageContext;
        this.f65914b = bVar;
        tbPageContext.registerListener(c1731a);
    }

    public void b(String str, int i2) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("props_id", i2);
        httpMessage.addParam("effect_id", str);
        httpMessage.addParam("buy_action", 0);
        this.f65913a.sendMessage(httpMessage);
    }

    public void c(int i2, int i3, boolean z) {
        HttpMessage httpMessage = new HttpMessage(AlaCmdConfigHttp.CMD_ALA_ENTER_EFFECT_BUY_PROP);
        httpMessage.addParam("props_id", i3);
        httpMessage.addParam("mark_id", i2);
        httpMessage.addParam("buy_action", z ? 1 : 0);
        this.f65913a.sendMessage(httpMessage);
    }
}
