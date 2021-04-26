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
    public d.r.b.a.a.j.b.a f67175a;

    /* renamed from: b  reason: collision with root package name */
    public IAppPayService f67176b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f67177c = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChargeCurrencyReqParams f67178e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f67179f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f67180g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f67181h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1838d f67182i;

        public a(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str, i iVar, InterfaceC1838d interfaceC1838d) {
            this.f67178e = chargeCurrencyReqParams;
            this.f67179f = i2;
            this.f67180g = str;
            this.f67181h = iVar;
            this.f67182i = interfaceC1838d;
        }

        @Override // java.lang.Runnable
        public void run() {
            GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = new GetChargeOrderStatusReqParams();
            getChargeOrderStatusReqParams.setUid(this.f67178e.getUid());
            getChargeOrderStatusReqParams.setAppId(this.f67179f);
            getChargeOrderStatusReqParams.setUsedChannel(this.f67178e.getUsedChannel());
            getChargeOrderStatusReqParams.setSid(this.f67178e.getSid());
            getChargeOrderStatusReqParams.setOrderId(this.f67180g);
            getChargeOrderStatusReqParams.setToken(this.f67178e.getToken());
            getChargeOrderStatusReqParams.setTokenCallback(this.f67178e.getTokenCallback());
            i iVar = this.f67181h;
            iVar.f67102c++;
            d.this.d(this.f67178e, getChargeOrderStatusReqParams, iVar, this.f67182i);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements IResult<GetChargeOrderStatusResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f67183a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetChargeOrderStatusReqParams f67184b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChargeCurrencyReqParams f67185c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1838d f67186d;

        public b(i iVar, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, ChargeCurrencyReqParams chargeCurrencyReqParams, InterfaceC1838d interfaceC1838d) {
            this.f67183a = iVar;
            this.f67184b = getChargeOrderStatusReqParams;
            this.f67185c = chargeCurrencyReqParams;
            this.f67186d = interfaceC1838d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "doPollingForChargeResult onSuccess result:" + getChargeOrderStatusResult);
            if (getChargeOrderStatusResult.getStatus() == 1) {
                i iVar = this.f67183a;
                iVar.f67102c = iVar.f67100a;
                d.this.e(this.f67184b, getChargeOrderStatusResult, false);
            } else if (getChargeOrderStatusResult.finish) {
                i iVar2 = this.f67183a;
                iVar2.f67102c = iVar2.f67100a;
                d.this.e(this.f67184b, getChargeOrderStatusResult, false);
            } else {
                d.this.f(this.f67185c, this.f67184b.getAppId(), this.f67184b.getOrderId(), this.f67183a, this.f67186d);
            }
            InterfaceC1838d interfaceC1838d = this.f67186d;
            if (interfaceC1838d != null) {
                interfaceC1838d.b(this.f67185c, getChargeOrderStatusResult);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-Poller", "doPollingForChargeResult onFail code:" + i2, new Object[0]);
            d.this.f(this.f67185c, this.f67184b.getAppId(), this.f67184b.getOrderId(), this.f67183a, this.f67186d);
            InterfaceC1838d interfaceC1838d = this.f67186d;
            if (interfaceC1838d != null) {
                interfaceC1838d.a(this.f67185c, i2, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CurrencyChargeMessage f67188e;

        public c(CurrencyChargeMessage currencyChargeMessage) {
            this.f67188e = currencyChargeMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f67175a.a(this.f67188e);
        }
    }

    /* renamed from: d.r.b.a.a.j.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1838d {
        void a(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str);

        void b(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult);
    }

    public d(IAppPayService iAppPayService, d.r.b.a.a.j.b.a aVar) {
        this.f67175a = aVar;
        this.f67176b = iAppPayService;
    }

    public final void d(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, i iVar, InterfaceC1838d interfaceC1838d) {
        d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "do pollingForChargeResult has finishTimes:" + iVar.f67102c);
        this.f67176b.queryChargeOrderStatus(getChargeOrderStatusReqParams, new b(iVar, getChargeOrderStatusReqParams, chargeCurrencyReqParams, interfaceC1838d));
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
            this.f67175a.a(currencyChargeMessage);
        } else {
            f.a().b().execute(new c(currencyChargeMessage));
        }
    }

    public void f(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str, i iVar, InterfaceC1838d interfaceC1838d) {
        int i3;
        if (d.r.b.a.a.f.a.c().a() != ProtocolType.HTTP) {
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult but not http");
        } else if (iVar == null) {
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo null");
        } else {
            int i4 = iVar.f67101b;
            if (i4 >= 0 && (i3 = iVar.f67100a) > 0) {
                int i5 = iVar.f67102c;
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
                d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult post delaye interval:" + iVar.f67101b + " has finish times:" + iVar.f67102c + " delay:" + i4);
                this.f67177c.postDelayed(new a(chargeCurrencyReqParams, i2, str, iVar, interfaceC1838d), ((long) i4) * 1000);
                return;
            }
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo params error");
        }
    }
}
