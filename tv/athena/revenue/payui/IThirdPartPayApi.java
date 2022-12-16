package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.i9a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, i9a i9aVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, i9a i9aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, i9a i9aVar);
}
