package tv.athena.revenue.payui.model;

import android.app.Activity;
import androidx.annotation.Keep;
import com.baidu.tieba.l7b;
import com.baidu.tieba.n7b;
import com.yy.mobile.framework.revenuesdk.payapi.PayType;
import java.util.List;
import java.util.Map;
import tv.athena.revenue.payui.view.AbsViewEventHandler;
@Keep
/* loaded from: classes9.dex */
public class ThirdPartPayDialogParams {
    public Activity act;
    public Map<String, String> appClientExpand;
    public PayType defaultType;
    public List<Object> payDiscountList;
    public String payWayDialogTitle;
    public double targetAmount;
    public l7b thirdPartOrderRequest;
    public n7b thirdPartToYYPayRequest;
    public AbsViewEventHandler viewEventListener;

    public String toString() {
        return "ThirdPartPayDialogParams{act=" + this.act + "defaultType=" + this.defaultType + "appClientExpand=" + this.appClientExpand + ", payWayDialogTitle=" + this.payWayDialogTitle + ", targetAmount=" + this.targetAmount + ", thirdPartPayToYYPayRequest=" + this.thirdPartToYYPayRequest + ", payDiscountList=" + this.payDiscountList + ", thirdPartOrderRequest='" + this.thirdPartOrderRequest + "'}";
    }
}
