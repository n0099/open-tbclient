package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.material.R;
/* loaded from: classes7.dex */
public class ShapeAppearanceModel {
    public static /* synthetic */ Interceptable $ic;
    public static final CornerSize PILL;
    public transient /* synthetic */ FieldHolder $fh;
    public EdgeTreatment bottomEdge;
    public CornerTreatment bottomLeftCorner;
    public CornerSize bottomLeftCornerSize;
    public CornerTreatment bottomRightCorner;
    public CornerSize bottomRightCornerSize;
    public EdgeTreatment leftEdge;
    public EdgeTreatment rightEdge;
    public EdgeTreatment topEdge;
    public CornerTreatment topLeftCorner;
    public CornerSize topLeftCornerSize;
    public CornerTreatment topRightCorner;
    public CornerSize topRightCornerSize;

    /* renamed from: com.google.android.material.shape.ShapeAppearanceModel$1  reason: invalid class name */
    /* loaded from: classes7.dex */
    public /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    /* loaded from: classes7.dex */
    public interface CornerSizeUnaryOperator {
        CornerSize apply(CornerSize cornerSize);
    }

    /* loaded from: classes7.dex */
    public final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public EdgeTreatment bottomEdge;
        public CornerTreatment bottomLeftCorner;
        public CornerSize bottomLeftCornerSize;
        public CornerTreatment bottomRightCorner;
        public CornerSize bottomRightCornerSize;
        public EdgeTreatment leftEdge;
        public EdgeTreatment rightEdge;
        public EdgeTreatment topEdge;
        public CornerTreatment topLeftCorner;
        public CornerSize topLeftCornerSize;
        public CornerTreatment topRightCorner;
        public CornerSize topRightCornerSize;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        }

        public Builder(ShapeAppearanceModel shapeAppearanceModel) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {shapeAppearanceModel};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
            this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
            this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
            this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
            this.topLeftCorner = shapeAppearanceModel.topLeftCorner;
            this.topRightCorner = shapeAppearanceModel.topRightCorner;
            this.bottomRightCorner = shapeAppearanceModel.bottomRightCorner;
            this.bottomLeftCorner = shapeAppearanceModel.bottomLeftCorner;
            this.topLeftCornerSize = shapeAppearanceModel.topLeftCornerSize;
            this.topRightCornerSize = shapeAppearanceModel.topRightCornerSize;
            this.bottomRightCornerSize = shapeAppearanceModel.bottomRightCornerSize;
            this.bottomLeftCornerSize = shapeAppearanceModel.bottomLeftCornerSize;
            this.topEdge = shapeAppearanceModel.topEdge;
            this.rightEdge = shapeAppearanceModel.rightEdge;
            this.bottomEdge = shapeAppearanceModel.bottomEdge;
            this.leftEdge = shapeAppearanceModel.leftEdge;
        }

        public static float compatCornerTreatmentSize(CornerTreatment cornerTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, cornerTreatment)) == null) {
                if (cornerTreatment instanceof RoundedCornerTreatment) {
                    return ((RoundedCornerTreatment) cornerTreatment).radius;
                }
                if (cornerTreatment instanceof CutCornerTreatment) {
                    return ((CutCornerTreatment) cornerTreatment).size;
                }
                return -1.0f;
            }
            return invokeL.floatValue;
        }

        public Builder setAllCornerSizes(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                return setTopLeftCornerSize(f).setTopRightCornerSize(f).setBottomRightCornerSize(f).setBottomLeftCornerSize(f);
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setAllCorners(CornerTreatment cornerTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cornerTreatment)) == null) {
                return setTopLeftCorner(cornerTreatment).setTopRightCorner(cornerTreatment).setBottomRightCorner(cornerTreatment).setBottomLeftCorner(cornerTreatment);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAllEdges(EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, edgeTreatment)) == null) {
                return setLeftEdge(edgeTreatment).setTopEdge(edgeTreatment).setRightEdge(edgeTreatment).setBottomEdge(edgeTreatment);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBottomEdge(EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, edgeTreatment)) == null) {
                this.bottomEdge = edgeTreatment;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBottomLeftCorner(CornerTreatment cornerTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, cornerTreatment)) == null) {
                this.bottomLeftCorner = cornerTreatment;
                float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
                if (compatCornerTreatmentSize != -1.0f) {
                    setBottomLeftCornerSize(compatCornerTreatmentSize);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBottomLeftCornerSize(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f)) == null) {
                this.bottomLeftCornerSize = new AbsoluteCornerSize(f);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setBottomRightCorner(CornerTreatment cornerTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048590, this, cornerTreatment)) == null) {
                this.bottomRightCorner = cornerTreatment;
                float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
                if (compatCornerTreatmentSize != -1.0f) {
                    setBottomRightCornerSize(compatCornerTreatmentSize);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBottomRightCornerSize(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048591, this, f)) == null) {
                this.bottomRightCornerSize = new AbsoluteCornerSize(f);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setLeftEdge(EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, edgeTreatment)) == null) {
                this.leftEdge = edgeTreatment;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setRightEdge(EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, edgeTreatment)) == null) {
                this.rightEdge = edgeTreatment;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTopEdge(EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, edgeTreatment)) == null) {
                this.topEdge = edgeTreatment;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTopLeftCorner(CornerTreatment cornerTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048598, this, cornerTreatment)) == null) {
                this.topLeftCorner = cornerTreatment;
                float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
                if (compatCornerTreatmentSize != -1.0f) {
                    setTopLeftCornerSize(compatCornerTreatmentSize);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTopLeftCornerSize(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048599, this, f)) == null) {
                this.topLeftCornerSize = new AbsoluteCornerSize(f);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public Builder setTopRightCorner(CornerTreatment cornerTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048603, this, cornerTreatment)) == null) {
                this.topRightCorner = cornerTreatment;
                float compatCornerTreatmentSize = compatCornerTreatmentSize(cornerTreatment);
                if (compatCornerTreatmentSize != -1.0f) {
                    setTopRightCornerSize(compatCornerTreatmentSize);
                }
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTopRightCornerSize(float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048604, this, f)) == null) {
                this.topRightCornerSize = new AbsoluteCornerSize(f);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        public ShapeAppearanceModel build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new ShapeAppearanceModel(this, null);
            }
            return (ShapeAppearanceModel) invokeV.objValue;
        }

        public Builder setAllCornerSizes(CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cornerSize)) == null) {
                return setTopLeftCornerSize(cornerSize).setTopRightCornerSize(cornerSize).setBottomRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize);
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBottomLeftCornerSize(CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cornerSize)) == null) {
                this.bottomLeftCornerSize = cornerSize;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setBottomRightCornerSize(CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cornerSize)) == null) {
                this.bottomRightCornerSize = cornerSize;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTopLeftCornerSize(CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, cornerSize)) == null) {
                this.topLeftCornerSize = cornerSize;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setTopRightCornerSize(CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, cornerSize)) == null) {
                this.topRightCornerSize = cornerSize;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        public Builder setAllCorners(int i, float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setAllCorners(MaterialShapeUtils.createCornerTreatment(i)).setAllCornerSizes(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setBottomLeftCorner(int i, float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setBottomRightCorner(int i, float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setTopLeftCorner(int i, float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setTopRightCorner(int i, float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopRightCornerSize(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        public Builder setBottomLeftCorner(int i, CornerSize cornerSize) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, cornerSize)) == null) {
                return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(cornerSize);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setBottomRightCorner(int i, CornerSize cornerSize) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, cornerSize)) == null) {
                return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(cornerSize);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setTopLeftCorner(int i, CornerSize cornerSize) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048597, this, i, cornerSize)) == null) {
                return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(cornerSize);
            }
            return (Builder) invokeIL.objValue;
        }

        public Builder setTopRightCorner(int i, CornerSize cornerSize) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048602, this, i, cornerSize)) == null) {
                return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopRightCornerSize(cornerSize);
            }
            return (Builder) invokeIL.objValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1336854749, "Lcom/google/android/material/shape/ShapeAppearanceModel;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1336854749, "Lcom/google/android/material/shape/ShapeAppearanceModel;");
                return;
            }
        }
        PILL = new RelativeCornerSize(0.5f);
    }

    public static Builder builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new Builder();
        }
        return (Builder) invokeV.objValue;
    }

    public EdgeTreatment getBottomEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bottomEdge;
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    public CornerTreatment getBottomLeftCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bottomLeftCorner;
        }
        return (CornerTreatment) invokeV.objValue;
    }

    public CornerSize getBottomLeftCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bottomLeftCornerSize;
        }
        return (CornerSize) invokeV.objValue;
    }

    public CornerTreatment getBottomRightCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.bottomRightCorner;
        }
        return (CornerTreatment) invokeV.objValue;
    }

    public CornerSize getBottomRightCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.bottomRightCornerSize;
        }
        return (CornerSize) invokeV.objValue;
    }

    public EdgeTreatment getLeftEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.leftEdge;
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    public EdgeTreatment getRightEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.rightEdge;
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    public EdgeTreatment getTopEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.topEdge;
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    public CornerTreatment getTopLeftCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.topLeftCorner;
        }
        return (CornerTreatment) invokeV.objValue;
    }

    public CornerSize getTopLeftCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.topLeftCornerSize;
        }
        return (CornerSize) invokeV.objValue;
    }

    public CornerTreatment getTopRightCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.topRightCorner;
        }
        return (CornerTreatment) invokeV.objValue;
    }

    public CornerSize getTopRightCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.topRightCornerSize;
        }
        return (CornerSize) invokeV.objValue;
    }

    public Builder toBuilder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return new Builder(this);
        }
        return (Builder) invokeV.objValue;
    }

    public ShapeAppearanceModel() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.topLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomRightCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.bottomLeftCorner = MaterialShapeUtils.createDefaultCornerTreatment();
        this.topLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomRightCornerSize = new AbsoluteCornerSize(0.0f);
        this.bottomLeftCornerSize = new AbsoluteCornerSize(0.0f);
        this.topEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.rightEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.bottomEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
        this.leftEdge = MaterialShapeUtils.createDefaultEdgeTreatment();
    }

    public ShapeAppearanceModel(Builder builder) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder};
            interceptable.invokeUnInit(65538, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65538, newInitContext);
                return;
            }
        }
        this.topLeftCorner = builder.topLeftCorner;
        this.topRightCorner = builder.topRightCorner;
        this.bottomRightCorner = builder.bottomRightCorner;
        this.bottomLeftCorner = builder.bottomLeftCorner;
        this.topLeftCornerSize = builder.topLeftCornerSize;
        this.topRightCornerSize = builder.topRightCornerSize;
        this.bottomRightCornerSize = builder.bottomRightCornerSize;
        this.bottomLeftCornerSize = builder.bottomLeftCornerSize;
        this.topEdge = builder.topEdge;
        this.rightEdge = builder.rightEdge;
        this.bottomEdge = builder.bottomEdge;
        this.leftEdge = builder.leftEdge;
    }

    public boolean isRoundRect(RectF rectF) {
        InterceptResult invokeL;
        boolean z;
        boolean z2;
        boolean z3;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048588, this, rectF)) == null) {
            if (this.leftEdge.getClass().equals(EdgeTreatment.class) && this.rightEdge.getClass().equals(EdgeTreatment.class) && this.topEdge.getClass().equals(EdgeTreatment.class) && this.bottomEdge.getClass().equals(EdgeTreatment.class)) {
                z = true;
            } else {
                z = false;
            }
            float cornerSize = this.topLeftCornerSize.getCornerSize(rectF);
            if (this.topRightCornerSize.getCornerSize(rectF) == cornerSize && this.bottomLeftCornerSize.getCornerSize(rectF) == cornerSize && this.bottomRightCornerSize.getCornerSize(rectF) == cornerSize) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((this.topRightCorner instanceof RoundedCornerTreatment) && (this.topLeftCorner instanceof RoundedCornerTreatment) && (this.bottomRightCorner instanceof RoundedCornerTreatment) && (this.bottomLeftCorner instanceof RoundedCornerTreatment)) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (z && z2 && z3) {
                return true;
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public /* synthetic */ ShapeAppearanceModel(Builder builder, AnonymousClass1 anonymousClass1) {
        this(builder);
    }

    public static Builder builder(Context context, int i, int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, context, i, i2)) == null) {
            return builder(context, i, i2, 0);
        }
        return (Builder) invokeLII.objValue;
    }

    public static Builder builder(Context context, int i, int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, context, i, i2, i3)) == null) {
            return builder(context, i, i2, new AbsoluteCornerSize(i3));
        }
        return (Builder) invokeLIII.objValue;
    }

    public static Builder builder(Context context, int i, int i2, CornerSize cornerSize) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65543, null, new Object[]{context, Integer.valueOf(i), Integer.valueOf(i2), cornerSize})) == null) {
            if (i2 != 0) {
                ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(context, i);
                i = i2;
                context = contextThemeWrapper;
            }
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(i, R.styleable.ShapeAppearance);
            try {
                int i3 = obtainStyledAttributes.getInt(0, 0);
                int i4 = obtainStyledAttributes.getInt(3, i3);
                int i5 = obtainStyledAttributes.getInt(4, i3);
                int i6 = obtainStyledAttributes.getInt(2, i3);
                int i7 = obtainStyledAttributes.getInt(1, i3);
                CornerSize cornerSize2 = getCornerSize(obtainStyledAttributes, 5, cornerSize);
                CornerSize cornerSize3 = getCornerSize(obtainStyledAttributes, 8, cornerSize2);
                return new Builder().setTopLeftCorner(i4, cornerSize3).setTopRightCorner(i5, getCornerSize(obtainStyledAttributes, 9, cornerSize2)).setBottomRightCorner(i6, getCornerSize(obtainStyledAttributes, 7, cornerSize2)).setBottomLeftCorner(i7, getCornerSize(obtainStyledAttributes, 6, cornerSize2));
            } finally {
                obtainStyledAttributes.recycle();
            }
        }
        return (Builder) invokeCommon.objValue;
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65544, null, context, attributeSet, i, i2)) == null) {
            return builder(context, attributeSet, i, i2, 0);
        }
        return (Builder) invokeLLII.objValue;
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            return builder(context, attributeSet, i, i2, new AbsoluteCornerSize(i3));
        }
        return (Builder) invokeCommon.objValue;
    }

    public static Builder builder(Context context, AttributeSet attributeSet, int i, int i2, CornerSize cornerSize) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2), cornerSize})) == null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.MaterialShape, i, i2);
            int resourceId = obtainStyledAttributes.getResourceId(0, 0);
            int resourceId2 = obtainStyledAttributes.getResourceId(1, 0);
            obtainStyledAttributes.recycle();
            return builder(context, resourceId, resourceId2, cornerSize);
        }
        return (Builder) invokeCommon.objValue;
    }

    public static CornerSize getCornerSize(TypedArray typedArray, int i, CornerSize cornerSize) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(65547, null, typedArray, i, cornerSize)) == null) {
            TypedValue peekValue = typedArray.peekValue(i);
            if (peekValue == null) {
                return cornerSize;
            }
            int i2 = peekValue.type;
            if (i2 == 5) {
                return new AbsoluteCornerSize(TypedValue.complexToDimensionPixelSize(peekValue.data, typedArray.getResources().getDisplayMetrics()));
            }
            if (i2 == 6) {
                return new RelativeCornerSize(peekValue.getFraction(1.0f, 1.0f));
            }
            return cornerSize;
        }
        return (CornerSize) invokeLIL.objValue;
    }

    public ShapeAppearanceModel withCornerSize(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048590, this, f)) == null) {
            return toBuilder().setAllCornerSizes(f).build();
        }
        return (ShapeAppearanceModel) invokeF.objValue;
    }

    public ShapeAppearanceModel withCornerSize(CornerSize cornerSize) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cornerSize)) == null) {
            return toBuilder().setAllCornerSizes(cornerSize).build();
        }
        return (ShapeAppearanceModel) invokeL.objValue;
    }

    public ShapeAppearanceModel withTransformedCornerSizes(CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cornerSizeUnaryOperator)) == null) {
            return toBuilder().setTopLeftCornerSize(cornerSizeUnaryOperator.apply(getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeUnaryOperator.apply(getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeUnaryOperator.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeUnaryOperator.apply(getBottomRightCornerSize())).build();
        }
        return (ShapeAppearanceModel) invokeL.objValue;
    }
}
