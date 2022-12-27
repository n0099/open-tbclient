package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.j9a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, j9a j9aVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, j9a j9aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, j9a j9aVar);
}
