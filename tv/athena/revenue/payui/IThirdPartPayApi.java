package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.s2a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, s2a s2aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, s2a s2aVar);
}
