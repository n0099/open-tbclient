package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.xcc;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, xcc xccVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, xcc xccVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, xcc xccVar);
}
