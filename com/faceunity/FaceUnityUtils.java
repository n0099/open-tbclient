package com.faceunity;

import android.content.Context;
import com.baidu.adp.base.BdBaseApplication;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tieba.ah;
import com.baidu.tieba.ih;
import com.baidu.tieba.u7b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.faceunity.wrapper.faceunity;
import java.io.File;
import java.io.FileInputStream;
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
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static boolean isLibNamaLoaded() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65537, null)) == null) {
            return !StringUtils.isNull(BdBaseApplication.getInst().getResHashMap().get("libnama.so"));
        }
        return invokeV.booleanValue;
    }

    public static int setUpFaceUnity(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65538, null, context)) == null) {
            try {
            } catch (Throwable th) {
                th.printStackTrace();
            }
            if (!isLibNamaLoaded()) {
                ah.a("setUpFaceUnity, libnama so not loaded");
                return 0;
            }
            String b = ih.b("v3.mp3");
            File file = new File(b);
            if (file.exists() && file.isFile()) {
                FileInputStream fileInputStream = new FileInputStream(b);
                fileInputStream.close();
                faceunity.fuSetup(new byte[fileInputStream.available()], null, u7b.a());
            }
            String b2 = ih.b("face_beautification.mp3");
            File file2 = new File(b2);
            if (file2.exists() && file2.isFile()) {
                FileInputStream fileInputStream2 = new FileInputStream(b2);
                fileInputStream2.close();
                return faceunity.fuCreateItemFromPackage(new byte[fileInputStream2.available()]);
            }
            return 0;
        }
        return invokeL.intValue;
    }
}
