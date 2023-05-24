package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.sdb;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, sdb sdbVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, sdb sdbVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, sdb sdbVar);
}
