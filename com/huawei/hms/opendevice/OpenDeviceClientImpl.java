package com.huawei.hms.opendevice;

import android.content.Context;
import com.baidu.tieba.nma;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.support.api.entity.opendevice.HuaweiOpendeviceNaming;
import com.huawei.hms.support.api.opendevice.OdidResult;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;
import com.huawei.hms.utils.JsonUtil;
/* loaded from: classes8.dex */
public class OpenDeviceClientImpl extends HuaweiApi<OpenDeviceOptions> implements OpenDeviceClient {
    public static /* synthetic */ Interceptable $ic;
    public static final OpenDeviceHmsClientBuilder a;
    public static final Api<OpenDeviceOptions> b;
    public static OpenDeviceOptions c;
    public transient /* synthetic */ FieldHolder $fh;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1505112176, "Lcom/huawei/hms/opendevice/OpenDeviceClientImpl;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1505112176, "Lcom/huawei/hms/opendevice/OpenDeviceClientImpl;");
                return;
            }
        }
        a = new OpenDeviceHmsClientBuilder();
        b = new Api<>(HuaweiApiAvailability.HMS_API_NAME_OD);
        c = new OpenDeviceOptions();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OpenDeviceClientImpl(Context context) {
        super(context, b, c, a);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (Api) objArr2[1], (Api.ApiOptions) objArr2[2], (AbstractClientBuilder) objArr2[3]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        super.setKitSdkVersion(60300305);
    }

    /* JADX DEBUG: Type inference failed for r0v4. Raw type applied. Possible types: com.baidu.tieba.nma<TResult>, com.baidu.tieba.nma<com.huawei.hms.support.api.opendevice.OdidResult> */
    @Override // com.huawei.hms.opendevice.OpenDeviceClient
    public nma<OdidResult> getOdid() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return doWrite(new OpenDeviceTaskApiCall(HuaweiOpendeviceNaming.getOdid, JsonUtil.createJsonString(null), HiAnalyticsClient.reportEntry(getContext(), HuaweiOpendeviceNaming.getOdid, 60300305)));
        }
        return (nma) invokeV.objValue;
    }
}
