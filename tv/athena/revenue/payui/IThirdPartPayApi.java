package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.qub;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, qub qubVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, qub qubVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, qub qubVar);
}
