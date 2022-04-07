package tv.athena.revenue.payui.view;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.payservice.impl.H5PayConstant;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes9.dex */
public abstract class AbsPayMessageReceiver extends BroadcastReceiver {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final String TAG;
    public long mCreateNanoTime;
    public PayFlowType mPayFlowType;

    public AbsPayMessageReceiver(PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {payFlowType};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.TAG = "AbsPayMessageReceiver";
        this.mPayFlowType = payFlowType;
        this.mCreateNanoTime = System.nanoTime();
        RLog.info("AbsPayMessageReceiver", "create AbsPayMessageReceiver mPayFlowType:" + this.mPayFlowType + " mCreateNanoTime:" + this.mCreateNanoTime);
    }

    private void checkReleaseAllView(String str, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, this, str, intent) == null) {
            long longExtra = intent.getLongExtra(H5PayConstant.EXTRA_PAY_FLOW_VIEW_RELEASE_NANO_TIME, 0L);
            boolean z = longExtra == 0 || longExtra > this.mCreateNanoTime;
            RLog.info("AbsPayMessageReceiver", "checkReleaseAllView action:" + str + " mPayFlowType:" + this.mPayFlowType + " releaseNanoTime:" + longExtra + " mCreateNanoTime:" + this.mCreateNanoTime + " release:" + z);
            if (z) {
                onAllPayFlowViewRelease();
            }
        }
    }

    private void checkReleaseDialogPayFlowView(String str, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65538, this, str, intent) == null) {
            if (this.mPayFlowType == PayFlowType.DIOALOG_PAY_FLOW) {
                long longExtra = intent.getLongExtra(H5PayConstant.EXTRA_PAY_FLOW_VIEW_RELEASE_NANO_TIME, 0L);
                boolean z = longExtra == 0 || longExtra > this.mCreateNanoTime;
                RLog.info("AbsPayMessageReceiver", "checkReleaseDialogPayFlowView action:" + str + " mPayFlowType:" + this.mPayFlowType + " releaseNanoTime:" + longExtra + " mCreateNanoTime:" + this.mCreateNanoTime + " release:" + z);
                if (z) {
                    onDialogPayFlowViewRelease();
                    return;
                }
                return;
            }
            RLog.info("AbsPayMessageReceiver", "checkReleaseDialogPayFlowView action:" + str + " mPayFlowType:" + this.mPayFlowType + " release nothing");
        }
    }

    private void checkReleaseWalletPayFlowView(String str, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65539, this, str, intent) == null) {
            if (this.mPayFlowType == PayFlowType.WALLET_PAY_FLOW) {
                long longExtra = intent.getLongExtra(H5PayConstant.EXTRA_PAY_FLOW_VIEW_RELEASE_NANO_TIME, 0L);
                boolean z = longExtra == 0 || longExtra > this.mCreateNanoTime;
                RLog.info("AbsPayMessageReceiver", "checkReleaseWalletPayFlowView action:" + str + " mPayFlowType:" + this.mPayFlowType + " releaseNanoTime:" + longExtra + " mCreateNanoTime:" + this.mCreateNanoTime + " release:" + z);
                if (z) {
                    onWalletPayFlowViewRelease();
                    return;
                }
                return;
            }
            RLog.info("AbsPayMessageReceiver", "checkReleaseWalletPayFlowView action:" + str + " mPayFlowType:" + this.mPayFlowType + " release nothing");
        }
    }

    public abstract void onAllPayFlowViewRelease();

    public abstract void onDialogPayFlowViewRelease();

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, context, intent) == null) {
            String action = intent != null ? intent.getAction() : "";
            RLog.info("AbsPayMessageReceiver", "onReceive action:" + action + " mPayFlowType:" + this.mPayFlowType);
            if ("tv.athena.revenue.payui.release_all_pay_flow_ui_action".equals(action)) {
                checkReleaseAllView(action, intent);
            } else if ("tv.athena.revenue.payui.release_all_pay_dialog_flow_ui_action".equals(action)) {
                checkReleaseDialogPayFlowView(action, intent);
            } else if ("tv.athena.revenue.payui.release_all_pay_wallet_flow_ui_action".equals(action)) {
                checkReleaseWalletPayFlowView(action, intent);
            }
        }
    }

    public abstract void onWalletPayFlowViewRelease();
}
