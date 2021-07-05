package com.yy.mobile.framework.revenuesdk.payservice.reporter;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.down.retry.HttpRetryStrategyDataParse;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.gslbsdk.db.DelayTB;
import com.yy.hiidostatis.inner.BaseStatisContent;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.HiidoReport;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.IReporter;
import com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter;
import com.yy.mobile.framework.revenuesdk.paybaseapi.BuildConfig;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.BaseHiidoContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.payflow.PayFlowContent;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010%\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B!\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e\u0012\u0006\u0010\u001c\u001a\u00020\u0012\u0012\u0006\u0010\u001d\u001a\u00020\u0012¢\u0006\u0004\b!\u0010\"J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\u0006J\u0017\u0010\t\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\t\u0010\u0006J\u0017\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\n\u0010\u0006J\u0017\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000b\u0010\u0006J\u0017\u0010\f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\f\u0010\u0006J\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\r\u0010\u0006J\u0017\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000e\u0010\u0006J\u0017\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u000f\u0010\u0006J\u0017\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0010\u0010\u0006J\u0017\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0011\u0010\u0006J+\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J#\u0010\u0018\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00142\u0006\u0010\u0003\u001a\u00020\u0002H\u0002¢\u0006\u0004\b\u0018\u0010\u0019R\u0016\u0010\u001a\u001a\u00020\u00128\u0002@\u0002X\u0082D¢\u0006\u0006\n\u0004\b\u001a\u0010\u001bR\u0016\u0010\u001c\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001c\u0010\u001bR\u0016\u0010\u001d\u001a\u00020\u00128\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u001e8\u0002@\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001f\u0010 ¨\u0006#"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/payservice/reporter/DefaultPayReporter;", "Lcom/yy/mobile/framework/revenuesdk/payapi/reporter/IPayReporter;", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportResponse;", "response", "", "onDoHangJob", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportResponse;)V", "onDoHangJobByProductId", "onOrderResult", "onPayEntrancePage", "onPayResult", "onPayStart", "onPurchaseReportResult", "onPurchaseSummaryResult", "onQueryChargeOrderStatus", "onQueryProductList", "onQueryUserYbDetails", "onRequestPay", "", "act", "", "map", "reportInternal", "(Ljava/lang/String;Ljava/util/Map;)V", "responseToMap", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/HiidoReport$CReportResponse;)Ljava/util/Map;", "TAG", "Ljava/lang/String;", "clientVer", "country", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;", "iReporter", "Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;", "<init>", "(Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IReporter;Ljava/lang/String;Ljava/lang/String;)V", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public final class DefaultPayReporter implements IPayReporter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public final String clientVer;
    public final String country;
    public final IReporter iReporter;

    public DefaultPayReporter(IReporter iReporter, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {iReporter, str, str2};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.iReporter = iReporter;
        this.clientVer = str;
        this.country = str2;
        this.TAG = "DefaultPayReporter";
    }

    private final void reportInternal(String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, str, map) == null) {
        }
    }

    private final Map<String, String> responseToMap(HiidoReport.CReportResponse cReportResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, this, cReportResponse)) == null) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            linkedHashMap.put("uid", String.valueOf(cReportResponse.mUid));
            linkedHashMap.put("paysource", String.valueOf(cReportResponse.mPaysource));
            linkedHashMap.put("code", cReportResponse.mErrCode.toString());
            linkedHashMap.put("msg", cReportResponse.mErrMsg.toString());
            linkedHashMap.put(HttpRetryStrategyDataParse.DOWNFLOW_RETRY_REQUEST_PARAM, "0");
            linkedHashMap.put(BaseHiidoContent.CLIENTVER, this.clientVer);
            String str = HiidoReport.CReportResponse.mCountry;
            Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportResponse.mCountry");
            linkedHashMap.put("country", str);
            linkedHashMap.put(BaseStatisContent.SDKVER, BuildConfig.VERSION_NAME);
            String str2 = cReportResponse.mOrderId;
            Intrinsics.checkExpressionValueIsNotNull(str2, "response.mOrderId");
            linkedHashMap.put("orderid", str2);
            String str3 = cReportResponse.mEventId;
            Intrinsics.checkExpressionValueIsNotNull(str3, "response.mEventId");
            linkedHashMap.put("eventid", str3);
            String str4 = cReportResponse.mEventaliae;
            Intrinsics.checkExpressionValueIsNotNull(str4, "response.mEventaliae");
            linkedHashMap.put("eventaliae", str4);
            String str5 = cReportResponse.mDelay;
            Intrinsics.checkExpressionValueIsNotNull(str5, "response.mDelay");
            linkedHashMap.put(DelayTB.DELAY, str5);
            String str6 = cReportResponse.mGPOrderId;
            Intrinsics.checkExpressionValueIsNotNull(str6, "response.mGPOrderId");
            linkedHashMap.put("gporderid", str6);
            String str7 = cReportResponse.mPurchaseTime;
            Intrinsics.checkExpressionValueIsNotNull(str7, "response.mPurchaseTime");
            linkedHashMap.put(PayFlowContent.PURCHASETIME, str7);
            String str8 = cReportResponse.mServiceName;
            Intrinsics.checkExpressionValueIsNotNull(str8, "response.mServiceName");
            linkedHashMap.put("servicename", str8);
            String str9 = cReportResponse.mFunctionName;
            Intrinsics.checkExpressionValueIsNotNull(str9, "response.mFunctionName");
            linkedHashMap.put("functionname", str9);
            String str10 = cReportResponse.mPageId;
            Intrinsics.checkExpressionValueIsNotNull(str10, "response.mPageId");
            linkedHashMap.put(PayFlowContent.PAYENTRANCEID, str10);
            String str11 = cReportResponse.mConfigTraceId;
            Intrinsics.checkExpressionValueIsNotNull(str11, "response.mConfigTraceId");
            linkedHashMap.put("configtraceid", str11);
            String str12 = cReportResponse.mPayTraceId;
            Intrinsics.checkExpressionValueIsNotNull(str12, "response.mPayTraceId");
            linkedHashMap.put(PayFlowContent.PAYTRACEID, str12);
            return linkedHashMap;
        }
        return (Map) invokeL.objValue;
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onDoHangJob(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String uri = HiidoReport.getInstance().getUri("onDoHangJob", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(uri, "HiidoReport.getInstance(…(\"onDoHangJob\", response)");
                int i2 = HiidoReport.CReportParam.INTER_SCODE;
                String str2 = cReportResponse.mDelay;
                Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                iReporter.reportReturnCode(i2, uri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onDoHangJobByProductId(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String summaryUri = HiidoReport.getInstance().getSummaryUri("DoHangJob", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(summaryUri, "HiidoReport.getInstance(…ri(\"DoHangJob\", response)");
                int i2 = HiidoReport.CReportParam.SUMMARY_SCODE;
                String str2 = cReportResponse.mDelay;
                Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                iReporter.reportReturnCode(i2, summaryUri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onOrderResult(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String uri = HiidoReport.getInstance().getUri("onOrderResult", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(uri, "HiidoReport.getInstance(…onOrderResult\", response)");
                int i2 = HiidoReport.CReportParam.INTER_SCODE;
                String str2 = cReportResponse.mDelay;
                Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                iReporter.reportReturnCode(i2, uri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onPayEntrancePage(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048579, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String uri = HiidoReport.getInstance().getUri("onPayEntrancePage", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(uri, "HiidoReport.getInstance(…yEntrancePage\", response)");
                int i2 = HiidoReport.CReportParam.INTER_SCODE;
                String str2 = cReportResponse.mDelay;
                Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                iReporter.reportReturnCode(i2, uri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onPayResult(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048580, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String uri = HiidoReport.getInstance().getUri("onPayResult", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(uri, "HiidoReport.getInstance(…(\"onPayResult\", response)");
                int i2 = HiidoReport.CReportParam.INTER_SCODE;
                String str2 = cReportResponse.mDelay;
                Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                iReporter.reportReturnCode(i2, uri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onPayStart(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String uri = HiidoReport.getInstance().getUri("onPayStart", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(uri, "HiidoReport.getInstance(…i(\"onPayStart\", response)");
                iReporter.reportCount(HiidoReport.CReportParam.INTER_SCODE, uri, "pay_start", 1L);
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onPurchaseReportResult(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String uri = HiidoReport.getInstance().getUri("onPurchaseReportResult", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(uri, "HiidoReport.getInstance(…eReportResult\", response)");
                int i2 = HiidoReport.CReportParam.INTER_SCODE;
                String str2 = cReportResponse.mDelay;
                Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                iReporter.reportReturnCode(i2, uri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onPurchaseSummaryResult(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048583, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String summaryUri = HiidoReport.getInstance().getSummaryUri("Purchase", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(summaryUri, "HiidoReport.getInstance(…Uri(\"Purchase\", response)");
                int i2 = HiidoReport.CReportParam.SUMMARY_SCODE;
                String str2 = cReportResponse.mDelay;
                Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                iReporter.reportReturnCode(i2, summaryUri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onQueryChargeOrderStatus(HiidoReport.CReportResponse cReportResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, cReportResponse) == null) {
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onQueryProductList(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048585, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String uri = HiidoReport.getInstance().getUri("onQueryProductList", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(uri, "HiidoReport.getInstance(…ryProductList\", response)");
                int i2 = HiidoReport.CReportParam.INTER_SCODE;
                String str2 = cReportResponse.mDelay;
                Intrinsics.checkExpressionValueIsNotNull(str2, "(response.mDelay)");
                iReporter.reportReturnCode(i2, uri, Long.parseLong(str2), cReportResponse.mErrCode.toString());
            }
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onQueryUserYbDetails(HiidoReport.CReportResponse cReportResponse) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cReportResponse) == null) {
        }
    }

    @Override // com.yy.mobile.framework.revenuesdk.payapi.reporter.IPayReporter
    public void onRequestPay(HiidoReport.CReportResponse cReportResponse) {
        IReporter iReporter;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048587, this, cReportResponse) == null) || (iReporter = this.iReporter) == null) {
            return;
        }
        HiidoReport hiidoReport = HiidoReport.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(hiidoReport, "HiidoReport.getInstance()");
        if (hiidoReport.isReportByRandomRatio()) {
            HiidoReport hiidoReport2 = HiidoReport.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(hiidoReport2, "HiidoReport.getInstance()");
            if (hiidoReport2.isReportByRandomRatio()) {
                Map<String, String> responseToMap = responseToMap(cReportResponse);
                String str = HiidoReport.CReportParam.ACT;
                Intrinsics.checkExpressionValueIsNotNull(str, "HiidoReport.CReportParam.ACT");
                iReporter.reportStatisticContent(str, responseToMap);
                String uri = HiidoReport.getInstance().getUri("onRequestPay", cReportResponse);
                Intrinsics.checkExpressionValueIsNotNull(uri, "HiidoReport.getInstance(…\"onRequestPay\", response)");
                iReporter.reportCount(HiidoReport.CReportParam.INTER_SCODE, uri, "request_pay", 1L);
            }
        }
    }
}
