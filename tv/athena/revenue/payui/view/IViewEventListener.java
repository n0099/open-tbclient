package tv.athena.revenue.payui.view;

import androidx.annotation.Keep;
import com.yy.mobile.framework.revenuesdk.payapi.bean.BannerConfigItem;
import tv.athena.revenue.payui.model.PayViewInfo;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
@Keep
/* loaded from: classes2.dex */
public interface IViewEventListener {
    void onBannerClick(BannerConfigItem.BannerInfo bannerInfo);

    void onHandleUrl(String str);

    boolean onInterceptView(PayViewInfo payViewInfo);

    void onViewStateChange(PayDialogType payDialogType);
}
