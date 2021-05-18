package d.r.b.a.a.j.c;

import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
import d.r.b.a.a.f.f.a;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes7.dex */
public final class a implements d.r.b.a.a.i.f.a {

    /* renamed from: a  reason: collision with root package name */
    public final IReporter f67876a;

    /* renamed from: b  reason: collision with root package name */
    public final String f67877b;

    public a(IReporter iReporter, String str, String str2) {
        this.f67876a = iReporter;
        this.f67877b = str;
    }

    @Override // d.r.b.a.a.i.f.a
    public void a(a.c cVar) {
        IReporter iReporter = this.f67876a;
        if (iReporter != null) {
            d.r.b.a.a.f.f.a a2 = d.r.b.a.a.f.f.a.a();
            Intrinsics.checkExpressionValueIsNotNull(a2, "HiidoReport.getInstance()");
            if (a2.d()) {
                d.r.b.a.a.f.f.a a3 = d.r.b.a.a.f.f.a.a();
                Intrinsics.checkExpressionValueIsNotNull(a3, "HiidoReport.getInstance()");
                if (a3.d()) {
                    Map<String, String> h2 = h(cVar);
                    String str = a.b.f67708a;
                    Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                    iReporter.reportStatisticContent(str, h2);
                    String c2 = d.r.b.a.a.f.f.a.a().c("onPayEntrancePage", cVar);
                    Intrinsics.checkExpressionValueIsNotNull(c2, "HiidoReport.getInstance(…yEntrancePage\", response)");
                    int i2 = a.b.f67709b;
                    String str2 = cVar.f67717g;
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                    iReporter.reportReturnCode(i2, c2, Long.parseLong(str2), cVar.f67712b.toString());
                }
            }
        }
    }

    @Override // d.r.b.a.a.i.f.a
    public void b(a.c cVar) {
        IReporter iReporter = this.f67876a;
        if (iReporter != null) {
            d.r.b.a.a.f.f.a a2 = d.r.b.a.a.f.f.a.a();
            Intrinsics.checkExpressionValueIsNotNull(a2, "HiidoReport.getInstance()");
            if (a2.d()) {
                d.r.b.a.a.f.f.a a3 = d.r.b.a.a.f.f.a.a();
                Intrinsics.checkExpressionValueIsNotNull(a3, "HiidoReport.getInstance()");
                if (a3.d()) {
                    Map<String, String> h2 = h(cVar);
                    String str = a.b.f67708a;
                    Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                    iReporter.reportStatisticContent(str, h2);
                    String c2 = d.r.b.a.a.f.f.a.a().c("onQueryProductList", cVar);
                    Intrinsics.checkExpressionValueIsNotNull(c2, "HiidoReport.getInstance(…ryProductList\", response)");
                    int i2 = a.b.f67709b;
                    String str2 = cVar.f67717g;
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                    iReporter.reportReturnCode(i2, c2, Long.parseLong(str2), cVar.f67712b.toString());
                }
            }
        }
    }

    @Override // d.r.b.a.a.i.f.a
    public void c(a.c cVar) {
    }

    @Override // d.r.b.a.a.i.f.a
    public void d(a.c cVar) {
        IReporter iReporter = this.f67876a;
        if (iReporter != null) {
            d.r.b.a.a.f.f.a a2 = d.r.b.a.a.f.f.a.a();
            Intrinsics.checkExpressionValueIsNotNull(a2, "HiidoReport.getInstance()");
            if (a2.d()) {
                d.r.b.a.a.f.f.a a3 = d.r.b.a.a.f.f.a.a();
                Intrinsics.checkExpressionValueIsNotNull(a3, "HiidoReport.getInstance()");
                if (a3.d()) {
                    Map<String, String> h2 = h(cVar);
                    String str = a.b.f67708a;
                    Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                    iReporter.reportStatisticContent(str, h2);
                    String b2 = d.r.b.a.a.f.f.a.a().b("Purchase", cVar);
                    Intrinsics.checkExpressionValueIsNotNull(b2, "HiidoReport.getInstance(…Uri(\"Purchase\", response)");
                    int i2 = a.b.f67710c;
                    String str2 = cVar.f67717g;
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                    iReporter.reportReturnCode(i2, b2, Long.parseLong(str2), cVar.f67712b.toString());
                }
            }
        }
    }

    @Override // d.r.b.a.a.i.f.a
    public void e(a.c cVar) {
    }

