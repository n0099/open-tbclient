package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.i5a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, i5a i5aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, i5a i5aVar);
}
