package com.yy.mobile.framework.revenuesdk.baseapi.reporter;

import com.yy.mobile.framework.revenuesdk.statistics.hiido.payflow.PayFlowContent;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.uievent.PayUiEventContent;
import kotlin.Metadata;
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\r\bf\u0018\u00002\u00020\u0001J_\u0010\f\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0004\u001a\u0004\u0018\u00010\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u00022\b\u0010\u0006\u001a\u0004\u0018\u00010\u00022\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u00022\b\u0010\n\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\f\u0010\rJ\u0019\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u000fJ#\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H&¢\u0006\u0004\b\u000e\u0010\u0011J5\u0010\u0016\u001a\u00020\u000b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00022\b\u0010\u0013\u001a\u0004\u0018\u00010\u00022\b\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0015\u001a\u00020\u0002H&¢\u0006\u0004\b\u0016\u0010\u0017¨\u0006\u0018"}, d2 = {"Lcom/yy/mobile/framework/revenuesdk/baseapi/reporter/IEventReporter;", "Lkotlin/Any;", "", "event", "code", "msg", PayFlowContent.ORDERID, PayFlowContent.PURCHASETIME, PayFlowContent.PRODUCTID, PayFlowContent.PAYENTRANCEID, PayFlowContent.PAYTRACEID, "", "reportPayFlow", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "reportUiEvent", "(Ljava/lang/String;)V", PayUiEventContent.AMOUNT, "(Ljava/lang/String;Ljava/lang/String;)V", "actType", "payChannel", "payMethod", "cid", "reportUvEvent", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "paybaseapi_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public interface IEventReporter {
    void reportPayFlow(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8);

    void reportUiEvent(String str);

    void reportUiEvent(String str, String str2);

    void reportUvEvent(String str, String str2, String str3, String str4);
}
