package com.vivo.push.util;

import android.content.Context;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.baidu.webkit.internal.Base64;
import com.google.android.exoplayer2.text.cea.Cea608Decoder;
/* loaded from: classes10.dex */
public final class ad extends c {
    public static /* synthetic */ Interceptable $ic;
    public static ad b;
    public transient /* synthetic */ FieldHolder $fh;

    public ad() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static synchronized ad b() {
        InterceptResult invokeV;
        ad adVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            synchronized (ad.class) {
                if (b == null) {
                    b = new ad();
                }
                adVar = b;
            }
            return adVar;
        }
        return (ad) invokeV.objValue;
    }

    public static byte[] d(String str) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, str)) == null) {
            byte[] bArr = null;
            try {
                String[] split = str.split(",");
                if (split.length > 0) {
                    bArr = new byte[split.length];
                    i = split.length;
                } else {
                    i = 0;
                }
                for (int i2 = 0; i2 < i; i2++) {
                    bArr[i2] = Byte.parseByte(split[i2].trim());
                }
            } catch (Exception e) {
                u.a("SharePreferenceManager", "getCodeBytes error:" + e.getMessage());
            }
            return bArr;
        }
        return (byte[]) invokeL.objValue;
    }

    public final synchronized void a(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, context) == null) {
            synchronized (this) {
                if (this.a == null) {
                    this.a = context;
                    a(context, "com.vivo.push_preferences");
                }
            }
        }
    }

    public final byte[] c() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            byte[] d = d(b("com.vivo.push.secure_cache_iv", ""));
            if (d == null || d.length <= 0) {
                return new byte[]{34, 32, 33, 37, 33, 34, 32, 33, 33, 33, 34, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, Base64.INTERNAL_PADDING, 32, 32, 32};
            }
            return d;
        }
        return (byte[]) invokeV.objValue;
    }

    public final byte[] d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            byte[] d = d(b("com.vivo.push.secure_cache_key", ""));
            if (d == null || d.length <= 0) {
                return new byte[]{33, 34, Base64.INTERNAL_PADDING, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, 37, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_4_ROWS, 40, Cea608Decoder.CTRL_RESUME_DIRECT_CAPTIONING, 32, Cea608Decoder.CTRL_ROLL_UP_CAPTIONS_3_ROWS, 37, Cea608Decoder.CTRL_DELETE_TO_END_OF_ROW, Base64.INTERNAL_PADDING, 34, 33};
            }
            return d;
        }
        return (byte[]) invokeV.objValue;
    }
}
