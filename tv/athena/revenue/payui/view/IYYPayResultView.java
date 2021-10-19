package tv.athena.revenue.payui.view;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.payapi.bean.CurrencyChargeMessage;
import tv.athena.revenue.payui.model.PaySource;
/* loaded from: classes2.dex */
public interface IYYPayResultView extends j.a.a.e.o.a {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes2.dex */
    public static final class Result {
        public static final /* synthetic */ Result[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Result PAY_FAIL;
        public static final Result PAY_LOADING;
        public static final Result PAY_SUUCESS;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-435287404, "Ltv/athena/revenue/payui/view/IYYPayResultView$Result;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-435287404, "Ltv/athena/revenue/payui/view/IYYPayResultView$Result;");
                    return;
                }
            }
            PAY_LOADING = new Result("PAY_LOADING", 0);
            PAY_SUUCESS = new Result("PAY_SUUCESS", 1);
            Result result = new Result("PAY_FAIL", 2);
            PAY_FAIL = result;
            $VALUES = new Result[]{PAY_LOADING, PAY_SUUCESS, result};
        }

        public Result(String str, int i2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65537, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    String str2 = (String) objArr2[0];
                    ((Integer) objArr2[1]).intValue();
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        public static Result valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (Result) Enum.valueOf(Result.class, str) : (Result) invokeL.objValue;
        }

        public static Result[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (Result[]) $VALUES.clone() : (Result[]) invokeV.objValue;
        }
    }

    /* loaded from: classes2.dex */
    public interface a {
        void a();
    }

    /* loaded from: classes2.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public Result f80291a;

        /* renamed from: b  reason: collision with root package name */
        public CurrencyChargeMessage f80292b;

        public b(Result result, CurrencyChargeMessage currencyChargeMessage) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {result, currencyChargeMessage};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f80291a = result;
            this.f80292b = currencyChargeMessage;
        }
    }

    /* loaded from: classes2.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public b f80293a;

        /* renamed from: b  reason: collision with root package name */
        public AbsViewEventHandler f80294b;

        public c() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            PaySource paySource = PaySource.UNKNOW;
        }
    }

    void setCallback(a aVar);
}
