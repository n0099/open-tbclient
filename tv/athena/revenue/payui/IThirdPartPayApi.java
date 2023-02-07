package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.aja;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, aja ajaVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, aja ajaVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, aja ajaVar);
}
