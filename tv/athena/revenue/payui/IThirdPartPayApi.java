package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.fdd;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, fdd fddVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, fdd fddVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, fdd fddVar);
}
