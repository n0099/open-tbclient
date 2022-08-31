package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.y0a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, y0a y0aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, y0a y0aVar);
}
