package d.b.i0.t.j.g.d.e;

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
    public InterfaceC1578b f60980a;

    /* renamed from: b  reason: collision with root package name */
    public HttpMessageListener f60981b = new a(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT);

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
                    if (b.this.f60980a != null) {
                        b.this.f60980a.a(alaEnterEffectEditHttpResMessage.getErrorString());
                    }
                } else if (!(alaEnterEffectEditHttpResMessage.getOrginalMessage() instanceof AlaEnterEffectEditHttpReqMessage) || b.this.f60980a == null) {
                } else {
                    b.this.f60980a.b(((AlaEnterEffectEditHttpReqMessage) alaEnterEffectEditHttpResMessage.getOrginalMessage()).isSelected());
                }
            }
        }
    }

    /* renamed from: d.b.i0.t.j.g.d.e.b$b  reason: collision with other inner class name */
    /* loaded from: classes4.dex */
    public interface InterfaceC1578b {
        void a(String str);

        void b(boolean z);
    }

    public b(InterfaceC1578b interfaceC1578b) {
        this.f60980a = interfaceC1578b;
        d.b.i0.c3.d0.a.e(AlaCmdConfigHttp.CMD_ALA_UPDATE_ENTER_EFFECT, AlaConfig.ALA_UPDATE_ENTER_EFFECT, AlaEnterEffectEditHttpResMessage.class, true, true, true, true);
        this.f60981b.setSelfListener(true);
        MessageManager.getInstance().registerListener(this.f60981b);
    }

    public void b(String str, boolean z) {
        MessageManager.getInstance().sendMessage(new AlaEnterEffectEditHttpReqMessage(str, z));
    }

    public void c() {
        MessageManager.getInstance().unRegisterListener(this.f60981b);
    }
}
