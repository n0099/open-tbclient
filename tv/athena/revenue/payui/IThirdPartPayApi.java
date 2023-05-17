package tv.athena.revenue.payui;

import androidx.annotation.Keep;
import com.baidu.tieba.rdb;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
@Keep
/* loaded from: classes2.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, rdb rdbVar);

    void startPayDialogV2(ThirdPartPayDialogParams thirdPartPayDialogParams, rdb rdbVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, rdb rdbVar);
}
