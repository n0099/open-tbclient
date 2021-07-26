package com.faceunity;

import android.content.Context;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.wrapper.faceunity;
import d.a.q0.v3.l.f;
import java.io.IOException;
import java.io.InputStream;
/* loaded from: classes5.dex */
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
                byte[] bArr = new byte[open.available()];
                open.read(bArr);
                open.close();
                faceunity.fuSetup(bArr, null, f.a());
                InputStream open2 = TbadkCoreApplication.getInst().getResources().getAssets().open("beauty/face_beautification.mp3");
                byte[] bArr2 = new byte[open2.available()];
                open2.read(bArr2);
                open2.close();
                return faceunity.fuCreateItemFromPackage(bArr2);
            } catch (IOException e2) {
                e2.printStackTrace();
                return 0;
            }
        }
        return invokeL.intValue;
    }
}
