package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.k7c;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, k7c k7cVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, k7c k7cVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, k7c k7cVar);
}
