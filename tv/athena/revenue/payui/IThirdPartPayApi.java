package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.rea;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, rea reaVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, rea reaVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, rea reaVar);
}
