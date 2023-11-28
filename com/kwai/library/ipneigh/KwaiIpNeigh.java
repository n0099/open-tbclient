package com.kwai.library.ipneigh;

import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
/* loaded from: classes10.dex */
public class KwaiIpNeigh {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KwaiIpNeigh";
    public transient /* synthetic */ FieldHolder $fh;

    public static native int getARPTableFromJni(int i);

    public static native int getARPTableFromJni2(int i);

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1447568411, "Lcom/kwai/library/ipneigh/KwaiIpNeigh;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1447568411, "Lcom/kwai/library/ipneigh/KwaiIpNeigh;");
                return;
            }
        }
        System.loadLibrary("ipneigh-android");
    }

    public KwaiIpNeigh() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    public static boolean az(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, str, str2)) == null) {
            if (str == null) {
                return false;
            }
            String[] split = str.split("\\s+");
            if (split.length < 2) {
                return false;
            }
            return split[0].equals(str2);
        }
        return invokeLL.booleanValue;
    }

    public static String i(String str, boolean z) {
        InterceptResult invokeLZ;
        ParcelFileDescriptor.AutoCloseInputStream autoCloseInputStream;
        int aRPTableFromJni;
        String readLine;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(65541, null, str, z)) == null) {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            try {
                ParcelFileDescriptor[] createPipe = ParcelFileDescriptor.createPipe();
                ParcelFileDescriptor parcelFileDescriptor = createPipe[0];
                ParcelFileDescriptor parcelFileDescriptor2 = createPipe[1];
                autoCloseInputStream = new ParcelFileDescriptor.AutoCloseInputStream(parcelFileDescriptor);
                int detachFd = parcelFileDescriptor2.detachFd();
                if (z) {
                    aRPTableFromJni = getARPTableFromJni2(detachFd);
                } else {
                    aRPTableFromJni = getARPTableFromJni(detachFd);
                }
            } catch (Throwable th) {
                th.printStackTrace();
                String str2 = TAG;
                Log.e(str2, "getARPResult exception:" + th.getMessage());
            }
            if (aRPTableFromJni != 0) {
                Log.e(TAG, "ARP table reading failed, are you using targetSdk 32 and an Android 13 device?");
                return "";
            }
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(autoCloseInputStream, StandardCharsets.UTF_8));
            do {
                readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return "";
                }
            } while (!az(readLine, str));
            return readLine;
        }
        return (String) invokeLZ.objValue;
    }
}
