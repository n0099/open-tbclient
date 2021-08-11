package com.yy.mobile.framework.revenuesdk.payapi.payservice;

import android.app.Activity;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.util.devices.RomUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.dxmpay.wallet.utils.StatHelper;
import com.yy.mobile.framework.revenuesdk.baseapi.IResult;
import com.yy.mobile.framework.revenuesdk.baseapi.reporter.EventAlias;
import com.yy.mobile.framework.revenuesdk.payapi.IPayCallback;
import com.yy.mobile.framework.revenuesdk.payapi.bean.ProductInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.PurchaseInfo;
import com.yy.mobile.framework.revenuesdk.payapi.bean.SkuDetailInfo;
import java.util.List;
/* loaded from: classes10.dex */
public interface IPayMethod {

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* loaded from: classes10.dex */
    public static final class Status {
        public static final /* synthetic */ Status[] $VALUES;
        public static /* synthetic */ Interceptable $ic;
        public static final Status ERROR;
        public static final Status NOT_SUPPORT;
        public static final Status OK;
        public static final Status UNKNOWN;
        public transient /* synthetic */ FieldHolder $fh;
        public final int code;
        public final String message;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1957166126, "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/IPayMethod$Status;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1957166126, "Lcom/yy/mobile/framework/revenuesdk/payapi/payservice/IPayMethod$Status;");
                    return;
                }
            }
            OK = new Status(StatHelper.SENSOR_OK, 0, 0, EventAlias.PayEventAlias.PAY_SUCCESS);
            NOT_SUPPORT = new Status("NOT_SUPPORT", 1, -101, "当前不支持该种支付方式");
            ERROR = new Status("ERROR", 2, -102, "支付错误");
            Status status = new Status(RomUtils.UNKNOWN, 3, -103, "未知错误");
            UNKNOWN = status;
            $VALUES = new Status[]{OK, NOT_SUPPORT, ERROR, status};
        }

        public Status(String str, int i2, int i3, String str2) {
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

        public static Status valueOf(String str) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) ? (Status) Enum.valueOf(Status.class, str) : (Status) invokeL.objValue;
        }

        public static Status[] values() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) ? (Status[]) $VALUES.clone() : (Status[]) invokeV.objValue;
        }

        public int getCode() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.code : invokeV.intValue;
        }

        public String getMessage() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.message : (String) invokeV.objValue;
        }

        public static Status valueOf(int i2) {
            InterceptResult invokeI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeI = interceptable.invokeI(65538, null, i2)) == null) {
                if (i2 != 0) {
                    switch (i2) {
                        case -103:
                            return UNKNOWN;
                        case -102:
                            return ERROR;
                        case -101:
                            return NOT_SUPPORT;
                        default:
                            return UNKNOWN;
                    }
                }
                return OK;
            }
            return (Status) invokeI.objValue;
        }
    }

    void appHasReturnToForegroud();

    void clearHangPayJob(Activity activity, int i2, IResult<PurchaseInfo> iResult);

    boolean doHangJob(@NonNull PurchaseInfo purchaseInfo, IResult<String> iResult);

    boolean hasHangPayJobs(Activity activity, IResult<List<PurchaseInfo>> iResult);

    boolean hasHangSubscribeJobs(Activity activity, IResult<List<PurchaseInfo>> iResult);

    boolean isPayingStatus();

    boolean isSupported(Activity activity);

    void onWxPayResult(int i2, String str);

    boolean queryHistoryPurchaseByProductId(String str, IResult<PurchaseInfo> iResult);

    boolean queryHistoryPurchaseBySkuType(@NonNull Activity activity, String str, IResult<List<PurchaseInfo>> iResult);

    boolean querySkuDetails(Activity activity, List<String> list, String str, IResult<List<SkuDetailInfo>> iResult);

    void requestPay(Activity activity, long j2, ProductInfo productInfo, String str, boolean z, IPayCallback<PurchaseInfo> iPayCallback);

    void requestPay(Activity activity, long j2, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback);

    void requestSubscription(Activity activity, long j2, String str, String str2, boolean z, IPayCallback<PurchaseInfo> iPayCallback);

    void updateSubscription(Activity activity, long j2, String str, String str2, int i2, String str3, boolean z, IPayCallback<PurchaseInfo> iPayCallback);
}
