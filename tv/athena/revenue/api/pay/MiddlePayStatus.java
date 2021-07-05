package tv.athena.revenue.api.pay;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.yy.mobile.framework.revenuesdk.baseapi.ErrorCode;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0018\b\u0086\u0001\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0019\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\f\u0010\rR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0019\u0010\b\u001a\u00020\u00078\u0006@\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001e¨\u0006\u001f"}, d2 = {"Ltv/athena/revenue/api/pay/MiddlePayStatus;", "Ljava/lang/Enum;", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "<init>", "(Ljava/lang/String;IILjava/lang/String;)V", "Companion", "RECHARGING", "CAN_NOT_USE", "WRONG_ARGS", "SEVER_ERROR", RomUtils.UNKNOWN, "NOT_SUPPORT", "ORDER_RISK_ERROR", "SERVICE_DISCONNECTED", "USER_CANCELED", "SERVICE_UNAVAILABLE", "ITEM_UNAVAILABLE", "DEVELOPER_ERROR", "ERROR", "ITEM_ALREADY_OWNED", "ITEM_NOT_OWNED", "BILLING_STARTUP", "paycore_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
/* loaded from: classes10.dex */
public final class MiddlePayStatus {
    public static final /* synthetic */ MiddlePayStatus[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final MiddlePayStatus BILLING_STARTUP;
    public static final MiddlePayStatus CAN_NOT_USE;
    public static final a Companion;
    public static final MiddlePayStatus DEVELOPER_ERROR;
    public static final MiddlePayStatus ERROR;
    public static final MiddlePayStatus ITEM_ALREADY_OWNED;
    public static final MiddlePayStatus ITEM_NOT_OWNED;
    public static final MiddlePayStatus ITEM_UNAVAILABLE;
    public static final MiddlePayStatus NOT_SUPPORT;
    public static final MiddlePayStatus ORDER_RISK_ERROR;
    public static final MiddlePayStatus RECHARGING;
    public static final MiddlePayStatus SERVICE_DISCONNECTED;
    public static final MiddlePayStatus SERVICE_UNAVAILABLE;
    public static final MiddlePayStatus SEVER_ERROR;
    public static final MiddlePayStatus UNKNOWN;
    public static final MiddlePayStatus USER_CANCELED;
    public static final MiddlePayStatus WRONG_ARGS;
    public transient /* synthetic */ FieldHolder $fh;
    public final int code;
    public final String message;

    /* loaded from: classes10.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(172101488, "Ltv/athena/revenue/api/pay/MiddlePayStatus;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(172101488, "Ltv/athena/revenue/api/pay/MiddlePayStatus;");
                return;
            }
        }
        MiddlePayStatus middlePayStatus = new MiddlePayStatus("RECHARGING", 0, -6, "正在支付");
        RECHARGING = middlePayStatus;
        MiddlePayStatus middlePayStatus2 = new MiddlePayStatus("CAN_NOT_USE", 1, -5, "账户已冻结");
        CAN_NOT_USE = middlePayStatus2;
        MiddlePayStatus middlePayStatus3 = new MiddlePayStatus("WRONG_ARGS", 2, ErrorCode.ARGS_ERROR, "参数错误，特指参数缺失");
        WRONG_ARGS = middlePayStatus3;
        MiddlePayStatus middlePayStatus4 = new MiddlePayStatus("SEVER_ERROR", 3, -500, "服务端错误");
        SEVER_ERROR = middlePayStatus4;
        MiddlePayStatus middlePayStatus5 = new MiddlePayStatus(RomUtils.UNKNOWN, 4, 0, "未知状态");
        UNKNOWN = middlePayStatus5;
        MiddlePayStatus middlePayStatus6 = new MiddlePayStatus("NOT_SUPPORT", 5, 3, "当前不支持该种支付方式");
        NOT_SUPPORT = middlePayStatus6;
        MiddlePayStatus middlePayStatus7 = new MiddlePayStatus("ORDER_RISK_ERROR", 6, -18, "风控拦截");
        ORDER_RISK_ERROR = middlePayStatus7;
        MiddlePayStatus middlePayStatus8 = new MiddlePayStatus("SERVICE_DISCONNECTED", 7, -1, "服务断开");
        SERVICE_DISCONNECTED = middlePayStatus8;
        MiddlePayStatus middlePayStatus9 = new MiddlePayStatus("USER_CANCELED", 8, 1, "用户取消");
        USER_CANCELED = middlePayStatus9;
        MiddlePayStatus middlePayStatus10 = new MiddlePayStatus("SERVICE_UNAVAILABLE", 9, 2, "Network connection is down");
        SERVICE_UNAVAILABLE = middlePayStatus10;
        MiddlePayStatus middlePayStatus11 = new MiddlePayStatus("ITEM_UNAVAILABLE", 10, 4, "Requested product is not available for purchase");
        ITEM_UNAVAILABLE = middlePayStatus11;
        MiddlePayStatus middlePayStatus12 = new MiddlePayStatus("DEVELOPER_ERROR", 11, 5, "DEVELOPER_ERROR");
        DEVELOPER_ERROR = middlePayStatus12;
        MiddlePayStatus middlePayStatus13 = new MiddlePayStatus("ERROR", 12, 6, "Fatal error during the API action");
        ERROR = middlePayStatus13;
        MiddlePayStatus middlePayStatus14 = new MiddlePayStatus("ITEM_ALREADY_OWNED", 13, 7, "Failure to purchase since item is already owned");
        ITEM_ALREADY_OWNED = middlePayStatus14;
        MiddlePayStatus middlePayStatus15 = new MiddlePayStatus("ITEM_NOT_OWNED", 14, 8, "Failure to consume since item is not owned");
        ITEM_NOT_OWNED = middlePayStatus15;
        MiddlePayStatus middlePayStatus16 = new MiddlePayStatus("BILLING_STARTUP", 15, 300, "BILLING_STARTUP");
        BILLING_STARTUP = middlePayStatus16;
        $VALUES = new MiddlePayStatus[]{middlePayStatus, middlePayStatus2, middlePayStatus3, middlePayStatus4, middlePayStatus5, middlePayStatus6, middlePayStatus7, middlePayStatus8, middlePayStatus9, middlePayStatus10, middlePayStatus11, middlePayStatus12, middlePayStatus13, middlePayStatus14, middlePayStatus15, middlePayStatus16};
        Companion = new a(null);
    }

    public MiddlePayStatus(String str, int i2, int i3, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i2), Integer.valueOf(i3), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i4 = newInitContext.flag;
            if ((i4 & 1) != 0) {
                int i5 = i4 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.code = i3;
        this.message = str2;
    }

    public static MiddlePayStatus valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (MiddlePayStatus) Enum.valueOf(MiddlePayStatus.class, str) : (MiddlePayStatus) invokeL.objValue;
    }

    public static MiddlePayStatus[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (MiddlePayStatus[]) $VALUES.clone() : (MiddlePayStatus[]) invokeV.objValue;
    }

    public final int getCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
    }

    public final String getMessage() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.message : (String) invokeV.objValue;
    }
}
