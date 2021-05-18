package d.r.b.a.a.j.b;

import android.os.Handler;
import android.os.Looper;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.ProtocolType;
import com.yy.mobile.framework.revenuesdk.payapi.IAppPayService;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import com.yy.mobile.framework.revenuesdk.payapi.callbackresult.GetChargeOrderStatusResult;
import com.yy.mobile.framework.revenuesdk.payapi.request.ChargeCurrencyReqParams;
import com.yy.mobile.framework.revenuesdk.payapi.request.GetChargeOrderStatusReqParams;
import d.r.b.a.a.f.h.f;
import d.r.b.a.a.i.c.i;
/* loaded from: classes7.dex */
public class d {

    /* renamed from: a  reason: collision with root package name */
    public d.r.b.a.a.j.b.a f67861a;

    /* renamed from: b  reason: collision with root package name */
    public IAppPayService f67862b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f67863c = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChargeCurrencyReqParams f67864e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f67865f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f67866g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f67867h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1902d f67868i;

        public a(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str, i iVar, InterfaceC1902d interfaceC1902d) {
            this.f67864e = chargeCurrencyReqParams;
            this.f67865f = i2;
            this.f67866g = str;
            this.f67867h = iVar;
            this.f67868i = interfaceC1902d;
        }

        @Override // java.lang.Runnable
        public void run() {
            GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = new GetChargeOrderStatusReqParams();
            getChargeOrderStatusReqParams.setUid(this.f67864e.getUid());
            getChargeOrderStatusReqParams.setAppId(this.f67865f);
            getChargeOrderStatusReqParams.setUsedChannel(this.f67864e.getUsedChannel());
            getChargeOrderStatusReqParams.setSid(this.f67864e.getSid());
            getChargeOrderStatusReqParams.setOrderId(this.f67866g);
            getChargeOrderStatusReqParams.setToken(this.f67864e.getToken());
            getChargeOrderStatusReqParams.setTokenCallback(this.f67864e.getTokenCallback());
            i iVar = this.f67867h;
            iVar.f67788c++;
            d.this.d(this.f67864e, getChargeOrderStatusReqParams, iVar, this.f67868i);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements IResult<GetChargeOrderStatusResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f67869a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetChargeOrderStatusReqParams f67870b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChargeCurrencyReqParams f67871c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1902d f67872d;

        public b(i iVar, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, ChargeCurrencyReqParams chargeCurrencyReqParams, InterfaceC1902d interfaceC1902d) {
            this.f67869a = iVar;
            this.f67870b = getChargeOrderStatusReqParams;
            this.f67871c = chargeCurrencyReqParams;
            this.f67872d = interfaceC1902d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "doPollingForChargeResult onSuccess result:" + getChargeOrderStatusResult);
            if (getChargeOrderStatusResult.getStatus() == 1) {
                i iVar = this.f67869a;
                iVar.f67788c = iVar.f67786a;
                d.this.e(this.f67870b, getChargeOrderStatusResult, false);
            } else if (getChargeOrderStatusResult.finish) {
                i iVar2 = this.f67869a;
                iVar2.f67788c = iVar2.f67786a;
                d.this.e(this.f67870b, getChargeOrderStatusResult, false);
            } else {
                d.this.f(this.f67871c, this.f67870b.getAppId(), this.f67870b.getOrderId(), this.f67869a, this.f67872d);
            }
            InterfaceC1902d interfaceC1902d = this.f67872d;
            if (interfaceC1902d != null) {
                interfaceC1902d.b(this.f67871c, getChargeOrderStatusResult);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-Poller", "doPollingForChargeResult onFail code:" + i2, new Object[0]);
            d.this.f(this.f67871c, this.f67870b.getAppId(), this.f67870b.getOrderId(), this.f67869a, this.f67872d);
            InterfaceC1902d interfaceC1902d = this.f67872d;
            if (interfaceC1902d != null) {
                interfaceC1902d.a(this.f67871c, i2, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CurrencyChargeMessage f67874e;

        public c(CurrencyChargeMessage currencyChargeMessage) {
            this.f67874e = currencyChargeMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f67861a.a(this.f67874e);
        }
    }

    /* renamed from: d.r.b.a.a.j.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1902d {
        void a(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str);

        void b(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult);
    }

    public d(IAppPayService iAppPayService, d.r.b.a.a.j.b.a aVar) {
        this.f67861a = aVar;
        this.f67862b = iAppPayService;
    }

    public final void d(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, i iVar, InterfaceC1902d interfaceC1902d) {
        d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "do pollingForChargeResult has finishTimes:" + iVar.f67788c);
        this.f67862b.queryChargeOrderStatus(getChargeOrderStatusReqParams, new b(iVar, getChargeOrderStatusReqParams, chargeCurrencyReqParams, interfaceC1902d));
    }

    public final void e(GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult, boolean z) {
        CurrencyChargeMessage currencyChargeMessage = new CurrencyChargeMessage();
        currencyChargeMessage.appid = getChargeOrderStatusReqParams.getAppId();
        currencyChargeMessage.usedChannel = getChargeOrderStatusReqParams.getUsedChannel();
        currencyChargeMessage.orderId = getChargeOrderStatusReqParams.getOrderId();
        currencyChargeMessage.uid = getChargeOrderStatusReqParams.getUid();
        currencyChargeMessage.amount = getChargeOrderStatusResult.amount;
        currencyChargeMessage.currencyAmount = getChargeOrderStatusResult.currencyAmount;
        currencyChargeMessage.currencyType = getChargeOrderStatusResult.currencyType;
        currencyChargeMessage.status = getChargeOrderStatusResult.status;
        currencyChargeMessage.pollingTimeout = z;
        if (Looper.myLooper() == Looper.getMainLooper()) {
            this.f67861a.a(currencyChargeMessage);
        } else {
            f.a().b().execute(new c(currencyChargeMessage));
        }
    }

    public void f(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str, i iVar, InterfaceC1902d interfaceC1902d) {
        int i3;
        if (d.r.b.a.a.f.a.c().a() != ProtocolType.HTTP) {
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult but not http");
        } else if (iVar == null) {
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo null");
        } else {
            int i4 = iVar.f67787b;
            if (i4 >= 0 && (i3 = iVar.f67786a) > 0) {
                int i5 = iVar.f67788c;
                if (i5 >= i3) {
                    GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = new GetChargeOrderStatusReqParams();
                    getChargeOrderStatusReqParams.setUid(chargeCurrencyReqParams.getUid());
                    getChargeOrderStatusReqParams.setToken(chargeCurrencyReqParams.getToken());
                    getChargeOrderStatusReqParams.setTokenCallback(chargeCurrencyReqParams.getTokenCallback());
                    getChargeOrderStatusReqParams.setAppId(i2);
                    getChargeOrderStatusReqParams.setUsedChannel(chargeCurrencyReqParams.getUsedChannel());
                    getChargeOrderStatusReqParams.setSid(chargeCurrencyReqParams.getSid());
                    getChargeOrderStatusReqParams.setOrderId(str);
                    GetChargeOrderStatusResult getChargeOrderStatusResult = new GetChargeOrderStatusResult();
                    getChargeOrderStatusResult.status = 0;
                    e(getChargeOrderStatusReqParams, getChargeOrderStatusResult, true);
                    d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo all times");
                    return;
                }
                if (i5 == 0) {
                    i4 = 2;
                }
                d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult post delaye interval:" + iVar.f67787b + " has finish times:" + iVar.f67788c + " delay:" + i4);
                this.f67863c.postDelayed(new a(chargeCurrencyReqParams, i2, str, iVar, interfaceC1902d), ((long) i4) * 1000);
                return;
            }
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo params error");
        }
    }
}
