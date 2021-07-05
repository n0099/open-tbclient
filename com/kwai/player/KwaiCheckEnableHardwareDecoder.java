package com.kwai.player;

import android.text.TextUtils;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.lang.reflect.InvocationTargetException;
/* loaded from: classes7.dex */
public class KwaiCheckEnableHardwareDecoder {
    public static /* synthetic */ Interceptable $ic;
    public static boolean mEnable;
    public static String mModel;
    public static String mPlatform;
    public static String mProduct;
    public static final HardwareDecoderProduct[] mProductArray;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public static class HardwareDecoderProduct {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public String model;
        public String platform;
        public String product;

        public HardwareDecoderProduct(String str, String str2, String str3) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {str, str2, str3};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.product = str;
            this.platform = str3;
            this.model = str2;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1335346505, "Lcom/kwai/player/KwaiCheckEnableHardwareDecoder;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1335346505, "Lcom/kwai/player/KwaiCheckEnableHardwareDecoder;");
                return;
            }
        }
        int i2 = 0;
        mProductArray = new HardwareDecoderProduct[]{new HardwareDecoderProduct("HUAWEI", "ALP-AL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "ALP-TL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "ALP-L09", "kirin970"), new HardwareDecoderProduct("HUAWEI", "ALP-L29", "kirin970"), new HardwareDecoderProduct("HUAWEI", "BLA-AL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "STF-AL10", "hi3660"), new HardwareDecoderProduct("HUAWEI", "STF-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "STF-TL10", "hi3660"), new HardwareDecoderProduct("HUAWEI", "BLA-AL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "BLA-TL00", "kirin970"), new HardwareDecoderProduct("HUAWEI", "BLA-L09", "kirin970"), new HardwareDecoderProduct("HUAWEI", "BLA-L29", "kirin970"), new HardwareDecoderProduct("HUAWEI", "LON-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "LON-CL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "LON-L29", "hi3660"), new HardwareDecoderProduct("HUAWEI", "LON-L09", "hi3660"), new HardwareDecoderProduct("HUAWEI", "LON-TL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-CL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-L09", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-L29", "hi3660"), new HardwareDecoderProduct("HUAWEI", "MHA-TL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-CL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-L09", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-L29", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VTR-TL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-AL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-CL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-L09", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-L29", "hi3660"), new HardwareDecoderProduct("HUAWEI", "VKY-TL00", "hi3660"), new HardwareDecoderProduct("HUAWEI", "DUK-AL20", "hi3660"), new HardwareDecoderProduct("HUAWEI", "DUK-AL30", "hi3660"), new HardwareDecoderProduct("HUAWEI", "DUK-TL30", "hi3660"), new HardwareDecoderProduct("HUAWEI", "BAC-AL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BAC-TL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PIC-AL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PIC-TL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "FRD-AL00", "hi3650"), new HardwareDecoderProduct("HUAWEI", "FRD-AL10", "hi3650"), new HardwareDecoderProduct("HUAWEI", "FRD-DL00", "hi3650"), new HardwareDecoderProduct("HUAWEI", "NEM-AL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "NEM-TL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "NEM-UL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "NEM-TL00H", "hi6250"), new HardwareDecoderProduct("HUAWEI", "NEM-UL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-TL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-TL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-AL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-AL20", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-AL30", "hi6250"), new HardwareDecoderProduct("HUAWEI", "BLN-AL40", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PRA-AL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PRA-AL00X", "hi6250"), new HardwareDecoderProduct("HUAWEI", "PRA-TL10", "hi6250"), new HardwareDecoderProduct("HUAWEI", "WAS-AL00", "hi6250"), new HardwareDecoderProduct("HUAWEI", "WAS-TL10", "hi6250")};
        mProduct = getProp("ro.product.manufacturer");
        mPlatform = getProp("ro.board.platform");
        mModel = getProp("ro.product.model");
        mEnable = false;
        while (true) {
            HardwareDecoderProduct[] hardwareDecoderProductArr = mProductArray;
            if (i2 >= hardwareDecoderProductArr.length) {
                return;
            }
            if (TextUtils.equals(mProduct, hardwareDecoderProductArr[i2].product) && TextUtils.equals(mPlatform, mProductArray[i2].platform) && TextUtils.equals(mModel, mProductArray[i2].model)) {
                mEnable = true;
            }
            i2++;
        }
    }

    public KwaiCheckEnableHardwareDecoder() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean canEnableHardwareDecoder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) ? mEnable : invokeV.booleanValue;
    }

    public static String getProp(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, str)) == null) {
            try {
                Class<?> cls = Class.forName("android.os.SystemProperties");
                return (String) cls.getDeclaredMethod("get", String.class).invoke(cls, str);
            } catch (ClassNotFoundException e2) {
                e2.printStackTrace();
                return null;
            } catch (IllegalAccessException e3) {
                e3.printStackTrace();
                return null;
            } catch (NoSuchMethodException e4) {
                e4.printStackTrace();
                return null;
            } catch (InvocationTargetException e5) {
                e5.printStackTrace();
                return null;
            }
        }
        return (String) invokeL.objValue;
    }
}
