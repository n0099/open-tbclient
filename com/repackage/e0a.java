package com.repackage;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import tv.athena.revenue.payui.YYPayUIKit;
import tv.athena.revenue.payui.model.PayFlowType;
import tv.athena.revenue.payui.view.dialog.PayDialogType;
/* loaded from: classes5.dex */
public class e0a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(String str, int i, int i2, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65536, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), payFlowType}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayFlowLifecycleHandler", "notifyPayFlowWork error payUIKit null", new Object[0]);
                return;
            }
            u0a payFlowLifecycle = uIKit.getPayFlowLifecycle();
            boolean z = payFlowLifecycle != null;
            RLog.info("PayFlowLifecycleHandler", "notifyPayActivityDestory  payFlowType:" + payFlowType + " shouldNotify:" + z);
            if (z) {
                payFlowLifecycle.b(str, payFlowType);
            }
        }
    }

    public static void b(String str, int i, int i2, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65537, null, new Object[]{str, Integer.valueOf(i), Integer.valueOf(i2), payFlowType}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayFlowLifecycleHandler", "notifyPayFlowWork error payUIKit null", new Object[0]);
                return;
            }
            u0a payFlowLifecycle = uIKit.getPayFlowLifecycle();
            boolean z = payFlowLifecycle != null;
            RLog.info("PayFlowLifecycleHandler", "notifyPayActivityVisit  payFlowType:" + payFlowType + " shouldNotify:" + z);
            if (z) {
                payFlowLifecycle.c(str, payFlowType);
            }
        }
    }

    public static void c(int i, int i2, PayFlowType payFlowType, PayDialogType payDialogType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65538, null, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), payFlowType, payDialogType}) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayFlowLifecycleHandler", "notifyPayDialogTypeChange error payUIKit null", new Object[0]);
                return;
            }
            u0a payFlowLifecycle = uIKit.getPayFlowLifecycle();
            boolean z = payFlowLifecycle != null;
            RLog.info("PayFlowLifecycleHandler", "notifyPayDialogTypeChange mPayFlowType:" + payFlowType + " shouldNotify:" + z);
            if (z) {
                payFlowLifecycle.d(payFlowType, payDialogType);
            }
        }
    }

    public static void d(int i, int i2, PayFlowType payFlowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65539, null, i, i2, payFlowType) == null) {
            YYPayUIKit uIKit = YYPayUIKit.getUIKit(i, i2);
            if (uIKit == null) {
                RLog.error("PayFlowLifecycleHandler", "notifyPayFlowWork error payUIKit null", new Object[0]);
                return;
            }
            u0a payFlowLifecycle = uIKit.getPayFlowLifecycle();
            boolean z = payFlowLifecycle != null;
            RLog.info("PayFlowLifecycleHandler", "notifyPayFlowWork mPayFlowType:" + payFlowType + " shouldNotify:" + z);
            if (z) {
                payFlowLifecycle.a(payFlowType);
            }
        }
    }
}
