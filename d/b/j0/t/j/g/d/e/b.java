package d.b.j0.t.j.g.d.e;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.HttpMessageListener;
import com.baidu.adp.framework.message.HttpResponsedMessage;
import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.ala.AlaConfig;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectEditHttpReqMessage;
import com.baidu.tieba.ala.personcenter.privilege.entereffect.effectDetail.AlaEnterEffectEditHttpResMessage;
/* loaded from: classes4.dex */
public class b {

    /* renamed from: a  reason: collision with root package name */
    public InterfaceC1654b f62965a;

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageListener f62966b = new a(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT);

    /* loaded from: classes4.dex */
    public class a extends HttpMessageListener {
        public a(int i) {
            super(i);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage instanceof AlaEnterEffectEditHttpResMessage) {
                AlaEnterEffectEditHttpResMessage alaEnterEffectEditHttpResMessage = (AlaEnterEffectEditHttpResMessage) httpResponsedMessage;
                if (alaEnterEffectEditHttpResMessage.getError() != 0) {
                    if (b.this.f62965a != null) {
                        b.this.f62965a.a(alaEnterEffectEditHttpResMessage.getErrorString());
                    }
                } else if (!(alaEnterEffectEditHttpResMessage.getOrginalMessage() instanceof AlaEnterEffectEditHttpReqMessage) || b.this.f62965a == null) {
                } else {
                    b.this.f62965a.b(((AlaEnterEffectEditHttpReqMessage) alaEnterEffectEditHttpResMessage.getOrginalMessage()).isSelected());
                }
            }
        }
    }

    /* renamed from: d.b.j0.t.j.g.d.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1654b {
        void a(String str);

        void b(boolean z);
    }

    public b(InterfaceC1654b interfaceC1654b) {
        this.f62965a = interfaceC1654b;
        d.b.j0.d3.d0.a.e(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, AlaConfig.ALA_UPDATE_ENTER_EFFECT, AlaEnterEffectEditHttpResMessage.class, true, true, true, true);
        this.f62966b.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f62966b);
    }

    public void b(String str, boolean z) {
        MessageManager.getInstance().sendMessage(new AlaEnterEffectEditHttpReqMessage(str, z));
    }

    public void c() {
        MessageManager.getInstance().unRegisterListener(this.f62966b);
    }
}
