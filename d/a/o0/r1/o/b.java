package d.a.o0.r1.o;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.searchbox.live.interfaces.service.YYPayService;
import d.a.n0.l0.f;
import d.a.n0.l0.g;
/* loaded from: classes3.dex */
public class b implements YYPayService {

    /* loaded from: classes3.dex */
    public class a implements d.a.n0.l0.b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ YYPayService.YYPayResultCallback f63723a;

        public a(b bVar, YYPayService.YYPayResultCallback yYPayResultCallback) {
            this.f63723a = yYPayResultCallback;
        }

        @Override // d.a.n0.l0.b
        public void a(g gVar) {
            if (gVar != null) {
                YYPayService.YYPayResultMessage yYPayResultMessage = new YYPayService.YYPayResultMessage();
                yYPayResultMessage.setStatus(gVar.f53298g);
                yYPayResultMessage.setAppid(gVar.f53293b);
                yYPayResultMessage.setUid(gVar.f53299h.longValue());
                yYPayResultMessage.setUsedChannel(gVar.f53300i);
                yYPayResultMessage.setCurrencyType(gVar.f53295d);
                yYPayResultMessage.setAmount(gVar.f53292a.longValue());
                yYPayResultMessage.setCurrencyAmount(gVar.f53294c.longValue());
                yYPayResultMessage.setOrderId(gVar.f53297f);
                yYPayResultMessage.setExpand(gVar.f53296e);
                this.f63723a.onSuccess(yYPayResultMessage);
                return;
            }
            this.f63723a.onSuccess(null);
        }

        @Override // d.a.n0.l0.b
        public void onFail(int i2, String str) {
            this.f63723a.onFail(i2, str);
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, YYPayService.YYPayResultCallback yYPayResultCallback) {
        startPayment(context, null, yYPayResultCallback);
    }

    @Override // com.baidu.searchbox.live.interfaces.service.YYPayService
    public void startPayment(Context context, String str, YYPayService.YYPayResultCallback yYPayResultCallback) {
        MessageManager.getInstance().runTask(2921546, String.class, new f(context, 1, str, new a(this, yYPayResultCallback)));
    }
}
