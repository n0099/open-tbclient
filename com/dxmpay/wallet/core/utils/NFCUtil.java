package com.dxmpay.wallet.core.utils;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.IntentFilter;
import android.nfc.NfcAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.wallet.router.LocalRouter;
@SuppressLint({"NewApi"})
/* loaded from: classes11.dex */
public final class NFCUtil {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public IntentFilter[] mFilters;
    public String[][] mTechlist;

    /* loaded from: classes11.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes11.dex */
    public static class b {
        public static /* synthetic */ Interceptable $ic;

        /* renamed from: a  reason: collision with root package name */
        public static NFCUtil f63503a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-399585810, "Lcom/dxmpay/wallet/core/utils/NFCUtil$b;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-399585810, "Lcom/dxmpay/wallet/core/utils/NFCUtil$b;");
                    return;
                }
            }
            f63503a = new NFCUtil(null);
        }
    }

    public /* synthetic */ NFCUtil(a aVar) {
        this();
    }

    public static NFCUtil getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? b.f63503a : (NFCUtil) invokeV.objValue;
    }

    public void disableForegroundDispatch(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048576, this, activity, z) == null) {
        }
    }

    public void enableForegroundDispatch(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, activity, z) == null) {
        }
    }

    public NfcAdapter getNFCAdapter(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, activity)) == null) {
            return null;
        }
        return (NfcAdapter) invokeL.objValue;
    }

    public boolean isPhoneNFCEnable(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, activity)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isPhoneSurportNFC(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, activity)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isWalletNFCEnable(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, activity)) == null) {
            return false;
        }
        return invokeL.booleanValue;
    }

    public boolean isWalletNFCSurport(Activity activity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, activity)) == null) ? LocalRouter.getInstance(activity).isProviderExisted("nfc") && isPhoneSurportNFC(activity) : invokeL.booleanValue;
    }

    public void setWalletNFCEnable(Activity activity, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048583, this, activity, z) == null) {
        }
    }

    public NFCUtil() {
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
}
