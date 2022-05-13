package com.tachikoma.core.component.network;

import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.browser.sailor.BdSailorConfig;
import com.baidu.searchbox.launch.LaunchStatsUtils;
import com.baidu.searchbox.retrieve.inter.constants.StatConstants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.vivo.push.util.NotifyAdapterUtil;
/* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
/* loaded from: classes7.dex */
public final class NetworkType {
    public static final /* synthetic */ NetworkType[] $VALUES;
    public static /* synthetic */ Interceptable $ic;
    public static final NetworkType AD;
    public static final NetworkType API;
    public static final NetworkType GZONE;
    public static final NetworkType HTTPS;
    public static final NetworkType IM;
    public static final NetworkType LIVE;
    public static final NetworkType LOG;
    public static final NetworkType MERCHANT;
    public static final NetworkType PAY;
    public static final NetworkType PAYGATEWAY;
    public static final NetworkType PUSH;
    public static final NetworkType UPLOAD;
    public static final NetworkType ZT;
    public transient /* synthetic */ FieldHolder $fh;
    public final String text;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-524801028, "Lcom/tachikoma/core/component/network/NetworkType;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-524801028, "Lcom/tachikoma/core/component/network/NetworkType;");
                return;
            }
        }
        API = new NetworkType("API", 0, RetrieveTaskManager.KEY);
        LOG = new NetworkType("LOG", 1, TbConfig.TMP_LOG_DIR_NAME);
        UPLOAD = new NetworkType(BdSailorConfig.SAILOR_BASE_UPLOAD, 2, StatConstants.VALUE_TYPE_UPLOAD);
        PAY = new NetworkType("PAY", 3, TiebaStatic.DQPay.TYPE_VALUE);
        PAYGATEWAY = new NetworkType("PAYGATEWAY", 4, "payGateway");
        HTTPS = new NetworkType("HTTPS", 5, "https");
        LIVE = new NetworkType("LIVE", 6, "live");
        IM = new NetworkType("IM", 7, "IM");
        PUSH = new NetworkType(NotifyAdapterUtil.PUSH_EN, 8, "push");
        AD = new NetworkType("AD", 9, LaunchStatsUtils.AD);
        MERCHANT = new NetworkType("MERCHANT", 10, "merchant");
        GZONE = new NetworkType("GZONE", 11, "gzone");
        NetworkType networkType = new NetworkType("ZT", 12, "zt");
        ZT = networkType;
        $VALUES = new NetworkType[]{API, LOG, UPLOAD, PAY, PAYGATEWAY, HTTPS, LIVE, IM, PUSH, AD, MERCHANT, GZONE, networkType};
    }

    public NetworkType(String str, int i, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, Integer.valueOf(i), str2};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                String str3 = (String) objArr2[0];
                ((Integer) objArr2[1]).intValue();
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.text = str2;
    }

    public static NetworkType valueOf(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) ? (NetworkType) Enum.valueOf(NetworkType.class, str) : (NetworkType) invokeL.objValue;
    }

    public static NetworkType[] values() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65539, null)) == null) ? (NetworkType[]) $VALUES.clone() : (NetworkType[]) invokeV.objValue;
    }

    @Override // java.lang.Enum
    public String toString() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.text : (String) invokeV.objValue;
    }
}
