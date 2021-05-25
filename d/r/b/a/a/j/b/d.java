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
    public d.r.b.a.a.j.b.a f67904a;

    /* renamed from: b  reason: collision with root package name */
    public IAppPayService f67905b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f67906c = new Handler(Looper.getMainLooper());

    /* loaded from: classes7.dex */
    public class a implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ ChargeCurrencyReqParams f67907e;

        /* renamed from: f  reason: collision with root package name */
        public final /* synthetic */ int f67908f;

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ String f67909g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ i f67910h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1906d f67911i;

        public a(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str, i iVar, InterfaceC1906d interfaceC1906d) {
            this.f67907e = chargeCurrencyReqParams;
            this.f67908f = i2;
            this.f67909g = str;
            this.f67910h = iVar;
            this.f67911i = interfaceC1906d;
        }

        @Override // java.lang.Runnable
        public void run() {
            GetChargeOrderStatusReqParams getChargeOrderStatusReqParams = new GetChargeOrderStatusReqParams();
            getChargeOrderStatusReqParams.setUid(this.f67907e.getUid());
            getChargeOrderStatusReqParams.setAppId(this.f67908f);
            getChargeOrderStatusReqParams.setUsedChannel(this.f67907e.getUsedChannel());
            getChargeOrderStatusReqParams.setSid(this.f67907e.getSid());
            getChargeOrderStatusReqParams.setOrderId(this.f67909g);
            getChargeOrderStatusReqParams.setToken(this.f67907e.getToken());
            getChargeOrderStatusReqParams.setTokenCallback(this.f67907e.getTokenCallback());
            i iVar = this.f67910h;
            iVar.f67831c++;
            d.this.d(this.f67907e, getChargeOrderStatusReqParams, iVar, this.f67911i);
        }
    }

    /* loaded from: classes7.dex */
    public class b implements IResult<GetChargeOrderStatusResult> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ i f67912a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ GetChargeOrderStatusReqParams f67913b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ChargeCurrencyReqParams f67914c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ InterfaceC1906d f67915d;

        public b(i iVar, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, ChargeCurrencyReqParams chargeCurrencyReqParams, InterfaceC1906d interfaceC1906d) {
            this.f67912a = iVar;
            this.f67913b = getChargeOrderStatusReqParams;
            this.f67914c = chargeCurrencyReqParams;
            this.f67915d = interfaceC1906d;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        /* renamed from: a */
        public void onSuccess(GetChargeOrderStatusResult getChargeOrderStatusResult, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "doPollingForChargeResult onSuccess result:" + getChargeOrderStatusResult);
            if (getChargeOrderStatusResult.getStatus() == 1) {
                i iVar = this.f67912a;
                iVar.f67831c = iVar.f67829a;
                d.this.e(this.f67913b, getChargeOrderStatusResult, false);
            } else if (getChargeOrderStatusResult.finish) {
                i iVar2 = this.f67912a;
                iVar2.f67831c = iVar2.f67829a;
                d.this.e(this.f67913b, getChargeOrderStatusResult, false);
            } else {
                d.this.f(this.f67914c, this.f67913b.getAppId(), this.f67913b.getOrderId(), this.f67912a, this.f67915d);
            }
            InterfaceC1906d interfaceC1906d = this.f67915d;
            if (interfaceC1906d != null) {
                interfaceC1906d.b(this.f67914c, getChargeOrderStatusResult);
            }
        }

        @Override // com.yy.mobile.framework.revenuesdk.baseapi.IResult
        public void onFail(int i2, String str, d.r.b.a.a.f.b bVar) {
            d.r.b.a.a.f.d.d.e("AppPayServiceImpl-Poller", "doPollingForChargeResult onFail code:" + i2, new Object[0]);
            d.this.f(this.f67914c, this.f67913b.getAppId(), this.f67913b.getOrderId(), this.f67912a, this.f67915d);
            InterfaceC1906d interfaceC1906d = this.f67915d;
            if (interfaceC1906d != null) {
                interfaceC1906d.a(this.f67914c, i2, str);
            }
        }
    }

    /* loaded from: classes7.dex */
    public class c implements Runnable {

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ CurrencyChargeMessage f67917e;

        public c(CurrencyChargeMessage currencyChargeMessage) {
            this.f67917e = currencyChargeMessage;
        }

        @Override // java.lang.Runnable
        public void run() {
            d.this.f67904a.a(this.f67917e);
        }
    }

    /* renamed from: d.r.b.a.a.j.b.d$d  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC1906d {
        void a(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str);

        void b(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusResult getChargeOrderStatusResult);
    }

    public d(IAppPayService iAppPayService, d.r.b.a.a.j.b.a aVar) {
        this.f67904a = aVar;
        this.f67905b = iAppPayService;
    }

    public final void d(ChargeCurrencyReqParams chargeCurrencyReqParams, GetChargeOrderStatusReqParams getChargeOrderStatusReqParams, i iVar, InterfaceC1906d interfaceC1906d) {
        d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "do pollingForChargeResult has finishTimes:" + iVar.f67831c);
        this.f67905b.queryChargeOrderStatus(getChargeOrderStatusReqParams, new b(iVar, getChargeOrderStatusReqParams, chargeCurrencyReqParams, interfaceC1906d));
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
            this.f67904a.a(currencyChargeMessage);
        } else {
            f.a().b().execute(new c(currencyChargeMessage));
        }
    }

    public void f(ChargeCurrencyReqParams chargeCurrencyReqParams, int i2, String str, i iVar, InterfaceC1906d interfaceC1906d) {
        int i3;
        if (d.r.b.a.a.f.a.c().a() != ProtocolType.HTTP) {
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult but not http");
        } else if (iVar == null) {
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo null");
        } else {
            int i4 = iVar.f67830b;
            if (i4 >= 0 && (i3 = iVar.f67829a) > 0) {
                int i5 = iVar.f67831c;
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
                d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult post delaye interval:" + iVar.f67830b + " has finish times:" + iVar.f67831c + " delay:" + i4);
                this.f67906c.postDelayed(new a(chargeCurrencyReqParams, i2, str, iVar, interfaceC1906d), ((long) i4) * 1000);
                return;
            }
            d.r.b.a.a.f.d.d.b("AppPayServiceImpl-Poller", "pollingForChargeResult pollingModeInfo params error");
        }
    }
}
