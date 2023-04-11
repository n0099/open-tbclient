package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.m7b;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, m7b m7bVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, m7b m7bVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, m7b m7bVar);
}
