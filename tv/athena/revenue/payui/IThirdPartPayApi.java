package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.sbb;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, sbb sbbVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, sbb sbbVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, sbb sbbVar);
}
