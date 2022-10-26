package tv.athena.revenue.payui.view;

import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes9.dex */
public interface IViewEventListener {
    void onBannerClick(BannerConfigItem.BannerInfo bannerInfo);

    void onHandleUrl(String str);

    boolean onInterceptView(PayViewInfo payViewInfo);

    void onPayInfo(int i, String str);

    void onViewStateChange(PayDialogType payDialogType);
}
