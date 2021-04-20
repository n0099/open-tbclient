package d.b.i0.q1.f;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.searchbox.live.interfaces.pay.IPayCallback;
import com.baidu.searchbox.live.interfaces.pay.IPayChannel;
import com.baidu.searchbox.live.interfaces.pay.PayChannelType;
import com.baidu.searchbox.live.interfaces.service.PayChannelService;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tieba.wallet.ITiebaPay;
import com.baidu.tieba.wallet.ITiebaPayCallback;
import d.b.h0.z0.n0;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class b implements PayChannelService {

    /* renamed from: a  reason: collision with root package name */
    public ITiebaPay f60467a = null;

    /* loaded from: classes3.dex */
    public class a implements IPayChannel {

        /* renamed from: d.b.i0.q1.f.b$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class C1514a implements ITiebaPayCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ IPayCallback f60469a;

            public C1514a(a aVar, IPayCallback iPayCallback) {
                this.f60469a = iPayCallback;
            }

            @Override // com.baidu.tieba.wallet.ITiebaPayCallback
            public void onPayResult(int i, String str) {
                IPayCallback iPayCallback = this.f60469a;
                if (iPayCallback != null) {
                    iPayCallback.onPayResult(i, str);
                }
            }
        }

        public a() {
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public PayChannelType getType() {
            return PayChannelType.WALLET;
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public String getUaForFrontPay() {
            return n0.b() + " (Baidu; P1 " + Build.VERSION.RELEASE + SmallTailInfo.EMOTION_SUFFIX;
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public void onPayResult(String str, String str2, String str3, Context context, boolean z) {
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public void pay(Activity activity, HashMap<String, String> hashMap, IPayCallback iPayCallback) {
            if (hashMap == null || hashMap.isEmpty()) {
                return;
            }
            b.this.c();
            if (b.this.f60467a != null) {
                b.this.f60467a.pay(hashMap.remove("channel"), hashMap, new C1514a(this, iPayCallback));
            } else if (iPayCallback != null) {
                iPayCallback.onPayResult(2, null);
            }
        }

        @Override // com.baidu.searchbox.live.interfaces.pay.IPayChannel
        public void release() {
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.PayChannelService
    public IPayChannel buildPayChannel(PayChannelType payChannelType) {
        if (payChannelType == PayChannelType.WALLET) {
            return new a();
        }
        return null;
    }

    public final void c() {
        CustomResponsedMessage runTask;
        if (this.f60467a == null && (runTask = MessageManager.getInstance().runTask(2921432, ITiebaPay.class)) != null) {
            this.f60467a = (ITiebaPay) runTask.getData();
        }
    }
}
