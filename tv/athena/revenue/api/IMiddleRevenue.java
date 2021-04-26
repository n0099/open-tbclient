package tv.athena.revenue.api;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.IRevenue;
import kotlin.Metadata;
import tv.athena.revenue.api.pay.IMiddlePayService;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\u00020\u00012\u00020\u0002J\u000f\u0010\u0004\u001a\u00020\u0003H&¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Ltv/athena/revenue/api/IMiddleRevenue;", "Lcom/yy/mobile/framework/revenuesdk/IRevenue;", "Lkotlin/Any;", "Ltv/athena/revenue/api/pay/IMiddlePayService;", "getMiddlePayService", "()Ltv/athena/revenue/api/pay/IMiddlePayService;", "revenue-wrapper_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes7.dex */
public interface IMiddleRevenue extends IRevenue {
    IMiddlePayService getMiddlePayService();
}