    @Override // d.r.b.a.a.i.f.a
    public void f(a.c cVar) {
        IReporter iReporter = this.f67876a;
        if (iReporter != null) {
            d.r.b.a.a.f.f.a a2 = d.r.b.a.a.f.f.a.a();
            Intrinsics.checkExpressionValueIsNotNull(a2, "HiidoReport.getInstance()");
            if (a2.d()) {
                d.r.b.a.a.f.f.a a3 = d.r.b.a.a.f.f.a.a();
                Intrinsics.checkExpressionValueIsNotNull(a3, "HiidoReport.getInstance()");
                if (a3.d()) {
                    Map<String, String> h2 = h(cVar);
                    String str = a.b.f67708a;
                    Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                    iReporter.reportStatisticContent(str, h2);
                    String c2 = d.r.b.a.a.f.f.a.a().c("onRequestPay", cVar);
                    Intrinsics.checkExpressionValueIsNotNull(c2, "HiidoReport.getInstance(…\"onRequestPay\", response)");
                    iReporter.reportCount(a.b.f67709b, c2, "request_pay", 1L);
                }
            }
        }
    }

    @Override // d.r.b.a.a.i.f.a
    public void g(a.c cVar) {
        IReporter iReporter = this.f67876a;
        if (iReporter != null) {
            d.r.b.a.a.f.f.a a2 = d.r.b.a.a.f.f.a.a();
            Intrinsics.checkExpressionValueIsNotNull(a2, "HiidoReport.getInstance()");
            if (a2.d()) {
                d.r.b.a.a.f.f.a a3 = d.r.b.a.a.f.f.a.a();
                Intrinsics.checkExpressionValueIsNotNull(a3, "HiidoReport.getInstance()");
                if (a3.d()) {
                    Map<String, String> h2 = h(cVar);
                    String str = a.b.f67708a;
                    Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                    iReporter.reportStatisticContent(str, h2);
                    String c2 = d.r.b.a.a.f.f.a.a().c("onOrderResult", cVar);
                    Intrinsics.checkExpressionValueIsNotNull(c2, "HiidoReport.getInstance(…onOrderResult\", response)");
                    int i2 = a.b.f67709b;
                    String str2 = cVar.f67717g;
                    Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                    iReporter.reportReturnCode(i2, c2, Long.parseLong(str2), cVar.f67712b.toString());
                }
            }
        }
    }

    public final Map<String, String> h(a.c cVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("uid", String.valueOf(cVar.f67714d));
        linkedHashMap.put("paysource", String.valueOf(cVar.f67715e));
        linkedHashMap.put("code", cVar.f67712b.toString());
        linkedHashMap.put("msg", cVar.f67713c.toString());
        linkedHashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, "0");
        linkedHashMap.put("clientver", this.f67877b);
        String str = a.c.t;
        Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportResponse.mCountry");
        linkedHashMap.put("country", str);
        linkedHashMap.put("sdkver", "4.1.4-bdpay");
        String str2 = cVar.f67718h;
        Intrinsics.checkExpressionValueIsNotNull(str2, "response.mOrderId");
        linkedHashMap.put("orderid", str2);
        String str3 = cVar.f67711a;
        Intrinsics.checkExpressionValueIsNotNull(str3, "response.mEventId");
        linkedHashMap.put("eventid", str3);
        String str4 = cVar.f67716f;
        Intrinsics.checkExpressionValueIsNotNull(str4, "response.mEventaliae");
        linkedHashMap.put("eventaliae", str4);
        String str5 = cVar.f67717g;
        Intrinsics.checkExpressionValueIsNotNull(str5, "response.mDelay");
        linkedHashMap.put("delay", str5);
        String str6 = cVar.f67719i;
        Intrinsics.checkExpressionValueIsNotNull(str6, "response.mGPOrderId");
        linkedHashMap.put("gporderid", str6);
        String str7 = cVar.j;
        Intrinsics.checkExpressionValueIsNotNull(str7, "response.mPurchaseTime");
        linkedHashMap.put("purchasetime", str7);
        String str8 = cVar.k;
        Intrinsics.checkExpressionValueIsNotNull(str8, "response.mServiceName");
        linkedHashMap.put("servicename", str8);
        String str9 = cVar.l;
        Intrinsics.checkExpressionValueIsNotNull(str9, "response.mFunctionName");
        linkedHashMap.put("functionname", str9);
        String str10 = cVar.m;
        Intrinsics.checkExpressionValueIsNotNull(str10, "response.mPageId");
        linkedHashMap.put("payentranceid", str10);
        String str11 = cVar.n;
        Intrinsics.checkExpressionValueIsNotNull(str11, "response.mConfigTraceId");
        linkedHashMap.put("configtraceid", str11);
        String str12 = cVar.o;
        Intrinsics.checkExpressionValueIsNotNull(str12, "response.mPayTraceId");
        linkedHashMap.put("paytraceid", str12);
        return linkedHashMap;
    }
}
