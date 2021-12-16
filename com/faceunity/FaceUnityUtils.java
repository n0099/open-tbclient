package com.faceunity;

import android.content.Context;
import c.a.d.k.i;
import c.a.s0.j4.l.e;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.wrapper.faceunity;
import java.io.File;
import java.io.FileInputStream;
/* loaded from: classes2.dex */
public class FaceUnityUtils {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String DEFAULT_FILTER_VALUE = "normal";
    public transient /* synthetic */ FieldHolder $fh;

    public FaceUnityUtils() {
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

    public static int setUpFaceUnity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, context)) == null) {
            try {
                String b2 = i.b("v3.mp3");
                File file = new File(b2);
                if (file.exists() && file.isFile()) {
                    FileInputStream fileInputStream = new FileInputStream(b2);
                    fileInputStream.close();
                    faceunity.fuSetup(new byte[fileInputStream.available()], null, e.a());
                }
                String b3 = i.b("face_beautification.mp3");
                File file2 = new File(b3);
                if (file2.exists() && file2.isFile()) {
                    FileInputStream fileInputStream2 = new FileInputStream(b3);
                    fileInputStream2.close();
                    return faceunity.fuCreateItemFromPackage(new byte[fileInputStream2.available()]);
                }
                return 0;
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
