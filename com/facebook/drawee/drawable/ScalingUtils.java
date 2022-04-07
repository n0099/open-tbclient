package com.facebook.drawee.drawable;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import javax.annotation.Nullable;
/* loaded from: classes4.dex */
public class ScalingUtils {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes4.dex */
    public static abstract class AbstractScaleType implements ScaleType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public AbstractScaleType() {
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

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)})) == null) {
                getTransformImpl(matrix, rect, i, i2, f, f2, rect.width() / i, rect.height() / i2);
                return matrix;
            }
            return (Matrix) invokeCommon.objValue;
        }

        public abstract void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4);
    }

    /* loaded from: classes4.dex */
    public interface ScaleType {
        public static final ScaleType FIT_XY = ScaleTypeFitXY.INSTANCE;
        public static final ScaleType FIT_START = ScaleTypeFitStart.INSTANCE;
        public static final ScaleType FIT_CENTER = ScaleTypeFitCenter.INSTANCE;
        public static final ScaleType FIT_END = ScaleTypeFitEnd.INSTANCE;
        public static final ScaleType CENTER = ScaleTypeCenter.INSTANCE;
        public static final ScaleType CENTER_INSIDE = ScaleTypeCenterInside.INSTANCE;
        public static final ScaleType CENTER_CROP = ScaleTypeCenterCrop.INSTANCE;
        public static final ScaleType FOCUS_CROP = ScaleTypeFocusCrop.INSTANCE;
        public static final ScaleType FIT_BOTTOM_START = ScaleTypeFitBottomStart.INSTANCE;

        Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2);
    }

    /* loaded from: classes4.dex */
    public static class ScaleTypeCenter extends AbstractScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1207690713, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1207690713, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenter;");
                    return;
                }
            }
            INSTANCE = new ScaleTypeCenter();
        }

        public ScaleTypeCenter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                matrix.setTranslate((int) (rect.left + ((rect.width() - i) * 0.5f) + 0.5f), (int) (rect.top + ((rect.height() - i2) * 0.5f) + 0.5f));
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "center" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScaleTypeCenterCrop extends AbstractScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-2026706057, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterCrop;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-2026706057, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterCrop;");
                    return;
                }
            }
            INSTANCE = new ScaleTypeCenterCrop();
        }

        public ScaleTypeCenterCrop() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float height;
            float f5;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                if (f4 > f3) {
                    f5 = rect.left + ((rect.width() - (i * f4)) * 0.5f);
                    height = rect.top;
                    f3 = f4;
                } else {
                    height = ((rect.height() - (i2 * f3)) * 0.5f) + rect.top;
                    f5 = rect.left;
                }
                matrix.setScale(f3, f3);
                matrix.postTranslate((int) (f5 + 0.5f), (int) (height + 0.5f));
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "center_crop" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScaleTypeCenterInside extends AbstractScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1125269365, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterInside;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1125269365, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeCenterInside;");
                    return;
                }
            }
            INSTANCE = new ScaleTypeCenterInside();
        }

        public ScaleTypeCenterInside() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                float min = Math.min(Math.min(f3, f4), 1.0f);
                float width = rect.left + ((rect.width() - (i * min)) * 0.5f);
                float height = rect.top + ((rect.height() - (i2 * min)) * 0.5f);
                matrix.setScale(min, min);
                matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "center_inside" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScaleTypeFitBottomStart extends AbstractScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1967441034, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitBottomStart;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1967441034, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitBottomStart;");
                    return;
                }
            }
            INSTANCE = new ScaleTypeFitBottomStart();
        }

        public ScaleTypeFitBottomStart() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                float min = Math.min(f3, f4);
                matrix.setScale(min, min);
                matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + (rect.height() - (i2 * min)) + 0.5f));
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "fit_bottom_start" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScaleTypeFitCenter extends AbstractScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1570358796, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitCenter;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1570358796, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitCenter;");
                    return;
                }
            }
            INSTANCE = new ScaleTypeFitCenter();
        }

        public ScaleTypeFitCenter() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                float min = Math.min(f3, f4);
                float width = rect.left + ((rect.width() - (i * min)) * 0.5f);
                float height = rect.top + ((rect.height() - (i2 * min)) * 0.5f);
                matrix.setScale(min, min);
                matrix.postTranslate((int) (width + 0.5f), (int) (height + 0.5f));
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "fit_center" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScaleTypeFitEnd extends AbstractScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1573486098, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitEnd;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1573486098, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitEnd;");
                    return;
                }
            }
            INSTANCE = new ScaleTypeFitEnd();
        }

        public ScaleTypeFitEnd() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                float min = Math.min(f3, f4);
                matrix.setScale(min, min);
                matrix.postTranslate((int) (rect.left + (rect.width() - (i * min)) + 0.5f), (int) (rect.top + (rect.height() - (i2 * min)) + 0.5f));
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "fit_end" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScaleTypeFitStart extends AbstractScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(697968363, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitStart;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(697968363, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitStart;");
                    return;
                }
            }
            INSTANCE = new ScaleTypeFitStart();
        }

        public ScaleTypeFitStart() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                float min = Math.min(f3, f4);
                matrix.setScale(min, min);
                matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "fit_start" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScaleTypeFitXY extends AbstractScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1196150808, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitXY;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1196150808, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFitXY;");
                    return;
                }
            }
            INSTANCE = new ScaleTypeFitXY();
        }

        public ScaleTypeFitXY() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                matrix.setScale(f3, f4);
                matrix.postTranslate((int) (rect.left + 0.5f), (int) (rect.top + 0.5f));
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "fit_xy" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public static class ScaleTypeFocusCrop extends AbstractScaleType {
        public static /* synthetic */ Interceptable $ic;
        public static final ScaleType INSTANCE;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1601597838, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFocusCrop;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-1601597838, "Lcom/facebook/drawee/drawable/ScalingUtils$ScaleTypeFocusCrop;");
                    return;
                }
            }
            INSTANCE = new ScaleTypeFocusCrop();
        }

        public ScaleTypeFocusCrop() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                }
            }
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.AbstractScaleType
        public void getTransformImpl(Matrix matrix, Rect rect, int i, int i2, float f, float f2, float f3, float f4) {
            float f5;
            float max;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4)}) == null) {
                if (f4 > f3) {
                    float f6 = i * f4;
                    f5 = rect.left + Math.max(Math.min((rect.width() * 0.5f) - (f * f6), 0.0f), rect.width() - f6);
                    max = rect.top;
                    f3 = f4;
                } else {
                    f5 = rect.left;
                    float f7 = i2 * f3;
                    max = Math.max(Math.min((rect.height() * 0.5f) - (f2 * f7), 0.0f), rect.height() - f7) + rect.top;
                }
                matrix.setScale(f3, f3);
                matrix.postTranslate((int) (f5 + 0.5f), (int) (max + 0.5f));
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? "focus_crop" : (String) invokeV.objValue;
        }
    }

    /* loaded from: classes4.dex */
    public interface StatefulScaleType {
        Object getState();
    }

    public ScalingUtils() {
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

    @Nullable
    public static ScaleTypeDrawable getActiveScaleTypeDrawable(@Nullable Drawable drawable) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65537, null, drawable)) == null) {
            if (drawable == null) {
                return null;
            }
            if (drawable instanceof ScaleTypeDrawable) {
                return (ScaleTypeDrawable) drawable;
            }
            if (drawable instanceof DrawableParent) {
                return getActiveScaleTypeDrawable(((DrawableParent) drawable).getDrawable());
            }
            if (drawable instanceof ArrayDrawable) {
                ArrayDrawable arrayDrawable = (ArrayDrawable) drawable;
                int numberOfLayers = arrayDrawable.getNumberOfLayers();
                for (int i = 0; i < numberOfLayers; i++) {
                    ScaleTypeDrawable activeScaleTypeDrawable = getActiveScaleTypeDrawable(arrayDrawable.getDrawable(i));
                    if (activeScaleTypeDrawable != null) {
                        return activeScaleTypeDrawable;
                    }
                }
            }
            return null;
        }
        return (ScaleTypeDrawable) invokeL.objValue;
    }

    /* loaded from: classes4.dex */
    public static class InterpolatingScaleType implements ScaleType, StatefulScaleType {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        @Nullable
        public final Rect mBoundsFrom;
        @Nullable
        public final Rect mBoundsTo;
        @Nullable
        public final PointF mFocusPointFrom;
        @Nullable
        public final PointF mFocusPointTo;
        public float mInterpolatingValue;
        public final float[] mMatrixValuesFrom;
        public final float[] mMatrixValuesInterpolated;
        public final float[] mMatrixValuesTo;
        public final ScaleType mScaleTypeFrom;
        public final ScaleType mScaleTypeTo;

        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, @Nullable Rect rect, @Nullable Rect rect2, @Nullable PointF pointF, @Nullable PointF pointF2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scaleType, scaleType2, rect, rect2, pointF, pointF2};
                interceptable.invokeUnInit(65538, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65538, newInitContext);
                    return;
                }
            }
            this.mMatrixValuesFrom = new float[9];
            this.mMatrixValuesTo = new float[9];
            this.mMatrixValuesInterpolated = new float[9];
            this.mScaleTypeFrom = scaleType;
            this.mScaleTypeTo = scaleType2;
            this.mBoundsFrom = rect;
            this.mBoundsTo = rect2;
            this.mFocusPointFrom = pointF;
            this.mFocusPointTo = pointF2;
        }

        @Nullable
        public Rect getBoundsFrom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? this.mBoundsFrom : (Rect) invokeV.objValue;
        }

        @Nullable
        public Rect getBoundsTo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? this.mBoundsTo : (Rect) invokeV.objValue;
        }

        @Nullable
        public PointF getFocusPointFrom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? this.mFocusPointFrom : (PointF) invokeV.objValue;
        }

        @Nullable
        public PointF getFocusPointTo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.mFocusPointTo : (PointF) invokeV.objValue;
        }

        public ScaleType getScaleTypeFrom() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? this.mScaleTypeFrom : (ScaleType) invokeV.objValue;
        }

        public ScaleType getScaleTypeTo() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) ? this.mScaleTypeTo : (ScaleType) invokeV.objValue;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.StatefulScaleType
        public Object getState() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) ? Float.valueOf(this.mInterpolatingValue) : invokeV.objValue;
        }

        @Override // com.facebook.drawee.drawable.ScalingUtils.ScaleType
        public Matrix getTransform(Matrix matrix, Rect rect, int i, int i2, float f, float f2) {
            InterceptResult invokeCommon;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048583, this, new Object[]{matrix, rect, Integer.valueOf(i), Integer.valueOf(i2), Float.valueOf(f), Float.valueOf(f2)})) == null) {
                Rect rect2 = this.mBoundsFrom;
                Rect rect3 = rect2 != null ? rect2 : rect;
                Rect rect4 = this.mBoundsTo;
                Rect rect5 = rect4 != null ? rect4 : rect;
                ScaleType scaleType = this.mScaleTypeFrom;
                PointF pointF = this.mFocusPointFrom;
                float f3 = pointF == null ? f : pointF.x;
                PointF pointF2 = this.mFocusPointFrom;
                scaleType.getTransform(matrix, rect3, i, i2, f3, pointF2 == null ? f2 : pointF2.y);
                matrix.getValues(this.mMatrixValuesFrom);
                ScaleType scaleType2 = this.mScaleTypeTo;
                PointF pointF3 = this.mFocusPointTo;
                float f4 = pointF3 == null ? f : pointF3.x;
                PointF pointF4 = this.mFocusPointTo;
                scaleType2.getTransform(matrix, rect5, i, i2, f4, pointF4 == null ? f2 : pointF4.y);
                matrix.getValues(this.mMatrixValuesTo);
                for (int i3 = 0; i3 < 9; i3++) {
                    float[] fArr = this.mMatrixValuesInterpolated;
                    float f5 = this.mMatrixValuesFrom[i3];
                    float f6 = this.mInterpolatingValue;
                    fArr[i3] = (f5 * (1.0f - f6)) + (this.mMatrixValuesTo[i3] * f6);
                }
                matrix.setValues(this.mMatrixValuesInterpolated);
                return matrix;
            }
            return (Matrix) invokeCommon.objValue;
        }

        public float getValue() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) ? this.mInterpolatingValue : invokeV.floatValue;
        }

        public void setValue(float f) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeF(1048585, this, f) == null) {
                this.mInterpolatingValue = f;
            }
        }

        public String toString() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) ? String.format("InterpolatingScaleType(%s (%s) -> %s (%s))", String.valueOf(this.mScaleTypeFrom), String.valueOf(this.mFocusPointFrom), String.valueOf(this.mScaleTypeTo), String.valueOf(this.mFocusPointTo)) : (String) invokeV.objValue;
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2, @Nullable Rect rect, @Nullable Rect rect2) {
            this(scaleType, scaleType2, rect, rect2, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scaleType, scaleType2, rect, rect2};
                interceptable.invokeUnInit(65537, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((ScaleType) objArr2[0], (ScaleType) objArr2[1], (Rect) objArr2[2], (Rect) objArr2[3], (PointF) objArr2[4], (PointF) objArr2[5]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
        }

        /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
        public InterpolatingScaleType(ScaleType scaleType, ScaleType scaleType2) {
            this(scaleType, scaleType2, null, null);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {scaleType, scaleType2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    this((ScaleType) objArr2[0], (ScaleType) objArr2[1], (Rect) objArr2[2], (Rect) objArr2[3]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }
}
