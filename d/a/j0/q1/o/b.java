package d.a.j0.q1.o;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.YYPayService;
import d.a.i0.l0.f;
import d.a.i0.l0.g;
/* loaded from: classes3.dex */
public class b implements YYPayService {

    /* loaded from: classes3.dex */
    public class a implements d.a.i0.l0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayService.YYPayResultCallback f59021a;

        public a(b bVar, YYPayService.YYPayResultCallback yYPayResultCallback) {
            this.f59021a = yYPayResultCallback;
        }

        @Override // d.a.i0.l0.b
        public void a(g gVar) {
            if (gVar != null) {
                YYPayService.YYPayResultMessage yYPayResultMessage = new YYPayService.YYPayResultMessage();
                yYPayResultMessage.setStatus(gVar.f48644h);
                yYPayResultMessage.setAppid(gVar.f48638b);
                yYPayResultMessage.setUid(gVar.f48645i.longValue());
                yYPayResultMessage.setUsedChannel(gVar.j);
                yYPayResultMessage.setCurrencyType(gVar.f48640d);
                yYPayResultMessage.setAmount(gVar.f48637a.longValue());
                yYPayResultMessage.setCurrencyAmount(gVar.f48639c.longValue());
                yYPayResultMessage.setOrderId(gVar.f48642f);
                yYPayResultMessage.setExpand(gVar.f48641e);
                yYPayResultMessage.setPollingTimeout(gVar.f48643g.booleanValue());
                this.f59021a.onSuccess(yYPayResultMessage);
                return;
            }
            this.f59021a.onSuccess(null);
        }

        @Override // d.a.i0.l0.b
        public void onFail(int i2, String str) {
            this.f59021a.onFail(i2, str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, YYPayService.YYPayResultCallback yYPayResultCallback) {
        MessageManager.getInstance().runTask(2921546, String.class, new f(context, 1, new a(this, yYPayResultCallback)));
    }
}
