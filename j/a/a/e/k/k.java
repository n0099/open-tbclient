package j.a.a.e.k;

import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.yy.mobile.framework.revenuesdk.baseapi.log.RLog;
import com.yy.mobile.framework.revenuesdk.statistics.hiido.eventtype.UiEventType;
import tv.athena.revenue.payui.view.dialog.CancelType;
/* loaded from: classes3.dex */
public class k {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static void a(int i2, int i3, CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65536, null, i2, i3, cancelType) == null) {
            if (cancelType == CancelType.BUTTOM_AREA_CLICK) {
                j.a.a.e.m.b.b(i2, i3, UiEventType.purchaseclose_bt);
                RLog.info("PayDialogStatistic", UiEventType.purchaseclose_bt);
            } else if (cancelType == CancelType.EMPTY_AREA_CLICK) {
                j.a.a.e.m.b.b(i2, i3, UiEventType.purchaseclose_transparent);
                RLog.info("PayDialogStatistic", UiEventType.purchaseclose_transparent);
            }
        }
    }

    public static void b(int i2, int i3, CancelType cancelType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(65537, null, i2, i3, cancelType) == null) {
            if (cancelType == CancelType.BUTTOM_AREA_CLICK) {
                j.a.a.e.m.b.b(i2, i3, UiEventType.paypageclose_bt);
                RLog.info("PayDialogStatistic", UiEventType.paypageclose_bt);
            } else if (cancelType == CancelType.EMPTY_AREA_CLICK) {
                j.a.a.e.m.b.b(i2, i3, UiEventType.paypageclose_transparent);
                RLog.info("PayDialogStatistic", UiEventType.paypageclose_transparent);
            }
        }
    }
}
