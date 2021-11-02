package com.google.android.material.shape;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
@Deprecated
/* loaded from: classes11.dex */
public class ShapePathModel extends ShapeAppearanceModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ShapePathModel() {
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

    @Deprecated
    public void setAllCorners(CornerTreatment cornerTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, cornerTreatment) == null) {
            this.topLeftCorner = cornerTreatment;
            this.topRightCorner = cornerTreatment;
            this.bottomRightCorner = cornerTreatment;
            this.bottomLeftCorner = cornerTreatment;
        }
    }

    @Deprecated
    public void setAllEdges(EdgeTreatment edgeTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, edgeTreatment) == null) {
            this.leftEdge = edgeTreatment;
            this.topEdge = edgeTreatment;
            this.rightEdge = edgeTreatment;
            this.bottomEdge = edgeTreatment;
        }
    }

    @Deprecated
    public void setBottomEdge(EdgeTreatment edgeTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, edgeTreatment) == null) {
            this.bottomEdge = edgeTreatment;
        }
    }

    @Deprecated
    public void setBottomLeftCorner(CornerTreatment cornerTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, cornerTreatment) == null) {
            this.bottomLeftCorner = cornerTreatment;
        }
    }

    @Deprecated
    public void setBottomRightCorner(CornerTreatment cornerTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, cornerTreatment) == null) {
            this.bottomRightCorner = cornerTreatment;
        }
    }

    @Deprecated
    public void setCornerTreatments(CornerTreatment cornerTreatment, CornerTreatment cornerTreatment2, CornerTreatment cornerTreatment3, CornerTreatment cornerTreatment4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048581, this, cornerTreatment, cornerTreatment2, cornerTreatment3, cornerTreatment4) == null) {
            this.topLeftCorner = cornerTreatment;
            this.topRightCorner = cornerTreatment2;
            this.bottomRightCorner = cornerTreatment3;
            this.bottomLeftCorner = cornerTreatment4;
        }
    }

    @Deprecated
    public void setEdgeTreatments(EdgeTreatment edgeTreatment, EdgeTreatment edgeTreatment2, EdgeTreatment edgeTreatment3, EdgeTreatment edgeTreatment4) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048582, this, edgeTreatment, edgeTreatment2, edgeTreatment3, edgeTreatment4) == null) {
            this.leftEdge = edgeTreatment;
            this.topEdge = edgeTreatment2;
            this.rightEdge = edgeTreatment3;
            this.bottomEdge = edgeTreatment4;
        }
    }

    @Deprecated
    public void setLeftEdge(EdgeTreatment edgeTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, edgeTreatment) == null) {
            this.leftEdge = edgeTreatment;
        }
    }

    @Deprecated
    public void setRightEdge(EdgeTreatment edgeTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, edgeTreatment) == null) {
            this.rightEdge = edgeTreatment;
        }
    }

    @Deprecated
    public void setTopEdge(EdgeTreatment edgeTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, edgeTreatment) == null) {
            this.topEdge = edgeTreatment;
        }
    }

    @Deprecated
    public void setTopLeftCorner(CornerTreatment cornerTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, cornerTreatment) == null) {
            this.topLeftCorner = cornerTreatment;
        }
    }

    @Deprecated
    public void setTopRightCorner(CornerTreatment cornerTreatment) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, cornerTreatment) == null) {
            this.topRightCorner = cornerTreatment;
        }
    }
}
