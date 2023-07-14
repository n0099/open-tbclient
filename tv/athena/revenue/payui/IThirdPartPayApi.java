package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.h8c;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, h8c h8cVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, h8c h8cVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, h8c h8cVar);
}
