package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.bec;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, bec becVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, bec becVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, bec becVar);
}
