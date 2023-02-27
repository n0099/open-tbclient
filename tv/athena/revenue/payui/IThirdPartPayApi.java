package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.zsa;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, zsa zsaVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, zsa zsaVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, zsa zsaVar);
}
