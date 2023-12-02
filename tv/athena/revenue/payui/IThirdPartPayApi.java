package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.edd;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, edd eddVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, edd eddVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, edd eddVar);
}
