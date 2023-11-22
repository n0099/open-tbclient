package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.b8d;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, b8d b8dVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, b8d b8dVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, b8d b8dVar);
}
