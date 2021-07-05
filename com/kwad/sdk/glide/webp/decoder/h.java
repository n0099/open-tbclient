package com.kwad.sdk.glide.webp.decoder;

import android.util.Log;
import com.baidu.down.utils.Utils;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes7.dex */
public class h {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static int a(int i2, int i3, int i4, int i5) {
        InterceptResult invokeIIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeIIII = interceptable.invokeIIII(65536, null, i2, i3, i4, i5)) == null) {
            int min = Math.min(i3 / i5, i2 / i4);
            int max = Math.max(1, min == 0 ? 0 : Integer.highestOneBit(min));
            if (Log.isLoggable(Utils.TAG, 2) && max > 1) {
                Log.v(Utils.TAG, "Downsampling WEBP, sampleSize: " + max + ", target dimens: [" + i4 + "x" + i5 + "], actual dimens: [" + i2 + "x" + i3 + PreferencesUtil.RIGHT_MOUNT);
            }
            return max;
        }
        return invokeIIII.intValue;
    }

    public static byte[] a(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable != null && (invokeL = interceptable.invokeL(65537, null, inputStream)) != null) {
            return (byte[]) invokeL.objValue;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int read = inputStream.read(bArr);
                if (read == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, read);
            }
        } catch (IOException e2) {
            if (Log.isLoggable(Utils.TAG, 5)) {
                Log.w(Utils.TAG, "Error reading data from stream", e2);
                return null;
            }
            return null;
        }
    }
}
