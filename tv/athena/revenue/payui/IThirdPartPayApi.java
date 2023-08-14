package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.l7c;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, l7c l7cVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, l7c l7cVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, l7c l7cVar);
}
