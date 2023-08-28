package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.dec;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, dec decVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, dec decVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, dec decVar);
}
