package tv.athena.revenue.payui.view;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.m1a;
import com.repackage.m2a;
import com.repackage.p1a;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PayWayInfo;
import java.util.List;
import tv.athena.revenue.api.pay.params.AppCustomExpand;
import tv.athena.revenue.payui.model.PayFlowType;
/* loaded from: classes8.dex */
public interface IYYPayWayView extends m2a {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes8.dex */
    public static final class PayViewState {
        public static final /* synthetic */ PayViewState[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final PayViewState SELECTING_VIEW_STATE;
        public static final PayViewState WAITING_VIEW_STATE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-724888369, "Ltv/athena/revenue/payui/view/IYYPayWayView$PayViewState;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-724888369, "Ltv/athena/revenue/payui/view/IYYPayWayView$PayViewState;");
                    return;
                }
            }
            SELECTING_VIEW_STATE = new PayViewState("SELECTING_VIEW_STATE", 0);
            PayViewState payViewState = new PayViewState("WAITING_VIEW_STATE", 1);
            WAITING_VIEW_STATE = payViewState;
            $VALUES = new PayViewState[]{SELECTING_VIEW_STATE, payViewState};
        }

        public PayViewState(String str, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static PayViewState valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (PayViewState) Enum.valueOf(PayViewState.class, str) : (PayViewState) invokeL.objValue;
        }

        public static PayViewState[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (PayViewState[]) $VALUES.clone() : (PayViewState[]) invokeV.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public interface a {
        void a(p1a p1aVar, m1a m1aVar, AppCustomExpand appCustomExpand);

        void onRefreshViewFail(int i, String str);
    }

    /* loaded from: classes8.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<PayWayInfo> a;
        public m1a b;
        public AppCustomExpand c;
        public boolean d;
        public AbsViewEventHandler e;
        public PayFlowType f;

        public b() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = false;
        }
    }

    void setCallback(a aVar);

    void setViewState(PayViewState payViewState);
}
