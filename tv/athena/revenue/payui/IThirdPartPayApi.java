package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.u7b;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, u7b u7bVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, u7b u7bVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, u7b u7bVar);
}
