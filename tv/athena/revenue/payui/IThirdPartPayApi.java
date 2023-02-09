package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.eka;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, eka ekaVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, eka ekaVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, eka ekaVar);
}
