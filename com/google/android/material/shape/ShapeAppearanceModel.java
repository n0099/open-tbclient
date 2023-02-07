package com.google.android.material.shape;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.annotation.AttrRes;
import androidx.annotation.Dimension;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.annotation.StyleRes;
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
/* loaded from: classes8.dex */
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
    /* loaded from: classes8.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    /* loaded from: classes8.dex */
    public interface CornerSizeUnaryOperator {
        @NonNull
        CornerSize apply(@NonNull CornerSize cornerSize);
    }

    /* loaded from: classes8.dex */
    public static final class Builder {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @NonNull
        public EdgeTreatment bottomEdge;
        @NonNull
        public CornerTreatment bottomLeftCorner;
        @NonNull
        public CornerSize bottomLeftCornerSize;
        @NonNull
        public CornerTreatment bottomRightCorner;
        @NonNull
        public CornerSize bottomRightCornerSize;
        @NonNull
        public EdgeTreatment leftEdge;
        @NonNull
        public EdgeTreatment rightEdge;
        @NonNull
        public EdgeTreatment topEdge;
        @NonNull
        public CornerTreatment topLeftCorner;
        @NonNull
        public CornerSize topLeftCornerSize;
        @NonNull
        public CornerTreatment topRightCorner;
        @NonNull
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

        public Builder(@NonNull ShapeAppearanceModel shapeAppearanceModel) {
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

        @NonNull
        public Builder setAllCornerSizes(@Dimension float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f)) == null) {
                return setTopLeftCornerSize(f).setTopRightCornerSize(f).setBottomRightCornerSize(f).setBottomLeftCornerSize(f);
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setAllCorners(@NonNull CornerTreatment cornerTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, cornerTreatment)) == null) {
                return setTopLeftCorner(cornerTreatment).setTopRightCorner(cornerTreatment).setBottomRightCorner(cornerTreatment).setBottomLeftCorner(cornerTreatment);
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setAllEdges(@NonNull EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, edgeTreatment)) == null) {
                return setLeftEdge(edgeTreatment).setTopEdge(edgeTreatment).setRightEdge(edgeTreatment).setBottomEdge(edgeTreatment);
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setBottomEdge(@NonNull EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, edgeTreatment)) == null) {
                this.bottomEdge = edgeTreatment;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setBottomLeftCorner(@NonNull CornerTreatment cornerTreatment) {
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

        @NonNull
        public Builder setBottomLeftCornerSize(@Dimension float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048586, this, f)) == null) {
                this.bottomLeftCornerSize = new AbsoluteCornerSize(f);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setBottomRightCorner(@NonNull CornerTreatment cornerTreatment) {
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

        @NonNull
        public Builder setBottomRightCornerSize(@Dimension float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048591, this, f)) == null) {
                this.bottomRightCornerSize = new AbsoluteCornerSize(f);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setLeftEdge(@NonNull EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048593, this, edgeTreatment)) == null) {
                this.leftEdge = edgeTreatment;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setRightEdge(@NonNull EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048594, this, edgeTreatment)) == null) {
                this.rightEdge = edgeTreatment;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setTopEdge(@NonNull EdgeTreatment edgeTreatment) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048595, this, edgeTreatment)) == null) {
                this.topEdge = edgeTreatment;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setTopLeftCorner(@NonNull CornerTreatment cornerTreatment) {
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

        @NonNull
        public Builder setTopLeftCornerSize(@Dimension float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048599, this, f)) == null) {
                this.topLeftCornerSize = new AbsoluteCornerSize(f);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public Builder setTopRightCorner(@NonNull CornerTreatment cornerTreatment) {
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

        @NonNull
        public Builder setTopRightCornerSize(@Dimension float f) {
            InterceptResult invokeF;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeF = interceptable.invokeF(1048604, this, f)) == null) {
                this.topRightCornerSize = new AbsoluteCornerSize(f);
                return this;
            }
            return (Builder) invokeF.objValue;
        }

        @NonNull
        public ShapeAppearanceModel build() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return new ShapeAppearanceModel(this, null);
            }
            return (ShapeAppearanceModel) invokeV.objValue;
        }

        @NonNull
        public Builder setAllCornerSizes(@NonNull CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, cornerSize)) == null) {
                return setTopLeftCornerSize(cornerSize).setTopRightCornerSize(cornerSize).setBottomRightCornerSize(cornerSize).setBottomLeftCornerSize(cornerSize);
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setBottomLeftCornerSize(@NonNull CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, cornerSize)) == null) {
                this.bottomLeftCornerSize = cornerSize;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setBottomRightCornerSize(@NonNull CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cornerSize)) == null) {
                this.bottomRightCornerSize = cornerSize;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setTopLeftCornerSize(@NonNull CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, cornerSize)) == null) {
                this.topLeftCornerSize = cornerSize;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setTopRightCornerSize(@NonNull CornerSize cornerSize) {
            InterceptResult invokeL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048605, this, cornerSize)) == null) {
                this.topRightCornerSize = cornerSize;
                return this;
            }
            return (Builder) invokeL.objValue;
        }

        @NonNull
        public Builder setAllCorners(int i, @Dimension float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048579, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setAllCorners(MaterialShapeUtils.createCornerTreatment(i)).setAllCornerSizes(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        @NonNull
        public Builder setBottomLeftCorner(int i, @Dimension float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        @NonNull
        public Builder setBottomRightCorner(int i, @Dimension float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048588, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        @NonNull
        public Builder setTopLeftCorner(int i, @Dimension float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048596, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        @NonNull
        public Builder setTopRightCorner(int i, @Dimension float f) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048601, this, new Object[]{Integer.valueOf(i), Float.valueOf(f)})) == null) {
                return setTopRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopRightCornerSize(f);
            }
            return (Builder) invokeCommon.objValue;
        }

        @NonNull
        public Builder setBottomLeftCorner(int i, @NonNull CornerSize cornerSize) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, cornerSize)) == null) {
                return setBottomLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomLeftCornerSize(cornerSize);
            }
            return (Builder) invokeIL.objValue;
        }

        @NonNull
        public Builder setBottomRightCorner(int i, @NonNull CornerSize cornerSize) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048589, this, i, cornerSize)) == null) {
                return setBottomRightCorner(MaterialShapeUtils.createCornerTreatment(i)).setBottomRightCornerSize(cornerSize);
            }
            return (Builder) invokeIL.objValue;
        }

        @NonNull
        public Builder setTopLeftCorner(int i, @NonNull CornerSize cornerSize) {
            InterceptResult invokeIL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeIL = interceptable.invokeIL(1048597, this, i, cornerSize)) == null) {
                return setTopLeftCorner(MaterialShapeUtils.createCornerTreatment(i)).setTopLeftCornerSize(cornerSize);
            }
            return (Builder) invokeIL.objValue;
        }

        @NonNull
        public Builder setTopRightCorner(int i, @NonNull CornerSize cornerSize) {
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

    @NonNull
    public static Builder builder() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TRACKBALL, null)) == null) {
            return new Builder();
        }
        return (Builder) invokeV.objValue;
    }

    @NonNull
    public EdgeTreatment getBottomEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.bottomEdge;
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    @NonNull
    public CornerTreatment getBottomLeftCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.bottomLeftCorner;
        }
        return (CornerTreatment) invokeV.objValue;
    }

    @NonNull
    public CornerSize getBottomLeftCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.bottomLeftCornerSize;
        }
        return (CornerSize) invokeV.objValue;
    }

    @NonNull
    public CornerTreatment getBottomRightCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.bottomRightCorner;
        }
        return (CornerTreatment) invokeV.objValue;
    }

    @NonNull
    public CornerSize getBottomRightCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.bottomRightCornerSize;
        }
        return (CornerSize) invokeV.objValue;
    }

    @NonNull
    public EdgeTreatment getLeftEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.leftEdge;
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    @NonNull
    public EdgeTreatment getRightEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.rightEdge;
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    @NonNull
    public EdgeTreatment getTopEdge() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.topEdge;
        }
        return (EdgeTreatment) invokeV.objValue;
    }

    @NonNull
    public CornerTreatment getTopLeftCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.topLeftCorner;
        }
        return (CornerTreatment) invokeV.objValue;
    }

    @NonNull
    public CornerSize getTopLeftCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            return this.topLeftCornerSize;
        }
        return (CornerSize) invokeV.objValue;
    }

    @NonNull
    public CornerTreatment getTopRightCorner() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return this.topRightCorner;
        }
        return (CornerTreatment) invokeV.objValue;
    }

    @NonNull
    public CornerSize getTopRightCornerSize() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.topRightCornerSize;
        }
        return (CornerSize) invokeV.objValue;
    }

    @NonNull
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

    public ShapeAppearanceModel(@NonNull Builder builder) {
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

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public boolean isRoundRect(@NonNull RectF rectF) {
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

    @NonNull
    public static Builder builder(Context context, @StyleRes int i, @StyleRes int i2) {
        InterceptResult invokeLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLII = interceptable.invokeLII(65541, null, context, i, i2)) == null) {
            return builder(context, i, i2, 0);
        }
        return (Builder) invokeLII.objValue;
    }

    @NonNull
    public static Builder builder(Context context, @StyleRes int i, @StyleRes int i2, int i3) {
        InterceptResult invokeLIII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIII = interceptable.invokeLIII(65542, null, context, i, i2, i3)) == null) {
            return builder(context, i, i2, new AbsoluteCornerSize(i3));
        }
        return (Builder) invokeLIII.objValue;
    }

    @NonNull
    public static Builder builder(Context context, @StyleRes int i, @StyleRes int i2, @NonNull CornerSize cornerSize) {
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

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2) {
        InterceptResult invokeLLII;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLII = interceptable.invokeLLII(65544, null, context, attributeSet, i, i2)) == null) {
            return builder(context, attributeSet, i, i2, 0);
        }
        return (Builder) invokeLLII.objValue;
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2, int i3) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65545, null, new Object[]{context, attributeSet, Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3)})) == null) {
            return builder(context, attributeSet, i, i2, new AbsoluteCornerSize(i3));
        }
        return (Builder) invokeCommon.objValue;
    }

    @NonNull
    public static Builder builder(@NonNull Context context, AttributeSet attributeSet, @AttrRes int i, @StyleRes int i2, @NonNull CornerSize cornerSize) {
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

    @NonNull
    public static CornerSize getCornerSize(TypedArray typedArray, int i, @NonNull CornerSize cornerSize) {
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

    @NonNull
    public ShapeAppearanceModel withCornerSize(float f) {
        InterceptResult invokeF;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeF = interceptable.invokeF(1048590, this, f)) == null) {
            return toBuilder().setAllCornerSizes(f).build();
        }
        return (ShapeAppearanceModel) invokeF.objValue;
    }

    @NonNull
    public ShapeAppearanceModel withCornerSize(@NonNull CornerSize cornerSize) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, cornerSize)) == null) {
            return toBuilder().setAllCornerSizes(cornerSize).build();
        }
        return (ShapeAppearanceModel) invokeL.objValue;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public ShapeAppearanceModel withTransformedCornerSizes(@NonNull CornerSizeUnaryOperator cornerSizeUnaryOperator) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048592, this, cornerSizeUnaryOperator)) == null) {
            return toBuilder().setTopLeftCornerSize(cornerSizeUnaryOperator.apply(getTopLeftCornerSize())).setTopRightCornerSize(cornerSizeUnaryOperator.apply(getTopRightCornerSize())).setBottomLeftCornerSize(cornerSizeUnaryOperator.apply(getBottomLeftCornerSize())).setBottomRightCornerSize(cornerSizeUnaryOperator.apply(getBottomRightCornerSize())).build();
        }
        return (ShapeAppearanceModel) invokeL.objValue;
    }
}
