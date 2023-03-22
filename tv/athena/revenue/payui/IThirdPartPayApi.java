package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.vxa;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, vxa vxaVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, vxa vxaVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, vxa vxaVar);
}
