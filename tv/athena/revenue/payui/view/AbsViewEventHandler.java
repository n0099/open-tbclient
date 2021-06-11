package tv.athena.revenue.payui.view;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import kotlin.Metadata;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
@Keep
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0019\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0019\u0010\t\u001a\u00020\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0007H\u0016¢\u0006\u0004\b\t\u0010\nJ\u0019\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0004\b\u000e\u0010\u000fJ\u0019\u0010\u0012\u001a\u00020\u00042\b\u0010\u0011\u001a\u0004\u0018\u00010\u0010H\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0016"}, d2 = {"Ltv/athena/revenue/payui/view/AbsViewEventHandler;", "Ltv/athena/revenue/payui/view/IViewEventListener;", "Lcom/yy/mobile/framework/revenuesdk/payapi/bean/BannerConfigItem$BannerInfo;", "bannerInfo", "", "onBannerClick", "(Lcom/yy/mobile/framework/revenuesdk/payapi/bean/BannerConfigItem$BannerInfo;)V", "", "params", "onHandleUrl", "(Ljava/lang/String;)V", "Ltv/athena/revenue/payui/model/PayViewInfo;", "payViewInfo", "", "onInterceptView", "(Ltv/athena/revenue/payui/model/PayViewInfo;)Z", "Ltv/athena/revenue/payui/view/dialog/PayDialogType;", "payDialogType", "onViewStateChange", "(Ltv/athena/revenue/payui/view/dialog/PayDialogType;)V", "<init>", "()V", "payui_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes8.dex */
public abstract class AbsViewEventHandler implements IViewEventListener {
    @Override // tv.athena.revenue.payui.view.IViewEventListener
    public void onBannerClick(BannerConfigItem.BannerInfo bannerInfo) {
    }

    @Override // tv.athena.revenue.payui.view.IViewEventListener
    public void onHandleUrl(String str) {
    }

    @Override // tv.athena.revenue.payui.view.IViewEventListener
    public boolean onInterceptView(PayViewInfo payViewInfo) {
        return false;
    }

    @Override // tv.athena.revenue.payui.view.IViewEventListener
    public void onViewStateChange(PayDialogType payDialogType) {
    }
}
