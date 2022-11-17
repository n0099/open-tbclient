package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.z5a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, z5a z5aVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, z5a z5aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, z5a z5aVar);
}
