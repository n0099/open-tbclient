package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.yic;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, yic yicVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, yic yicVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, yic yicVar);
}
