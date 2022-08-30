package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.a1a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, a1a a1aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, a1a a1aVar);
}
