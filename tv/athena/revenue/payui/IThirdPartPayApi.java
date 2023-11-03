package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.a8d;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, a8d a8dVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, a8d a8dVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, a8d a8dVar);
}
