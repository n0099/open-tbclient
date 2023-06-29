package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.kzb;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, kzb kzbVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, kzb kzbVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, kzb kzbVar);
}
