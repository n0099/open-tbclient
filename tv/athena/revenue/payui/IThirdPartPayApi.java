package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.xsb;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, xsb xsbVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, xsb xsbVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, xsb xsbVar);
}
