package d.a.k0.q1.o;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.YYPayService;
import d.a.j0.l0.f;
import d.a.j0.l0.g;
/* loaded from: classes3.dex */
public class b implements YYPayService {

    /* loaded from: classes3.dex */
    public class a implements d.a.j0.l0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayService.YYPayResultCallback f59766a;

        public a(b bVar, YYPayService.YYPayResultCallback yYPayResultCallback) {
            this.f59766a = yYPayResultCallback;
        }

        @Override // d.a.j0.l0.b
        public void a(g gVar) {
            if (gVar != null) {
                YYPayService.YYPayResultMessage yYPayResultMessage = new YYPayService.YYPayResultMessage();
                yYPayResultMessage.setStatus(gVar.f49473h);
                yYPayResultMessage.setAppid(gVar.f49467b);
                yYPayResultMessage.setUid(gVar.f49474i.longValue());
                yYPayResultMessage.setUsedChannel(gVar.j);
                yYPayResultMessage.setCurrencyType(gVar.f49469d);
                yYPayResultMessage.setAmount(gVar.f49466a.longValue());
                yYPayResultMessage.setCurrencyAmount(gVar.f49468c.longValue());
                yYPayResultMessage.setOrderId(gVar.f49471f);
                yYPayResultMessage.setExpand(gVar.f49470e);
                yYPayResultMessage.setPollingTimeout(gVar.f49472g.booleanValue());
                this.f59766a.onSuccess(yYPayResultMessage);
                return;
            }
            this.f59766a.onSuccess(null);
        }

        @Override // d.a.j0.l0.b
        public void onFail(int i2, String str) {
            this.f59766a.onFail(i2, str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, YYPayService.YYPayResultCallback yYPayResultCallback) {
        MessageManager.getInstance().runTask(2921546, String.class, new f(context, 1, new a(this, yYPayResultCallback)));
    }
}
