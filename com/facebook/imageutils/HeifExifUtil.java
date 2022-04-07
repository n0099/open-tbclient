package com.facebook.imageutils;

import android.media.ExifInterface;
import android.os.Build;
import androidx.annotation.RequiresApi;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.common.logging.FLog;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes4.dex */
public class HeifExifUtil {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "HeifExifUtil";
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static class HeifExifUtilAndroidN {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public HeifExifUtilAndroidN() {
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

        @RequiresApi(api = 24)
        public static int getOrientation(InputStream inputStream) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
                try {
                    return new ExifInterface(inputStream).getAttributeInt("Orientation", 1);
                } catch (IOException e) {
                    FLog.d(HeifExifUtil.TAG, "Failed reading Heif Exif orientation -> ignoring", (Throwable) e);
                    return 0;
                }
            }
            return invokeL.intValue;
        }
    }

    public HeifExifUtil() {
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

    public static int getOrientation(InputStream inputStream) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, inputStream)) == null) {
            if (Build.VERSION.SDK_INT >= 24) {
                return HeifExifUtilAndroidN.getOrientation(inputStream);
            }
            FLog.d(TAG, "Trying to read Heif Exif information before Android N -> ignoring");
            return 0;
        }
        return invokeL.intValue;
    }
}
