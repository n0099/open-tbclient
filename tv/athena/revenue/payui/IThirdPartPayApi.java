package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.ghc;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, ghc ghcVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, ghc ghcVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, ghc ghcVar);
}
