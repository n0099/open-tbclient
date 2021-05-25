package d.a.n0.r1.o;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.YYPayService;
import d.a.m0.l0.f;
import d.a.m0.l0.g;
/* loaded from: classes3.dex */
public class b implements YYPayService {

    /* loaded from: classes3.dex */
    public class a implements d.a.m0.l0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayService.YYPayResultCallback f59907a;

        public a(b bVar, YYPayService.YYPayResultCallback yYPayResultCallback) {
            this.f59907a = yYPayResultCallback;
        }

        @Override // d.a.m0.l0.b
        public void a(g gVar) {
            if (gVar != null) {
                YYPayService.YYPayResultMessage yYPayResultMessage = new YYPayService.YYPayResultMessage();
                yYPayResultMessage.setStatus(gVar.f49517h);
                yYPayResultMessage.setAppid(gVar.f49511b);
                yYPayResultMessage.setUid(gVar.f49518i.longValue());
                yYPayResultMessage.setUsedChannel(gVar.j);
                yYPayResultMessage.setCurrencyType(gVar.f49513d);
                yYPayResultMessage.setAmount(gVar.f49510a.longValue());
                yYPayResultMessage.setCurrencyAmount(gVar.f49512c.longValue());
                yYPayResultMessage.setOrderId(gVar.f49515f);
                yYPayResultMessage.setExpand(gVar.f49514e);
                yYPayResultMessage.setPollingTimeout(gVar.f49516g.booleanValue());
                this.f59907a.onSuccess(yYPayResultMessage);
                return;
            }
            this.f59907a.onSuccess(null);
        }

        @Override // d.a.m0.l0.b
        public void onFail(int i2, String str) {
            this.f59907a.onFail(i2, str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, YYPayService.YYPayResultCallback yYPayResultCallback) {
        MessageManager.getInstance().runTask(2921546, String.class, new f(context, 1, new a(this, yYPayResultCallback)));
    }
}
