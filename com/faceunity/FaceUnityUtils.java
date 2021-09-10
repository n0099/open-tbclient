package com.faceunity;

import android.content.Context;
import c.a.r0.x3.l.e;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.wrapper.faceunity;
import java.io.InputStream;
/* loaded from: classes9.dex */
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
                InputStream open = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/v3.mp3");
                open.close();
                faceunity.fuSetup(new byte[open.available()], null, e.a());
                InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                open2.close();
                return faceunity.fuCreateItemFromPackage(new byte[open2.available()]);
            } catch (Throwable th) {
                th.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
