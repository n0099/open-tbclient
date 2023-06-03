package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.ssb;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, ssb ssbVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, ssb ssbVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, ssb ssbVar);
}
