package i.a.a.f;

import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import d.r.b.a.a.f.d.d;
/* loaded from: classes8.dex */
public final class b implements d.r.b.a.a.i.b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f68901a = new b();

    @Override // d.r.b.a.a.i.b
    public void a(CurrencyChargeMessage currencyChargeMessage) {
        d.b("GiftEventCallbackImpl", "onCurrencyChargeMessage appId == " + currencyChargeMessage.appid);
    }

    @Override // d.r.b.a.a.i.b
    public void b(d.r.b.a.a.i.c.c cVar) {
        d.b("GiftEventCallbackImpl", "onConsumeConfirmMessage appId == " + cVar.f67760b);
    }

    @Override // d.r.b.a.a.i.b
    public void c(d.r.b.a.a.i.c.a aVar) {
        d.b("GiftEventCallbackImpl", "onAccountDelayMessage appId == " + aVar.f67743a);
    }
}
