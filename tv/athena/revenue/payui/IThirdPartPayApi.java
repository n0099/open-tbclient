package tv.athena.revenue.payui;

import com.baidu.tieba.z3a;
import tv.athena.revenue.payui.model.ThirdPartPayDialogParams;
import tv.athena.revenue.payui.model.ThirdPartPayParams;
/* loaded from: classes9.dex */
public interface IThirdPartPayApi {
    void release();

    void startPayDialog(ThirdPartPayDialogParams thirdPartPayDialogParams, z3a z3aVar);

    void startPlay(ThirdPartPayParams thirdPartPayParams, z3a z3aVar);
}
