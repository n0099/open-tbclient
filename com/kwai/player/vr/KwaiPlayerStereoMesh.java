package com.kwai.player.vr;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes7.dex */
public class KwaiPlayerStereoMesh {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String TAG = "KwaiPlayerStereoMesh";
    public transient /* synthetic */ FieldHolder $fh;
    public KwaiBaseMesh mKwaiBaseMesh;

    public KwaiPlayerStereoMesh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {Integer.valueOf(i2)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i3 = newInitContext.flag;
            if ((i3 & 1) != 0) {
                int i4 = i3 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        genKwaiMesh(i2);
    }

    public void genKwaiMesh(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i2) == null) {
            if (i2 == 1) {
                this.mKwaiBaseMesh = new KwaiSphereMesh();
            }
            KwaiBaseMesh kwaiBaseMesh = this.mKwaiBaseMesh;
            if (kwaiBaseMesh != null) {
                kwaiBaseMesh.genKwaiMesh();
            }
        }
    }

    public KwaiMesh getKwaiMesh() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            KwaiBaseMesh kwaiBaseMesh = this.mKwaiBaseMesh;
            if (kwaiBaseMesh != null) {
                return kwaiBaseMesh.getKwaiMesh();
            }
            return null;
        }
        return (KwaiMesh) invokeV.objValue;
    }
}
